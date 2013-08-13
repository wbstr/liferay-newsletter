package com.wcs.newsletter.controller;

/*
 * #%L
 * Webstar Newsletter
 * %%
 * Copyright (C) 2013 Webstar Csoport Kft.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.liferay.portal.kernel.exception.SystemException;
import com.wcs.newsletter.dto.SubscriptionKeySet;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.model.impl.SubscriptionCategoryImpl;
import com.wcs.newsletter.model.impl.SubscriptionImpl;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionLocalServiceUtil;
import com.wcs.newsletter.util.SubscriptionKeyUtil;
import com.wcs.newsletter.util.WcsNewsletterConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.DualListModel;

@ManagedBean
@ViewScoped
public class SubscriptionEditController extends AbstractEditController<Subscription, Long> {

//    private static final String CATEGORY_CONFIRMED = "admin_categories_category_confirmed";
//    private static final String CATEGORY_PENDING = "admin_categories_category_pending";
    private DualListModel<Category> categoriesModel;
    private HashMap<Long, SubscriptionCategory> usersCategoriesListForConfirmCheck;

    public HashMap<Long, SubscriptionCategory> getUsersCategoriesListForConfirmCheck() {
        return usersCategoriesListForConfirmCheck;
    }

    public void setUsersCategoriesListForConfirmCheck(HashMap<Long, SubscriptionCategory> usersCategoriesListForConfirmCheck) {
        this.usersCategoriesListForConfirmCheck = usersCategoriesListForConfirmCheck;
    }

    public boolean getCategoryConfirmed(long catId) {
        if (usersCategoriesListForConfirmCheck.keySet().contains(catId)) {
            if (usersCategoriesListForConfirmCheck.get(catId).isConfirmed()) {
                return true;// AppMessageBundle.getString(CATEGORY_CONFIRMED);
            }
            return false;//AppMessageBundle.getString(CATEGORY_PENDING);
        }
        return false;
    }

    @Override
    public Subscription initElem() throws Exception {
        return SubscriptionLocalServiceUtil.getSubscription((Long) getId());
    }

    @Override
    public Subscription initNewElem() {
        elem = new SubscriptionImpl();
        return elem;
    }

    @Override
    public void initController() {
        super.initController();
        initCategoriesModel();
    }

    public void resetController() {
        elem = null;
        categoriesModel = null;
    }

    public void initCategoriesModel() {
        if (categoriesModel == null) {
            categoriesModel = new DualListModel<Category>();

            List<Category> source = new ArrayList<Category>();
            List<Category> target = new ArrayList<Category>();

            try {
                usersCategoriesListForConfirmCheck = new HashMap<Long, SubscriptionCategory>();
                List<Category> allCategories = CategoryLocalServiceUtil.getCategories();
                List<Category> userCategories = new ArrayList<Category>();
                List<SubscriptionCategory> oldCats = SubscriptionCategoryLocalServiceUtil.findBySubscriptionId(getSubscriptionId());
                for (SubscriptionCategory subscriptionCategory : oldCats) {
                    usersCategoriesListForConfirmCheck.put(subscriptionCategory.getCategoryId(), subscriptionCategory);
                    userCategories.add(CategoryLocalServiceUtil.getCategory(subscriptionCategory.getCategoryId()));
                }

                source.addAll(allCategories);
                source.removeAll(userCategories);
                target.addAll(userCategories);
            } catch (Exception e) {
                logger.error(e);
                addErrorMessage(e);
            }

            categoriesModel.setSource(source);
            categoriesModel.setTarget(target);
        }
    }

    public DualListModel<Category> getCategoriesModel() {
        return categoriesModel;
    }

    public void setCategoriesModel(DualListModel<Category> categoriesModel) {
        this.categoriesModel = categoriesModel;
    }

    @Override
    protected Subscription persist() throws SystemException {
        throw new UnsupportedOperationException();
    }

    protected Long getSubscriptionId() {
        return getElem() != null ? getElem().getSubscriptionId() : null;
    }

    protected String getSubscriptionEmail() {
        return getElem() != null ? getElem().getEmailString() : null;
    }

    @Override
    protected Subscription update() throws Exception {
        List<Category> oldCategories = new ArrayList<Category>();

        List<Category> categoriesToDelete = new ArrayList<Category>();
        List<Category> categoriesToCreate = new ArrayList<Category>();

        List<Category> selectedCategories = getCategoriesModel().getTarget();

        List<SubscriptionCategory> oldSubscriptionCategories = SubscriptionCategoryLocalServiceUtil.findBySubscriptionId(getSubscriptionId());
        for (SubscriptionCategory oldSubscriptionCategory : oldSubscriptionCategories) {
            Category oldCategory = oldSubscriptionCategory.getCategory();

            oldCategories.add(oldCategory);
        }

        for (Category category : oldCategories) {
            if (!selectedCategories.contains(category)) {
                categoriesToDelete.add(category);
            }
        }

        for (Category category : selectedCategories) {
            if (!oldCategories.contains(category)) {
                categoriesToCreate.add(category);
            }
        }

        //logger.info("oldCategories: {0}", new Object[]{oldCategories});
        //logger.info("categoriesToDelete: {0}", new Object[]{categoriesToDelete});
        //logger.info("categoriesToCreate: {0}", new Object[]{categoriesToCreate});

        for (SubscriptionCategory oldSubscriptionCategory : oldSubscriptionCategories) {
            Category oldCategory = oldSubscriptionCategory.getCategory();

            if (categoriesToDelete.contains(oldCategory)) {
                SubscriptionCategoryLocalServiceUtil.deleteSubscriptionCategory(oldSubscriptionCategory);
            }
        }

        for (Category category : categoriesToCreate) {
            SubscriptionCategory subscriptionCategory = new SubscriptionCategoryImpl();
            subscriptionCategory.setSubscriptionId(getSubscriptionId());
            subscriptionCategory.setCategoryId(category.getCategoryId());

            String email = getSubscriptionEmail();
            String catId = String.valueOf(category.getCategoryId());

            SubscriptionKeySet subscriptionKeySet = SubscriptionKeyUtil.generateKeySet(catId, email);
            subscriptionCategory.setCancellationKey(subscriptionKeySet.getCancelationKey());

            subscriptionCategory.setStatus(WcsNewsletterConst.SubscriptionCategory.CONFIRMED);
            SubscriptionCategoryLocalServiceUtil.addSubscriptionCategory(subscriptionCategory);
        }
        categoriesModel = null;
        return getElem();
    }
}
