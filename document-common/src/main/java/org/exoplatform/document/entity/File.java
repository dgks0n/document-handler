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
import java.util.List;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version File.java Oct 31, 2013
 *
 */
public class File extends Document<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525605509708642225L;
	
	// The title of the this file. 
	// Used to identify file or folder name.
	private String title;
	
	// A short description of the file.
	private String description;
	
	// A group of labels for the file.
	private Label label;
	
	// Create time for this file (formatted ISO8601 timestamp).
	private Date createdDate;
	
	// Last time this file was modified by the user (formatted RFC 3339 timestamp). 
	// Note that setting modifiedDate will also update the modifiedByMe date for the user which set the date.
	private Date modifiedByMeDate;
	
	// The file extension used when downloading this file. 
	// This field is read only. 
	// To set the extension, include it in the title when creating the file. 
	// This is only populated for files with content stored in Drive.
	private String fileExtension;
	
	// A link for opening the file in using a relevant Google editor or viewer.
	private String alternateLink;
	
	// A link for embedding the file.
	private String embedLink;
	
	// A group of labels for the file.
	private Label labelOfFile;
	
	// Time at which this file was shared with the user (formatted RFC 3339 timestamp).
	private Date sharedWithMeDate;
	
	// Collection of parent folders which contain this file.
	// Setting this field will put the file in all of the provided folders. 
	// On insert, if no folders are provided, the file will be placed in the default root folder.
	private List parents;
	
	// The number of quota bytes used by this file.
	private long quotaBytesUsed;
	
	// Name(s) of the owner(s) of this file.
	private OwnerEntity[] ownerNames;
	
	// Whether the file can be edited by the current user.
	private boolean editable;
	
	// Whether writers can share the document with other users.
	private boolean writersCanShare;
	
	// A link to the file's thumbnail.
	private String thumbnailLink;
	
	// Last time this file was viewed by the user (formatted RFC 3339 timestamp).
	private Date lastViewedByMeDate;
	
	// A link for downloading the content of the file in a browser using cookie based authentication. 
	// In cases where the content is shared publicly, the content can be downloaded without any credentials.
	private String webContentLink;
	
	// Whether this file has been explicitly trashed, as opposed to recursively trashed. 
	// This will only be populated if the file is trashed.
	private boolean explicitlyTrashed;
	
	// Thumbnail for the file. 
	// Only accepted on upload and for files that are not already thumbnailed by Google.
	private Thumbnail thumbnail;
	
	// A link only available on public folders for viewing their static web assets (HTML, CSS, JS, etc) via Google Drive's Website Hosting.
	private String webViewLink;
	
	// A link to the file's icon.
	private String iconLink;
	
	// Whether the file has been shared.
	private boolean shared;
	
	// The owner(s) of this file.
	private List owners;
	
	// Whether this file is in the appdata folder.
	private boolean appDataContents;
	
	// A link to open this file with the user's default app for this file. 
	// Only populated when the drive.apps.readonly scope is used.
	private String defaultOpenWithLink;
	
	// The ID of the file's head revision. 
	// This will only be populated for files with content stored in Drive.
	private String headRevisionId;
	
	// Whether the file can be copied by the current user.
	private boolean copyable;

	/**
	 * 
	 */
	public File() {
		super();
	}

	/**
	 * @param title
	 * @param description
	 * @param label
	 * @param createdDate
	 * @param modifiedByMeDate
	 * @param fileExtension
	 * @param alternateLink
	 * @param embedLink
	 * @param labelOfFile
	 * @param sharedWithMeDate
	 * @param parents
	 * @param quotaBytesUsed
	 * @param ownerNames
	 * @param editable
	 * @param writersCanShare
	 * @param thumbnailLink
	 * @param lastViewedByMeDate
	 * @param webContentLink
	 * @param explicitlyTrashed
	 * @param thumbnail
	 * @param webViewLink
	 * @param iconLink
	 * @param shared
	 * @param owners
	 * @param appDataContents
	 * @param defaultOpenWithLink
	 * @param headRevisionId
	 * @param copyable
	 */
	public File(String title, String description, Label label,
			Date createdDate, Date modifiedByMeDate, String fileExtension,
			String alternateLink, String embedLink, Label labelOfFile,
			Date sharedWithMeDate, List parents, long quotaBytesUsed,
			OwnerEntity[] ownerNames, boolean editable, boolean writersCanShare,
			String thumbnailLink, Date lastViewedByMeDate,
			String webContentLink, boolean explicitlyTrashed,
			Thumbnail thumbnail, String webViewLink, String iconLink,
			boolean shared, List owners, boolean appDataContents,
			String defaultOpenWithLink, String headRevisionId, boolean copyable) {
		super();
		this.title = title;
		this.description = description;
		this.label = label;
		this.createdDate = createdDate;
		this.modifiedByMeDate = modifiedByMeDate;
		this.fileExtension = fileExtension;
		this.alternateLink = alternateLink;
		this.embedLink = embedLink;
		this.labelOfFile = labelOfFile;
		this.sharedWithMeDate = sharedWithMeDate;
		this.parents = parents;
		this.quotaBytesUsed = quotaBytesUsed;
		this.ownerNames = ownerNames;
		this.editable = editable;
		this.writersCanShare = writersCanShare;
		this.thumbnailLink = thumbnailLink;
		this.lastViewedByMeDate = lastViewedByMeDate;
		this.webContentLink = webContentLink;
		this.explicitlyTrashed = explicitlyTrashed;
		this.thumbnail = thumbnail;
		this.webViewLink = webViewLink;
		this.iconLink = iconLink;
		this.shared = shared;
		this.owners = owners;
		this.appDataContents = appDataContents;
		this.defaultOpenWithLink = defaultOpenWithLink;
		this.headRevisionId = headRevisionId;
		this.copyable = copyable;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the label
	 */
	public Label getLabel() {
		return label;
	}

	/**
	 * @param label the label to set
	 */
	public void setLabel(Label label) {
		this.label = label;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the modifiedByMeDate
	 */
	public Date getModifiedByMeDate() {
		return modifiedByMeDate;
	}

	/**
	 * @param modifiedByMeDate the modifiedByMeDate to set
	 */
	public void setModifiedByMeDate(Date modifiedByMeDate) {
		this.modifiedByMeDate = modifiedByMeDate;
	}

	/**
	 * @return the fileExtension
	 */
	public String getFileExtension() {
		return fileExtension;
	}

	/**
	 * @param fileExtension the fileExtension to set
	 */
	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	/**
	 * @return the alternateLink
	 */
	public String getAlternateLink() {
		return alternateLink;
	}

	/**
	 * @param alternateLink the alternateLink to set
	 */
	public void setAlternateLink(String alternateLink) {
		this.alternateLink = alternateLink;
	}

	/**
	 * @return the embedLink
	 */
	public String getEmbedLink() {
		return embedLink;
	}

	/**
	 * @param embedLink the embedLink to set
	 */
	public void setEmbedLink(String embedLink) {
		this.embedLink = embedLink;
	}

	/**
	 * @return the labelOfFile
	 */
	public Label getLabelOfFile() {
		return labelOfFile;
	}

	/**
	 * @param labelOfFile the labelOfFile to set
	 */
	public void setLabelOfFile(Label labelOfFile) {
		this.labelOfFile = labelOfFile;
	}

	/**
	 * @return the sharedWithMeDate
	 */
	public Date getSharedWithMeDate() {
		return sharedWithMeDate;
	}

	/**
	 * @param sharedWithMeDate the sharedWithMeDate to set
	 */
	public void setSharedWithMeDate(Date sharedWithMeDate) {
		this.sharedWithMeDate = sharedWithMeDate;
	}

	/**
	 * @return the parents
	 */
	public List getParents() {
		return parents;
	}

	/**
	 * @param parents the parents to set
	 */
	public void setParents(List parents) {
		this.parents = parents;
	}

	/**
	 * @return the quotaBytesUsed
	 */
	public long getQuotaBytesUsed() {
		return quotaBytesUsed;
	}

	/**
	 * @param quotaBytesUsed the quotaBytesUsed to set
	 */
	public void setQuotaBytesUsed(long quotaBytesUsed) {
		this.quotaBytesUsed = quotaBytesUsed;
	}

	/**
	 * @return the ownerNames
	 */
	public OwnerEntity[] getOwnerNames() {
		return ownerNames;
	}

	/**
	 * @param ownerNames the ownerNames to set
	 */
	public void setOwnerNames(OwnerEntity[] ownerNames) {
		this.ownerNames = ownerNames;
	}

	/**
	 * @return the editable
	 */
	public boolean isEditable() {
		return editable;
	}

	/**
	 * @param editable the editable to set
	 */
	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	/**
	 * @return the writersCanShare
	 */
	public boolean isWritersCanShare() {
		return writersCanShare;
	}

	/**
	 * @param writersCanShare the writersCanShare to set
	 */
	public void setWritersCanShare(boolean writersCanShare) {
		this.writersCanShare = writersCanShare;
	}

	/**
	 * @return the thumbnailLink
	 */
	public String getThumbnailLink() {
		return thumbnailLink;
	}

	/**
	 * @param thumbnailLink the thumbnailLink to set
	 */
	public void setThumbnailLink(String thumbnailLink) {
		this.thumbnailLink = thumbnailLink;
	}

	/**
	 * @return the lastViewedByMeDate
	 */
	public Date getLastViewedByMeDate() {
		return lastViewedByMeDate;
	}

	/**
	 * @param lastViewedByMeDate the lastViewedByMeDate to set
	 */
	public void setLastViewedByMeDate(Date lastViewedByMeDate) {
		this.lastViewedByMeDate = lastViewedByMeDate;
	}

	/**
	 * @return the webContentLink
	 */
	public String getWebContentLink() {
		return webContentLink;
	}

	/**
	 * @param webContentLink the webContentLink to set
	 */
	public void setWebContentLink(String webContentLink) {
		this.webContentLink = webContentLink;
	}

	/**
	 * @return the explicitlyTrashed
	 */
	public boolean isExplicitlyTrashed() {
		return explicitlyTrashed;
	}

	/**
	 * @param explicitlyTrashed the explicitlyTrashed to set
	 */
	public void setExplicitlyTrashed(boolean explicitlyTrashed) {
		this.explicitlyTrashed = explicitlyTrashed;
	}

	/**
	 * @return the thumbnail
	 */
	public Thumbnail getThumbnail() {
		return thumbnail;
	}

	/**
	 * @param thumbnail the thumbnail to set
	 */
	public void setThumbnail(Thumbnail thumbnail) {
		this.thumbnail = thumbnail;
	}

	/**
	 * @return the webViewLink
	 */
	public String getWebViewLink() {
		return webViewLink;
	}

	/**
	 * @param webViewLink the webViewLink to set
	 */
	public void setWebViewLink(String webViewLink) {
		this.webViewLink = webViewLink;
	}

	/**
	 * @return the iconLink
	 */
	public String getIconLink() {
		return iconLink;
	}

	/**
	 * @param iconLink the iconLink to set
	 */
	public void setIconLink(String iconLink) {
		this.iconLink = iconLink;
	}

	/**
	 * @return the shared
	 */
	public boolean isShared() {
		return shared;
	}

	/**
	 * @param shared the shared to set
	 */
	public void setShared(boolean shared) {
		this.shared = shared;
	}

	/**
	 * @return the owners
	 */
	public List getOwners() {
		return owners;
	}

	/**
	 * @param owners the owners to set
	 */
	public void setOwners(List owners) {
		this.owners = owners;
	}

	/**
	 * @return the appDataContents
	 */
	public boolean isAppDataContents() {
		return appDataContents;
	}

	/**
	 * @param appDataContents the appDataContents to set
	 */
	public void setAppDataContents(boolean appDataContents) {
		this.appDataContents = appDataContents;
	}

	/**
	 * @return the defaultOpenWithLink
	 */
	public String getDefaultOpenWithLink() {
		return defaultOpenWithLink;
	}

	/**
	 * @param defaultOpenWithLink the defaultOpenWithLink to set
	 */
	public void setDefaultOpenWithLink(String defaultOpenWithLink) {
		this.defaultOpenWithLink = defaultOpenWithLink;
	}

	/**
	 * @return the headRevisionId
	 */
	public String getHeadRevisionId() {
		return headRevisionId;
	}

	/**
	 * @param headRevisionId the headRevisionId to set
	 */
	public void setHeadRevisionId(String headRevisionId) {
		this.headRevisionId = headRevisionId;
	}

	/**
	 * @return the copyable
	 */
	public boolean isCopyable() {
		return copyable;
	}

	/**
	 * @param copyable the copyable to set
	 */
	public void setCopyable(boolean copyable) {
		this.copyable = copyable;
	}
	
	
}
