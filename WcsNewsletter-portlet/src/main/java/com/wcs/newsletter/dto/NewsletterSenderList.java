/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.newsletter.dto;

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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.tool.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 *
 * @author csaba
 */
public class NewsletterSenderList {

    private List<SendListElem> recipients;

    public List<SendListElem> getRecipients() {
        return recipients;
    }

    public void setRecipients(List<SendListElem> recipients) {
        this.recipients = recipients;
    }

    public NewsletterSenderList(Newsletter newsletter, String testEmail) {
        try {
            recipients = new ArrayList<SendListElem>();
            SendListElem listElem = new SendListElem();
            InternetAddress internetAddress = new InternetAddress(testEmail);
            listElem.setSubscriptionEmail(internetAddress);
            listElem.setCategoryName("Test - "+testEmail);
            recipients.add(listElem);
        } catch (AddressException ex) {
            Logger.getLogger(NewsletterSenderList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public NewsletterSenderList(Newsletter newsletter, Locale locale) {
        try {

//            initNewsletterCategory();
//            newsletterCategory = NewsletterCategoryLocalServiceUtil.getNewsletterCategories(0, NewsletterCategoryLocalServiceUtil.getNewsletterCategoriesCount());
            recipients = new ArrayList<SendListElem>();

            List<Category> categories = CategoryLocalServiceUtil.findByNewsletterId(newsletter.getNewsletterId()); 
//            List<Category> categories = newsletter.getCategories();
            for (Category category : categories) {
                Long categoryId = category.getCategoryId();

                List<SubscriptionCategory> subscriptionCategories = SubscriptionCategoryLocalServiceUtil.findByCategoryId(categoryId);
                for (SubscriptionCategory subscriptionCategory : subscriptionCategories) {
                    if (!subscriptionCategory.isConfirmed()) {
                        continue;
                    }

                    Subscription subscription = null;
                    try {
                        subscription = subscriptionCategory.getSubscription();
                    } catch (Exception ex) {
//                        logger.error(ex);
                    }
                    if (subscription == null) {
                        continue;
                    }

                    String email = subscription.getEmailString();

                    if (StringUtil.isNotEmpty(email)) {
                        SendListElem listElem = new SendListElem();
                        if (subscription.getUserId() != Long.MIN_VALUE && subscription.getUserId() != 0) {
                            User newletterRecipUser = UserLocalServiceUtil.getUser(subscription.getUserId());
                            listElem.setNewsletterUser(newletterRecipUser);
                        }
                        
                        String categoryName = category.getName(locale); 
                        
                        System.out.println("categoryName = " + categoryName); 
                        
                        listElem.setCategoryName(categoryName);
                        
//                        listElem.setCategoryName(category.getName());

                        InternetAddress internetAddress = new InternetAddress(email);
                        listElem.setSubscriptionEmail(internetAddress);

                        listElem.setNewsletterSubscription(subscription);
                        listElem.setNewsletterSubscriptionCategory(subscriptionCategory);
                        recipients.add(listElem);
                    }
                }
            }
        } catch (AddressException ex) {
            Logger.getLogger(NewsletterSenderList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PortalException ex) {
            Logger.getLogger(NewsletterSenderList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(NewsletterSenderList.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
