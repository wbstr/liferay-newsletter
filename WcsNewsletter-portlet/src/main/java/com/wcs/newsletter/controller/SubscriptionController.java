/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.wcs.newsletter.dto.SubscriptionKeySet;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.model.impl.SubscriptionCategoryImpl;
import com.wcs.newsletter.model.impl.SubscriptionImpl;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionLocalServiceUtil;
import com.wcs.newsletter.util.BundleKeysConst;
import com.wcs.newsletter.util.LiferayUtil;
import com.wcs.newsletter.util.SubscriberEmailSender;
import com.wcs.newsletter.util.SubscriptionKeyUtil;
import com.wcs.newsletter.util.WcsNewsletterConst;
import com.wcs.tool.ListUtil;
import com.wcs.tool.StringUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author csaba
 */
@ManagedBean
@ViewScoped
public class SubscriptionController extends AbstractController {

    private String email;
    private List<Category> categoryList;
    private List<String> selectedCategories;
    private User activeUser;

    public User getActiveUser() {
        if (activeUser == null) {
            activeUser = LiferayUtil.getActiveUser();
        }
        
        return activeUser;
    }

    private boolean isLoggedIn() {
        return getActiveUser() != null;
    }
    
    public List<String> getSelectedCategories() {
        if (selectedCategories == null) {
            selectedCategories = new ArrayList<String>();        
        }
        
        return selectedCategories;
    }

    public void setSelectedCategories(List<String> selectedCategories) {
        this.selectedCategories = selectedCategories;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (isLoggedIn()) {
            email = getActiveUser().getEmailAddress();
        }
        
        this.email = email;
    }    
    
