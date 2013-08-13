package com.wcs.newsletter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.Newsletter;

import java.util.List;

/**
 * The persistence utility for the newsletter service. This utility wraps {@link NewsletterPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistence
 * @see NewsletterPersistenceImpl
 * @generated
 */
public class NewsletterUtil {
    private static NewsletterPersistence _persistence;

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
    public static void clearCache(Newsletter newsletter) {
        getPersistence().clearCache(newsletter);
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
    public static List<Newsletter> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Newsletter> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Newsletter> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Newsletter update(Newsletter newsletter, boolean merge)
        throws SystemException {
        return getPersistence().update(newsletter, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Newsletter update(Newsletter newsletter, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(newsletter, merge, serviceContext);
    }

    /**
    * Caches the newsletter in the entity cache if it is enabled.
    *
    * @param newsletter the newsletter
    */
    public static void cacheResult(
        com.wcs.newsletter.model.Newsletter newsletter) {
        getPersistence().cacheResult(newsletter);
    }

    /**
    * Caches the newsletters in the entity cache if it is enabled.
    *
    * @param newsletters the newsletters
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.Newsletter> newsletters) {
        getPersistence().cacheResult(newsletters);
    }

    /**
    * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
    *
    * @param newsletterId the primary key for the new newsletter
    * @return the new newsletter
    */
    public static com.wcs.newsletter.model.Newsletter create(long newsletterId) {
        return getPersistence().create(newsletterId);
    }

    /**
    * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter that was removed
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter remove(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException {
        return getPersistence().remove(newsletterId);
    }

    public static com.wcs.newsletter.model.Newsletter updateImpl(
        com.wcs.newsletter.model.Newsletter newsletter, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(newsletter, merge);
    }

    /**
    * Returns the newsletter with the primary key or throws a {@link com.wcs.newsletter.NoSuchNewsletterException} if it could not be found.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter findByPrimaryKey(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException {
        return getPersistence().findByPrimaryKey(newsletterId);
    }

    /**
    * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter fetchByPrimaryKey(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(newsletterId);
    }

    /**
    * Returns all the newsletters where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Newsletter> findByParentId(
        long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentId(parentId);
    }

    /**
    * Returns a range of all the newsletters where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Newsletter> findByParentId(
        long parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByParentId(parentId, start, end);
    }

    /**
    * Returns an ordered range of all the newsletters where parentId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param parentId the parent ID
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Newsletter> findByParentId(
        long parentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByParentId(parentId, start, end, orderByComparator);
    }

    /**
    * Returns the first newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter findByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException {
        return getPersistence().findByParentId_First(parentId, orderByComparator);
    }

    /**
    * Returns the first newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter fetchByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByParentId_First(parentId, orderByComparator);
    }

    /**
    * Returns the last newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter findByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException {
        return getPersistence().findByParentId_Last(parentId, orderByComparator);
    }

    /**
    * Returns the last newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter fetchByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByParentId_Last(parentId, orderByComparator);
    }

    /**
    * Returns the newsletters before and after the current newsletter in the ordered set where parentId = &#63;.
    *
    * @param newsletterId the primary key of the current newsletter
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next newsletter
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Newsletter[] findByParentId_PrevAndNext(
        long newsletterId, long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException {
        return getPersistence()
                   .findByParentId_PrevAndNext(newsletterId, parentId,
            orderByComparator);
    }

    /**
    * Returns all the newsletters.
    *
    * @return the newsletters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Newsletter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the newsletters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of newsletters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Newsletter> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the newsletters.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of newsletters
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Newsletter> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the newsletters where parentId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByParentId(parentId);
    }

    /**
    * Removes all the newsletters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of newsletters where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the number of matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public static int countByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByParentId(parentId);
    }

    /**
    * Returns the number of newsletters.
    *
    * @return the number of newsletters
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    /**
    * Returns all the categories associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the categories associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> getCategories(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategories(pk);
    }

    /**
    * Returns a range of all the categories associated with the newsletter.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the newsletter
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of categories associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> getCategories(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategories(pk, start, end);
    }

    /**
    * Returns an ordered range of all the categories associated with the newsletter.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the newsletter
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of categories associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Category> getCategories(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategories(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of categories associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the number of categories associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static int getCategoriesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getCategoriesSize(pk);
    }

    /**
    * Returns <code>true</code> if the category is associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPK the primary key of the category
    * @return <code>true</code> if the category is associated with the newsletter; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsCategory(pk, categoryPK);
    }

    /**
    * Returns <code>true</code> if the newsletter has any categories associated with it.
    *
    * @param pk the primary key of the newsletter to check for associations with categories
    * @return <code>true</code> if the newsletter has any categories associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsCategories(pk);
    }

    /**
    * Adds an association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public static void addCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategory(pk, categoryPK);
    }

    /**
    * Adds an association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public static void addCategory(long pk,
        com.wcs.newsletter.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategory(pk, category);
    }

    /**
    * Adds an association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public static void addCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategories(pk, categoryPKs);
    }

    /**
    * Adds an association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public static void addCategories(long pk,
        java.util.List<com.wcs.newsletter.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addCategories(pk, categories);
    }

    /**
    * Clears all associations between the newsletter and its categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter to clear the associated categories from
    * @throws SystemException if a system exception occurred
    */
    public static void clearCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearCategories(pk);
    }

    /**
    * Removes the association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategory(pk, categoryPK);
    }

    /**
    * Removes the association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategory(long pk,
        com.wcs.newsletter.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategory(pk, category);
    }

    /**
    * Removes the association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategories(pk, categoryPKs);
    }

    /**
    * Removes the association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public static void removeCategories(long pk,
        java.util.List<com.wcs.newsletter.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeCategories(pk, categories);
    }

    /**
    * Sets the categories associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPKs the primary keys of the categories to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static void setCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setCategories(pk, categoryPKs);
    }

    /**
    * Sets the categories associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categories the categories to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static void setCategories(long pk,
        java.util.List<com.wcs.newsletter.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setCategories(pk, categories);
    }

    /**
    * Returns all the labels associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the labels associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Label> getLabels(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLabels(pk);
    }

    /**
    * Returns a range of all the labels associated with the newsletter.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the newsletter
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of labels associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Label> getLabels(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLabels(pk, start, end);
    }

    /**
    * Returns an ordered range of all the labels associated with the newsletter.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the newsletter
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of labels associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Label> getLabels(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLabels(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of labels associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the number of labels associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static int getLabelsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getLabelsSize(pk);
    }

    /**
    * Returns <code>true</code> if the label is associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @param labelPK the primary key of the label
    * @return <code>true</code> if the label is associated with the newsletter; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsLabel(long pk, long labelPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsLabel(pk, labelPK);
    }

    /**
    * Returns <code>true</code> if the newsletter has any labels associated with it.
    *
    * @param pk the primary key of the newsletter to check for associations with labels
    * @return <code>true</code> if the newsletter has any labels associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsLabels(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsLabels(pk);
    }

    /**
    * Adds an association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPK the primary key of the label
    * @throws SystemException if a system exception occurred
    */
    public static void addLabel(long pk, long labelPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLabel(pk, labelPK);
    }

    /**
    * Adds an association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param label the label
    * @throws SystemException if a system exception occurred
    */
    public static void addLabel(long pk, com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLabel(pk, label);
    }

    /**
    * Adds an association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPKs the primary keys of the labels
    * @throws SystemException if a system exception occurred
    */
    public static void addLabels(long pk, long[] labelPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLabels(pk, labelPKs);
    }

    /**
    * Adds an association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labels the labels
    * @throws SystemException if a system exception occurred
    */
    public static void addLabels(long pk,
        java.util.List<com.wcs.newsletter.model.Label> labels)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().addLabels(pk, labels);
    }

    /**
    * Clears all associations between the newsletter and its labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter to clear the associated labels from
    * @throws SystemException if a system exception occurred
    */
    public static void clearLabels(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().clearLabels(pk);
    }

    /**
    * Removes the association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPK the primary key of the label
    * @throws SystemException if a system exception occurred
    */
    public static void removeLabel(long pk, long labelPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLabel(pk, labelPK);
    }

    /**
    * Removes the association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param label the label
    * @throws SystemException if a system exception occurred
    */
    public static void removeLabel(long pk, com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLabel(pk, label);
    }

    /**
    * Removes the association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPKs the primary keys of the labels
    * @throws SystemException if a system exception occurred
    */
    public static void removeLabels(long pk, long[] labelPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLabels(pk, labelPKs);
    }

    /**
    * Removes the association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labels the labels
    * @throws SystemException if a system exception occurred
    */
    public static void removeLabels(long pk,
        java.util.List<com.wcs.newsletter.model.Label> labels)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeLabels(pk, labels);
    }

