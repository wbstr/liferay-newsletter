package com.wcs.newsletter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.wcs.newsletter.model.Subscription;

/**
 * The persistence interface for the subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionPersistenceImpl
 * @see SubscriptionUtil
 * @generated
 */
public interface SubscriptionPersistence extends BasePersistence<Subscription> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SubscriptionUtil} to access the subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the subscription in the entity cache if it is enabled.
    *
    * @param subscription the subscription
    */
    public void cacheResult(com.wcs.newsletter.model.Subscription subscription);

    /**
    * Caches the subscriptions in the entity cache if it is enabled.
    *
    * @param subscriptions the subscriptions
    */
    public void cacheResult(
        java.util.List<com.wcs.newsletter.model.Subscription> subscriptions);

    /**
    * Creates a new subscription with the primary key. Does not add the subscription to the database.
    *
    * @param subscriptionId the primary key for the new subscription
    * @return the new subscription
    */
    public com.wcs.newsletter.model.Subscription create(long subscriptionId);

    /**
    * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription that was removed
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription remove(long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    public com.wcs.newsletter.model.Subscription updateImpl(
        com.wcs.newsletter.model.Subscription subscription, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscription with the primary key or throws a {@link com.wcs.newsletter.NoSuchSubscriptionException} if it could not be found.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription findByPrimaryKey(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    /**
    * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription fetchByPrimaryKey(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the subscriptions where email = &#63;.
    *
    * @param email the email
    * @return the matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the subscriptions where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of subscriptions
    * @param end the upper bound of the range of subscriptions (not inclusive)
    * @return the range of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the subscriptions where email = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param email the email
    * @param start the lower bound of the range of subscriptions
    * @param end the upper bound of the range of subscriptions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription findByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    /**
    * Returns the first subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription fetchByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription findByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    /**
    * Returns the last subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription fetchByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptions before and after the current subscription in the ordered set where email = &#63;.
    *
    * @param subscriptionId the primary key of the current subscription
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription[] findByEmail_PrevAndNext(
        long subscriptionId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    /**
    * Returns all the subscriptions where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the subscriptions where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of subscriptions
    * @param end the upper bound of the range of subscriptions (not inclusive)
    * @return the range of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the subscriptions where userId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param userId the user ID
    * @param start the lower bound of the range of subscriptions
    * @param end the upper bound of the range of subscriptions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    /**
    * Returns the first subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    /**
    * Returns the last subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscriptions before and after the current subscription in the ordered set where userId = &#63;.
    *
    * @param subscriptionId the primary key of the current subscription
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Subscription[] findByUserId_PrevAndNext(
        long subscriptionId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException;

    /**
    * Returns all the subscriptions.
    *
    * @return the subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the subscriptions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of subscriptions
    * @param end the upper bound of the range of subscriptions (not inclusive)
    * @return the range of subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the subscriptions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of subscriptions
    * @param end the upper bound of the range of subscriptions (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of subscriptions
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Subscription> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscriptions where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public void removeByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscriptions where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscriptions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptions where email = &#63;.
    *
    * @param email the email
    * @return the number of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public int countByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptions where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscriptions.
    *
    * @return the number of subscriptions
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
