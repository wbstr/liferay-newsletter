package com.wcs.newsletter.model.impl;

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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Label;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.model.Recipient;
import com.wcs.newsletter.service.NewsletterLocalServiceUtil;
import com.wcs.newsletter.util.LiferayUtil;
import java.util.List;

public class NewsletterImpl extends NewsletterBaseImpl {

    private static final Logger logger = LoggerFactory.getLogger(NewsletterImpl.class);
    private List<Category> categories;
    private List<Recipient> recipients;
    private List<Label> labels;

    public NewsletterImpl() {
    }

    public List<Category> getCategories() throws SystemException {
        if (categories == null) {
            categories = LiferayUtil.getImplFromListForClass(NewsletterLocalServiceUtil.getCategories(this), Category.class, CategoryImpl.class);
        }

        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Recipient> getRecipients() throws SystemException {
        if (recipients == null) {
            recipients = NewsletterLocalServiceUtil.getRecipients(this);
        }

        return recipients;
    }

    public void setRecipients(List<Recipient> recipients) {
        this.recipients = recipients;
    }

    public List<Label> getLabels() throws SystemException {
        if (labels == null) {
            labels = LiferayUtil.getImplFromListForClass(NewsletterLocalServiceUtil.getLabels(this), Label.class, LabelImpl.class);
        }
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public JournalArticle getJournalArticle(ThemeDisplay themeDisplay) throws SystemException, PortalException {
        if (themeDisplay == null) {
            logger.error("no themeDisplay");
            return null;
        }

        Long groupId = null;
        try {
            groupId = themeDisplay.getScopeGroupId();
        } catch (Exception e) {
        }

        if (groupId == null) {
            logger.error("no groupId");
            return null;
        }

        String articleId = getContentId();
        Double version = null;

        try {
            version = Double.parseDouble(getContentVersion());
        } catch (Exception e) {
            logger.error(e);
        }

        if (version == null) {
            logger.error("no version");
            return null;
        }

        //logger.info("getJournalArticle: {0} {1} {2}", new Object[]{groupId, articleId, version});

        JournalArticle journalArticle = null;

        try {
            journalArticle = JournalArticleLocalServiceUtil.getArticle(groupId, articleId, version);
        } catch (Exception e) {
            logger.error(e);
        }

        return journalArticle;
    }

    public Newsletter getChild() throws SystemException {
        Newsletter clone = (Newsletter) super.clone();
        clone.setNewsletterId(0);
        clone.setParentId(getNewsletterId());
        clone.setCategories(getCategories());

        return clone;
    }

    public boolean isRoot() {
        return getParentId() < 1;
    }
}
