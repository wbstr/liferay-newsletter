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

import com.wcs.newsletter.NoSuchSubscriptionCategoryException;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.model.impl.SubscriptionCategoryImpl;
import com.wcs.newsletter.model.impl.SubscriptionCategoryModelImpl;
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
 * The persistence implementation for the subscription category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionCategoryPersistence
 * @see SubscriptionCategoryUtil
 * @generated
 */
public class SubscriptionCategoryPersistenceImpl extends BasePersistenceImpl<SubscriptionCategory>
    implements SubscriptionCategoryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SubscriptionCategoryUtil} to access the subscription category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SubscriptionCategoryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBSCRIPTIONID =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findBySubscriptionId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTIONID =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findBySubscriptionId",
            new String[] { Long.class.getName() },
            SubscriptionCategoryModelImpl.SUBSCRIPTIONID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_SUBSCRIPTIONID = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBySubscriptionId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
            new String[] { Long.class.getName() },
            SubscriptionCategoryModelImpl.CATEGORYID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CATEGORYID = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIRMATIONKEY =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByConfirmationKey",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIRMATIONKEY =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByConfirmationKey",
            new String[] { String.class.getName() },
            SubscriptionCategoryModelImpl.CONFIRMATIONKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CONFIRMATIONKEY = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByConfirmationKey", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_CANCELLATIONKEY =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCancellationKey",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANCELLATIONKEY =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCancellationKey",
            new String[] { String.class.getName() },
            SubscriptionCategoryModelImpl.CANCELLATIONKEY_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_CANCELLATIONKEY = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "countByCancellationKey", new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
        new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
            new String[] { String.class.getName() },
            SubscriptionCategoryModelImpl.STATUS_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SUBSCRIPTIONCATEGORY = "SELECT subscriptionCategory FROM SubscriptionCategory subscriptionCategory";
    private static final String _SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE = "SELECT subscriptionCategory FROM SubscriptionCategory subscriptionCategory WHERE ";
    private static final String _SQL_COUNT_SUBSCRIPTIONCATEGORY = "SELECT COUNT(subscriptionCategory) FROM SubscriptionCategory subscriptionCategory";
    private static final String _SQL_COUNT_SUBSCRIPTIONCATEGORY_WHERE = "SELECT COUNT(subscriptionCategory) FROM SubscriptionCategory subscriptionCategory WHERE ";
    private static final String _FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2 = "subscriptionCategory.id.subscriptionId = ?";
    private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 = "subscriptionCategory.id.categoryId = ?";
    private static final String _FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_1 =
        "subscriptionCategory.confirmationKey IS NULL";
    private static final String _FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_2 =
        "subscriptionCategory.confirmationKey = ?";
    private static final String _FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_3 =
        "(subscriptionCategory.confirmationKey IS NULL OR subscriptionCategory.confirmationKey = ?)";
    private static final String _FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_1 =
        "subscriptionCategory.cancellationKey IS NULL";
    private static final String _FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_2 =
        "subscriptionCategory.cancellationKey = ?";
    private static final String _FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_3 =
        "(subscriptionCategory.cancellationKey IS NULL OR subscriptionCategory.cancellationKey = ?)";
    private static final String _FINDER_COLUMN_STATUS_STATUS_1 = "subscriptionCategory.status IS NULL";
    private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "subscriptionCategory.status = ?";
    private static final String _FINDER_COLUMN_STATUS_STATUS_3 = "(subscriptionCategory.status IS NULL OR subscriptionCategory.status = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "subscriptionCategory.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No SubscriptionCategory exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No SubscriptionCategory exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SubscriptionCategoryPersistenceImpl.class);
    private static SubscriptionCategory _nullSubscriptionCategory = new SubscriptionCategoryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<SubscriptionCategory> toCacheModel() {
                return _nullSubscriptionCategoryCacheModel;
            }
        };

    private static CacheModel<SubscriptionCategory> _nullSubscriptionCategoryCacheModel =
        new CacheModel<SubscriptionCategory>() {
            public SubscriptionCategory toEntityModel() {
                return _nullSubscriptionCategory;
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
     * Caches the subscription category in the entity cache if it is enabled.
     *
     * @param subscriptionCategory the subscription category
     */
    public void cacheResult(SubscriptionCategory subscriptionCategory) {
        EntityCacheUtil.putResult(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            subscriptionCategory.getPrimaryKey(), subscriptionCategory);

        subscriptionCategory.resetOriginalValues();
    }

    /**
     * Caches the subscription categories in the entity cache if it is enabled.
     *
     * @param subscriptionCategories the subscription categories
     */
    public void cacheResult(List<SubscriptionCategory> subscriptionCategories) {
        for (SubscriptionCategory subscriptionCategory : subscriptionCategories) {
            if (EntityCacheUtil.getResult(
                        SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptionCategoryImpl.class,
                        subscriptionCategory.getPrimaryKey()) == null) {
                cacheResult(subscriptionCategory);
            } else {
                subscriptionCategory.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all subscription categories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SubscriptionCategoryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SubscriptionCategoryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the subscription category.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(SubscriptionCategory subscriptionCategory) {
        EntityCacheUtil.removeResult(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryImpl.class, subscriptionCategory.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<SubscriptionCategory> subscriptionCategories) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (SubscriptionCategory subscriptionCategory : subscriptionCategories) {
            EntityCacheUtil.removeResult(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptionCategoryImpl.class,
                subscriptionCategory.getPrimaryKey());
        }
    }

    /**
     * Creates a new subscription category with the primary key. Does not add the subscription category to the database.
     *
     * @param subscriptionCategoryPK the primary key for the new subscription category
     * @return the new subscription category
     */
    public SubscriptionCategory create(
        SubscriptionCategoryPK subscriptionCategoryPK) {
        SubscriptionCategory subscriptionCategory = new SubscriptionCategoryImpl();

        subscriptionCategory.setNew(true);
        subscriptionCategory.setPrimaryKey(subscriptionCategoryPK);

        return subscriptionCategory;
    }

    /**
     * Removes the subscription category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param subscriptionCategoryPK the primary key of the subscription category
     * @return the subscription category that was removed
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory remove(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws NoSuchSubscriptionCategoryException, SystemException {
        return remove((Serializable) subscriptionCategoryPK);
    }

    /**
     * Removes the subscription category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the subscription category
     * @return the subscription category that was removed
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptionCategory remove(Serializable primaryKey)
        throws NoSuchSubscriptionCategoryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            SubscriptionCategory subscriptionCategory = (SubscriptionCategory) session.get(SubscriptionCategoryImpl.class,
                    primaryKey);

            if (subscriptionCategory == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSubscriptionCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(subscriptionCategory);
        } catch (NoSuchSubscriptionCategoryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected SubscriptionCategory removeImpl(
        SubscriptionCategory subscriptionCategory) throws SystemException {
        subscriptionCategory = toUnwrappedModel(subscriptionCategory);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, subscriptionCategory);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(subscriptionCategory);

        return subscriptionCategory;
    }

    @Override
    public SubscriptionCategory updateImpl(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory,
        boolean merge) throws SystemException {
        subscriptionCategory = toUnwrappedModel(subscriptionCategory);

        boolean isNew = subscriptionCategory.isNew();

        SubscriptionCategoryModelImpl subscriptionCategoryModelImpl = (SubscriptionCategoryModelImpl) subscriptionCategory;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, subscriptionCategory, merge);

            subscriptionCategory.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SubscriptionCategoryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((subscriptionCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTIONID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(subscriptionCategoryModelImpl.getOriginalSubscriptionId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIPTIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTIONID,
                    args);

                args = new Object[] {
                        Long.valueOf(subscriptionCategoryModelImpl.getSubscriptionId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_SUBSCRIPTIONID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTIONID,
                    args);
            }

            if ((subscriptionCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(subscriptionCategoryModelImpl.getOriginalCategoryId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
                    args);

                args = new Object[] {
                        Long.valueOf(subscriptionCategoryModelImpl.getCategoryId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CATEGORYID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID,
                    args);
            }

            if ((subscriptionCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIRMATIONKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptionCategoryModelImpl.getOriginalConfirmationKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIRMATIONKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIRMATIONKEY,
                    args);

                args = new Object[] {
                        subscriptionCategoryModelImpl.getConfirmationKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CONFIRMATIONKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIRMATIONKEY,
                    args);
            }

            if ((subscriptionCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANCELLATIONKEY.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptionCategoryModelImpl.getOriginalCancellationKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANCELLATIONKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANCELLATIONKEY,
                    args);

                args = new Object[] {
                        subscriptionCategoryModelImpl.getCancellationKey()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CANCELLATIONKEY,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANCELLATIONKEY,
                    args);
            }

            if ((subscriptionCategoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptionCategoryModelImpl.getOriginalStatus()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);

                args = new Object[] { subscriptionCategoryModelImpl.getStatus() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
                    args);
            }
        }

        EntityCacheUtil.putResult(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionCategoryImpl.class,
            subscriptionCategory.getPrimaryKey(), subscriptionCategory);

        return subscriptionCategory;
    }

    protected SubscriptionCategory toUnwrappedModel(
        SubscriptionCategory subscriptionCategory) {
        if (subscriptionCategory instanceof SubscriptionCategoryImpl) {
            return subscriptionCategory;
        }

        SubscriptionCategoryImpl subscriptionCategoryImpl = new SubscriptionCategoryImpl();

        subscriptionCategoryImpl.setNew(subscriptionCategory.isNew());
        subscriptionCategoryImpl.setPrimaryKey(subscriptionCategory.getPrimaryKey());

        subscriptionCategoryImpl.setSubscriptionId(subscriptionCategory.getSubscriptionId());
        subscriptionCategoryImpl.setCategoryId(subscriptionCategory.getCategoryId());
        subscriptionCategoryImpl.setConfirmationKey(subscriptionCategory.getConfirmationKey());
        subscriptionCategoryImpl.setCancellationKey(subscriptionCategory.getCancellationKey());
        subscriptionCategoryImpl.setStatus(subscriptionCategory.getStatus());

        return subscriptionCategoryImpl;
    }

    /**
     * Returns the subscription category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the subscription category
     * @return the subscription category
     * @throws com.liferay.portal.NoSuchModelException if a subscription category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptionCategory findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey((SubscriptionCategoryPK) primaryKey);
    }

    /**
     * Returns the subscription category with the primary key or throws a {@link com.wcs.newsletter.NoSuchSubscriptionCategoryException} if it could not be found.
     *
     * @param subscriptionCategoryPK the primary key of the subscription category
     * @return the subscription category
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a subscription category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory findByPrimaryKey(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByPrimaryKey(subscriptionCategoryPK);

        if (subscriptionCategory == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    subscriptionCategoryPK);
            }

            throw new NoSuchSubscriptionCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                subscriptionCategoryPK);
        }

        return subscriptionCategory;
    }

    /**
     * Returns the subscription category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the subscription category
     * @return the subscription category, or <code>null</code> if a subscription category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public SubscriptionCategory fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey((SubscriptionCategoryPK) primaryKey);
    }

    /**
     * Returns the subscription category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param subscriptionCategoryPK the primary key of the subscription category
     * @return the subscription category, or <code>null</code> if a subscription category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByPrimaryKey(
        SubscriptionCategoryPK subscriptionCategoryPK)
        throws SystemException {
        SubscriptionCategory subscriptionCategory = (SubscriptionCategory) EntityCacheUtil.getResult(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptionCategoryImpl.class, subscriptionCategoryPK);

        if (subscriptionCategory == _nullSubscriptionCategory) {
            return null;
        }

        if (subscriptionCategory == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                subscriptionCategory = (SubscriptionCategory) session.get(SubscriptionCategoryImpl.class,
                        subscriptionCategoryPK);
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (subscriptionCategory != null) {
                    cacheResult(subscriptionCategory);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(SubscriptionCategoryModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptionCategoryImpl.class, subscriptionCategoryPK,
                        _nullSubscriptionCategory);
                }

                closeSession(session);
            }
        }

        return subscriptionCategory;
    }

    /**
     * Returns all the subscription categories where subscriptionId = &#63;.
     *
     * @param subscriptionId the subscription ID
     * @return the matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public List<SubscriptionCategory> findBySubscriptionId(long subscriptionId)
        throws SystemException {
        return findBySubscriptionId(subscriptionId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<SubscriptionCategory> findBySubscriptionId(
        long subscriptionId, int start, int end) throws SystemException {
        return findBySubscriptionId(subscriptionId, start, end, null);
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
    public List<SubscriptionCategory> findBySubscriptionId(
        long subscriptionId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SUBSCRIPTIONID;
            finderArgs = new Object[] { subscriptionId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SUBSCRIPTIONID;
            finderArgs = new Object[] {
                    subscriptionId,
                    
                    start, end, orderByComparator
                };
        }

        List<SubscriptionCategory> list = (List<SubscriptionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SubscriptionCategory subscriptionCategory : list) {
                if ((subscriptionId != subscriptionCategory.getSubscriptionId())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

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

                qPos.add(subscriptionId);

                list = (List<SubscriptionCategory>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first subscription category in the ordered set where subscriptionId = &#63;.
     *
     * @param subscriptionId the subscription ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory findBySubscriptionId_First(
        long subscriptionId, OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchBySubscriptionId_First(subscriptionId,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("subscriptionId=");
        msg.append(subscriptionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the first subscription category in the ordered set where subscriptionId = &#63;.
     *
     * @param subscriptionId the subscription ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchBySubscriptionId_First(
        long subscriptionId, OrderByComparator orderByComparator)
        throws SystemException {
        List<SubscriptionCategory> list = findBySubscriptionId(subscriptionId,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory findBySubscriptionId_Last(long subscriptionId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchBySubscriptionId_Last(subscriptionId,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("subscriptionId=");
        msg.append(subscriptionId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the last subscription category in the ordered set where subscriptionId = &#63;.
     *
     * @param subscriptionId the subscription ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchBySubscriptionId_Last(
        long subscriptionId, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countBySubscriptionId(subscriptionId);

        List<SubscriptionCategory> list = findBySubscriptionId(subscriptionId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory[] findBySubscriptionId_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, long subscriptionId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = findByPrimaryKey(subscriptionCategoryPK);

        Session session = null;

        try {
            session = openSession();

            SubscriptionCategory[] array = new SubscriptionCategoryImpl[3];

            array[0] = getBySubscriptionId_PrevAndNext(session,
                    subscriptionCategory, subscriptionId, orderByComparator,
                    true);

            array[1] = subscriptionCategory;

            array[2] = getBySubscriptionId_PrevAndNext(session,
                    subscriptionCategory, subscriptionId, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SubscriptionCategory getBySubscriptionId_PrevAndNext(
        Session session, SubscriptionCategory subscriptionCategory,
        long subscriptionId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

        query.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

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

        qPos.add(subscriptionId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptionCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SubscriptionCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the subscription categories where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @return the matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public List<SubscriptionCategory> findByCategoryId(long categoryId)
        throws SystemException {
        return findByCategoryId(categoryId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<SubscriptionCategory> findByCategoryId(long categoryId,
        int start, int end) throws SystemException {
        return findByCategoryId(categoryId, start, end, null);
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
    public List<SubscriptionCategory> findByCategoryId(long categoryId,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CATEGORYID;
            finderArgs = new Object[] { categoryId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CATEGORYID;
            finderArgs = new Object[] { categoryId, start, end, orderByComparator };
        }

        List<SubscriptionCategory> list = (List<SubscriptionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SubscriptionCategory subscriptionCategory : list) {
                if ((categoryId != subscriptionCategory.getCategoryId())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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

                qPos.add(categoryId);

                list = (List<SubscriptionCategory>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first subscription category in the ordered set where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory findByCategoryId_First(long categoryId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByCategoryId_First(categoryId,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the first subscription category in the ordered set where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByCategoryId_First(long categoryId,
        OrderByComparator orderByComparator) throws SystemException {
        List<SubscriptionCategory> list = findByCategoryId(categoryId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory findByCategoryId_Last(long categoryId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByCategoryId_Last(categoryId,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("categoryId=");
        msg.append(categoryId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the last subscription category in the ordered set where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByCategoryId_Last(long categoryId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByCategoryId(categoryId);

        List<SubscriptionCategory> list = findByCategoryId(categoryId,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory[] findByCategoryId_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, long categoryId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = findByPrimaryKey(subscriptionCategoryPK);

        Session session = null;

        try {
            session = openSession();

            SubscriptionCategory[] array = new SubscriptionCategoryImpl[3];

            array[0] = getByCategoryId_PrevAndNext(session,
                    subscriptionCategory, categoryId, orderByComparator, true);

            array[1] = subscriptionCategory;

            array[2] = getByCategoryId_PrevAndNext(session,
                    subscriptionCategory, categoryId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SubscriptionCategory getByCategoryId_PrevAndNext(
        Session session, SubscriptionCategory subscriptionCategory,
        long categoryId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

        query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

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

        qPos.add(categoryId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptionCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SubscriptionCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the subscription categories where confirmationKey = &#63;.
     *
     * @param confirmationKey the confirmation key
     * @return the matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public List<SubscriptionCategory> findByConfirmationKey(
        String confirmationKey) throws SystemException {
        return findByConfirmationKey(confirmationKey, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<SubscriptionCategory> findByConfirmationKey(
        String confirmationKey, int start, int end) throws SystemException {
        return findByConfirmationKey(confirmationKey, start, end, null);
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
    public List<SubscriptionCategory> findByConfirmationKey(
        String confirmationKey, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CONFIRMATIONKEY;
            finderArgs = new Object[] { confirmationKey };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CONFIRMATIONKEY;
            finderArgs = new Object[] {
                    confirmationKey,
                    
                    start, end, orderByComparator
                };
        }

        List<SubscriptionCategory> list = (List<SubscriptionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SubscriptionCategory subscriptionCategory : list) {
                if (!Validator.equals(confirmationKey,
                            subscriptionCategory.getConfirmationKey())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

            if (confirmationKey == null) {
                query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_1);
            } else {
                if (confirmationKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_2);
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

                if (confirmationKey != null) {
                    qPos.add(confirmationKey);
                }

                list = (List<SubscriptionCategory>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first subscription category in the ordered set where confirmationKey = &#63;.
     *
     * @param confirmationKey the confirmation key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory findByConfirmationKey_First(
        String confirmationKey, OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByConfirmationKey_First(confirmationKey,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("confirmationKey=");
        msg.append(confirmationKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the first subscription category in the ordered set where confirmationKey = &#63;.
     *
     * @param confirmationKey the confirmation key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByConfirmationKey_First(
        String confirmationKey, OrderByComparator orderByComparator)
        throws SystemException {
        List<SubscriptionCategory> list = findByConfirmationKey(confirmationKey,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory findByConfirmationKey_Last(
        String confirmationKey, OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByConfirmationKey_Last(confirmationKey,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("confirmationKey=");
        msg.append(confirmationKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the last subscription category in the ordered set where confirmationKey = &#63;.
     *
     * @param confirmationKey the confirmation key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByConfirmationKey_Last(
        String confirmationKey, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByConfirmationKey(confirmationKey);

        List<SubscriptionCategory> list = findByConfirmationKey(confirmationKey,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory[] findByConfirmationKey_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, String confirmationKey,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = findByPrimaryKey(subscriptionCategoryPK);

        Session session = null;

        try {
            session = openSession();

            SubscriptionCategory[] array = new SubscriptionCategoryImpl[3];

            array[0] = getByConfirmationKey_PrevAndNext(session,
                    subscriptionCategory, confirmationKey, orderByComparator,
                    true);

            array[1] = subscriptionCategory;

            array[2] = getByConfirmationKey_PrevAndNext(session,
                    subscriptionCategory, confirmationKey, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SubscriptionCategory getByConfirmationKey_PrevAndNext(
        Session session, SubscriptionCategory subscriptionCategory,
        String confirmationKey, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

        if (confirmationKey == null) {
            query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_1);
        } else {
            if (confirmationKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_3);
            } else {
                query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_2);
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

        if (confirmationKey != null) {
            qPos.add(confirmationKey);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptionCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SubscriptionCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the subscription categories where cancellationKey = &#63;.
     *
     * @param cancellationKey the cancellation key
     * @return the matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public List<SubscriptionCategory> findByCancellationKey(
        String cancellationKey) throws SystemException {
        return findByCancellationKey(cancellationKey, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    public List<SubscriptionCategory> findByCancellationKey(
        String cancellationKey, int start, int end) throws SystemException {
        return findByCancellationKey(cancellationKey, start, end, null);
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
    public List<SubscriptionCategory> findByCancellationKey(
        String cancellationKey, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_CANCELLATIONKEY;
            finderArgs = new Object[] { cancellationKey };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_CANCELLATIONKEY;
            finderArgs = new Object[] {
                    cancellationKey,
                    
                    start, end, orderByComparator
                };
        }

        List<SubscriptionCategory> list = (List<SubscriptionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SubscriptionCategory subscriptionCategory : list) {
                if (!Validator.equals(cancellationKey,
                            subscriptionCategory.getCancellationKey())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

            if (cancellationKey == null) {
                query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_1);
            } else {
                if (cancellationKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_2);
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

                if (cancellationKey != null) {
                    qPos.add(cancellationKey);
                }

                list = (List<SubscriptionCategory>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first subscription category in the ordered set where cancellationKey = &#63;.
     *
     * @param cancellationKey the cancellation key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory findByCancellationKey_First(
        String cancellationKey, OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByCancellationKey_First(cancellationKey,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("cancellationKey=");
        msg.append(cancellationKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the first subscription category in the ordered set where cancellationKey = &#63;.
     *
     * @param cancellationKey the cancellation key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByCancellationKey_First(
        String cancellationKey, OrderByComparator orderByComparator)
        throws SystemException {
        List<SubscriptionCategory> list = findByCancellationKey(cancellationKey,
                0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory findByCancellationKey_Last(
        String cancellationKey, OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByCancellationKey_Last(cancellationKey,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("cancellationKey=");
        msg.append(cancellationKey);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the last subscription category in the ordered set where cancellationKey = &#63;.
     *
     * @param cancellationKey the cancellation key
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByCancellationKey_Last(
        String cancellationKey, OrderByComparator orderByComparator)
        throws SystemException {
        int count = countByCancellationKey(cancellationKey);

        List<SubscriptionCategory> list = findByCancellationKey(cancellationKey,
                count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory[] findByCancellationKey_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, String cancellationKey,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = findByPrimaryKey(subscriptionCategoryPK);

        Session session = null;

        try {
            session = openSession();

            SubscriptionCategory[] array = new SubscriptionCategoryImpl[3];

            array[0] = getByCancellationKey_PrevAndNext(session,
                    subscriptionCategory, cancellationKey, orderByComparator,
                    true);

            array[1] = subscriptionCategory;

            array[2] = getByCancellationKey_PrevAndNext(session,
                    subscriptionCategory, cancellationKey, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SubscriptionCategory getByCancellationKey_PrevAndNext(
        Session session, SubscriptionCategory subscriptionCategory,
        String cancellationKey, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

        if (cancellationKey == null) {
            query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_1);
        } else {
            if (cancellationKey.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_3);
            } else {
                query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_2);
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

        if (cancellationKey != null) {
            qPos.add(cancellationKey);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptionCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SubscriptionCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the subscription categories where status = &#63;.
     *
     * @param status the status
     * @return the matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public List<SubscriptionCategory> findByStatus(String status)
        throws SystemException {
        return findByStatus(status, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<SubscriptionCategory> findByStatus(String status, int start,
        int end) throws SystemException {
        return findByStatus(status, start, end, null);
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
    public List<SubscriptionCategory> findByStatus(String status, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
            finderArgs = new Object[] { status, start, end, orderByComparator };
        }

        List<SubscriptionCategory> list = (List<SubscriptionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (SubscriptionCategory subscriptionCategory : list) {
                if (!Validator.equals(status, subscriptionCategory.getStatus())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

            if (status == null) {
                query.append(_FINDER_COLUMN_STATUS_STATUS_1);
            } else {
                if (status.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_STATUS_STATUS_3);
                } else {
                    query.append(_FINDER_COLUMN_STATUS_STATUS_2);
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

                if (status != null) {
                    qPos.add(status);
                }

                list = (List<SubscriptionCategory>) QueryUtil.list(q,
                        getDialect(), start, end);
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
     * Returns the first subscription category in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category
     * @throws com.wcs.newsletter.NoSuchSubscriptionCategoryException if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory findByStatus_First(String status,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByStatus_First(status,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the first subscription category in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByStatus_First(String status,
        OrderByComparator orderByComparator) throws SystemException {
        List<SubscriptionCategory> list = findByStatus(status, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory findByStatus_Last(String status,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = fetchByStatus_Last(status,
                orderByComparator);

        if (subscriptionCategory != null) {
            return subscriptionCategory;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("status=");
        msg.append(status);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionCategoryException(msg.toString());
    }

    /**
     * Returns the last subscription category in the ordered set where status = &#63;.
     *
     * @param status the status
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscription category, or <code>null</code> if a matching subscription category could not be found
     * @throws SystemException if a system exception occurred
     */
    public SubscriptionCategory fetchByStatus_Last(String status,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByStatus(status);

        List<SubscriptionCategory> list = findByStatus(status, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public SubscriptionCategory[] findByStatus_PrevAndNext(
        SubscriptionCategoryPK subscriptionCategoryPK, String status,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionCategoryException, SystemException {
        SubscriptionCategory subscriptionCategory = findByPrimaryKey(subscriptionCategoryPK);

        Session session = null;

        try {
            session = openSession();

            SubscriptionCategory[] array = new SubscriptionCategoryImpl[3];

            array[0] = getByStatus_PrevAndNext(session, subscriptionCategory,
                    status, orderByComparator, true);

            array[1] = subscriptionCategory;

            array[2] = getByStatus_PrevAndNext(session, subscriptionCategory,
                    status, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected SubscriptionCategory getByStatus_PrevAndNext(Session session,
        SubscriptionCategory subscriptionCategory, String status,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY_WHERE);

        if (status == null) {
            query.append(_FINDER_COLUMN_STATUS_STATUS_1);
        } else {
            if (status.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_STATUS_STATUS_3);
            } else {
                query.append(_FINDER_COLUMN_STATUS_STATUS_2);
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

        if (status != null) {
            qPos.add(status);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscriptionCategory);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<SubscriptionCategory> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the subscription categories.
     *
     * @return the subscription categories
     * @throws SystemException if a system exception occurred
     */
    public List<SubscriptionCategory> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<SubscriptionCategory> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<SubscriptionCategory> findAll(int start, int end,
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

        List<SubscriptionCategory> list = (List<SubscriptionCategory>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SUBSCRIPTIONCATEGORY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SUBSCRIPTIONCATEGORY;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<SubscriptionCategory>) QueryUtil.list(q,
                            getDialect(), start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<SubscriptionCategory>) QueryUtil.list(q,
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
     * Removes all the subscription categories where subscriptionId = &#63; from the database.
     *
     * @param subscriptionId the subscription ID
     * @throws SystemException if a system exception occurred
     */
    public void removeBySubscriptionId(long subscriptionId)
        throws SystemException {
        for (SubscriptionCategory subscriptionCategory : findBySubscriptionId(
                subscriptionId)) {
            remove(subscriptionCategory);
        }
    }

    /**
     * Removes all the subscription categories where categoryId = &#63; from the database.
     *
     * @param categoryId the category ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByCategoryId(long categoryId) throws SystemException {
        for (SubscriptionCategory subscriptionCategory : findByCategoryId(
                categoryId)) {
            remove(subscriptionCategory);
        }
    }

    /**
     * Removes all the subscription categories where confirmationKey = &#63; from the database.
     *
     * @param confirmationKey the confirmation key
     * @throws SystemException if a system exception occurred
     */
    public void removeByConfirmationKey(String confirmationKey)
        throws SystemException {
        for (SubscriptionCategory subscriptionCategory : findByConfirmationKey(
                confirmationKey)) {
            remove(subscriptionCategory);
        }
    }

    /**
     * Removes all the subscription categories where cancellationKey = &#63; from the database.
     *
     * @param cancellationKey the cancellation key
     * @throws SystemException if a system exception occurred
     */
    public void removeByCancellationKey(String cancellationKey)
        throws SystemException {
        for (SubscriptionCategory subscriptionCategory : findByCancellationKey(
                cancellationKey)) {
            remove(subscriptionCategory);
        }
    }

    /**
     * Removes all the subscription categories where status = &#63; from the database.
     *
     * @param status the status
     * @throws SystemException if a system exception occurred
     */
    public void removeByStatus(String status) throws SystemException {
        for (SubscriptionCategory subscriptionCategory : findByStatus(status)) {
            remove(subscriptionCategory);
        }
    }

    /**
     * Removes all the subscription categories from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (SubscriptionCategory subscriptionCategory : findAll()) {
            remove(subscriptionCategory);
        }
    }

    /**
     * Returns the number of subscription categories where subscriptionId = &#63;.
     *
     * @param subscriptionId the subscription ID
     * @return the number of matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public int countBySubscriptionId(long subscriptionId)
        throws SystemException {
        Object[] finderArgs = new Object[] { subscriptionId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_SUBSCRIPTIONID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTIONCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_SUBSCRIPTIONID_SUBSCRIPTIONID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(subscriptionId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_SUBSCRIPTIONID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of subscription categories where categoryId = &#63;.
     *
     * @param categoryId the category ID
     * @return the number of matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public int countByCategoryId(long categoryId) throws SystemException {
        Object[] finderArgs = new Object[] { categoryId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CATEGORYID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTIONCATEGORY_WHERE);

            query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(categoryId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CATEGORYID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of subscription categories where confirmationKey = &#63;.
     *
     * @param confirmationKey the confirmation key
     * @return the number of matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public int countByConfirmationKey(String confirmationKey)
        throws SystemException {
        Object[] finderArgs = new Object[] { confirmationKey };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CONFIRMATIONKEY,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTIONCATEGORY_WHERE);

            if (confirmationKey == null) {
                query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_1);
            } else {
                if (confirmationKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_CONFIRMATIONKEY_CONFIRMATIONKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (confirmationKey != null) {
                    qPos.add(confirmationKey);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CONFIRMATIONKEY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of subscription categories where cancellationKey = &#63;.
     *
     * @param cancellationKey the cancellation key
     * @return the number of matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public int countByCancellationKey(String cancellationKey)
        throws SystemException {
        Object[] finderArgs = new Object[] { cancellationKey };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_CANCELLATIONKEY,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTIONCATEGORY_WHERE);

            if (cancellationKey == null) {
                query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_1);
            } else {
                if (cancellationKey.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_3);
                } else {
                    query.append(_FINDER_COLUMN_CANCELLATIONKEY_CANCELLATIONKEY_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (cancellationKey != null) {
                    qPos.add(cancellationKey);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CANCELLATIONKEY,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of subscription categories where status = &#63;.
     *
     * @param status the status
     * @return the number of matching subscription categories
     * @throws SystemException if a system exception occurred
     */
    public int countByStatus(String status) throws SystemException {
        Object[] finderArgs = new Object[] { status };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_STATUS,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTIONCATEGORY_WHERE);

            if (status == null) {
                query.append(_FINDER_COLUMN_STATUS_STATUS_1);
            } else {
                if (status.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_STATUS_STATUS_3);
                } else {
                    query.append(_FINDER_COLUMN_STATUS_STATUS_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (status != null) {
                    qPos.add(status);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_STATUS,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of subscription categories.
     *
     * @return the number of subscription categories
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SUBSCRIPTIONCATEGORY);

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
     * Initializes the subscription category persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.wcs.newsletter.model.SubscriptionCategory")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<SubscriptionCategory>> listenersList = new ArrayList<ModelListener<SubscriptionCategory>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<SubscriptionCategory>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SubscriptionCategoryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
