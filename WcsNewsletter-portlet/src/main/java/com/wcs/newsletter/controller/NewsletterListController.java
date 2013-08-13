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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.wcs.newsletter.comparator.AssetTagComparator;
import com.wcs.newsletter.dto.NewsletterListElem;
import com.wcs.newsletter.dto.NewsletterListElemDataModel;
import com.wcs.newsletter.model.Label;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.service.NewsletterLocalServiceUtil;
import com.wcs.newsletter.util.LiferayUtil;
import com.wcs.tool.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class NewsletterListController extends AbstractListController<NewsletterListElem, NewsletterListElemDataModel> {

    private Map<Long, AssetTag> tagsMap;
    private boolean isListView;

    public boolean isIsListView() {
        return isListView;
    }

    public void setIsListView(boolean isListView) {
        this.isListView = isListView;
    }

    @Override
    protected void init() {
        initModel();
    }

    public void resetController() {
        model = null;
    }

    public void initModel() {
        if (model == null) {
            List<NewsletterListElem> elems = new ArrayList<NewsletterListElem>();

            try {
                List<Newsletter> newsletters = NewsletterLocalServiceUtil.getNewsletters(0, NewsletterLocalServiceUtil.getNewslettersCount());
                for (Newsletter newsletter : newsletters) {
                    if (!newsletter.isRoot()) {
                        continue;
                    }
                    long newsletterId = newsletter.getNewsletterId();
                    String subject = newsletter.getSubject();
                    String sender = newsletter.getSender();
                    Date creationDate = null;
                    String tags = getTags(newsletter);
                    List<Newsletter> childNws = NewsletterLocalServiceUtil.findByParentId(newsletter.getNewsletterId());
                    if (childNws.size() > 0) {
                        creationDate = childNws.get(childNws.size()-1).getCreationTime();
                    }
                    elems.add(new NewsletterListElem(newsletterId, subject, sender, tags, creationDate));
                }
            } catch (Exception ex) {
                logger.error(ex);
                addErrorMessage(ex);
            }

            model = new NewsletterListElemDataModel(elems);
            isListView = true;
        }
    }

    private Map<Long, AssetTag> getTagsMap() {
        if (tagsMap == null) {
            tagsMap = new HashMap<Long, AssetTag>();

            List<AssetTag> tags = null;

            try {
                tags = AssetTagLocalServiceUtil.getAssetTags(0, AssetTagLocalServiceUtil.getAssetTagsCount());
            } catch (Exception e) {
                logger.error(e);
            }

            if (tags == null) {
                tags = new ArrayList<AssetTag>();
            }

            for (AssetTag assetTag : tags) {
                tagsMap.put(assetTag.getTagId(), assetTag);
            }
        }

        return tagsMap;
    }

    private List<AssetTag> getAssetTags(Newsletter newsletter) throws SystemException {
        List<AssetTag> assetTags = new ArrayList<AssetTag>();

        if (newsletter == null) {
            return assetTags;
        }

        List<Label> labels = newsletter.getLabels();
        for (Label label : labels) {
            Long tagId = label.getTagId();
            AssetTag assetTag = getTagsMap().get(tagId);
            if (assetTag != null) {
                assetTags.add(assetTag);
            }
        }

        Locale locale = LiferayUtil.getThemeDisplay().getLocale();
        Collections.sort(assetTags, new AssetTagComparator(locale));

        return assetTags;
    }

    private String getTags(Newsletter newsletter) throws SystemException {
        List<String> tagNames = new ArrayList<String>();

        List<AssetTag> assetTags = getAssetTags(newsletter);
        for (AssetTag assetTag : assetTags) {
            tagNames.add(assetTag.getName());
        }

        return StringUtil.toCSV(tagNames);
    }

    @Override
    public String edit(NewsletterListElem elem) {
        return getNavigationController().navigateToNewsletterEdit(elem.getNewsletterId());
    }

    @Override
    public String create() {
        return getNavigationController().navigateToNewsletterCreate();
    }

    @Override
    public void delete(NewsletterListElem elem) throws Exception {
        Long id = elem.getNewsletterId();
        NewsletterLocalServiceUtil.deleteNewsletter(id);
    }
}
