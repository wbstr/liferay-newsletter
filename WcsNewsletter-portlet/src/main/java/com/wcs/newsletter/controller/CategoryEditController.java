package com.wcs.newsletter.controller;

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

import com.liferay.portal.kernel.exception.SystemException;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.impl.CategoryImpl;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.util.LiferayUtil;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CategoryEditController extends AbstractEditController<Category, Long> {

    @Override
    public Category initElem() throws Exception {
        return CategoryLocalServiceUtil.getCategory((Long) getId());
    }

    @Override
    public Category initNewElem() {
        return new CategoryImpl();
    }

    @Override
    protected Category persist() throws SystemException {
        return CategoryLocalServiceUtil.addCategory((Category) elem);
    }

    @Override
    protected Category update() throws SystemException {
        return CategoryLocalServiceUtil.updateCategory((Category) elem);
    }

    public Locale[] getAvailableLocales() {
        return LiferayUtil.getAvailableLocales();
    }

    public void resetController() {
        elem = null;
        id = null;
    }
}
