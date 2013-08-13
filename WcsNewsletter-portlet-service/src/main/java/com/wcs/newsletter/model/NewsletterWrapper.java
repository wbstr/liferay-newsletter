package com.wcs.newsletter.model;

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

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Newsletter}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Newsletter
 * @generated
 */
public class NewsletterWrapper implements Newsletter, ModelWrapper<Newsletter> {
    private Newsletter _newsletter;

    public NewsletterWrapper(Newsletter newsletter) {
        _newsletter = newsletter;
    }

    public Class<?> getModelClass() {
        return Newsletter.class;
    }

    public String getModelClassName() {
        return Newsletter.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("newsletterId", getNewsletterId());
        attributes.put("subject", getSubject());
        attributes.put("sender", getSender());
        attributes.put("contentId", getContentId());
        attributes.put("contentVersion", getContentVersion());
        attributes.put("templateId", getTemplateId());
        attributes.put("templateVersion", getTemplateVersion());
        attributes.put("parentId", getParentId());
        attributes.put("creationTime", getCreationTime());
        attributes.put("state", getState());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long newsletterId = (Long) attributes.get("newsletterId");

        if (newsletterId != null) {
            setNewsletterId(newsletterId);
        }

        String subject = (String) attributes.get("subject");

        if (subject != null) {
            setSubject(subject);
        }

        String sender = (String) attributes.get("sender");

        if (sender != null) {
            setSender(sender);
        }

        String contentId = (String) attributes.get("contentId");

        if (contentId != null) {
            setContentId(contentId);
        }

        String contentVersion = (String) attributes.get("contentVersion");

        if (contentVersion != null) {
            setContentVersion(contentVersion);
        }

        String templateId = (String) attributes.get("templateId");

        if (templateId != null) {
            setTemplateId(templateId);
        }

        String templateVersion = (String) attributes.get("templateVersion");

        if (templateVersion != null) {
            setTemplateVersion(templateVersion);
        }

        Long parentId = (Long) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        Date creationTime = (Date) attributes.get("creationTime");

        if (creationTime != null) {
            setCreationTime(creationTime);
        }

        String state = (String) attributes.get("state");

        if (state != null) {
            setState(state);
        }
    }

    /**
    * Returns the primary key of this newsletter.
    *
    * @return the primary key of this newsletter
    */
    public long getPrimaryKey() {
        return _newsletter.getPrimaryKey();
    }

