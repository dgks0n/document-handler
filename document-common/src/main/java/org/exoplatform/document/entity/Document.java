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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exoplatform.document.constant.TBLDocument;
import org.exoplatform.document.constant.TBLEntity;
import org.exoplatform.document.entity.plugin.IDocument;

/**
 * Created by The eXo Platform SAS
 * 
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 * 
 * @version Document.java Nov 1, 2013
 */
@MappedSuperclass
public class Document extends BaseEntityIdentity implements IDocument {

	private static final long serialVersionUID = -868279763726156941L;

	@Lob
	@Column(name = TBLDocument.ETAG)
	protected String[] etag;

	@Column(name = TBLDocument.MIME_TYPE, nullable = true, length = 250)
	protected String mimeType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLDocument.MODIFIED_DATE)
	protected Calendar modifiedDate;

	@Column(name = TBLDocument.DOWNLOAD_URL, nullable = false, length = 1500)
	protected String downloadUrl;

	@Column(name = TBLDocument.ORIGINAL_FILENAME, nullable = false, length = 500)
	protected String originalFilename;

	@Column(name = TBLDocument.MD5_CHECKSUM, nullable = true)
	protected String md5Checksum;

	@Column(name = TBLDocument.FILE_SIZE, nullable = false)
	protected long fileSize;

	@Column(name = TBLDocument.LAST_MODIFYING_USERNAME, nullable = true, length = 500)
	protected String lastModifyingUserName;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = TBLDocument.LAST_MODIFYING_USER, referencedColumnName = TBLEntity.ID)
	protected Owner lastModifyingUser;

	public Document() {
		super();
	}

	/**
	 * @return the etag
	 */
	public String[] getEtag() {
		return etag;
	}

	/**
	 * @param etag
	 *            the etag to set
	 */
	public void setEtag(String[] etag) {
		this.etag = etag;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @param mimeType
	 *            the mimeType to set
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * @return the modifiedDate
	 */
	public Calendar getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the downloadUrl
	 */
	public String getDownloadUrl() {
		return downloadUrl;
	}

	/**
	 * @param downloadUrl
	 *            the downloadUrl to set
	 */
	public void setDownloadUrl(String downloadUrl) {
		this.downloadUrl = downloadUrl;
	}

	/**
	 * @return the originalFilename
	 */
	public String getOriginalFilename() {
		return originalFilename;
	}

	/**
	 * @param originalFilename
	 *            the originalFilename to set
	 */
	public void setOriginalFilename(String originalFilename) {
		this.originalFilename = originalFilename;
	}

	/**
	 * @return the md5Checksum
	 */
	public String getMd5Checksum() {
		return md5Checksum;
	}

	/**
	 * @param md5Checksum
	 *            the md5Checksum to set
	 */
	public void setMd5Checksum(String md5Checksum) {
		this.md5Checksum = md5Checksum;
	}

	/**
	 * @return the fileSize
	 */
	public long getFileSize() {
		return fileSize;
	}

	/**
	 * @param fileSize
	 *            the fileSize to set
	 */
	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the lastModifyingUserName
	 */
	public String getLastModifyingUserName() {
		return lastModifyingUserName;
	}

	/**
	 * @param lastModifyingUserName
	 *            the lastModifyingUserName to set
	 */
	public void setLastModifyingUserName(String lastModifyingUserName) {
		this.lastModifyingUserName = lastModifyingUserName;
	}

	/**
	 * @return the lastModifyingUser
	 */
	public Owner getLastModifyingUser() {
		return lastModifyingUser;
	}

	/**
	 * @param lastModifyingUser
	 *            the lastModifyingUser to set
	 */
	public void setLastModifyingUser(Owner lastModifyingUser) {
		this.lastModifyingUser = lastModifyingUser;
	}
}
