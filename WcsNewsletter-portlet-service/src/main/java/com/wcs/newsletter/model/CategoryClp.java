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

import com.wcs.newsletter.service.CategoryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;


public class CategoryClp extends BaseModelImpl<Category> implements Category {
    private long _categoryId;
    private String _name;
    private String _locale;
    private BaseModel<?> _categoryRemoteModel;

    public CategoryClp() {
    }

    public Class<?> getModelClass() {
        return Category.class;
    }

    public String getModelClassName() {
        return Category.class.getName();
    }

    public long getPrimaryKey() {
        return _categoryId;
    }

    public void setPrimaryKey(long primaryKey) {
        setCategoryId(primaryKey);
    }

    public Serializable getPrimaryKeyObj() {
        return new Long(_categoryId);
    }

    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("categoryId", getCategoryId());
        attributes.put("name", getName());
        attributes.put("locale", getLocale());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long categoryId = (Long) attributes.get("categoryId");

        if (categoryId != null) {
            setCategoryId(categoryId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String locale = (String) attributes.get("locale");

        if (locale != null) {
            setLocale(locale);
        }
    }

    public long getCategoryId() {
        return _categoryId;
    }

    public void setCategoryId(long categoryId) {
        _categoryId = categoryId;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getLocale() {
        return _locale;
    }

    public void setLocale(String locale) {
        _locale = locale;
    }

    public BaseModel<?> getCategoryRemoteModel() {
        return _categoryRemoteModel;
    }

    public void setCategoryRemoteModel(BaseModel<?> categoryRemoteModel) {
        _categoryRemoteModel = categoryRemoteModel;
    }

    public void persist() throws SystemException {
        if (this.isNew()) {
            CategoryLocalServiceUtil.addCategory(this);
        } else {
            CategoryLocalServiceUtil.updateCategory(this);
        }
    }

    @Override
    public Category toEscapedModel() {
        return (Category) Proxy.newProxyInstance(Category.class.getClassLoader(),
            new Class[] { Category.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CategoryClp clone = new CategoryClp();

        clone.setCategoryId(getCategoryId());
        clone.setName(getName());
        clone.setLocale(getLocale());

        return clone;
    }

    public int compareTo(Category category) {
        long primaryKey = category.getPrimaryKey();

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

        CategoryClp category = null;

        try {
            category = (CategoryClp) obj;
        } catch (ClassCastException cce) {
            return false;
        }

        long primaryKey = category.getPrimaryKey();

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

        sb.append("{categoryId=");
        sb.append(getCategoryId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", locale=");
        sb.append(getLocale());
        sb.append("}");

        return sb.toString();
    }

    public String toXmlString() {
        StringBundler sb = new StringBundler(13);

        sb.append("<model><model-name>");
        sb.append("com.wcs.newsletter.model.Category");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>categoryId</column-name><column-value><![CDATA[");
        sb.append(getCategoryId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>locale</column-name><column-value><![CDATA[");
        sb.append(getLocale());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
