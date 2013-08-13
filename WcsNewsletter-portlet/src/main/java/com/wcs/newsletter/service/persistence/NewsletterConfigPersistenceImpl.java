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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.wcs.newsletter.NoSuchNewsletterConfigException;
import com.wcs.newsletter.model.NewsletterConfig;
import com.wcs.newsletter.model.impl.NewsletterConfigImpl;
import com.wcs.newsletter.model.impl.NewsletterConfigModelImpl;
import com.wcs.newsletter.service.persistence.CategoryPersistence;
import com.wcs.newsletter.service.persistence.LabelPersistence;
import com.wcs.newsletter.service.persistence.NewsletterConfigPersistence;
import com.wcs.newsletter.service.persistence.NewsletterPersistence;
import com.wcs.newsletter.service.persistence.RecipientPersistence;
import com.wcs.newsletter.service.persistence.SubscriptionCategoryPersistence;
import com.wcs.newsletter.service.persistence.SubscriptionPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the newsletter config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterConfigPersistence
 * @see NewsletterConfigUtil
 * @generated
 */
public class NewsletterConfigPersistenceImpl extends BasePersistenceImpl<NewsletterConfig>
    implements NewsletterConfigPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link NewsletterConfigUtil} to access the newsletter config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = NewsletterConfigImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIGKEY =
        new FinderPath(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigModelImpl.FINDER_CACHE_ENABLED,
            NewsletterConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findByConfigKey",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGKEY =
        new FinderPath(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigModelImpl.FINDER_CACHE_ENABLED,
            NewsletterConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConfigKey",
            new String[] { String.class.getName() },
            NewsletterConfigModelImpl.CONFIGKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONFIGKEY = new FinderPath(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByConfigKey",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigModelImpl.FINDER_CACHE_ENABLED,
            NewsletterConfigImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
            "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigModelImpl.FINDER_CACHE_ENABLED,
            NewsletterConfigImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_NEWSLETTERCONFIG = "SELECT newsletterConfig FROM NewsletterConfig newsletterConfig";
    private static final String _SQL_SELECT_NEWSLETTERCONFIG_WHERE = "SELECT newsletterConfig FROM NewsletterConfig newsletterConfig WHERE ";
    private static final String _SQL_COUNT_NEWSLETTERCONFIG = "SELECT COUNT(newsletterConfig) FROM NewsletterConfig newsletterConfig";
    private static final String _SQL_COUNT_NEWSLETTERCONFIG_WHERE = "SELECT COUNT(newsletterConfig) FROM NewsletterConfig newsletterConfig WHERE ";
    private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1 = "newsletterConfig.configKey IS NULL";
    private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2 = "newsletterConfig.configKey = ?";
    private static final String _FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3 = "(newsletterConfig.configKey IS NULL OR newsletterConfig.configKey = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "newsletterConfig.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No NewsletterConfig exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No NewsletterConfig exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(NewsletterConfigPersistenceImpl.class);
    private static NewsletterConfig _nullNewsletterConfig = new NewsletterConfigImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<NewsletterConfig> toCacheModel() {
                return _nullNewsletterConfigCacheModel;
            }
        };

    private static CacheModel<NewsletterConfig> _nullNewsletterConfigCacheModel = new CacheModel<NewsletterConfig>() {
            public NewsletterConfig toEntityModel() {
                return _nullNewsletterConfig;
            }
        };

    @BeanReference(type = CategoryPersistence.class)
    protected CategoryPersistence categoryPersistence;
    @BeanReference(type = LabelPersistence.class)
    protected LabelPersistence labelPersistence;
    @BeanReference(type = NewsletterPersistence.class)
    protected NewsletterPersistence newsletterPersistence;
    @BeanReference(type = NewsletterConfigPersistence.class)
    protected NewsletterConfigPersistence newsletterConfigPersistence;
    @BeanReference(type = RecipientPersistence.class)
    protected RecipientPersistence recipientPersistence;
    @BeanReference(type = SubscriptionPersistence.class)
    protected SubscriptionPersistence subscriptionPersistence;
    @BeanReference(type = SubscriptionCategoryPersistence.class)
    protected SubscriptionCategoryPersistence subscriptionCategoryPersistence;
    @BeanReference(type = ResourcePersistence.class)
    protected ResourcePersistence resourcePersistence;
    @BeanReference(type = UserPersistence.class)
    protected UserPersistence userPersistence;

    /**
     * Caches the newsletter config in the entity cache if it is enabled.
     *
     * @param newsletterConfig the newsletter config
     */
    public void cacheResult(NewsletterConfig newsletterConfig) {
        EntityCacheUtil.putResult(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigImpl.class, newsletterConfig.getPrimaryKey(),
            newsletterConfig);

        newsletterConfig.resetOriginalValues();
    }

    /**
     * Caches the newsletter configs in the entity cache if it is enabled.
     *
     * @param newsletterConfigs the newsletter configs
     */
    public void cacheResult(List<NewsletterConfig> newsletterConfigs) {
        for (NewsletterConfig newsletterConfig : newsletterConfigs) {
            if (EntityCacheUtil.getResult(
                        NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
                        NewsletterConfigImpl.class,
                        newsletterConfig.getPrimaryKey()) == null) {
                cacheResult(newsletterConfig);
            } else {
                newsletterConfig.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all newsletter configs.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(NewsletterConfigImpl.class.getName());
        }

        EntityCacheUtil.clearCache(NewsletterConfigImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the newsletter config.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(NewsletterConfig newsletterConfig) {
        EntityCacheUtil.removeResult(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigImpl.class, newsletterConfig.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<NewsletterConfig> newsletterConfigs) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (NewsletterConfig newsletterConfig : newsletterConfigs) {
            EntityCacheUtil.removeResult(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
                NewsletterConfigImpl.class, newsletterConfig.getPrimaryKey());
        }
    }

    /**
     * Creates a new newsletter config with the primary key. Does not add the newsletter config to the database.
     *
     * @param configId the primary key for the new newsletter config
     * @return the new newsletter config
     */
    public NewsletterConfig create(long configId) {
        NewsletterConfig newsletterConfig = new NewsletterConfigImpl();

        newsletterConfig.setNew(true);
        newsletterConfig.setPrimaryKey(configId);

        return newsletterConfig;
    }

    /**
     * Removes the newsletter config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param configId the primary key of the newsletter config
     * @return the newsletter config that was removed
     * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public NewsletterConfig remove(long configId)
        throws NoSuchNewsletterConfigException, SystemException {
        return remove(Long.valueOf(configId));
    }

    /**
     * Removes the newsletter config with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the newsletter config
     * @return the newsletter config that was removed
     * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public NewsletterConfig remove(Serializable primaryKey)
        throws NoSuchNewsletterConfigException, SystemException {
        Session session = null;

        try {
            session = openSession();

            NewsletterConfig newsletterConfig = (NewsletterConfig) session.get(NewsletterConfigImpl.class,
                    primaryKey);

            if (newsletterConfig == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchNewsletterConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(newsletterConfig);
        } catch (NoSuchNewsletterConfigException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected NewsletterConfig removeImpl(NewsletterConfig newsletterConfig)
        throws SystemException {
        newsletterConfig = toUnwrappedModel(newsletterConfig);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, newsletterConfig);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(newsletterConfig);

        return newsletterConfig;
    }

    @Override
    public NewsletterConfig updateImpl(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig,
        boolean merge) throws SystemException {
        newsletterConfig = toUnwrappedModel(newsletterConfig);

        boolean isNew = newsletterConfig.isNew();

        NewsletterConfigModelImpl newsletterConfigModelImpl = (NewsletterConfigModelImpl) newsletterConfig;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, newsletterConfig, merge);

            newsletterConfig.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !NewsletterConfigModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((newsletterConfigModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        newsletterConfigModelImpl.getOriginalConfigKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGKEY,
                    args);

                args = new Object[] { newsletterConfigModelImpl.getConfigKey() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIGKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGKEY,
                    args);
            }
        }

        EntityCacheUtil.putResult(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterConfigImpl.class, newsletterConfig.getPrimaryKey(),
            newsletterConfig);

        return newsletterConfig;
    }

    protected NewsletterConfig toUnwrappedModel(
        NewsletterConfig newsletterConfig) {
        if (newsletterConfig instanceof NewsletterConfigImpl) {
            return newsletterConfig;
        }

        NewsletterConfigImpl newsletterConfigImpl = new NewsletterConfigImpl();

        newsletterConfigImpl.setNew(newsletterConfig.isNew());
        newsletterConfigImpl.setPrimaryKey(newsletterConfig.getPrimaryKey());

        newsletterConfigImpl.setConfigId(newsletterConfig.getConfigId());
        newsletterConfigImpl.setConfigKey(newsletterConfig.getConfigKey());
        newsletterConfigImpl.setConfigValue(newsletterConfig.getConfigValue());

        return newsletterConfigImpl;
    }

    /**
     * Returns the newsletter config with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the newsletter config
     * @return the newsletter config
     * @throws com.liferay.portal.NoSuchModelException if a newsletter config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public NewsletterConfig findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the newsletter config with the primary key or throws a {@link com.wcs.newsletter.NoSuchNewsletterConfigException} if it could not be found.
     *
     * @param configId the primary key of the newsletter config
     * @return the newsletter config
     * @throws com.wcs.newsletter.NoSuchNewsletterConfigException if a newsletter config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public NewsletterConfig findByPrimaryKey(long configId)
        throws NoSuchNewsletterConfigException, SystemException {
        NewsletterConfig newsletterConfig = fetchByPrimaryKey(configId);

        if (newsletterConfig == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + configId);
            }

            throw new NoSuchNewsletterConfigException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                configId);
        }

        return newsletterConfig;
    }

    /**
     * Returns the newsletter config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the newsletter config
     * @return the newsletter config, or <code>null</code> if a newsletter config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public NewsletterConfig fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the newsletter config with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param configId the primary key of the newsletter config
     * @return the newsletter config, or <code>null</code> if a newsletter config with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public NewsletterConfig fetchByPrimaryKey(long configId)
        throws SystemException {
        NewsletterConfig newsletterConfig = (NewsletterConfig) EntityCacheUtil.getResult(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
                NewsletterConfigImpl.class, configId);

        if (newsletterConfig == _nullNewsletterConfig) {
            return null;
        }

        if (newsletterConfig == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                newsletterConfig = (NewsletterConfig) session.get(NewsletterConfigImpl.class,
                        Long.valueOf(configId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (newsletterConfig != null) {
                    cacheResult(newsletterConfig);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(NewsletterConfigModelImpl.ENTITY_CACHE_ENABLED,
                        NewsletterConfigImpl.class, configId,
                        _nullNewsletterConfig);
                }

                closeSession(session);
            }
        }

        return newsletterConfig;
    }

    /**
     * Returns all the newsletter configs where configKey = &#63;.
     *
     * @param configKey the config key
     * @return the matching newsletter configs
     * @throws SystemException if a system exception occurred
     */
    public List<NewsletterConfig> findByConfigKey(String configKey)
        throws SystemException {
        return findByConfigKey(configKey, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    public List<NewsletterConfig> findByConfigKey(String configKey, int start,
        int end) throws SystemException {
        return findByConfigKey(configKey, start, end, null);
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
    public List<NewsletterConfig> findByConfigKey(String configKey, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIGKEY;
            finderArgs = new Object[] { configKey };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIGKEY;
            finderArgs = new Object[] { configKey, start, end, orderByComparator };
        }

        List<NewsletterConfig> list = (List<NewsletterConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (NewsletterConfig newsletterConfig : list) {
                if (!Validator.equals(configKey, newsletterConfig.getConfigKey())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(3 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(2);
            }

            query.append(_SQL_SELECT_NEWSLETTERCONFIG_WHERE);

            if (configKey == null) {
                query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1);
            } else {
                if (configKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2);
                }
            }

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (configKey != null) {
                    qPos.add(configKey);
                }

                list = (List<NewsletterConfig>) QueryUtil.list(q, getDialect(),
                        start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
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
    public NewsletterConfig findByConfigKey_First(String configKey,
        OrderByComparator orderByComparator)
        throws NoSuchNewsletterConfigException, SystemException {
        NewsletterConfig newsletterConfig = fetchByConfigKey_First(configKey,
                orderByComparator);

        if (newsletterConfig != null) {
            return newsletterConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("configKey=");
        msg.append(configKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNewsletterConfigException(msg.toString());
    }

    /**
     * Returns the first newsletter config in the ordered set where configKey = &#63;.
     *
     * @param configKey the config key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching newsletter config, or <code>null</code> if a matching newsletter config could not be found
     * @throws SystemException if a system exception occurred
     */
    public NewsletterConfig fetchByConfigKey_First(String configKey,
        OrderByComparator orderByComparator) throws SystemException {
        List<NewsletterConfig> list = findByConfigKey(configKey, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public NewsletterConfig findByConfigKey_Last(String configKey,
        OrderByComparator orderByComparator)
        throws NoSuchNewsletterConfigException, SystemException {
        NewsletterConfig newsletterConfig = fetchByConfigKey_Last(configKey,
                orderByComparator);

        if (newsletterConfig != null) {
            return newsletterConfig;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("configKey=");
        msg.append(configKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNewsletterConfigException(msg.toString());
    }

    /**
     * Returns the last newsletter config in the ordered set where configKey = &#63;.
     *
     * @param configKey the config key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching newsletter config, or <code>null</code> if a matching newsletter config could not be found
     * @throws SystemException if a system exception occurred
     */
    public NewsletterConfig fetchByConfigKey_Last(String configKey,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByConfigKey(configKey);

        List<NewsletterConfig> list = findByConfigKey(configKey, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public NewsletterConfig[] findByConfigKey_PrevAndNext(long configId,
        String configKey, OrderByComparator orderByComparator)
        throws NoSuchNewsletterConfigException, SystemException {
        NewsletterConfig newsletterConfig = findByPrimaryKey(configId);

        Session session = null;

        try {
            session = openSession();

            NewsletterConfig[] array = new NewsletterConfigImpl[3];

            array[0] = getByConfigKey_PrevAndNext(session, newsletterConfig,
                    configKey, orderByComparator, true);

            array[1] = newsletterConfig;

            array[2] = getByConfigKey_PrevAndNext(session, newsletterConfig,
                    configKey, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected NewsletterConfig getByConfigKey_PrevAndNext(Session session,
        NewsletterConfig newsletterConfig, String configKey,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NEWSLETTERCONFIG_WHERE);

        if (configKey == null) {
            query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1);
        } else {
            if (configKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3);
            } else {
                query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2);
            }
        }

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        if (configKey != null) {
            qPos.add(configKey);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(newsletterConfig);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<NewsletterConfig> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the newsletter configs.
     *
     * @return the newsletter configs
     * @throws SystemException if a system exception occurred
     */
    public List<NewsletterConfig> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<NewsletterConfig> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<NewsletterConfig> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = new Object[] { start, end, orderByComparator };

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<NewsletterConfig> list = (List<NewsletterConfig>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_NEWSLETTERCONFIG);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_NEWSLETTERCONFIG;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<NewsletterConfig>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<NewsletterConfig>) QueryUtil.list(q,
                            getDialect(), start, end);
                }
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(finderPath, finderArgs);
                } else {
                    cacheResult(list);

                    FinderCacheUtil.putResult(finderPath, finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the newsletter configs where configKey = &#63; from the database.
     *
     * @param configKey the config key
     * @throws SystemException if a system exception occurred
     */
    public void removeByConfigKey(String configKey) throws SystemException {
        for (NewsletterConfig newsletterConfig : findByConfigKey(configKey)) {
            remove(newsletterConfig);
        }
    }

    /**
     * Removes all the newsletter configs from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (NewsletterConfig newsletterConfig : findAll()) {
            remove(newsletterConfig);
        }
    }

    /**
     * Returns the number of newsletter configs where configKey = &#63;.
     *
     * @param configKey the config key
     * @return the number of matching newsletter configs
     * @throws SystemException if a system exception occurred
     */
    public int countByConfigKey(String configKey) throws SystemException {
        Object[] finderArgs = new Object[] { configKey };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONFIGKEY,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NEWSLETTERCONFIG_WHERE);

            if (configKey == null) {
                query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_1);
            } else {
                if (configKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_CONFIGKEY_CONFIGKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (configKey != null) {
                    qPos.add(configKey);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONFIGKEY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of newsletter configs.
     *
     * @return the number of newsletter configs
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_NEWSLETTERCONFIG);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the newsletter config persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.wcs.newsletter.model.NewsletterConfig")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<NewsletterConfig>> listenersList = new ArrayList<ModelListener<NewsletterConfig>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<NewsletterConfig>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(NewsletterConfigImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
