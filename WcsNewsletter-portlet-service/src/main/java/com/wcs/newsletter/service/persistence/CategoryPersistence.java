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

import com.liferay.portal.service.persistence.BasePersistence;

import com.wcs.newsletter.model.Category;

/**
 * The persistence interface for the category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CategoryPersistenceImpl
 * @see CategoryUtil
 * @generated
 */
public interface CategoryPersistence extends BasePersistence<Category> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link CategoryUtil} to access the category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the category in the entity cache if it is enabled.
    *
    * @param category the category
    */
    public void cacheResult(com.wcs.newsletter.model.Category category);

    /**
    * Caches the categories in the entity cache if it is enabled.
    *
    * @param categories the categories
    */
    public void cacheResult(
        java.util.List<com.wcs.newsletter.model.Category> categories);

    /**
    * Creates a new category with the primary key. Does not add the category to the database.
    *
    * @param categoryId the primary key for the new category
    * @return the new category
    */
    public com.wcs.newsletter.model.Category create(long categoryId);

    /**
    * Removes the category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param categoryId the primary key of the category
    * @return the category that was removed
    * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category remove(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException;

    public com.wcs.newsletter.model.Category updateImpl(
        com.wcs.newsletter.model.Category category, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the category with the primary key or throws a {@link com.wcs.newsletter.NoSuchCategoryException} if it could not be found.
    *
    * @param categoryId the primary key of the category
    * @return the category
    * @throws com.wcs.newsletter.NoSuchCategoryException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category findByPrimaryKey(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException;

    /**
    * Returns the category with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param categoryId the primary key of the category
    * @return the category, or <code>null</code> if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category fetchByPrimaryKey(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the categories where locale = &#63;.
    *
    * @param locale the locale
    * @return the matching categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category
    * @throws com.wcs.newsletter.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category findByLocale_First(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException;

    /**
    * Returns the first category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category fetchByLocale_First(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category
    * @throws com.wcs.newsletter.NoSuchCategoryException if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category findByLocale_Last(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException;

    /**
    * Returns the last category in the ordered set where locale = &#63;.
    *
    * @param locale the locale
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching category, or <code>null</code> if a matching category could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category fetchByLocale_Last(
        java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.Category[] findByLocale_PrevAndNext(
        long categoryId, java.lang.String locale,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchCategoryException;

    /**
    * Returns all the categories.
    *
    * @return the categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Category> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Category> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Category> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the categories where locale = &#63; from the database.
    *
    * @param locale the locale
    * @throws SystemException if a system exception occurred
    */
    public void removeByLocale(java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the categories from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories where locale = &#63;.
    *
    * @param locale the locale
    * @return the number of matching categories
    * @throws SystemException if a system exception occurred
    */
    public int countByLocale(java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories.
    *
    * @return the number of categories
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
