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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.PortalUtil;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.impl.CategoryImpl;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.util.LiferayUtil;

import java.awt.event.ActionEvent;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class CategoryEditController extends
		AbstractEditController<Category, Long> {
	
	private String languageId = null; 
	private String name = null;

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

		logger.debug("Executing persist().");
		
		Map<Locale, String> nameMap = elem.getNameMap(); 
		Locale locale = LiferayUtil.getLocale(languageId); 
		nameMap.put(locale, name); 
		elem.setNameMap(nameMap);
		
		return CategoryLocalServiceUtil.addCategory((Category) elem);
	}

	@Override
	protected Category update() throws SystemException {

		logger.debug("Executing update().");
		
		Map<Locale, String> nameMap = elem.getNameMap(); 
		Locale locale = LiferayUtil.getLocale(languageId); 
		nameMap.put(locale, name); 
		elem.setNameMap(nameMap);

		return CategoryLocalServiceUtil.updateCategory((Category) elem);
	}

	public Locale[] getAvailableLocales() {
		return LiferayUtil.getAvailableLocales();
	}

	public void resetController() {
		elem = null;
		id = null;
		languageId = null; 
		name = null; 
	}

	public void onChangeLanguage() {

		logger.debug("Executing onChangeLocale().");
		logger.debug("languageId = " + languageId);
		
		Locale locale = LiferayUtil.getLocale(languageId); 
		name = elem.getName(locale);

	}
	
	// Getters and setters
	public String getLanguageId() throws PortalException, SystemException {
		
		if (languageId != null) {
			return languageId;
		} else {
			Locale locale = PortalUtil.getSiteDefaultLocale(0); 
			return LanguageUtil.getLanguageId(locale); 
		}
	}

	public void setLanguageId(String languageId) {
		this.languageId = languageId;
	}

	public String getName() throws PortalException, SystemException {
		
		if (name != null) {
			return name; 
		} else {
			Locale locale = PortalUtil.getSiteDefaultLocale(0); 
			return elem.getName(locale); 
		}
	}

	public void setName(String name) {
		this.name = name; 
	}
}
