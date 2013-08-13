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

import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.util.BundleKeysConst;
import com.wcs.newsletter.util.EmailConst;
import com.wcs.newsletter.util.LiferayUtil;
import com.wcs.newsletter.util.WcsNewsletterConst;
import com.wcs.tool.ListUtil;
import com.wcs.tool.StringUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class SubscriptionActionController extends AbstractController {

    private List<String> getParams(String key) {
        List<String> params = new ArrayList<String>();
        
        if (StringUtil.isEmpty(key)) {
            return params;
        }
        
        String[] paramsArr = null;
        
        try {
            paramsArr = LiferayUtil.getHttpServletRequest().getParameterValues(key);   
        } catch (Exception e) {
            logger.error(e);
        }
        
        if (paramsArr != null) {
            params = new ArrayList(Arrays.asList(paramsArr));        
        }
        
        return params;
    }        
    
    private List<String> getConfirmParams() {
        return getParams(EmailConst.Action.CONFIRM_PARAM_KEY);
    }    
    
    private boolean hasConfirmParam() {
        return ListUtil.isNotEmpty(getConfirmParams());
    }
    
    private void logAction(String actionName, SubscriptionCategory subscriptionCategory) {
        String email = null;
        String categoryName = null;
        
        try {
            Subscription subscription = subscriptionCategory.getSubscription();
            email = subscription != null ? subscription.getEmailString() : null;
        } catch (Exception e) {
        
        }

        try {
            Category category = subscriptionCategory.getCategory();
            categoryName = category != null ? category.getName() : null;   
        } catch (Exception e) {
        
        }
        
        logger.info("subscription {0}: {1} {2}", new Object[]{actionName, email, categoryName});    
    }
    
    private void checkConfirm() {
        try {
            boolean changed = false;
            for (String key : getConfirmParams()) {
                List<SubscriptionCategory> subsList = SubscriptionCategoryLocalServiceUtil.findByConfirmationKey(key);
                for (SubscriptionCategory confirmSub : subsList) {
                    confirmSub.setConfirmationKey(null);
                    confirmSub.setStatus(WcsNewsletterConst.SubscriptionCategory.CONFIRMED);
                    SubscriptionCategoryLocalServiceUtil.updateSubscriptionCategory(confirmSub);   
                    changed = true;
                    
                    logAction("confirm", confirmSub);
                }
            }
            
            if (changed) {
                addSuccessMessage(BundleKeysConst.Subscription.CONFIRM_SUCCESS);            
            } else {
                addWarningMessage(BundleKeysConst.Subscription.CONFIRM_EMPTY_LIST);            
            }
            
        } catch (Exception ex) {
            logger.error(ex);
            
            addErrorMessage(BundleKeysConst.Subscription.CONFIRM_ERROR);
        }
    }

    private List<String> getCancelParams() {
        return getParams(EmailConst.Action.CANCEL_PARAM_KEY);
    }       
    
    private boolean hasCancelParam() {
        return ListUtil.isNotEmpty(getCancelParams());
    }    
    
    private void checkCancel() {
        try {
            boolean changed = false;
            for (String key : getCancelParams()) {            
                List<SubscriptionCategory> subsList = SubscriptionCategoryLocalServiceUtil.findByCancellationKey(key);                
                for (SubscriptionCategory subscriptionCategory : subsList) {
                    SubscriptionCategoryLocalServiceUtil.deleteSubscriptionCategory(subscriptionCategory);
                    changed = true;
                    
                    logAction("cancel", subscriptionCategory);
                }
            }
            
            if (changed) {
                addSuccessMessage(BundleKeysConst.Subscription.CANCEL_SUCCESS);                
            } else {
                addWarningMessage(BundleKeysConst.Subscription.CANCEL_EMPTY_LIST);
            }            
            
        } catch (Exception ex) {
            logger.error(ex);
            
            addErrorMessage(BundleKeysConst.Subscription.CANCEL_ERROR);
        }
        
    }

    @Override
    public void initController() {
        if (hasConfirmParam()) {
            checkConfirm();
        }
        
        if (hasCancelParam()) {
            checkCancel();
        }
    }

}
