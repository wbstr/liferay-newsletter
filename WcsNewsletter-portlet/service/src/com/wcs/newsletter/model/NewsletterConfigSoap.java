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
public class NewsletterConfigSoap implements Serializable {
    private long _configId;
    private String _configKey;
    private String _configValue;

    public NewsletterConfigSoap() {
    }

    public static NewsletterConfigSoap toSoapModel(NewsletterConfig model) {
        NewsletterConfigSoap soapModel = new NewsletterConfigSoap();

        soapModel.setConfigId(model.getConfigId());
        soapModel.setConfigKey(model.getConfigKey());
        soapModel.setConfigValue(model.getConfigValue());

        return soapModel;
    }

    public static NewsletterConfigSoap[] toSoapModels(NewsletterConfig[] models) {
        NewsletterConfigSoap[] soapModels = new NewsletterConfigSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static NewsletterConfigSoap[][] toSoapModels(
        NewsletterConfig[][] models) {
        NewsletterConfigSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new NewsletterConfigSoap[models.length][models[0].length];
        } else {
            soapModels = new NewsletterConfigSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static NewsletterConfigSoap[] toSoapModels(
        List<NewsletterConfig> models) {
        List<NewsletterConfigSoap> soapModels = new ArrayList<NewsletterConfigSoap>(models.size());

        for (NewsletterConfig model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new NewsletterConfigSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _configId;
    }

    public void setPrimaryKey(long pk) {
        setConfigId(pk);
    }

    public long getConfigId() {
        return _configId;
    }

    public void setConfigId(long configId) {
        _configId = configId;
    }

    public String getConfigKey() {
        return _configKey;
    }

    public void setConfigKey(String configKey) {
        _configKey = configKey;
    }

    public String getConfigValue() {
        return _configValue;
    }

    public void setConfigValue(String configValue) {
        _configValue = configValue;
    }
}
