package com.wcs.newsletter.replacer;

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
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.wcs.newsletter.model.NewsletterConfig;
import com.wcs.newsletter.service.NewsletterConfigLocalServiceUtil;
import com.wcs.newsletter.util.EmailConst;
import com.wcs.newsletter.util.LiferayUtil;
import com.wcs.tool.ListUtil;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConfirmEmailLinkReplacer extends AbstractEmailReplacer {

    private List<String> confirmationKeys;

    public ConfirmEmailLinkReplacer(List<String> confirmationKeys) {
        this.confirmationKeys = confirmationKeys;
    }
    
    @Override
    public String getVariableName() {
        return EmailConst.Variable.CONFIRM_EMAIL;
    }

    @Override
    public String getValue() throws Exception {
        return getConfirmationLink();
    }

    private String getConfirmationLink() throws PortalException {
        try {
            if (ListUtil.isEmpty(confirmationKeys)) {
                return null;            
            }
            
            StringBuilder body = new StringBuilder();
            body.append("<a href=\"");
            List<NewsletterConfig> configs = NewsletterConfigLocalServiceUtil.findByConfigKey("subscriptionActionLayout");
                NewsletterConfig subscriptionActionLayout;
                subscriptionActionLayout = configs.get(0);
                Layout layout = null;
                layout = LayoutLocalServiceUtil.getLayout(Long.parseLong(subscriptionActionLayout.getConfigValue()));
//                layout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(subscriptionActionLayout.getConfigValue(), LiferayUtil.getThemeDisplay().getScopeGroupId());
//                layout = LayoutLocalServiceUtil.getLayoutByUuidAndGroupId(subscriptionActionLayout.getConfigValue(), LiferayUtil.getThemeDisplay().getScopeGroupId(),false);
                String layoutURL = PortalUtil.getLayoutURL(layout, LiferayUtil.getThemeDisplay());
              
            body.append(LiferayUtil.getThemeDisplay().getURLPortal());
//            body.append("/subscription?");
              body.append(layoutURL);
              body.append("?");
         
            for (int i = 0; i < confirmationKeys.size(); i++) {
                String confirmationKey = confirmationKeys.get(i);
       
                if (i > 0) {
                    body.append("&");            
                }
                body.append(EmailConst.Action.CONFIRM_PARAM_KEY).append("=").append(confirmationKey);        
            }
            
            body.append("\">");
            body.append("Megerősít/Confirm");
            body.append("</a>");

            body.append("<br />");    
            
            return new String(body);
        } catch (SystemException ex) {
            Logger.getLogger(ConfirmEmailLinkReplacer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }    
    
    
}
