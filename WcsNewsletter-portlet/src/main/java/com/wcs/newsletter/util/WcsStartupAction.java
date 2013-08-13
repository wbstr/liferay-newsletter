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
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author csaba
 */
public class WcsStartupAction extends SimpleAction {

    @Override
    public void run(String[] strings) throws ActionException {
//        System.out.println("ottfutababakocsi");
//        try {
//            
////            long id = CounterLocalServiceUtil.increment();
////            ThemeDisplay themeDisplay = LiferayUtil.getThemeDisplay();
////            DLFolder folder = DLFolderLocalServiceUtil.createDLFolder(id);
////            folder.setName("Webstar-Newsletter");
////            folder.setParentFolderId(0);
////            folder.setDescription("folder test");
////            folder.setGroupId(themeDisplay.getScopeGroupId());
////            folder.setCompanyId(themeDisplay.getCompanyId());
////            folder.setUserId(themeDisplay.getDefaultUserId());
////            Date allDate = new Date();
////            folder.setCreateDate(allDate);
////            folder.setModifiedDate(allDate);
////            folder.setLastPostDate(allDate);
////            folder = DLFolderLocalServiceUtil.addDLFolder(folder);
////            System.out.println("folderForUs:" + folder);
//        } catch (PortalException ex) {
//            Logger.getLogger(WcsStartupAction.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SystemException ex) {
//            Logger.getLogger(WcsStartupAction.class.getName()).log(Level.SEVERE, null, ex);
//        }


    }
}
