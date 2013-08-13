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
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQuery;
import com.liferay.portal.kernel.dao.jdbc.MappingSqlQueryFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.RowMapper;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.wcs.newsletter.NoSuchNewsletterException;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.model.impl.NewsletterImpl;
import com.wcs.newsletter.model.impl.NewsletterModelImpl;
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
import java.util.Set;

/**
 * The persistence implementation for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistence
 * @see NewsletterUtil
 * @generated
 */
public class NewsletterPersistenceImpl extends BasePersistenceImpl<Newsletter>
    implements NewsletterPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = NewsletterImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByParentId",
            new String[] {
                Long.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID =
        new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByParentId",
            new String[] { Long.class.getName() },
            NewsletterModelImpl.PARENTID_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_PARENTID = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByParentId",
            new String[] { Long.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, NewsletterImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_GET_CATEGORIES = new FinderPath(com.wcs.newsletter.model.impl.CategoryModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED_WCSNEWSLETTER_NEWSLETTER_CATEGORY,
            com.wcs.newsletter.model.impl.CategoryImpl.class,
            NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME,
            "getCategories",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_CATEGORIES.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_CATEGORIES_SIZE = new FinderPath(com.wcs.newsletter.model.impl.CategoryModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED_WCSNEWSLETTER_NEWSLETTER_CATEGORY,
            Long.class,
            NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME,
            "getCategoriesSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_CATEGORIES_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_CATEGORY = new FinderPath(com.wcs.newsletter.model.impl.CategoryModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED_WCSNEWSLETTER_NEWSLETTER_CATEGORY,
            Boolean.class,
            NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME,
            "containsCategory",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_GET_LABELS = new FinderPath(com.wcs.newsletter.model.impl.LabelModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED_WCSNEWSLETTER_NEWSLETTER_LABEL,
            com.wcs.newsletter.model.impl.LabelImpl.class,
            NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME,
            "getLabels",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_LABELS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_LABELS_SIZE = new FinderPath(com.wcs.newsletter.model.impl.LabelModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED_WCSNEWSLETTER_NEWSLETTER_LABEL,
            Long.class,
            NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME,
            "getLabelsSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_LABELS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_LABEL = new FinderPath(com.wcs.newsletter.model.impl.LabelModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterModelImpl.FINDER_CACHE_ENABLED_WCSNEWSLETTER_NEWSLETTER_LABEL,
            Boolean.class,
            NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME,
            "containsLabel",
            new String[] { Long.class.getName(), Long.class.getName() });
    public static final FinderPath FINDER_PATH_GET_RECIPIENTS = new FinderPath(com.wcs.newsletter.model.impl.RecipientModelImpl.ENTITY_CACHE_ENABLED,
            com.wcs.newsletter.model.impl.RecipientModelImpl.FINDER_CACHE_ENABLED,
            com.wcs.newsletter.model.impl.RecipientImpl.class,
            com.wcs.newsletter.service.persistence.RecipientPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getRecipients",
            new String[] {
                Long.class.getName(), "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });

    static {
        FINDER_PATH_GET_RECIPIENTS.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_GET_RECIPIENTS_SIZE = new FinderPath(com.wcs.newsletter.model.impl.RecipientModelImpl.ENTITY_CACHE_ENABLED,
            com.wcs.newsletter.model.impl.RecipientModelImpl.FINDER_CACHE_ENABLED,
            com.wcs.newsletter.model.impl.RecipientImpl.class,
            com.wcs.newsletter.service.persistence.RecipientPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "getRecipientsSize", new String[] { Long.class.getName() });

    static {
        FINDER_PATH_GET_RECIPIENTS_SIZE.setCacheKeyGeneratorCacheName(null);
    }

    public static final FinderPath FINDER_PATH_CONTAINS_RECIPIENT = new FinderPath(com.wcs.newsletter.model.impl.RecipientModelImpl.ENTITY_CACHE_ENABLED,
            com.wcs.newsletter.model.impl.RecipientModelImpl.FINDER_CACHE_ENABLED,
            com.wcs.newsletter.model.impl.RecipientImpl.class,
            com.wcs.newsletter.service.persistence.RecipientPersistenceImpl.FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
            "containsRecipient",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _SQL_SELECT_NEWSLETTER = "SELECT newsletter FROM Newsletter newsletter";
    private static final String _SQL_SELECT_NEWSLETTER_WHERE = "SELECT newsletter FROM Newsletter newsletter WHERE ";
    private static final String _SQL_COUNT_NEWSLETTER = "SELECT COUNT(newsletter) FROM Newsletter newsletter";
    private static final String _SQL_COUNT_NEWSLETTER_WHERE = "SELECT COUNT(newsletter) FROM Newsletter newsletter WHERE ";
    private static final String _SQL_GETCATEGORIES = "SELECT {WcsNewsletter_Category.*} FROM WcsNewsletter_Category INNER JOIN WcsNewsletter_Newsletter_Category ON (WcsNewsletter_Newsletter_Category.categoryId = WcsNewsletter_Category.categoryId) WHERE (WcsNewsletter_Newsletter_Category.newsletterId = ?)";
    private static final String _SQL_GETCATEGORIESSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM WcsNewsletter_Newsletter_Category WHERE newsletterId = ?";
    private static final String _SQL_CONTAINSCATEGORY = "SELECT COUNT(*) AS COUNT_VALUE FROM WcsNewsletter_Newsletter_Category WHERE newsletterId = ? AND categoryId = ?";
    private static final String _SQL_GETLABELS = "SELECT {WcsNewsletter_Label.*} FROM WcsNewsletter_Label INNER JOIN WcsNewsletter_Newsletter_Label ON (WcsNewsletter_Newsletter_Label.labelId = WcsNewsletter_Label.labelId) WHERE (WcsNewsletter_Newsletter_Label.newsletterId = ?)";
    private static final String _SQL_GETLABELSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM WcsNewsletter_Newsletter_Label WHERE newsletterId = ?";
    private static final String _SQL_CONTAINSLABEL = "SELECT COUNT(*) AS COUNT_VALUE FROM WcsNewsletter_Newsletter_Label WHERE newsletterId = ? AND labelId = ?";
    private static final String _SQL_GETRECIPIENTS = "SELECT {WcsNewsletter_Recipient.*} FROM WcsNewsletter_Recipient INNER JOIN WcsNewsletter_Newsletter ON (WcsNewsletter_Newsletter.newsletterId = WcsNewsletter_Recipient.newsletterId) WHERE (WcsNewsletter_Newsletter.newsletterId = ?)";
    private static final String _SQL_GETRECIPIENTSSIZE = "SELECT COUNT(*) AS COUNT_VALUE FROM WcsNewsletter_Recipient WHERE newsletterId = ?";
    private static final String _SQL_CONTAINSRECIPIENT = "SELECT COUNT(*) AS COUNT_VALUE FROM WcsNewsletter_Recipient WHERE newsletterId = ? AND recipientId = ?";
    private static final String _FINDER_COLUMN_PARENTID_PARENTID_2 = "newsletter.parentId = ?";
    private static final String _ORDER_BY_ENTITY_ALIAS = "newsletter.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Newsletter exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Newsletter exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(NewsletterPersistenceImpl.class);
    private static Newsletter _nullNewsletter = new NewsletterImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Newsletter> toCacheModel() {
                return _nullNewsletterCacheModel;
            }
        };

    private static CacheModel<Newsletter> _nullNewsletterCacheModel = new CacheModel<Newsletter>() {
            public Newsletter toEntityModel() {
                return _nullNewsletter;
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
    protected ContainsCategory containsCategory;
    protected AddCategory addCategory;
    protected ClearCategories clearCategories;
    protected RemoveCategory removeCategory;
    protected ContainsLabel containsLabel;
    protected AddLabel addLabel;
    protected ClearLabels clearLabels;
    protected RemoveLabel removeLabel;
    protected ContainsRecipient containsRecipient;

    /**
     * Caches the newsletter in the entity cache if it is enabled.
     *
     * @param newsletter the newsletter
     */
    public void cacheResult(Newsletter newsletter) {
        EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter);

        newsletter.resetOriginalValues();
    }

    /**
     * Caches the newsletters in the entity cache if it is enabled.
     *
     * @param newsletters the newsletters
     */
    public void cacheResult(List<Newsletter> newsletters) {
        for (Newsletter newsletter : newsletters) {
            if (EntityCacheUtil.getResult(
                        NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                        NewsletterImpl.class, newsletter.getPrimaryKey()) == null) {
                cacheResult(newsletter);
            } else {
                newsletter.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all newsletters.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(NewsletterImpl.class.getName());
        }

        EntityCacheUtil.clearCache(NewsletterImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the newsletter.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Newsletter newsletter) {
        EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterImpl.class, newsletter.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Newsletter> newsletters) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Newsletter newsletter : newsletters) {
            EntityCacheUtil.removeResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                NewsletterImpl.class, newsletter.getPrimaryKey());
        }
    }

    /**
     * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
     *
     * @param newsletterId the primary key for the new newsletter
     * @return the new newsletter
     */
    public Newsletter create(long newsletterId) {
        Newsletter newsletter = new NewsletterImpl();

        newsletter.setNew(true);
        newsletter.setPrimaryKey(newsletterId);

        return newsletter;
    }

    /**
     * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param newsletterId the primary key of the newsletter
     * @return the newsletter that was removed
     * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Newsletter remove(long newsletterId)
        throws NoSuchNewsletterException, SystemException {
        return remove(Long.valueOf(newsletterId));
    }

    /**
     * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the newsletter
     * @return the newsletter that was removed
     * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter remove(Serializable primaryKey)
        throws NoSuchNewsletterException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Newsletter newsletter = (Newsletter) session.get(NewsletterImpl.class,
                    primaryKey);

            if (newsletter == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(newsletter);
        } catch (NoSuchNewsletterException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Newsletter removeImpl(Newsletter newsletter)
        throws SystemException {
        newsletter = toUnwrappedModel(newsletter);

        try {
            clearCategories.clear(newsletter.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }

        try {
            clearLabels.clear(newsletter.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, newsletter);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(newsletter);

        return newsletter;
    }

    @Override
    public Newsletter updateImpl(
        com.wcs.newsletter.model.Newsletter newsletter, boolean merge)
        throws SystemException {
        newsletter = toUnwrappedModel(newsletter);

        boolean isNew = newsletter.isNew();

        NewsletterModelImpl newsletterModelImpl = (NewsletterModelImpl) newsletter;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, newsletter, merge);

            newsletter.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !NewsletterModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((newsletterModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        Long.valueOf(newsletterModelImpl.getOriginalParentId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);

                args = new Object[] {
                        Long.valueOf(newsletterModelImpl.getParentId())
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_PARENTID, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID,
                    args);
            }
        }

        EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
            NewsletterImpl.class, newsletter.getPrimaryKey(), newsletter);

        return newsletter;
    }

    protected Newsletter toUnwrappedModel(Newsletter newsletter) {
        if (newsletter instanceof NewsletterImpl) {
            return newsletter;
        }

        NewsletterImpl newsletterImpl = new NewsletterImpl();

        newsletterImpl.setNew(newsletter.isNew());
        newsletterImpl.setPrimaryKey(newsletter.getPrimaryKey());

        newsletterImpl.setNewsletterId(newsletter.getNewsletterId());
        newsletterImpl.setSubject(newsletter.getSubject());
        newsletterImpl.setSender(newsletter.getSender());
        newsletterImpl.setContentId(newsletter.getContentId());
        newsletterImpl.setContentVersion(newsletter.getContentVersion());
        newsletterImpl.setTemplateId(newsletter.getTemplateId());
        newsletterImpl.setTemplateVersion(newsletter.getTemplateVersion());
        newsletterImpl.setParentId(newsletter.getParentId());
        newsletterImpl.setCreationTime(newsletter.getCreationTime());
        newsletterImpl.setState(newsletter.getState());

        return newsletterImpl;
    }

    /**
     * Returns the newsletter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the newsletter
     * @return the newsletter
     * @throws com.liferay.portal.NoSuchModelException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the newsletter with the primary key or throws a {@link com.wcs.newsletter.NoSuchNewsletterException} if it could not be found.
     *
     * @param newsletterId the primary key of the newsletter
     * @return the newsletter
     * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Newsletter findByPrimaryKey(long newsletterId)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = fetchByPrimaryKey(newsletterId);

        if (newsletter == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + newsletterId);
            }

            throw new NoSuchNewsletterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                newsletterId);
        }

        return newsletter;
    }

    /**
     * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the newsletter
     * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Newsletter fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param newsletterId the primary key of the newsletter
     * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Newsletter fetchByPrimaryKey(long newsletterId)
        throws SystemException {
        Newsletter newsletter = (Newsletter) EntityCacheUtil.getResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                NewsletterImpl.class, newsletterId);

        if (newsletter == _nullNewsletter) {
            return null;
        }

        if (newsletter == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                newsletter = (Newsletter) session.get(NewsletterImpl.class,
                        Long.valueOf(newsletterId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (newsletter != null) {
                    cacheResult(newsletter);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(NewsletterModelImpl.ENTITY_CACHE_ENABLED,
                        NewsletterImpl.class, newsletterId, _nullNewsletter);
                }

                closeSession(session);
            }
        }

        return newsletter;
    }

    /**
     * Returns all the newsletters where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @return the matching newsletters
     * @throws SystemException if a system exception occurred
     */
    public List<Newsletter> findByParentId(long parentId)
        throws SystemException {
        return findByParentId(parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
            null);
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
    public List<Newsletter> findByParentId(long parentId, int start, int end)
        throws SystemException {
        return findByParentId(parentId, start, end, null);
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
    public List<Newsletter> findByParentId(long parentId, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_PARENTID;
            finderArgs = new Object[] { parentId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_PARENTID;
            finderArgs = new Object[] { parentId, start, end, orderByComparator };
        }

        List<Newsletter> list = (List<Newsletter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Newsletter newsletter : list) {
                if ((parentId != newsletter.getParentId())) {
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

            query.append(_SQL_SELECT_NEWSLETTER_WHERE);

            query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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

                qPos.add(parentId);

                list = (List<Newsletter>) QueryUtil.list(q, getDialect(),
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
     * Returns the first newsletter in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching newsletter
     * @throws com.wcs.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
     * @throws SystemException if a system exception occurred
     */
    public Newsletter findByParentId_First(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = fetchByParentId_First(parentId,
                orderByComparator);

        if (newsletter != null) {
            return newsletter;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNewsletterException(msg.toString());
    }

    /**
     * Returns the first newsletter in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
     * @throws SystemException if a system exception occurred
     */
    public Newsletter fetchByParentId_First(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Newsletter> list = findByParentId(parentId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Newsletter findByParentId_Last(long parentId,
        OrderByComparator orderByComparator)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = fetchByParentId_Last(parentId, orderByComparator);

        if (newsletter != null) {
            return newsletter;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("parentId=");
        msg.append(parentId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchNewsletterException(msg.toString());
    }

    /**
     * Returns the last newsletter in the ordered set where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
     * @throws SystemException if a system exception occurred
     */
    public Newsletter fetchByParentId_Last(long parentId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByParentId(parentId);

        List<Newsletter> list = findByParentId(parentId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Newsletter[] findByParentId_PrevAndNext(long newsletterId,
        long parentId, OrderByComparator orderByComparator)
        throws NoSuchNewsletterException, SystemException {
        Newsletter newsletter = findByPrimaryKey(newsletterId);

        Session session = null;

        try {
            session = openSession();

            Newsletter[] array = new NewsletterImpl[3];

            array[0] = getByParentId_PrevAndNext(session, newsletter, parentId,
                    orderByComparator, true);

            array[1] = newsletter;

            array[2] = getByParentId_PrevAndNext(session, newsletter, parentId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Newsletter getByParentId_PrevAndNext(Session session,
        Newsletter newsletter, long parentId,
        OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_NEWSLETTER_WHERE);

        query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

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

        qPos.add(parentId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(newsletter);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Newsletter> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the newsletters.
     *
     * @return the newsletters
     * @throws SystemException if a system exception occurred
     */
    public List<Newsletter> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Newsletter> findAll(int start, int end)
        throws SystemException {
        return findAll(start, end, null);
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
    public List<Newsletter> findAll(int start, int end,
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

        List<Newsletter> list = (List<Newsletter>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_NEWSLETTER);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_NEWSLETTER;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Newsletter>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Newsletter>) QueryUtil.list(q, getDialect(),
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
     * Removes all the newsletters where parentId = &#63; from the database.
     *
     * @param parentId the parent ID
     * @throws SystemException if a system exception occurred
     */
    public void removeByParentId(long parentId) throws SystemException {
        for (Newsletter newsletter : findByParentId(parentId)) {
            remove(newsletter);
        }
    }

    /**
     * Removes all the newsletters from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Newsletter newsletter : findAll()) {
            remove(newsletter);
        }
    }

    /**
     * Returns the number of newsletters where parentId = &#63;.
     *
     * @param parentId the parent ID
     * @return the number of matching newsletters
     * @throws SystemException if a system exception occurred
     */
    public int countByParentId(long parentId) throws SystemException {
        Object[] finderArgs = new Object[] { parentId };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_PARENTID,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_NEWSLETTER_WHERE);

            query.append(_FINDER_COLUMN_PARENTID_PARENTID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(parentId);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_PARENTID,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of newsletters.
     *
     * @return the number of newsletters
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_NEWSLETTER);

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
     * Returns all the categories associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @return the categories associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public List<com.wcs.newsletter.model.Category> getCategories(long pk)
        throws SystemException {
        return getCategories(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
    public List<com.wcs.newsletter.model.Category> getCategories(long pk,
        int start, int end) throws SystemException {
        return getCategories(pk, start, end, null);
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
    public List<com.wcs.newsletter.model.Category> getCategories(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<com.wcs.newsletter.model.Category> list = (List<com.wcs.newsletter.model.Category>) FinderCacheUtil.getResult(FINDER_PATH_GET_CATEGORIES,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETCATEGORIES.concat(ORDER_BY_CLAUSE)
                                            .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETCATEGORIES;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("WcsNewsletter_Category",
                    com.wcs.newsletter.model.impl.CategoryImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<com.wcs.newsletter.model.Category>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_CATEGORIES,
                        finderArgs);
                } else {
                    categoryPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_CATEGORIES,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of categories associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @return the number of categories associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public int getCategoriesSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_CATEGORIES_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETCATEGORIESSIZE);

                q.addScalar(COUNT_COLUMN_NAME,
                    com.liferay.portal.kernel.dao.orm.Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_CATEGORIES_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the category is associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @param categoryPK the primary key of the category
     * @return <code>true</code> if the category is associated with the newsletter; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsCategory(long pk, long categoryPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, categoryPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_CATEGORY,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsCategory.contains(pk, categoryPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_CATEGORY,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the newsletter has any categories associated with it.
     *
     * @param pk the primary key of the newsletter to check for associations with categories
     * @return <code>true</code> if the newsletter has any categories associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsCategories(long pk) throws SystemException {
        if (getCategoriesSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categoryPK the primary key of the category
     * @throws SystemException if a system exception occurred
     */
    public void addCategory(long pk, long categoryPK) throws SystemException {
        try {
            addCategory.add(pk, categoryPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param category the category
     * @throws SystemException if a system exception occurred
     */
    public void addCategory(long pk, com.wcs.newsletter.model.Category category)
        throws SystemException {
        try {
            addCategory.add(pk, category.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categoryPKs the primary keys of the categories
     * @throws SystemException if a system exception occurred
     */
    public void addCategories(long pk, long[] categoryPKs)
        throws SystemException {
        try {
            for (long categoryPK : categoryPKs) {
                addCategory.add(pk, categoryPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Adds an association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categories the categories
     * @throws SystemException if a system exception occurred
     */
    public void addCategories(long pk,
        List<com.wcs.newsletter.model.Category> categories)
        throws SystemException {
        try {
            for (com.wcs.newsletter.model.Category category : categories) {
                addCategory.add(pk, category.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Clears all associations between the newsletter and its categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter to clear the associated categories from
     * @throws SystemException if a system exception occurred
     */
    public void clearCategories(long pk) throws SystemException {
        try {
            clearCategories.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categoryPK the primary key of the category
     * @throws SystemException if a system exception occurred
     */
    public void removeCategory(long pk, long categoryPK)
        throws SystemException {
        try {
            removeCategory.remove(pk, categoryPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param category the category
     * @throws SystemException if a system exception occurred
     */
    public void removeCategory(long pk,
        com.wcs.newsletter.model.Category category) throws SystemException {
        try {
            removeCategory.remove(pk, category.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categoryPKs the primary keys of the categories
     * @throws SystemException if a system exception occurred
     */
    public void removeCategories(long pk, long[] categoryPKs)
        throws SystemException {
        try {
            for (long categoryPK : categoryPKs) {
                removeCategory.remove(pk, categoryPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categories the categories
     * @throws SystemException if a system exception occurred
     */
    public void removeCategories(long pk,
        List<com.wcs.newsletter.model.Category> categories)
        throws SystemException {
        try {
            for (com.wcs.newsletter.model.Category category : categories) {
                removeCategory.remove(pk, category.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Sets the categories associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categoryPKs the primary keys of the categories to be associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public void setCategories(long pk, long[] categoryPKs)
        throws SystemException {
        try {
            Set<Long> categoryPKSet = SetUtil.fromArray(categoryPKs);

            List<com.wcs.newsletter.model.Category> categories = getCategories(pk);

            for (com.wcs.newsletter.model.Category category : categories) {
                if (!categoryPKSet.remove(category.getPrimaryKey())) {
                    removeCategory.remove(pk, category.getPrimaryKey());
                }
            }

            for (Long categoryPK : categoryPKSet) {
                addCategory.add(pk, categoryPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Sets the categories associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param categories the categories to be associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public void setCategories(long pk,
        List<com.wcs.newsletter.model.Category> categories)
        throws SystemException {
        try {
            long[] categoryPKs = new long[categories.size()];

            for (int i = 0; i < categories.size(); i++) {
                com.wcs.newsletter.model.Category category = categories.get(i);

                categoryPKs[i] = category.getPrimaryKey();
            }

            setCategories(pk, categoryPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_CATEGORY_NAME);
        }
    }

    /**
     * Returns all the labels associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @return the labels associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public List<com.wcs.newsletter.model.Label> getLabels(long pk)
        throws SystemException {
        return getLabels(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
    public List<com.wcs.newsletter.model.Label> getLabels(long pk, int start,
        int end) throws SystemException {
        return getLabels(pk, start, end, null);
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
    public List<com.wcs.newsletter.model.Label> getLabels(long pk, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<com.wcs.newsletter.model.Label> list = (List<com.wcs.newsletter.model.Label>) FinderCacheUtil.getResult(FINDER_PATH_GET_LABELS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETLABELS.concat(ORDER_BY_CLAUSE)
                                        .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETLABELS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("WcsNewsletter_Label",
                    com.wcs.newsletter.model.impl.LabelImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<com.wcs.newsletter.model.Label>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_LABELS,
                        finderArgs);
                } else {
                    labelPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_LABELS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of labels associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @return the number of labels associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public int getLabelsSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_LABELS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETLABELSSIZE);

                q.addScalar(COUNT_COLUMN_NAME,
                    com.liferay.portal.kernel.dao.orm.Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_LABELS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the label is associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @param labelPK the primary key of the label
     * @return <code>true</code> if the label is associated with the newsletter; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsLabel(long pk, long labelPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, labelPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_LABEL,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsLabel.contains(pk, labelPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_LABEL,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the newsletter has any labels associated with it.
     *
     * @param pk the primary key of the newsletter to check for associations with labels
     * @return <code>true</code> if the newsletter has any labels associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsLabels(long pk) throws SystemException {
        if (getLabelsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Adds an association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labelPK the primary key of the label
     * @throws SystemException if a system exception occurred
     */
    public void addLabel(long pk, long labelPK) throws SystemException {
        try {
            addLabel.add(pk, labelPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Adds an association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param label the label
     * @throws SystemException if a system exception occurred
     */
    public void addLabel(long pk, com.wcs.newsletter.model.Label label)
        throws SystemException {
        try {
            addLabel.add(pk, label.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Adds an association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labelPKs the primary keys of the labels
     * @throws SystemException if a system exception occurred
     */
    public void addLabels(long pk, long[] labelPKs) throws SystemException {
        try {
            for (long labelPK : labelPKs) {
                addLabel.add(pk, labelPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Adds an association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labels the labels
     * @throws SystemException if a system exception occurred
     */
    public void addLabels(long pk, List<com.wcs.newsletter.model.Label> labels)
        throws SystemException {
        try {
            for (com.wcs.newsletter.model.Label label : labels) {
                addLabel.add(pk, label.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Clears all associations between the newsletter and its labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter to clear the associated labels from
     * @throws SystemException if a system exception occurred
     */
    public void clearLabels(long pk) throws SystemException {
        try {
            clearLabels.clear(pk);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labelPK the primary key of the label
     * @throws SystemException if a system exception occurred
     */
    public void removeLabel(long pk, long labelPK) throws SystemException {
        try {
            removeLabel.remove(pk, labelPK);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param label the label
     * @throws SystemException if a system exception occurred
     */
    public void removeLabel(long pk, com.wcs.newsletter.model.Label label)
        throws SystemException {
        try {
            removeLabel.remove(pk, label.getPrimaryKey());
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labelPKs the primary keys of the labels
     * @throws SystemException if a system exception occurred
     */
    public void removeLabels(long pk, long[] labelPKs)
        throws SystemException {
        try {
            for (long labelPK : labelPKs) {
                removeLabel.remove(pk, labelPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Removes the association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labels the labels
     * @throws SystemException if a system exception occurred
     */
    public void removeLabels(long pk,
        List<com.wcs.newsletter.model.Label> labels) throws SystemException {
        try {
            for (com.wcs.newsletter.model.Label label : labels) {
                removeLabel.remove(pk, label.getPrimaryKey());
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Sets the labels associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labelPKs the primary keys of the labels to be associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public void setLabels(long pk, long[] labelPKs) throws SystemException {
        try {
            Set<Long> labelPKSet = SetUtil.fromArray(labelPKs);

            List<com.wcs.newsletter.model.Label> labels = getLabels(pk);

            for (com.wcs.newsletter.model.Label label : labels) {
                if (!labelPKSet.remove(label.getPrimaryKey())) {
                    removeLabel.remove(pk, label.getPrimaryKey());
                }
            }

            for (Long labelPK : labelPKSet) {
                addLabel.add(pk, labelPK);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Sets the labels associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
     *
     * @param pk the primary key of the newsletter
     * @param labels the labels to be associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public void setLabels(long pk, List<com.wcs.newsletter.model.Label> labels)
        throws SystemException {
        try {
            long[] labelPKs = new long[labels.size()];

            for (int i = 0; i < labels.size(); i++) {
                com.wcs.newsletter.model.Label label = labels.get(i);

                labelPKs[i] = label.getPrimaryKey();
            }

            setLabels(pk, labelPKs);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            FinderCacheUtil.clearCache(NewsletterModelImpl.MAPPING_TABLE_WCSNEWSLETTER_NEWSLETTER_LABEL_NAME);
        }
    }

    /**
     * Returns all the recipients associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @return the recipients associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public List<com.wcs.newsletter.model.Recipient> getRecipients(long pk)
        throws SystemException {
        return getRecipients(pk, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
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
    public List<com.wcs.newsletter.model.Recipient> getRecipients(long pk,
        int start, int end) throws SystemException {
        return getRecipients(pk, start, end, null);
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
    public List<com.wcs.newsletter.model.Recipient> getRecipients(long pk,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, start, end, orderByComparator };

        List<com.wcs.newsletter.model.Recipient> list = (List<com.wcs.newsletter.model.Recipient>) FinderCacheUtil.getResult(FINDER_PATH_GET_RECIPIENTS,
                finderArgs, this);

        if (list == null) {
            Session session = null;

            try {
                session = openSession();

                String sql = null;

                if (orderByComparator != null) {
                    sql = _SQL_GETRECIPIENTS.concat(ORDER_BY_CLAUSE)
                                            .concat(orderByComparator.getOrderBy());
                } else {
                    sql = _SQL_GETRECIPIENTS;
                }

                SQLQuery q = session.createSQLQuery(sql);

                q.addEntity("WcsNewsletter_Recipient",
                    com.wcs.newsletter.model.impl.RecipientImpl.class);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                list = (List<com.wcs.newsletter.model.Recipient>) QueryUtil.list(q,
                        getDialect(), start, end);
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (list == null) {
                    FinderCacheUtil.removeResult(FINDER_PATH_GET_RECIPIENTS,
                        finderArgs);
                } else {
                    recipientPersistence.cacheResult(list);

                    FinderCacheUtil.putResult(FINDER_PATH_GET_RECIPIENTS,
                        finderArgs, list);
                }

                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Returns the number of recipients associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @return the number of recipients associated with the newsletter
     * @throws SystemException if a system exception occurred
     */
    public int getRecipientsSize(long pk) throws SystemException {
        Object[] finderArgs = new Object[] { pk };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_GET_RECIPIENTS_SIZE,
                finderArgs, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                SQLQuery q = session.createSQLQuery(_SQL_GETRECIPIENTSSIZE);

                q.addScalar(COUNT_COLUMN_NAME,
                    com.liferay.portal.kernel.dao.orm.Type.LONG);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(pk);

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_GET_RECIPIENTS_SIZE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns <code>true</code> if the recipient is associated with the newsletter.
     *
     * @param pk the primary key of the newsletter
     * @param recipientPK the primary key of the recipient
     * @return <code>true</code> if the recipient is associated with the newsletter; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsRecipient(long pk, long recipientPK)
        throws SystemException {
        Object[] finderArgs = new Object[] { pk, recipientPK };

        Boolean value = (Boolean) FinderCacheUtil.getResult(FINDER_PATH_CONTAINS_RECIPIENT,
                finderArgs, this);

        if (value == null) {
            try {
                value = Boolean.valueOf(containsRecipient.contains(pk,
                            recipientPK));
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (value == null) {
                    value = Boolean.FALSE;
                }

                FinderCacheUtil.putResult(FINDER_PATH_CONTAINS_RECIPIENT,
                    finderArgs, value);
            }
        }

        return value.booleanValue();
    }

    /**
     * Returns <code>true</code> if the newsletter has any recipients associated with it.
     *
     * @param pk the primary key of the newsletter to check for associations with recipients
     * @return <code>true</code> if the newsletter has any recipients associated with it; <code>false</code> otherwise
     * @throws SystemException if a system exception occurred
     */
    public boolean containsRecipients(long pk) throws SystemException {
        if (getRecipientsSize(pk) > 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Initializes the newsletter persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.wcs.newsletter.model.Newsletter")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Newsletter>> listenersList = new ArrayList<ModelListener<Newsletter>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Newsletter>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }

        containsCategory = new ContainsCategory();

        addCategory = new AddCategory();
        clearCategories = new ClearCategories();
        removeCategory = new RemoveCategory();

        containsLabel = new ContainsLabel();

        addLabel = new AddLabel();
        clearLabels = new ClearLabels();
        removeLabel = new RemoveLabel();

        containsRecipient = new ContainsRecipient();
    }

    public void destroy() {
        EntityCacheUtil.removeCache(NewsletterImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    protected class ContainsCategory {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsCategory() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSCATEGORY,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long newsletterId, long categoryId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(newsletterId), new Long(categoryId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }

    protected class AddCategory {
        private SqlUpdate _sqlUpdate;

        protected AddCategory() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO WcsNewsletter_Newsletter_Category (newsletterId, categoryId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long newsletterId, long categoryId)
            throws SystemException {
            if (!containsCategory.contains(newsletterId, categoryId)) {
                ModelListener<com.wcs.newsletter.model.Category>[] categoryListeners =
                    categoryPersistence.getListeners();

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onBeforeAddAssociation(newsletterId,
                        com.wcs.newsletter.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<com.wcs.newsletter.model.Category> listener : categoryListeners) {
                    listener.onBeforeAddAssociation(categoryId,
                        Newsletter.class.getName(), newsletterId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(newsletterId), new Long(categoryId)
                    });

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onAfterAddAssociation(newsletterId,
                        com.wcs.newsletter.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<com.wcs.newsletter.model.Category> listener : categoryListeners) {
                    listener.onAfterAddAssociation(categoryId,
                        Newsletter.class.getName(), newsletterId);
                }
            }
        }
    }

    protected class ClearCategories {
        private SqlUpdate _sqlUpdate;

        protected ClearCategories() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM WcsNewsletter_Newsletter_Category WHERE newsletterId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long newsletterId) throws SystemException {
            ModelListener<com.wcs.newsletter.model.Category>[] categoryListeners =
                categoryPersistence.getListeners();

            List<com.wcs.newsletter.model.Category> categories = null;

            if ((listeners.length > 0) || (categoryListeners.length > 0)) {
                categories = getCategories(newsletterId);

                for (com.wcs.newsletter.model.Category category : categories) {
                    for (ModelListener<Newsletter> listener : listeners) {
                        listener.onBeforeRemoveAssociation(newsletterId,
                            com.wcs.newsletter.model.Category.class.getName(),
                            category.getPrimaryKey());
                    }

                    for (ModelListener<com.wcs.newsletter.model.Category> listener : categoryListeners) {
                        listener.onBeforeRemoveAssociation(category.getPrimaryKey(),
                            Newsletter.class.getName(), newsletterId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(newsletterId) });

            if ((listeners.length > 0) || (categoryListeners.length > 0)) {
                for (com.wcs.newsletter.model.Category category : categories) {
                    for (ModelListener<Newsletter> listener : listeners) {
                        listener.onAfterRemoveAssociation(newsletterId,
                            com.wcs.newsletter.model.Category.class.getName(),
                            category.getPrimaryKey());
                    }

                    for (ModelListener<com.wcs.newsletter.model.Category> listener : categoryListeners) {
                        listener.onAfterRemoveAssociation(category.getPrimaryKey(),
                            Newsletter.class.getName(), newsletterId);
                    }
                }
            }
        }
    }

    protected class RemoveCategory {
        private SqlUpdate _sqlUpdate;

        protected RemoveCategory() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM WcsNewsletter_Newsletter_Category WHERE newsletterId = ? AND categoryId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long newsletterId, long categoryId)
            throws SystemException {
            if (containsCategory.contains(newsletterId, categoryId)) {
                ModelListener<com.wcs.newsletter.model.Category>[] categoryListeners =
                    categoryPersistence.getListeners();

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onBeforeRemoveAssociation(newsletterId,
                        com.wcs.newsletter.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<com.wcs.newsletter.model.Category> listener : categoryListeners) {
                    listener.onBeforeRemoveAssociation(categoryId,
                        Newsletter.class.getName(), newsletterId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(newsletterId), new Long(categoryId)
                    });

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onAfterRemoveAssociation(newsletterId,
                        com.wcs.newsletter.model.Category.class.getName(),
                        categoryId);
                }

                for (ModelListener<com.wcs.newsletter.model.Category> listener : categoryListeners) {
                    listener.onAfterRemoveAssociation(categoryId,
                        Newsletter.class.getName(), newsletterId);
                }
            }
        }
    }

    protected class ContainsLabel {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsLabel() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSLABEL,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long newsletterId, long labelId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(newsletterId), new Long(labelId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }

    protected class AddLabel {
        private SqlUpdate _sqlUpdate;

        protected AddLabel() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "INSERT INTO WcsNewsletter_Newsletter_Label (newsletterId, labelId) VALUES (?, ?)",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void add(long newsletterId, long labelId)
            throws SystemException {
            if (!containsLabel.contains(newsletterId, labelId)) {
                ModelListener<com.wcs.newsletter.model.Label>[] labelListeners = labelPersistence.getListeners();

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onBeforeAddAssociation(newsletterId,
                        com.wcs.newsletter.model.Label.class.getName(), labelId);
                }

                for (ModelListener<com.wcs.newsletter.model.Label> listener : labelListeners) {
                    listener.onBeforeAddAssociation(labelId,
                        Newsletter.class.getName(), newsletterId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(newsletterId), new Long(labelId)
                    });

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onAfterAddAssociation(newsletterId,
                        com.wcs.newsletter.model.Label.class.getName(), labelId);
                }

                for (ModelListener<com.wcs.newsletter.model.Label> listener : labelListeners) {
                    listener.onAfterAddAssociation(labelId,
                        Newsletter.class.getName(), newsletterId);
                }
            }
        }
    }

    protected class ClearLabels {
        private SqlUpdate _sqlUpdate;

        protected ClearLabels() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM WcsNewsletter_Newsletter_Label WHERE newsletterId = ?",
                    new int[] { java.sql.Types.BIGINT });
        }

        protected void clear(long newsletterId) throws SystemException {
            ModelListener<com.wcs.newsletter.model.Label>[] labelListeners = labelPersistence.getListeners();

            List<com.wcs.newsletter.model.Label> labels = null;

            if ((listeners.length > 0) || (labelListeners.length > 0)) {
                labels = getLabels(newsletterId);

                for (com.wcs.newsletter.model.Label label : labels) {
                    for (ModelListener<Newsletter> listener : listeners) {
                        listener.onBeforeRemoveAssociation(newsletterId,
                            com.wcs.newsletter.model.Label.class.getName(),
                            label.getPrimaryKey());
                    }

                    for (ModelListener<com.wcs.newsletter.model.Label> listener : labelListeners) {
                        listener.onBeforeRemoveAssociation(label.getPrimaryKey(),
                            Newsletter.class.getName(), newsletterId);
                    }
                }
            }

            _sqlUpdate.update(new Object[] { new Long(newsletterId) });

            if ((listeners.length > 0) || (labelListeners.length > 0)) {
                for (com.wcs.newsletter.model.Label label : labels) {
                    for (ModelListener<Newsletter> listener : listeners) {
                        listener.onAfterRemoveAssociation(newsletterId,
                            com.wcs.newsletter.model.Label.class.getName(),
                            label.getPrimaryKey());
                    }

                    for (ModelListener<com.wcs.newsletter.model.Label> listener : labelListeners) {
                        listener.onAfterRemoveAssociation(label.getPrimaryKey(),
                            Newsletter.class.getName(), newsletterId);
                    }
                }
            }
        }
    }

    protected class RemoveLabel {
        private SqlUpdate _sqlUpdate;

        protected RemoveLabel() {
            _sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(getDataSource(),
                    "DELETE FROM WcsNewsletter_Newsletter_Label WHERE newsletterId = ? AND labelId = ?",
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT });
        }

        protected void remove(long newsletterId, long labelId)
            throws SystemException {
            if (containsLabel.contains(newsletterId, labelId)) {
                ModelListener<com.wcs.newsletter.model.Label>[] labelListeners = labelPersistence.getListeners();

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onBeforeRemoveAssociation(newsletterId,
                        com.wcs.newsletter.model.Label.class.getName(), labelId);
                }

                for (ModelListener<com.wcs.newsletter.model.Label> listener : labelListeners) {
                    listener.onBeforeRemoveAssociation(labelId,
                        Newsletter.class.getName(), newsletterId);
                }

                _sqlUpdate.update(new Object[] {
                        new Long(newsletterId), new Long(labelId)
                    });

                for (ModelListener<Newsletter> listener : listeners) {
                    listener.onAfterRemoveAssociation(newsletterId,
                        com.wcs.newsletter.model.Label.class.getName(), labelId);
                }

                for (ModelListener<com.wcs.newsletter.model.Label> listener : labelListeners) {
                    listener.onAfterRemoveAssociation(labelId,
                        Newsletter.class.getName(), newsletterId);
                }
            }
        }
    }

    protected class ContainsRecipient {
        private MappingSqlQuery<Integer> _mappingSqlQuery;

        protected ContainsRecipient() {
            _mappingSqlQuery = MappingSqlQueryFactoryUtil.getMappingSqlQuery(getDataSource(),
                    _SQL_CONTAINSRECIPIENT,
                    new int[] { java.sql.Types.BIGINT, java.sql.Types.BIGINT },
                    RowMapper.COUNT);
        }

        protected boolean contains(long newsletterId, long recipientId) {
            List<Integer> results = _mappingSqlQuery.execute(new Object[] {
                        new Long(newsletterId), new Long(recipientId)
                    });

            if (results.size() > 0) {
                Integer count = results.get(0);

                if (count.intValue() > 0) {
                    return true;
                }
            }

            return false;
        }
    }
}
