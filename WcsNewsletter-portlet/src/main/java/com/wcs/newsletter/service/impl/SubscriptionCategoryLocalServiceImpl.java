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

import com.wcs.newsletter.service.base.SubscriptionCategoryLocalServiceBaseImpl;
import com.wcs.newsletter.service.persistence.SubscriptionCategoryUtil;

/**
 * The implementation of the subscription category local service.
 *
 * <p> All custom service methods should be put in this class. Whenever methods
 * are added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.wcs.newsletter.service.SubscriptionCategoryLocalService}
 * interface.
 *
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.wcs.newsletter.service.base.SubscriptionCategoryLocalServiceBaseImpl
 * @see com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil
 */
public class SubscriptionCategoryLocalServiceImpl
        extends SubscriptionCategoryLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil} to access the subscription category local service.
     */

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
            long subscriptionId)
            throws com.liferay.portal.kernel.exception.SystemException {
        return SubscriptionCategoryUtil.findBySubscriptionId(subscriptionId);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
            java.lang.String confirmationKey)
            throws com.liferay.portal.kernel.exception.SystemException {
        return SubscriptionCategoryUtil.findByConfirmationKey(confirmationKey);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
            java.lang.String cancellationKey)
            throws com.liferay.portal.kernel.exception.SystemException {
        return SubscriptionCategoryUtil.findByCancellationKey(cancellationKey);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
            java.lang.String status)
            throws com.liferay.portal.kernel.exception.SystemException {
        return SubscriptionCategoryUtil.findByStatus(status);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
            long categoryId)
            throws com.liferay.portal.kernel.exception.SystemException {
        return SubscriptionCategoryUtil.findByCategoryId(categoryId);
    }
}
