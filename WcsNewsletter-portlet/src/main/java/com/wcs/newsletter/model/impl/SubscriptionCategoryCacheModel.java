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

import com.wcs.newsletter.model.SubscriptionCategory;

import java.io.Serializable;

/**
 * The cache model class for representing SubscriptionCategory in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionCategory
 * @generated
 */
public class SubscriptionCategoryCacheModel implements CacheModel<SubscriptionCategory>,
    Serializable {
    public long subscriptionId;
    public long categoryId;
    public String confirmationKey;
    public String cancellationKey;
    public String status;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{subscriptionId=");
        sb.append(subscriptionId);
        sb.append(", categoryId=");
        sb.append(categoryId);
        sb.append(", confirmationKey=");
        sb.append(confirmationKey);
        sb.append(", cancellationKey=");
        sb.append(cancellationKey);
        sb.append(", status=");
        sb.append(status);
        sb.append("}");

        return sb.toString();
    }

    public SubscriptionCategory toEntityModel() {
        SubscriptionCategoryImpl subscriptionCategoryImpl = new SubscriptionCategoryImpl();

        subscriptionCategoryImpl.setSubscriptionId(subscriptionId);
        subscriptionCategoryImpl.setCategoryId(categoryId);

        if (confirmationKey == null) {
            subscriptionCategoryImpl.setConfirmationKey(StringPool.BLANK);
        } else {
            subscriptionCategoryImpl.setConfirmationKey(confirmationKey);
        }

        if (cancellationKey == null) {
            subscriptionCategoryImpl.setCancellationKey(StringPool.BLANK);
        } else {
            subscriptionCategoryImpl.setCancellationKey(cancellationKey);
        }

        if (status == null) {
            subscriptionCategoryImpl.setStatus(StringPool.BLANK);
        } else {
            subscriptionCategoryImpl.setStatus(status);
        }

        subscriptionCategoryImpl.resetOriginalValues();

        return subscriptionCategoryImpl;
    }
}
