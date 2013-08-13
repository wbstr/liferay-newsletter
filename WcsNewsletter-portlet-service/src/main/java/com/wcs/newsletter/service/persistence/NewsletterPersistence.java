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

import com.wcs.newsletter.model.Newsletter;

/**
 * The persistence interface for the newsletter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterPersistenceImpl
 * @see NewsletterUtil
 * @generated
 */
public interface NewsletterPersistence extends BasePersistence<Newsletter> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link NewsletterUtil} to access the newsletter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the newsletter in the entity cache if it is enabled.
    *
    * @param newsletter the newsletter
    */
    public void cacheResult(com.wcs.newsletter.model.Newsletter newsletter);

    /**
    * Caches the newsletters in the entity cache if it is enabled.
    *
    * @param newsletters the newsletters
    */
    public void cacheResult(
        java.util.List<com.wcs.newsletter.model.Newsletter> newsletters);

    /**
    * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
    *
    * @param newsletterId the primary key for the new newsletter
    * @return the new newsletter
    */
    public com.wcs.newsletter.model.Newsletter create(long newsletterId);

    /**
    * Removes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter that was removed
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter remove(long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException;

    public com.wcs.newsletter.model.Newsletter updateImpl(
        com.wcs.newsletter.model.Newsletter newsletter, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the newsletter with the primary key or throws a {@link com.wcs.newsletter.NoSuchNewsletterException} if it could not be found.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter findByPrimaryKey(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException;

    /**
    * Returns the newsletter with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter, or <code>null</code> if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter fetchByPrimaryKey(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the newsletters where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Newsletter> findByParentId(
        long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Newsletter> findByParentId(
        long parentId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Newsletter> findByParentId(
        long parentId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter findByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException;

    /**
    * Returns the first newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching newsletter, or <code>null</code> if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter fetchByParentId_First(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter
    * @throws com.wcs.newsletter.NoSuchNewsletterException if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter findByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException;

    /**
    * Returns the last newsletter in the ordered set where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching newsletter, or <code>null</code> if a matching newsletter could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter fetchByParentId_Last(
        long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.wcs.newsletter.model.Newsletter[] findByParentId_PrevAndNext(
        long newsletterId, long parentId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchNewsletterException;

    /**
    * Returns all the newsletters.
    *
    * @return the newsletters
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Newsletter> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Newsletter> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Newsletter> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newsletters where parentId = &#63; from the database.
    *
    * @param parentId the parent ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the newsletters from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newsletters where parentId = &#63;.
    *
    * @param parentId the parent ID
    * @return the number of matching newsletters
    * @throws SystemException if a system exception occurred
    */
    public int countByParentId(long parentId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of newsletters.
    *
    * @return the number of newsletters
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the categories associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the categories associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Category> getCategories(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Category> getCategories(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Category> getCategories(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of categories associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the number of categories associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public int getCategoriesSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the category is associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPK the primary key of the category
    * @return <code>true</code> if the category is associated with the newsletter; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the newsletter has any categories associated with it.
    *
    * @param pk the primary key of the newsletter to check for associations with categories
    * @return <code>true</code> if the newsletter has any categories associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public void addCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public void addCategory(long pk, com.wcs.newsletter.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public void addCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public void addCategories(long pk,
        java.util.List<com.wcs.newsletter.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the newsletter and its categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter to clear the associated categories from
    * @throws SystemException if a system exception occurred
    */
    public void clearCategories(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPK the primary key of the category
    * @throws SystemException if a system exception occurred
    */
    public void removeCategory(long pk, long categoryPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the category. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param category the category
    * @throws SystemException if a system exception occurred
    */
    public void removeCategory(long pk,
        com.wcs.newsletter.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPKs the primary keys of the categories
    * @throws SystemException if a system exception occurred
    */
    public void removeCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the categories. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categories the categories
    * @throws SystemException if a system exception occurred
    */
    public void removeCategories(long pk,
        java.util.List<com.wcs.newsletter.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the categories associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categoryPKs the primary keys of the categories to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public void setCategories(long pk, long[] categoryPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the categories associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param categories the categories to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public void setCategories(long pk,
        java.util.List<com.wcs.newsletter.model.Category> categories)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the labels associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the labels associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Label> getLabels(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Label> getLabels(long pk,
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Label> getLabels(long pk,
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of labels associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the number of labels associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public int getLabelsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the label is associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @param labelPK the primary key of the label
    * @return <code>true</code> if the label is associated with the newsletter; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsLabel(long pk, long labelPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the newsletter has any labels associated with it.
    *
    * @param pk the primary key of the newsletter to check for associations with labels
    * @return <code>true</code> if the newsletter has any labels associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsLabels(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPK the primary key of the label
    * @throws SystemException if a system exception occurred
    */
    public void addLabel(long pk, long labelPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param label the label
    * @throws SystemException if a system exception occurred
    */
    public void addLabel(long pk, com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPKs the primary keys of the labels
    * @throws SystemException if a system exception occurred
    */
    public void addLabels(long pk, long[] labelPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Adds an association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labels the labels
    * @throws SystemException if a system exception occurred
    */
    public void addLabels(long pk,
        java.util.List<com.wcs.newsletter.model.Label> labels)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Clears all associations between the newsletter and its labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter to clear the associated labels from
    * @throws SystemException if a system exception occurred
    */
    public void clearLabels(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPK the primary key of the label
    * @throws SystemException if a system exception occurred
    */
    public void removeLabel(long pk, long labelPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the label. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param label the label
    * @throws SystemException if a system exception occurred
    */
    public void removeLabel(long pk, com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPKs the primary keys of the labels
    * @throws SystemException if a system exception occurred
    */
    public void removeLabels(long pk, long[] labelPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the association between the newsletter and the labels. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labels the labels
    * @throws SystemException if a system exception occurred
    */
    public void removeLabels(long pk,
        java.util.List<com.wcs.newsletter.model.Label> labels)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the labels associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labelPKs the primary keys of the labels to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public void setLabels(long pk, long[] labelPKs)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Sets the labels associated with the newsletter, removing and adding associations as necessary. Also notifies the appropriate model listeners and clears the mapping table finder cache.
    *
    * @param pk the primary key of the newsletter
    * @param labels the labels to be associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public void setLabels(long pk,
        java.util.List<com.wcs.newsletter.model.Label> labels)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the recipients associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the recipients associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        long pk) throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        long pk, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        long pk, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of recipients associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @return the number of recipients associated with the newsletter
    * @throws SystemException if a system exception occurred
    */
    public int getRecipientsSize(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the recipient is associated with the newsletter.
    *
    * @param pk the primary key of the newsletter
    * @param recipientPK the primary key of the recipient
    * @return <code>true</code> if the recipient is associated with the newsletter; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRecipient(long pk, long recipientPK)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns <code>true</code> if the newsletter has any recipients associated with it.
    *
    * @param pk the primary key of the newsletter to check for associations with recipients
    * @return <code>true</code> if the newsletter has any recipients associated with it; <code>false</code> otherwise
    * @throws SystemException if a system exception occurred
    */
    public boolean containsRecipients(long pk)
        throws com.liferay.portal.kernel.exception.SystemException;
}
