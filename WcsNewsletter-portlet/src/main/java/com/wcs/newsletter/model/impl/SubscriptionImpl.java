package com.wcs.newsletter.model.impl;

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
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.wcs.tool.StringUtil;

public class SubscriptionImpl extends SubscriptionBaseImpl {

    private static final Logger logger = LoggerFactory.getLogger(SubscriptionImpl.class);
    private User user;

    public SubscriptionImpl() {
    }

    public boolean hasUser() {
        return getUserId() != 0;
    }

    public User getUser() {
        if (user == null) {
            if (hasUser()) {
                try {
                    user = UserLocalServiceUtil.getUser(getUserId());
                } catch (Exception ex) {
                    logger.error(ex);
                }
            }
        }

        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUserName() {
        String name = getUser() != null ? getUser().getFullName() : null;

        return StringUtil.toString(name);
    }

    public String getEmailString() {
        String email = getUser() != null ? getUser().getEmailAddress() : getEmail();        
        //logger.info("email: {0} ({1})", new Object[]{email, (hasUser() ? "" : "not ") + "registered"});

        return StringUtil.toString(email);
    }
}
