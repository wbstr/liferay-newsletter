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

import com.wcs.newsletter.model.Category;

import java.io.Serializable;

/**
 * The cache model class for representing Category in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Category
 * @generated
 */
public class CategoryCacheModel implements CacheModel<Category>, Serializable {
    public long categoryId;
    public String name;
    public String locale;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(7);

        sb.append("{categoryId=");
        sb.append(categoryId);
        sb.append(", name=");
        sb.append(name);
        sb.append(", locale=");
        sb.append(locale);
        sb.append("}");

        return sb.toString();
    }

    public Category toEntityModel() {
        CategoryImpl categoryImpl = new CategoryImpl();

        categoryImpl.setCategoryId(categoryId);

        if (name == null) {
            categoryImpl.setName(StringPool.BLANK);
        } else {
            categoryImpl.setName(name);
        }

        if (locale == null) {
            categoryImpl.setLocale(StringPool.BLANK);
        } else {
            categoryImpl.setLocale(locale);
        }

        categoryImpl.resetOriginalValues();

        return categoryImpl;
    }
}
