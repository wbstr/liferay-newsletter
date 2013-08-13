package com.wcs.newsletter.service.impl;

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
import com.wcs.newsletter.model.Label;
import com.wcs.newsletter.service.base.LabelLocalServiceBaseImpl;
import com.wcs.newsletter.service.persistence.LabelUtil;
import com.wcs.tool.ListUtil;
import java.util.List;

public class LabelLocalServiceImpl extends LabelLocalServiceBaseImpl {

    public Label findByTagId(long tagId) throws SystemException {
        List<Label> labels = LabelUtil.findByTagId(tagId);
        
        Label label = null;
        if (ListUtil.isNotEmpty(labels)) {
            label = labels.get(0);
        }
        
        return label;
    }    
    
}
