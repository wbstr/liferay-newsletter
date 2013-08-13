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
public class LabelSoap implements Serializable {
    private long _labelId;
    private long _tagId;

    public LabelSoap() {
    }

    public static LabelSoap toSoapModel(Label model) {
        LabelSoap soapModel = new LabelSoap();

        soapModel.setLabelId(model.getLabelId());
        soapModel.setTagId(model.getTagId());

        return soapModel;
    }

    public static LabelSoap[] toSoapModels(Label[] models) {
        LabelSoap[] soapModels = new LabelSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static LabelSoap[][] toSoapModels(Label[][] models) {
        LabelSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new LabelSoap[models.length][models[0].length];
        } else {
            soapModels = new LabelSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static LabelSoap[] toSoapModels(List<Label> models) {
        List<LabelSoap> soapModels = new ArrayList<LabelSoap>(models.size());

        for (Label model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new LabelSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _labelId;
    }

    public void setPrimaryKey(long pk) {
        setLabelId(pk);
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
}
