package com.wcs.newsletter.util;

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
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.wcs.newsletter.controller.AbstractController;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portlet.asset.model.AssetTag;
import com.wcs.newsletter.controller.NewsletterListController;
import com.wcs.newsletter.model.Label;
import com.wcs.newsletter.model.impl.LabelImpl;
import com.wcs.tool.StringUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import javax.faces.context.FacesContext;
import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;

public class LiferayUtil {

    protected static final Logger logger = LoggerFactory.getLogger(AbstractController.class);

    public static User getActiveUser() {
        User user = null;

        FacesContext liferayFacesContext = FacesContext.getCurrentInstance();
        PortletRequest request = liferayFacesContext != null ? (PortletRequest) liferayFacesContext.getExternalContext().getRequest() : null;
        String remoteUser = request != null ? request.getRemoteUser() : null;

        if (StringUtil.isNotEmpty(remoteUser)) {
            try {
                user = UserLocalServiceUtil.getUser(Long.parseLong(remoteUser));
            } catch (Exception e) {
                logger.error(e);
            }
        }

        return user;
    }

    public static ThemeDisplay getThemeDisplay() {
        PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        return (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
    }

    public static HttpServletRequest getHttpServletRequest() {
//        LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
        PortletRequest request = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));

        return httpReq;
    }

    public static String getLiferayFullLangCode() {
        PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        return themeDisplay.getLanguageId();
    }

    public static Locale getLocale(String langCode) {
        if (StringUtil.isEmpty(langCode)) {
            return null;
        }

        Locale[] availableLocales = getAvailableLocales();
        for (Locale locale : availableLocales) {
            String localeStr = locale.toString();
            if (langCode.equals(localeStr)) {
                return locale;
            }
        }

        return null;
    }

    public static PortletPreferences getPortletPreferences() {
//        LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
        PortletRequest request = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        PortletPreferences preferences = request.getPreferences();

        String portletResource = ParamUtil.getString(request, "portletResource");

        if (Validator.isNotNull(portletResource)) {
            try {
                preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
            } catch (Exception ex) {
                logger.error(ex);
            }
        }

        return preferences;
    }

    public static Locale[] getAvailableLocales() {
        Locale[] availableLocales = LanguageUtil.getAvailableLocales();

        if (availableLocales == null) {
            availableLocales = new Locale[]{};
        }

        return availableLocales;
    }

    public static <T> List<T> getImplFromListForClass(List listToTransfer, Class<T> transferedClass) {
        return getImplFromListForClass(listToTransfer, transferedClass, null);
    }

    public static <T> List<T> getImplFromListForClass(List listToTransfer, Class<T> transferedClass, Class initialiserClass) {
        //MANY-TO-MANY Liferay 6.2 BUG fix
        List<T> transferedList = new ArrayList<>();
        for (int i = 0; i < listToTransfer.size(); i++) {
            try {
                Object elem = listToTransfer.get(i);
//                System.out.println("elem.getClass()" + elem.getClass());
//                System.out.println("transferedClass.getClass()" + transferedClass);
//                System.out.println("elso:" + elem.getClass().isAssignableFrom(transferedClass));
//                System.out.println("masodik:" + transferedClass.isAssignableFrom(elem.getClass()));
//                System.out.println("memoria:" + (elem.getClass() == transferedClass));
                T transferedObj = null;
                if (initialiserClass != null) {
                    transferedObj = (T) initialiserClass.getConstructor().newInstance();
                } else {
                    transferedObj = transferedClass.getConstructor().newInstance();
                }
                Method[] methods = transferedObj.getClass().getMethods();                
                for (Method method : methods) {
                    if (isSetter(method)) {
                        Class paramType = method.getParameterTypes()[0];
                        String paramName = method.getName().replace("set", "");
                        String paramNameGetter = method.getName().replace("set", "get");
                        try {
                            Method getMeth = elem.getClass().getMethod(paramNameGetter);
                            if (getMeth != null) {
                                method.invoke(transferedObj, getMeth.invoke(elem));
                            }
                        } catch (NoSuchMethodException ex) {
//                            ex.printStackTrace();  IGNORE IF SO SUCH GETTER
                        }

                    }
                }
                transferedList.add(transferedObj);
            } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException ex) {
//                ex.printStackTrace();
                java.util.logging.Logger.getLogger(LiferayUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return transferedList;
    }

    public static boolean isSetter(Method method) {
        if (!method.getName().startsWith("set")) {
            return false;
        }
        if (method.getParameterTypes().length != 1) {
            return false;
        }
        return true;
    }
}
