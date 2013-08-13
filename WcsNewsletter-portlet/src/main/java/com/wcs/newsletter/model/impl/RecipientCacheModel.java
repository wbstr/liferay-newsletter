package com.wcs.newsletter.model.impl;

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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.wcs.newsletter.model.Recipient;

import java.io.Serializable;

/**
 * The cache model class for representing Recipient in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Recipient
 * @generated
 */
public class RecipientCacheModel implements CacheModel<Recipient>, Serializable {
    public long recipientId;
    public long newsletterId;
    public String email;
    public String status;
    public String errorMessage;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{recipientId=");
        sb.append(recipientId);
        sb.append(", newsletterId=");
        sb.append(newsletterId);
        sb.append(", email=");
        sb.append(email);
        sb.append(", status=");
        sb.append(status);
        sb.append(", errorMessage=");
        sb.append(errorMessage);
        sb.append("}");

        return sb.toString();
    }

    public Recipient toEntityModel() {
        RecipientImpl recipientImpl = new RecipientImpl();

        recipientImpl.setRecipientId(recipientId);
        recipientImpl.setNewsletterId(newsletterId);

        if (email == null) {
            recipientImpl.setEmail(StringPool.BLANK);
        } else {
            recipientImpl.setEmail(email);
        }

        if (status == null) {
            recipientImpl.setStatus(StringPool.BLANK);
        } else {
            recipientImpl.setStatus(status);
        }

        if (errorMessage == null) {
            recipientImpl.setErrorMessage(StringPool.BLANK);
        } else {
            recipientImpl.setErrorMessage(errorMessage);
        }

        recipientImpl.resetOriginalValues();

        return recipientImpl;
    }
}
