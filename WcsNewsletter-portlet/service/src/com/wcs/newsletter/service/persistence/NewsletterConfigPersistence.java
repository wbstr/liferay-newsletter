package com.wcs.newsletter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.wcs.newsletter.model.NewsletterConfig;

/**
 * The persistence interface for the newsletter config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterConfigPersistenceImpl
 * @see NewsletterConfigUtil
 * @generated
 */
public interface NewsletterConfigPersistence extends BasePersistence<NewsletterConfig> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link NewsletterConfigUtil} to access the newsletter config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the newsletter config in the entity cache if it is enabled.
    *
    * @param newsletterConfig the newsletter config
    */
    public void cacheResult(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig);

    /**
    * Caches the newsletter configs in the entity cache if it is enabled.
    *
    * @param newsletterConfigs the newsletter configs
    */
    public void cacheResult(
        java.util.List<com.wcs.newsletter.model.NewsletterConfig> newsletterConfigs);

    /**
    * Creates a new newsletter config with the primary key. Does not add the newsletter config to the database.
    *
    * @param configId the primary key for the new newsletter config
    * @return the new newsletter config
    */
    public com.wcs.newsletter.model.NewsletterConfig create(long configId);

    /**
    * Removes the newsletter config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config that was removed
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig remove(long configId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException;

    public com.wcs.newsletter.model.NewsletterConfig updateImpl(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the newsletter config with the primary key or throws a {@link com.wcs.newsletter.NoSuchNewsletterConfigException} if it could not be found.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig findByPrimaryKey(
        long configId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException;

    /**
    * Returns the newsletter config with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config, or <code>null</code> if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig fetchByPrimaryKey(
        long configId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the newsletter configs where configKey = &#63;.
    *
    * @param configKey the config key
    * @return the matching newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> findByConfigKey(
        java.lang.String configKey)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> findByConfigKey(
        java.lang.String configKey, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> findByConfigKey(
        java.lang.String configKey, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter config
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig findByConfigKey_First(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException;

    /**
    * Returns the first newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter config, or <code>null</code> if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig fetchByConfigKey_First(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter config
    * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig findByConfigKey_Last(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException;

    /**
    * Returns the last newsletter config in the ordered set where configKey = &#63;.
    *
    * @param configKey the config key
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter config, or <code>null</code> if a matching newsletter config could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig fetchByConfigKey_Last(
        java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.NewsletterConfig[] findByConfigKey_PrevAndNext(
        long configId, java.lang.String configKey,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterConfigException;

    /**
    * Returns all the newsletter configs.
    *
    * @return the newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newsletter configs where configKey = &#63; from the database.
    *
    * @param configKey the config key
    * @throws SystemException if a system exception occurred
    */
    public void removeByConfigKey(java.lang.String configKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newsletter configs from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newsletter configs where configKey = &#63;.
    *
    * @param configKey the config key
    * @return the number of matching newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public int countByConfigKey(java.lang.String configKey)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newsletter configs.
    *
    * @return the number of newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
