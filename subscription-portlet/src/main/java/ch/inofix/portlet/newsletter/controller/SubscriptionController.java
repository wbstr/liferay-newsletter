package ch.inofix.portlet.newsletter.controller;

/*
 * #%L
 * Webstar Newsletter
 * %%
 * Copyright (C) 2013 - 2014 Webstar Csoport Kft.
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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.portlet.PortletRequest;

import ch.inofix.portlet.newsletter.dto.SubscriptionKeySet;
import ch.inofix.portlet.newsletter.util.SubscriptionKeyUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.wcs.newsletter.model.Category;
import com.wcs.newsletter.model.Subscription;
import com.wcs.newsletter.model.SubscriptionCategory;
import com.wcs.newsletter.service.CategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionCategoryLocalServiceUtil;
import com.wcs.newsletter.service.SubscriptionLocalServiceUtil;

/**
 * Backing bean for the newsletter subscription.
 * 
 * Based on the com.wcs.newsletter.controller.SubscriptionController.
 * 
 * 
 * @author Christian Berndt
 * @created 2014-06-05 11:01
 * @modified 2014-06-23 14:08
 * @version 1.6
 * 
 */
@ManagedBean
public class SubscriptionController {

	// Enable logging for this class
	private static Logger logger = LoggerFactory
			.getLogger(SubscriptionController.class);

	// Configurable properties
	private long defaultCategoryId = -1;
	private String email = null;
	private List<String> selectedCategoryIds = null;

	/**
	 * Store a success message in the current context.
	 * 
	 * @param msg
	 * @since 1.0
	 */
	// From JsfUtil, a candidate for an AbstractController
	public static void addSuccessMessage(String msg) {
		
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO,
				msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	/**
	 * 
	 * @param key
	 * @param args
	 * @since 1.5
	 */
	public static void addSuccessMessage(String key, Object[] args) {

		Locale locale = FacesContext.getCurrentInstance().getViewRoot()
				.getLocale();
		
		String message = getMessage(key, args, locale);

		FacesMessage facesMessage = new FacesMessage(
				FacesMessage.SEVERITY_INFO, message, null);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);

	}
	
	/** 
	 * 
	 * @param key
	 * @param args
	 * @return
	 * @since 1.5
	 * 
	 */
	// From FacesMessageUtil
	// TODO: Move to an utility class
	public static String getMessage(String key, Object[] args) {
		
		return getMessage(key, args, null); 
		
	}
	
	/** 
	 * 
	 * @param key
	 * @param args
	 * @return
	 * @since 1.5
	 * 
	 */
	// From FacesMessageUtil
	// TODO: Move to an utility class
	public static String getMessage(String key, Object[] args, Locale locale) {
		
		String message = key;
		ResourceBundle resourceBundle = null; 

		try {

			if (resourceBundle == null) {
				resourceBundle = ResourceBundle.getBundle("Language", locale);
			}

			message = resourceBundle.getString(key);

			if (args != null) {
				message = MessageFormat.format(message, args);
			}
		}
		catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		return message;
	}

