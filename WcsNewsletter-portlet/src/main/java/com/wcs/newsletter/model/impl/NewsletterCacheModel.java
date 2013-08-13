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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.wcs.newsletter.model.Newsletter;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Newsletter in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Newsletter
 * @generated
 */
public class NewsletterCacheModel implements CacheModel<Newsletter>,
    Serializable {
    public long newsletterId;
    public String subject;
    public String sender;
    public String contentId;
    public String contentVersion;
    public String templateId;
    public String templateVersion;
    public long parentId;
    public long creationTime;
    public String state;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{newsletterId=");
        sb.append(newsletterId);
        sb.append(", subject=");
        sb.append(subject);
        sb.append(", sender=");
        sb.append(sender);
        sb.append(", contentId=");
        sb.append(contentId);
        sb.append(", contentVersion=");
        sb.append(contentVersion);
        sb.append(", templateId=");
        sb.append(templateId);
        sb.append(", templateVersion=");
        sb.append(templateVersion);
        sb.append(", parentId=");
        sb.append(parentId);
        sb.append(", creationTime=");
        sb.append(creationTime);
        sb.append(", state=");
        sb.append(state);
        sb.append("}");

        return sb.toString();
    }

    public Newsletter toEntityModel() {
        NewsletterImpl newsletterImpl = new NewsletterImpl();

        newsletterImpl.setNewsletterId(newsletterId);

        if (subject == null) {
            newsletterImpl.setSubject(StringPool.BLANK);
        } else {
            newsletterImpl.setSubject(subject);
        }

        if (sender == null) {
            newsletterImpl.setSender(StringPool.BLANK);
        } else {
            newsletterImpl.setSender(sender);
        }

        if (contentId == null) {
            newsletterImpl.setContentId(StringPool.BLANK);
        } else {
            newsletterImpl.setContentId(contentId);
        }

        if (contentVersion == null) {
            newsletterImpl.setContentVersion(StringPool.BLANK);
        } else {
            newsletterImpl.setContentVersion(contentVersion);
        }

        if (templateId == null) {
            newsletterImpl.setTemplateId(StringPool.BLANK);
        } else {
            newsletterImpl.setTemplateId(templateId);
        }

        if (templateVersion == null) {
            newsletterImpl.setTemplateVersion(StringPool.BLANK);
        } else {
            newsletterImpl.setTemplateVersion(templateVersion);
        }

        newsletterImpl.setParentId(parentId);

        if (creationTime == Long.MIN_VALUE) {
            newsletterImpl.setCreationTime(null);
        } else {
            newsletterImpl.setCreationTime(new Date(creationTime));
        }

        if (state == null) {
            newsletterImpl.setState(StringPool.BLANK);
        } else {
            newsletterImpl.setState(state);
        }

        newsletterImpl.resetOriginalValues();

        return newsletterImpl;
    }
}
