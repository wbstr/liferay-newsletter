package com.wcs.newsletter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the subscription local service. This utility wraps {@link com.wcs.newsletter.service.impl.SubscriptionLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionLocalService
 * @see com.wcs.newsletter.service.base.SubscriptionLocalServiceBaseImpl
 * @see com.wcs.newsletter.service.impl.SubscriptionLocalServiceImpl
 * @generated
 */
public class SubscriptionLocalServiceUtil {
    private static SubscriptionLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.wcs.newsletter.service.impl.SubscriptionLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the subscription to the database. Also notifies the appropriate model listeners.
    *
    * @param subscription the subscription
    * @return the subscription that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription addSubscription(
        com.wcs.newsletter.model.Subscription subscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSubscription(subscription);
    }

    /**
    * Creates a new subscription with the primary key. Does not add the subscription to the database.
    *
    * @param subscriptionId the primary key for the new subscription
    * @return the new subscription
    */
    public static com.wcs.newsletter.model.Subscription createSubscription(
        long subscriptionId) {
        return getService().createSubscription(subscriptionId);
    }

    /**
    * Deletes the subscription with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription that was removed
    * @throws PortalException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription deleteSubscription(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSubscription(subscriptionId);
    }

    /**
    * Deletes the subscription from the database. Also notifies the appropriate model listeners.
    *
    * @param subscription the subscription
    * @return the subscription that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription deleteSubscription(
        com.wcs.newsletter.model.Subscription subscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSubscription(subscription);
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

    public static com.wcs.newsletter.model.Subscription fetchSubscription(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSubscription(subscriptionId);
    }

    /**
    * Returns the subscription with the primary key.
    *
    * @param subscriptionId the primary key of the subscription
    * @return the subscription
    * @throws PortalException if a subscription with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription getSubscription(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscription(subscriptionId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the subscriptions.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of subscriptions
    * @param end the upper bound of the range of subscriptions (not inclusive)
    * @return the range of subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Subscription> getSubscriptions(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptions(start, end);
    }

    /**
    * Returns the number of subscriptions.
    *
    * @return the number of subscriptions
    * @throws SystemException if a system exception occurred
    */
    public static int getSubscriptionsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptionsCount();
    }

    /**
    * Updates the subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscription the subscription
    * @return the subscription that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription updateSubscription(
        com.wcs.newsletter.model.Subscription subscription)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSubscription(subscription);
    }

    /**
    * Updates the subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscription the subscription
    * @param merge whether to merge the subscription with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the subscription that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Subscription updateSubscription(
        com.wcs.newsletter.model.Subscription subscription, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSubscription(subscription, merge);
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

    public static java.util.List<com.wcs.newsletter.model.Subscription> findByEmail(
        java.lang.String email)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByEmail(email);
    }

    public static java.util.List<com.wcs.newsletter.model.Subscription> findByUserId(
        long userId) throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByUserId(userId);
    }

    public static java.util.List<com.wcs.newsletter.model.Subscription> getSubscriptions()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptions();
    }

    public static void clearService() {
        _service = null;
    }

    public static SubscriptionLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SubscriptionLocalService.class.getName());

            if (invokableLocalService instanceof SubscriptionLocalService) {
                _service = (SubscriptionLocalService) invokableLocalService;
            } else {
                _service = new SubscriptionLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SubscriptionLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(SubscriptionLocalService service) {
    }
}
