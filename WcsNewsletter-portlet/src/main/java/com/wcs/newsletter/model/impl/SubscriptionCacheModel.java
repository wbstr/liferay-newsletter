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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.wcs.newsletter.model.Subscription;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing Subscription in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Subscription
 * @generated
 */
public class SubscriptionCacheModel implements CacheModel<Subscription>,
    Serializable {
    public long subscriptionId;
    public long userId;
    public String email;
    public long subscriptionDate;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(9);

        sb.append("{subscriptionId=");
        sb.append(subscriptionId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", email=");
        sb.append(email);
        sb.append(", subscriptionDate=");
        sb.append(subscriptionDate);
        sb.append("}");

        return sb.toString();
    }

    public Subscription toEntityModel() {
        SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

        subscriptionImpl.setSubscriptionId(subscriptionId);
        subscriptionImpl.setUserId(userId);

        if (email == null) {
            subscriptionImpl.setEmail(StringPool.BLANK);
        } else {
            subscriptionImpl.setEmail(email);
        }

        if (subscriptionDate == Long.MIN_VALUE) {
            subscriptionImpl.setSubscriptionDate(null);
        } else {
            subscriptionImpl.setSubscriptionDate(new Date(subscriptionDate));
        }

        subscriptionImpl.resetOriginalValues();

        return subscriptionImpl;
    }
}
