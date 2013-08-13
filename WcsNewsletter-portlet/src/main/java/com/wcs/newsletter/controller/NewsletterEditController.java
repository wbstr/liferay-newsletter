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
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.model.AssetTagWrapper;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portlet.journalcontent.util.JournalContentUtil;
import com.wcs.newsletter.comparator.AssetTagComparator;
import com.wcs.newsletter.dto.NewsletterListElem;
import com.wcs.newsletter.dto.NewsletterListElemDataModel;
import com.wcs.newsletter.dto.NewsletterSenderList;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Label;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.model.NewsletterConfig;
import com.wcs.newsletter.model.Recipient;
import com.wcs.newsletter.model.impl.NewsletterImpl;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.NewsletterLocalServiceUtil;
import com.wcs.newsletter.service.NewsletterConfigLocalServiceUtil;
import com.wcs.newsletter.service.RecipientLocalServiceUtil;
import com.wcs.newsletter.tools.Tools;
import com.wcs.newsletter.util.LiferayUtil;
import com.wcs.newsletter.util.NewsletterSender;
import com.wcs.tool.DateUtil;
import com.wcs.tool.ListUtil;
import com.wcs.tool.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.portlet.PortletResponse;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;
import com.wcs.newsletter.model.impl.LabelImpl;
import com.wcs.newsletter.service.LabelLocalServiceUtil;
import java.util.Collections;

@ManagedBean
@ViewScoped
public class NewsletterEditController extends AbstractEditController<Newsletter, Long> {

    private static final String SENDING_ERROR = "admin_newsletters_sending_error";
    private static final String SENDING_SUCCESS = "admin_newsletters_sending_success";
    private DualListModel<Category> categoriesModel;
    private List<JournalArticle> webContentList;
    private NewsletterListElemDataModel childModel;
    private JournalArticle selectedWc;
    private boolean updateWc;
    private boolean updateTemplate;
    private List<FileEntry> templateList;
    private FileEntry selectedTemplate;
    private List<Recipient> userList;
    private String testEmail;
    private String categoryLocale;
    private List<AssetTag> tags;
    private List<AssetTag> selectedTags;
    private String labelStr;

    public String getLabelStr() {
        return labelStr;
    }

    public void setLabelStr(String labelStr) {
        this.labelStr = labelStr;
    }

    public List<AssetTag> getTags() {
        if (tags == null) {
            try {
                tags = AssetTagLocalServiceUtil.getAssetTags(0, AssetTagLocalServiceUtil.getAssetTagsCount());
            } catch (Exception e) {
                logger.error(e);
            }

            if (tags == null) {
                tags = new ArrayList<AssetTag>();
            }

            Locale locale = LiferayUtil.getThemeDisplay().getLocale();
            Collections.sort(tags, new AssetTagComparator(locale));
        }

//        logger.info("getTags: {0}db", new Object[]{tags.size()});
//        for (AssetTag tag : tags) {
//            logger.info("tag: {0} {1}", new Object[]{String.valueOf(tag.getTagId()), tag.getName()});            
//        }

        return tags;
    }

    public void setTags(List<AssetTag> tags) {
        this.tags = tags;
    }

    private Map<Long, AssetTag> getTagsMap() {
        Map<Long, AssetTag> tagsMap = new HashMap<Long, AssetTag>();

        for (AssetTag assetTag : getTags()) {
            tagsMap.put(assetTag.getTagId(), assetTag);
        }

        return tagsMap;
    }

