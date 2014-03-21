/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.security.permission.ActionKeys;

import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;




import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.LayoutLister;
import com.liferay.portal.util.LayoutView;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
//import com.liferay.portlet.documentlibrary.model.DLSync;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import static com.wcs.newsletter.controller.AbstractController.logger;
//import com.liferay.portlet.documentlibrary.service.DLSyncLocalServiceUtil;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.NewsletterConfig;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.model.impl.CategoryImpl;
import com.wcs.newsletter.model.impl.NewsletterConfigImpl;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.NewsletterConfigLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.util.AppMessageBundle;
import com.wcs.newsletter.util.LiferayUtil;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author csaba
 */
@ManagedBean (name = "configController")
@ViewScoped
public class ConfigController extends AbstractController {

    private static final String SAVE_SUCCESS = "admin_newsletters_save_success";
    private static final String CLEAR_SUCCESS = "admin_newsletters_clear_success";
    private boolean updateTemplate;
    private List<FileEntry> templateList;
    private FileEntry selectedTemplate;
    private boolean syncUsers;
    private boolean installedDefaults;
    private SelectItem[] layoutsForSelect;
    private String selectedLayout;

    public String getSelectedLayout() {
        return selectedLayout;
    }

    public void setSelectedLayout(String selectedLayout) {
        this.selectedLayout = selectedLayout;
    }

    public SelectItem[] getLayoutsForSelect() {
        return layoutsForSelect;
    }

    public void setLayoutsForSelect(SelectItem[] layoutsForSelect) {
        this.layoutsForSelect = layoutsForSelect;
    }

    public boolean isInstalledDefaults() {
        return installedDefaults;
    }

    public void setInstalledDefaults(boolean installedDefaults) {
        this.installedDefaults = installedDefaults;
    }

    public void save() {
        try {

            if (selectedTemplate != null) {
                List<NewsletterConfig> configs = NewsletterConfigLocalServiceUtil.findByConfigKey("emailTemplate");
                NewsletterConfig emailTemplateConfig;

                if (configs.isEmpty()) {
                    emailTemplateConfig = new NewsletterConfigImpl();
                    emailTemplateConfig.setConfigKey("emailTemplate");
                    emailTemplateConfig.setConfigValue(String.valueOf(selectedTemplate.getFileEntryId()));
                    NewsletterConfigLocalServiceUtil.addNewsletterConfig(emailTemplateConfig);
                } else {
                    emailTemplateConfig = configs.get(0);
                    emailTemplateConfig.setConfigValue(String.valueOf(selectedTemplate.getFileEntryId()));
                    NewsletterConfigLocalServiceUtil.updateNewsletterConfig(emailTemplateConfig);
                }
            }
            //configs
            List<NewsletterConfig> configs = NewsletterConfigLocalServiceUtil.findByConfigKey("syncUsers");
            NewsletterConfig syncUserConfig;

            if (configs.isEmpty()) {
                syncUserConfig = new NewsletterConfigImpl();
                syncUserConfig.setConfigKey("syncUsers");
                syncUserConfig.setConfigValue(syncUsers ? "1" : "0");
                NewsletterConfigLocalServiceUtil.addNewsletterConfig(syncUserConfig);
            } else {
                syncUserConfig = configs.get(0);
                syncUserConfig.setConfigValue(syncUsers ? "1" : "0");
                NewsletterConfigLocalServiceUtil.updateNewsletterConfig(syncUserConfig);
            }

            //configs
            configs = NewsletterConfigLocalServiceUtil.findByConfigKey("subscriptionActionLayout");
            NewsletterConfig subscriptionActionLayout;

            if (configs.isEmpty()) {
                subscriptionActionLayout = new NewsletterConfigImpl();
                subscriptionActionLayout.setConfigKey("subscriptionActionLayout");
                subscriptionActionLayout.setConfigValue(selectedLayout);
                NewsletterConfigLocalServiceUtil.addNewsletterConfig(subscriptionActionLayout);
            } else {
                subscriptionActionLayout = configs.get(0);
                subscriptionActionLayout.setConfigValue(selectedLayout);
                NewsletterConfigLocalServiceUtil.updateNewsletterConfig(subscriptionActionLayout);
            }
            //end configs

            addSuccessMessage(SAVE_SUCCESS);
        } catch (Exception ex) {
            logger.error(ex);
            addErrorMessage(ex);
        }
    }

    public boolean isSyncUsers() {
        return syncUsers;
    }

