package com.wcs.newsletter.util;

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

import com.wcs.misc.AbstractHasId;
import com.wcs.misc.HasId;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.PartialViewContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;

public class JsfUtil {

    public static void resetForm(String formId) {
        resetValueTree((UIForm) FacesContext.getCurrentInstance().getViewRoot().findComponent(formId));
    }

    public static void resetForm(final UIForm form) {
        resetValueTree(form);
    }

    private static void resetValueTree(final UIComponent component) {
        if (component == null) {
            return; //hiba elnyelése
        }
        if (component instanceof UIInput) {
            UIInput input = (UIInput) component;
            input.resetValue();
        } else {
            for (UIComponent child : component.getChildren()) {
                resetValueTree(child);
            }
        }
    }
    
    public static Object findInputComponentValue(UIComponent component, String componentId) {
        UIForm form = findParentForm(component);
        if (form == null) {
            throw new ValidatorException(new FacesMessage("Couldn't find parent form for field: " + component.getClientId()));
        }
        UIComponent otherComponent = form.findComponent(componentId);
        if (otherComponent == null) {
            throw new ValidatorException(new FacesMessage(String.format("Field '%s' not found in '%s' form.", componentId, form)));
        }
        if (!(otherComponent instanceof UIInput)) {
            throw new IllegalArgumentException(String.format("%s is not an input field", componentId));
        }
        
        return ((UIInput) otherComponent).getSubmittedValue();
    }

    public static UIForm findParentForm(UIComponent component) {
        UIComponent c = component;
        while (c != null) {
            c = c.getParent();
            if (c instanceof UIForm) {
                return (UIForm) c;
            }
        }
        return null;
    }

    public static void addPartialViewRender(String id) {
        PartialViewContext pcontext = FacesContext.getCurrentInstance().getPartialViewContext();
        if (pcontext != null) {
            pcontext.getRenderIds().add(id);
        }
    }

    public static Object getManagedBean(String name) {
        return getManagedBean(name, FacesContext.getCurrentInstance());
    }

    public static Object getManagedBean(String name, FacesContext context) {
        return context.getApplication().getELResolver().
                getValue(context.getELContext(), null, name);
    }

    public static SelectItem[] getSelectItems(List<?> entities, boolean selectOne) {
        int size = selectOne ? entities.size() + 1 : entities.size();
        SelectItem[] items = new SelectItem[size];
        int i = 0;
        if (selectOne) {
            items[0] = new SelectItem("", "---");
            i++;
        }
        for (Object x : entities) {
            items[i++] = new SelectItem(x, x.toString());
        }
        return items;
    }

    public static void addFatalMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addFatalMessage(String summary, String detail) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addWarningMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addWarningMessage(String summary, String detail) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addErrorMessage(Exception ex, String defaultMsg) {
        String msg = ex.getLocalizedMessage();
        if (msg != null && msg.length() > 0) {
            addErrorMessage(msg);
        } else {
            addErrorMessage(defaultMsg);
        }
    }

    public static void addErrorMessages(List<String> messages) {
        for (String message : messages) {
            addErrorMessage(message);
        }
    }

    public static void addErrorMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addErrorMessage(String summary, String detail) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String msg) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static void addSuccessMessage(String summary, String detail) {
        FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, facesMsg);
    }

    public static String getRequestParameter(String key) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(key);
    }

    public static Object getObjectFromRequestParameter(String requestParameterName, Converter converter, UIComponent component) {
        String theId = JsfUtil.getRequestParameter(requestParameterName);
        return converter.getAsObject(FacesContext.getCurrentInstance(), component, theId);
    }

    public static <T extends AbstractHasId<Long>> Long getNegativeMinId(List<T> hasIdList) {
        Long minId = -1L;
        for (AbstractHasId<Long> actual : hasIdList) {
            if (actual.getId() < minId) {
                minId = actual.getId();
            }
        }
        return minId;
    }

    public static <T extends AbstractHasId<Long>> Long getNextNegativId(List<T> hasIdList) {
        Long minId = JsfUtil.getNegativeMinId(hasIdList);
        return --minId;
    }
    
    public static <ID extends Number, T extends HasId<ID>> ID getMinNegativeId(List<T> hasIdList) {
        ID minId = null;
        long minLong = -1;
        for (HasId<ID> actual : hasIdList) {         
            ID actualId = actual.getId();
            if (actualId.longValue() < minLong) {
                minId = actualId;
                minLong = actualId.longValue();
            }
        }
        return minId;
    }

    public static String getApplicationUrl(ExternalContext externalContext) {
        StringBuilder path = new StringBuilder();
        path.append(externalContext.getRequestScheme());
        path.append("://");
        path.append(externalContext.getRequestServerName());
        path.append(":");
        path.append(externalContext.getRequestServerPort());
        path.append(externalContext.getRequestContextPath());
        return path.toString();
    }
    
    public static void addErrorMessageByKey(String key) {
        String msg = AppMessageBundle.getString(key);
        addErrorMessage(msg);
    }

    public static void addSuccessMessageByKey(String key) {
        String msg = AppMessageBundle.getString(key);
        addSuccessMessage(msg);
    }            
    
    public static void addWarningMessageByKey(String key) {
        String msg = AppMessageBundle.getString(key);
        addWarningMessage(msg);
    }      
}