    public List<AssetTag> getSelectedTags() {
        if (selectedTags == null) {
            selectedTags = new ArrayList<AssetTag>();

            Map<Long, AssetTag> tagsMap = getTagsMap();

            try {
                List<Label> labels = getElem().getLabels();
                for (Label tag : labels) {
                    Long assetTagId = tag.getTagId();
                    AssetTag assetTag = tagsMap.get(assetTagId);

                    if (assetTag == null) {
                        logger.warn("NINCS assetTag!!! {0}", new Object[]{tag});
                    } else {
                        selectedTags.add(assetTag);
                    }
                }
            } catch (Exception e) {
                logger.error(e);
            }

            Locale locale = LiferayUtil.getThemeDisplay().getLocale();
            Collections.sort(selectedTags, new AssetTagComparator(locale));
        }

//        logger.info("newsletter tags: {0}db", new Object[]{selectedTags.size()});
//        for (AssetTag tag : selectedTags) {
//            logger.info("newsletter tag: {0} {1}", new Object[]{String.valueOf(tag.getTagId()), tag.getName()});            
//        }          

        return selectedTags;
    }

    public void setSelectedTags(List<AssetTag> selectedTags) {
        this.selectedTags = selectedTags;
    }

    public boolean isTagContainerRendered() {
        boolean rendered = ListUtil.isNotEmpty(getSelectedTags());

        return rendered;
    }

    public void onLabelChange() {
        //logger.info("onLabelChange: {0}", new Object[]{""});

        List<Label> labels = new ArrayList<Label>();

        try {
            for (AssetTag assetTag : getSelectedTags()) {
                Label label = getLabel(assetTag);
                label.setTagId(assetTag.getTagId());

                labels.add(label);
            }

            getElem().setLabels(labels);
        } catch (Exception e) {
            logger.error(e);
        }
    }

    private Label getLabel(AssetTag assetTag) throws SystemException {
        if (assetTag == null) {
            return null;
        }

        Long tagId = assetTag.getTagId();

        Label savedLabel = null;

        savedLabel = LabelLocalServiceUtil.findByTagId(tagId);

        if (savedLabel == null) {
            savedLabel = new LabelImpl();
            savedLabel.setTagId(tagId);
            savedLabel = LabelLocalServiceUtil.addLabel(savedLabel);
        }

        return savedLabel;
    }

    private AssetTag getAssetTagByName(String tagName) throws Exception {
        AssetTag savedAssetTag = null;

        if (StringUtil.isEmpty(tagName)) {
            return savedAssetTag;
        }

        Map<Long, AssetTag> tagsMap = getTagsMap();
        for (Map.Entry<Long, AssetTag> entry : tagsMap.entrySet()) {
            AssetTag assetTag = entry.getValue();

            String assetTagName = assetTag.getName();

            if (tagName.equalsIgnoreCase(assetTagName)) {
                savedAssetTag = assetTag;
                break;
            }
        }

        if (savedAssetTag == null) {
            String assetTagClassName = AssetTag.class.getName();
            Long tagId = CounterLocalServiceUtil.increment(assetTagClassName);
            savedAssetTag = AssetTagLocalServiceUtil.createAssetTag(tagId);
            savedAssetTag.setName(tagName);

            User user = LiferayUtil.getActiveUser();
            if (user != null) {
                savedAssetTag.setUserId(user.getUserId());
                savedAssetTag.setCompanyId(user.getCompanyId());
                Long groupId = null;
                try {
                    groupId = user.getGroupId();
                } catch (Exception e) {
                    logger.error(e);
                }
                savedAssetTag.setGroupId(groupId);
            }

            Date date = DateUtil.getCurrentDate();
            savedAssetTag.setCreateDate(date);
            savedAssetTag.setModifiedDate(date);

            AssetTagLocalServiceUtil.updateAssetTag(savedAssetTag, true);
            savedAssetTag = AssetTagLocalServiceUtil.getTag(tagId);
        }

        if (savedAssetTag == null) {
            throw new IllegalStateException();
        }

        return savedAssetTag;
    }

    public void createLabel() {
        //logger.info("createLabel: {0}", new Object[]{labelStr});

        if (StringUtil.isEmpty(labelStr)) {
            return;
        }

        try {
            AssetTag savedAssetTag = getAssetTagByName(labelStr);
            Label savedLabel = getLabel(savedAssetTag);

            List<Label> oldLabels = getElem().getLabels();
            List<Label> labels = new ArrayList<Label>();
            labels.addAll(oldLabels);
            labels.add(savedLabel);

            getElem().setLabels(labels);

            setTags(null);
            setSelectedTags(null);
            setLabelStr(null);

        } catch (Exception e) {
            logger.error(e);
            addErrorMessage(e);
        }

    }

