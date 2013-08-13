package com.wcs.newsletter.tools;

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
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class SortTools implements Serializable {

    private final Comparator COMPARATOR;

    public SortTools() {
        FacesContext context = FacesContext.getCurrentInstance();
        
        if (context != null) {
            Locale locale = context.getViewRoot().getLocale();
            COMPARATOR = Collator.getInstance(locale);
        } else {
            COMPARATOR = Collator.getInstance(new Locale("hu"));
        }
    }

    public int sort(Object s1, Object s2) {
        if(s1 == null){
            return -1;
        }
        if(s2 == null){
            return 1;
        }
        return COMPARATOR.compare(s1, s2);
    }
}
