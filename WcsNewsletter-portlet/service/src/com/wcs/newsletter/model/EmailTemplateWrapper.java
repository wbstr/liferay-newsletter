package com.wcs.newsletter.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link EmailTemplate}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       EmailTemplate
 * @generated
 */
public class EmailTemplateWrapper implements EmailTemplate,
    ModelWrapper<EmailTemplate> {
    private EmailTemplate _emailTemplate;

    public EmailTemplateWrapper(EmailTemplate emailTemplate) {
        _emailTemplate = emailTemplate;
    }

    public Class<?> getModelClass() {
        return EmailTemplate.class;
    }

    public String getModelClassName() {
        return EmailTemplate.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("emailTemplateId", getEmailTemplateId());
        attributes.put("fileEntryId", getFileEntryId());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long emailTemplateId = (Long) attributes.get("emailTemplateId");

        if (emailTemplateId != null) {
            setEmailTemplateId(emailTemplateId);
        }

        Long fileEntryId = (Long) attributes.get("fileEntryId");

        if (fileEntryId != null) {
            setFileEntryId(fileEntryId);
        }
    }

    /**
    * Returns the primary key of this email template.
    *
    * @return the primary key of this email template
    */
    public long getPrimaryKey() {
        return _emailTemplate.getPrimaryKey();
    }

    /**
    * Sets the primary key of this email template.
    *
    * @param primaryKey the primary key of this email template
    */
    public void setPrimaryKey(long primaryKey) {
        _emailTemplate.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the email template ID of this email template.
    *
    * @return the email template ID of this email template
    */
    public long getEmailTemplateId() {
        return _emailTemplate.getEmailTemplateId();
    }

    /**
    * Sets the email template ID of this email template.
    *
    * @param emailTemplateId the email template ID of this email template
    */
    public void setEmailTemplateId(long emailTemplateId) {
        _emailTemplate.setEmailTemplateId(emailTemplateId);
    }

    /**
    * Returns the file entry ID of this email template.
    *
    * @return the file entry ID of this email template
    */
    public long getFileEntryId() {
        return _emailTemplate.getFileEntryId();
    }

    /**
    * Sets the file entry ID of this email template.
    *
    * @param fileEntryId the file entry ID of this email template
    */
    public void setFileEntryId(long fileEntryId) {
        _emailTemplate.setFileEntryId(fileEntryId);
    }

    public boolean isNew() {
        return _emailTemplate.isNew();
    }

    public void setNew(boolean n) {
        _emailTemplate.setNew(n);
    }

    public boolean isCachedModel() {
        return _emailTemplate.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _emailTemplate.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _emailTemplate.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _emailTemplate.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _emailTemplate.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _emailTemplate.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _emailTemplate.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new EmailTemplateWrapper((EmailTemplate) _emailTemplate.clone());
    }

    public int compareTo(EmailTemplate emailTemplate) {
        return _emailTemplate.compareTo(emailTemplate);
    }

    @Override
    public int hashCode() {
        return _emailTemplate.hashCode();
    }

    public com.liferay.portal.model.CacheModel<EmailTemplate> toCacheModel() {
        return _emailTemplate.toCacheModel();
    }

    public EmailTemplate toEscapedModel() {
        return new EmailTemplateWrapper(_emailTemplate.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _emailTemplate.toString();
    }

    public java.lang.String toXmlString() {
        return _emailTemplate.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _emailTemplate.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public EmailTemplate getWrappedEmailTemplate() {
        return _emailTemplate;
    }

    public EmailTemplate getWrappedModel() {
        return _emailTemplate;
    }

    public void resetOriginalValues() {
        _emailTemplate.resetOriginalValues();
    }
}
