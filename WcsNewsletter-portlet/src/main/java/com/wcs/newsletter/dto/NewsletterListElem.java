package com.wcs.newsletter.dto;

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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.wcs.newsletter.model.Newsletter;
import com.wcs.newsletter.service.NewsletterLocalServiceUtil;
import com.wcs.tool.DateUtil;
import com.wcs.tool.StringUtil;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NewsletterListElem implements ModelElem, Serializable {

    private long newsletterId;
    private String subject;
    private String sender;
    private String tags;
    private Date creationDate;
    private Newsletter newsletter;

    public NewsletterListElem(long newsletterId, String subject, String sender, String tags, Date creationDate) {

        this.newsletterId = newsletterId;
        this.subject = subject;
        this.sender = sender;
        this.tags = StringUtil.toString(tags);
        this.creationDate = creationDate;
        try {
            List<Newsletter> childList =  NewsletterLocalServiceUtil.findByParentId(newsletterId);
            if(childList.size()>0){
                this.newsletter = childList.get(childList.size()-1);
            }
        } catch (SystemException ex) {
            Logger.getLogger(NewsletterListElem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Newsletter getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Newsletter newsletter) {
        this.newsletter = newsletter;
    }

    public long getNewsletterId() {
        return newsletterId;
    }

    public String getSubject() {
        return subject;
    }

    public String getSender() {
        return sender;
    }

    public String getCreationDate() {
        return DateUtil.dateToStringSecLevel(creationDate);
    }

    public String getRowKey() {
        return StringUtil.toString(newsletterId);
    }

    public String getTags() {
        return tags;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.newsletterId ^ (this.newsletterId >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NewsletterListElem other = (NewsletterListElem) obj;
        if (this.newsletterId != other.newsletterId) {
            return false;
        }
        return true;
    }
}
