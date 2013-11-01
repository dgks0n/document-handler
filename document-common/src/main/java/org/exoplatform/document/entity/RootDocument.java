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

import java.io.Serializable;
import java.util.Date;

import org.exoplatform.document.entity.procedure.DocumentProcedure;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version BaseDocument.java Nov 1, 2013
 */
public class RootDocument<I extends Serializable> extends RootEntity<I> implements DocumentProcedure {

	/**
	 * 
	 */
	private static final long serialVersionUID = -868279763726156941L;
	
	// ETag of the file.
	private String[] etag;
	
	// The MIME type of the file. 
	// This is only mutable on update when uploading new content. 
	// This field can be left blank, and the mimetype will be determined from the uploaded content's MIME type.
	private String mimeType;
	
	// Last time this file was modified by anyone (formatted RFC 3339 timestamp). 
	// This is only mutable on update when the setModifiedDate parameter is set.
	private Date modifiedDate;
	
	// Short lived download URL for the file. 
	// This is only populated for files with content stored in Drive.
	private String downloadUrl;
	
	// The original filename if the file was uploaded manually, or the original title if the file was inserted through the API.
	// Note that renames of the title will not change the original filename. 
	// This will only be populated on files with content stored in Drive.
	private String originalFilename;	
	
	// An MD5 checksum for the content of this file. 
	// This is populated only for files with content stored in Drive.
	private String md5Checksum;
	
	// The size of the file in bytes. 
	// This is only populated for files with content stored in Drive.
	private long fileSize;
	
	// Name of the last user to modify this file.
	private String lastModifyingUserName;
	
	// The last user to modify this file.
	private Owner lastModifyingUser;
	
	public RootDocument() {
		super();
	}
	
	public RootDocument(String kind, String selfLink, String[] etag, String mimeType, Date modifiedDate,
			String downloadUrl, String originalFilename, String md5Checksum,
			long fileSize, String lastModifyingUserName, Owner lastModifyingUser) {
		super(kind, selfLink);
		this.etag = etag;
		this.mimeType = mimeType;
		this.modifiedDate = modifiedDate;
		this.downloadUrl = downloadUrl;
		this.originalFilename = originalFilename;
		this.md5Checksum = md5Checksum;
		this.fileSize = fileSize;
		this.lastModifyingUserName = lastModifyingUserName;
		this.lastModifyingUser = lastModifyingUser;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getEtag()
	 */
	@Override
	public String[] getEtag() {
		return etag;
	}
	
	/**
	 * @param etag the etag to set
	 */
	public void setEtag(String[] etag) {
		this.etag = etag;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getMimeType()
	 */
	@Override
	public String getMimeType() {
		return mimeType;
	}
	
	/**
	 * @param mimeType the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getModifiedDate()
	 */
	@Override
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getDownloadUrl()
	 */
	@Override
	public String getDownloadUrl() {
		return downloadUrl;
	}
	
	/**
	 * @param downloadUrl the downloadUrl to set
	 */
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getOriginalFilename()
	 */
	@Override
	public String getOriginalFilename() {
		return originalFilename;
	}
	
	/**
	 * @param originalFilename the originalFilename to set
	 */
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getMd5Checksum()
	 */
	@Override
	public String getMd5Checksum() {
		return md5Checksum;
	}
	
	/**
	 * @param md5Checksum the md5Checksum to set
	 */
	public void setMd5Checksum(String md5Checksum) {
		this.md5Checksum = md5Checksum;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getFileSize()
	 */
	@Override
	public long getFileSize() {
		return fileSize;
	}
	
	/**
	 * @param fileSize the fileSize to set
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getLastModifyingUserName()
	 */
	@Override
	public String getLastModifyingUserName() {
		return lastModifyingUserName;
	}
	
	/**
	 * @param lastModifyingUserName the lastModifyingUserName to set
	 */
	public void setLastModifyingUserName(String lastModifyingUserName) {
		this.lastModifyingUserName = lastModifyingUserName;
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.entity.DocumentPlugin#getLastModifyingUser()
	 */
	@Override
	public Owner getLastModifyingUser() {
		return lastModifyingUser;
	}
	
	/**
	 * @param lastModifyingUser the lastModifyingUser to set
	 */
	public void setLastModifyingUser(Owner lastModifyingUser) {
		this.lastModifyingUser = lastModifyingUser;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
}
