package com.wcs.newsletter.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Newsletter service. Represents a row in the &quot;WcsNewsletter_Newsletter&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see NewsletterModel
 * @see com.wcs.newsletter.model.impl.NewsletterImpl
 * @see com.wcs.newsletter.model.impl.NewsletterModelImpl
 * @generated
 */
public interface Newsletter extends NewsletterModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.wcs.newsletter.model.impl.NewsletterImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public java.util.List<com.wcs.newsletter.model.Category> getCategories()
        throws com.liferay.portal.kernel.exception.SystemException;

    public void setCategories(
        java.util.List<com.wcs.newsletter.model.Category> categories);

    public java.util.List<com.wcs.newsletter.model.Recipient> getRecipients()
        throws com.liferay.portal.kernel.exception.SystemException;

    public void setRecipients(
        java.util.List<com.wcs.newsletter.model.Recipient> recipients);

    public java.util.List<com.wcs.newsletter.model.Label> getLabels()
        throws com.liferay.portal.kernel.exception.SystemException;

    public void setLabels(java.util.List<com.wcs.newsletter.model.Label> labels);

    public com.liferay.portlet.journal.model.JournalArticle getJournalArticle(
        com.liferay.portal.theme.ThemeDisplay themeDisplay)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.wcs.newsletter.model.Newsletter getChild()
        throws com.liferay.portal.kernel.exception.SystemException;

    public boolean isRoot();
}
