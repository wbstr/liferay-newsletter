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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.PortalUtil;
import com.wcs.newsletter.dto.CategoryListElem;
import com.wcs.newsletter.dto.CategoryListElemDataModel;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.util.AppMessageBundle;
import com.wcs.newsletter.util.LiferayUtil;
import com.wcs.newsletter.util.WcsNewsletterConst;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class CategoryListController extends AbstractListController<CategoryListElem, CategoryListElemDataModel> {

    private List<SubscriptionUserElem> userList;
    private SelectItem[] localeOptions;
    private boolean isListView;

    public boolean isIsListView() {
        return isListView;
    }

    public void setIsListView(boolean isListView) {
        this.isListView = isListView;
    }

    @Override
    protected void init() {
        initModel();
        initLocaleOptions();
    }

    public void initModel() {
        if (model == null) {
            List<CategoryListElem> elems = new ArrayList<CategoryListElem>();
            try {
                elems = getCategoryListElems();
            } catch (SystemException ex) {
                logger.error(ex);
                addErrorMessage(ex);
            }

            model = new CategoryListElemDataModel(elems);
            isListView = true;
        }
    }

    private List<CategoryListElem> getCategoryListElems() throws SystemException {
        List<CategoryListElem> categoryListElems = new ArrayList<CategoryListElem>();
        List<Category> categories = CategoryLocalServiceUtil.getCategories();

        for (Category category : categories) {
            long id = category.getCategoryId();
            String localeStr = category.getLocale();
            Locale locale = null;
			try {
				locale = PortalUtil.getSiteDefaultLocale(0);
			} catch (PortalException e) {
//				e.printStackTrace();
				logger.error(e);
			} 
            String name = category.getName(locale);

            List<SubscriptionCategory> subscribedList = SubscriptionCategoryLocalServiceUtil.findByCategoryId(id);
            long subscribed = subscribedList != null ? subscribedList.size() : 0;



            String adminLocaleStr = LiferayUtil.getLiferayFullLangCode();
            Locale adminLocale = LiferayUtil.getLocale(adminLocaleStr);

//            String localizedLocaleStr = locale != null ? locale.getDisplayLanguage(adminLocale) : null;
            String localizedLocaleStr = locale != null ? locale.getDisplayName(adminLocale) : null;

//            logger.info("localeStr: {0}", new Object[]{localeStr});
//            logger.info("locale: {0}", new Object[]{locale.getDisplayName()});
//            logger.info("adminLocaleStr: {0}", new Object[]{adminLocaleStr});
//            logger.info("adminLocale: {0}", new Object[]{adminLocale});
//            logger.info("localizedLocaleStr: {0}", new Object[]{localizedLocaleStr});
//            logger.info(" ", new Object[]{});

            CategoryListElem categoryListElem = new CategoryListElem(id, name, localeStr, localizedLocaleStr, subscribed);
            categoryListElems.add(categoryListElem);
        }

        return categoryListElems;
    }

    public String getStatForSubs(String stat) {
        return stat.equals("1") ? AppMessageBundle.getString("admin_categories_category_confirmed") : AppMessageBundle.getString("admin_categories_category_pending");
    }

    @Override
    public String edit(CategoryListElem elem) {
        return getNavigationController().navigateToCategoryEdit(elem.getId());
    }

    @Override
    public String create() {
        return getNavigationController().navigateToCategoryEdit(null);
    }

    @Override
    public void delete(CategoryListElem elem) throws Exception {
        Long categoryId = elem.getId();
        CategoryLocalServiceUtil.deleteCategory(categoryId);

        //TODO PS: delete subscriptioncategories
    }

    public boolean canDelete() {
        return selectedElems.length > 0;
    }

    public List<SubscriptionUserElem> getUserList() {
        return userList;
    }

    public void setUserList(List<SubscriptionUserElem> userList) {
        this.userList = userList;
    }

    public void generateUserList(CategoryListElem category) {
        try {
            userList = new ArrayList<SubscriptionUserElem>();
            List<SubscriptionCategory> userListTemp = SubscriptionCategoryLocalServiceUtil.findByCategoryId(category.getId());
            for (SubscriptionCategory sC : userListTemp) {
                SubscriptionUserElem sue = new SubscriptionUserElem();
                sue.subscription = sC.getSubscription();
                sue.subscriptionCategory = sC;
                userList.add(sue);
            }
        } catch (PortalException ex) {
            Logger.getLogger(CategoryListController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(CategoryListController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class SubscriptionUserElem {

        private Subscription subscription;
        private SubscriptionCategory subscriptionCategory;

        public Subscription getSubscription() {
            return subscription;
        }

        public void setSubscription(Subscription subscription) {
            this.subscription = subscription;
        }

        public SubscriptionCategory getSubscriptionCategory() {
            return subscriptionCategory;
        }

        public void setSubscriptionCategory(SubscriptionCategory subscriptionCategory) {
            this.subscriptionCategory = subscriptionCategory;
        }
    }

    public void initLocaleOptions() {
        //logger.info("initLocaleOptions", new Object[]{});

        Map<String, String> localeMap = new LinkedHashMap<String, String>();
        List<CategoryListElem> elems = (List<CategoryListElem>) getModel().getWrappedData();
        for (CategoryListElem categoryListElem : elems) {
            String localeStr = categoryListElem.getLocaleStr();
            String localizedLocaleStr = categoryListElem.getLocalizedLocaleStr();

            localeMap.put(localeStr, localizedLocaleStr);
        }

        SelectItem[] options = new SelectItem[localeMap.size() + 1];

        options[0] = new SelectItem("", "");
        int i = 1;
        for (Map.Entry<String, String> entry : localeMap.entrySet()) {
            String localeStr = entry.getKey();
            String localizedLocaleStr = entry.getValue();

            options[i] = new SelectItem(localeStr, localizedLocaleStr);
            i++;
        }

        setLocaleOptions(options);
    }

    public SelectItem[] getLocaleOptions() {
        return localeOptions;
    }

    public void setLocaleOptions(SelectItem[] localeOptions) {
        this.localeOptions = localeOptions;
    }

    public void resetController() {
        model = null;
    }

    @Override
    public void delete() {
        super.delete();
        if (selectedElems == null) {
            logger.info("no selectedElems");
            return;
        }

        Object[] deletedCategoryList = selectedElems;
        for (int i = 0; i < deletedCategoryList.length; i++) {
            try {
                CategoryListElem deletedCategory = (CategoryListElem) deletedCategoryList[i];

                List<SubscriptionCategory> sCList = SubscriptionCategoryLocalServiceUtil.findByCategoryId(deletedCategory.getId());
                for (SubscriptionCategory sC : sCList) {
                    SubscriptionCategoryLocalServiceUtil.deleteSubscriptionCategory(sC);
                }
            } catch (SystemException ex) {
                Logger.getLogger(CategoryListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
