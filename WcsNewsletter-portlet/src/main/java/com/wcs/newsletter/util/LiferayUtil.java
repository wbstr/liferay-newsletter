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

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.wcs.newsletter.controller.AbstractController;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.wcs.tool.StringUtil;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

public class LiferayUtil {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);
    
    public static User getActiveUser() {
        User user = null;
        
       FacesContext liferayFacesContext = FacesContext.getCurrentInstance();
        PortletRequest  request = liferayFacesContext != null ? (PortletRequest) liferayFacesContext.getExternalContext().getRequest() : null;
        String remoteUser = request != null ? request.getRemoteUser() : null;
        
        if (StringUtil.isNotEmpty(remoteUser)) {
            try {
                user = UserLocalServiceUtil.getUser(Long.parseLong(remoteUser));   
            } catch (Exception e) {
                logger.error(e);
            }
        }        
        
        return user;
    }
    
    public static ThemeDisplay getThemeDisplay(){
        PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        return (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
    }       
    
    public static HttpServletRequest getHttpServletRequest() {
//        LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
        PortletRequest request = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
        
        return httpReq;
    }    
    
    public static String getLiferayFullLangCode() {
        PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        return themeDisplay.getLanguageId();
    }    
    
    public static Locale getLocale(String langCode) {
        if (StringUtil.isEmpty(langCode)) {
            return null;
        }
        
        Locale[] availableLocales = getAvailableLocales();
        for (Locale locale : availableLocales) {
            String localeStr = locale.toString();
            if (langCode.equals(localeStr)) {
                return locale;
            }
        }
        
        return null;
    }
    
    public static PortletPreferences getPortletPreferences() {
//        LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
        PortletRequest request = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        PortletPreferences preferences = request.getPreferences();

        String portletResource = ParamUtil.getString(request, "portletResource");

        if (Validator.isNotNull(portletResource)) {
            try {
                preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
            } catch (Exception ex) {
                logger.error(ex);
            }
        }
        
        return preferences;
    }
    
    public static Locale[] getAvailableLocales() {
        Locale[] availableLocales = LanguageUtil.getAvailableLocales();
        
        if (availableLocales == null) {
            availableLocales = new Locale[]{};
        }
        
        return availableLocales;
    }    
    
}
