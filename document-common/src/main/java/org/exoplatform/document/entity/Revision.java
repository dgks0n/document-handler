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
 * @version Revision.java Nov 1, 2013
 */
public class Revision extends RootDocument<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6612421643350781170L;
	
	// Whether this revision is pinned to prevent automatic purging. 
	// This will only be populated and can only be modified on files with content stored in Drive which are not Google Docs. 
	// Revisions can also be pinned when they are created through the drive.files.insert/update/copy by using the pinned query parameter.
	private boolean pinned;
	
	// Whether this revision is published. 
	// This is only populated and can only be modified for Google Docs.
	private boolean published;
	
	// Whether subsequent revisions will be automatically republished. 
	// This is only populated and can only be modified for Google Docs.
	private boolean publishAuto;
	
	// Whether this revision is published outside the domain. 
	// This is only populated and can only be modified for Google Docs.
	private boolean publishedOutsideDomain;
	
	// A link to the published revision.
	private String publishedLink;

	/**
	 * 
	 */
	public Revision() {
		super();
	}

	public Revision(String kind, String selfLink, String[] etag, String mimeType, 
			Date modifiedDate, String downloadUrl, String originalFilename, String md5Checksum, 
			long fileSize, String lastModifyingUserName, Owner lastModifyingUser, boolean pinned, 
			boolean published, boolean publishAuto, boolean publishedOutsideDomain, String publishedLink) {
		super(kind, selfLink, etag, mimeType, modifiedDate, downloadUrl, 
				originalFilename, md5Checksum, fileSize, lastModifyingUserName, lastModifyingUser);
		this.pinned = pinned;
		this.published = published;
		this.publishAuto = publishAuto;
		this.publishedOutsideDomain = publishedOutsideDomain;
		this.publishedLink = publishedLink;
	}

	/**
	 * @return the pinned
	 */
	public boolean isPinned() {
		return pinned;
	}

	/**
	 * @param pinned the pinned to set
	 */
	public void setPinned(boolean pinned) {
		this.pinned = pinned;
	}

	/**
	 * @return the published
	 */
	public boolean isPublished() {
		return published;
	}

	/**
	 * @param published the published to set
	 */
	public void setPublished(boolean published) {
		this.published = published;
	}

	/**
	 * @return the publishAuto
	 */
	public boolean isPublishAuto() {
		return publishAuto;
	}

	/**
	 * @param publishAuto the publishAuto to set
	 */
	public void setPublishAuto(boolean publishAuto) {
		this.publishAuto = publishAuto;
	}

	/**
	 * @return the publishedOutsideDomain
	 */
	public boolean isPublishedOutsideDomain() {
		return publishedOutsideDomain;
	}

	/**
	 * @param publishedOutsideDomain the publishedOutsideDomain to set
	 */
	public void setPublishedOutsideDomain(boolean publishedOutsideDomain) {
		this.publishedOutsideDomain = publishedOutsideDomain;
	}

	/**
	 * @return the publishedLink
	 */
	public String getPublishedLink() {
		return publishedLink;
	}

	/**
	 * @param publishedLink the publishedLink to set
	 */
	public void setPublishedLink(String publishedLink) {
		this.publishedLink = publishedLink;
	}
	
}
