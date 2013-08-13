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
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.wcs.newsletter.NoSuchRecipientException;
import com.wcs.newsletter.model.Recipient;
import com.wcs.newsletter.model.impl.RecipientImpl;
import com.wcs.newsletter.model.impl.RecipientModelImpl;
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
 * The persistence implementation for the recipient service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RecipientPersistence
 * @see RecipientUtil
 * @generated
 */
public class RecipientPersistenceImpl extends BasePersistenceImpl<Recipient>
    implements RecipientPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link RecipientUtil} to access the recipient persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = RecipientImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWSLETTERID =
        new FinderPath(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientModelImpl.FINDER_CACHE_ENABLED, RecipientImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNewsletterId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID =
        new FinderPath(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientModelImpl.FINDER_CACHE_ENABLED, RecipientImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByNewsletterId",
            new String[] { Long.class.getName() },
            RecipientModelImpl.NEWSLETTERID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_NEWSLETTERID = new FinderPath(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByNewsletterId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientModelImpl.FINDER_CACHE_ENABLED, RecipientImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientModelImpl.FINDER_CACHE_ENABLED, RecipientImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_RECIPIENT = "SELECT recipient FROM Recipient recipient";
    private static final String _SQL_SELECT_RECIPIENT_WHERE = "SELECT recipient FROM Recipient recipient WHERE ";
    private static final String _SQL_COUNT_RECIPIENT = "SELECT COUNT(recipient) FROM Recipient recipient";
    private static final String _SQL_COUNT_RECIPIENT_WHERE = "SELECT COUNT(recipient) FROM Recipient recipient WHERE ";
    private static final String _FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2 = "recipient.newsletterId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "recipient.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Recipient exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Recipient exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(RecipientPersistenceImpl.class);
    private static Recipient _nullRecipient = new RecipientImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Recipient> toCacheModel() {
                return _nullRecipientCacheModel;
            }
        };

    private static CacheModel<Recipient> _nullRecipientCacheModel = new CacheModel<Recipient>() {
            public Recipient toEntityModel() {
                return _nullRecipient;
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
     * Caches the recipient in the entity cache if it is enabled.
     *
     * @param recipient the recipient
     */
    public void cacheResult(Recipient recipient) {
        EntityCacheUtil.putResult(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientImpl.class, recipient.getPrimaryKey(), recipient);

        recipient.resetOriginalValues();
    }

    /**
     * Caches the recipients in the entity cache if it is enabled.
     *
     * @param recipients the recipients
     */
    public void cacheResult(List<Recipient> recipients) {
        for (Recipient recipient : recipients) {
            if (EntityCacheUtil.getResult(
                        RecipientModelImpl.ENTITY_CACHE_ENABLED,
                        RecipientImpl.class, recipient.getPrimaryKey()) == null) {
                cacheResult(recipient);
            } else {
                recipient.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all recipients.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(RecipientImpl.class.getName());
        }

        EntityCacheUtil.clearCache(RecipientImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the recipient.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Recipient recipient) {
        EntityCacheUtil.removeResult(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientImpl.class, recipient.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Recipient> recipients) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Recipient recipient : recipients) {
            EntityCacheUtil.removeResult(RecipientModelImpl.ENTITY_CACHE_ENABLED,
                RecipientImpl.class, recipient.getPrimaryKey());
        }
    }

    /**
     * Creates a new recipient with the primary key. Does not add the recipient to the database.
     *
     * @param recipientId the primary key for the new recipient
     * @return the new recipient
     */
    public Recipient create(long recipientId) {
        Recipient recipient = new RecipientImpl();

        recipient.setNew(true);
        recipient.setPrimaryKey(recipientId);

        return recipient;
    }

    /**
     * Removes the recipient with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param recipientId the primary key of the recipient
     * @return the recipient that was removed
     * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient remove(long recipientId)
        throws NoSuchRecipientException, SystemException {
        return remove(Long.valueOf(recipientId));
    }

    /**
     * Removes the recipient with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the recipient
     * @return the recipient that was removed
     * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Recipient remove(Serializable primaryKey)
        throws NoSuchRecipientException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Recipient recipient = (Recipient) session.get(RecipientImpl.class,
                    primaryKey);

            if (recipient == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchRecipientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(recipient);
        } catch (NoSuchRecipientException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Recipient removeImpl(Recipient recipient)
        throws SystemException {
        recipient = toUnwrappedModel(recipient);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, recipient);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(recipient);

        return recipient;
    }

    @Override
    public Recipient updateImpl(com.wcs.newsletter.model.Recipient recipient,
        boolean merge) throws SystemException {
        recipient = toUnwrappedModel(recipient);

        boolean isNew = recipient.isNew();

        RecipientModelImpl recipientModelImpl = (RecipientModelImpl) recipient;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, recipient, merge);

            recipient.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !RecipientModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((recipientModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(recipientModelImpl.getOriginalNewsletterId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEWSLETTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID,
                    args);

                args = new Object[] {
                        Long.valueOf(recipientModelImpl.getNewsletterId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NEWSLETTERID,
                    args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID,
                    args);
            }
        }

        EntityCacheUtil.putResult(RecipientModelImpl.ENTITY_CACHE_ENABLED,
            RecipientImpl.class, recipient.getPrimaryKey(), recipient);

        return recipient;
    }

    protected Recipient toUnwrappedModel(Recipient recipient) {
        if (recipient instanceof RecipientImpl) {
            return recipient;
        }

        RecipientImpl recipientImpl = new RecipientImpl();

        recipientImpl.setNew(recipient.isNew());
        recipientImpl.setPrimaryKey(recipient.getPrimaryKey());

        recipientImpl.setRecipientId(recipient.getRecipientId());
        recipientImpl.setNewsletterId(recipient.getNewsletterId());
        recipientImpl.setEmail(recipient.getEmail());
        recipientImpl.setStatus(recipient.getStatus());
        recipientImpl.setErrorMessage(recipient.getErrorMessage());

        return recipientImpl;
    }

    /**
     * Returns the recipient with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the recipient
     * @return the recipient
     * @throws com.liferay.portal.NoSuchModelException if a recipient with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Recipient findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the recipient with the primary key or throws a {@link com.wcs.newsletter.NoSuchRecipientException} if it could not be found.
     *
     * @param recipientId the primary key of the recipient
     * @return the recipient
     * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient findByPrimaryKey(long recipientId)
        throws NoSuchRecipientException, SystemException {
        Recipient recipient = fetchByPrimaryKey(recipientId);

        if (recipient == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + recipientId);
            }

            throw new NoSuchRecipientException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                recipientId);
        }

        return recipient;
    }

    /**
     * Returns the recipient with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the recipient
     * @return the recipient, or <code>null</code> if a recipient with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Recipient fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the recipient with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param recipientId the primary key of the recipient
     * @return the recipient, or <code>null</code> if a recipient with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient fetchByPrimaryKey(long recipientId)
        throws SystemException {
        Recipient recipient = (Recipient) EntityCacheUtil.getResult(RecipientModelImpl.ENTITY_CACHE_ENABLED,
                RecipientImpl.class, recipientId);

        if (recipient == _nullRecipient) {
            return null;
        }

        if (recipient == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                recipient = (Recipient) session.get(RecipientImpl.class,
                        Long.valueOf(recipientId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (recipient != null) {
                    cacheResult(recipient);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(RecipientModelImpl.ENTITY_CACHE_ENABLED,
                        RecipientImpl.class, recipientId, _nullRecipient);
                }

                closeSession(session);
            }
        }

        return recipient;
    }

    /**
     * Returns all the recipients where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @return the matching recipients
     * @throws SystemException if a system exception occurred
     */
    public List<Recipient> findByNewsletterId(long newsletterId)
        throws SystemException {
        return findByNewsletterId(newsletterId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the recipients where newsletterId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param newsletterId the newsletter ID
     * @param start the lower bound of the range of recipients
     * @param end the upper bound of the range of recipients (not inclusive)
     * @return the range of matching recipients
     * @throws SystemException if a system exception occurred
     */
    public List<Recipient> findByNewsletterId(long newsletterId, int start,
        int end) throws SystemException {
        return findByNewsletterId(newsletterId, start, end, null);
    }

    /**
     * Returns an ordered range of all the recipients where newsletterId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param newsletterId the newsletter ID
     * @param start the lower bound of the range of recipients
     * @param end the upper bound of the range of recipients (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching recipients
     * @throws SystemException if a system exception occurred
     */
    public List<Recipient> findByNewsletterId(long newsletterId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_NEWSLETTERID;
            finderArgs = new Object[] { newsletterId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NEWSLETTERID;
            finderArgs = new Object[] {
                    newsletterId,
                    
                    start, end, orderByComparator
                };
        }

        List<Recipient> list = (List<Recipient>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Recipient recipient : list) {
                if ((newsletterId != recipient.getNewsletterId())) {
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

            query.append(_SQL_SELECT_RECIPIENT_WHERE);

            query.append(_FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2);

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

                qPos.add(newsletterId);

                list = (List<Recipient>) QueryUtil.list(q, getDialect(), start,
                        end);
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
     * Returns the first recipient in the ordered set where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching recipient
     * @throws com.wcs.newsletter.NoSuchRecipientException if a matching recipient could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient findByNewsletterId_First(long newsletterId,
        OrderByComparator orderByComparator)
        throws NoSuchRecipientException, SystemException {
        Recipient recipient = fetchByNewsletterId_First(newsletterId,
                orderByComparator);

        if (recipient != null) {
            return recipient;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("newsletterId=");
        msg.append(newsletterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRecipientException(msg.toString());
    }

    /**
     * Returns the first recipient in the ordered set where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching recipient, or <code>null</code> if a matching recipient could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient fetchByNewsletterId_First(long newsletterId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Recipient> list = findByNewsletterId(newsletterId, 0, 1,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last recipient in the ordered set where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching recipient
     * @throws com.wcs.newsletter.NoSuchRecipientException if a matching recipient could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient findByNewsletterId_Last(long newsletterId,
        OrderByComparator orderByComparator)
        throws NoSuchRecipientException, SystemException {
        Recipient recipient = fetchByNewsletterId_Last(newsletterId,
                orderByComparator);

        if (recipient != null) {
            return recipient;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("newsletterId=");
        msg.append(newsletterId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchRecipientException(msg.toString());
    }

    /**
     * Returns the last recipient in the ordered set where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching recipient, or <code>null</code> if a matching recipient could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient fetchByNewsletterId_Last(long newsletterId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByNewsletterId(newsletterId);

        List<Recipient> list = findByNewsletterId(newsletterId, count - 1,
                count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the recipients before and after the current recipient in the ordered set where newsletterId = &#63;.
     *
     * @param recipientId the primary key of the current recipient
     * @param newsletterId the newsletter ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next recipient
     * @throws com.wcs.newsletter.NoSuchRecipientException if a recipient with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Recipient[] findByNewsletterId_PrevAndNext(long recipientId,
        long newsletterId, OrderByComparator orderByComparator)
        throws NoSuchRecipientException, SystemException {
        Recipient recipient = findByPrimaryKey(recipientId);

        Session session = null;

        try {
            session = openSession();

            Recipient[] array = new RecipientImpl[3];

            array[0] = getByNewsletterId_PrevAndNext(session, recipient,
                    newsletterId, orderByComparator, true);

            array[1] = recipient;

            array[2] = getByNewsletterId_PrevAndNext(session, recipient,
                    newsletterId, orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Recipient getByNewsletterId_PrevAndNext(Session session,
        Recipient recipient, long newsletterId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_RECIPIENT_WHERE);

        query.append(_FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2);

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

        qPos.add(newsletterId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(recipient);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Recipient> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the recipients.
     *
     * @return the recipients
     * @throws SystemException if a system exception occurred
     */
    public List<Recipient> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the recipients.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of recipients
     * @param end the upper bound of the range of recipients (not inclusive)
     * @return the range of recipients
     * @throws SystemException if a system exception occurred
     */
    public List<Recipient> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the recipients.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of recipients
     * @param end the upper bound of the range of recipients (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of recipients
     * @throws SystemException if a system exception occurred
     */
    public List<Recipient> findAll(int start, int end,
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

        List<Recipient> list = (List<Recipient>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_RECIPIENT);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_RECIPIENT;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Recipient>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Recipient>) QueryUtil.list(q, getDialect(),
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
     * Removes all the recipients where newsletterId = &#63; from the database.
     *
     * @param newsletterId the newsletter ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByNewsletterId(long newsletterId)
        throws SystemException {
        for (Recipient recipient : findByNewsletterId(newsletterId)) {
            remove(recipient);
        }
    }

    /**
     * Removes all the recipients from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Recipient recipient : findAll()) {
            remove(recipient);
        }
    }

    /**
     * Returns the number of recipients where newsletterId = &#63;.
     *
     * @param newsletterId the newsletter ID
     * @return the number of matching recipients
     * @throws SystemException if a system exception occurred
     */
    public int countByNewsletterId(long newsletterId) throws SystemException {
        Object[] finderArgs = new Object[] { newsletterId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_NEWSLETTERID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_RECIPIENT_WHERE);

            query.append(_FINDER_COLUMN_NEWSLETTERID_NEWSLETTERID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(newsletterId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NEWSLETTERID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of recipients.
     *
     * @return the number of recipients
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_RECIPIENT);

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
     * Initializes the recipient persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.wcs.newsletter.model.Recipient")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Recipient>> listenersList = new ArrayList<ModelListener<Recipient>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Recipient>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(RecipientImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
