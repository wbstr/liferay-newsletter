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
import java.text.MessageFormat;
import java.util.ResourceBundle;

public class ResourceBundleUtil {

    private static final Logger logger = LoggerFactory.getLogger(ResourceBundleUtil.class);
    
    public static final String MESSAGE_BUNDLE = "Messages";
    
    private static ResourceBundle resourceBundle;    
    
    public static String getMessage(String key) {
        return getMessage(key, null);
    }
    
    public static String getMessage(String key, Object[] args) {
        String message = key;

        try {

            if (resourceBundle == null) {
                resourceBundle = ResourceBundle.getBundle(MESSAGE_BUNDLE);
            }

            message = resourceBundle.getString(key);

            if (args != null) {
                message = MessageFormat.format(message, args);
            }
        } catch (Exception e) {
            logger.error(e);
        }

        return message;
    }    
    
}
