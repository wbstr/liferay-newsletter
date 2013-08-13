package com.wcs.newsletter.model;

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
