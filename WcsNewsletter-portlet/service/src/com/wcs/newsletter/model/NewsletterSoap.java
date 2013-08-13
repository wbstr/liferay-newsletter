package com.wcs.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class NewsletterSoap implements Serializable {
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

    public NewsletterSoap() {
    }

    public static NewsletterSoap toSoapModel(Newsletter model) {
        NewsletterSoap soapModel = new NewsletterSoap();

        soapModel.setNewsletterId(model.getNewsletterId());
        soapModel.setSubject(model.getSubject());
        soapModel.setSender(model.getSender());
        soapModel.setContentId(model.getContentId());
        soapModel.setContentVersion(model.getContentVersion());
        soapModel.setTemplateId(model.getTemplateId());
        soapModel.setTemplateVersion(model.getTemplateVersion());
        soapModel.setParentId(model.getParentId());
        soapModel.setCreationTime(model.getCreationTime());
        soapModel.setState(model.getState());

        return soapModel;
    }

    public static NewsletterSoap[] toSoapModels(Newsletter[] models) {
        NewsletterSoap[] soapModels = new NewsletterSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static NewsletterSoap[][] toSoapModels(Newsletter[][] models) {
        NewsletterSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new NewsletterSoap[models.length][models[0].length];
        } else {
            soapModels = new NewsletterSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static NewsletterSoap[] toSoapModels(List<Newsletter> models) {
        List<NewsletterSoap> soapModels = new ArrayList<NewsletterSoap>(models.size());

        for (Newsletter model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NewsletterSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _newsletterId;
    }

    public void setPrimaryKey(long pk) {
        setNewsletterId(pk);
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
}
