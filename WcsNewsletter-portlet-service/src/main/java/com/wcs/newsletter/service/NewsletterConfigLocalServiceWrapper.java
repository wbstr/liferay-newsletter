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
 * This class is a wrapper for {@link NewsletterConfigLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       NewsletterConfigLocalService
 * @generated
 */
public class NewsletterConfigLocalServiceWrapper
    implements NewsletterConfigLocalService,
        ServiceWrapper<NewsletterConfigLocalService> {
    private NewsletterConfigLocalService _newsletterConfigLocalService;

    public NewsletterConfigLocalServiceWrapper(
        NewsletterConfigLocalService newsletterConfigLocalService) {
        _newsletterConfigLocalService = newsletterConfigLocalService;
    }

    /**
    * Adds the newsletter config to the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterConfig the newsletter config
    * @return the newsletter config that was added
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig addNewsletterConfig(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.addNewsletterConfig(newsletterConfig);
    }

    /**
    * Creates a new newsletter config with the primary key. Does not add the newsletter config to the database.
    *
    * @param configId the primary key for the new newsletter config
    * @return the new newsletter config
    */
    public com.wcs.newsletter.model.NewsletterConfig createNewsletterConfig(
        long configId) {
        return _newsletterConfigLocalService.createNewsletterConfig(configId);
    }

    /**
    * Deletes the newsletter config with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config that was removed
    * @throws PortalException if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig deleteNewsletterConfig(
        long configId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.deleteNewsletterConfig(configId);
    }

    /**
    * Deletes the newsletter config from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterConfig the newsletter config
    * @return the newsletter config that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig deleteNewsletterConfig(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.deleteNewsletterConfig(newsletterConfig);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _newsletterConfigLocalService.dynamicQuery();
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
        return _newsletterConfigLocalService.dynamicQuery(dynamicQuery);
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
        return _newsletterConfigLocalService.dynamicQuery(dynamicQuery, start,
            end);
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
        return _newsletterConfigLocalService.dynamicQuery(dynamicQuery, start,
            end, orderByComparator);
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
        return _newsletterConfigLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.wcs.newsletter.model.NewsletterConfig fetchNewsletterConfig(
        long configId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.fetchNewsletterConfig(configId);
    }

    /**
    * Returns the newsletter config with the primary key.
    *
    * @param configId the primary key of the newsletter config
    * @return the newsletter config
    * @throws PortalException if a newsletter config with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig getNewsletterConfig(
        long configId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.getNewsletterConfig(configId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the newsletter configs.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of newsletter configs
    * @param end the upper bound of the range of newsletter configs (not inclusive)
    * @return the range of newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> getNewsletterConfigs(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.getNewsletterConfigs(start, end);
    }

    /**
    * Returns the number of newsletter configs.
    *
    * @return the number of newsletter configs
    * @throws SystemException if a system exception occurred
    */
    public int getNewsletterConfigsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.getNewsletterConfigsCount();
    }

    /**
    * Updates the newsletter config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param newsletterConfig the newsletter config
    * @return the newsletter config that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig updateNewsletterConfig(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.updateNewsletterConfig(newsletterConfig);
    }

    /**
    * Updates the newsletter config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param newsletterConfig the newsletter config
    * @param merge whether to merge the newsletter config with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the newsletter config that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.NewsletterConfig updateNewsletterConfig(
        com.wcs.newsletter.model.NewsletterConfig newsletterConfig,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.updateNewsletterConfig(newsletterConfig,
            merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _newsletterConfigLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _newsletterConfigLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _newsletterConfigLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public java.util.List<com.wcs.newsletter.model.NewsletterConfig> findByConfigKey(
        java.lang.String configKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterConfigLocalService.findByConfigKey(configKey);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public NewsletterConfigLocalService getWrappedNewsletterConfigLocalService() {
        return _newsletterConfigLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedNewsletterConfigLocalService(
        NewsletterConfigLocalService newsletterConfigLocalService) {
        _newsletterConfigLocalService = newsletterConfigLocalService;
    }

    public NewsletterConfigLocalService getWrappedService() {
        return _newsletterConfigLocalService;
    }

    public void setWrappedService(
        NewsletterConfigLocalService newsletterConfigLocalService) {
        _newsletterConfigLocalService = newsletterConfigLocalService;
    }
}
