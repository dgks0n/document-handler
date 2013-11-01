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
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version DocumentPlugin.java Nov 1, 2013
 */
public interface DocumentPlugin {

	/**
	 * The ETag of the document.
	 * 
	 * @return an array of ETag
	 */
	public String[] getEtag();
	
	/**
	 * The MIME type of the document
	 * 
	 * @return a MIME type
	 */
	public String getMimeType();
	
	/**
	 * Last time this document was modified (formatted RFC 3339 timestamp).
	 * 
	 * @return modified time
	 */
	public Date getModifiedDate();
	
	/**
	 * Short term download URL for the file. 
	 * This will only be populated on files with content stored in Drive.
	 * 
	 * @return a short download URL
	 */
	public String getDownloadUrl();
	
	/**
	 * The original filename when this document was created. 
	 * This will only be populated on files with content stored in Drive.
	 * 
	 * @return original filename
	 */
	public String getOriginalFilename();
	
	/**
	 * An MD5 checksum for the content of this document. 
	 * This will only be populated on files with content stored in Drive.
	 * 
	 * @return an MD5
	 */
	public String getMd5Checksum();
	
	/**
	 * The size of the document in bytes. 
	 * This will only be populated on files with content stored in Drive.
	 * 
	 * @return size of document
	 */
	public long getFileSize();
	
	/**
	 * Name of the last user to modify this document.
	 * 
	 * @return a name
	 */
	public String getLastModifyingUserName();
	
	/**
	 * The last user to modify this document.
	 * 
	 * @return owner object
	 */
	public Owner getLastModifyingUser();
}
