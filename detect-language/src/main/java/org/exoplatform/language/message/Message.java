/*
 * Copyright (C) 2003-2013 eXo Platform SAS.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.language.message;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @since Sep 26, 2013
 * @version 
 */
public class Message {

	private static final Logger logger = LoggerFactory.getLogger(Message.class);
	
	private static final String BUNDLE_NAME = "org.exoplatform.language.message.Message";
	
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault());
	
	public Message() {
	}
	
	public static String getMessage(String key) {
		String valueOfKey;
		try {
			valueOfKey = RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException mre) {
			logger.error("Can't find any messages matches with \"" + key + "\"", mre);
			valueOfKey = "[" + key + "]";
		}
		return valueOfKey;
	}
}
