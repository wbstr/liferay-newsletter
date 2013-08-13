package com.wcs.newsletter.comparator;

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

import com.liferay.portlet.asset.model.AssetTag;
import com.wcs.tool.StringUtil;
import java.io.Serializable;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class AssetTagComparator implements Comparator<AssetTag>, Serializable {

    private Collator collator;

    public AssetTagComparator(Locale locale) {
        collator = Collator.getInstance(locale);
    }
    
    public int compare(AssetTag o1, AssetTag o2) {
        String name1 = StringUtil.toString(o1 != null ? o1.getName() : null);
        String name2 = StringUtil.toString(o2 != null ? o2.getName() : null);
        
        return collator.compare(name1, name2);
    }

}
