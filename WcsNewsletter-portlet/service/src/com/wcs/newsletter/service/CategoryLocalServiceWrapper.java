package com.wcs.newsletter.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * <p>
 * This class is a wrapper for {@link CategoryLocalService}.
 * </p>
 *
 * @author    Brian Wing Shun Chan
 * @see       CategoryLocalService
 * @generated
 */
public class CategoryLocalServiceWrapper implements CategoryLocalService,
    ServiceWrapper<CategoryLocalService> {
    private CategoryLocalService _categoryLocalService;

    public CategoryLocalServiceWrapper(
        CategoryLocalService categoryLocalService) {
        _categoryLocalService = categoryLocalService;
    }

    /**
    * Adds the category to the database. Also notifies the appropriate model listeners.
    *
    * @param category the category
    * @return the category that was added
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category addCategory(
        com.wcs.newsletter.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.addCategory(category);
    }

    /**
    * Creates a new category with the primary key. Does not add the category to the database.
    *
    * @param categoryId the primary key for the new category
    * @return the new category
    */
    public com.wcs.newsletter.model.Category createCategory(long categoryId) {
        return _categoryLocalService.createCategory(categoryId);
    }

    /**
    * Deletes the category with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param categoryId the primary key of the category
    * @return the category that was removed
    * @throws PortalException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category deleteCategory(long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.deleteCategory(categoryId);
    }

    /**
    * Deletes the category from the database. Also notifies the appropriate model listeners.
    *
    * @param category the category
    * @return the category that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category deleteCategory(
        com.wcs.newsletter.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.deleteCategory(category);
    }

    public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
        return _categoryLocalService.dynamicQuery();
    }

    /**
    * Performs a dynamic query on the database and returns the matching rows.
    *
    * @param dynamicQuery the dynamic query
    * @return the matching rows
    * @throws SystemException if a system exception occurred
    */
    @SuppressWarnings("rawtypes")
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQuery(dynamicQuery);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQuery(dynamicQuery, start, end);
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
    public java.util.List dynamicQuery(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
    * Returns the number of rows that match the dynamic query.
    *
    * @param dynamicQuery the dynamic query
    * @return the number of rows that match the dynamic query
    * @throws SystemException if a system exception occurred
    */
    public long dynamicQueryCount(
        com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.dynamicQueryCount(dynamicQuery);
    }

    public com.wcs.newsletter.model.Category fetchCategory(long categoryId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.fetchCategory(categoryId);
    }

    /**
    * Returns the category with the primary key.
    *
    * @param categoryId the primary key of the category
    * @return the category
    * @throws PortalException if a category with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category getCategory(long categoryId)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getCategory(categoryId);
    }

    public com.liferay.portal.model.PersistedModel getPersistedModel(
        java.io.Serializable primaryKeyObj)
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getPersistedModel(primaryKeyObj);
    }

    /**
    * Returns a range of all the categories.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
    * </p>
    *
    * @param start the lower bound of the range of categories
    * @param end the upper bound of the range of categories (not inclusive)
    * @return the range of categories
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.wcs.newsletter.model.Category> getCategories(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getCategories(start, end);
    }

    /**
    * Returns the number of categories.
    *
    * @return the number of categories
    * @throws SystemException if a system exception occurred
    */
    public int getCategoriesCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getCategoriesCount();
    }

    /**
    * Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param category the category
    * @return the category that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category updateCategory(
        com.wcs.newsletter.model.Category category)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.updateCategory(category);
    }

    /**
    * Updates the category in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
    *
    * @param category the category
    * @param merge whether to merge the category with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
    * @return the category that was updated
    * @throws SystemException if a system exception occurred
    */
    public com.wcs.newsletter.model.Category updateCategory(
        com.wcs.newsletter.model.Category category, boolean merge)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.updateCategory(category, merge);
    }

    /**
    * Returns the Spring bean ID for this bean.
    *
    * @return the Spring bean ID for this bean
    */
    public java.lang.String getBeanIdentifier() {
        return _categoryLocalService.getBeanIdentifier();
    }

    /**
    * Sets the Spring bean ID for this bean.
    *
    * @param beanIdentifier the Spring bean ID for this bean
    */
    public void setBeanIdentifier(java.lang.String beanIdentifier) {
        _categoryLocalService.setBeanIdentifier(beanIdentifier);
    }

    public java.lang.Object invokeMethod(java.lang.String name,
        java.lang.String[] parameterTypes, java.lang.Object[] arguments)
        throws java.lang.Throwable {
        return _categoryLocalService.invokeMethod(name, parameterTypes,
            arguments);
    }

    public com.wcs.newsletter.model.Category createNewCategory() {
        return _categoryLocalService.createNewCategory();
    }

    public java.util.List<com.wcs.newsletter.model.Category> getCategories()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.getCategories();
    }

    public java.util.List<com.wcs.newsletter.model.Category> findByLocale(
        java.lang.String locale)
        throws com.liferay.portal.kernel.exception.SystemException {
        return _categoryLocalService.findByLocale(locale);
    }

    /**
     * @deprecated Renamed to {@link #getWrappedService}
     */
    public CategoryLocalService getWrappedCategoryLocalService() {
        return _categoryLocalService;
    }

    /**
     * @deprecated Renamed to {@link #setWrappedService}
     */
    public void setWrappedCategoryLocalService(
        CategoryLocalService categoryLocalService) {
        _categoryLocalService = categoryLocalService;
    }

    public CategoryLocalService getWrappedService() {
        return _categoryLocalService;
    }

    public void setWrappedService(CategoryLocalService categoryLocalService) {
        _categoryLocalService = categoryLocalService;
    }
}
