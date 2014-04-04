package com.wcs.newsletter.service.impl;

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
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.model.Recipient;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.model.impl.RecipientImpl;
import com.wcs.newsletter.service.base.NewsletterLocalServiceBaseImpl;
import com.wcs.newsletter.service.persistence.NewsletterUtil;
import java.util.ArrayList;
import java.util.List;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.wcs.newsletter.model.Label;
import com.wcs.newsletter.model.Subscription;
import com.wcs.tool.StringUtil;

public class NewsletterLocalServiceImpl extends NewsletterLocalServiceBaseImpl {
    
    private static final Logger logger = LoggerFactory.getLogger(NewsletterLocalServiceImpl.class);
    
    public List<Newsletter> findByParentId(long parentId) throws SystemException {
        return NewsletterUtil.findByParentId(parentId);
    }    
    
    public List<Category> getCategories(Newsletter newsletter) throws SystemException {
        List<Category> categories = new ArrayList<Category>();
        if (newsletter == null) {
            return categories;
        }
        
        if (newsletter.isNew()) {
            return categories;
        }
        
        Long newsletterId = newsletter.getNewsletterId();
        
        categories = newsletterPersistence.getCategories(newsletterId);
        
        return categories;
    }

    public List<Recipient> getRecipients(Newsletter newsletter) throws SystemException {
        List<Recipient> recipients = new ArrayList<Recipient>();
        if (newsletter == null) {
            return recipients;
        }
        
        if (newsletter.isNew()) {
            return recipients;
        }
        
        Long newsletterId = newsletter.getNewsletterId();
        
        recipients = recipientPersistence.findByNewsletterId(newsletterId);//newsletterPersistence.getRecipients(newsletterId);
        
        return recipients;
    }    
    
    public List<Label> getLabels(Newsletter newsletter) throws SystemException {
        List<Label> labels = new ArrayList<Label>();
        if (newsletter == null) {
            return labels;
        }
        
        if (newsletter.isNew()) {
            return labels;
        }
        
        Long newsletterId = newsletter.getNewsletterId();
        
        labels = newsletterPersistence.getLabels(newsletterId);
        
        if (labels == null) {
            labels = new ArrayList<Label>();
        }
        
        return labels;
    }    
    
    public Newsletter save(Newsletter newsletter) throws SystemException {
        if (newsletter.isNew()) {
            newsletter = newsletterLocalService.addNewsletter(newsletter);
        } else {
            newsletter = newsletterPersistence.update(newsletter, true);
        }
        
        Long newsletterId = newsletter.getNewsletterId();
        
        List<Category> categories = newsletter.getCategories();
        
        newsletterPersistence.clearCategories(newsletterId);
        newsletterPersistence.addCategories(newsletterId, categories);
        
        List<Label> labels = newsletter.getLabels();
        
        newsletterPersistence.clearLabels(newsletterId);
        newsletterPersistence.addLabels(newsletterId, labels);
        
        logger.info("save: {0}", new Object[]{newsletter});
        
        return newsletter;
    }
    
    public Newsletter saveChild(Newsletter newsletter) throws SystemException {
        newsletter.setNew(true);
        newsletter = save(newsletter);
        Long newsletterId = newsletter.getNewsletterId();
        List<Recipient> recipients = new ArrayList<Recipient>();
        
        List<Category> categories = newsletter.getCategories();
        for (Category category : categories) {
            Long categoryId = category.getCategoryId();
            
            List<SubscriptionCategory> subscriptionCategories = subscriptionCategoryPersistence.findByCategoryId(categoryId);
            for (SubscriptionCategory subscriptionCategory : subscriptionCategories) {
                if (!subscriptionCategory.isConfirmed()) {
                    continue;
                }
                
                Subscription subscription = null;
                try {
                    subscription = subscriptionCategory.getSubscription();
                } catch (Exception ex) {
                    logger.error(ex);
                }
                if (subscription == null) {
                    continue;
                }
                
                String email = subscription.getEmailString();
                if (StringUtil.isNotEmpty(email)) {
                    Recipient recipient = new RecipientImpl();
                    recipient.setNewsletterId(newsletterId); 
                    recipient.setEmail(email);
                    
                    recipients.add(recipient);
                }
            }
        }

        logger.info("saveChild: {0}", new Object[]{newsletter});
        
        for (Recipient recipient : recipients) {
            logger.info("recipient: {0}", new Object[]{recipient});
            recipientLocalService.addRecipient(recipient);            
        }        
        
        return newsletter;
    }    
    
}
