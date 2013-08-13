package com.wcs.newsletter.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SubscriptionCategory}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SubscriptionCategory
 * @generated
 */
public class SubscriptionCategoryWrapper implements SubscriptionCategory,
    ModelWrapper<SubscriptionCategory> {
    private SubscriptionCategory _subscriptionCategory;

    public SubscriptionCategoryWrapper(
        SubscriptionCategory subscriptionCategory) {
        _subscriptionCategory = subscriptionCategory;
    }

    public Class<?> getModelClass() {
        return SubscriptionCategory.class;
    }

    public String getModelClassName() {
        return SubscriptionCategory.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subscriptionId", getSubscriptionId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("confirmationKey", getConfirmationKey());
        attributes.put("cancellationKey", getCancellationKey());
        attributes.put("status", getStatus());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long subscriptionId = (Long) attributes.get("subscriptionId");

        if (subscriptionId != null) {
            setSubscriptionId(subscriptionId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String confirmationKey = (String) attributes.get("confirmationKey");

        if (confirmationKey != null) {
            setConfirmationKey(confirmationKey);
        }

        String cancellationKey = (String) attributes.get("cancellationKey");

        if (cancellationKey != null) {
            setCancellationKey(cancellationKey);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
    }

    /**
    * Returns the primary key of this subscription category.
    *
    * @return the primary key of this subscription category
    */
    public com.wcs.newsletter.service.persistence.SubscriptionCategoryPK getPrimaryKey() {
        return _subscriptionCategory.getPrimaryKey();
    }

    /**
    * Sets the primary key of this subscription category.
    *
    * @param primaryKey the primary key of this subscription category
    */
    public void setPrimaryKey(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK primaryKey) {
        _subscriptionCategory.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the subscription ID of this subscription category.
    *
    * @return the subscription ID of this subscription category
    */
    public long getSubscriptionId() {
        return _subscriptionCategory.getSubscriptionId();
    }

    /**
    * Sets the subscription ID of this subscription category.
    *
    * @param subscriptionId the subscription ID of this subscription category
    */
    public void setSubscriptionId(long subscriptionId) {
        _subscriptionCategory.setSubscriptionId(subscriptionId);
    }

    /**
    * Returns the category ID of this subscription category.
    *
    * @return the category ID of this subscription category
    */
    public long getCategoryId() {
        return _subscriptionCategory.getCategoryId();
    }

    /**
    * Sets the category ID of this subscription category.
    *
    * @param categoryId the category ID of this subscription category
    */
    public void setCategoryId(long categoryId) {
        _subscriptionCategory.setCategoryId(categoryId);
    }

    /**
    * Returns the confirmation key of this subscription category.
    *
    * @return the confirmation key of this subscription category
    */
    public java.lang.String getConfirmationKey() {
        return _subscriptionCategory.getConfirmationKey();
    }

    /**
    * Sets the confirmation key of this subscription category.
    *
    * @param confirmationKey the confirmation key of this subscription category
    */
    public void setConfirmationKey(java.lang.String confirmationKey) {
        _subscriptionCategory.setConfirmationKey(confirmationKey);
    }

    /**
    * Returns the cancellation key of this subscription category.
    *
    * @return the cancellation key of this subscription category
    */
    public java.lang.String getCancellationKey() {
        return _subscriptionCategory.getCancellationKey();
    }

    /**
    * Sets the cancellation key of this subscription category.
    *
    * @param cancellationKey the cancellation key of this subscription category
    */
    public void setCancellationKey(java.lang.String cancellationKey) {
        _subscriptionCategory.setCancellationKey(cancellationKey);
    }

    /**
    * Returns the status of this subscription category.
    *
    * @return the status of this subscription category
    */
    public java.lang.String getStatus() {
        return _subscriptionCategory.getStatus();
    }

    /**
    * Sets the status of this subscription category.
    *
    * @param status the status of this subscription category
    */
    public void setStatus(java.lang.String status) {
        _subscriptionCategory.setStatus(status);
    }

    public boolean isNew() {
        return _subscriptionCategory.isNew();
    }

    public void setNew(boolean n) {
        _subscriptionCategory.setNew(n);
    }

    public boolean isCachedModel() {
        return _subscriptionCategory.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _subscriptionCategory.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _subscriptionCategory.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _subscriptionCategory.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _subscriptionCategory.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _subscriptionCategory.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _subscriptionCategory.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SubscriptionCategoryWrapper((SubscriptionCategory) _subscriptionCategory.clone());
    }

    public int compareTo(SubscriptionCategory subscriptionCategory) {
        return _subscriptionCategory.compareTo(subscriptionCategory);
    }

    @Override
    public int hashCode() {
        return _subscriptionCategory.hashCode();
    }

    public com.liferay.portal.model.CacheModel<SubscriptionCategory> toCacheModel() {
        return _subscriptionCategory.toCacheModel();
    }

    public SubscriptionCategory toEscapedModel() {
        return new SubscriptionCategoryWrapper(_subscriptionCategory.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _subscriptionCategory.toString();
    }

    public java.lang.String toXmlString() {
        return _subscriptionCategory.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _subscriptionCategory.persist();
    }

    public boolean isConfirmed() {
        return _subscriptionCategory.isConfirmed();
    }

    public com.wcs.newsletter.model.Subscription getSubscription()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategory.getSubscription();
    }

    public com.wcs.newsletter.model.Category getCategory()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategory.getCategory();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public SubscriptionCategory getWrappedSubscriptionCategory() {
        return _subscriptionCategory;
    }

    public SubscriptionCategory getWrappedModel() {
        return _subscriptionCategory;
    }

    public void resetOriginalValues() {
        _subscriptionCategory.resetOriginalValues();
    }
}
