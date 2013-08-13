package com.wcs.newsletter.model;

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
