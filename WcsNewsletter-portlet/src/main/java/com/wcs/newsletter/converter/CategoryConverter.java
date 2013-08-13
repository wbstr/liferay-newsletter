package com.wcs.newsletter.converter;

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

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import com.wcs.newsletter.model.Category;
import com.wcs.tool.StringUtil;

@FacesConverter("categoryConverter")
public class CategoryConverter implements Converter {
    
    private static final Logger logger = LoggerFactory.getLogger(CategoryConverter.class);
    
    public Object getAsObject(FacesContext fc, UIComponent uic, String categoryId) {
        if (StringUtil.isEmpty(categoryId)) {
            return null;
        }
        
        try {
            return CategoryLocalServiceUtil.getCategory(Long.parseLong(categoryId));
        } catch (Exception ex) {
            logger.error(ex);
        } 
        
        return null;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        
        long categoryId = ((Category) o).getCategoryId();
        return StringUtil.toString(categoryId);
    }    
    
}
