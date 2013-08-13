package com.wcs.newsletter.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import com.wcs.newsletter.model.CategoryClp;
import com.wcs.newsletter.model.EmailTemplateClp;
import com.wcs.newsletter.model.LabelClp;
import com.wcs.newsletter.model.NewsletterClp;
import com.wcs.newsletter.model.NewsletterConfigClp;
import com.wcs.newsletter.model.RecipientClp;
import com.wcs.newsletter.model.SubscriptionCategoryClp;
import com.wcs.newsletter.model.SubscriptionClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "WcsNewsletter-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "WcsNewsletter-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "WcsNewsletter-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(CategoryClp.class.getName())) {
            return translateInputCategory(oldModel);
        }

        if (oldModelClassName.equals(EmailTemplateClp.class.getName())) {
            return translateInputEmailTemplate(oldModel);
        }

        if (oldModelClassName.equals(LabelClp.class.getName())) {
            return translateInputLabel(oldModel);
        }

        if (oldModelClassName.equals(NewsletterClp.class.getName())) {
            return translateInputNewsletter(oldModel);
        }

        if (oldModelClassName.equals(NewsletterConfigClp.class.getName())) {
            return translateInputNewsletterConfig(oldModel);
        }

        if (oldModelClassName.equals(RecipientClp.class.getName())) {
            return translateInputRecipient(oldModel);
        }

        if (oldModelClassName.equals(SubscriptionClp.class.getName())) {
            return translateInputSubscription(oldModel);
        }

        if (oldModelClassName.equals(SubscriptionCategoryClp.class.getName())) {
            return translateInputSubscriptionCategory(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputCategory(BaseModel<?> oldModel) {
        CategoryClp oldClpModel = (CategoryClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCategoryRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputEmailTemplate(BaseModel<?> oldModel) {
        EmailTemplateClp oldClpModel = (EmailTemplateClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getEmailTemplateRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputLabel(BaseModel<?> oldModel) {
        LabelClp oldClpModel = (LabelClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getLabelRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputNewsletter(BaseModel<?> oldModel) {
        NewsletterClp oldClpModel = (NewsletterClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getNewsletterRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputNewsletterConfig(BaseModel<?> oldModel) {
        NewsletterConfigClp oldClpModel = (NewsletterConfigClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getNewsletterConfigRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRecipient(BaseModel<?> oldModel) {
        RecipientClp oldClpModel = (RecipientClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRecipientRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSubscription(BaseModel<?> oldModel) {
        SubscriptionClp oldClpModel = (SubscriptionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSubscriptionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputSubscriptionCategory(
        BaseModel<?> oldModel) {
        SubscriptionCategoryClp oldClpModel = (SubscriptionCategoryClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getSubscriptionCategoryRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "com.wcs.newsletter.model.impl.CategoryImpl")) {
            return translateOutputCategory(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.wcs.newsletter.model.impl.EmailTemplateImpl")) {
            return translateOutputEmailTemplate(oldModel);
        }

        if (oldModelClassName.equals("com.wcs.newsletter.model.impl.LabelImpl")) {
            return translateOutputLabel(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.wcs.newsletter.model.impl.NewsletterImpl")) {
            return translateOutputNewsletter(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.wcs.newsletter.model.impl.NewsletterConfigImpl")) {
            return translateOutputNewsletterConfig(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.wcs.newsletter.model.impl.RecipientImpl")) {
            return translateOutputRecipient(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.wcs.newsletter.model.impl.SubscriptionImpl")) {
            return translateOutputSubscription(oldModel);
        }

        if (oldModelClassName.equals(
                    "com.wcs.newsletter.model.impl.SubscriptionCategoryImpl")) {
            return translateOutputSubscriptionCategory(oldModel);
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("com.wcs.newsletter.NoSuchCategoryException")) {
            return new com.wcs.newsletter.NoSuchCategoryException();
        }

        if (className.equals("com.wcs.newsletter.NoSuchEmailTemplateException")) {
            return new com.wcs.newsletter.NoSuchEmailTemplateException();
        }

        if (className.equals("com.wcs.newsletter.NoSuchLabelException")) {
            return new com.wcs.newsletter.NoSuchLabelException();
        }

        if (className.equals("com.wcs.newsletter.NoSuchNewsletterException")) {
            return new com.wcs.newsletter.NoSuchNewsletterException();
        }

        if (className.equals(
                    "com.wcs.newsletter.NoSuchNewsletterConfigException")) {
            return new com.wcs.newsletter.NoSuchNewsletterConfigException();
        }

        if (className.equals("com.wcs.newsletter.NoSuchRecipientException")) {
            return new com.wcs.newsletter.NoSuchRecipientException();
        }

        if (className.equals("com.wcs.newsletter.NoSuchSubscriptionException")) {
            return new com.wcs.newsletter.NoSuchSubscriptionException();
        }

        if (className.equals(
                    "com.wcs.newsletter.NoSuchSubscriptionCategoryException")) {
            return new com.wcs.newsletter.NoSuchSubscriptionCategoryException();
        }

        return throwable;
    }

    public static Object translateOutputCategory(BaseModel<?> oldModel) {
        CategoryClp newModel = new CategoryClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCategoryRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputEmailTemplate(BaseModel<?> oldModel) {
        EmailTemplateClp newModel = new EmailTemplateClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setEmailTemplateRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputLabel(BaseModel<?> oldModel) {
        LabelClp newModel = new LabelClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setLabelRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputNewsletter(BaseModel<?> oldModel) {
        NewsletterClp newModel = new NewsletterClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setNewsletterRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputNewsletterConfig(BaseModel<?> oldModel) {
        NewsletterConfigClp newModel = new NewsletterConfigClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setNewsletterConfigRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRecipient(BaseModel<?> oldModel) {
        RecipientClp newModel = new RecipientClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRecipientRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSubscription(BaseModel<?> oldModel) {
        SubscriptionClp newModel = new SubscriptionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSubscriptionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputSubscriptionCategory(
        BaseModel<?> oldModel) {
        SubscriptionCategoryClp newModel = new SubscriptionCategoryClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setSubscriptionCategoryRemoteModel(oldModel);

        return newModel;
    }
}
