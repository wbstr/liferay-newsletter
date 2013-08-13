package com.wcs.newsletter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.NewsletterConfig;

import java.util.List;

/**
 * The persistence utility for the newsletter config service. This utility wraps {@link NewsletterConfigPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterConfigPersistence
 * @see NewsletterConfigPersistenceImpl
 * @generated
 */
public class NewsletterConfigUtil {
    private static NewsletterConfigPersistence _persistence;

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
    public static void clearCache(NewsletterConfig newsletterConfig) {
        getPersistence().clearCache(newsletterConfig);
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
    public static List<NewsletterConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<NewsletterConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<NewsletterConfig> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static NewsletterConfig update(NewsletterConfig newsletterConfig,
        boolean merge) throws SystemException {
        return getPersistence().update(newsletterConfig, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static NewsletterConfig update(NewsletterConfig newsletterConfig,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(newsletterConfig, merge, serviceContext);
    }

    /**
    * Caches the newsletter config in the entity cache if it is enabled.
    *
    * @param newsletterConfig the newsletter config
    */
    public static void cacheResult(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig) {
        getPersistence().cacheResult(newsletterConfig);
    }

    /**
    * Caches the newsletter configs in the entity cache if it is enabled.
    *
    * @param newsletterConfigs the newsletter configs
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.NewsletterConfig> newsletterConfigs) {
        getPersistence().cacheResult(newsletterConfigs);
    }

    /**
    * Creates a new newsletter config with the primary key. Does not add the newsletter config to the database.
    *
    * @param configId the primary key for the new newsletter config
    * @return the new newsletter config
    */
    public static com.wcs.newsletter.model.NewsletterConfig create(
        long configId) {
        return getPersistence().create(configId);
    }

    /**
    * Removes the newsletter config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config that was removed
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig remove(
        long configId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException {
        return getPersistence().remove(configId);
    }

    public static com.wcs.newsletter.model.NewsletterConfig updateImpl(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(newsletterConfig, merge);
    }

    /**
    * Returns the newsletter config with the primary key or throws a {@link com.wcs.newsletter.NoSuchNewsletterConfigException} if it could not be found.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig findByPrimaryKey(
        long configId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException {
        return getPersistence().findByPrimaryKey(configId);
    }

    /**
    * Returns the newsletter config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config, or <code>null</code> if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig fetchByPrimaryKey(
        long configId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(configId);
    }

    /**
    * Returns all the newsletter configs where configKey = &#63;.
    *
    * @param configKey the config key
    * @return the matching newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.NewsletterConfig> findByConfigKey(
        java.lang.String configKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByConfigKey(configKey);
    }

    /**
    * Returns a range of all the newsletter configs where configKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param configKey the config key
    * @param start the lower bound of the range of newsletter configs
    * @param end the upper bound of the range of newsletter configs (not inclusive)
    * @return the range of matching newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.NewsletterConfig> findByConfigKey(
        java.lang.String configKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByConfigKey(configKey, start, end);
    }

    /**
    * Returns an ordered range of all the newsletter configs where configKey = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param configKey the config key
    * @param start the lower bound of the range of newsletter configs
    * @param end the upper bound of the range of newsletter configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.NewsletterConfig> findByConfigKey(
        java.lang.String configKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByConfigKey(configKey, start, end, orderByComparator);
    }

    /**
    * Returns the first newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter config
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig findByConfigKey_First(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException {
        return getPersistence()
                   .findByConfigKey_First(configKey, orderByComparator);
    }

    /**
    * Returns the first newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter config, or <code>null</code> if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig fetchByConfigKey_First(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConfigKey_First(configKey, orderByComparator);
    }

    /**
    * Returns the last newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter config
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig findByConfigKey_Last(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException {
        return getPersistence()
                   .findByConfigKey_Last(configKey, orderByComparator);
    }

    /**
    * Returns the last newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter config, or <code>null</code> if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig fetchByConfigKey_Last(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByConfigKey_Last(configKey, orderByComparator);
    }

    /**
    * Returns the newsletter configs before and after the current newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configId the primary key of the current newsletter config
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next newsletter config
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.NewsletterConfig[] findByConfigKey_PrevAndNext(
        long configId, java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException {
        return getPersistence()
                   .findByConfigKey_PrevAndNext(configId, configKey,
            orderByComparator);
    }

    /**
    * Returns all the newsletter configs.
    *
    * @return the newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.NewsletterConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the newsletter configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newsletter configs
    * @param end the upper bound of the range of newsletter configs (not inclusive)
    * @return the range of newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.NewsletterConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the newsletter configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newsletter configs
    * @param end the upper bound of the range of newsletter configs (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.NewsletterConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the newsletter configs where configKey = &#63; from the database.
    *
    * @param configKey the config key
    * @throws SystemException if a system exception occurred
    */
    public static void removeByConfigKey(java.lang.String configKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByConfigKey(configKey);
    }

    /**
    * Removes all the newsletter configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of newsletter configs where configKey = &#63;.
    *
    * @param configKey the config key
    * @return the number of matching newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static int countByConfigKey(java.lang.String configKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByConfigKey(configKey);
    }

    /**
    * Returns the number of newsletter configs.
    *
    * @return the number of newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static NewsletterConfigPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (NewsletterConfigPersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    NewsletterConfigPersistence.class.getName());

            ReferenceRegistry.registerReference(NewsletterConfigUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(NewsletterConfigPersistence persistence) {
    }
}
