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

import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Category}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Category
 * @generated
 */
public class CategoryWrapper implements Category, ModelWrapper<Category> {
    private Category _category;

    public CategoryWrapper(Category category) {
        _category = category;
    }

    public Class<?> getModelClass() {
        return Category.class;
    }

    public String getModelClassName() {
        return Category.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("categoryId", getCategoryId());
        attributes.put("name", getName());
        attributes.put("locale", getLocale());

        return attributes;
    }

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

    /**
    * Returns the primary key of this category.
    *
    * @return the primary key of this category
    */
    public long getPrimaryKey() {
        return _category.getPrimaryKey();
    }

    /**
    * Sets the primary key of this category.
    *
    * @param primaryKey the primary key of this category
    */
    public void setPrimaryKey(long primaryKey) {
        _category.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the category ID of this category.
    *
    * @return the category ID of this category
    */
    public long getCategoryId() {
        return _category.getCategoryId();
    }

    /**
    * Sets the category ID of this category.
    *
    * @param categoryId the category ID of this category
    */
    public void setCategoryId(long categoryId) {
        _category.setCategoryId(categoryId);
    }

    /**
    * Returns the name of this category.
    *
    * @return the name of this category
    */
    public java.lang.String getName() {
        return _category.getName();
    }

    /**
    * Sets the name of this category.
    *
    * @param name the name of this category
    */
    public void setName(java.lang.String name) {
        _category.setName(name);
    }

    /**
    * Returns the locale of this category.
    *
    * @return the locale of this category
    */
    public java.lang.String getLocale() {
        return _category.getLocale();
    }

    /**
    * Sets the locale of this category.
    *
    * @param locale the locale of this category
    */
    public void setLocale(java.lang.String locale) {
        _category.setLocale(locale);
    }

    public boolean isNew() {
        return _category.isNew();
    }

    public void setNew(boolean n) {
        _category.setNew(n);
    }

    public boolean isCachedModel() {
        return _category.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _category.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _category.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _category.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _category.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _category.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _category.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CategoryWrapper((Category) _category.clone());
    }

    public int compareTo(Category category) {
        return _category.compareTo(category);
    }

    @Override
    public int hashCode() {
        return _category.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Category> toCacheModel() {
        return _category.toCacheModel();
    }

    public Category toEscapedModel() {
        return new CategoryWrapper(_category.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _category.toString();
    }

    public java.lang.String toXmlString() {
        return _category.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _category.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Category getWrappedCategory() {
        return _category;
    }

    public Category getWrappedModel() {
        return _category;
    }

    public void resetOriginalValues() {
        _category.resetOriginalValues();
    }
}
