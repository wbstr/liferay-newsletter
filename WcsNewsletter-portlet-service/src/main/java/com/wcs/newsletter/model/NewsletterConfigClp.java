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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.wcs.newsletter.service.NewsletterConfigLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class NewsletterConfigClp extends BaseModelImpl<NewsletterConfig>
    implements NewsletterConfig {
    private long _configId;
    private String _configKey;
    private String _configValue;
    private BaseModel<?> _newsletterConfigRemoteModel;

    public NewsletterConfigClp() {
    }

    public Class<?> getModelClass() {
        return NewsletterConfig.class;
    }

    public String getModelClassName() {
        return NewsletterConfig.class.getName();
    }

    public long getPrimaryKey() {
        return _configId;
    }

    public void setPrimaryKey(long primaryKey) {
        setConfigId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_configId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("configId", getConfigId());
        attributes.put("configKey", getConfigKey());
        attributes.put("configValue", getConfigValue());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long configId = (Long) attributes.get("configId");

        if (configId != null) {
            setConfigId(configId);
        }

        String configKey = (String) attributes.get("configKey");

        if (configKey != null) {
            setConfigKey(configKey);
        }

        String configValue = (String) attributes.get("configValue");

        if (configValue != null) {
            setConfigValue(configValue);
        }
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

    public BaseModel<?> getNewsletterConfigRemoteModel() {
        return _newsletterConfigRemoteModel;
    }

    public void setNewsletterConfigRemoteModel(
        BaseModel<?> newsletterConfigRemoteModel) {
        _newsletterConfigRemoteModel = newsletterConfigRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            NewsletterConfigLocalServiceUtil.addNewsletterConfig(this);
        } else {
            NewsletterConfigLocalServiceUtil.updateNewsletterConfig(this);
        }
    }

    @Override
    public NewsletterConfig toEscapedModel() {
        return (NewsletterConfig) Proxy.newProxyInstance(NewsletterConfig.class.getClassLoader(),
            new Class[] { NewsletterConfig.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        NewsletterConfigClp clone = new NewsletterConfigClp();

        clone.setConfigId(getConfigId());
        clone.setConfigKey(getConfigKey());
        clone.setConfigValue(getConfigValue());

        return clone;
    }

    public int compareTo(NewsletterConfig newsletterConfig) {
        long primaryKey = newsletterConfig.getPrimaryKey();

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

        NewsletterConfigClp newsletterConfig = null;

        try {
            newsletterConfig = (NewsletterConfigClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = newsletterConfig.getPrimaryKey();

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
        StringBundler sb = new StringBundler(7);

        sb.append("{configId=");
        sb.append(getConfigId());
        sb.append(", configKey=");
        sb.append(getConfigKey());
        sb.append(", configValue=");
        sb.append(getConfigValue());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.NewsletterConfig");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>configId</column-name><column-value><![CDATA[");
        sb.append(getConfigId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>configKey</column-name><column-value><![CDATA[");
        sb.append(getConfigKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>configValue</column-name><column-value><![CDATA[");
        sb.append(getConfigValue());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
