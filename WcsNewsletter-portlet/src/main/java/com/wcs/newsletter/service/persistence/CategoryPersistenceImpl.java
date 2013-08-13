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

import com.wcs.newsletter.NoSuchCategoryException;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.impl.CategoryImpl;
import com.wcs.newsletter.model.impl.CategoryModelImpl;
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
 * The persistence implementation for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryPersistence
 * @see CategoryUtil
 * @generated
 */
public class CategoryPersistenceImpl extends BasePersistenceImpl<Category>
    implements CategoryPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = CategoryImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALE = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLocale",
            new String[] {
                String.class.getName(),
                
            "java.lang.Integer", "java.lang.Integer",
                "com.liferay.portal.kernel.util.OrderByComparator"
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE =
        new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLocale",
            new String[] { String.class.getName() },
            CategoryModelImpl.LOCALE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_LOCALE = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLocale",
            new String[] { String.class.getName() });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, CategoryImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    private static final String _SQL_SELECT_CATEGORY = "SELECT category FROM Category category";
    private static final String _SQL_SELECT_CATEGORY_WHERE = "SELECT category FROM Category category WHERE ";
    private static final String _SQL_COUNT_CATEGORY = "SELECT COUNT(category) FROM Category category";
    private static final String _SQL_COUNT_CATEGORY_WHERE = "SELECT COUNT(category) FROM Category category WHERE ";
    private static final String _FINDER_COLUMN_LOCALE_LOCALE_1 = "category.locale IS NULL";
    private static final String _FINDER_COLUMN_LOCALE_LOCALE_2 = "category.locale = ?";
    private static final String _FINDER_COLUMN_LOCALE_LOCALE_3 = "(category.locale IS NULL OR category.locale = ?)";
    private static final String _ORDER_BY_ENTITY_ALIAS = "category.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Category exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Category exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(CategoryPersistenceImpl.class);
    private static Category _nullCategory = new CategoryImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Category> toCacheModel() {
                return _nullCategoryCacheModel;
            }
        };

    private static CacheModel<Category> _nullCategoryCacheModel = new CacheModel<Category>() {
            public Category toEntityModel() {
                return _nullCategory;
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
     * Caches the category in the entity cache if it is enabled.
     *
     * @param category the category
     */
    public void cacheResult(Category category) {
        EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey(), category);

        category.resetOriginalValues();
    }

    /**
     * Caches the categories in the entity cache if it is enabled.
     *
     * @param categories the categories
     */
    public void cacheResult(List<Category> categories) {
        for (Category category : categories) {
            if (EntityCacheUtil.getResult(
                        CategoryModelImpl.ENTITY_CACHE_ENABLED,
                        CategoryImpl.class, category.getPrimaryKey()) == null) {
                cacheResult(category);
            } else {
                category.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all categories.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(CategoryImpl.class.getName());
        }

        EntityCacheUtil.clearCache(CategoryImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the category.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Category category) {
        EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Category> categories) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Category category : categories) {
            EntityCacheUtil.removeResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                CategoryImpl.class, category.getPrimaryKey());
        }
    }

    /**
     * Creates a new category with the primary key. Does not add the category to the database.
     *
     * @param categoryId the primary key for the new category
     * @return the new category
     */
    public Category create(long categoryId) {
        Category category = new CategoryImpl();

        category.setNew(true);
        category.setPrimaryKey(categoryId);

        return category;
    }

    /**
     * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param categoryId the primary key of the category
     * @return the category that was removed
     * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category remove(long categoryId)
        throws NoSuchCategoryException, SystemException {
        return remove(Long.valueOf(categoryId));
    }

    /**
     * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the category
     * @return the category that was removed
     * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category remove(Serializable primaryKey)
        throws NoSuchCategoryException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Category category = (Category) session.get(CategoryImpl.class,
                    primaryKey);

            if (category == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(category);
        } catch (NoSuchCategoryException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Category removeImpl(Category category) throws SystemException {
        category = toUnwrappedModel(category);

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.delete(session, category);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        clearCache(category);

        return category;
    }

    @Override
    public Category updateImpl(com.wcs.newsletter.model.Category category,
        boolean merge) throws SystemException {
        category = toUnwrappedModel(category);

        boolean isNew = category.isNew();

        CategoryModelImpl categoryModelImpl = (CategoryModelImpl) category;

        Session session = null;

        try {
            session = openSession();

            BatchSessionUtil.update(session, category, merge);

            category.setNew(false);
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !CategoryModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((categoryModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        categoryModelImpl.getOriginalLocale()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE,
                    args);

                args = new Object[] { categoryModelImpl.getLocale() };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_LOCALE, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE,
                    args);
            }
        }

        EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
            CategoryImpl.class, category.getPrimaryKey(), category);

        return category;
    }

    protected Category toUnwrappedModel(Category category) {
        if (category instanceof CategoryImpl) {
            return category;
        }

        CategoryImpl categoryImpl = new CategoryImpl();

        categoryImpl.setNew(category.isNew());
        categoryImpl.setPrimaryKey(category.getPrimaryKey());

        categoryImpl.setCategoryId(category.getCategoryId());
        categoryImpl.setName(category.getName());
        categoryImpl.setLocale(category.getLocale());

        return categoryImpl;
    }

    /**
     * Returns the category with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the category
     * @return the category
     * @throws com.liferay.portal.NoSuchModelException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category findByPrimaryKey(Serializable primaryKey)
        throws NoSuchModelException, SystemException {
        return findByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the category with the primary key or throws a {@link com.wcs.newsletter.NoSuchCategoryException} if it could not be found.
     *
     * @param categoryId the primary key of the category
     * @return the category
     * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findByPrimaryKey(long categoryId)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByPrimaryKey(categoryId);

        if (category == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + categoryId);
            }

            throw new NoSuchCategoryException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                categoryId);
        }

        return category;
    }

    /**
     * Returns the category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the category
     * @return the category, or <code>null</code> if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Category fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        return fetchByPrimaryKey(((Long) primaryKey).longValue());
    }

    /**
     * Returns the category with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param categoryId the primary key of the category
     * @return the category, or <code>null</code> if a category with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchByPrimaryKey(long categoryId)
        throws SystemException {
        Category category = (Category) EntityCacheUtil.getResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                CategoryImpl.class, categoryId);

        if (category == _nullCategory) {
            return null;
        }

        if (category == null) {
            Session session = null;

            boolean hasException = false;

            try {
                session = openSession();

                category = (Category) session.get(CategoryImpl.class,
                        Long.valueOf(categoryId));
            } catch (Exception e) {
                hasException = true;

                throw processException(e);
            } finally {
                if (category != null) {
                    cacheResult(category);
                } else if (!hasException) {
                    EntityCacheUtil.putResult(CategoryModelImpl.ENTITY_CACHE_ENABLED,
                        CategoryImpl.class, categoryId, _nullCategory);
                }

                closeSession(session);
            }
        }

        return category;
    }

    /**
     * Returns all the categories where locale = &#63;.
     *
     * @param locale the locale
     * @return the matching categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findByLocale(String locale) throws SystemException {
        return findByLocale(locale, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Category> findByLocale(String locale, int start, int end)
        throws SystemException {
        return findByLocale(locale, start, end, null);
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
    public List<Category> findByLocale(String locale, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LOCALE;
            finderArgs = new Object[] { locale };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LOCALE;
            finderArgs = new Object[] { locale, start, end, orderByComparator };
        }

        List<Category> list = (List<Category>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Category category : list) {
                if (!Validator.equals(locale, category.getLocale())) {
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

            query.append(_SQL_SELECT_CATEGORY_WHERE);

            if (locale == null) {
                query.append(_FINDER_COLUMN_LOCALE_LOCALE_1);
            } else {
                if (locale.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_LOCALE_LOCALE_3);
                } else {
                    query.append(_FINDER_COLUMN_LOCALE_LOCALE_2);
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

                if (locale != null) {
                    qPos.add(locale);
                }

                list = (List<Category>) QueryUtil.list(q, getDialect(), start,
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
     * Returns the first category in the ordered set where locale = &#63;.
     *
     * @param locale the locale
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category
     * @throws com.wcs.newsletter.NoSuchCategoryException if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category findByLocale_First(String locale,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByLocale_First(locale, orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("locale=");
        msg.append(locale);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the first category in the ordered set where locale = &#63;.
     *
     * @param locale the locale
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the first matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchByLocale_First(String locale,
        OrderByComparator orderByComparator) throws SystemException {
        List<Category> list = findByLocale(locale, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Category findByLocale_Last(String locale,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = fetchByLocale_Last(locale, orderByComparator);

        if (category != null) {
            return category;
        }

        StringBundler msg = new StringBundler(4);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("locale=");
        msg.append(locale);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchCategoryException(msg.toString());
    }

    /**
     * Returns the last category in the ordered set where locale = &#63;.
     *
     * @param locale the locale
     * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
     * @return the last matching category, or <code>null</code> if a matching category could not be found
     * @throws SystemException if a system exception occurred
     */
    public Category fetchByLocale_Last(String locale,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByLocale(locale);

        List<Category> list = findByLocale(locale, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    public Category[] findByLocale_PrevAndNext(long categoryId, String locale,
        OrderByComparator orderByComparator)
        throws NoSuchCategoryException, SystemException {
        Category category = findByPrimaryKey(categoryId);

        Session session = null;

        try {
            session = openSession();

            Category[] array = new CategoryImpl[3];

            array[0] = getByLocale_PrevAndNext(session, category, locale,
                    orderByComparator, true);

            array[1] = category;

            array[2] = getByLocale_PrevAndNext(session, category, locale,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Category getByLocale_PrevAndNext(Session session,
        Category category, String locale, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_CATEGORY_WHERE);

        if (locale == null) {
            query.append(_FINDER_COLUMN_LOCALE_LOCALE_1);
        } else {
            if (locale.equals(StringPool.BLANK)) {
                query.append(_FINDER_COLUMN_LOCALE_LOCALE_3);
            } else {
                query.append(_FINDER_COLUMN_LOCALE_LOCALE_2);
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

        if (locale != null) {
            qPos.add(locale);
        }

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(category);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Category> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Returns all the categories.
     *
     * @return the categories
     * @throws SystemException if a system exception occurred
     */
    public List<Category> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    public List<Category> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    public List<Category> findAll(int start, int end,
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

        List<Category> list = (List<Category>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_CATEGORY);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_CATEGORY;
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (orderByComparator == null) {
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
                            start, end, false);

                    Collections.sort(list);
                } else {
                    list = (List<Category>) QueryUtil.list(q, getDialect(),
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
     * Removes all the categories where locale = &#63; from the database.
     *
     * @param locale the locale
     * @throws SystemException if a system exception occurred
     */
    public void removeByLocale(String locale) throws SystemException {
        for (Category category : findByLocale(locale)) {
            remove(category);
        }
    }

    /**
     * Removes all the categories from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    public void removeAll() throws SystemException {
        for (Category category : findAll()) {
            remove(category);
        }
    }

    /**
     * Returns the number of categories where locale = &#63;.
     *
     * @param locale the locale
     * @return the number of matching categories
     * @throws SystemException if a system exception occurred
     */
    public int countByLocale(String locale) throws SystemException {
        Object[] finderArgs = new Object[] { locale };

        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_LOCALE,
                finderArgs, this);

        if (count == null) {
            StringBundler query = new StringBundler(2);

            query.append(_SQL_COUNT_CATEGORY_WHERE);

            if (locale == null) {
                query.append(_FINDER_COLUMN_LOCALE_LOCALE_1);
            } else {
                if (locale.equals(StringPool.BLANK)) {
                    query.append(_FINDER_COLUMN_LOCALE_LOCALE_3);
                } else {
                    query.append(_FINDER_COLUMN_LOCALE_LOCALE_2);
                }
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                if (locale != null) {
                    qPos.add(locale);
                }

                count = (Long) q.uniqueResult();
            } catch (Exception e) {
                throw processException(e);
            } finally {
                if (count == null) {
                    count = Long.valueOf(0);
                }

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_LOCALE,
                    finderArgs, count);

                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Returns the number of categories.
     *
     * @return the number of categories
     * @throws SystemException if a system exception occurred
     */
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_CATEGORY);

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
     * Initializes the category persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.wcs.newsletter.model.Category")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Category>> listenersList = new ArrayList<ModelListener<Category>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Category>) InstanceFactory.newInstance(
                            listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(CategoryImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
