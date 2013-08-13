package com.wcs.newsletter.model;

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
