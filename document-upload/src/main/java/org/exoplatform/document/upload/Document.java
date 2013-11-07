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
package org.exoplatform.document.upload;

import java.util.Date;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.exoplatform.document.entity.Entity;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version Document.java Nov 7, 2013
 */
public class Document extends Entity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2664377649402353894L;
	
	private static Document _document; 

	/**
	 * File's name
	 */
	String filename;
	
	/**
	 * File's size
	 */
	long size;
	
	/**
	 * File's URL
	 */
	String url;
	
	/**
	 * File's content type
	 */
	String contentType;
	
	String language;
	
	String encoding;
	
	String mimeType;
	
	/**
	 * 
	 */
	Map<String, String> formFields;
	
	/**
	 * File's creation time
	 */
	Date creationTime;
	
	/**
	 * File's access time
	 */
	Date lastAccessTime;
	
	/**
	 * File's modified time
	 */
	Date lastModifiedTime;
	
	/**
	 * Tells whether the file is a directory
	 */
	boolean isDirectory;
	
	/**
	 * Tells whether the file is something other than a regular file, directory, or symbolic link.
	 */
	boolean isOther;
	
	/**
	 * Tells whether the file is a regular file with opaque content.
	 */
	boolean isRegularFile;
	
	/**
	 * Tells whether the file is a symbolic link.
	 */
	boolean isSymbolicLink;
	
	boolean isReadOnly;
	
	boolean isHidden;
	
	boolean isArchive;
	
	boolean isSystem;

	public Document() {
		super();
	}
	
	public Document(String filename, long size, String url, String contentType,
			String language, String encoding, String mimeType,
			Map<String, String> formFields, Date creationTime,
			Date lastAccessTime, Date lastModifiedTime, boolean isDirectory,
			boolean isOther, boolean isRegularFile, boolean isSymbolicLink,
			boolean isReadOnly, boolean isHidden, boolean isArchive,
			boolean isSystem) {
		this.filename = filename;
		this.size = size;
		this.url = url;
		this.contentType = contentType;
		this.language = language;
		this.encoding = encoding;
		this.mimeType = mimeType;
		this.formFields = formFields;
		this.creationTime = creationTime;
		this.lastAccessTime = lastAccessTime;
		this.lastModifiedTime = lastModifiedTime;
		this.isDirectory = isDirectory;
		this.isOther = isOther;
		this.isRegularFile = isRegularFile;
		this.isSymbolicLink = isSymbolicLink;
		this.isReadOnly = isReadOnly;
		this.isHidden = isHidden;
		this.isArchive = isArchive;
		this.isSystem = isSystem;
	}

	public static Document getInstance() {
		if (_document == null) {
			return new Document();
		}
		
		return _document;
	}
	
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 * @return the size
	 */
	public long getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the encoding
	 */
	public String getEncoding() {
		return encoding;
	}

	/**
	 * @param encoding the encoding to set
	 */
	public void setEncoding(String encoding) {
		this.encoding = encoding;
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
	 * @return the formFields
	 */
	public Map<String, String> getFormFields() {
		return formFields;
	}

	/**
	 * @param formFields the formFields to set
	 */
	public void setFormFields(Map<String, String> formFields) {
		this.formFields = formFields;
	}

	/**
	 * @return the creationTime
	 */
	public Date getCreationTime() {
		return creationTime;
	}

	/**
	 * @param creationTime the creationTime to set
	 */
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}

	/**
	 * @return the lastAccessTime
	 */
	public Date getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	 * @param lastAccessTime the lastAccessTime to set
	 */
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}

	/**
	 * @return the lastModifiedTime
	 */
	public Date getLastModifiedTime() {
		return lastModifiedTime;
	}

	/**
	 * @param lastModifiedTime the lastModifiedTime to set
	 */
	public void setLastModifiedTime(Date lastModifiedTime) {
		this.lastModifiedTime = lastModifiedTime;
	}

	/**
	 * @return the isDirectory
	 */
	public boolean isDirectory() {
		return isDirectory;
	}

	/**
	 * @param isDirectory the isDirectory to set
	 */
	public void setDirectory(boolean isDirectory) {
		this.isDirectory = isDirectory;
	}

	/**
	 * @return the isOther
	 */
	public boolean isOther() {
		return isOther;
	}

	/**
	 * @param isOther the isOther to set
	 */
	public void setOther(boolean isOther) {
		this.isOther = isOther;
	}

	/**
	 * @return the isRegularFile
	 */
	public boolean isRegularFile() {
		return isRegularFile;
	}

	/**
	 * @param isRegularFile the isRegularFile to set
	 */
	public void setRegularFile(boolean isRegularFile) {
		this.isRegularFile = isRegularFile;
	}

	/**
	 * @return the isSymbolicLink
	 */
	public boolean isSymbolicLink() {
		return isSymbolicLink;
	}

	/**
	 * @param isSymbolicLink the isSymbolicLink to set
	 */
	public void setSymbolicLink(boolean isSymbolicLink) {
		this.isSymbolicLink = isSymbolicLink;
	}

	/**
	 * @return the isReadOnly
	 */
	public boolean isReadOnly() {
		return isReadOnly;
	}

	/**
	 * @param isReadOnly the isReadOnly to set
	 */
	public void setReadOnly(boolean isReadOnly) {
		this.isReadOnly = isReadOnly;
	}

	/**
	 * @return the isHidden
	 */
	public boolean isHidden() {
		return isHidden;
	}

	/**
	 * @param isHidden the isHidden to set
	 */
	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}

	/**
	 * @return the isArchive
	 */
	public boolean isArchive() {
		return isArchive;
	}

	/**
	 * @param isArchive the isArchive to set
	 */
	public void setArchive(boolean isArchive) {
		this.isArchive = isArchive;
	}

	/**
	 * @return the isSystem
	 */
	public boolean isSystem() {
		return isSystem;
	}

	/**
	 * @param isSystem the isSystem to set
	 */
	public void setSystem(boolean isSystem) {
		this.isSystem = isSystem;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Document [filename=" + filename + ", size=" + size + ", url="
				+ url + ", contentType=" + contentType + ", language="
				+ language + ", encoding=" + encoding + ", mimeType="
				+ mimeType + ", formFields=" + formFields + ", creationTime="
				+ creationTime + ", lastAccessTime=" + lastAccessTime
				+ ", lastModifiedTime=" + lastModifiedTime + ", isDirectory="
				+ isDirectory + ", isOther=" + isOther + ", isRegularFile="
				+ isRegularFile + ", isSymbolicLink=" + isSymbolicLink
				+ ", isReadOnly=" + isReadOnly + ", isHidden=" + isHidden
				+ ", isArchive=" + isArchive + ", isSystem=" + isSystem + "]";
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject jSONObject = new JSONObject();
		jSONObject.put("filename", filename);
		jSONObject.put("size", size);
		jSONObject.put("url", url);
		jSONObject.put("contentType", contentType);
		jSONObject.put("contentType", contentType);
		jSONObject.put("language", language);
		jSONObject.put("encoding", encoding);
		jSONObject.put("mimeType", mimeType);
		jSONObject.put("creationTime", creationTime);
		jSONObject.put("lastAccessTime", lastAccessTime);
		jSONObject.put("lastModifiedTime", lastModifiedTime);
		jSONObject.put("isDirectory", isDirectory);
		jSONObject.put("isOther", isOther);
		jSONObject.put("isRegularFile", isRegularFile);
		jSONObject.put("isSymbolicLink", isSymbolicLink);
		jSONObject.put("isReadOnly", isReadOnly);
		jSONObject.put("isHidden", isHidden);
		jSONObject.put("isArchive", isArchive);
		jSONObject.put("isSystem", isSystem);
//		jSONObject.put("formFields", formFields);
		return jSONObject;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contentType == null) ? 0 : contentType.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((encoding == null) ? 0 : encoding.hashCode());
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
		result = prime * result + (isArchive ? 1231 : 1237);
		result = prime * result + (isDirectory ? 1231 : 1237);
		result = prime * result + (isHidden ? 1231 : 1237);
		result = prime * result + (isOther ? 1231 : 1237);
		result = prime * result + (isReadOnly ? 1231 : 1237);
		result = prime * result + (isRegularFile ? 1231 : 1237);
		result = prime * result + (isSymbolicLink ? 1231 : 1237);
		result = prime * result + (isSystem ? 1231 : 1237);
		result = prime * result + ((language == null) ? 0 : language.hashCode());
		result = prime * result + ((lastAccessTime == null) ? 0 : lastAccessTime.hashCode());
		result = prime * result + ((lastModifiedTime == null) ? 0 : lastModifiedTime.hashCode());
		result = prime * result + ((mimeType == null) ? 0 : mimeType.hashCode());
		result = prime * result + (int) (size ^ (size >>> 32));
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (contentType == null) {
			if (other.contentType != null)
				return false;
		} else if (!contentType.equals(other.contentType))
			return false;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (encoding == null) {
			if (other.encoding != null)
				return false;
		} else if (!encoding.equals(other.encoding))
			return false;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		if (isArchive != other.isArchive)
			return false;
		if (isDirectory != other.isDirectory)
			return false;
		if (isHidden != other.isHidden)
			return false;
		if (isOther != other.isOther)
			return false;
		if (isReadOnly != other.isReadOnly)
			return false;
		if (isRegularFile != other.isRegularFile)
			return false;
		if (isSymbolicLink != other.isSymbolicLink)
			return false;
		if (isSystem != other.isSystem)
			return false;
		if (language == null) {
			if (other.language != null)
				return false;
		} else if (!language.equals(other.language))
			return false;
		if (lastAccessTime == null) {
			if (other.lastAccessTime != null)
				return false;
		} else if (!lastAccessTime.equals(other.lastAccessTime))
			return false;
		if (lastModifiedTime == null) {
			if (other.lastModifiedTime != null)
				return false;
		} else if (!lastModifiedTime.equals(other.lastModifiedTime))
			return false;
		if (mimeType == null) {
			if (other.mimeType != null)
				return false;
		} else if (!mimeType.equals(other.mimeType))
			return false;
		if (size != other.size)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
}
