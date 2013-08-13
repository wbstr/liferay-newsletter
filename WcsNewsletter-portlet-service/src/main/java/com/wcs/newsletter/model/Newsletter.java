package com.wcs.newsletter.model;

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
