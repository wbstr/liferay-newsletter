package com.wcs.newsletter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the subscription category local service. This utility wraps {@link com.wcs.newsletter.service.impl.SubscriptionCategoryLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SubscriptionCategoryLocalService
 * @see com.wcs.newsletter.service.base.SubscriptionCategoryLocalServiceBaseImpl
 * @see com.wcs.newsletter.service.impl.SubscriptionCategoryLocalServiceImpl
 * @generated
 */
public class SubscriptionCategoryLocalServiceUtil {
    private static SubscriptionCategoryLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.wcs.newsletter.service.impl.SubscriptionCategoryLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the subscription category to the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @return the subscription category that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory addSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addSubscriptionCategory(subscriptionCategory);
    }

    /**
    * Creates a new subscription category with the primary key. Does not add the subscription category to the database.
    *
    * @param subscriptionCategoryPK the primary key for the new subscription category
    * @return the new subscription category
    */
    public static com.wcs.newsletter.model.SubscriptionCategory createSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK) {
        return getService().createSubscriptionCategory(subscriptionCategoryPK);
    }

    /**
    * Deletes the subscription category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category that was removed
    * @throws PortalException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory deleteSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSubscriptionCategory(subscriptionCategoryPK);
    }

    /**
    * Deletes the subscription category from the database. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @return the subscription category that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory deleteSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteSubscriptionCategory(subscriptionCategory);
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

    public static com.wcs.newsletter.model.SubscriptionCategory fetchSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchSubscriptionCategory(subscriptionCategoryPK);
    }

    /**
    * Returns the subscription category with the primary key.
    *
    * @param subscriptionCategoryPK the primary key of the subscription category
    * @return the subscription category
    * @throws PortalException if a subscription category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory getSubscriptionCategory(
        com.wcs.newsletter.service.persistence.SubscriptionCategoryPK subscriptionCategoryPK)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptionCategory(subscriptionCategoryPK);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the subscription categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of subscription categories
    * @param end the upper bound of the range of subscription categories (not inclusive)
    * @return the range of subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> getSubscriptionCategories(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptionCategories(start, end);
    }

    /**
    * Returns the number of subscription categories.
    *
    * @return the number of subscription categories
    * @throws SystemException if a system exception occurred
    */
    public static int getSubscriptionCategoriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getSubscriptionCategoriesCount();
    }

    /**
    * Updates the subscription category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @return the subscription category that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory updateSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateSubscriptionCategory(subscriptionCategory);
    }

    /**
    * Updates the subscription category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param subscriptionCategory the subscription category
    * @param merge whether to merge the subscription category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the subscription category that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.SubscriptionCategory updateSubscriptionCategory(
        com.wcs.newsletter.model.SubscriptionCategory subscriptionCategory,
        boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService()
                   .updateSubscriptionCategory(subscriptionCategory, merge);
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

    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findBySubscriptionId(
        long subscriptionId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findBySubscriptionId(subscriptionId);
    }

    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByConfirmationKey(
        java.lang.String confirmationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByConfirmationKey(confirmationKey);
    }

    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCancellationKey(
        java.lang.String cancellationKey)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCancellationKey(cancellationKey);
    }

    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByStatus(
        java.lang.String status)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByStatus(status);
    }

    public static java.util.List<com.wcs.newsletter.model.SubscriptionCategory> findByCategoryId(
        long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByCategoryId(categoryId);
    }

    public static void clearService() {
        _service = null;
    }

    public static SubscriptionCategoryLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    SubscriptionCategoryLocalService.class.getName());

            if (invokableLocalService instanceof SubscriptionCategoryLocalService) {
                _service = (SubscriptionCategoryLocalService) invokableLocalService;
            } else {
                _service = new SubscriptionCategoryLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(SubscriptionCategoryLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(SubscriptionCategoryLocalService service) {
    }
}
