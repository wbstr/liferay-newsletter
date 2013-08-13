package com.wcs.newsletter.util;

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
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.wcs.newsletter.model.NewsletterConfig;
import com.wcs.newsletter.replacer.CategoryNameReplacer;
import com.wcs.newsletter.replacer.ConfirmEmailLinkReplacer;
import com.wcs.newsletter.replacer.EmailVariableReplacer;
import com.wcs.newsletter.service.NewsletterConfigLocalServiceUtil;
import com.wcs.newsletter.tools.Tools;
import com.wcs.tool.StringUtil;
import java.util.List;
import javax.mail.internet.InternetAddress;

public class SubscriberEmailSender {

    protected static final Logger logger = LoggerFactory.getLogger(SubscriberEmailSender.class);

    public void sendMail(String email, List<String> categoryIds, List<String> confirmationKeys) throws Exception {
        String subject = ResourceBundleUtil.getMessage(BundleKeysConst.Email.SUBSCRIPTION_SUBJECT);

        String templateContent = getTemplateContent();
        templateContent = new EmailVariableReplacer(templateContent)
                .addReplacer(new CategoryNameReplacer(categoryIds))
                .addReplacer(new ConfirmEmailLinkReplacer(confirmationKeys))
                .replace();

        sendEmail(email, subject, templateContent, true);
    }

    private String getTemplateContent() throws Exception {
        String newsletterEmail = GetterUtil.getString(LiferayUtil.getPortletPreferences().getValue(EmailConst.Preference.NEWSLETTER_EMAIL, StringPool.BLANK));
        if (StringUtil.isEmpty(newsletterEmail)) {
            List<NewsletterConfig> configs = NewsletterConfigLocalServiceUtil.findByConfigKey("emailTemplate");
            if (!configs.isEmpty()) {
                newsletterEmail = String.valueOf(configs.get(0).getConfigValue());
            }
        }

        String templateContent = null;
        try {
            DLFileEntry newsletterTemplate = DLFileEntryLocalServiceUtil.getDLFileEntry(Long.parseLong(newsletterEmail));// DLAppServiceUtil.getFileEntry(Long.parseLong(newsletterEmail));
            templateContent = Tools.InputStream2Str(newsletterTemplate.getContentStream(), false);
        } catch (Exception ex) {
            logger.error(ex);
        }

        return templateContent;
    }

    private void sendEmail(String email, String subject, String body, boolean sendHtml) throws Exception {
        InternetAddress rcpt = new InternetAddress(email);
        InternetAddress from = new InternetAddress(PrefsPropsUtil.getString(LiferayUtil.getThemeDisplay().getCompanyId(), PropsKeys.ADMIN_EMAIL_FROM_ADDRESS));

        MailMessage mailMessage = new MailMessage();
        mailMessage.setBody(body);
        mailMessage.setHTMLFormat(sendHtml);
        mailMessage.setFrom(from);
        mailMessage.setTo(rcpt);
        mailMessage.setSubject(subject);
        MailServiceUtil.sendEmail(mailMessage);
    }
}