    public void removeLabel(AssetTag assetTag) {
        //logger.info("removeLabel: {0}", new Object[]{assetTag});

        if (assetTag == null) {
            return;
        }

        Long tagId = assetTag.getTagId();

        Label labelToDelete = null;

        try {
            List<Label> oldLabels = getElem().getLabels();
            for (Label label : oldLabels) {
                Long labelTagId = label.getTagId();

                if (tagId.equals(labelTagId)) {
                    labelToDelete = label;
                    break;
                }
            }

            List<Label> labels = new ArrayList<Label>();
            labels.addAll(oldLabels);
            labels.remove(labelToDelete);

            getElem().setLabels(labels);

            setSelectedTags(null);

        } catch (Exception e) {
            logger.error(e);
        }
    }

    public String getCategoryLocale() {
        return categoryLocale;
    }

    public void setCategoryLocale(String categoryLocale) {
        //logger.info("setCategoryLocale: {0}", new Object[]{categoryLocale});

        this.categoryLocale = categoryLocale;
    }

    public boolean isCanSend() {
        if (getElem().getNewsletterId() == 0) {
            return false;
        }

        if (!isCanEdit()) {
            return false;
        }

        return true;
    }

    public String getTestEmail() {
        return testEmail;
    }

    public void setTestEmail(String testEmail) {
        this.testEmail = testEmail;
    }

    public boolean isCanEdit() {
        return getChildModel().getRowCount() < 1;
    }

    public String getSiteViewUrl(JournalArticle art) {
        return getThemeDisplay().getURLPortal() + "/-/" + art.getUrlTitle();
//        return getThemeDisplay().getURLPortal()+"/c/journal/view_article_content?cmd=view&groupId="+art.getGroupId()+"&articleId="+art.getArticleId()+"&version="+art.getVersion();
    }

    public String getPubDate(JournalArticle art) {
        return DateUtil.dateToString(art.getCreateDate(), "yyyy.MM.dd");// hh:mm:ss
    }

