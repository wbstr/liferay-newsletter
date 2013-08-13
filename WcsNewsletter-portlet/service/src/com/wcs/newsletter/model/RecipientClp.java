package com.wcs.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.wcs.newsletter.service.RecipientLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class RecipientClp extends BaseModelImpl<Recipient> implements Recipient {
    private long _recipientId;
    private long _newsletterId;
    private String _email;
    private String _status;
    private String _errorMessage;
    private BaseModel<?> _recipientRemoteModel;

    public RecipientClp() {
    }

    public Class<?> getModelClass() {
        return Recipient.class;
    }

    public String getModelClassName() {
        return Recipient.class.getName();
    }

    public long getPrimaryKey() {
        return _recipientId;
    }

    public void setPrimaryKey(long primaryKey) {
        setRecipientId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_recipientId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("recipientId", getRecipientId());
        attributes.put("newsletterId", getNewsletterId());
        attributes.put("email", getEmail());
        attributes.put("status", getStatus());
        attributes.put("errorMessage", getErrorMessage());

        return attributes;
    }

    @Override
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

    public long getRecipientId() {
        return _recipientId;
    }

    public void setRecipientId(long recipientId) {
        _recipientId = recipientId;
    }

    public long getNewsletterId() {
        return _newsletterId;
    }

    public void setNewsletterId(long newsletterId) {
        _newsletterId = newsletterId;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public String getErrorMessage() {
        return _errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        _errorMessage = errorMessage;
    }

    public BaseModel<?> getRecipientRemoteModel() {
        return _recipientRemoteModel;
    }

    public void setRecipientRemoteModel(BaseModel<?> recipientRemoteModel) {
        _recipientRemoteModel = recipientRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            RecipientLocalServiceUtil.addRecipient(this);
        } else {
            RecipientLocalServiceUtil.updateRecipient(this);
        }
    }

    @Override
    public Recipient toEscapedModel() {
        return (Recipient) Proxy.newProxyInstance(Recipient.class.getClassLoader(),
            new Class[] { Recipient.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        RecipientClp clone = new RecipientClp();

        clone.setRecipientId(getRecipientId());
        clone.setNewsletterId(getNewsletterId());
        clone.setEmail(getEmail());
        clone.setStatus(getStatus());
        clone.setErrorMessage(getErrorMessage());

        return clone;
    }

    public int compareTo(Recipient recipient) {
        long primaryKey = recipient.getPrimaryKey();

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

        RecipientClp recipient = null;

        try {
            recipient = (RecipientClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = recipient.getPrimaryKey();

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
        StringBundler sb = new StringBundler(11);

        sb.append("{recipientId=");
        sb.append(getRecipientId());
        sb.append(", newsletterId=");
        sb.append(getNewsletterId());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", errorMessage=");
        sb.append(getErrorMessage());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.Recipient");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>recipientId</column-name><column-value><![CDATA[");
        sb.append(getRecipientId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>newsletterId</column-name><column-value><![CDATA[");
        sb.append(getNewsletterId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>errorMessage</column-name><column-value><![CDATA[");
        sb.append(getErrorMessage());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
