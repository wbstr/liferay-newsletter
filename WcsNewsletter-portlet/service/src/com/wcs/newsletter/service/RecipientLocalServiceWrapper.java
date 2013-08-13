package com.wcs.newsletter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link RecipientLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       RecipientLocalService
 * @generated
 */
public class RecipientLocalServiceWrapper implements RecipientLocalService,
    ServiceWrapper<RecipientLocalService> {
    private RecipientLocalService _recipientLocalService;

    public RecipientLocalServiceWrapper(
        RecipientLocalService recipientLocalService) {
        _recipientLocalService = recipientLocalService;
    }

    /**
    * Adds the recipient to the database. Also notifies the appropriate model listeners.
    *
    * @param recipient the recipient
    * @return the recipient that was added
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient addRecipient(
        com.wcs.newsletter.model.Recipient recipient)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.addRecipient(recipient);
    }

    /**
    * Creates a new recipient with the primary key. Does not add the recipient to the database.
    *
    * @param recipientId the primary key for the new recipient
    * @return the new recipient
    */
    public com.wcs.newsletter.model.Recipient createRecipient(long recipientId) {
        return _recipientLocalService.createRecipient(recipientId);
    }

    /**
    * Deletes the recipient with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient that was removed
    * @throws PortalException if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient deleteRecipient(long recipientId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.deleteRecipient(recipientId);
    }

    /**
    * Deletes the recipient from the database. Also notifies the appropriate model listeners.
    *
    * @param recipient the recipient
    * @return the recipient that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient deleteRecipient(
        com.wcs.newsletter.model.Recipient recipient)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.deleteRecipient(recipient);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _recipientLocalService.dynamicQuery();
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
        return _recipientLocalService.dynamicQuery(dynamicQuery);
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
        return _recipientLocalService.dynamicQuery(dynamicQuery, start, end);
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
        return _recipientLocalService.dynamicQuery(dynamicQuery, start, end,
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
        return _recipientLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.wcs.newsletter.model.Recipient fetchRecipient(long recipientId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.fetchRecipient(recipientId);
    }

    /**
    * Returns the recipient with the primary key.
    *
    * @param recipientId the primary key of the recipient
    * @return the recipient
    * @throws PortalException if a recipient with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient getRecipient(long recipientId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.getRecipient(recipientId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the recipients.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of recipients
    * @param end the upper bound of the range of recipients (not inclusive)
    * @return the range of recipients
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.getRecipients(start, end);
    }

    /**
    * Returns the number of recipients.
    *
    * @return the number of recipients
    * @throws SystemException if a system exception occurred
    */
    public int getRecipientsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.getRecipientsCount();
    }

    /**
    * Updates the recipient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param recipient the recipient
    * @return the recipient that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient updateRecipient(
        com.wcs.newsletter.model.Recipient recipient)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.updateRecipient(recipient);
    }

    /**
    * Updates the recipient in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param recipient the recipient
    * @param merge whether to merge the recipient with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the recipient that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Recipient updateRecipient(
        com.wcs.newsletter.model.Recipient recipient, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.updateRecipient(recipient, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _recipientLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _recipientLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _recipientLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public java.util.List<com.wcs.newsletter.model.Recipient> findByNewsletterId(
        long newsletterId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _recipientLocalService.findByNewsletterId(newsletterId);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public RecipientLocalService getWrappedRecipientLocalService() {
        return _recipientLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedRecipientLocalService(
        RecipientLocalService recipientLocalService) {
        _recipientLocalService = recipientLocalService;
    }

    public RecipientLocalService getWrappedService() {
        return _recipientLocalService;
    }

    public void setWrappedService(RecipientLocalService recipientLocalService) {
        _recipientLocalService = recipientLocalService;
    }
}
