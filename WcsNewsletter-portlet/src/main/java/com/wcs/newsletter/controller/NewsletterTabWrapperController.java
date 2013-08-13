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

import com.wcs.newsletter.dto.NewsletterListElem;
import com.wcs.newsletter.util.JsfUtil;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author csaba
 */
@ManagedBean
@ViewScoped
public class NewsletterTabWrapperController implements Serializable {

    private boolean editView;

    public boolean isEditView() {
        return editView;
    }

    public void setEditView(boolean editView) {
        this.editView = editView;
    }

    public void createNewsletter() {
        NewsletterEditController nEC = (NewsletterEditController) JsfUtil.getManagedBean("newsletterEditController", FacesContext.getCurrentInstance());
        nEC.resetController();
        nEC.initController();
        editView = true;
    }

    public void editNewsletter(NewsletterListElem newsletter) {
        try {
            NewsletterEditController nEC = (NewsletterEditController) JsfUtil.getManagedBean("newsletterEditController", FacesContext.getCurrentInstance());
            nEC.resetController();
            nEC.setId(newsletter.getNewsletterId());
            nEC.initController();
            editView = true;
        } catch (Exception ex) {
            Logger.getLogger(NewsletterTabWrapperController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void backToList() {
        NewsletterListController nLC = (NewsletterListController) JsfUtil.getManagedBean("newsletterListController", FacesContext.getCurrentInstance());
        nLC.resetController();
        nLC.initController();
        editView = false;
    }
}
