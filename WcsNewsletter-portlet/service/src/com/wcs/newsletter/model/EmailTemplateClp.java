package com.wcs.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.wcs.newsletter.service.EmailTemplateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class EmailTemplateClp extends BaseModelImpl<EmailTemplate>
    implements EmailTemplate {
    private long _emailTemplateId;
    private long _fileEntryId;
    private BaseModel<?> _emailTemplateRemoteModel;

    public EmailTemplateClp() {
    }

    public Class<?> getModelClass() {
        return EmailTemplate.class;
    }

    public String getModelClassName() {
        return EmailTemplate.class.getName();
    }

    public long getPrimaryKey() {
        return _emailTemplateId;
    }

    public void setPrimaryKey(long primaryKey) {
        setEmailTemplateId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_emailTemplateId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("emailTemplateId", getEmailTemplateId());
        attributes.put("fileEntryId", getFileEntryId());

        return attributes;
    }

    @Override
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

    public long getEmailTemplateId() {
        return _emailTemplateId;
    }

    public void setEmailTemplateId(long emailTemplateId) {
        _emailTemplateId = emailTemplateId;
    }

    public long getFileEntryId() {
        return _fileEntryId;
    }

    public void setFileEntryId(long fileEntryId) {
        _fileEntryId = fileEntryId;
    }

    public BaseModel<?> getEmailTemplateRemoteModel() {
        return _emailTemplateRemoteModel;
    }

    public void setEmailTemplateRemoteModel(
        BaseModel<?> emailTemplateRemoteModel) {
        _emailTemplateRemoteModel = emailTemplateRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            EmailTemplateLocalServiceUtil.addEmailTemplate(this);
        } else {
            EmailTemplateLocalServiceUtil.updateEmailTemplate(this);
        }
    }

    @Override
    public EmailTemplate toEscapedModel() {
        return (EmailTemplate) Proxy.newProxyInstance(EmailTemplate.class.getClassLoader(),
            new Class[] { EmailTemplate.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        EmailTemplateClp clone = new EmailTemplateClp();

        clone.setEmailTemplateId(getEmailTemplateId());
        clone.setFileEntryId(getFileEntryId());

        return clone;
    }

    public int compareTo(EmailTemplate emailTemplate) {
        long primaryKey = emailTemplate.getPrimaryKey();

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

        EmailTemplateClp emailTemplate = null;

        try {
            emailTemplate = (EmailTemplateClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = emailTemplate.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{emailTemplateId=");
        sb.append(getEmailTemplateId());
        sb.append(", fileEntryId=");
        sb.append(getFileEntryId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.EmailTemplate");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>emailTemplateId</column-name><column-value><![CDATA[");
        sb.append(getEmailTemplateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
        sb.append(getFileEntryId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
