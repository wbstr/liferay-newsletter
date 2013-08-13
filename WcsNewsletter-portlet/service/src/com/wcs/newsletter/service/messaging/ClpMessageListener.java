package com.wcs.newsletter.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.ClpSerializer;
import com.wcs.newsletter.service.EmailTemplateLocalServiceUtil;
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

            EmailTemplateLocalServiceUtil.clearService();

            LabelLocalServiceUtil.clearService();

            NewsletterLocalServiceUtil.clearService();

            NewsletterConfigLocalServiceUtil.clearService();

            RecipientLocalServiceUtil.clearService();

            SubscriptionLocalServiceUtil.clearService();

            SubscriptionCategoryLocalServiceUtil.clearService();
        }
    }
}
