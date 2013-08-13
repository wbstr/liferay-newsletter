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

import com.liferay.portal.model.BaseModel;
import com.wcs.newsletter.util.BundleKeysConst;

public abstract class AbstractEditController<E extends BaseModel, I> extends AbstractController {

    protected I id;
    protected E elem;

    public E getElem() {
        return elem;
    }

    public void setElem(E elem) {
        this.elem = elem;
    }

    public void save() {
        System.out.println("save");
        E elem = null;

        try {
            if (getElem().isNew()) {
                elem = persist();
            } else {
                elem = update();
            }

            if (elem == null) {
                addErrorMessage(BundleKeysConst.General.SAVE_ERROR);
            } else {
                setElem(elem);
                addSuccessMessage(BundleKeysConst.General.SAVE_SUCCESS);
            }

        } catch (Exception ex) {
            addErrorMessage(ex);
            logger.error(ex);
        }
    }

    @Override
    public void initController() {
        initElemByParam();
    }

    public void initElemByParam() {
        if (elem != null) {
            return;
        }
        
        E elem = null;

        try {
            if (isNew()) {
                elem = initNewElem();
                elem.setNew(true);
            } else {
                elem = initElem();
            }
        } catch (Exception ex) {
            addErrorMessage(ex);

            logger.error(ex);
        }

        if (elem == null) {
            addErrorMessage(BundleKeysConst.General.INIT_ERROR);
        }

        setElem(elem);
    }
    
    protected I getId(){
        return id;
    }

    protected void setId(I id) {
        this.id = id;
    }

    public boolean isNew() {
        return getId() == null;
    }

    public abstract E initElem() throws Exception;

    public abstract E initNewElem();

    protected abstract E persist() throws Exception;

    protected abstract E update() throws Exception;
}
