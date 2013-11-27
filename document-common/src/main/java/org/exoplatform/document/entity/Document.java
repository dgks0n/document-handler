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

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exoplatform.document.constant.TBLDocument;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version Document.java Nov 1, 2013
 */
@MappedSuperclass
public class Document extends BaseEntity<String> implements IDocument {

	/**
	 * 
	 */
	private static final long serialVersionUID = -868279763726156941L;

	@Column(name = TBLDocument.ETAG)
	protected String[] etag;
	
	@Column(name = TBLDocument.MIME_TYPE)
	protected String mimeType;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLDocument.MODIFIED_DATE)
	protected Calendar modifiedDate;
	
	@Column(name = TBLDocument.DOWNLOAD_URL)
	protected String downloadUrl;
	
	@Column(name = TBLDocument.ORIGINAL_FILENAME)
	protected String originalFilename;	
	
	@Column(name = TBLDocument.MD5_CHECKSUM)
	protected String md5Checksum;
	
	@Column(name = TBLDocument.FILE_SIZE)
	protected long fileSize;
	
	@Column(name = TBLDocument.LAST_MODIFYING_USERNAME)
	protected String lastModifyingUserName;
	
	@Column(name = TBLDocument.LAST_MODIFYING_USER)
	protected Owner lastModifyingUser;
	
	public Document() {
		super();
	}
	
	public Document(String kind, String selfLink, String[] etag, String mimeType, Calendar modifiedDate,
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
	public Calendar getModifiedDate() {
		return modifiedDate;
	}
	
	/**
	 * @param modifiedDate the modifiedDate to set
	 */
	public void setModifiedDate(Calendar modifiedDate) {
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
