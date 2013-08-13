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

import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.service.persistence.SubscriptionCategoryPK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class SubscriptionCategoryClp extends BaseModelImpl<SubscriptionCategory>
    implements SubscriptionCategory {
    private long _subscriptionId;
    private long _categoryId;
    private String _confirmationKey;
    private String _cancellationKey;
    private String _status;
    private BaseModel<?> _subscriptionCategoryRemoteModel;

    public SubscriptionCategoryClp() {
    }

    public Class<?> getModelClass() {
        return SubscriptionCategory.class;
    }

    public String getModelClassName() {
        return SubscriptionCategory.class.getName();
    }

    public SubscriptionCategoryPK getPrimaryKey() {
        return new SubscriptionCategoryPK(_subscriptionId, _categoryId);
    }

    public void setPrimaryKey(SubscriptionCategoryPK primaryKey) {
        setSubscriptionId(primaryKey.subscriptionId);
        setCategoryId(primaryKey.categoryId);
    }

    public Serializable getPrimaryKeyObj() {
        return new SubscriptionCategoryPK(_subscriptionId, _categoryId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey((SubscriptionCategoryPK) primaryKeyObj);
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("subscriptionId", getSubscriptionId());
        attributes.put("categoryId", getCategoryId());
        attributes.put("confirmationKey", getConfirmationKey());
        attributes.put("cancellationKey", getCancellationKey());
        attributes.put("status", getStatus());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long subscriptionId = (Long) attributes.get("subscriptionId");

        if (subscriptionId != null) {
            setSubscriptionId(subscriptionId);
        }

        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String confirmationKey = (String) attributes.get("confirmationKey");

        if (confirmationKey != null) {
            setConfirmationKey(confirmationKey);
        }

        String cancellationKey = (String) attributes.get("cancellationKey");

        if (cancellationKey != null) {
            setCancellationKey(cancellationKey);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }
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

    public com.wcs.newsletter.model.Category getCategory() {
        throw new UnsupportedOperationException();
    }

    public com.wcs.newsletter.model.Subscription getSubscription() {
        throw new UnsupportedOperationException();
    }

    public boolean isConfirmed() {
        throw new UnsupportedOperationException();
    }

    public BaseModel<?> getSubscriptionCategoryRemoteModel() {
        return _subscriptionCategoryRemoteModel;
    }

    public void setSubscriptionCategoryRemoteModel(
        BaseModel<?> subscriptionCategoryRemoteModel) {
        _subscriptionCategoryRemoteModel = subscriptionCategoryRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            SubscriptionCategoryLocalServiceUtil.addSubscriptionCategory(this);
        } else {
            SubscriptionCategoryLocalServiceUtil.updateSubscriptionCategory(this);
        }
    }

    @Override
    public SubscriptionCategory toEscapedModel() {
        return (SubscriptionCategory) Proxy.newProxyInstance(SubscriptionCategory.class.getClassLoader(),
            new Class[] { SubscriptionCategory.class },
            new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SubscriptionCategoryClp clone = new SubscriptionCategoryClp();

        clone.setSubscriptionId(getSubscriptionId());
        clone.setCategoryId(getCategoryId());
        clone.setConfirmationKey(getConfirmationKey());
        clone.setCancellationKey(getCancellationKey());
        clone.setStatus(getStatus());

        return clone;
    }

    public int compareTo(SubscriptionCategory subscriptionCategory) {
        SubscriptionCategoryPK primaryKey = subscriptionCategory.getPrimaryKey();

        return getPrimaryKey().compareTo(primaryKey);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        SubscriptionCategoryClp subscriptionCategory = null;

        try {
            subscriptionCategory = (SubscriptionCategoryClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        SubscriptionCategoryPK primaryKey = subscriptionCategory.getPrimaryKey();

        if (getPrimaryKey().equals(primaryKey)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return getPrimaryKey().hashCode();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{subscriptionId=");
        sb.append(getSubscriptionId());
        sb.append(", categoryId=");
        sb.append(getCategoryId());
        sb.append(", confirmationKey=");
        sb.append(getConfirmationKey());
        sb.append(", cancellationKey=");
        sb.append(getCancellationKey());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.SubscriptionCategory");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>subscriptionId</column-name><column-value><![CDATA[");
        sb.append(getSubscriptionId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>confirmationKey</column-name><column-value><![CDATA[");
        sb.append(getConfirmationKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>cancellationKey</column-name><column-value><![CDATA[");
        sb.append(getCancellationKey());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
