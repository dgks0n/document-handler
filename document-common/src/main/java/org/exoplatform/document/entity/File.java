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
	
	private String title;
	
	private String description;
	
	private Label label;
	
	private Date createdDate;
	
	private Date modifiedByMeDate;
	
	private String fileExtension;
	
	private String alternateLink;
	
	private String embedLink;
	
	private Label labelOfFile;
	
	private Date sharedWithMeDate;
	
	private List parents;
	
	private long quotaBytesUsed;
	
	private List ownerNames;
	
	private boolean editable;
	
	private boolean writersCanShare;
	
	private String thumbnailLink;
	
	private Date lastViewedByMeDate;
	
	private String webContentLink;
	
	private boolean explicitlyTrashed;
	
	private Thumbnail thumbnail;
	
	private String webViewLink;
	
	private String iconLink;
	
	private boolean shared;
	
	private List owners;
	
	private boolean appDataContents;
	
	private String defaultOpenWithLink;
	
	private String headRevisionId;
	
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
			List ownerNames, boolean editable, boolean writersCanShare,
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
	public List getOwnerNames() {
		return ownerNames;
	}

	/**
	 * @param ownerNames the ownerNames to set
	 */
	public void setOwnerNames(List ownerNames) {
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
