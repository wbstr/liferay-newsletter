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
 * This class is a wrapper for {@link SubscriptionCategoryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       SubscriptionCategoryLocalService
 * @generated
 */
public class SubscriptionCategoryLocalServiceWrapper
    implements SubscriptionCategoryLocalService,
        ServiceWrapper<SubscriptionCategoryLocalService> {
    private SubscriptionCategoryLocalService _subscriptionCategoryLocalService;

    public SubscriptionCategoryLocalServiceWrapper(
        SubscriptionCategoryLocalService subscriptionCategoryLocalService) {
        _subscriptionCategoryLocalService = subscriptionCategoryLocalService;
    }

    /**
    * Adds the subscription category to the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @return the subscription category that was added
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory addSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.addSubscriptionCategory(subscriptionCategory);
    }

    /**
    * Creates a new subscription category with the primary key. Does not add the subscription category to the database.
    *
    * @param subscriptionCategoryPK the primary key for the new subscription category
    * @return the new subscription category
    */
    public com.wcs.newsletter.model.SubscriptionCategory createSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK) {
        return _subscriptionCategoryLocalService.createSubscriptionCategory(subscriptionCategoryPK);
    }

    /**
    * Deletes the subscription category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category that was removed
    * @throws PortalException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory deleteSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.deleteSubscriptionCategory(subscriptionCategoryPK);
    }

    /**
    * Deletes the subscription category from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @return the subscription category that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory deleteSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.deleteSubscriptionCategory(subscriptionCategory);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _subscriptionCategoryLocalService.dynamicQuery();
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
        return _subscriptionCategoryLocalService.dynamicQuery(dynamicQuery);
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
        return _subscriptionCategoryLocalService.dynamicQuery(dynamicQuery,
            start, end);
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
        return _subscriptionCategoryLocalService.dynamicQuery(dynamicQuery,
            start, end, orderByComparator);
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
        return _subscriptionCategoryLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.wcs.newsletter.model.SubscriptionCategory fetchSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.fetchSubscriptionCategory(subscriptionCategoryPK);
    }

    /**
    * Returns the subscription category with the primary key.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category
    * @throws PortalException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory getSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.getSubscriptionCategory(subscriptionCategoryPK);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> getSubscriptionCategories(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.getSubscriptionCategories(start,
            end);
    }

    /**
    * Returns the number of subscription categories.
    *
    * @return the number of subscription categories
    * @throws SystemException if a system exception occurred
    */
    public int getSubscriptionCategoriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.getSubscriptionCategoriesCount();
    }

    /**
    * Updates the subscription category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @return the subscription category that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory updateSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.updateSubscriptionCategory(subscriptionCategory);
    }

    /**
    * Updates the subscription category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @param merge whether to merge the subscription category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the subscription category that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.SubscriptionCategory updateSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.updateSubscriptionCategory(subscriptionCategory,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _subscriptionCategoryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _subscriptionCategoryLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _subscriptionCategoryLocalService.invokeMethod(name,
            parameterTypes, arguments);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.findBySubscriptionId(subscriptionId);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.findByConfirmationKey(confirmationKey);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.findByCancellationKey(cancellationKey);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.findByStatus(status);
    }

    public java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _subscriptionCategoryLocalService.findByCategoryId(categoryId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public SubscriptionCategoryLocalService getWrappedSubscriptionCategoryLocalService() {
        return _subscriptionCategoryLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedSubscriptionCategoryLocalService(
        SubscriptionCategoryLocalService subscriptionCategoryLocalService) {
        _subscriptionCategoryLocalService = subscriptionCategoryLocalService;
    }

    public SubscriptionCategoryLocalService getWrappedService() {
        return _subscriptionCategoryLocalService;
    }

    public void setWrappedService(
        SubscriptionCategoryLocalService subscriptionCategoryLocalService) {
        _subscriptionCategoryLocalService = subscriptionCategoryLocalService;
    }
}
