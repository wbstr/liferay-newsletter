package com.wcs.newsletter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.SubscriptionCategory;

import java.util.List;

/**
 * The persistence utility for the subscription category service. This utility wraps {@link SubscriptionCategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionCategoryPersistence
 * @see SubscriptionCategoryPersistenceImpl
 * @generated
 */
public class SubscriptionCategoryUtil {
    private static SubscriptionCategoryPersistence _persistence;

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
    public static void clearCache(SubscriptionCategory subscriptionCategory) {
        getPersistence().clearCache(subscriptionCategory);
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
    public static List<SubscriptionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<SubscriptionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<SubscriptionCategory> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static SubscriptionCategory update(
        SubscriptionCategory subscriptionCategory, boolean merge)
        throws SystemException {
        return getPersistence().update(subscriptionCategory, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static SubscriptionCategory update(
        SubscriptionCategory subscriptionCategory, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence()
                   .update(subscriptionCategory, merge, serviceContext);
    }

    /**
    * Caches the subscription category in the entity cache if it is enabled.
    *
    * @param subscriptionCategory the subscription category
    */
    public static void cacheResult(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory) {
        getPersistence().cacheResult(subscriptionCategory);
    }

    /**
    * Caches the subscription categories in the entity cache if it is enabled.
    *
    * @param subscriptionCategories the subscription categories
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.SubscriptionCategory> subscriptionCategories) {
        getPersistence().cacheResult(subscriptionCategories);
    }

    /**
    * Creates a new subscription category with the primary key. Does not add the subscription category to the database.
    *
    * @param subscriptionCategoryPK the primary key for the new subscription category
    * @return the new subscription category
    */
    public static com.wcs.newsletter.model.SubscriptionCategory create(
        SubscriptionCategoryPK subscriptionCategoryPK) {
        return getPersistence().create(subscriptionCategoryPK);
    }

    /**
    * Removes the subscription category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category that was removed
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory remove(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence().remove(subscriptionCategoryPK);
    }

    public static com.wcs.newsletter.model.SubscriptionCategory updateImpl(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(subscriptionCategory, merge);
    }

    /**
    * Returns the subscription category with the primary key or throws a {@link com.wcs.newsletter.NoSuchSubscriptionCategoryException} if it could not be found.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByPrimaryKey(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence().findByPrimaryKey(subscriptionCategoryPK);
    }

    /**
    * Returns the subscription category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category, or <code>null</code> if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByPrimaryKey(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(subscriptionCategoryPK);
    }

    /**
    * Returns all the subscription categories where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubscriptionId(subscriptionId);
    }

    /**
    * Returns a range of all the subscription categories where subscriptionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param subscriptionId the subscription ID
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @return the range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findBySubscriptionId(subscriptionId, start, end);
    }

    /**
    * Returns an ordered range of all the subscription categories where subscriptionId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param subscriptionId the subscription ID
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findBySubscriptionId(subscriptionId, start, end,
            orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findBySubscriptionId_First(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findBySubscriptionId_First(subscriptionId, orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchBySubscriptionId_First(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySubscriptionId_First(subscriptionId,
            orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findBySubscriptionId_Last(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findBySubscriptionId_Last(subscriptionId, orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchBySubscriptionId_Last(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchBySubscriptionId_Last(subscriptionId, orderByComparator);
    }

    /**
    * Returns the subscription categories before and after the current subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionCategoryPK the primary key of the current subscription category
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory[] findBySubscriptionId_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findBySubscriptionId_PrevAndNext(subscriptionCategoryPK,
            subscriptionId, orderByComparator);
    }

    /**
    * Returns all the subscription categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCategoryId(categoryId);
    }

    /**
    * Returns a range of all the subscription categories where categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param categoryId the category ID
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @return the range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCategoryId(categoryId, start, end);
    }

    /**
    * Returns an ordered range of all the subscription categories where categoryId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param categoryId the category ID
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCategoryId(categoryId, start, end, orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByCategoryId_First(categoryId, orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCategoryId_First(categoryId, orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByCategoryId_Last(categoryId, orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCategoryId_Last(categoryId, orderByComparator);
    }

    /**
    * Returns the subscription categories before and after the current subscription category in the ordered set where categoryId = &#63;.
    *
    * @param subscriptionCategoryPK the primary key of the current subscription category
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory[] findByCategoryId_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByCategoryId_PrevAndNext(subscriptionCategoryPK,
            categoryId, orderByComparator);
    }

    /**
    * Returns all the subscription categories where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByConfirmationKey(confirmationKey);
    }

    /**
    * Returns a range of all the subscription categories where confirmationKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param confirmationKey the confirmation key
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @return the range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConfirmationKey(confirmationKey, start, end);
    }

    /**
    * Returns an ordered range of all the subscription categories where confirmationKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param confirmationKey the confirmation key
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConfirmationKey(confirmationKey, start, end,
            orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByConfirmationKey_First(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByConfirmationKey_First(confirmationKey,
            orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByConfirmationKey_First(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConfirmationKey_First(confirmationKey,
            orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByConfirmationKey_Last(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByConfirmationKey_Last(confirmationKey,
            orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByConfirmationKey_Last(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConfirmationKey_Last(confirmationKey,
            orderByComparator);
    }

    /**
    * Returns the subscription categories before and after the current subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param subscriptionCategoryPK the primary key of the current subscription category
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory[] findByConfirmationKey_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK,
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByConfirmationKey_PrevAndNext(subscriptionCategoryPK,
            confirmationKey, orderByComparator);
    }

    /**
    * Returns all the subscription categories where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByCancellationKey(cancellationKey);
    }

    /**
    * Returns a range of all the subscription categories where cancellationKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param cancellationKey the cancellation key
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @return the range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCancellationKey(cancellationKey, start, end);
    }

    /**
    * Returns an ordered range of all the subscription categories where cancellationKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param cancellationKey the cancellation key
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByCancellationKey(cancellationKey, start, end,
            orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByCancellationKey_First(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByCancellationKey_First(cancellationKey,
            orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByCancellationKey_First(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCancellationKey_First(cancellationKey,
            orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByCancellationKey_Last(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByCancellationKey_Last(cancellationKey,
            orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByCancellationKey_Last(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByCancellationKey_Last(cancellationKey,
            orderByComparator);
    }

    /**
    * Returns the subscription categories before and after the current subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param subscriptionCategoryPK the primary key of the current subscription category
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory[] findByCancellationKey_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK,
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByCancellationKey_PrevAndNext(subscriptionCategoryPK,
            cancellationKey, orderByComparator);
    }

    /**
    * Returns all the subscription categories where status = &#63;.
    *
    * @param status the status
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus(status);
    }

    /**
    * Returns a range of all the subscription categories where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @return the range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByStatus(status, start, end);
    }

    /**
    * Returns an ordered range of all the subscription categories where status = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param status the status
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByStatus(status, start, end, orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByStatus_First(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence().findByStatus_First(status, orderByComparator);
    }

    /**
    * Returns the first subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByStatus_First(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus_First(status, orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory findByStatus_Last(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence().findByStatus_Last(status, orderByComparator);
    }

    /**
    * Returns the last subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory fetchByStatus_Last(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByStatus_Last(status, orderByComparator);
    }

    /**
    * Returns the subscription categories before and after the current subscription category in the ordered set where status = &#63;.
    *
    * @param subscriptionCategoryPK the primary key of the current subscription category
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory[] findByStatus_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException {
        return getPersistence()
                   .findByStatus_PrevAndNext(subscriptionCategoryPK, status,
            orderByComparator);
    }

    /**
    * Returns all the subscription categories.
    *
    * @return the subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the subscription categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @return the range of subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the subscription categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the subscription categories where subscriptionId = &#63; from the database.
    *
    * @param subscriptionId the subscription ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeBySubscriptionId(long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeBySubscriptionId(subscriptionId);
    }

    /**
    * Removes all the subscription categories where categoryId = &#63; from the database.
    *
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCategoryId(categoryId);
    }

    /**
    * Removes all the subscription categories where confirmationKey = &#63; from the database.
    *
    * @param confirmationKey the confirmation key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByConfirmationKey(java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByConfirmationKey(confirmationKey);
    }

    /**
    * Removes all the subscription categories where cancellationKey = &#63; from the database.
    *
    * @param cancellationKey the cancellation key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByCancellationKey(java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByCancellationKey(cancellationKey);
    }

    /**
    * Removes all the subscription categories where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public static void removeByStatus(java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByStatus(status);
    }

    /**
    * Removes all the subscription categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of subscription categories where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static int countBySubscriptionId(long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countBySubscriptionId(subscriptionId);
    }

    /**
    * Returns the number of subscription categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCategoryId(categoryId);
    }

    /**
    * Returns the number of subscription categories where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByConfirmationKey(java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByConfirmationKey(confirmationKey);
    }

    /**
    * Returns the number of subscription categories where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByCancellationKey(java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByCancellationKey(cancellationKey);
    }

    /**
    * Returns the number of subscription categories where status = &#63;.
    *
    * @param status the status
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByStatus(java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByStatus(status);
    }

    /**
    * Returns the number of subscription categories.
    *
    * @return the number of subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static SubscriptionCategoryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (SubscriptionCategoryPersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    SubscriptionCategoryPersistence.class.getName());

            ReferenceRegistry.registerReference(SubscriptionCategoryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(SubscriptionCategoryPersistence persistence) {
    }
}
