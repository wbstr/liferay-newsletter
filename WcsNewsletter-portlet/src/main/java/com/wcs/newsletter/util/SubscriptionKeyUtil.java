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

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.wcs.newsletter.dto.SubscriptionKeySet;
import com.wcs.newsletter.tools.Tools;


public class SubscriptionKeyUtil {

    protected static final Logger logger = LoggerFactory.getLogger(SubscriptionKeyUtil.class);
    
    public static SubscriptionKeySet generateKeySet(String catId, String email) {
        double randomNumber = Math.random() * 1000;
        
        String confirmationKey = Tools.md5(catId + "_" + randomNumber + "_" + email + "_confirm");        
        String cancelationKey = Tools.md5(catId + "_" + randomNumber + "_" + email + "_cancel");
        
        //logger.info("generateKeySet: {0} {1} ({2}) ({3})", new Object[]{catId, email, confirmationKey, cancelationKey});
        
        SubscriptionKeySet subscriptionKeySet = new SubscriptionKeySet(confirmationKey, cancelationKey);
        
        return subscriptionKeySet;
    }
    
}
