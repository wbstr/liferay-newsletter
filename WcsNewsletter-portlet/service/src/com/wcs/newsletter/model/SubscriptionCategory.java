package com.wcs.newsletter.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the SubscriptionCategory service. Represents a row in the &quot;WcsNewsletter_Subscription_Category&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionCategoryModel
 * @see com.wcs.newsletter.model.impl.SubscriptionCategoryImpl
 * @see com.wcs.newsletter.model.impl.SubscriptionCategoryModelImpl
 * @generated
 */
public interface SubscriptionCategory extends SubscriptionCategoryModel,
    PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.wcs.newsletter.model.impl.SubscriptionCategoryImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public boolean isConfirmed();

    public com.wcs.newsletter.model.Subscription getSubscription()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;

    public com.wcs.newsletter.model.Category getCategory()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