	/**
	 * Store an error message in the current context.
	 * 
	 * @param msg
	 * @since 1.0
	 */
	public static void addErrorMessage(String msg) {
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
				msg, msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMsg);
	}

	/**
	 * Save the subscription to the database
	 * 
	 * @param actionEvent
	 * @since 1.0
	 */
	public void saveSubscription(ActionEvent actionEvent) {

		logger.info("Executing saveSubscription()");
		logger.debug("email = " + email);

		if (selectedCategoryIds != null) {
			logger.debug("selectedCategoryIds.size() = "
					+ selectedCategoryIds.size());
		}
		
		try {
			
			// TODO: find a cleaner solution for this
			if (getCategories().size() == 1) {
				String categoryId = String.valueOf(getCategories().get(0).getCategoryId()); 
				selectedCategoryIds = new ArrayList<String>();
				selectedCategoryIds.add(categoryId);
			}

			List<Subscription> subscriptions = SubscriptionLocalServiceUtil
					.findByEmail(email);

			// TODO: move this code to
			// SubscriptionLocalService.saveSubscription()
			long subscriptionId = 0;
			Subscription subscription = null;

			if (subscriptions.size() > 0) {

				// Update an already existing subscription (Update the
				// list of selected categories).
				subscription = subscriptions.get(0);
				subscriptionId = subscription.getSubscriptionId();

			} else {

				// Create a new subscription
				subscriptionId = CounterLocalServiceUtil.increment();
				subscription = SubscriptionLocalServiceUtil
						.createSubscription(subscriptionId);

				subscription.setEmail(email);
				subscription.setSubscriptionDate(new Date());

				subscription = SubscriptionLocalServiceUtil
						.updateSubscription(subscription);

			}

			// Because in WcsNewsletter service an increment key is used,
			// we must update the subscriptionId here
			subscriptionId = subscription.getSubscriptionId();

			// Update the list of associated categories
			List<SubscriptionCategory> subscriptionCategories = SubscriptionCategoryLocalServiceUtil
					.findBySubscriptionId(subscriptionId);

			logger.debug("subscriptionCategories.size = "
					+ subscriptionCategories.size());

			if (subscriptionCategories.size() > 0) {

				// TODO: Do not remove, only update the list of associated
				// categories
				//
				// Remove the list of already associated categories
				for (SubscriptionCategory subscriptionCategory : subscriptionCategories) {

					subscriptionCategory = SubscriptionCategoryLocalServiceUtil
							.deleteSubscriptionCategory(subscriptionCategory);

					logger.debug("Deleted subscriptionCategory with id = "
							+ subscriptionCategory.getSubscriptionCategoryId());
				}
			}

			for (String selectedCategoryId : selectedCategoryIds) {

				long categoryId = GetterUtil.getLong(selectedCategoryId);
				logger.debug("categoryId = " + categoryId);

				long subscriptionCategoryId = CounterLocalServiceUtil
						.increment();

				SubscriptionCategory subscriptionCategory = SubscriptionCategoryLocalServiceUtil
						.createSubscriptionCategory(subscriptionCategoryId);

				subscriptionCategory.setCategoryId(categoryId);
				subscriptionCategory.setSubscriptionId(subscriptionId);

				SubscriptionKeySet subscriptionKeySet = SubscriptionKeyUtil
						.generateKeySet(selectedCategoryId, email);
				subscriptionCategory.setCancellationKey(subscriptionKeySet
						.getCancelationKey());

				String confirmed = "1";
				subscriptionCategory.setStatus(confirmed);

				SubscriptionCategoryLocalServiceUtil
						.addSubscriptionCategory(subscriptionCategory);

			}
			
			addSuccessMessage("your-subscription-has-been-saved-with-the-address-x", new String[]{email});

		} catch (SystemException se) {

			String msg = LanguageUtil.get(getThemeDisplay().getLocale(),
					"a-system-error-occurred");

			addErrorMessage(msg);

			logger.error(se);

		} catch (Exception e) {

			String msg = LanguageUtil.get(getThemeDisplay().getLocale(),
					"a-system-error-occurred");

			addErrorMessage(msg);

			logger.error(e);

		}

	}

	/**
	 * Return the List of categories available for a given locale.
	 * 
	 * @return the List of categories available for a given locale.
	 * @since 1.0
	 * @throws SystemException
	 */
	public List<Category> getCategories() throws SystemException {

		logger.info("Executing getCategories()");

		return CategoryLocalServiceUtil.getCategories();
		// TODO: Find a cleaner solution for the Locale to String conversion
		// return CategoryLocalServiceUtil.findByLocale(""
		// + getThemeDisplay().getLocale());

	}

	/**
	 * Retrieve the ThemeDisplay associated with this request.
	 * 
	 * @since 1.0
	 */
	// From AbstractController
	public ThemeDisplay getThemeDisplay() {

		PortletRequest portletRequest = (PortletRequest) FacesContext
				.getCurrentInstance().getExternalContext().getRequest();

		return (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
	}

	// Getters and setters
	public long getDefaultCategoryId() {
		
		return defaultCategoryId;
	}

	public void setDefaultCategoryId(long defaultCategoryId) {
		this.defaultCategoryId = defaultCategoryId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSelectedCategoryIds() {
		
		return selectedCategoryIds;
	}

	public void setSelectedCategoryIds(List<String> selectedCategoryIds) {
		this.selectedCategoryIds = selectedCategoryIds;
	}

}
