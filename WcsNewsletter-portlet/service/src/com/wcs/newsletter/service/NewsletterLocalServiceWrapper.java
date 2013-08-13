package com.wcs.newsletter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link NewsletterLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       NewsletterLocalService
 * @generated
 */
public class NewsletterLocalServiceWrapper implements NewsletterLocalService,
    ServiceWrapper<NewsletterLocalService> {
    private NewsletterLocalService _newsletterLocalService;

    public NewsletterLocalServiceWrapper(
        NewsletterLocalService newsletterLocalService) {
        _newsletterLocalService = newsletterLocalService;
    }

    /**
    * Adds the newsletter to the database. Also notifies the appropriate model listeners.
    *
    * @param newsletter the newsletter
    * @return the newsletter that was added
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter addNewsletter(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.addNewsletter(newsletter);
    }

    /**
    * Creates a new newsletter with the primary key. Does not add the newsletter to the database.
    *
    * @param newsletterId the primary key for the new newsletter
    * @return the new newsletter
    */
    public com.wcs.newsletter.model.Newsletter createNewsletter(
        long newsletterId) {
        return _newsletterLocalService.createNewsletter(newsletterId);
    }

    /**
    * Deletes the newsletter with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter that was removed
    * @throws PortalException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter deleteNewsletter(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.deleteNewsletter(newsletterId);
    }

    /**
    * Deletes the newsletter from the database. Also notifies the appropriate model listeners.
    *
    * @param newsletter the newsletter
    * @return the newsletter that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter deleteNewsletter(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.deleteNewsletter(newsletter);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _newsletterLocalService.dynamicQuery();
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
        return _newsletterLocalService.dynamicQuery(dynamicQuery);
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
        return _newsletterLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _newsletterLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _newsletterLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.wcs.newsletter.model.Newsletter fetchNewsletter(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.fetchNewsletter(newsletterId);
    }

    /**
    * Returns the newsletter with the primary key.
    *
    * @param newsletterId the primary key of the newsletter
    * @return the newsletter
    * @throws PortalException if a newsletter with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter getNewsletter(long newsletterId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getNewsletter(newsletterId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getPersistedModel(primaryKeyObj);
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
    public java.util.List<com.wcs.newsletter.model.Newsletter> getNewsletters(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getNewsletters(start, end);
    }

    /**
    * Returns the number of newsletters.
    *
    * @return the number of newsletters
    * @throws SystemException if a system exception occurred
    */
    public int getNewslettersCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getNewslettersCount();
    }

    /**
    * Updates the newsletter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param newsletter the newsletter
    * @return the newsletter that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter updateNewsletter(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.updateNewsletter(newsletter);
    }

    /**
    * Updates the newsletter in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param newsletter the newsletter
    * @param merge whether to merge the newsletter with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the newsletter that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Newsletter updateNewsletter(
        com.wcs.newsletter.model.Newsletter newsletter, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.updateNewsletter(newsletter, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _newsletterLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _newsletterLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _newsletterLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public java.util.List<com.wcs.newsletter.model.Newsletter> findByParentId(
        long parentId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.findByParentId(parentId);
    }

    public java.util.List<com.wcs.newsletter.model.Category> getCategories(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getCategories(newsletter);
    }

    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getRecipients(newsletter);
    }

    public java.util.List<com.wcs.newsletter.model.Label> getLabels(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.getLabels(newsletter);
    }

    public com.wcs.newsletter.model.Newsletter save(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.save(newsletter);
    }

    public com.wcs.newsletter.model.Newsletter saveChild(
        com.wcs.newsletter.model.Newsletter newsletter)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _newsletterLocalService.saveChild(newsletter);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public NewsletterLocalService getWrappedNewsletterLocalService() {
        return _newsletterLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedNewsletterLocalService(
        NewsletterLocalService newsletterLocalService) {
        _newsletterLocalService = newsletterLocalService;
    }

    public NewsletterLocalService getWrappedService() {
        return _newsletterLocalService;
    }

    public void setWrappedService(NewsletterLocalService newsletterLocalService) {
        _newsletterLocalService = newsletterLocalService;
    }
}
