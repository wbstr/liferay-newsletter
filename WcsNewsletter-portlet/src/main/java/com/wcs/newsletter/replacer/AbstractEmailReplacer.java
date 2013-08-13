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

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.wcs.newsletter.controller.AbstractController;
import com.wcs.tool.StringUtil;


public abstract class AbstractEmailReplacer {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);
    
    public String replace(String content) throws Exception {
        String variableName = StringUtil.toString(getVariableName());
        String value = StringUtil.toString(getValue());
        return content.replace(variableName, value);
    }    
    
    public abstract String getVariableName();
    public abstract String getValue() throws Exception;
    
}
