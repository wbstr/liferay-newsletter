package com.wcs.newsletter.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.wcs.newsletter.service.NewsletterLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class NewsletterClp extends BaseModelImpl<Newsletter>
    implements Newsletter {
    private long _newsletterId;
    private String _subject;
    private String _sender;
    private String _contentId;
    private String _contentVersion;
    private String _templateId;
    private String _templateVersion;
    private long _parentId;
    private Date _creationTime;
    private String _state;
    private BaseModel<?> _newsletterRemoteModel;

    public NewsletterClp() {
    }

    public Class<?> getModelClass() {
        return Newsletter.class;
    }

    public String getModelClassName() {
        return Newsletter.class.getName();
    }

    public long getPrimaryKey() {
        return _newsletterId;
    }

    public void setPrimaryKey(long primaryKey) {
        setNewsletterId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_newsletterId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
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

    @Override
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

    public long getNewsletterId() {
        return _newsletterId;
    }

    public void setNewsletterId(long newsletterId) {
        _newsletterId = newsletterId;
    }

    public String getSubject() {
        return _subject;
    }

    public void setSubject(String subject) {
        _subject = subject;
    }

    public String getSender() {
        return _sender;
    }

    public void setSender(String sender) {
        _sender = sender;
    }

    public String getContentId() {
        return _contentId;
    }

    public void setContentId(String contentId) {
        _contentId = contentId;
    }

    public String getContentVersion() {
        return _contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        _contentVersion = contentVersion;
    }

    public String getTemplateId() {
        return _templateId;
    }

    public void setTemplateId(String templateId) {
        _templateId = templateId;
    }

    public String getTemplateVersion() {
        return _templateVersion;
    }

    public void setTemplateVersion(String templateVersion) {
        _templateVersion = templateVersion;
    }

    public long getParentId() {
        return _parentId;
    }

    public void setParentId(long parentId) {
        _parentId = parentId;
    }

    public Date getCreationTime() {
        return _creationTime;
    }

    public void setCreationTime(Date creationTime) {
        _creationTime = creationTime;
    }

    public String getState() {
        return _state;
    }

    public void setState(String state) {
        _state = state;
    }

    public java.util.List<com.wcs.newsletter.model.Category> getCategories() {
        throw new UnsupportedOperationException();
    }

    public com.wcs.newsletter.model.Newsletter getChild() {
        throw new UnsupportedOperationException();
    }

    public com.liferay.portlet.journal.model.JournalArticle getJournalArticle(
        com.liferay.portal.theme.ThemeDisplay themeDisplay) {
        throw new UnsupportedOperationException();
    }

    public java.util.List<com.wcs.newsletter.model.Label> getLabels() {
        throw new UnsupportedOperationException();
    }

    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients() {
        throw new UnsupportedOperationException();
    }

    public void setLabels(java.util.List<com.wcs.newsletter.model.Label> labels) {
        throw new UnsupportedOperationException();
    }

    public boolean isRoot() {
        throw new UnsupportedOperationException();
    }

    public void setCategories(
        java.util.List<com.wcs.newsletter.model.Category> categories) {
        throw new UnsupportedOperationException();
    }

    public void setRecipients(
        java.util.List<com.wcs.newsletter.model.Recipient> recipients) {
        throw new UnsupportedOperationException();
    }

    public BaseModel<?> getNewsletterRemoteModel() {
        return _newsletterRemoteModel;
    }

    public void setNewsletterRemoteModel(BaseModel<?> newsletterRemoteModel) {
        _newsletterRemoteModel = newsletterRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            NewsletterLocalServiceUtil.addNewsletter(this);
        } else {
            NewsletterLocalServiceUtil.updateNewsletter(this);
        }
    }

    @Override
    public Newsletter toEscapedModel() {
        return (Newsletter) Proxy.newProxyInstance(Newsletter.class.getClassLoader(),
            new Class[] { Newsletter.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        NewsletterClp clone = new NewsletterClp();

        clone.setNewsletterId(getNewsletterId());
        clone.setSubject(getSubject());
        clone.setSender(getSender());
        clone.setContentId(getContentId());
        clone.setContentVersion(getContentVersion());
        clone.setTemplateId(getTemplateId());
        clone.setTemplateVersion(getTemplateVersion());
        clone.setParentId(getParentId());
        clone.setCreationTime(getCreationTime());
        clone.setState(getState());

        return clone;
    }

    public int compareTo(Newsletter newsletter) {
        long primaryKey = newsletter.getPrimaryKey();

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

        NewsletterClp newsletter = null;

        try {
            newsletter = (NewsletterClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = newsletter.getPrimaryKey();

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
        StringBundler sb = new StringBundler(21);

        sb.append("{newsletterId=");
        sb.append(getNewsletterId());
        sb.append(", subject=");
        sb.append(getSubject());
        sb.append(", sender=");
        sb.append(getSender());
        sb.append(", contentId=");
        sb.append(getContentId());
        sb.append(", contentVersion=");
        sb.append(getContentVersion());
        sb.append(", templateId=");
        sb.append(getTemplateId());
        sb.append(", templateVersion=");
        sb.append(getTemplateVersion());
        sb.append(", parentId=");
        sb.append(getParentId());
        sb.append(", creationTime=");
        sb.append(getCreationTime());
        sb.append(", state=");
        sb.append(getState());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.Newsletter");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>newsletterId</column-name><column-value><![CDATA[");
        sb.append(getNewsletterId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>subject</column-name><column-value><![CDATA[");
        sb.append(getSubject());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>sender</column-name><column-value><![CDATA[");
        sb.append(getSender());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contentId</column-name><column-value><![CDATA[");
        sb.append(getContentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contentVersion</column-name><column-value><![CDATA[");
        sb.append(getContentVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>templateId</column-name><column-value><![CDATA[");
        sb.append(getTemplateId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>templateVersion</column-name><column-value><![CDATA[");
        sb.append(getTemplateVersion());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>parentId</column-name><column-value><![CDATA[");
        sb.append(getParentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>creationTime</column-name><column-value><![CDATA[");
        sb.append(getCreationTime());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>state</column-name><column-value><![CDATA[");
        sb.append(getState());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
