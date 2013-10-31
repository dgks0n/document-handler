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
package org.exoplatform.document.entity;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version Thumbnail.java Oct 31, 2013
 *
 */
public class Thumbnail extends Entity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5149103349382724837L;

	// The URL-safe Base64 encoded bytes of the thumbnail image.
	private byte[] image;
	
	// The MIME type of the thumbnail.
	private String mimeType;

	/**
	 * 
	 */
	public Thumbnail() {
		super();
	}

	/**
	 * @param image
	 * @param mimeType
	 */
	public Thumbnail(byte[] image, String mimeType) {
		super();
		this.image = image;
		this.mimeType = mimeType;
	}

	/**
	 * @return the image
	 */
	public byte[] getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(byte[] image) {
		this.image = image;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
}
