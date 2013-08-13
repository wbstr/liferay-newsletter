package com.wcs.newsletter.controller;

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

import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.wcs.newsletter.util.JsfUtil;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;

@ManagedBean
@SessionScoped
public class NavigationController extends AbstractSessionController {

    private static final String ROOT = "/view/admin/";
    private static final String EDIT = "edit";
    private static final String LIST = "list";
    private static final String NEWSLETTER = "newsletter";
    private static final int CATEGORIES_MENU = 0;
    private static final int SUBSCRIPTIONS_MENU = 1;
    private static final int NEWSLETTERS_MENU = 2;
    private static final int NEWSLETTERSCONFIG_MENU = 3;
    private static final int CATEGORIES = 0;
    private static final int CATEGORIES_EDIT = 1;
    private static final int USERS = 2;
    private static final int USERS_EDIT = 3;
    private static final int NEWSLETTERS = 4;    
    private static final int NEWSLETTERS_EDIT = 5;
    private static final int NEWSLETTERS_LIST = 6;
    private static final int NEWSLETTERS_LIST_EDIT = 7;
    private static final int NEWSLETTERS_CONFIG = 8;
    private NavigationParamController navigationParamController;
    private int activeIndex = 0;
    private int activeSubIndex = 0;

    public void initCategoriesMenu() {
        setActiveIndex(CATEGORIES_MENU);
    }

    public void initSubscriptionsMenu() {
        setActiveIndex(SUBSCRIPTIONS_MENU);
    }

    public void initNewslettersMenu() {
        setActiveIndex(NEWSLETTERS_MENU);
    }

    public void initNewslettersConfig() {
        setActiveIndex(NEWSLETTERSCONFIG_MENU);
    }

    public void initSubscriptionsSubMenu() {
        setActiveSubIndex(USERS);
    }
    public void initSubscriptionsEditSubMenu() {
        setActiveSubIndex(USERS_EDIT);
    }
    public void initNewsletterSubMenu() {
        setActiveSubIndex(NEWSLETTERS);
    }
    public void initNewsletterEditSubMenu() {
        setActiveSubIndex(NEWSLETTERS_EDIT);
    }
    public void initNewsletterListSubMenu() {
        setActiveSubIndex(NEWSLETTERS_LIST);
    }
    public void initNewsletterListEditSubMenu() {
        setActiveSubIndex(NEWSLETTERS_LIST_EDIT);
    }
    public void initNewsletterConfigSubMenu() {
        setActiveSubIndex(NEWSLETTERS_CONFIG);
    }
    public void initCategoriesSubMenu() {
        setActiveSubIndex(CATEGORIES);
    }
    public void initCategoriesEditSubMenu() {
        setActiveSubIndex(CATEGORIES_EDIT);
    }

    public String navigateToCategoriesMenu() {
        initCategoriesMenu();
        return ROOT + "categoryList.jsf?faces-redirect=true";
    }

    public String navigateToSubscriptionsMenu() {
        initSubscriptionsMenu();
        return ROOT + "subscriptionList.jsf?faces-redirect=true";
    }

    public String navigateToNewslettersMenu() {
        initNewslettersMenu();
        return ROOT + "newsletterList.jsf?faces-redirect=true";
    }

    public String navigateToNewslettersConfig() {
        initNewslettersConfig();
        return ROOT + "subscriptionConfig.jsf?faces-redirect=true";
    }

    public String navigateToCategoryEdit(Long id) {
        getNavigationParamController().setCategoryParam(id);

        return EDIT;
    }

    public String navigateToSubscriptionEdit(Long id) {
        getNavigationParamController().setSubscriptionParam(id);

        return EDIT;
    }

    public String navigateToNewsletterEdit(Long id) {
        getNavigationParamController().setNewsletterParam(id);

        return EDIT;
    }

    public String navigateToNewsletterCreate() {
        return EDIT;
    }
    
    public String navigateToNewsletterList() {
        return LIST;
    }

    public String navigateToList() {
        return LIST;
    }

    public int getActiveIndex() {
        return activeIndex;
    }

    public int getActiveSubIndex() {
        return activeSubIndex;
    }

    public void setActiveSubIndex(int activeSubIndex) {
        this.activeSubIndex = activeSubIndex;
    }

    public void setActiveIndex(int activeIndex) {
        this.activeIndex = activeIndex;
    }

    public String getLiferayFullLangCode() {
        PortletRequest portletRequest = (PortletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        //TODO: ez jöhetne valami abstract ős controllerből!
        return themeDisplay.getLanguageId();
    }
    
    public NavigationParamController getNavigationParamController() {
        if (navigationParamController == null) {
            navigationParamController = (NavigationParamController) JsfUtil.getManagedBean("navigationParamController");
        }

        return navigationParamController;
    }

    public boolean isCategories() {

        return CATEGORIES == activeSubIndex;
    }

    public boolean isCategoriesEdit() {

        return CATEGORIES_EDIT == activeSubIndex;
    }

    public boolean isUsers() {

        return USERS == activeSubIndex;
    }

    public boolean isUsersEdit() {

        return USERS_EDIT == activeSubIndex;
    }

    public boolean isNewsletters() {

        return NEWSLETTERS == activeSubIndex;
    }
    public boolean isNewslettersEdit() {

        return NEWSLETTERS_EDIT == activeSubIndex;
    }

    public boolean isNewslettersList() {

        return NEWSLETTERS_LIST == activeSubIndex;
    }

    public boolean isNewslettersListEdit() {

        return NEWSLETTERS_LIST_EDIT == activeSubIndex;
    }

    public boolean isConfig() {

        return NEWSLETTERS_CONFIG == activeSubIndex;
    }
}
