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


import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.wcs.newsletter.util.JsfUtil;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

public abstract class AbstractController implements Serializable {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    protected NavigationController navigationController;
    protected NavigationParamController navigationParamController;

    public abstract void initController();
    
    protected NavigationController getNavigationController() {
        if (navigationController == null) {
            navigationController = (NavigationController) JsfUtil.getManagedBean("navigationController");
        }
        
        return navigationController;
    }

    public NavigationParamController getNavigationParamController() {
        if (navigationParamController == null) {
            navigationParamController = (NavigationParamController) JsfUtil.getManagedBean("navigationParamController");
        }
        
        return navigationParamController;
    }
    
    protected void addErrorMessage(Exception ex) {
        JsfUtil.addErrorMessage(ex, null);
    }

    protected void addErrorMessage(Exception ex, String messageKey) {
        JsfUtil.addErrorMessage(ex, messageKey);
    }    
    
    protected void addErrorMessage(String messageKey) {
        JsfUtil.addErrorMessageByKey(messageKey);
    }   
    
    public void addSuccessMessage(String messageKey) {
        JsfUtil.addSuccessMessageByKey(messageKey);
    }    

    public void addWarningMessage(String messageKey) {
        JsfUtil.addWarningMessageByKey(messageKey);
    }      
    
    public ThemeDisplay getThemeDisplay(){
        PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        return (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
    }    
}
