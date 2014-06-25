package com.wcs.newsletter.action;

/*
 * #%L
 * Webstar Newsletter
 * %%
 * Copyright (C) 2013 - 2014 Webstar Csoport Kft.
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

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;


import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * Configuration of the calendar-importer portlet.
 * 
 * @author Christian Berndt
 * @created 2014-06-24 22:13
 * @modified 2014-06-24 22:13
 * @version 1.0
 * 
 */
public class NewsletterAdminConfigurationActionImpl extends
		DefaultConfigurationAction {
	
    // Enable logging for this class
    public static final Log _log = LogFactoryUtil
            .getLog(NewsletterAdminConfigurationActionImpl.class.getName());
    
    @Override
    public void processAction(PortletConfig portletConfig,
            ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {

        _log.info("Executing processAction().");

        String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
        String templateId = ParamUtil.getString(actionRequest, "templateId"); 

        _log.debug("cmd = " + cmd);
        _log.debug("templateId = " + templateId);
        
        setPreference(actionRequest, "templateId", templateId);
        
        if (Constants.DELETE.equals(cmd)) {
        	
        	PortletPreferences portletPreferences = actionRequest.getPreferences();
        	portletPreferences.reset("templateId");
            portletPreferences.store();
            
            // TODO: Store a success message in the session context.
    		
        } else {
        
	        // Store the preferences
	        super.processAction(portletConfig, actionRequest, actionResponse);
	        
        }

    }

}
