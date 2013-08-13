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


public class BundleKeysConst {

    public static class General {
        
        public static final String INIT_ERROR = "admin_general_elem_init_error";
        public static final String SAVE_ERROR = "admin_general_elem_save_error";
        public static final String SAVE_SUCCESS = "admin_general_elem_save_success";   
        public static final String DELETE_SUCCESS = "admin_general_elem_delete_success";
        public static final String DELETE_ERROR = "admin_general_elem_delete_error";        
        public static final String LIST_INIT_ERROR = "admin_general_list_init_error";
        
    }    
    
    public static class Email {
        
        private static final String NEWSLETTER = "newsletter_";
        public static final String SUBSCRIPTION_SUBJECT = NEWSLETTER + "subscription_subject";        
        
    }
    
    public static class Subscription {
        
        private static final String SUBSCRIPTION = "subscription_";
        public static final String CONFIRM_SUCCESS = SUBSCRIPTION + "confirm_success";
        public static final String CONFIRM_ERROR = SUBSCRIPTION + "confirm_error";
        public static final String CONFIRM_EMPTY_LIST = SUBSCRIPTION + "confirm_empty_list";
        
        public static final String CANCEL_SUCCESS = SUBSCRIPTION + "cancel_success";
        public static final String CANCEL_ERROR = SUBSCRIPTION + "cancel_error";
        public static final String CANCEL_EMPTY_LIST = SUBSCRIPTION + "cancel_empty_list";
        
        public static final String SUBSCRIPTION_EMAIL_SENT = SUBSCRIPTION + "email_sent";
        
        public static final String USER_EXISTS_PLEASE_LOG_IN = SUBSCRIPTION + "user_exists_please_log_in";
        
    }
    
}
