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
public class SubscriptionSoap implements Serializable {
    private long _subscriptionId;
    private long _userId;
    private String _email;
    private Date _subscriptionDate;

    public SubscriptionSoap() {
    }

    public static SubscriptionSoap toSoapModel(Subscription model) {
        SubscriptionSoap soapModel = new SubscriptionSoap();

        soapModel.setSubscriptionId(model.getSubscriptionId());
        soapModel.setUserId(model.getUserId());
        soapModel.setEmail(model.getEmail());
        soapModel.setSubscriptionDate(model.getSubscriptionDate());

        return soapModel;
    }

    public static SubscriptionSoap[] toSoapModels(Subscription[] models) {
        SubscriptionSoap[] soapModels = new SubscriptionSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SubscriptionSoap[][] toSoapModels(Subscription[][] models) {
        SubscriptionSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SubscriptionSoap[models.length][models[0].length];
        } else {
            soapModels = new SubscriptionSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SubscriptionSoap[] toSoapModels(List<Subscription> models) {
        List<SubscriptionSoap> soapModels = new ArrayList<SubscriptionSoap>(models.size());

        for (Subscription model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SubscriptionSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _subscriptionId;
    }

    public void setPrimaryKey(long pk) {
        setSubscriptionId(pk);
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
}