    public void generateUserList(NewsletterListElem sNL) {
        try {
            userList = new ArrayList<Recipient>();
            userList = RecipientLocalServiceUtil.findByNewsletterId(sNL.getNewsletterId());
        } catch (SystemException ex) {
            Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void generateUserListTable(Newsletter sNL) {
        try {
            userList = new ArrayList<Recipient>();
            userList = RecipientLocalServiceUtil.findByNewsletterId(sNL.getNewsletterId());
        } catch (SystemException ex) {
            Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public List<Recipient> getUserList() {
        return userList;
    }

    public void setUserList(List<Recipient> userList) {
        this.userList = userList;
    }

    public List<FileEntry> getTemplateList() {
        if (templateList == null) {
            templateList = new ArrayList<FileEntry>();
            long galleryRootFolder = 0;


            try {
                long folderId = galleryRootFolder;//folder id of parent folder inside which you place  your image or sub folders(get this id from database //table)

//                DLFolder templateFolder = DLFolderServiceUtil.getFolder(folderId);
                List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getDLFileEntries(0, DLFileEntryLocalServiceUtil.getDLFileEntriesCount());//getFileEntries(getThemeDisplay().getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);//.getFileEntries(templateFolder.getRepositoryId(), folderId);
//                           List<FileEntry> files = DLAppServiceUtil.getGroupFileEntries(getThemeDisplay().getParentGroupId(), getThemeDisplay().getUserId(), 0, DLAppServiceUtil.getGroupFileEntriesCount(getThemeDisplay().getParentGroupId(), getThemeDisplay().getUserId()));//.getFileEntries(templateFolder.getRepositoryId(), folderId);
                for (DLFileEntry fil : files) {
                    FileEntry newsletterTemplate = DLAppServiceUtil.getFileEntry(fil.getFileEntryId());
                    if (newsletterTemplate.getMimeType().equals("text/html")) {
                        templateList.add(newsletterTemplate);
                    }
                }
            } catch (PortalException ex) {
                Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
                logger.error(ex);
            }
        }
        return templateList;
    }

    public void setTemplateList(List<FileEntry> templateList) {
        this.templateList = templateList;
    }

    public List<JournalArticle> getWebContentList() {
        try {
            if (webContentList == null) {
                webContentList = new ArrayList<JournalArticle>();
                if (elem.isNew()) {
                    List<JournalArticle> artList = JournalArticleLocalServiceUtil.getArticles();
                    for (JournalArticle art : artList) {
                        try {
                            if (JournalArticleLocalServiceUtil.isLatestVersion(getThemeDisplay().getScopeGroupId(), art.getArticleId(), art.getVersion())) {
                                webContentList.add(art);
                            }
                        } catch (PortalException ex) {
                            Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    webContentList = JournalArticleLocalServiceUtil.getArticles();
                }

//            JournalArticle teszt;
//            teszt.getVersion();    
            }
            return webContentList;
        } catch (SystemException ex) {
            Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setWebContentList(List<JournalArticle> webContentList) {
        this.webContentList = webContentList;
    }

    public void canSetWc() {
        updateWc = true;
    }

    public void canSetTemplate() {
        updateTemplate = true;
    }

    public FileEntry getSelectedTemplate() {
        if (!elem.isNew() && !updateWc) {
            try {
                selectedTemplate = DLAppServiceUtil.getFileEntry(Long.parseLong(getElem().getTemplateId()));
            } catch (PortalException ex) {
                Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return selectedTemplate;
    }

    public void setSelectedTemplate(FileEntry selectedTemplate) {
        this.selectedTemplate = selectedTemplate;
    }

    public JournalArticle getSelectedWc() {
        if (!elem.isNew() && !updateWc) {
            try {
                selectedWc = getElem().getJournalArticle(getThemeDisplay());
            } catch (PortalException ex) {
                Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SystemException ex) {
                Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return selectedWc;
    }

    public void setSelectedWc(JournalArticle selectedWc) {
        this.selectedWc = selectedWc;
    }

    @Override
    public void initController() {
        super.initController();
        initCategoryLocale();
        initCategoriesModel();
        getWebContentList();
        initChildModel();
    }

    public void initCategoryLocale() {
        if (categoryLocale == null) {

            if (!getElem().isNew()) {
                try {
                    List<Category> userCategories = getElem().getCategories();
                    if (ListUtil.isNotEmpty(userCategories)) {
                        Category category = userCategories.get(0);
                        categoryLocale = category.getLocale();
                    }
                } catch (Exception e) {
                    logger.error(e);
                }
            }

            if (categoryLocale == null) {
                categoryLocale = LiferayUtil.getLiferayFullLangCode();
            }


            //logger.info("initCategoryLocale {0}", new Object[]{categoryLocale});
        }
    }

    public void initCategoriesModel() {
        //logger.info("initCategoriesModel: {0}", new Object[]{categoriesModel});

        if (categoriesModel == null) {
            categoriesModel = new DualListModel<Category>();

            List<Category> source = new ArrayList<Category>();
            List<Category> target = new ArrayList<Category>();

            try {
                List<Category> allCategories = CategoryLocalServiceUtil.findByLocale(getCategoryLocale());
                source.addAll(allCategories);

                if (!getElem().isNew()) {
                    List<Category> userCategories = getElem().getCategories();
                    source.removeAll(userCategories);
                    target.addAll(userCategories);
                }

            } catch (Exception e) {
                logger.error(e);
                addErrorMessage(e);
            }

            categoriesModel.setSource(source);
            categoriesModel.setTarget(target);
        }
    }

    public void initChildModel() {
        //logger.info("initChildModel");

        if (childModel == null) {
            List<NewsletterListElem> elems = new ArrayList<NewsletterListElem>();

            if (!getElem().isNew()) {
                Long parentNewsletterId = getElem().getNewsletterId();

                //logger.info("parentNewsletterId: {0}", new Object[]{parentNewsletterId});

                try {
                    List<Newsletter> newsletters = NewsletterLocalServiceUtil.findByParentId(parentNewsletterId);
                    //logger.info("child newsletters: {0}", new Object[]{newsletters});

                    for (Newsletter newsletter : newsletters) {
                        Long newsletterId = newsletter.getNewsletterId();
                        String subject = newsletter.getSubject();
                        String sender = newsletter.getSender();
                        Date creationDate = newsletter.getCreationTime();
                        elems.add(new NewsletterListElem(newsletterId, subject, sender, null, creationDate));
                    }
                } catch (SystemException ex) {
                    logger.error(ex);
                    addErrorMessage(ex);
                }

            }

            childModel = new NewsletterListElemDataModel(elems);
        }
    }

    public void resetController() {
        id = null;
        elem = null;
        categoriesModel = null;
        webContentList = null;
        childModel = null;
        selectedWc = null;
        updateWc = false;
        updateTemplate = false;
        templateList = null;
        selectedTemplate = null;
        userList = null;
        testEmail = null;
        categoryLocale = null;
        tags = null;
        selectedTags = null;
        labelStr = null;
    }

    private void resetChildModel() {
        setChildModel(null);
    }

    public NewsletterListElemDataModel getChildModel() {
        return childModel;
    }

    public void setChildModel(NewsletterListElemDataModel childModel) {
        this.childModel = childModel;
    }

    public DualListModel<Category> getCategoriesModel() {
        return categoriesModel;
    }

    public void setCategoriesModel(DualListModel<Category> categoriesModel) {
        this.categoriesModel = categoriesModel;
    }

    private void resetCategoriesModel() {
        setCategoriesModel(null);
    }

    @Override
    public Newsletter initElem() throws Exception {
        Newsletter newsletter = NewsletterLocalServiceUtil.getNewsletter((Long) getId());

        return newsletter;
    }

    @Override
    public Newsletter initNewElem() {
        Newsletter newsletter = new NewsletterImpl();

        return newsletter;
    }

    @Override
    protected Newsletter persist() throws SystemException {
        return newsletterSave();
    }

    @Override
    protected Newsletter update() throws SystemException {
        return newsletterSave();
    }

    public Newsletter newsletterSave() throws SystemException {
        getElem().setCategories(getCategoriesModel().getTarget());
        getElem().setContentId(String.valueOf(selectedWc.getArticleId()));
        getElem().setContentVersion(String.valueOf(selectedWc.getVersion()));
        getElem().setTemplateId(String.valueOf(selectedTemplate.getFileEntryId()));
        getElem().setTemplateVersion(String.valueOf(selectedTemplate.getVersion()));

        return NewsletterLocalServiceUtil.save(getElem());
    }

    public String getTitle(JournalArticle jA) {
        return jA.getTitle(getThemeDisplay().getLocale());
    }

    public void send() {
        // TODO: persisted check
        // TODO: change check

        resetChildModel();

        Newsletter newsletter = null;
        try {
            newsletter = getElem().getChild();
            newsletter.setCreationTime(DateUtil.getCurrentDate());
            newsletter = NewsletterLocalServiceUtil.saveChild(newsletter);

            List<Recipient> recipientsSaver = newsletter.getRecipients();
            NewsletterSenderList recipients = new NewsletterSenderList(newsletter);

            NewsletterSender newsletterSender = new NewsletterSender(newsletter, recipients, getThemeDisplay());
            newsletterSender.send();
        } catch (Exception e) {
            logger.error(e);
            addErrorMessage(e);
            return;
        }

        addSuccessMessage(SENDING_SUCCESS);
    }

    public void sendTest() {
        // TODO: persisted check
        // TODO: change check

        resetChildModel();

        Newsletter newsletter = null;
        try {
            if (testEmail != null && !testEmail.equals("")) {
                newsletter = getElem().getChild();
                newsletter.setCreationTime(DateUtil.getCurrentDate());
                //newsletter = NewsletterLocalServiceUtil.saveChild(newsletter);

                // List<Recipient> recipientsSaver = newsletter.getRecipients();
                NewsletterSenderList recipients = new NewsletterSenderList(newsletter, testEmail);
                NewsletterSender newsletterSender = new NewsletterSender(newsletter, recipients, getThemeDisplay());
                newsletterSender.send();
            }
        } catch (Exception e) {
            logger.error(e);
            addErrorMessage(e);
            return;
        }

        addSuccessMessage(SENDING_SUCCESS);
    }

    public void viewNewsletterInContent(long newsletterId) {
        try {
            FacesContext fcontext = FacesContext.getCurrentInstance();
            PortletResponse portletResponse = (PortletResponse) fcontext.getExternalContext().getResponse();
            HttpServletResponse response = PortalUtil.getHttpServletResponse(portletResponse);
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            response.setHeader("content-disposition; charset=utf-8", "inline");
            response.flushBuffer();
            ServletOutputStream out = response.getOutputStream();

            Newsletter newsletter = null;
            try {
                newsletter = NewsletterLocalServiceUtil.getNewsletter(newsletterId);
                JournalArticle journalArticle = newsletter.getJournalArticle(getThemeDisplay());
                String content = getArticleContent(journalArticle, getThemeDisplay().getLanguageId(), newsletter);
//                System.out.println("content:" + content);
//                System.out.println("journalArticle" + journalArticle.getVersion());
                byte[] teszt = content.getBytes();
                out.write(teszt);

            } catch (Exception ex) {
                Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
            }

            out.flush();
            fcontext.responseComplete();
        } catch (IOException ex) {
            Logger.getLogger(NewsletterEditController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getArticleContent(JournalArticle article, String locale, Newsletter newsletter) throws Exception {
        try {
            String articleMultiLanguageXMLContent = article.getContent();
            String templateContent;
            FileEntry newsletterTemplate = DLAppServiceUtil.getFileEntry(Long.parseLong(getElem().getChild().getTemplateId()));
            templateContent = Tools.InputStream2Str(newsletterTemplate.getContentStream(), false);
            String localizedContent = templateContent.replace("###CONTENT###", JournalContentUtil.getContent(article.getGroupId(), article.getArticleId(), null, locale, articleMultiLanguageXMLContent));
            localizedContent = localizedContent.replace("###sendDate###", DateUtil.dateToString(newsletter.getCreationTime(), "yyyy.MM.dd", getThemeDisplay().getLocale()));
//            System.out.println(newsletter.getCreationTime());
            localizedContent = localizedContent.replace("###newsletterTitle###", article.getTitle(locale));
            localizedContent = localizedContent.replaceAll("<img alt=\"\" src=\"\\/documents", "<img alt=\"\" src=\"" + getThemeDisplay().getURLPortal() + "\\/documents");
            return localizedContent;
        } catch (Exception ex) {
            logger.error(ex);
            return "";
        }
    }

    public Locale[] getAvailableLocales() {
        return LiferayUtil.getAvailableLocales();
    }

    public void onCategoryLocaleChange() {
        //logger.info("onCategoryLocaleChange");

        getElem().setCategories(new ArrayList<Category>());
        resetCategoriesModel();

        resetPickList();
    }

    public void resetPickList() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        UIViewRoot viewRoot = facesContext.getViewRoot();
        PartialViewContext partialViewContext = facesContext.getPartialViewContext();
        Collection<String> renderIds = partialViewContext.getRenderIds();

        for (String renderId : renderIds) {
            try {
                UIComponent component = viewRoot.findComponent(renderId);
                if (component instanceof PickList) {
                    PickList pickList = (PickList) component;
                    pickList.resetValue();
                }
            } catch (Exception e) {
                logger.error(e);
            }

            //logger.info("{0} {1}", new Object[]{renderId, component});
        }
    }
}
