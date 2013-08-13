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

import com.wcs.newsletter.dto.AbstractDataModel;
import com.wcs.newsletter.util.BundleKeysConst;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractListController<E, M extends AbstractDataModel> extends AbstractController {

    protected M model;
    protected E[] selectedElems;      
    
    @Override
    public void initController() {
        init();
    }

    protected abstract void init();    
    public abstract String edit(E elem);
    public abstract String create();
    public abstract void delete(E elem) throws Exception;

    public M getModel() {
        return model;
    }
    
    public void setModel(M model) {
        this.model = model;
    }

    public E[] getSelectedElems() {
        return selectedElems;
    }

    public void setSelectedElems(E[] selectedElems) {
        this.selectedElems = selectedElems;
    }
    
    public void delete() {
        logger.info("delete");
        
        if (selectedElems == null) {
            logger.info("no selectedElems");
            return;
        }
        
        List<E> deletedElems = new ArrayList<E>();
        
        try {
            for (int i = 0; i < selectedElems.length; i++) {
                E e = selectedElems[i];
                delete(e);
                deletedElems.add(e);
            }
            addSuccessMessage(BundleKeysConst.General.DELETE_SUCCESS);
        } catch (Exception e) {
            logger.error(e);
            addErrorMessage(e, BundleKeysConst.General.DELETE_ERROR);
        }
        
        try {
            List<E> wrappedData = (List<E>) model.getWrappedData();
            wrappedData.removeAll(deletedElems);            
        } catch (Exception e) {
            logger.error(e);
        }

    }

}
