package com.wcs.newsletter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.Subscription;

import java.util.List;

/**
 * The persistence utility for the subscription service. This utility wraps {@link SubscriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionPersistence
 * @see SubscriptionPersistenceImpl
 * @generated
 */
public class SubscriptionUtil {
    private static SubscriptionPersistence _persistence;

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
    public static void clearCache(Subscription subscription) {
        getPersistence().clearCache(subscription);
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
    public static List<Subscription> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Subscription> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Subscription> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Subscription update(Subscription subscription, boolean merge)
        throws SystemException {
        return getPersistence().update(subscription, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Subscription update(Subscription subscription, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(subscription, merge, serviceContext);
    }

    /**
    * Caches the subscription in the entity cache if it is enabled.
    *
    * @param subscription the subscription
    */
    public static void cacheResult(
        com.wcs.newsletter.model.Subscription subscription) {
        getPersistence().cacheResult(subscription);
    }

    /**
    * Caches the subscriptions in the entity cache if it is enabled.
    *
    * @param subscriptions the subscriptions
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.Subscription> subscriptions) {
        getPersistence().cacheResult(subscriptions);
    }

    /**
    * Creates a new subscription with the primary key. Does not add the subscription to the database.
    *
    * @param subscriptionId the primary key for the new subscription
    * @return the new subscription
    */
    public static com.wcs.newsletter.model.Subscription create(
        long subscriptionId) {
        return getPersistence().create(subscriptionId);
    }

    /**
    * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription that was removed
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription remove(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence().remove(subscriptionId);
    }

    public static com.wcs.newsletter.model.Subscription updateImpl(
        com.wcs.newsletter.model.Subscription subscription, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(subscription, merge);
    }

    /**
    * Returns the subscription with the primary key or throws a {@link com.wcs.newsletter.NoSuchSubscriptionException} if it could not be found.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription findByPrimaryKey(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence().findByPrimaryKey(subscriptionId);
    }

    /**
    * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription fetchByPrimaryKey(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(subscriptionId);
    }

    /**
    * Returns all the subscriptions where email = &#63;.
    *
    * @param email the email
    * @return the matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email);
    }

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
    public static java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
        java.lang.String email, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email, start, end);
    }

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
    public static java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
        java.lang.String email, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByEmail(email, start, end, orderByComparator);
    }

    /**
    * Returns the first subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription findByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence().findByEmail_First(email, orderByComparator);
    }

    /**
    * Returns the first subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription fetchByEmail_First(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail_First(email, orderByComparator);
    }

    /**
    * Returns the last subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription findByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence().findByEmail_Last(email, orderByComparator);
    }

    /**
    * Returns the last subscription in the ordered set where email = &#63;.
    *
    * @param email the email
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription fetchByEmail_Last(
        java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByEmail_Last(email, orderByComparator);
    }

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
    public static com.wcs.newsletter.model.Subscription[] findByEmail_PrevAndNext(
        long subscriptionId, java.lang.String email,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence()
                   .findByEmail_PrevAndNext(subscriptionId, email,
            orderByComparator);
    }

    /**
    * Returns all the subscriptions where userId = &#63;.
    *
    * @param userId the user ID
    * @return the matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId);
    }

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
    public static java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
        long userId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUserId(userId, start, end);
    }

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
    public static java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
        long userId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUserId(userId, start, end, orderByComparator);
    }

    /**
    * Returns the first subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription findByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence().findByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the first subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription fetchByUserId_First(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_First(userId, orderByComparator);
    }

    /**
    * Returns the last subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription
    * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription findByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence().findByUserId_Last(userId, orderByComparator);
    }

    /**
    * Returns the last subscription in the ordered set where userId = &#63;.
    *
    * @param userId the user ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription fetchByUserId_Last(
        long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUserId_Last(userId, orderByComparator);
    }

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
    public static com.wcs.newsletter.model.Subscription[] findByUserId_PrevAndNext(
        long subscriptionId, long userId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionException {
        return getPersistence()
                   .findByUserId_PrevAndNext(subscriptionId, userId,
            orderByComparator);
    }

    /**
    * Returns all the subscriptions.
    *
    * @return the subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Subscription> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

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
    public static java.util.List<com.wcs.newsletter.model.Subscription> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

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
    public static java.util.List<com.wcs.newsletter.model.Subscription> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the subscriptions where email = &#63; from the database.
    *
    * @param email the email
    * @throws SystemException if a system exception occurred
    */
    public static void removeByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByEmail(email);
    }

    /**
    * Removes all the subscriptions where userId = &#63; from the database.
    *
    * @param userId the user ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUserId(userId);
    }

    /**
    * Removes all the subscriptions from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of subscriptions where email = &#63;.
    *
    * @param email the email
    * @return the number of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int countByEmail(java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByEmail(email);
    }

    /**
    * Returns the number of subscriptions where userId = &#63;.
    *
    * @param userId the user ID
    * @return the number of matching subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int countByUserId(long userId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUserId(userId);
    }

    /**
    * Returns the number of subscriptions.
    *
    * @return the number of subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SubscriptionPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SubscriptionPersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    SubscriptionPersistence.class.getName());

            ReferenceRegistry.registerReference(SubscriptionUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(SubscriptionPersistence persistence) {
    }
}
