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
public class RecipientSoap implements Serializable {
    private long _recipientId;
    private long _newsletterId;
    private String _email;
    private String _status;
    private String _errorMessage;

    public RecipientSoap() {
    }

    public static RecipientSoap toSoapModel(Recipient model) {
        RecipientSoap soapModel = new RecipientSoap();

        soapModel.setRecipientId(model.getRecipientId());
        soapModel.setNewsletterId(model.getNewsletterId());
        soapModel.setEmail(model.getEmail());
        soapModel.setStatus(model.getStatus());
        soapModel.setErrorMessage(model.getErrorMessage());

        return soapModel;
    }

    public static RecipientSoap[] toSoapModels(Recipient[] models) {
        RecipientSoap[] soapModels = new RecipientSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static RecipientSoap[][] toSoapModels(Recipient[][] models) {
        RecipientSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new RecipientSoap[models.length][models[0].length];
        } else {
            soapModels = new RecipientSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static RecipientSoap[] toSoapModels(List<Recipient> models) {
        List<RecipientSoap> soapModels = new ArrayList<RecipientSoap>(models.size());

        for (Recipient model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new RecipientSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _recipientId;
    }

    public void setPrimaryKey(long pk) {
        setRecipientId(pk);
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
}
