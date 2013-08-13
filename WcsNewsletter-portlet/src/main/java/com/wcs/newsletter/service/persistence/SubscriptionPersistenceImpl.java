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

import com.wcs.newsletter.NoSuchSubscriptionException;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.impl.SubscriptionImpl;
import com.wcs.newsletter.model.impl.SubscriptionModelImpl;
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
 * The persistence implementation for the subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionPersistence
 * @see SubscriptionUtil
 * @generated
 */
public class SubscriptionPersistenceImpl extends BasePersistenceImpl<Subscription>
    implements SubscriptionPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link SubscriptionUtil} to access the subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = SubscriptionImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmail",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmail",
            new String[] { String.class.getName() },
            SubscriptionModelImpl.EMAIL_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_EMAIL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmail",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUserId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID =
        new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUserId",
            new String[] { Long.class.getName() },
            SubscriptionModelImpl.USERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_USERID = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUserId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, SubscriptionImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_SUBSCRIPTION = "SELECT subscription FROM Subscription subscription";
    private static final String _SQL_SELECT_SUBSCRIPTION_WHERE = "SELECT subscription FROM Subscription subscription WHERE ";
    private static final String _SQL_COUNT_SUBSCRIPTION = "SELECT COUNT(subscription) FROM Subscription subscription";
    private static final String _SQL_COUNT_SUBSCRIPTION_WHERE = "SELECT COUNT(subscription) FROM Subscription subscription WHERE ";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_1 = "subscription.email IS NULL";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_2 = "subscription.email = ?";
    private static final String _FINDER_COLUMN_EMAIL_EMAIL_3 = "(subscription.email IS NULL OR subscription.email = ?)";
    private static final String _FINDER_COLUMN_USERID_USERID_2 = "subscription.userId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "subscription.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Subscription exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Subscription exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(SubscriptionPersistenceImpl.class);
    private static Subscription _nullSubscription = new SubscriptionImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Subscription> toCacheModel() {
                return _nullSubscriptionCacheModel;
            }
        };

    private static CacheModel<Subscription> _nullSubscriptionCacheModel = new CacheModel<Subscription>() {
            public Subscription toEntityModel() {
                return _nullSubscription;
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
     * Caches the subscription in the entity cache if it is enabled.
     *
     * @param subscription the subscription
     */
    public void cacheResult(Subscription subscription) {
        EntityCacheUtil.putResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionImpl.class, subscription.getPrimaryKey(), subscription);

        subscription.resetOriginalValues();
    }

    /**
     * Caches the subscriptions in the entity cache if it is enabled.
     *
     * @param subscriptions the subscriptions
     */
    public void cacheResult(List<Subscription> subscriptions) {
        for (Subscription subscription : subscriptions) {
            if (EntityCacheUtil.getResult(
                        SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptionImpl.class, subscription.getPrimaryKey()) == null) {
                cacheResult(subscription);
            } else {
                subscription.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all subscriptions.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(SubscriptionImpl.class.getName());
        }

        EntityCacheUtil.clearCache(SubscriptionImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the subscription.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Subscription subscription) {
        EntityCacheUtil.removeResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionImpl.class, subscription.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Subscription> subscriptions) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Subscription subscription : subscriptions) {
            EntityCacheUtil.removeResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptionImpl.class, subscription.getPrimaryKey());
        }
    }

    /**
     * Creates a new subscription with the primary key. Does not add the subscription to the database.
     *
     * @param subscriptionId the primary key for the new subscription
     * @return the new subscription
     */
    public Subscription create(long subscriptionId) {
        Subscription subscription = new SubscriptionImpl();

        subscription.setNew(true);
        subscription.setPrimaryKey(subscriptionId);

        return subscription;
    }

    /**
     * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param subscriptionId the primary key of the subscription
     * @return the subscription that was removed
     * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription remove(long subscriptionId)
        throws NoSuchSubscriptionException, SystemException {
        return remove(Long.valueOf(subscriptionId));
    }

    /**
     * Removes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the subscription
     * @return the subscription that was removed
     * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscription remove(Serializable primaryKey)
        throws NoSuchSubscriptionException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Subscription subscription = (Subscription) session.get(SubscriptionImpl.class,
                    primaryKey);

            if (subscription == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(subscription);
        } catch (NoSuchSubscriptionException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Subscription removeImpl(Subscription subscription)
        throws SystemException {
        subscription = toUnwrappedModel(subscription);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, subscription);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(subscription);

        return subscription;
    }

    @Override
    public Subscription updateImpl(
        com.wcs.newsletter.model.Subscription subscription, boolean merge)
        throws SystemException {
        subscription = toUnwrappedModel(subscription);

        boolean isNew = subscription.isNew();

        SubscriptionModelImpl subscriptionModelImpl = (SubscriptionModelImpl) subscription;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, subscription, merge);

            subscription.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !SubscriptionModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((subscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        subscriptionModelImpl.getOriginalEmail()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);

                args = new Object[] { subscriptionModelImpl.getEmail() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_EMAIL, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL,
                    args);
            }

            if ((subscriptionModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(subscriptionModelImpl.getOriginalUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);

                args = new Object[] {
                        Long.valueOf(subscriptionModelImpl.getUserId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_USERID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
            SubscriptionImpl.class, subscription.getPrimaryKey(), subscription);

        return subscription;
    }

    protected Subscription toUnwrappedModel(Subscription subscription) {
        if (subscription instanceof SubscriptionImpl) {
            return subscription;
        }

        SubscriptionImpl subscriptionImpl = new SubscriptionImpl();

        subscriptionImpl.setNew(subscription.isNew());
        subscriptionImpl.setPrimaryKey(subscription.getPrimaryKey());

        subscriptionImpl.setSubscriptionId(subscription.getSubscriptionId());
        subscriptionImpl.setUserId(subscription.getUserId());
        subscriptionImpl.setEmail(subscription.getEmail());
        subscriptionImpl.setSubscriptionDate(subscription.getSubscriptionDate());

        return subscriptionImpl;
    }

    /**
     * Returns the subscription with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the subscription
     * @return the subscription
     * @throws com.liferay.portal.NoSuchModelException if a subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscription findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the subscription with the primary key or throws a {@link com.wcs.newsletter.NoSuchSubscriptionException} if it could not be found.
     *
     * @param subscriptionId the primary key of the subscription
     * @return the subscription
     * @throws com.wcs.newsletter.NoSuchSubscriptionException if a subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription findByPrimaryKey(long subscriptionId)
        throws NoSuchSubscriptionException, SystemException {
        Subscription subscription = fetchByPrimaryKey(subscriptionId);

        if (subscription == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + subscriptionId);
            }

            throw new NoSuchSubscriptionException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                subscriptionId);
        }

        return subscription;
    }

    /**
     * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the subscription
     * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Subscription fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the subscription with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param subscriptionId the primary key of the subscription
     * @return the subscription, or <code>null</code> if a subscription with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription fetchByPrimaryKey(long subscriptionId)
        throws SystemException {
        Subscription subscription = (Subscription) EntityCacheUtil.getResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                SubscriptionImpl.class, subscriptionId);

        if (subscription == _nullSubscription) {
            return null;
        }

        if (subscription == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                subscription = (Subscription) session.get(SubscriptionImpl.class,
                        Long.valueOf(subscriptionId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (subscription != null) {
                    cacheResult(subscription);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(SubscriptionModelImpl.ENTITY_CACHE_ENABLED,
                        SubscriptionImpl.class, subscriptionId,
                        _nullSubscription);
                }

                closeSession(session);
            }
        }

        return subscription;
    }

    /**
     * Returns all the subscriptions where email = &#63;.
     *
     * @param email the email
     * @return the matching subscriptions
     * @throws SystemException if a system exception occurred
     */
    public List<Subscription> findByEmail(String email)
        throws SystemException {
        return findByEmail(email, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Subscription> findByEmail(String email, int start, int end)
        throws SystemException {
        return findByEmail(email, start, end, null);
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
    public List<Subscription> findByEmail(String email, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EMAIL;
            finderArgs = new Object[] { email, start, end, orderByComparator };
        }

        List<Subscription> list = (List<Subscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Subscription subscription : list) {
                if (!Validator.equals(email, subscription.getEmail())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else {
                if (email.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
                } else {
                    query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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

                if (email != null) {
                    qPos.add(email);
                }

                list = (List<Subscription>) QueryUtil.list(q, getDialect(),
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
     * Returns the first subscription in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription
     * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription findByEmail_First(String email,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionException, SystemException {
        Subscription subscription = fetchByEmail_First(email, orderByComparator);

        if (subscription != null) {
            return subscription;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionException(msg.toString());
    }

    /**
     * Returns the first subscription in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription fetchByEmail_First(String email,
        OrderByComparator orderByComparator) throws SystemException {
        List<Subscription> list = findByEmail(email, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Subscription findByEmail_Last(String email,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionException, SystemException {
        Subscription subscription = fetchByEmail_Last(email, orderByComparator);

        if (subscription != null) {
            return subscription;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("email=");
        msg.append(email);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionException(msg.toString());
    }

    /**
     * Returns the last subscription in the ordered set where email = &#63;.
     *
     * @param email the email
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription fetchByEmail_Last(String email,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByEmail(email);

        List<Subscription> list = findByEmail(email, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Subscription[] findByEmail_PrevAndNext(long subscriptionId,
        String email, OrderByComparator orderByComparator)
        throws NoSuchSubscriptionException, SystemException {
        Subscription subscription = findByPrimaryKey(subscriptionId);

        Session session = null;

        try {
            session = openSession();

            Subscription[] array = new SubscriptionImpl[3];

            array[0] = getByEmail_PrevAndNext(session, subscription, email,
                    orderByComparator, true);

            array[1] = subscription;

            array[2] = getByEmail_PrevAndNext(session, subscription, email,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Subscription getByEmail_PrevAndNext(Session session,
        Subscription subscription, String email,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

        if (email == null) {
            query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
        } else {
            if (email.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
            } else {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
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

        if (email != null) {
            qPos.add(email);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Subscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the subscriptions where userId = &#63;.
     *
     * @param userId the user ID
     * @return the matching subscriptions
     * @throws SystemException if a system exception occurred
     */
    public List<Subscription> findByUserId(long userId)
        throws SystemException {
        return findByUserId(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Subscription> findByUserId(long userId, int start, int end)
        throws SystemException {
        return findByUserId(userId, start, end, null);
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
    public List<Subscription> findByUserId(long userId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USERID;
            finderArgs = new Object[] { userId, start, end, orderByComparator };
        }

        List<Subscription> list = (List<Subscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Subscription subscription : list) {
                if ((userId != subscription.getUserId())) {
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

            query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

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

                qPos.add(userId);

                list = (List<Subscription>) QueryUtil.list(q, getDialect(),
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
     * Returns the first subscription in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription
     * @throws com.wcs.newsletter.NoSuchSubscriptionException if a matching subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription findByUserId_First(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionException, SystemException {
        Subscription subscription = fetchByUserId_First(userId,
                orderByComparator);

        if (subscription != null) {
            return subscription;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionException(msg.toString());
    }

    /**
     * Returns the first subscription in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching subscription, or <code>null</code> if a matching subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription fetchByUserId_First(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Subscription> list = findByUserId(userId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Subscription findByUserId_Last(long userId,
        OrderByComparator orderByComparator)
        throws NoSuchSubscriptionException, SystemException {
        Subscription subscription = fetchByUserId_Last(userId, orderByComparator);

        if (subscription != null) {
            return subscription;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("userId=");
        msg.append(userId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchSubscriptionException(msg.toString());
    }

    /**
     * Returns the last subscription in the ordered set where userId = &#63;.
     *
     * @param userId the user ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching subscription, or <code>null</code> if a matching subscription could not be found
     * @throws SystemException if a system exception occurred
     */
    public Subscription fetchByUserId_Last(long userId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByUserId(userId);

        List<Subscription> list = findByUserId(userId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Subscription[] findByUserId_PrevAndNext(long subscriptionId,
        long userId, OrderByComparator orderByComparator)
        throws NoSuchSubscriptionException, SystemException {
        Subscription subscription = findByPrimaryKey(subscriptionId);

        Session session = null;

        try {
            session = openSession();

            Subscription[] array = new SubscriptionImpl[3];

            array[0] = getByUserId_PrevAndNext(session, subscription, userId,
                    orderByComparator, true);

            array[1] = subscription;

            array[2] = getByUserId_PrevAndNext(session, subscription, userId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Subscription getByUserId_PrevAndNext(Session session,
        Subscription subscription, long userId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_SUBSCRIPTION_WHERE);

        query.append(_FINDER_COLUMN_USERID_USERID_2);

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

        qPos.add(userId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(subscription);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Subscription> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the subscriptions.
     *
     * @return the subscriptions
     * @throws SystemException if a system exception occurred
     */
    public List<Subscription> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Subscription> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<Subscription> findAll(int start, int end,
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

        List<Subscription> list = (List<Subscription>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_SUBSCRIPTION);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_SUBSCRIPTION;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Subscription>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Subscription>) QueryUtil.list(q, getDialect(),
                            start, end);
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
     * Removes all the subscriptions where email = &#63; from the database.
     *
     * @param email the email
     * @throws SystemException if a system exception occurred
     */
    public void removeByEmail(String email) throws SystemException {
        for (Subscription subscription : findByEmail(email)) {
            remove(subscription);
        }
    }

    /**
     * Removes all the subscriptions where userId = &#63; from the database.
     *
     * @param userId the user ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByUserId(long userId) throws SystemException {
        for (Subscription subscription : findByUserId(userId)) {
            remove(subscription);
        }
    }

    /**
     * Removes all the subscriptions from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Subscription subscription : findAll()) {
            remove(subscription);
        }
    }

    /**
     * Returns the number of subscriptions where email = &#63;.
     *
     * @param email the email
     * @return the number of matching subscriptions
     * @throws SystemException if a system exception occurred
     */
    public int countByEmail(String email) throws SystemException {
        Object[] finderArgs = new Object[] { email };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_EMAIL,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTION_WHERE);

            if (email == null) {
                query.append(_FINDER_COLUMN_EMAIL_EMAIL_1);
            } else {
                if (email.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_EMAIL_EMAIL_3);
                } else {
                    query.append(_FINDER_COLUMN_EMAIL_EMAIL_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (email != null) {
                    qPos.add(email);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_EMAIL,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of subscriptions where userId = &#63;.
     *
     * @param userId the user ID
     * @return the number of matching subscriptions
     * @throws SystemException if a system exception occurred
     */
    public int countByUserId(long userId) throws SystemException {
        Object[] finderArgs = new Object[] { userId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_USERID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_SUBSCRIPTION_WHERE);

            query.append(_FINDER_COLUMN_USERID_USERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(userId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_USERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of subscriptions.
     *
     * @return the number of subscriptions
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_SUBSCRIPTION);

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
     * Initializes the subscription persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.wcs.newsletter.model.Subscription")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Subscription>> listenersList = new ArrayList<ModelListener<Subscription>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Subscription>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(SubscriptionImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
