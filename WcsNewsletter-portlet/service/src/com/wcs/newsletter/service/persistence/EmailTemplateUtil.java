package com.wcs.newsletter.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.wcs.newsletter.model.EmailTemplate;

import java.util.List;

/**
 * The persistence utility for the email template service. This utility wraps {@link EmailTemplatePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplatePersistence
 * @see EmailTemplatePersistenceImpl
 * @generated
 */
public class EmailTemplateUtil {
    private static EmailTemplatePersistence _persistence;

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
    public static void clearCache(EmailTemplate emailTemplate) {
        getPersistence().clearCache(emailTemplate);
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
    public static List<EmailTemplate> findWithDynamicQuery(
        DynamicQuery dynamicQuery) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<EmailTemplate> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<EmailTemplate> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
     */
    public static EmailTemplate update(EmailTemplate emailTemplate,
        boolean merge) throws SystemException {
        return getPersistence().update(emailTemplate, merge);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
     */
    public static EmailTemplate update(EmailTemplate emailTemplate,
        boolean merge, ServiceContext serviceContext) throws SystemException {
        return getPersistence().update(emailTemplate, merge, serviceContext);
    }

    /**
    * Caches the email template in the entity cache if it is enabled.
    *
    * @param emailTemplate the email template
    */
    public static void cacheResult(
        com.wcs.newsletter.model.EmailTemplate emailTemplate) {
        getPersistence().cacheResult(emailTemplate);
    }

    /**
    * Caches the email templates in the entity cache if it is enabled.
    *
    * @param emailTemplates the email templates
    */
    public static void cacheResult(
        java.util.List<com.wcs.newsletter.model.EmailTemplate> emailTemplates) {
        getPersistence().cacheResult(emailTemplates);
    }

    /**
    * Creates a new email template with the primary key. Does not add the email template to the database.
    *
    * @param emailTemplateId the primary key for the new email template
    * @return the new email template
    */
    public static com.wcs.newsletter.model.EmailTemplate create(
        long emailTemplateId) {
        return getPersistence().create(emailTemplateId);
    }

    /**
    * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template that was removed
    * @throws com.wcs.newsletter.NoSuchEmailTemplateException if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate remove(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchEmailTemplateException {
        return getPersistence().remove(emailTemplateId);
    }

    public static com.wcs.newsletter.model.EmailTemplate updateImpl(
        com.wcs.newsletter.model.EmailTemplate emailTemplate, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(emailTemplate, merge);
    }

    /**
    * Returns the email template with the primary key or throws a {@link com.wcs.newsletter.NoSuchEmailTemplateException} if it could not be found.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template
    * @throws com.wcs.newsletter.NoSuchEmailTemplateException if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate findByPrimaryKey(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchEmailTemplateException {
        return getPersistence().findByPrimaryKey(emailTemplateId);
    }

    /**
    * Returns the email template with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template, or <code>null</code> if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.EmailTemplate fetchByPrimaryKey(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(emailTemplateId);
    }

    /**
    * Returns all the email templates.
    *
    * @return the email templates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.EmailTemplate> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
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
    public static java.util.List<com.wcs.newsletter.model.EmailTemplate> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the email templates.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of email templates
    * @param end the upper bound of the range of email templates (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of email templates
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.EmailTemplate> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the email templates from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of email templates.
    *
    * @return the number of email templates
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static EmailTemplatePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (EmailTemplatePersistence) PortletBeanLocatorUtil.locate(com.wcs.newsletter.service.ClpSerializer.getServletContextName(),
                    EmailTemplatePersistence.class.getName());

            ReferenceRegistry.registerReference(EmailTemplateUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated
     */
    public void setPersistence(EmailTemplatePersistence persistence) {
    }
}
