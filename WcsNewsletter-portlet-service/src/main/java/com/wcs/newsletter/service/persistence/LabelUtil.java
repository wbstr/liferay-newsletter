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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.Label;

import java.util.List;

/**
 * The persistence utility for the label service. This utility wraps {@link LabelPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LabelPersistence
 * @see LabelPersistenceImpl
 * @generated
 */
public class LabelUtil {
    private static LabelPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Label label) {
        getPersistence().clearCache(label);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Label> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Label> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Label> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static Label update(Label label, boolean merge)
        throws SystemException {
        return getPersistence().update(label, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static Label update(Label label, boolean merge,
        ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(label, merge, serviceContext);
    }

    /**
    * Caches the label in the entity cache if it is enabled.
    *
    * @param label the label
    */
    public static void cacheResult(com.wcs.newsletter.model.Label label) {
        getPersistence().cacheResult(label);
    }

    /**
    * Caches the labels in the entity cache if it is enabled.
    *
    * @param labels the labels
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.Label> labels) {
        getPersistence().cacheResult(labels);
    }

    /**
    * Creates a new label with the primary key. Does not add the label to the database.
    *
    * @param labelId the primary key for the new label
    * @return the new label
    */
    public static com.wcs.newsletter.model.Label create(long labelId) {
        return getPersistence().create(labelId);
    }

    /**
    * Removes the label with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param labelId the primary key of the label
    * @return the label that was removed
    * @throws com.wcs.newsletter.NoSuchLabelException if a label with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label remove(long labelId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchLabelException {
        return getPersistence().remove(labelId);
    }

    public static com.wcs.newsletter.model.Label updateImpl(
        com.wcs.newsletter.model.Label label, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(label, merge);
    }

    /**
    * Returns the label with the primary key or throws a {@link com.wcs.newsletter.NoSuchLabelException} if it could not be found.
    *
    * @param labelId the primary key of the label
    * @return the label
    * @throws com.wcs.newsletter.NoSuchLabelException if a label with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label findByPrimaryKey(long labelId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchLabelException {
        return getPersistence().findByPrimaryKey(labelId);
    }

    /**
    * Returns the label with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param labelId the primary key of the label
    * @return the label, or <code>null</code> if a label with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label fetchByPrimaryKey(long labelId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(labelId);
    }

    /**
    * Returns all the labels where tagId = &#63;.
    *
    * @param tagId the tag ID
    * @return the matching labels
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Label> findByTagId(
        long tagId) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTagId(tagId);
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
    public static java.util.List<com.wcs.newsletter.model.Label> findByTagId(
        long tagId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTagId(tagId, start, end);
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
    public static java.util.List<com.wcs.newsletter.model.Label> findByTagId(
        long tagId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByTagId(tagId, start, end, orderByComparator);
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
    public static com.wcs.newsletter.model.Label findByTagId_First(long tagId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchLabelException {
        return getPersistence().findByTagId_First(tagId, orderByComparator);
    }

    /**
    * Returns the first label in the ordered set where tagId = &#63;.
    *
    * @param tagId the tag ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching label, or <code>null</code> if a matching label could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label fetchByTagId_First(
        long tagId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTagId_First(tagId, orderByComparator);
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
    public static com.wcs.newsletter.model.Label findByTagId_Last(long tagId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchLabelException {
        return getPersistence().findByTagId_Last(tagId, orderByComparator);
    }

    /**
    * Returns the last label in the ordered set where tagId = &#63;.
    *
    * @param tagId the tag ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching label, or <code>null</code> if a matching label could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label fetchByTagId_Last(long tagId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByTagId_Last(tagId, orderByComparator);
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
    public static com.wcs.newsletter.model.Label[] findByTagId_PrevAndNext(
        long labelId, long tagId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchLabelException {
        return getPersistence()
                   .findByTagId_PrevAndNext(labelId, tagId, orderByComparator);
    }

    /**
    * Returns all the labels.
    *
    * @return the labels
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Label> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.wcs.newsletter.model.Label> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
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
    public static java.util.List<com.wcs.newsletter.model.Label> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the labels where tagId = &#63; from the database.
    *
    * @param tagId the tag ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByTagId(long tagId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByTagId(tagId);
    }

    /**
    * Removes all the labels from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of labels where tagId = &#63;.
    *
    * @param tagId the tag ID
    * @return the number of matching labels
    * @throws SystemException if a system exception occurred
    */
    public static int countByTagId(long tagId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByTagId(tagId);
    }

    /**
    * Returns the number of labels.
    *
    * @return the number of labels
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static LabelPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (LabelPersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    LabelPersistence.class.getName());

            ReferenceRegistry.registerReference(LabelUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(LabelPersistence persistence) {
    }
}
