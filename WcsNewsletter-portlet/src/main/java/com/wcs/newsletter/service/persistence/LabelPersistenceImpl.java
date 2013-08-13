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

import com.wcs.newsletter.NoSuchLabelException;
import com.wcs.newsletter.model.Label;
import com.wcs.newsletter.model.impl.LabelImpl;
import com.wcs.newsletter.model.impl.LabelModelImpl;
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
 * The persistence implementation for the label service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LabelPersistence
 * @see LabelUtil
 * @generated
 */
public class LabelPersistenceImpl extends BasePersistenceImpl<Label>
    implements LabelPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link LabelUtil} to access the label persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = LabelImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGID = new FinderPath(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelModelImpl.FINDER_CACHE_ENABLED, LabelImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByTagId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID = new FinderPath(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelModelImpl.FINDER_CACHE_ENABLED, LabelImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByTagId",
            new String[] { Long.class.getName() },
            LabelModelImpl.TAGID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_TAGID = new FinderPath(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByTagId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelModelImpl.FINDER_CACHE_ENABLED, LabelImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelModelImpl.FINDER_CACHE_ENABLED, LabelImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_LABEL = "SELECT label FROM Label label";
    private static final String _SQL_SELECT_LABEL_WHERE = "SELECT label FROM Label label WHERE ";
    private static final String _SQL_COUNT_LABEL = "SELECT COUNT(label) FROM Label label";
    private static final String _SQL_COUNT_LABEL_WHERE = "SELECT COUNT(label) FROM Label label WHERE ";
    private static final String _FINDER_COLUMN_TAGID_TAGID_2 = "label.tagId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "label.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Label exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Label exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(LabelPersistenceImpl.class);
    private static Label _nullLabel = new LabelImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Label> toCacheModel() {
                return _nullLabelCacheModel;
            }
        };

    private static CacheModel<Label> _nullLabelCacheModel = new CacheModel<Label>() {
            public Label toEntityModel() {
                return _nullLabel;
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
     * Caches the label in the entity cache if it is enabled.
     *
     * @param label the label
     */
    public void cacheResult(Label label) {
        EntityCacheUtil.putResult(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelImpl.class, label.getPrimaryKey(), label);

        label.resetOriginalValues();
    }

    /**
     * Caches the labels in the entity cache if it is enabled.
     *
     * @param labels the labels
     */
    public void cacheResult(List<Label> labels) {
        for (Label label : labels) {
            if (EntityCacheUtil.getResult(LabelModelImpl.ENTITY_CACHE_ENABLED,
                        LabelImpl.class, label.getPrimaryKey()) == null) {
                cacheResult(label);
            } else {
                label.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all labels.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(LabelImpl.class.getName());
        }

        EntityCacheUtil.clearCache(LabelImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the label.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Label label) {
        EntityCacheUtil.removeResult(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelImpl.class, label.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Label> labels) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Label label : labels) {
            EntityCacheUtil.removeResult(LabelModelImpl.ENTITY_CACHE_ENABLED,
                LabelImpl.class, label.getPrimaryKey());
        }
    }

    /**
     * Creates a new label with the primary key. Does not add the label to the database.
     *
     * @param labelId the primary key for the new label
     * @return the new label
     */
    public Label create(long labelId) {
        Label label = new LabelImpl();

        label.setNew(true);
        label.setPrimaryKey(labelId);

        return label;
    }

    /**
     * Removes the label with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param labelId the primary key of the label
     * @return the label that was removed
     * @throws com.wcs.newsletter.NoSuchLabelException if a label with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label remove(long labelId)
        throws NoSuchLabelException, SystemException {
        return remove(Long.valueOf(labelId));
    }

    /**
     * Removes the label with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the label
     * @return the label that was removed
     * @throws com.wcs.newsletter.NoSuchLabelException if a label with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Label remove(Serializable primaryKey)
        throws NoSuchLabelException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Label label = (Label) session.get(LabelImpl.class, primaryKey);

            if (label == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchLabelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(label);
        } catch (NoSuchLabelException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Label removeImpl(Label label) throws SystemException {
        label = toUnwrappedModel(label);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, label);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(label);

        return label;
    }

    @Override
    public Label updateImpl(com.wcs.newsletter.model.Label label, boolean merge)
        throws SystemException {
        label = toUnwrappedModel(label);

        boolean isNew = label.isNew();

        LabelModelImpl labelModelImpl = (LabelModelImpl) label;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, label, merge);

            label.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !LabelModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((labelModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(labelModelImpl.getOriginalTagId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID,
                    args);

                args = new Object[] { Long.valueOf(labelModelImpl.getTagId()) };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TAGID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID,
                    args);
            }
        }

        EntityCacheUtil.putResult(LabelModelImpl.ENTITY_CACHE_ENABLED,
            LabelImpl.class, label.getPrimaryKey(), label);

        return label;
    }

    protected Label toUnwrappedModel(Label label) {
        if (label instanceof LabelImpl) {
            return label;
        }

        LabelImpl labelImpl = new LabelImpl();

        labelImpl.setNew(label.isNew());
        labelImpl.setPrimaryKey(label.getPrimaryKey());

        labelImpl.setLabelId(label.getLabelId());
        labelImpl.setTagId(label.getTagId());

        return labelImpl;
    }

    /**
     * Returns the label with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the label
     * @return the label
     * @throws com.liferay.portal.NoSuchModelException if a label with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Label findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the label with the primary key or throws a {@link com.wcs.newsletter.NoSuchLabelException} if it could not be found.
     *
     * @param labelId the primary key of the label
     * @return the label
     * @throws com.wcs.newsletter.NoSuchLabelException if a label with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label findByPrimaryKey(long labelId)
        throws NoSuchLabelException, SystemException {
        Label label = fetchByPrimaryKey(labelId);

        if (label == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + labelId);
            }

            throw new NoSuchLabelException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                labelId);
        }

        return label;
    }

    /**
     * Returns the label with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the label
     * @return the label, or <code>null</code> if a label with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Label fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the label with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param labelId the primary key of the label
     * @return the label, or <code>null</code> if a label with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label fetchByPrimaryKey(long labelId) throws SystemException {
        Label label = (Label) EntityCacheUtil.getResult(LabelModelImpl.ENTITY_CACHE_ENABLED,
                LabelImpl.class, labelId);

        if (label == _nullLabel) {
            return null;
        }

        if (label == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                label = (Label) session.get(LabelImpl.class,
                        Long.valueOf(labelId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (label != null) {
                    cacheResult(label);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(LabelModelImpl.ENTITY_CACHE_ENABLED,
                        LabelImpl.class, labelId, _nullLabel);
                }

                closeSession(session);
            }
        }

        return label;
    }

    /**
     * Returns all the labels where tagId = &#63;.
     *
     * @param tagId the tag ID
     * @return the matching labels
     * @throws SystemException if a system exception occurred
     */
    public List<Label> findByTagId(long tagId) throws SystemException {
        return findByTagId(tagId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the labels where tagId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param tagId the tag ID
     * @param start the lower bound of the range of labels
     * @param end the upper bound of the range of labels (not inclusive)
     * @return the range of matching labels
     * @throws SystemException if a system exception occurred
     */
    public List<Label> findByTagId(long tagId, int start, int end)
        throws SystemException {
        return findByTagId(tagId, start, end, null);
    }

    /**
     * Returns an ordered range of all the labels where tagId = &#63;.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param tagId the tag ID
     * @param start the lower bound of the range of labels
     * @param end the upper bound of the range of labels (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of matching labels
     * @throws SystemException if a system exception occurred
     */
    public List<Label> findByTagId(long tagId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TAGID;
            finderArgs = new Object[] { tagId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TAGID;
            finderArgs = new Object[] { tagId, start, end, orderByComparator };
        }

        List<Label> list = (List<Label>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Label label : list) {
                if ((tagId != label.getTagId())) {
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

            query.append(_SQL_SELECT_LABEL_WHERE);

            query.append(_FINDER_COLUMN_TAGID_TAGID_2);

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

                qPos.add(tagId);

                list = (List<Label>) QueryUtil.list(q, getDialect(), start, end);
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
     * Returns the first label in the ordered set where tagId = &#63;.
     *
     * @param tagId the tag ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching label
     * @throws com.wcs.newsletter.NoSuchLabelException if a matching label could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label findByTagId_First(long tagId,
        OrderByComparator orderByComparator)
        throws NoSuchLabelException, SystemException {
        Label label = fetchByTagId_First(tagId, orderByComparator);

        if (label != null) {
            return label;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("tagId=");
        msg.append(tagId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLabelException(msg.toString());
    }

    /**
     * Returns the first label in the ordered set where tagId = &#63;.
     *
     * @param tagId the tag ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching label, or <code>null</code> if a matching label could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label fetchByTagId_First(long tagId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Label> list = findByTagId(tagId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the last label in the ordered set where tagId = &#63;.
     *
     * @param tagId the tag ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching label
     * @throws com.wcs.newsletter.NoSuchLabelException if a matching label could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label findByTagId_Last(long tagId,
        OrderByComparator orderByComparator)
        throws NoSuchLabelException, SystemException {
        Label label = fetchByTagId_Last(tagId, orderByComparator);

        if (label != null) {
            return label;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("tagId=");
        msg.append(tagId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchLabelException(msg.toString());
    }

    /**
     * Returns the last label in the ordered set where tagId = &#63;.
     *
     * @param tagId the tag ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching label, or <code>null</code> if a matching label could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label fetchByTagId_Last(long tagId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByTagId(tagId);

        List<Label> list = findByTagId(tagId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
    }

    /**
     * Returns the labels before and after the current label in the ordered set where tagId = &#63;.
     *
     * @param labelId the primary key of the current label
     * @param tagId the tag ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the previous, current, and next label
     * @throws com.wcs.newsletter.NoSuchLabelException if a label with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Label[] findByTagId_PrevAndNext(long labelId, long tagId,
        OrderByComparator orderByComparator)
        throws NoSuchLabelException, SystemException {
        Label label = findByPrimaryKey(labelId);

        Session session = null;

        try {
            session = openSession();

            Label[] array = new LabelImpl[3];

            array[0] = getByTagId_PrevAndNext(session, label, tagId,
                    orderByComparator, true);

            array[1] = label;

            array[2] = getByTagId_PrevAndNext(session, label, tagId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Label getByTagId_PrevAndNext(Session session, Label label,
        long tagId, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_LABEL_WHERE);

        query.append(_FINDER_COLUMN_TAGID_TAGID_2);

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

        qPos.add(tagId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(label);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Label> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the labels.
     *
     * @return the labels
     * @throws SystemException if a system exception occurred
     */
    public List<Label> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
    }

    /**
     * Returns a range of all the labels.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of labels
     * @param end the upper bound of the range of labels (not inclusive)
     * @return the range of labels
     * @throws SystemException if a system exception occurred
     */
    public List<Label> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
    }

    /**
     * Returns an ordered range of all the labels.
     *
     * <p>
     * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
     * </p>
     *
     * @param start the lower bound of the range of labels
     * @param end the upper bound of the range of labels (not inclusive)
     * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
     * @return the ordered range of labels
     * @throws SystemException if a system exception occurred
     */
    public List<Label> findAll(int start, int end,
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

        List<Label> list = (List<Label>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_LABEL);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_LABEL;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Label>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Label>) QueryUtil.list(q, getDialect(), start,
                            end);
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
     * Removes all the labels where tagId = &#63; from the database.
     *
     * @param tagId the tag ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByTagId(long tagId) throws SystemException {
        for (Label label : findByTagId(tagId)) {
            remove(label);
        }
    }

    /**
     * Removes all the labels from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Label label : findAll()) {
            remove(label);
        }
    }

    /**
     * Returns the number of labels where tagId = &#63;.
     *
     * @param tagId the tag ID
     * @return the number of matching labels
     * @throws SystemException if a system exception occurred
     */
    public int countByTagId(long tagId) throws SystemException {
        Object[] finderArgs = new Object[] { tagId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_TAGID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_LABEL_WHERE);

            query.append(_FINDER_COLUMN_TAGID_TAGID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(tagId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_TAGID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of labels.
     *
     * @return the number of labels
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_LABEL);

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
     * Initializes the label persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.wcs.newsletter.model.Label")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Label>> listenersList = new ArrayList<ModelListener<Label>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Label>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(LabelImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
