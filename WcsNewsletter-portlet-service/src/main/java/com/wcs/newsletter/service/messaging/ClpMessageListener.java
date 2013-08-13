package com.wcs.newsletter.service.messaging;

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

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.ClpSerializer;
import com.wcs.newsletter.service.LabelLocalServiceUtil;
import com.wcs.newsletter.service.NewsletterConfigLocalServiceUtil;
import com.wcs.newsletter.service.NewsletterLocalServiceUtil;
import com.wcs.newsletter.service.RecipientLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionLocalServiceUtil;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            CategoryLocalServiceUtil.clearService();

            LabelLocalServiceUtil.clearService();

            NewsletterLocalServiceUtil.clearService();

            NewsletterConfigLocalServiceUtil.clearService();

            RecipientLocalServiceUtil.clearService();

            SubscriptionLocalServiceUtil.clearService();

            SubscriptionCategoryLocalServiceUtil.clearService();
        }
    }
}
