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

import com.wcs.newsletter.model.Subscription;
import com.wcs.tool.StringUtil;
import java.io.Serializable;
import java.util.Date;

public class SubscriptionListElem implements ModelElem, Serializable {

    private Subscription subscription;
    private Long categoryCount;

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    public SubscriptionListElem(Subscription subscription, Long categoryCount) {
        this.subscription = subscription;
        this.categoryCount = categoryCount;
    }

    public Long getId() {
        return subscription.getSubscriptionId();
    }
    
    public String getName() {
        return subscription.getUserName();
    }

    public String getEmail() {
        return subscription.getEmailString();
    }
    
    public Date getSubscriptionDate() {
        return subscription.getSubscriptionDate();
    }

    public Long getCategoryCount() {
        return categoryCount;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.subscription != null ? this.subscription.hashCode() : 0);
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
        final SubscriptionListElem other = (SubscriptionListElem) obj;
        if (this.subscription != other.subscription && (this.subscription == null || !this.subscription.equals(other.subscription))) {
            return false;
        }
        return true;
    }

    public String getRowKey() {
        return StringUtil.toString(getId());
    }
    
}
