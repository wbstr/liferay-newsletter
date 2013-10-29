package com.wcs.tool;

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


import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StringUtil {

    public static String toCSV(Object[] objs, boolean quote) {
        if (objs == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objs.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            if (quote) {
                sb.append('\'');
            }
            sb.append(objs[i]);
            if (quote) {
                sb.append('\'');
            }
        }
        return sb.toString();
    }

    public static String toCSV(Object[] objs) {
        return toCSV(objs, false);
    }

    public static String toCSV(List<?> list, boolean quote) {
        if (list == null) {
            return null;
        }

        return toCSV(list.toArray(), quote);
    }

    public static String toCSV(List<?> list) {
        return toCSV(list, false);
    }

    public static String toSV(Collection collection, String separator) {
        if (collection == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        Iterator itr = collection.iterator();
        while (itr.hasNext()) {
            sb.append(itr.next());
            if (itr.hasNext()) {
                sb.append(separator);
            }
        }

        return sb.toString();
    }

    public static boolean isEmpty(String str) {
        return (str == null || str.trim().isEmpty());
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static String toString(Object obj) {
        String stringValue = "";

        if (obj != null) {
            stringValue = obj.toString();
        }

        return stringValue;
    }
}
