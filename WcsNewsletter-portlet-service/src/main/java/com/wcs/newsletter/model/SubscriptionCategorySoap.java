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

import com.wcs.newsletter.service.persistence.SubscriptionCategoryPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Brian Wing Shun Chan
 * @generated
 */
public class SubscriptionCategorySoap implements Serializable {
    private long _subscriptionId;
    private long _categoryId;
    private String _confirmationKey;
    private String _cancellationKey;
    private String _status;

    public SubscriptionCategorySoap() {
    }

    public static SubscriptionCategorySoap toSoapModel(
        SubscriptionCategory model) {
        SubscriptionCategorySoap soapModel = new SubscriptionCategorySoap();

        soapModel.setSubscriptionId(model.getSubscriptionId());
        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setConfirmationKey(model.getConfirmationKey());
        soapModel.setCancellationKey(model.getCancellationKey());
        soapModel.setStatus(model.getStatus());

        return soapModel;
    }

    public static SubscriptionCategorySoap[] toSoapModels(
        SubscriptionCategory[] models) {
        SubscriptionCategorySoap[] soapModels = new SubscriptionCategorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SubscriptionCategorySoap[][] toSoapModels(
        SubscriptionCategory[][] models) {
        SubscriptionCategorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SubscriptionCategorySoap[models.length][models[0].length];
        } else {
            soapModels = new SubscriptionCategorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SubscriptionCategorySoap[] toSoapModels(
        List<SubscriptionCategory> models) {
        List<SubscriptionCategorySoap> soapModels = new ArrayList<SubscriptionCategorySoap>(models.size());

        for (SubscriptionCategory model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SubscriptionCategorySoap[soapModels.size()]);
    }

    public SubscriptionCategoryPK getPrimaryKey() {
        return new SubscriptionCategoryPK(_subscriptionId, _categoryId);
    }

    public void setPrimaryKey(SubscriptionCategoryPK pk) {
        setSubscriptionId(pk.subscriptionId);
        setCategoryId(pk.categoryId);
    }

    public long getSubscriptionId() {
        return _subscriptionId;
    }

    public void setSubscriptionId(long subscriptionId) {
        _subscriptionId = subscriptionId;
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public String getConfirmationKey() {
        return _confirmationKey;
    }

    public void setConfirmationKey(String confirmationKey) {
        _confirmationKey = confirmationKey;
    }

    public String getCancellationKey() {
        return _cancellationKey;
    }

    public void setCancellationKey(String cancellationKey) {
        _cancellationKey = cancellationKey;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }
}
