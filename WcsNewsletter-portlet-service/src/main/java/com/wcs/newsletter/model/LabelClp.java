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

import com.wcs.newsletter.service.LabelLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class LabelClp extends BaseModelImpl<Label> implements Label {
    private long _labelId;
    private long _tagId;
    private BaseModel<?> _labelRemoteModel;

    public LabelClp() {
    }

    public Class<?> getModelClass() {
        return Label.class;
    }

    public String getModelClassName() {
        return Label.class.getName();
    }

    public long getPrimaryKey() {
        return _labelId;
    }

    public void setPrimaryKey(long primaryKey) {
        setLabelId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_labelId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("labelId", getLabelId());
        attributes.put("tagId", getTagId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long labelId = (Long) attributes.get("labelId");

        if (labelId != null) {
            setLabelId(labelId);
        }

        Long tagId = (Long) attributes.get("tagId");

        if (tagId != null) {
            setTagId(tagId);
        }
    }

    public long getLabelId() {
        return _labelId;
    }

    public void setLabelId(long labelId) {
        _labelId = labelId;
    }

    public long getTagId() {
        return _tagId;
    }

    public void setTagId(long tagId) {
        _tagId = tagId;
    }

    public BaseModel<?> getLabelRemoteModel() {
        return _labelRemoteModel;
    }

    public void setLabelRemoteModel(BaseModel<?> labelRemoteModel) {
        _labelRemoteModel = labelRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            LabelLocalServiceUtil.addLabel(this);
        } else {
            LabelLocalServiceUtil.updateLabel(this);
        }
    }

    @Override
    public Label toEscapedModel() {
        return (Label) Proxy.newProxyInstance(Label.class.getClassLoader(),
            new Class[] { Label.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        LabelClp clone = new LabelClp();

        clone.setLabelId(getLabelId());
        clone.setTagId(getTagId());

        return clone;
    }

    public int compareTo(Label label) {
        long primaryKey = label.getPrimaryKey();

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

        LabelClp label = null;

        try {
            label = (LabelClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = label.getPrimaryKey();

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
        StringBundler sb = new StringBundler(5);

        sb.append("{labelId=");
        sb.append(getLabelId());
        sb.append(", tagId=");
        sb.append(getTagId());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(10);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.Label");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>labelId</column-name><column-value><![CDATA[");
        sb.append(getLabelId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tagId</column-name><column-value><![CDATA[");
        sb.append(getTagId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
