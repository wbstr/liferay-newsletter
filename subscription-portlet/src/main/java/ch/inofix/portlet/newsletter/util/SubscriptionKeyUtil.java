package ch.inofix.portlet.newsletter.util;

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
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import ch.inofix.portlet.newsletter.dto.SubscriptionKeySet;

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;

/**
 * Utility for hashing subscribe- and unsubscribe keys.
 * 
 * Based on the com.wcs.newsletter.util.SubscriptionKeyUtil
 * 
 * 
 * @author Christian Berndt
 * @created 2014-06-08 17:56
 * @modified 2014-06-08 17:56
 * @version 1.0
 * 
 */
public class SubscriptionKeyUtil {

	protected static final Logger logger = LoggerFactory
			.getLogger(SubscriptionKeyUtil.class);

	// From com.wcs.newsletter.util.SubscriptionUtil
	public static SubscriptionKeySet generateKeySet(String catId, String email) {
		double randomNumber = Math.random() * 1000;

		String confirmationKey = md5(catId + "_" + randomNumber + "_" + email
				+ "_confirm");
		String cancelationKey = md5(catId + "_" + randomNumber + "_" + email
				+ "_cancel");

		logger.debug("generateKeySet: {0} {1} ({2}) ({3})", new Object[] {
				catId, email, confirmationKey, cancelationKey });

		SubscriptionKeySet subscriptionKeySet = new SubscriptionKeySet(
				confirmationKey, cancelationKey);

		return subscriptionKeySet;
	}

	// From com.wcs.newsletter.tools.Tools
	public static String md5(String text) {
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(text.getBytes());
			byte messageDigest[] = m.digest();

			StringBuffer hexString = new StringBuffer();
			for (int i = 0; i < messageDigest.length; i++) {
				String hex = Integer.toHexString(0xFF & messageDigest[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}
				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			logger.error(e);
		}
		return null;
	}
}
