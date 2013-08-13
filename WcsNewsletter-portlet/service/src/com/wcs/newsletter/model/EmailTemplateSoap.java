package com.wcs.newsletter.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class EmailTemplateSoap implements Serializable {
    private long _emailTemplateId;
    private long _fileEntryId;

    public EmailTemplateSoap() {
    }

    public static EmailTemplateSoap toSoapModel(EmailTemplate model) {
        EmailTemplateSoap soapModel = new EmailTemplateSoap();

        soapModel.setEmailTemplateId(model.getEmailTemplateId());
        soapModel.setFileEntryId(model.getFileEntryId());

        return soapModel;
    }

    public static EmailTemplateSoap[] toSoapModels(EmailTemplate[] models) {
        EmailTemplateSoap[] soapModels = new EmailTemplateSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EmailTemplateSoap[][] toSoapModels(EmailTemplate[][] models) {
        EmailTemplateSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EmailTemplateSoap[models.length][models[0].length];
        } else {
            soapModels = new EmailTemplateSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EmailTemplateSoap[] toSoapModels(List<EmailTemplate> models) {
        List<EmailTemplateSoap> soapModels = new ArrayList<EmailTemplateSoap>(models.size());

        for (EmailTemplate model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EmailTemplateSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _emailTemplateId;
    }

    public void setPrimaryKey(long pk) {
        setEmailTemplateId(pk);
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
}
