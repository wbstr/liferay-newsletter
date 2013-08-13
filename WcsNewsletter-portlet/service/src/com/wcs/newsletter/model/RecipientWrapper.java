package com.wcs.newsletter.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Recipient}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Recipient
 * @generated
 */
public class RecipientWrapper implements Recipient, ModelWrapper<Recipient> {
    private Recipient _recipient;

    public RecipientWrapper(Recipient recipient) {
        _recipient = recipient;
    }

    public Class<?> getModelClass() {
        return Recipient.class;
    }

    public String getModelClassName() {
        return Recipient.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("recipientId", getRecipientId());
        attributes.put("newsletterId", getNewsletterId());
        attributes.put("email", getEmail());
        attributes.put("status", getStatus());
        attributes.put("errorMessage", getErrorMessage());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long recipientId = (Long) attributes.get("recipientId");

        if (recipientId != null) {
            setRecipientId(recipientId);
        }

        Long newsletterId = (Long) attributes.get("newsletterId");

        if (newsletterId != null) {
            setNewsletterId(newsletterId);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String errorMessage = (String) attributes.get("errorMessage");

        if (errorMessage != null) {
            setErrorMessage(errorMessage);
        }
    }

    /**
    * Returns the primary key of this recipient.
    *
    * @return the primary key of this recipient
    */
    public long getPrimaryKey() {
        return _recipient.getPrimaryKey();
    }

    /**
    * Sets the primary key of this recipient.
    *
    * @param primaryKey the primary key of this recipient
    */
    public void setPrimaryKey(long primaryKey) {
        _recipient.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the recipient ID of this recipient.
    *
    * @return the recipient ID of this recipient
    */
    public long getRecipientId() {
        return _recipient.getRecipientId();
    }

    /**
    * Sets the recipient ID of this recipient.
    *
    * @param recipientId the recipient ID of this recipient
    */
    public void setRecipientId(long recipientId) {
        _recipient.setRecipientId(recipientId);
    }

    /**
    * Returns the newsletter ID of this recipient.
    *
    * @return the newsletter ID of this recipient
    */
    public long getNewsletterId() {
        return _recipient.getNewsletterId();
    }

    /**
    * Sets the newsletter ID of this recipient.
    *
    * @param newsletterId the newsletter ID of this recipient
    */
    public void setNewsletterId(long newsletterId) {
        _recipient.setNewsletterId(newsletterId);
    }

    /**
    * Returns the email of this recipient.
    *
    * @return the email of this recipient
    */
    public java.lang.String getEmail() {
        return _recipient.getEmail();
    }

    /**
    * Sets the email of this recipient.
    *
    * @param email the email of this recipient
    */
    public void setEmail(java.lang.String email) {
        _recipient.setEmail(email);
    }

    /**
    * Returns the status of this recipient.
    *
    * @return the status of this recipient
    */
    public java.lang.String getStatus() {
        return _recipient.getStatus();
    }

    /**
    * Sets the status of this recipient.
    *
    * @param status the status of this recipient
    */
    public void setStatus(java.lang.String status) {
        _recipient.setStatus(status);
    }

    /**
    * Returns the error message of this recipient.
    *
    * @return the error message of this recipient
    */
    public java.lang.String getErrorMessage() {
        return _recipient.getErrorMessage();
    }

    /**
    * Sets the error message of this recipient.
    *
    * @param errorMessage the error message of this recipient
    */
    public void setErrorMessage(java.lang.String errorMessage) {
        _recipient.setErrorMessage(errorMessage);
    }

    public boolean isNew() {
        return _recipient.isNew();
    }

    public void setNew(boolean n) {
        _recipient.setNew(n);
    }

    public boolean isCachedModel() {
        return _recipient.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _recipient.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _recipient.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _recipient.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _recipient.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _recipient.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _recipient.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new RecipientWrapper((Recipient) _recipient.clone());
    }

    public int compareTo(Recipient recipient) {
        return _recipient.compareTo(recipient);
    }

    @Override
    public int hashCode() {
        return _recipient.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Recipient> toCacheModel() {
        return _recipient.toCacheModel();
    }

    public Recipient toEscapedModel() {
        return new RecipientWrapper(_recipient.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _recipient.toString();
    }

    public java.lang.String toXmlString() {
        return _recipient.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _recipient.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Recipient getWrappedRecipient() {
        return _recipient;
    }

    public Recipient getWrappedModel() {
        return _recipient;
    }

    public void resetOriginalValues() {
        _recipient.resetOriginalValues();
    }
}