    public void setSyncUsers(boolean syncUsers) {
        this.syncUsers = syncUsers;
    }

    @Override
    public void initController() {
        listLayouts();
        initConfigs();
    }

    public void canSetTemplate() {
        updateTemplate = true;
    }

    public void initConfigs() {
        try {



            List<NewsletterConfig> configs = NewsletterConfigLocalServiceUtil.getNewsletterConfigs(0, NewsletterConfigLocalServiceUtil.getNewsletterConfigsCount());
            if (!configs.isEmpty()) {
                HashMap<String, String> configMap = new HashMap<String, String>();
                for (NewsletterConfig conf : configs) {
                    configMap.put(conf.getConfigKey(), conf.getConfigValue());
                }
                syncUsers = "1".equals(configMap.get("syncUsers"));
                installedDefaults = "1".equals(configMap.get("defaultsInstalled"));
                if (!updateTemplate) {
                    selectedTemplate = DLAppServiceUtil.getFileEntry(Long.valueOf(configMap.get("emailTemplate")));
                }
                selectedLayout = "";
                selectedLayout = configMap.get("subscriptionActionLayout");
            }
        } catch (PortalException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FileEntry getSelectedTemplate() {
        return selectedTemplate;
    }

    public void setSelectedTemplate(FileEntry selectedTemplate) {
        this.selectedTemplate = selectedTemplate;
    }

    public List<FileEntry> getTemplateList() {
        if (templateList == null || !(templateList.size() > 0)) {
            templateList = new ArrayList<FileEntry>();
            long galleryRootFolder = 0;
            try {
                List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getDLFileEntries(0, DLFileEntryLocalServiceUtil.getDLFileEntriesCount());//getFileEntries(getThemeDisplay().getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);//.getFileEntries(templateFolder.getRepositoryId(), folderId);
                for (DLFileEntry fil : files) {
                    FileEntry newsletterTemplate = DLAppServiceUtil.getFileEntry(fil.getFileEntryId());
                    if (newsletterTemplate.getMimeType().equals("text/html")) {
                        templateList.add(newsletterTemplate);
                    }
                }
            } catch (PortalException ex) {
                logger.error(ex);
            } catch (SystemException ex) {
                logger.error(ex);
            }
        }
        return templateList;
    }

    public void setTemplateList(List<FileEntry> templateList) {
        this.templateList = templateList;
    }

    public void installDefaultContents() {

        try {

            long id = CounterLocalServiceUtil.increment();
            ThemeDisplay themeDisplay = LiferayUtil.getThemeDisplay();
            DLFolder folder = DLFolderLocalServiceUtil.createDLFolder(id);
            folder.setName("Webstar-Newsletter");
            folder.setParentFolderId(0);
            folder.setDescription("Folder for default Webstar-Newsletter contents");
            folder.setGroupId(themeDisplay.getScopeGroupId());
            folder.setCompanyId(themeDisplay.getCompanyId());
            folder.setUserId(themeDisplay.getRealUserId());
            folder.setParentFolderId(DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
            long defaultRepoId = DLFolderConstants.getDataRepositoryId(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);
            folder.setRepositoryId(defaultRepoId);
            Date allDate = new Date();
            folder.setCreateDate(allDate);
            folder.setModifiedDate(allDate);
            folder.setLastPostDate(allDate);
            folder = DLFolderLocalServiceUtil.addDLFolder(folder);
            ServiceContext serviceContext = new ServiceContext();
            serviceContext.setScopeGroupId(folder.getGroupId());
            serviceContext.setAddGuestPermissions(true);
            serviceContext.setGuestPermissions(new String[]{ActionKeys.ACCESS});

            /*long syncId = CounterLocalServiceUtil.increment();
             DLSyncEvent foldersSync = DLSyncEventLocalServiceUtil.createDLSyncEvent(syncId);
             foldersSync.setFileId(folder.getFolderId());
             foldersSync.setParentFolderId(folder.getParentFolderId());
             foldersSync.setCompanyId(folder.getCompanyId());
             foldersSync.setFileUuid(folder.getUuid());
             foldersSync.setRepositoryId(folder.getRepositoryId());
             foldersSync.setName(folder.getName());
             foldersSync.setEvent("add");
             foldersSync.setType("folder");
             foldersSync.setVersion("-1");
             foldersSync.setCreateDate(allDate);
             foldersSync.setModifiedDate(allDate);
             DLSyncEventLocalServiceUtil.updateDLSync(foldersSync);*/

            /* Confirm tempalte 1*/
            long fileId = CounterLocalServiceUtil.increment();
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("install/HU_Confirm_Email.html");
            String filename = "Confirm_Template_HU.html";
            File confTemp1 = File.createTempFile("temp", ".tmp");
            FileOutputStream out = new FileOutputStream(confTemp1);
            IOUtils.copy(inputStream, out);


            DLFileEntry templateFile = DLFileEntryServiceUtil.addFileEntry(folder.getGroupId(), folder.getRepositoryId(), folder.getFolderId(), confTemp1.getName(), "text/html", filename, filename, "", folder.getDefaultFileEntryTypeId(), null, confTemp1, null, confTemp1.getUsableSpace(), serviceContext);
            DLFileEntryLocalServiceUtil.updateFileEntry(folder.getUserId(), templateFile.getFileEntryId(), filename, "text/html", filename, filename, "", true, templateFile.getFileEntryTypeId(), null, confTemp1, null, confTemp1.getUsableSpace(), serviceContext);
            confTemp1.deleteOnExit();

            /* Confirm tempalte 2*/
            fileId = CounterLocalServiceUtil.increment();
            inputStream = getClass().getClassLoader().getResourceAsStream("install/EN_Confirm_Email.html");
            filename = "Confirm_Template_EN.html";
            File confTemp2 = File.createTempFile("temp2", ".tmp");
            out = new FileOutputStream(confTemp2);
            IOUtils.copy(inputStream, out);

            templateFile = DLFileEntryServiceUtil.addFileEntry(folder.getGroupId(), folder.getRepositoryId(), folder.getFolderId(), confTemp2.getName(), "text/html", filename, filename, "", folder.getDefaultFileEntryTypeId(), null, confTemp2, null, confTemp2.getUsableSpace(), serviceContext);
            DLFileEntryLocalServiceUtil.updateFileEntry(folder.getUserId(), templateFile.getFileEntryId(), filename, "text/html", filename, filename, "", true, templateFile.getFileEntryTypeId(), null, confTemp2, null, confTemp2.getUsableSpace(), serviceContext);
            confTemp2.deleteOnExit();

            /*Set default confirm template to EN version */



            List<NewsletterConfig> configs = NewsletterConfigLocalServiceUtil.findByConfigKey("emailTemplate");
            NewsletterConfig defaultTemplate;
            if (configs.isEmpty()) {
                defaultTemplate = new NewsletterConfigImpl();
                defaultTemplate.setConfigKey("emailTemplate");
                defaultTemplate.setConfigValue(String.valueOf(templateFile.getFileEntryId()));
                NewsletterConfigLocalServiceUtil.addNewsletterConfig(defaultTemplate);
            } else {
                defaultTemplate = configs.get(0);
                defaultTemplate.setConfigValue(String.valueOf(templateFile.getFileEntryId()));
                NewsletterConfigLocalServiceUtil.updateNewsletterConfig(defaultTemplate);
            }


            /* Newsletter tempalte 1*/
            fileId = CounterLocalServiceUtil.increment();
            inputStream = getClass().getClassLoader().getResourceAsStream("install/HU_newsletterTemplate.html");
            filename = "Newsletter_Template_HU.html";
            File newsletterTemp1 = File.createTempFile("temp3", ".tmp");
            out = new FileOutputStream(newsletterTemp1);
            IOUtils.copy(inputStream, out);

            templateFile = DLFileEntryServiceUtil.addFileEntry(folder.getGroupId(), folder.getRepositoryId(), folder.getFolderId(), newsletterTemp1.getName(), "text/html", filename, filename, "", folder.getDefaultFileEntryTypeId(), null, newsletterTemp1, null, newsletterTemp1.getUsableSpace(), serviceContext);
            DLFileEntryLocalServiceUtil.updateFileEntry(folder.getUserId(), templateFile.getFileEntryId(), filename, "text/html", filename, filename, "", true, templateFile.getFileEntryTypeId(), null, newsletterTemp1, null, newsletterTemp1.getUsableSpace(), serviceContext);
            newsletterTemp1.deleteOnExit();


            /* Newsletter tempalte 2*/
            fileId = CounterLocalServiceUtil.increment();
            inputStream = getClass().getClassLoader().getResourceAsStream("install/EN_newsletterTemplate.html");
            filename = "Newsletter_Template_EN.html";
            File newsletterTemp2 = File.createTempFile("temp4", ".tmp");
            out = new FileOutputStream(newsletterTemp2);
            IOUtils.copy(inputStream, out);

            templateFile = DLFileEntryServiceUtil.addFileEntry(folder.getGroupId(), folder.getRepositoryId(), folder.getFolderId(), newsletterTemp2.getName(), "text/html", filename, filename, "", folder.getDefaultFileEntryTypeId(), null, newsletterTemp2, null, newsletterTemp2.getUsableSpace(), serviceContext);
            DLFileEntryLocalServiceUtil.updateFileEntry(folder.getUserId(), templateFile.getFileEntryId(), filename, "text/html", filename, filename, "", true, templateFile.getFileEntryTypeId(), null, newsletterTemp2, null, newsletterTemp2.getUsableSpace(), serviceContext);
            newsletterTemp2.deleteOnExit();

            NewsletterConfig defaultsInstalledConfig = new NewsletterConfigImpl();
            defaultsInstalledConfig.setConfigKey("defaultsInstalled");
            defaultsInstalledConfig.setConfigValue("1");
            NewsletterConfigLocalServiceUtil.addNewsletterConfig(defaultsInstalledConfig);

            Category actualCategory = null;
            Locale[] localesForDefaultCategories = LiferayUtil.getAvailableLocales();
            for (Locale local : localesForDefaultCategories) {
                actualCategory = new CategoryImpl();
                actualCategory.setLocale(local.toString());
                actualCategory.setName("Default_" + local);
                CategoryLocalServiceUtil.addCategory(actualCategory);
            }


        } catch (IOException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PortalException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void listLayouts() {
        try {
            Layout rootLayout = null;

            long rootLayoutId = LayoutConstants.DEFAULT_PARENT_LAYOUT_ID;

            LayoutLister layoutLister = new LayoutLister();

            String rootNodeName = StringPool.BLANK;
            LayoutView layoutView = layoutLister.getLayoutView(getThemeDisplay().getScopeGroupId(), false, rootNodeName, getThemeDisplay().getLocale());

            List layoutList = layoutView.getList();
            Map<String, String> layoutMap = new HashMap<String, String>();
            layoutMap.put("", AppMessageBundle.getString("choose"));
            for (int i = 0; i < layoutList.size(); i++) {
                // id | parentId | ls | obj id | name | img | depth
                String layoutDesc = (String) layoutList.get(i);

                String[] nodeValues = StringUtil.split(layoutDesc, '|');

                long objId = GetterUtil.getLong(nodeValues[3]);
                String name = nodeValues[4];

                int depth = 0;

                if (i != 0) {
                    depth = GetterUtil.getInteger(nodeValues[6]);
                }

                for (int j = 0; j < depth; j++) {
                    name = "- " + name;
                }
                Layout curRootLayout = null;
                try {
                    curRootLayout = LayoutLocalServiceUtil.getLayout(objId);
                } catch (Exception e) {
                }
                if (curRootLayout != null) {
                    layoutMap.put(String.valueOf(curRootLayout.getPlid()), name);
                }

            }
            layoutsForSelect = new SelectItem[layoutMap.size()];
            int arrayHelper = 0;
            for (String key : layoutMap.keySet()) {
                layoutsForSelect[arrayHelper] = new SelectItem(key, layoutMap.get(key));
                arrayHelper++;
            }
        } catch (PortalException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SystemException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearCategorySubscriptions() {
        try {
            List<Category> categoryList = CategoryLocalServiceUtil.getCategories();
            List<SubscriptionCategory> subscriptionList = SubscriptionCategoryLocalServiceUtil.getSubscriptionCategories(0, SubscriptionCategoryLocalServiceUtil.getSubscriptionCategoriesCount());
//            System.out.println("categoryList" + categoryList);
//            System.out.println("subscriptionList" + subscriptionList);
            List<Long> catIds = new ArrayList<Long>();
            for (Category cat : categoryList) {
                catIds.add(cat.getCategoryId());
            }
            for (SubscriptionCategory sCat : subscriptionList) {
                if (!catIds.contains(sCat.getCategoryId())) {
                    SubscriptionCategoryLocalServiceUtil.deleteSubscriptionCategory(sCat);
                }
            }
            addSuccessMessage(CLEAR_SUCCESS);
        } catch (SystemException ex) {
            Logger.getLogger(ConfigController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
