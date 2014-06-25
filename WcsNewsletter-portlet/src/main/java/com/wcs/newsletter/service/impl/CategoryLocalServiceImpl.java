package com.wcs.newsletter.service.impl;

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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.impl.CategoryImpl;
import com.wcs.newsletter.service.base.CategoryLocalServiceBaseImpl;
import com.wcs.newsletter.service.persistence.CategoryFinderUtil;
import com.wcs.newsletter.service.persistence.CategoryUtil;

import java.util.List;

public class CategoryLocalServiceImpl extends CategoryLocalServiceBaseImpl {

    private static final Logger logger = LoggerFactory.getLogger(CategoryLocalServiceImpl.class);
    
    public Category createNewCategory() {
        try {
            Category category = new CategoryImpl();
            return addCategory(category);
        } catch (SystemException ex) {
            logger.error(ex);
        }

        return null;
    }

    public List<Category> getCategories() throws SystemException {
        return categoryPersistence.findAll();
    }    
    
    public java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return CategoryUtil.findByLocale(locale);
    }
    
    public List<Category> findByNewsletterId(long newsletterId) throws PortalException, SystemException {
    	
    	return CategoryFinderUtil.findByNewsletterId(newsletterId); 
    }

}
