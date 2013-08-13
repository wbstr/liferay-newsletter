package com.wcs.newsletter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.wcs.newsletter.model.SubscriptionCategory;

/**
 * The persistence interface for the subscription category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionCategoryPersistenceImpl
 * @see SubscriptionCategoryUtil
 * @generated
 */
public interface SubscriptionCategoryPersistence extends BasePersistence<SubscriptionCategory> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link SubscriptionCategoryUtil} to access the subscription category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the subscription category in the entity cache if it is enabled.
    *
    * @param subscriptionCategory the subscription category
    */
    public void cacheResult(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory);

    /**
    * Caches the subscription categories in the entity cache if it is enabled.
    *
    * @param subscriptionCategories the subscription categories
    */
    public void cacheResult(
        java.util.List<com.wcs.newsletter.model.SubscriptionCategory> subscriptionCategories);

    /**
    * Creates a new subscription category with the primary key. Does not add the subscription category to the database.
    *
    * @param subscriptionCategoryPK the primary key for the new subscription category
    * @return the new subscription category
    */
    public com.wcs.newsletter.model.SubscriptionCategory create(
        SubscriptionCategoryPK subscriptionCategoryPK);

    /**
    * Removes the subscription category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category that was removed
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory remove(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    public com.wcs.newsletter.model.SubscriptionCategory updateImpl(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the subscription category with the primary key or throws a {@link com.wcs.newsletter.NoSuchSubscriptionCategoryException} if it could not be found.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByPrimaryKey(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the subscription category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category, or <code>null</code> if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByPrimaryKey(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the subscription categories where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findBySubscriptionId_First(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the first subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchBySubscriptionId_First(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findBySubscriptionId_Last(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the last subscription category in the ordered set where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchBySubscriptionId_Last(
        long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.SubscriptionCategory[] findBySubscriptionId_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, long subscriptionId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns all the subscription categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the first subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByCategoryId_First(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the last subscription category in the ordered set where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByCategoryId_Last(
        long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.SubscriptionCategory[] findByCategoryId_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, long categoryId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns all the subscription categories where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByConfirmationKey_First(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the first subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByConfirmationKey_First(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByConfirmationKey_Last(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the last subscription category in the ordered set where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByConfirmationKey_Last(
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.SubscriptionCategory[] findByConfirmationKey_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK,
        java.lang.String confirmationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns all the subscription categories where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByCancellationKey_First(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the first subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByCancellationKey_First(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByCancellationKey_Last(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the last subscription category in the ordered set where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByCancellationKey_Last(
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.SubscriptionCategory[] findByCancellationKey_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK,
        java.lang.String cancellationKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns all the subscription categories where status = &#63;.
    *
    * @param status the status
    * @return the matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByStatus_First(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the first subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByStatus_First(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category
    * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory findByStatus_Last(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns the last subscription category in the ordered set where status = &#63;.
    *
    * @param status the status
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory fetchByStatus_Last(
        java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.SubscriptionCategory[] findByStatus_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, java.lang.String status,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchSubscriptionCategoryException;

    /**
    * Returns all the subscription categories.
    *
    * @return the subscription categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscription categories where subscriptionId = &#63; from the database.
    *
    * @param subscriptionId the subscription ID
    * @throws SystemException if a system exception occurred
    */
    public void removeBySubscriptionId(long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscription categories where categoryId = &#63; from the database.
    *
    * @param categoryId the category ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscription categories where confirmationKey = &#63; from the database.
    *
    * @param confirmationKey the confirmation key
    * @throws SystemException if a system exception occurred
    */
    public void removeByConfirmationKey(java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscription categories where cancellationKey = &#63; from the database.
    *
    * @param cancellationKey the cancellation key
    * @throws SystemException if a system exception occurred
    */
    public void removeByCancellationKey(java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscription categories where status = &#63; from the database.
    *
    * @param status the status
    * @throws SystemException if a system exception occurred
    */
    public void removeByStatus(java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the subscription categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscription categories where subscriptionId = &#63;.
    *
    * @param subscriptionId the subscription ID
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public int countBySubscriptionId(long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscription categories where categoryId = &#63;.
    *
    * @param categoryId the category ID
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public int countByCategoryId(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscription categories where confirmationKey = &#63;.
    *
    * @param confirmationKey the confirmation key
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public int countByConfirmationKey(java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscription categories where cancellationKey = &#63;.
    *
    * @param cancellationKey the cancellation key
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public int countByCancellationKey(java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscription categories where status = &#63;.
    *
    * @param status the status
    * @return the number of matching subscription categories
    * @throws SystemException if a system exception occurred
    */
    public int countByStatus(java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of subscription categories.
    *
    * @return the number of subscription categories
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
