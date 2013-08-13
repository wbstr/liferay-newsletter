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

import com.wcs.tool.StringUtil;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;

public abstract class AbstractDataModel<M extends ModelElem> extends ListDataModel<M> implements SelectableDataModel<M>, Serializable {

    protected static final Logger logger = Logger.getLogger(AbstractDataModel.class.getName());
    
    public AbstractDataModel(List<M> list) {
        super(list);
    }

    @Override
    public Object getRowKey(M modelElem) {
        if (modelElem == null) {
            return null;
        }
        
        Object rowKey = modelElem.getRowKey();
        
        return rowKey;
    }

    @Override
    public M getRowData(String rowKey) {
        if (StringUtil.isEmpty(rowKey)) {
            return null;
        }
        
        List<M> modelElemek = (List<M>) getWrappedData();
        for (M modelElem : modelElemek) {
            if (rowKey.equals(getRowKey(modelElem))) {
                return modelElem;
            }
        }
        
        return null;
    }

    @Override
    public Object getWrappedData() {
        return super.getWrappedData();
    }

}
