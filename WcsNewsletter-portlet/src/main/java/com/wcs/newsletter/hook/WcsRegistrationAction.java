package com.wcs.newsletter.hook;

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
import com.liferay.portal.ModelListenerException;
import com.liferay.portal.model.ModelListener;
import com.wcs.newsletter.model.NewsletterConfig;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.service.NewsletterConfigLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionLocalServiceUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WcsRegistrationAction implements ModelListener {

    public void onAfterCreate(Object model) throws ModelListenerException {

        com.liferay.portal.model.User mdlObj = (com.liferay.portal.model.User) model;
        try {
            List<NewsletterConfig> configs = NewsletterConfigLocalServiceUtil.findByConfigKey("syncUsers");
            if (configs.size() > 0 && "1".equals(configs.get(0).getConfigValue())) {
                List<Subscription> subs = SubscriptionLocalServiceUtil.findByEmail(mdlObj.getEmailAddress());
                if (subs.size() > 0) {
                    for (Subscription sub : subs) {
                        sub.setEmail("");
                        sub.setUserId(mdlObj.getUserId());
                        SubscriptionLocalServiceUtil.updateSubscription(sub);
                    }
                }
            }
        } catch (com.liferay.portal.kernel.exception.SystemException ex) {
            Logger.getLogger(WcsRegistrationAction.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onAfterAddAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
        //Add your implementation here
    }

    public void onAfterRemove(Object model) throws ModelListenerException {
        //Add your implementation here
    }

    public void onAfterRemoveAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
        //Add your implementation here
    }

    public void onAfterUpdate(Object model) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeAddAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeCreate(Object model) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeRemove(Object model) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeRemoveAssociation(Object arg0, String arg1, Object arg2) throws ModelListenerException {
        //Add your implementation here
    }

    public void onBeforeUpdate(Object model) throws ModelListenerException {
        //Add your implementation here
    }
}
