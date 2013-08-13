package com.wcs.newsletter.model;

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link NewsletterConfig}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       NewsletterConfig
 * @generated
 */
public class NewsletterConfigWrapper implements NewsletterConfig,
    ModelWrapper<NewsletterConfig> {
    private NewsletterConfig _newsletterConfig;

    public NewsletterConfigWrapper(NewsletterConfig newsletterConfig) {
        _newsletterConfig = newsletterConfig;
    }

    public Class<?> getModelClass() {
        return NewsletterConfig.class;
    }

    public String getModelClassName() {
        return NewsletterConfig.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("configId", getConfigId());
        attributes.put("configKey", getConfigKey());
        attributes.put("configValue", getConfigValue());

        return attributes;
    }

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

    /**
    * Returns the primary key of this newsletter config.
    *
    * @return the primary key of this newsletter config
    */
    public long getPrimaryKey() {
        return _newsletterConfig.getPrimaryKey();
    }

    /**
    * Sets the primary key of this newsletter config.
    *
    * @param primaryKey the primary key of this newsletter config
    */
    public void setPrimaryKey(long primaryKey) {
        _newsletterConfig.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the config ID of this newsletter config.
    *
    * @return the config ID of this newsletter config
    */
    public long getConfigId() {
        return _newsletterConfig.getConfigId();
    }

    /**
    * Sets the config ID of this newsletter config.
    *
    * @param configId the config ID of this newsletter config
    */
    public void setConfigId(long configId) {
        _newsletterConfig.setConfigId(configId);
    }

    /**
    * Returns the config key of this newsletter config.
    *
    * @return the config key of this newsletter config
    */
    public java.lang.String getConfigKey() {
        return _newsletterConfig.getConfigKey();
    }

    /**
    * Sets the config key of this newsletter config.
    *
    * @param configKey the config key of this newsletter config
    */
    public void setConfigKey(java.lang.String configKey) {
        _newsletterConfig.setConfigKey(configKey);
    }

    /**
    * Returns the config value of this newsletter config.
    *
    * @return the config value of this newsletter config
    */
    public java.lang.String getConfigValue() {
        return _newsletterConfig.getConfigValue();
    }

    /**
    * Sets the config value of this newsletter config.
    *
    * @param configValue the config value of this newsletter config
    */
    public void setConfigValue(java.lang.String configValue) {
        _newsletterConfig.setConfigValue(configValue);
    }

    public boolean isNew() {
        return _newsletterConfig.isNew();
    }

    public void setNew(boolean n) {
        _newsletterConfig.setNew(n);
    }

    public boolean isCachedModel() {
        return _newsletterConfig.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _newsletterConfig.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _newsletterConfig.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _newsletterConfig.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _newsletterConfig.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _newsletterConfig.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _newsletterConfig.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new NewsletterConfigWrapper((NewsletterConfig) _newsletterConfig.clone());
    }

    public int compareTo(NewsletterConfig newsletterConfig) {
        return _newsletterConfig.compareTo(newsletterConfig);
    }

    @Override
    public int hashCode() {
        return _newsletterConfig.hashCode();
    }

    public com.liferay.portal.model.CacheModel<NewsletterConfig> toCacheModel() {
        return _newsletterConfig.toCacheModel();
    }

    public NewsletterConfig toEscapedModel() {
        return new NewsletterConfigWrapper(_newsletterConfig.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _newsletterConfig.toString();
    }

    public java.lang.String toXmlString() {
        return _newsletterConfig.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _newsletterConfig.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public NewsletterConfig getWrappedNewsletterConfig() {
        return _newsletterConfig;
    }

    public NewsletterConfig getWrappedModel() {
        return _newsletterConfig;
    }

    public void resetOriginalValues() {
        _newsletterConfig.resetOriginalValues();
    }
}
