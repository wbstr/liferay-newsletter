package com.wcs.newsletter.service.persistence;

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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.Recipient;

import java.util.List;

/**
 * The persistence utility for the recipient service. This utility wraps {@link RecipientPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecipientPersistence
 * @see RecipientPersistenceImpl
 * @generated
 */
public class RecipientUtil {
    private static RecipientPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Recipient recipient) {
        getPersistence().clearCache(recipient);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Recipient> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Recipient> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Recipient> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Recipient update(Recipient recipient, boolean merge)
        throws SystemException {
        return getPersistence().update(recipient, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Recipient update(Recipient recipient, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(recipient, merge, serviceContext);
    }

    /**
    * Caches the recipient in the entity cache if it is enabled.
    *
    * @param recipient the recipient
    */
    public static void cacheResult(com.wcs.newsletter.model.Recipient recipient) {
        getPersistence().cacheResult(recipient);
    }

    /**
    * Caches the recipients in the entity cache if it is enabled.
    *
    * @param recipients the recipients
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.Recipient> recipients) {
        getPersistence().cacheResult(recipients);
    }

    /**
    * Creates a new recipient with the primary key. Does not add the recipient to the database.
    *
    * @param recipientId the primary key for the new recipient
    * @return the new recipient
    */
    public static com.wcs.newsletter.model.Recipient create(long recipientId) {
        return getPersistence().create(recipientId);
    }

    /**
    * Removes the recipient with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient that was removed
    * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient remove(long recipientId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException {
        return getPersistence().remove(recipientId);
    }

    public static com.wcs.newsletter.model.Recipient updateImpl(
        com.wcs.newsletter.model.Recipient recipient, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(recipient, merge);
    }

    /**
    * Returns the recipient with the primary key or throws a {@link com.wcs.newsletter.NoSuchRecipientException} if it could not be found.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient
    * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient findByPrimaryKey(
        long recipientId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException {
        return getPersistence().findByPrimaryKey(recipientId);
    }

    /**
    * Returns the recipient with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient, or <code>null</code> if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient fetchByPrimaryKey(
        long recipientId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(recipientId);
    }

    /**
    * Returns all the recipients where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the matching recipients
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> findByNewsletterId(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNewsletterId(newsletterId);
    }

    /**
    * Returns a range of all the recipients where newsletterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param newsletterId the newsletter ID
    * @param start the lower bound of the range of recipients
    * @param end the upper bound of the range of recipients (not inclusive)
    * @return the range of matching recipients
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> findByNewsletterId(
        long newsletterId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByNewsletterId(newsletterId, start, end);
    }

    /**
    * Returns an ordered range of all the recipients where newsletterId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param newsletterId the newsletter ID
    * @param start the lower bound of the range of recipients
    * @param end the upper bound of the range of recipients (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching recipients
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> findByNewsletterId(
        long newsletterId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByNewsletterId(newsletterId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching recipient
    * @throws com.wcs.newsletter.NoSuchRecipientException if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient findByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException {
        return getPersistence()
                   .findByNewsletterId_First(newsletterId, orderByComparator);
    }

    /**
    * Returns the first recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching recipient, or <code>null</code> if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient fetchByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNewsletterId_First(newsletterId, orderByComparator);
    }

    /**
    * Returns the last recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching recipient
    * @throws com.wcs.newsletter.NoSuchRecipientException if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient findByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException {
        return getPersistence()
                   .findByNewsletterId_Last(newsletterId, orderByComparator);
    }

    /**
    * Returns the last recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching recipient, or <code>null</code> if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient fetchByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByNewsletterId_Last(newsletterId, orderByComparator);
    }

    /**
    * Returns the recipients before and after the current recipient in the ordered set where newsletterId = &#63;.
    *
    * @param recipientId the primary key of the current recipient
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next recipient
    * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Recipient[] findByNewsletterId_PrevAndNext(
        long recipientId, long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException {
        return getPersistence()
                   .findByNewsletterId_PrevAndNext(recipientId, newsletterId,
            orderByComparator);
    }

    /**
    * Returns all the recipients.
    *
    * @return the recipients
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the recipients.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of recipients
    * @param end the upper bound of the range of recipients (not inclusive)
    * @return the range of recipients
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the recipients.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of recipients
    * @param end the upper bound of the range of recipients (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of recipients
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the recipients where newsletterId = &#63; from the database.
    *
    * @param newsletterId the newsletter ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByNewsletterId(newsletterId);
    }

    /**
    * Removes all the recipients from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of recipients where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the number of matching recipients
    * @throws SystemException if a system exception occurred
    */
    public static int countByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByNewsletterId(newsletterId);
    }

    /**
    * Returns the number of recipients.
    *
    * @return the number of recipients
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static RecipientPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (RecipientPersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    RecipientPersistence.class.getName());

            ReferenceRegistry.registerReference(RecipientUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(RecipientPersistence persistence) {
    }
}
