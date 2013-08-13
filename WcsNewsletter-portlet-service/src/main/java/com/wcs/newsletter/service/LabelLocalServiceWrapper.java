package com.wcs.newsletter.service;

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

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LabelLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       LabelLocalService
 * @generated
 */
public class LabelLocalServiceWrapper implements LabelLocalService,
    ServiceWrapper<LabelLocalService> {
    private LabelLocalService _labelLocalService;

    public LabelLocalServiceWrapper(LabelLocalService labelLocalService) {
        _labelLocalService = labelLocalService;
    }

    /**
    * Adds the label to the database. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @return the label that was added
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Label addLabel(
        com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.addLabel(label);
    }

    /**
    * Creates a new label with the primary key. Does not add the label to the database.
    *
    * @param labelId the primary key for the new label
    * @return the new label
    */
    public com.wcs.newsletter.model.Label createLabel(long labelId) {
        return _labelLocalService.createLabel(labelId);
    }

    /**
    * Deletes the label with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param labelId the primary key of the label
    * @return the label that was removed
    * @throws PortalException if a label with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Label deleteLabel(long labelId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.deleteLabel(labelId);
    }

    /**
    * Deletes the label from the database. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @return the label that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Label deleteLabel(
        com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.deleteLabel(label);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _labelLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.dynamicQuery(dynamicQuery);
    }

    /**
    * Performs a dynamic query on the database and returns a range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @return the range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.dynamicQuery(dynamicQuery, start, end);
    }

    /**
    * Performs a dynamic query on the database and returns an ordered range of the matching rows.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param dynamicQuery the dynamic query
    * @param start the lower bound of the range of model instances
    * @param end the upper bound of the range of model instances (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.wcs.newsletter.model.Label fetchLabel(long labelId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.fetchLabel(labelId);
    }

    /**
    * Returns the label with the primary key.
    *
    * @param labelId the primary key of the label
    * @return the label
    * @throws PortalException if a label with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Label getLabel(long labelId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.getLabel(labelId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.wcs.newsletter.model.Label> getLabels(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.getLabels(start, end);
    }

    /**
    * Returns the number of labels.
    *
    * @return the number of labels
    * @throws SystemException if a system exception occurred
    */
    public int getLabelsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.getLabelsCount();
    }

    /**
    * Updates the label in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @return the label that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Label updateLabel(
        com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.updateLabel(label);
    }

    /**
    * Updates the label in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @param merge whether to merge the label with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the label that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Label updateLabel(
        com.wcs.newsletter.model.Label label, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.updateLabel(label, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _labelLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _labelLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _labelLocalService.invokeMethod(name, parameterTypes, arguments);
    }

    public com.wcs.newsletter.model.Label findByTagId(long tagId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _labelLocalService.findByTagId(tagId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public LabelLocalService getWrappedLabelLocalService() {
        return _labelLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedLabelLocalService(LabelLocalService labelLocalService) {
        _labelLocalService = labelLocalService;
    }

    public LabelLocalService getWrappedService() {
        return _labelLocalService;
    }

    public void setWrappedService(LabelLocalService labelLocalService) {
        _labelLocalService = labelLocalService;
    }
}
