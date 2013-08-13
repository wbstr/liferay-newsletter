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
