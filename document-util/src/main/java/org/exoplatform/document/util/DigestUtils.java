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
package org.exoplatform.document.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version DigestUtils.java Nov 10, 2013
 *
 */
public class DigestUtils extends org.apache.commons.codec.digest.DigestUtils {
	
	/**
	 * Calculates a SHA1 hash from a provided String. If text is null, a RuntimeException will be thrown.
 	 * 
	 * @param text - String to calculate a SHA1 hash from.
	 * @return A SHA1 hash from the provided String.
	 */
	public static String toHexFromText(final String text) {
		String hashOfText = null;
	    // If the provided String is null, throw an Exception.
	    if (text == null) {
	        throw new RuntimeException("There is no String to calculate a SHA1 hash from.");
	    }
	    
	    try {
	        MessageDigest digest = MessageDigest.getInstance("SHA1");
	        digest.update(text.getBytes(CharsetUtils.UTF_8));
	        hashOfText = sha1Hex(digest.digest());
	    } catch (NoSuchAlgorithmException nsae) {
	        throw new RuntimeException("Could not find a SHA1 instance: " + nsae.getMessage());
	    }
	    return hashOfText;
	}
}