    /**
    * Sets the primary key of this newsletter.
    *
    * @param primaryKey the primary key of this newsletter
    */
    public void setPrimaryKey(long primaryKey) {
        _newsletter.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the newsletter ID of this newsletter.
    *
    * @return the newsletter ID of this newsletter
    */
    public long getNewsletterId() {
        return _newsletter.getNewsletterId();
    }

    /**
    * Sets the newsletter ID of this newsletter.
    *
    * @param newsletterId the newsletter ID of this newsletter
    */
    public void setNewsletterId(long newsletterId) {
        _newsletter.setNewsletterId(newsletterId);
    }

    /**
    * Returns the subject of this newsletter.
    *
    * @return the subject of this newsletter
    */
    public java.lang.String getSubject() {
        return _newsletter.getSubject();
    }

    /**
    * Sets the subject of this newsletter.
    *
    * @param subject the subject of this newsletter
    */
    public void setSubject(java.lang.String subject) {
        _newsletter.setSubject(subject);
    }

    /**
    * Returns the sender of this newsletter.
    *
    * @return the sender of this newsletter
    */
    public java.lang.String getSender() {
        return _newsletter.getSender();
    }

    /**
    * Sets the sender of this newsletter.
    *
    * @param sender the sender of this newsletter
    */
    public void setSender(java.lang.String sender) {
        _newsletter.setSender(sender);
    }

    /**
    * Returns the content ID of this newsletter.
    *
    * @return the content ID of this newsletter
    */
    public java.lang.String getContentId() {
        return _newsletter.getContentId();
    }

    /**
    * Sets the content ID of this newsletter.
    *
    * @param contentId the content ID of this newsletter
    */
    public void setContentId(java.lang.String contentId) {
        _newsletter.setContentId(contentId);
    }

    /**
    * Returns the content version of this newsletter.
    *
    * @return the content version of this newsletter
    */
    public java.lang.String getContentVersion() {
        return _newsletter.getContentVersion();
    }

    /**
    * Sets the content version of this newsletter.
    *
    * @param contentVersion the content version of this newsletter
    */
    public void setContentVersion(java.lang.String contentVersion) {
        _newsletter.setContentVersion(contentVersion);
    }

    /**
    * Returns the template ID of this newsletter.
    *
    * @return the template ID of this newsletter
    */
    public java.lang.String getTemplateId() {
        return _newsletter.getTemplateId();
    }

    /**
    * Sets the template ID of this newsletter.
    *
    * @param templateId the template ID of this newsletter
    */
    public void setTemplateId(java.lang.String templateId) {
        _newsletter.setTemplateId(templateId);
    }

    /**
    * Returns the template version of this newsletter.
    *
    * @return the template version of this newsletter
    */
    public java.lang.String getTemplateVersion() {
        return _newsletter.getTemplateVersion();
    }

    /**
    * Sets the template version of this newsletter.
    *
    * @param templateVersion the template version of this newsletter
    */
    public void setTemplateVersion(java.lang.String templateVersion) {
        _newsletter.setTemplateVersion(templateVersion);
    }

    /**
    * Returns the parent ID of this newsletter.
    *
    * @return the parent ID of this newsletter
    */
    public long getParentId() {
        return _newsletter.getParentId();
    }

    /**
    * Sets the parent ID of this newsletter.
    *
    * @param parentId the parent ID of this newsletter
    */
    public void setParentId(long parentId) {
        _newsletter.setParentId(parentId);
    }

    /**
    * Returns the creation time of this newsletter.
    *
    * @return the creation time of this newsletter
    */
    public java.util.Date getCreationTime() {
        return _newsletter.getCreationTime();
    }

    /**
    * Sets the creation time of this newsletter.
    *
    * @param creationTime the creation time of this newsletter
    */
    public void setCreationTime(java.util.Date creationTime) {
        _newsletter.setCreationTime(creationTime);
    }

    /**
    * Returns the state of this newsletter.
    *
    * @return the state of this newsletter
    */
    public java.lang.String getState() {
        return _newsletter.getState();
    }

    /**
    * Sets the state of this newsletter.
    *
    * @param state the state of this newsletter
    */
    public void setState(java.lang.String state) {
        _newsletter.setState(state);
    }

    public boolean isNew() {
        return _newsletter.isNew();
    }

    public void setNew(boolean n) {
        _newsletter.setNew(n);
    }

    public boolean isCachedModel() {
        return _newsletter.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _newsletter.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _newsletter.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _newsletter.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _newsletter.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _newsletter.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _newsletter.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new NewsletterWrapper((Newsletter) _newsletter.clone());
    }

    public int compareTo(Newsletter newsletter) {
        return _newsletter.compareTo(newsletter);
    }

    @Override
    public int hashCode() {
        return _newsletter.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Newsletter> toCacheModel() {
        return _newsletter.toCacheModel();
    }

    public Newsletter toEscapedModel() {
        return new NewsletterWrapper(_newsletter.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _newsletter.toString();
    }

    public java.lang.String toXmlString() {
        return _newsletter.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _newsletter.persist();
    }

    public java.util.List<com.wcs.newsletter.model.Category> getCategories()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletter.getCategories();
    }

    public void setCategories(
        java.util.List<com.wcs.newsletter.model.Category> categories) {
        _newsletter.setCategories(categories);
    }

    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletter.getRecipients();
    }

    public void setRecipients(
        java.util.List<com.wcs.newsletter.model.Recipient> recipients) {
        _newsletter.setRecipients(recipients);
    }

    public java.util.List<com.wcs.newsletter.model.Label> getLabels()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletter.getLabels();
    }

    public void setLabels(java.util.List<com.wcs.newsletter.model.Label> labels) {
        _newsletter.setLabels(labels);
    }

    public com.liferay.portlet.journal.model.JournalArticle getJournalArticle(
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletter.getJournalArticle(themeDisplay);
    }

    public com.wcs.newsletter.model.Newsletter getChild()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletter.getChild();
    }

    public boolean isRoot() {
        return _newsletter.isRoot();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Newsletter getWrappedNewsletter() {
        return _newsletter;
    }

    public Newsletter getWrappedModel() {
        return _newsletter;
    }

    public void resetOriginalValues() {
        _newsletter.resetOriginalValues();
    }
}
