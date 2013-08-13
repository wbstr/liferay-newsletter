package com.wcs.newsletter.dto;

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

import com.wcs.tool.StringUtil;
import java.io.Serializable;

public class CategoryListElem implements ModelElem, Serializable {

    private long id;
    private String name;
    private String localeStr;
    private String localizedLocaleStr;
    private String subscribed;

    public CategoryListElem(long id, String name, String localeStr, String localizedLocaleStr, long subscribed) {
        this.id = id;
        this.name = StringUtil.toString(name);
        this.subscribed = StringUtil.toString(subscribed);
        this.localizedLocaleStr = StringUtil.toString(localizedLocaleStr);
        this.localeStr = StringUtil.toString(localeStr);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSubscribed() {
        return subscribed;
    }

    public String getLocaleStr() {
        return localeStr;
    }

    public String getLocalizedLocaleStr() {
        return localizedLocaleStr;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CategoryListElem other = (CategoryListElem) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public String getRowKey() {
        return StringUtil.toString(id);
    }
    
}
