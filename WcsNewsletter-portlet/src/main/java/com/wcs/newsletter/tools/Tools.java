package com.wcs.newsletter.tools;

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

import com.liferay.faces.util.logging.Logger;
import com.liferay.faces.util.logging.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tools {

    protected static final Logger logger = LoggerFactory.getLogger(Tools.class);
    
    public static InputStream getResourceStream(String key) {
        InputStream is = null;
        try {
            java.lang.reflect.Method getCCL =
                    Thread.class.getMethod("getContextClassLoader", new Class[0]);
            if (getCCL != null) {
                ClassLoader contextClassLoader =
                        (ClassLoader) getCCL.invoke(Thread.currentThread(),
                        new Object[0]);
                if (contextClassLoader != null) {
                    is = contextClassLoader.getResourceAsStream(key);
                }
            }
        } catch (Throwable e) {
        }
        if (is == null) {
            is = ClassLoader.getSystemResourceAsStream(key);
        }
        return is;
    }

    public static String InputStream2Str(InputStream is, boolean needLineSep) throws Exception {
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");

        BufferedReader input = null;
        StringBuilder sb = new StringBuilder();

        input = new BufferedReader(isr);

        try {
            String line = null;
            while ((line = input.readLine()) != null) {
                sb.append(line);

                if (needLineSep) {
                    sb.append(System.getProperty("line.separator"));
                }
            }
        } finally {
            input.close();
        }

        return sb.toString();
    }
    
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

