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
 * This class is a wrapper for {@link Label}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       Label
 * @generated
 */
public class LabelWrapper implements Label, ModelWrapper<Label> {
    private Label _label;

    public LabelWrapper(Label label) {
        _label = label;
    }

    public Class<?> getModelClass() {
        return Label.class;
    }

    public String getModelClassName() {
        return Label.class.getName();
    }

    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("labelId", getLabelId());
        attributes.put("tagId", getTagId());

        return attributes;
    }

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

    /**
    * Returns the primary key of this label.
    *
    * @return the primary key of this label
    */
    public long getPrimaryKey() {
        return _label.getPrimaryKey();
    }

    /**
    * Sets the primary key of this label.
    *
    * @param primaryKey the primary key of this label
    */
    public void setPrimaryKey(long primaryKey) {
        _label.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the label ID of this label.
    *
    * @return the label ID of this label
    */
    public long getLabelId() {
        return _label.getLabelId();
    }

    /**
    * Sets the label ID of this label.
    *
    * @param labelId the label ID of this label
    */
    public void setLabelId(long labelId) {
        _label.setLabelId(labelId);
    }

    /**
    * Returns the tag ID of this label.
    *
    * @return the tag ID of this label
    */
    public long getTagId() {
        return _label.getTagId();
    }

    /**
    * Sets the tag ID of this label.
    *
    * @param tagId the tag ID of this label
    */
    public void setTagId(long tagId) {
        _label.setTagId(tagId);
    }

    public boolean isNew() {
        return _label.isNew();
    }

    public void setNew(boolean n) {
        _label.setNew(n);
    }

    public boolean isCachedModel() {
        return _label.isCachedModel();
    }

    public void setCachedModel(boolean cachedModel) {
        _label.setCachedModel(cachedModel);
    }

    public boolean isEscapedModel() {
        return _label.isEscapedModel();
    }

    public java.io.Serializable getPrimaryKeyObj() {
        return _label.getPrimaryKeyObj();
    }

    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _label.setPrimaryKeyObj(primaryKeyObj);
    }

    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _label.getExpandoBridge();
    }

    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _label.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new LabelWrapper((Label) _label.clone());
    }

    public int compareTo(Label label) {
        return _label.compareTo(label);
    }

    @Override
    public int hashCode() {
        return _label.hashCode();
    }

    public com.liferay.portal.model.CacheModel<Label> toCacheModel() {
        return _label.toCacheModel();
    }

    public Label toEscapedModel() {
        return new LabelWrapper(_label.toEscapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _label.toString();
    }

    public java.lang.String toXmlString() {
        return _label.toXmlString();
    }

    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _label.persist();
    }

    /**
     * @deprecated Renamed to {@link #getWrappedModel}
     */
    public Label getWrappedLabel() {
        return _label;
    }

    public Label getWrappedModel() {
        return _label;
    }

    public void resetOriginalValues() {
        _label.resetOriginalValues();
    }
}
