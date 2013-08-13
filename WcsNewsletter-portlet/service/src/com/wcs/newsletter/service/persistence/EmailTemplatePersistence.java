package com.wcs.newsletter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.wcs.newsletter.model.EmailTemplate;

/**
 * The persistence interface for the email template service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EmailTemplatePersistenceImpl
 * @see EmailTemplateUtil
 * @generated
 */
public interface EmailTemplatePersistence extends BasePersistence<EmailTemplate> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EmailTemplateUtil} to access the email template persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the email template in the entity cache if it is enabled.
    *
    * @param emailTemplate the email template
    */
    public void cacheResult(
        com.wcs.newsletter.model.EmailTemplate emailTemplate);

    /**
    * Caches the email templates in the entity cache if it is enabled.
    *
    * @param emailTemplates the email templates
    */
    public void cacheResult(
        java.util.List<com.wcs.newsletter.model.EmailTemplate> emailTemplates);

    /**
    * Creates a new email template with the primary key. Does not add the email template to the database.
    *
    * @param emailTemplateId the primary key for the new email template
    * @return the new email template
    */
    public com.wcs.newsletter.model.EmailTemplate create(long emailTemplateId);

    /**
    * Removes the email template with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template that was removed
    * @throws com.wcs.newsletter.NoSuchEmailTemplateException if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.EmailTemplate remove(long emailTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchEmailTemplateException;

    public com.wcs.newsletter.model.EmailTemplate updateImpl(
        com.wcs.newsletter.model.EmailTemplate emailTemplate, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the email template with the primary key or throws a {@link com.wcs.newsletter.NoSuchEmailTemplateException} if it could not be found.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template
    * @throws com.wcs.newsletter.NoSuchEmailTemplateException if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.EmailTemplate findByPrimaryKey(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.wcs.newsletter.NoSuchEmailTemplateException;

    /**
    * Returns the email template with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param emailTemplateId the primary key of the email template
    * @return the email template, or <code>null</code> if a email template with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.EmailTemplate fetchByPrimaryKey(
        long emailTemplateId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the email templates.
    *
    * @return the email templates
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.EmailTemplate> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.EmailTemplate> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.wcs.newsletter.model.EmailTemplate> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the email templates from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of email templates.
    *
    * @return the number of email templates
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
