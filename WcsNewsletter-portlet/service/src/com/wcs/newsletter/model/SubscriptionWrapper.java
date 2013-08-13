package com.wcs.newsletter.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Subscription}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Subscription
 * @generated
 */
public class SubscriptionWrapper implements Subscription,
    ModelWrapper<Subscription> {
    private Subscription _subscription;

    public SubscriptionWrapper(Subscription subscription) {
        _subscription = subscription;
    }

    public Class<?> getModelClass() {
        return Subscription.class;
    }

    public String getModelClassName() {
        return Subscription.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subscriptionId", getSubscriptionId());
        attributes.put("userId", getUserId());
        attributes.put("email", getEmail());
        attributes.put("subscriptionDate", getSubscriptionDate());

        return attributes;
    }

    public void setModelAttributes(Map<String, Object> attributes) {
        Long subscriptionId = (Long) attributes.get("subscriptionId");

        if (subscriptionId != null) {
            setSubscriptionId(subscriptionId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        Date subscriptionDate = (Date) attributes.get("subscriptionDate");

        if (subscriptionDate != null) {
            setSubscriptionDate(subscriptionDate);
        }
    }

    /**
    * Returns the primary key of this subscription.
    *
    * @return the primary key of this subscription
    */
    public long getPrimaryKey() {
        return _subscription.getPrimaryKey();
    }

    /**
    * Sets the primary key of this subscription.
    *
    * @param primaryKey the primary key of this subscription
    */
    public void setPrimaryKey(long primaryKey) {
        _subscription.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the subscription ID of this subscription.
    *
    * @return the subscription ID of this subscription
    */
    public long getSubscriptionId() {
        return _subscription.getSubscriptionId();
    }

    /**
    * Sets the subscription ID of this subscription.
    *
    * @param subscriptionId the subscription ID of this subscription
    */
    public void setSubscriptionId(long subscriptionId) {
        _subscription.setSubscriptionId(subscriptionId);
    }

    /**
    * Returns the user ID of this subscription.
    *
    * @return the user ID of this subscription
    */
    public long getUserId() {
        return _subscription.getUserId();
    }

    /**
    * Sets the user ID of this subscription.
    *
    * @param userId the user ID of this subscription
    */
    public void setUserId(long userId) {
        _subscription.setUserId(userId);
    }

    /**
    * Returns the user uuid of this subscription.
    *
    * @return the user uuid of this subscription
    * @throws SystemException if a system exception occurred
    */
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscription.getUserUuid();
    }

    /**
    * Sets the user uuid of this subscription.
    *
    * @param userUuid the user uuid of this subscription
    */
    public void setUserUuid(java.lang.String userUuid) {
        _subscription.setUserUuid(userUuid);
    }

    /**
    * Returns the email of this subscription.
    *
    * @return the email of this subscription
    */
    public java.lang.String getEmail() {
        return _subscription.getEmail();
    }

    /**
    * Sets the email of this subscription.
    *
    * @param email the email of this subscription
    */
    public void setEmail(java.lang.String email) {
        _subscription.setEmail(email);
    }

    /**
    * Returns the subscription date of this subscription.
    *
    * @return the subscription date of this subscription
    */
    public java.util.Date getSubscriptionDate() {
        return _subscription.getSubscriptionDate();
    }

    /**
    * Sets the subscription date of this subscription.
    *
    * @param subscriptionDate the subscription date of this subscription
    */
    public void setSubscriptionDate(java.util.Date subscriptionDate) {
        _subscription.setSubscriptionDate(subscriptionDate);
    }

    public boolean isNew() {
        return _subscription.isNew();
    }

    public void setNew(boolean n) {
        _subscription.setNew(n);
    }

    public boolean isCachedModel() {
        return _subscription.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _subscription.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _subscription.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _subscription.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _subscription.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _subscription.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _subscription.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SubscriptionWrapper((Subscription) _subscription.clone());
    }

    public int compareTo(Subscription subscription) {
        return _subscription.compareTo(subscription);
    }

    @Override
    public int hashCode() {
        return _subscription.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Subscription> toCacheModel() {
        return _subscription.toCacheModel();
    }

    public Subscription toEscapedModel() {
        return new SubscriptionWrapper(_subscription.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _subscription.toString();
    }

    public java.lang.String toXmlString() {
        return _subscription.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _subscription.persist();
    }

    public boolean hasUser() {
        return _subscription.hasUser();
    }

    public com.liferay.portal.model.User getUser() {
        return _subscription.getUser();
    }

    public void setUser(com.liferay.portal.model.User user) {
        _subscription.setUser(user);
    }

    public java.lang.String getUserName() {
        return _subscription.getUserName();
    }

    public java.lang.String getEmailString() {
        return _subscription.getEmailString();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Subscription getWrappedSubscription() {
        return _subscription;
    }

    public Subscription getWrappedModel() {
        return _subscription;
    }

    public void resetOriginalValues() {
        _subscription.resetOriginalValues();
    }
}
