package com.wcs.newsletter.model.impl;

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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.wcs.newsletter.model.NewsletterConfig;

import java.io.Serializable;

/**
 * The cache model class for representing NewsletterConfig in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterConfig
 * @generated
 */
public class NewsletterConfigCacheModel implements CacheModel<NewsletterConfig>,
    Serializable {
    public long configId;
    public String configKey;
    public String configValue;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{configId=");
        sb.append(configId);
        sb.append(", configKey=");
        sb.append(configKey);
        sb.append(", configValue=");
        sb.append(configValue);
        sb.append("}");

        return sb.toString();
    }

    public NewsletterConfig toEntityModel() {
        NewsletterConfigImpl newsletterConfigImpl = new NewsletterConfigImpl();

        newsletterConfigImpl.setConfigId(configId);

        if (configKey == null) {
            newsletterConfigImpl.setConfigKey(StringPool.BLANK);
        } else {
            newsletterConfigImpl.setConfigKey(configKey);
        }

        if (configValue == null) {
            newsletterConfigImpl.setConfigValue(StringPool.BLANK);
        } else {
            newsletterConfigImpl.setConfigValue(configValue);
        }

        newsletterConfigImpl.resetOriginalValues();

        return newsletterConfigImpl;
    }
}
