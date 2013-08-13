package com.wcs.newsletter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the email template local service. This utility wraps {@link com.wcs.newsletter.service.impl.EmailTemplateLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplateLocalService
 * @see com.wcs.newsletter.service.base.EmailTemplateLocalServiceBaseImpl
 * @see com.wcs.newsletter.service.impl.EmailTemplateLocalServiceImpl
 * @generated
 */
public class EmailTemplateLocalServiceUtil {
    private static EmailTemplateLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.wcs.newsletter.service.impl.EmailTemplateLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the email template to the database. Also notifies the appropriate model listeners.
    *
    * @param emailTemplate the email template
    * @return the email template that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate addEmailTemplate(
        com.wcs.newsletter.model.EmailTemplate emailTemplate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addEmailTemplate(emailTemplate);
    }

    /**
    * Creates a new email template with the primary key. Does not add the email template to the database.
    *
    * @param emailTemplateId the primary key for the new email template
    * @return the new email template
    */
    public static com.wcs.newsletter.model.EmailTemplate createEmailTemplate(
        long emailTemplateId) {
        return getService().createEmailTemplate(emailTemplateId);
    }

    /**
    * Deletes the email template with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template that was removed
    * @throws PortalException if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate deleteEmailTemplate(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEmailTemplate(emailTemplateId);
    }

    /**
    * Deletes the email template from the database. Also notifies the appropriate model listeners.
    *
    * @param emailTemplate the email template
    * @return the email template that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate deleteEmailTemplate(
        com.wcs.newsletter.model.EmailTemplate emailTemplate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteEmailTemplate(emailTemplate);
    }

    public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return getService().dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQuery(dynamicQuery, start, end);
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
    public static java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public static long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().dynamicQueryCount(dynamicQuery);
    }

    public static com.wcs.newsletter.model.EmailTemplate fetchEmailTemplate(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchEmailTemplate(emailTemplateId);
    }

    /**
    * Returns the email template with the primary key.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template
    * @throws PortalException if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate getEmailTemplate(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getEmailTemplate(emailTemplateId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the email templates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of email templates
    * @param end the upper bound of the range of email templates (not inclusive)
    * @return the range of email templates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.EmailTemplate> getEmailTemplates(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEmailTemplates(start, end);
    }

    /**
    * Returns the number of email templates.
    *
    * @return the number of email templates
    * @throws SystemException if a system exception occurred
    */
    public static int getEmailTemplatesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getEmailTemplatesCount();
    }

    /**
    * Updates the email template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param emailTemplate the email template
    * @return the email template that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate updateEmailTemplate(
        com.wcs.newsletter.model.EmailTemplate emailTemplate)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateEmailTemplate(emailTemplate);
    }

    /**
    * Updates the email template in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param emailTemplate the email template
    * @param merge whether to merge the email template with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the email template that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate updateEmailTemplate(
        com.wcs.newsletter.model.EmailTemplate emailTemplate, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateEmailTemplate(emailTemplate, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public static java.lang.String getBeanIdentifier() {
        return getService().getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public static void setBeanIdentifier(java.lang.String beanIdentifier) {
        getService().setBeanIdentifier(beanIdentifier);
    }

    public static java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return getService().invokeMethod(name, parameterTypes, arguments);
    }

    public static void clearService() {
        _service = null;
    }

    public static EmailTemplateLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    EmailTemplateLocalService.class.getName());

            if (invokableLocalService instanceof EmailTemplateLocalService) {
                _service = (EmailTemplateLocalService) invokableLocalService;
            } else {
                _service = new EmailTemplateLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(EmailTemplateLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(EmailTemplateLocalService service) {
    }
}
