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


public class EmailConst {

    public static class Preference {
        public static final String NEWSLETTER_EMAIL = "newsletterEmail";
    }    
    
    public static class Variable {
        public static final String CATEGORY_NAME = "###categoryName###";
        public static final String CONFIRM_EMAIL = "###confirmEmail###";
    }
    
    public static class Action {
        
        public static final String CONFIRM_PARAM_KEY = "confkey[]";
        public static final String CANCEL_PARAM_KEY = "canckey[]";
        
    }    
    
}
