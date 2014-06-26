package com.wcs.newsletter.service.impl;

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
import com.liferay.portal.kernel.exception.SystemException;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.service.base.SubscriptionLocalServiceBaseImpl;
import com.wcs.newsletter.service.persistence.SubscriptionUtil;
import java.util.List;

public class SubscriptionLocalServiceImpl extends SubscriptionLocalServiceBaseImpl {

    public java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
            java.lang.String email)
            throws com.liferay.portal.kernel.exception.SystemException {
        return SubscriptionUtil.findByEmail(email);
    }

    public java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
            long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return SubscriptionUtil.findByUserId(userId);
    }

    public List<Subscription> getSubscriptions() throws SystemException {
        return SubscriptionUtil.findAll();
    }
}
