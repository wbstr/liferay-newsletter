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
 * The extended model interface for the Subscription service. Represents a row in the &quot;WcsNewsletter_Subscription&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionModel
 * @see com.wcs.newsletter.model.impl.SubscriptionImpl
 * @see com.wcs.newsletter.model.impl.SubscriptionModelImpl
 * @generated
 */
public interface Subscription extends SubscriptionModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.wcs.newsletter.model.impl.SubscriptionImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public boolean hasUser();

    public com.liferay.portal.model.User getUser();

    public void setUser(com.liferay.portal.model.User user);

    public java.lang.String getUserName();

    public java.lang.String getEmailString();
}
