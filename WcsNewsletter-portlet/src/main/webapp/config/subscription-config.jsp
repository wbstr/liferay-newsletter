<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="javax.sound.midi.Soundbank"%>
<%@ taglib uri="http://java.sun.com/portlet" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %> 
<%@page import="com.liferay.portal.kernel.util.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.service.ImageServiceUtil"%>
<%@page import="com.liferay.portal.service.ImageServiceWrapper"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.persistence.DLFolderUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.persistence.DLFolderFinderUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>

<%@page import="com.liferay.portlet.documentlibrary.service.DLAppServiceUtil"%>

<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<%@ page import="com.liferay.portlet.documentlibrary.model.*"%>
<%@ page import="com.liferay.portlet.documentlibrary.service.*"%>
<%@ page import="com.liferay.portal.kernel.repository.model.*"%>

<%@ page import="java.util.List"%>


<%
    PortletPreferences preferences = renderRequest.getPreferences();

    String portletResource = ParamUtil.getString(request, "portletResource");

    if (Validator.isNotNull(portletResource)) {
        preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
    }
    String newsletterEmail = GetterUtil.getString(preferences.getValue("newsletterEmail", StringPool.BLANK));  
    long selectedEmail=0;
    if (Validator.isNotNull(newsletterEmail)) {
        selectedEmail = Long.parseLong(newsletterEmail);
    }
    List<FileEntry> templateList = new ArrayList<FileEntry>();
            long galleryRootFolder = 0;
                long folderId = galleryRootFolder;//folder id of parent folder inside which you place  your image or sub folders(get this id from database //table)
//                DLFolder templateFolder = DLFolderServiceUtil.getFolder(folderId);
//                List<FileEntry> files = DLAppServiceUtil.getGroupFileEntries(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), 0, DLAppServiceUtil.getGroupFileEntriesCount(themeDisplay.getScopeGroupId(), themeDisplay.getUserId()));//.getFileEntries(templateFolder.getRepositoryId(), folderId);
                List<DLFileEntry> files = DLFileEntryLocalServiceUtil.getDLFileEntries(0, DLFileEntryLocalServiceUtil.getDLFileEntriesCount());
                for (DLFileEntry fil : files) {
                    FileEntry newsletterTemplate = DLAppServiceUtil.getFileEntry(fil.getFileEntryId());
                    if (newsletterTemplate.getMimeType().equals("text/html")) {
                        templateList.add(newsletterTemplate);
                    }
                }
%>
<form action="<liferay-portlet:actionURL portletConfiguration="true" />"
      method="post" name="<portlet:namespace />fm">
    <input name="<portlet:namespace /><%= Constants.CMD%>" type="hidden" value="<%= Constants.UPDATE%>" />
 <label for="<portlet:namespace />newsletterEmail" >Notification email:</label>
    <select name="<portlet:namespace />newsletterEmail">
        <%
            for (FileEntry fF: templateList) {
        %>
        <%  if (fF.getFileEntryId() == selectedEmail) {%>
        <option selected="selected" title="<%=fF.getTitle()%>" value="<%= fF.getFileEntryId()%>"><%=fF.getTitle()%></option>
        <%} else {%>
        <option title="<%=fF.getTitle()%>" value="<%= fF.getFileEntryId()%>"><%=fF.getTitle()%></option>
        <%}%>
        <%
            }
        %>
    </select><br />  
    <br />
    <input type="button" value="<liferay-ui:message key="save" />"
           onClick="submitForm(document.<portlet:namespace />fm);" />
</form>
