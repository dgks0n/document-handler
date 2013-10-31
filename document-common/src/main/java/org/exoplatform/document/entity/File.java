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

import java.util.Date;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version File.java Oct 31, 2013
 *
 */
public class File extends Entity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525605509708642225L;

	// The type of file. This is always entity#file.
	private String kind;
	
	// ETag of the file.
	private String etag;
	
	// A link back to this file.
	private String selfLink;
	
	// The title of the this file. Used to identify file or folder name.
	private String title;
	
	// The MIME type of the file. This is only mutable on update when uploading new content. This field can be left blank, and the mimetype will be determined from the uploaded content's MIME type.
	private String mimeType;
	
	// A short description of the file.
	private String description;
	
	// A group of labels for the file.
	private Label label;
	
	// Create time for this file (formatted ISO8601 timestamp).
	private Date createdDate;
	
	// Last time this file was modified by anyone (formatted RFC 3339 timestamp). This is only mutable on update when the setModifiedDate parameter is set.
	private Date modifiedDate;
}