    /**
    * Sets the labels associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPKs the primary keys of the labels to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static void setLabels(long pk, long[] labelPKs)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setLabels(pk, labelPKs);
    }

    /**
    * Sets the labels associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labels the labels to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static void setLabels(long pk,
        java.util.List<com.wcs.newsletter.model.Label> labels)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().setLabels(pk, labels);
    }

    /**
    * Returns all the recipients associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the recipients associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        long pk) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRecipients(pk);
    }

    /**
    * Returns a range of all the recipients associated with the newsletter.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the newsletter
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @return the range of recipients associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRecipients(pk, start, end);
    }

    /**
    * Returns an ordered range of all the recipients associated with the newsletter.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param pk the primary key of the newsletter
    * @param start the lower bound of the range of newsletters
    * @param end the upper bound of the range of newsletters (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of recipients associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRecipients(pk, start, end, orderByComparator);
    }

    /**
    * Returns the number of recipients associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the number of recipients associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public static int getRecipientsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().getRecipientsSize(pk);
    }

    /**
    * Returns <code>true</code> if the recipient is associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @param recipientPK the primary key of the recipient
    * @return <code>true</code> if the recipient is associated with the newsletter; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsRecipient(long pk, long recipientPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsRecipient(pk, recipientPK);
    }

    /**
    * Returns <code>true</code> if the newsletter has any recipients associated with it.
    *
    * @param pk the primary key of the newsletter to check for associations with recipients
    * @return <code>true</code> if the newsletter has any recipients associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public static boolean containsRecipients(long pk)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().containsRecipients(pk);
    }

    public static NewsletterPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (NewsletterPersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    NewsletterPersistence.class.getName());

            ReferenceRegistry.registerReference(NewsletterUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(NewsletterPersistence persistence) {
    }
}
