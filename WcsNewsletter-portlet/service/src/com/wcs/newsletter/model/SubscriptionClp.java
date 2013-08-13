package com.wcs.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.wcs.newsletter.service.SubscriptionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SubscriptionClp extends BaseModelImpl<Subscription>
    implements Subscription {
    private long _subscriptionId;
    private long _userId;
    private String _userUuid;
    private String _email;
    private Date _subscriptionDate;
    private BaseModel<?> _subscriptionRemoteModel;

    public SubscriptionClp() {
    }

    public Class<?> getModelClass() {
        return Subscription.class;
    }

    public String getModelClassName() {
        return Subscription.class.getName();
    }

    public long getPrimaryKey() {
        return _subscriptionId;
    }

    public void setPrimaryKey(long primaryKey) {
        setSubscriptionId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_subscriptionId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subscriptionId", getSubscriptionId());
        attributes.put("userId", getUserId());
        attributes.put("email", getEmail());
        attributes.put("subscriptionDate", getSubscriptionDate());

        return attributes;
    }

    @Override
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

    public long getSubscriptionId() {
        return _subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        _subscriptionId = subscriptionId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public Date getSubscriptionDate() {
        return _subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        _subscriptionDate = subscriptionDate;
    }

    public void setUser(com.liferay.portal.model.User user) {
        throw new UnsupportedOperationException();
    }

    public com.liferay.portal.model.User getUser() {
        throw new UnsupportedOperationException();
    }

    public java.lang.String getEmailString() {
        throw new UnsupportedOperationException();
    }

    public java.lang.String getUserName() {
        throw new UnsupportedOperationException();
    }

    public boolean hasUser() {
        throw new UnsupportedOperationException();
    }

    public BaseModel<?> getSubscriptionRemoteModel() {
        return _subscriptionRemoteModel;
    }

    public void setSubscriptionRemoteModel(BaseModel<?> subscriptionRemoteModel) {
        _subscriptionRemoteModel = subscriptionRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            SubscriptionLocalServiceUtil.addSubscription(this);
        } else {
            SubscriptionLocalServiceUtil.updateSubscription(this);
        }
    }

    @Override
    public Subscription toEscapedModel() {
        return (Subscription) Proxy.newProxyInstance(Subscription.class.getClassLoader(),
            new Class[] { Subscription.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SubscriptionClp clone = new SubscriptionClp();

        clone.setSubscriptionId(getSubscriptionId());
        clone.setUserId(getUserId());
        clone.setEmail(getEmail());
        clone.setSubscriptionDate(getSubscriptionDate());

        return clone;
    }

    public int compareTo(Subscription subscription) {
        long primaryKey = subscription.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SubscriptionClp subscription = null;

        try {
            subscription = (SubscriptionClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = subscription.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{subscriptionId=");
        sb.append(getSubscriptionId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", subscriptionDate=");
        sb.append(getSubscriptionDate());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(16);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.Subscription");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>subscriptionId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subscriptionDate</column-name><column-value><![CDATA[");
        sb.append(getSubscriptionDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
