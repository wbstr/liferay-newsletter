/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wcs.newsletter.util;

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

import java.util.Locale;
import java.util.ResourceBundle;
import javax.faces.context.FacesContext;

/**
 *
 * @author kumm
 */
public class AppMessageBundle {
	
	public static String getString(String id) {
		return getString(FacesContext.getCurrentInstance(), id);
	}

	public static String getString(FacesContext facesContext, String id) {
		Locale locale = null;
		if (facesContext.getViewRoot() != null) {
			locale = facesContext.getViewRoot().getLocale();
		}
		if (locale == null) {
			locale = Locale.getDefault();
		}
		return getString(facesContext, locale, id);
	}

	public static String getString(FacesContext facesContext, Locale locale, String id) {
		String bundleName = facesContext.getApplication().getMessageBundle();
		if (bundleName==null) {
			throw new RuntimeException("Nincs default bundle. (faces-config.xml message-bundle)");
		}
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, locale, getCurrentClassLoader(bundleName));
		if (bundle == null) {
			throw new RuntimeException("Nem található a bundle: "+bundleName+", locale: "+locale.toString());
		}
		return bundle.getString(id);
	}

	protected static ClassLoader getCurrentClassLoader(Object clazz) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();

        if (loader == null) {
            loader = clazz.getClass().getClassLoader();
        }
        return loader;
    }

}