    public List<Category> getCategoryList() {
        if (categoryList == null) {
            try {
                categoryList = CategoryLocalServiceUtil.findByLocale("" + getThemeDisplay().getLocale());
            } catch (SystemException ex) {
                logger.error(ex);
            }
        }
        
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Category getDefaultCategoryByLocale() {
        List<Category> categoryList = getCategoryList(); 
        if (categoryList != null && categoryList.size() == 1) {
            return categoryList.get(0);
        }
        
        return null;
    }

    public String getDefaultCategoryIdByLocale() {
        Category category = getDefaultCategoryByLocale();
        Long categoryId = category != null ? category.getCategoryId() : null;
        
        String categoryIdStr = StringUtil.toString(categoryId);
        
        return categoryIdStr;
    }    
    
    public boolean isHasCategoryByLocale() {
        return ListUtil.isNotEmpty(getCategoryList());
    }

    public boolean isHasDefaultCategoryByLocale() {
        return getDefaultCategoryByLocale() != null;
    }    

    private List<String> getCategoryIds(List<Category> categories) throws Exception {
        List<String> categoryIds = new ArrayList<String>();

        if (ListUtil.isEmpty(categories)) {
            return categoryIds;
        }        
        
        for (Category category : categories) {
            categoryIds.add(StringUtil.toString(category.getCategoryId()));
        }
        
        return categoryIds;
    }    
    
    public void saveSubscription() {
            
        try {            
            String email = getEmail();
            
            if (!isLoggedIn()) {
                long companyId = LiferayUtil.getThemeDisplay().getCompanyId();
                User user = null;
                try {
                    user = UserLocalServiceUtil.getUserByEmailAddress(companyId, email);               
                } catch (Exception e) {
                
                }
                
                if (user != null) {
                    addWarningMessage(BundleKeysConst.Subscription.USER_EXISTS_PLEASE_LOG_IN);
                    return;
                }
            }
            
            Subscription savedSubscription = getSubscription();
            if (savedSubscription == null) {
                savedSubscription = createSubscription();
            }
            
            long subscriptionId = savedSubscription.getSubscriptionId();
            
            List<String> categoriesToDelete = new ArrayList<String>();
            List<String> categoriesToCreate = new ArrayList<String>(); 
            
            List<String> selectedCategories = getSelectedCategories();
            if (isHasDefaultCategoryByLocale()) {
                selectedCategories = new ArrayList<String>();
                selectedCategories.add(getDefaultCategoryIdByLocale());
            }
            
            List<String> categoriesByLocale = getCategoryIds(getCategoryList());
            
            List<String> oldCategories = new ArrayList<String>();
            Map<String, SubscriptionCategory> subscriptionCategoryMap = new HashMap<String, SubscriptionCategory>();
            List<SubscriptionCategory> oldSubscriptionCategories = SubscriptionCategoryLocalServiceUtil.findBySubscriptionId(subscriptionId);
            for (SubscriptionCategory subscriptionCategory : oldSubscriptionCategories) {
                String catId = StringUtil.toString(subscriptionCategory.getCategoryId());
                        
                if (categoriesByLocale.contains(catId)) {
                    oldCategories.add(catId);
                    subscriptionCategoryMap.put(catId, subscriptionCategory);
                }
            }

            for (String catId : oldCategories) {
                if (!selectedCategories.contains(catId)) {
                    categoriesToDelete.add(catId);
                }
            }            
            
            for (String catId : selectedCategories) {
                if (!oldCategories.contains(catId)) {
                    categoriesToCreate.add(catId);
                }
            }            
            
            //logger.info("oldCategories: {0}", oldCategories);
            //logger.info("categoryToDelete: {0}", categoriesToDelete);
            //logger.info("categoryToCreate: {0}", categoriesToCreate);
            
            List<String> confirmationKeys = new ArrayList<String>();
            for (String catId : categoriesToCreate) {
                SubscriptionCategory newsubsCat = new SubscriptionCategoryImpl();
                newsubsCat.setSubscriptionId(subscriptionId);
                newsubsCat.setCategoryId(Long.parseLong(catId));
                
                SubscriptionKeySet subscriptionKeySet = SubscriptionKeyUtil.generateKeySet(catId, email);
                newsubsCat.setCancellationKey(subscriptionKeySet.getCancelationKey());                
                
                if (!isLoggedIn()) {
                    String confirmationKey = subscriptionKeySet.getConfirmationKey();
                    newsubsCat.setConfirmationKey(confirmationKey);
                    confirmationKeys.add(confirmationKey);                
                }

                SubscriptionCategoryLocalServiceUtil.addSubscriptionCategory(newsubsCat);
            }            
            
            if (isLoggedIn()) {
                for (String catId : categoriesToDelete) {
                    SubscriptionCategory subscriptionCategory = subscriptionCategoryMap.get(catId);
                    if (subscriptionCategory != null) {
                        SubscriptionCategoryLocalServiceUtil.deleteSubscriptionCategory(subscriptionCategory);
                    }
                }
                
                oldSubscriptionCategories = SubscriptionCategoryLocalServiceUtil.findBySubscriptionId(subscriptionId);
                for (SubscriptionCategory subscriptionCategory : oldSubscriptionCategories) {
                    String catId = StringUtil.toString(subscriptionCategory.getCategoryId());

                    if (categoriesByLocale.contains(catId)) {
                        subscriptionCategory.setStatus(WcsNewsletterConst.SubscriptionCategory.CONFIRMED);
                        SubscriptionCategoryLocalServiceUtil.updateSubscriptionCategory(subscriptionCategory);                          
                    }
                }                
            
                addSuccessMessage(BundleKeysConst.General.SAVE_SUCCESS);
            } else {
                if (ListUtil.isNotEmpty(categoriesToCreate)) {
                    SubscriberEmailSender sender = new SubscriberEmailSender();
                    sender.sendMail(email, categoriesToCreate, confirmationKeys);
                    
                    addSuccessMessage(BundleKeysConst.Subscription.SUBSCRIPTION_EMAIL_SENT);
                }
            }
            
            
        } catch (Exception e) {
            logger.error(e);
            
            addErrorMessage(BundleKeysConst.General.SAVE_ERROR);
        }
    }

    private Subscription getSubscription() throws Exception {
        List<Subscription> subscriptions;
        if (isLoggedIn()) {
            subscriptions = SubscriptionLocalServiceUtil.findByUserId(getActiveUser().getUserId());
        } else {
            subscriptions = SubscriptionLocalServiceUtil.findByEmail(getEmail());
        }        

        return ListUtil.isNotEmpty(subscriptions) ? subscriptions.get(0) : null;
    }
    
    private Subscription createSubscription() throws Exception {
        Subscription newSubscription = new SubscriptionImpl();
        
        if (isLoggedIn()) {
            newSubscription.setUserId(getActiveUser().getUserId());
        } else {
            newSubscription.setEmail(getEmail());
        }
        newSubscription.setSubscriptionDate(new Date());
        
        Subscription savedSubscription = SubscriptionLocalServiceUtil.addSubscription(newSubscription);           
        return savedSubscription;
    }
    
    @Override
    public void initController() {
        //logger.info("initController: " + getClass().getSimpleName());
        
        initCategories(); 
        initEmail();
    }

    public void initCategories() {
        if (isLoggedIn()) {
            List<String> selectedCategories = new ArrayList<String>();  
            
            try {
                List<Subscription> userSubscription = SubscriptionLocalServiceUtil.findByUserId(getActiveUser().getUserId());
                if (ListUtil.isNotEmpty(userSubscription)) {
                    List<SubscriptionCategory> oldCats = SubscriptionCategoryLocalServiceUtil.findBySubscriptionId(userSubscription.get(0).getSubscriptionId());
                    for (SubscriptionCategory sC : oldCats) {
                        selectedCategories.add(String.valueOf(sC.getCategoryId()));
                    }
                }
            } catch (SystemException ex) {
                logger.error(ex);
            }
            
            setSelectedCategories(selectedCategories);
        }      
    }
    
    public void initEmail() {
        if (StringUtil.isEmpty(getEmail())) {
            setEmail(null);            
        }
    }
}
