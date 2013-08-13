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
import com.liferay.portal.model.CacheModel;

import com.wcs.newsletter.model.Label;

import java.io.Serializable;

/**
 * The cache model class for representing Label in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Label
 * @generated
 */
public class LabelCacheModel implements CacheModel<Label>, Serializable {
    public long labelId;
    public long tagId;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(5);

        sb.append("{labelId=");
        sb.append(labelId);
        sb.append(", tagId=");
        sb.append(tagId);
        sb.append("}");

        return sb.toString();
    }

    public Label toEntityModel() {
        LabelImpl labelImpl = new LabelImpl();

        labelImpl.setLabelId(labelId);
        labelImpl.setTagId(tagId);

        labelImpl.resetOriginalValues();

        return labelImpl;
    }
}
