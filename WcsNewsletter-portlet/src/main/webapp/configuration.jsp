<%--
	configuration.jsp: configuration page for 
	the newsletter-admin portlet.
	
	Created: 	2014-06-24 22:16 by Christian Berndt
	Modified:	2014-06-24 22:16 by Christian Berndt
	Version: 	1.0
	
--%>

<%-- Import required classes. --%>
<%-- <%@ page import="java.util.List"%> --%>

<%@ page import="javax.portlet.PortletPreferences"%>

<%@ page import="com.liferay.faces.util.portal.WebKeys"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ page import="com.liferay.portal.kernel.util.Validator"%>
<%@ page import="com.liferay.portal.kernel.util.PrefsParamUtil"%>
<%-- <%@ page import="com.liferay.portlet.dynamicdatamapping.model.DDMStructure"%> --%>
<%-- <%@ page import="com.liferay.portlet.dynamicdatamapping.service.DDMStructureServiceUtil"%> --%>
<%@ page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>

<%-- Import required taglibs --%>
<%@ taglib prefix="aui" uri="http://alloy.liferay.com/tld/aui"%>
<%@ taglib prefix="liferay-portlet" uri="http://liferay.com/tld/portlet"%>
<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/ui"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet_2_0"%>

<%-- Enable the JSR 286 portlet variables,    --%>
<%-- e.g. renderRequest, portletConfig etc.   --%>
<%-- For the full list of available variables --%>
<%-- see the JSR 286 specification.           --%>
<portlet:defineObjects />


<%
	PortletPreferences preferences = renderRequest.getPreferences();

	String portletResource = ParamUtil.getString(request,
			"portletResource");

	if (Validator.isNotNull(portletResource)) {

		preferences = PortletPreferencesFactoryUtil.getPortletSetup(
				request, portletResource);
	}
	
	String templateId = PrefsParamUtil.getString(preferences,
			renderRequest, "templateId");
	
//  ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(
//                 WebKeys.THEME_DISPLAY);
    
// 	long companyId = themeDisplay.getCompanyId(); 
	
	
// 	List<DDMStructure> structures =  DDMStructureServiceUtil.search(companyId, groupIds, classNameIds, keywords, start, end, orderByComparator); 
%>

<%-- Compose the renderURL --%>
<liferay-portlet:renderURL portletConfiguration="true" var="portletURL" />

<%-- Compose the configurationURL --%>
<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationURL" />

<%-- Edit the calendar-to-article portlet configuration. --%>
<aui:form action="<%=configurationURL%>">

	<%-- cmd is required when using --%>
	<%-- DefaultConfigurationAction --%>
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />

	<aui:fieldset>

		<aui:input name="templateId" value="<%= templateId %>"
			help-message="configuration-template-id-help" />

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>

</aui:form>
