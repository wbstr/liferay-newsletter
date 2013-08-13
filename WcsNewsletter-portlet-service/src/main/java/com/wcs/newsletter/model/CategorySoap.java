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
public class CategorySoap implements Serializable {
    private long _categoryId;
    private String _name;
    private String _locale;

    public CategorySoap() {
    }

    public static CategorySoap toSoapModel(Category model) {
        CategorySoap soapModel = new CategorySoap();

        soapModel.setCategoryId(model.getCategoryId());
        soapModel.setName(model.getName());
        soapModel.setLocale(model.getLocale());

        return soapModel;
    }

    public static CategorySoap[] toSoapModels(Category[] models) {
        CategorySoap[] soapModels = new CategorySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CategorySoap[][] toSoapModels(Category[][] models) {
        CategorySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CategorySoap[models.length][models[0].length];
        } else {
            soapModels = new CategorySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CategorySoap[] toSoapModels(List<Category> models) {
        List<CategorySoap> soapModels = new ArrayList<CategorySoap>(models.size());

        for (Category model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CategorySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _categoryId;
    }

    public void setPrimaryKey(long pk) {
        setCategoryId(pk);
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
}
