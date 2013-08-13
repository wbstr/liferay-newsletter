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

import com.wcs.tool.StringUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationParamController extends AbstractSessionController {
    
    private static final String CATEGORY = "CATEGORY";
    private static final String SUBSCRIPTION = "SUBSCRIPTION";
    private static final String NEWSLETTER = "NEWSLETTER";       
    private static final String NEWSLETTER_FOLDER = "NEWSLETTER_FOLDER";       
    
    private String key;
    private Object value;
    
    public void put(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return StringUtil.toString(key);
    }
    
    public Object get(String key) {
        return getKey().equals(key) ? value : null;
    }    
    
    public void setCategoryParam(Long id) {
        put(CATEGORY, id);
    }

    public Object getCategoryParam() {
        return get(CATEGORY);
    }    
    
    public void setSubscriptionParam(Long id) {
        put(SUBSCRIPTION, id);
    }    

    public Object getSubscriptionParam() {
        return get(SUBSCRIPTION);
    }       
    
    public void setNewsletterParam(Long id) {
        put(NEWSLETTER, id);
    }    
    
    public Object getNewsletterParam() {
        return get(NEWSLETTER);
    }      

}
