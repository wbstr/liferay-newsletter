liferay-newsletter
==================

To build the project you need to call mvn liferay:build-service before mvn package.


If yout want to add this portlet to your theme, you must add the following lines to your portal-ext.properties:
portlet.add.default.resource.check.enabled=true
portlet.add.default.resource.check.whitelist=3,56_INSTANCE_0000,58,82,86,87,88,103,113,145,164,166,170,177,webstarnewslettersubscriptionjquery_WAR_WcsNewsletterportlet,webstarnewslettersubscription_WAR_WcsNewsletterportlet

You can add the subscription portlet to your theme by the following line (for example to your portal_normal.vm):
$theme.runtime("webstarnewslettersubscription_WAR_WcsNewsletterportlet")
or
$theme.runtime("webstarnewslettersubscriptionjquery_WAR_WcsNewsletterportlet")



