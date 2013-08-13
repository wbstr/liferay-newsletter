package com.wcs.newsletter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.Category;

import java.util.List;

/**
 * The persistence utility for the category service. This utility wraps {@link CategoryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryPersistence
 * @see CategoryPersistenceImpl
 * @generated
 */
public class CategoryUtil {
    private static CategoryPersistence _persistence;

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
    public static void clearCache(Category category) {
        getPersistence().clearCache(category);
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
    public static List<Category> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Category> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Category> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Category update(Category category, boolean merge)
        throws SystemException {
        return getPersistence().update(category, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Category update(Category category, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(category, merge, serviceContext);
    }

    /**
    * Caches the category in the entity cache if it is enabled.
    *
    * @param category the category
    */
    public static void cacheResult(com.wcs.newsletter.model.Category category) {
        getPersistence().cacheResult(category);
    }

    /**
    * Caches the categories in the entity cache if it is enabled.
    *
    * @param categories the categories
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.Category> categories) {
        getPersistence().cacheResult(categories);
    }

    /**
    * Creates a new category with the primary key. Does not add the category to the database.
    *
    * @param categoryId the primary key for the new category
    * @return the new category
    */
    public static com.wcs.newsletter.model.Category create(long categoryId) {
        return getPersistence().create(categoryId);
    }

    /**
    * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param categoryId the primary key of the category
    * @return the category that was removed
    * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category remove(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException {
        return getPersistence().remove(categoryId);
    }

    public static com.wcs.newsletter.model.Category updateImpl(
        com.wcs.newsletter.model.Category category, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(category, merge);
    }

    /**
    * Returns the category with the primary key or throws a {@link com.wcs.newsletter.NoSuchCategoryException} if it could not be found.
    *
    * @param categoryId the primary key of the category
    * @return the category
    * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category findByPrimaryKey(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException {
        return getPersistence().findByPrimaryKey(categoryId);
    }

    /**
    * Returns the category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param categoryId the primary key of the category
    * @return the category, or <code>null</code> if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category fetchByPrimaryKey(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(categoryId);
    }

    /**
    * Returns all the categories where locale = &#63;.
    *
    * @param locale the locale
    * @return the matching categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByLocale(locale);
    }

    /**
    * Returns a range of all the categories where locale = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param locale the locale
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of matching categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByLocale(locale, start, end);
    }

    /**
    * Returns an ordered range of all the categories where locale = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param locale the locale
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByLocale(locale, start, end, orderByComparator);
    }

    /**
    * Returns the first category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category
    * @throws com.wcs.newsletter.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category findByLocale_First(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException {
        return getPersistence().findByLocale_First(locale, orderByComparator);
    }

    /**
    * Returns the first category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category fetchByLocale_First(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByLocale_First(locale, orderByComparator);
    }

    /**
    * Returns the last category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category
    * @throws com.wcs.newsletter.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category findByLocale_Last(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException {
        return getPersistence().findByLocale_Last(locale, orderByComparator);
    }

    /**
    * Returns the last category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category fetchByLocale_Last(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByLocale_Last(locale, orderByComparator);
    }

    /**
    * Returns the categories before and after the current category in the ordered set where locale = &#63;.
    *
    * @param categoryId the primary key of the current category
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next category
    * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Category[] findByLocale_PrevAndNext(
        long categoryId, java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException {
        return getPersistence()
                   .findByLocale_PrevAndNext(categoryId, locale,
            orderByComparator);
    }

    /**
    * Returns all the categories.
    *
    * @return the categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the categories where locale = &#63; from the database.
    *
    * @param locale the locale
    * @throws SystemException if a system exception occurred
    */
    public static void removeByLocale(java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByLocale(locale);
    }

    /**
    * Removes all the categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of categories where locale = &#63;.
    *
    * @param locale the locale
    * @return the number of matching categories
    * @throws SystemException if a system exception occurred
    */
    public static int countByLocale(java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByLocale(locale);
    }

    /**
    * Returns the number of categories.
    *
    * @return the number of categories
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static CategoryPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (CategoryPersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    CategoryPersistence.class.getName());

            ReferenceRegistry.registerReference(CategoryUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(CategoryPersistence persistence) {
    }
}
