package com.wcs.newsletter.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * The utility for the label local service. This utility wraps {@link com.wcs.newsletter.service.impl.LabelLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LabelLocalService
 * @see com.wcs.newsletter.service.base.LabelLocalServiceBaseImpl
 * @see com.wcs.newsletter.service.impl.LabelLocalServiceImpl
 * @generated
 */
public class LabelLocalServiceUtil {
    private static LabelLocalService _service;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Add custom service methods to {@link com.wcs.newsletter.service.impl.LabelLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
     */

    /**
    * Adds the label to the database. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @return the label that was added
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label addLabel(
        com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().addLabel(label);
    }

    /**
    * Creates a new label with the primary key. Does not add the label to the database.
    *
    * @param labelId the primary key for the new label
    * @return the new label
    */
    public static com.wcs.newsletter.model.Label createLabel(long labelId) {
        return getService().createLabel(labelId);
    }

    /**
    * Deletes the label with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param labelId the primary key of the label
    * @return the label that was removed
    * @throws PortalException if a label with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label deleteLabel(long labelId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLabel(labelId);
    }

    /**
    * Deletes the label from the database. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @return the label that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label deleteLabel(
        com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().deleteLabel(label);
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

    public static com.wcs.newsletter.model.Label fetchLabel(long labelId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().fetchLabel(labelId);
    }

    /**
    * Returns the label with the primary key.
    *
    * @param labelId the primary key of the label
    * @return the label
    * @throws PortalException if a label with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label getLabel(long labelId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getLabel(labelId);
    }

    public static com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return getService().getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the labels.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of labels
    * @param end the upper bound of the range of labels (not inclusive)
    * @return the range of labels
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.wcs.newsletter.model.Label> getLabels(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLabels(start, end);
    }

    /**
    * Returns the number of labels.
    *
    * @return the number of labels
    * @throws SystemException if a system exception occurred
    */
    public static int getLabelsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().getLabelsCount();
    }

    /**
    * Updates the label in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @return the label that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label updateLabel(
        com.wcs.newsletter.model.Label label)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLabel(label);
    }

    /**
    * Updates the label in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param label the label
    * @param merge whether to merge the label with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the label that was updated
    * @throws SystemException if a system exception occurred
    */
    public static com.wcs.newsletter.model.Label updateLabel(
        com.wcs.newsletter.model.Label label, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().updateLabel(label, merge);
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

    public static com.wcs.newsletter.model.Label findByTagId(long tagId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getService().findByTagId(tagId);
    }

    public static void clearService() {
        _service = null;
    }

    public static LabelLocalService getService() {
        if (_service == null) {
            InvokableLocalService invokableLocalService = (InvokableLocalService) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
                    LabelLocalService.class.getName());

            if (invokableLocalService instanceof LabelLocalService) {
                _service = (LabelLocalService) invokableLocalService;
            } else {
                _service = new LabelLocalServiceClp(invokableLocalService);
            }

            ReferenceRegistry.registerReference(LabelLocalServiceUtil.class,
                "_service");
        }

        return _service;
    }

    /**
     * @deprecated
     */
    public void setService(LabelLocalService service) {
    }
}
