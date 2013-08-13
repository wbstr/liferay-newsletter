package com.wcs.newsletter.model;

/*
 * #%L
 * Webstar Newsletter
 * %%
 * Copyright (C) 2013 Webstar Csoport Kft.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public 
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

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
