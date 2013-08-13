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

import com.liferay.portal.service.persistence.BasePersistence;

import com.wcs.newsletter.model.Recipient;

/**
 * The persistence interface for the recipient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecipientPersistenceImpl
 * @see RecipientUtil
 * @generated
 */
public interface RecipientPersistence extends BasePersistence<Recipient> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RecipientUtil} to access the recipient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the recipient in the entity cache if it is enabled.
    *
    * @param recipient the recipient
    */
    public void cacheResult(com.wcs.newsletter.model.Recipient recipient);

    /**
    * Caches the recipients in the entity cache if it is enabled.
    *
    * @param recipients the recipients
    */
    public void cacheResult(
        java.util.List<com.wcs.newsletter.model.Recipient> recipients);

    /**
    * Creates a new recipient with the primary key. Does not add the recipient to the database.
    *
    * @param recipientId the primary key for the new recipient
    * @return the new recipient
    */
    public com.wcs.newsletter.model.Recipient create(long recipientId);

    /**
    * Removes the recipient with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient that was removed
    * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient remove(long recipientId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException;

    public com.wcs.newsletter.model.Recipient updateImpl(
        com.wcs.newsletter.model.Recipient recipient, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the recipient with the primary key or throws a {@link com.wcs.newsletter.NoSuchRecipientException} if it could not be found.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient
    * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient findByPrimaryKey(long recipientId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException;

    /**
    * Returns the recipient with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient, or <code>null</code> if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient fetchByPrimaryKey(
        long recipientId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the recipients where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the matching recipients
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Recipient> findByNewsletterId(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Recipient> findByNewsletterId(
        long newsletterId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Recipient> findByNewsletterId(
        long newsletterId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching recipient
    * @throws com.wcs.newsletter.NoSuchRecipientException if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient findByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException;

    /**
    * Returns the first recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching recipient, or <code>null</code> if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient fetchByNewsletterId_First(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching recipient
    * @throws com.wcs.newsletter.NoSuchRecipientException if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient findByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException;

    /**
    * Returns the last recipient in the ordered set where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching recipient, or <code>null</code> if a matching recipient could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient fetchByNewsletterId_Last(
        long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.Recipient[] findByNewsletterId_PrevAndNext(
        long recipientId, long newsletterId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchRecipientException;

    /**
    * Returns all the recipients.
    *
    * @return the recipients
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Recipient> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Recipient> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Recipient> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the recipients where newsletterId = &#63; from the database.
    *
    * @param newsletterId the newsletter ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the recipients from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of recipients where newsletterId = &#63;.
    *
    * @param newsletterId the newsletter ID
    * @return the number of matching recipients
    * @throws SystemException if a system exception occurred
    */
    public int countByNewsletterId(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of recipients.
    *
    * @return the number of recipients
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
