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
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.model.JournalArticleDisplay;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.wcs.newsletter.dto.NewsletterSenderList;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.tools.Tools;
import com.wcs.tool.DateUtil;
import com.wcs.tool.StringUtil;

import javax.mail.internet.InternetAddress;

public class NewsletterSender {

    private static final Logger logger = LoggerFactory.getLogger(NewsletterSender.class);
    private Newsletter newsletter;
    private ThemeDisplay themeDisplay;
    private NewsletterSenderList recList;
    private String templateKey;

    public NewsletterSender(Newsletter newsletter, NewsletterSenderList recList, ThemeDisplay themeDisplay, String templateKey) {
        this.newsletter = newsletter;
        this.recList = recList;
        this.themeDisplay = themeDisplay;
        this.templateKey = templateKey; 
    }

    public void send() throws Exception {
        String languageId = themeDisplay.getLanguageId();

        JournalArticle journalArticle = newsletter.getJournalArticle(themeDisplay);

        logger.info("journalArticle: {0}", new Object[]{journalArticle});

        String content = getArticleContent(journalArticle, languageId, templateKey);

        InternetAddress from = new InternetAddress(newsletter.getSender());        
        String subject = newsletter.getSubject();
        String htmlContent = StringUtil.toString(content);



        NewsletterSenderThread newsletterSenderThread = new NewsletterSenderThread(from, recList, subject, htmlContent,themeDisplay);
        Thread thread = new Thread(newsletterSenderThread);
        thread.start();
    }

    private String getArticleContent(JournalArticle article, String languageId, String templateKey) throws Exception {
        try {
            String articleMultiLanguageXMLContent = article.getContent();
            String templateContent;
            FileEntry newsletterTemplate = DLAppServiceUtil.getFileEntry(Long.parseLong(newsletter.getTemplateId()));
            templateContent = Tools.InputStream2Str(newsletterTemplate.getContentStream(), false);
            
			JournalArticleDisplay articleDisplay = JournalArticleLocalServiceUtil
					.getArticleDisplay(article, templateKey, Constants.VIEW,
							languageId, 1, null, null);
			
			String articleContent = articleDisplay.getContent();
			
            String localizedContent = templateContent.replace("###CONTENT###", articleContent);
//            String localizedContent = templateContent.replace("###CONTENT###", JournalContentUtil.getContent(article.getGroupId(), article.getArticleId(), null, locale, articleMultiLanguageXMLContent));
            localizedContent = localizedContent.replace("###sendDate###", DateUtil.dateToString(newsletter.getCreationTime(), "yyyy.MM.dd"));
            localizedContent = localizedContent.replace("###newsletterTitle###", article.getTitle(languageId));
            localizedContent = localizedContent.replaceAll("\"\\/documents", "\"" + themeDisplay.getURLPortal() + "\\/documents");
            return localizedContent;
        } catch (Exception ex) {
            logger.error(ex);
            return "";
        }
    }

}
