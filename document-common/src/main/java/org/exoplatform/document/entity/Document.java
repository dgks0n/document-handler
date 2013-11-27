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

import java.util.Arrays;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.exoplatform.document.constant.TBLDocument;
import org.exoplatform.document.entity.plugin.IDocument;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version Document.java Nov 1, 2013
 */
@MappedSuperclass
public class Document extends BaseEntityIdentity implements IDocument {

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

  /**
   * 
   */
  public Document() {
    super();
  }

  /**
   * @param etag
   * @param mimeType
   * @param modifiedDate
   * @param downloadUrl
   * @param originalFilename
   * @param md5Checksum
   * @param fileSize
   * @param lastModifyingUserName
   * @param lastModifyingUser
   */
  public Document(String[] etag, String mimeType, Calendar modifiedDate,
      String downloadUrl, String originalFilename, String md5Checksum,
      long fileSize, String lastModifyingUserName, Owner lastModifyingUser) {
    super();
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

  /**
   * @return the etag
   */
  public String[] getEtag() {
    return etag;
  }

  /**
   * @param etag the etag to set
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
   * @param mimeType the mimeType to set
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
   * @param modifiedDate the modifiedDate to set
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
   * @param downloadUrl the downloadUrl to set
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
   * @param originalFilename the originalFilename to set
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
   * @param md5Checksum the md5Checksum to set
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
   * @param fileSize the fileSize to set
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
   * @param lastModifyingUserName the lastModifyingUserName to set
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
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((downloadUrl == null) ? 0 : downloadUrl.hashCode());
    result = prime * result + Arrays.hashCode(etag);
    result = prime * result + (int) (fileSize ^ (fileSize >>> 32));
    result = prime * result
        + ((lastModifyingUser == null) ? 0 : lastModifyingUser.hashCode());
    result = prime
        * result
        + ((lastModifyingUserName == null) ? 0 : lastModifyingUserName
            .hashCode());
    result = prime * result
        + ((md5Checksum == null) ? 0 : md5Checksum.hashCode());
    result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
    result = prime * result
        + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
    result = prime * result
        + ((originalFilename == null) ? 0 : originalFilename.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (!(obj instanceof Document)) {
      return false;
    }
    Document other = (Document) obj;
    if (downloadUrl == null) {
      if (other.downloadUrl != null) {
        return false;
      }
    } else if (!downloadUrl.equals(other.downloadUrl)) {
      return false;
    }
    if (!Arrays.equals(etag, other.etag)) {
      return false;
    }
    if (fileSize != other.fileSize) {
      return false;
    }
    if (lastModifyingUser == null) {
      if (other.lastModifyingUser != null) {
        return false;
      }
    } else if (!lastModifyingUser.equals(other.lastModifyingUser)) {
      return false;
    }
    if (lastModifyingUserName == null) {
      if (other.lastModifyingUserName != null) {
        return false;
      }
    } else if (!lastModifyingUserName.equals(other.lastModifyingUserName)) {
      return false;
    }
    if (md5Checksum == null) {
      if (other.md5Checksum != null) {
        return false;
      }
    } else if (!md5Checksum.equals(other.md5Checksum)) {
      return false;
    }
    if (mimeType == null) {
      if (other.mimeType != null) {
        return false;
      }
    } else if (!mimeType.equals(other.mimeType)) {
      return false;
    }
    if (modifiedDate == null) {
      if (other.modifiedDate != null) {
        return false;
      }
    } else if (!modifiedDate.equals(other.modifiedDate)) {
      return false;
    }
    if (originalFilename == null) {
      if (other.originalFilename != null) {
        return false;
      }
    } else if (!originalFilename.equals(other.originalFilename)) {
      return false;
    }
    return true;
  }
}
