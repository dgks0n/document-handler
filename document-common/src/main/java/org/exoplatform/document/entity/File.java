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
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.exoplatform.document.constant.TBLEntity;
import org.exoplatform.document.constant.TBLFile;
import org.exoplatform.document.constant.TBLOwnerFile;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version File.java Oct 31, 2013
 *
 */
@Entity
@Table(name = TBLFile.TBL_NAME,
    uniqueConstraints = {@UniqueConstraint(columnNames = TBLEntity.ID)})
public class File extends Document {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1525605509708642225L;
	
	@Column(name = TBLFile.TITLE, nullable = false , length = 500)
	private String title;
	
	@Column(name = TBLFile.DESCRIPTION, length = 1000)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = TBLFile.LABEL, nullable = false)
	private Label label;
	
	@Temporal(TemporalType.TIMESTAMP)
  @Column(name = TBLFile.CREATED_DATE)
	private Calendar createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
  @Column(name = TBLFile.MODIFIED_BY_ME_DATE)
	private Calendar modifiedByMeDate;
	
	@Column(name = TBLFile.FILE_EXTENSION, nullable = false , length = 10)
	private String fileExtension;
	
	@Column(name = TBLFile.ALTERNATE_LINK, nullable = true, length = 1500)
	private String alternateLink;
	
	@Column(name = TBLFile.EMBED_LINK, nullable = true, length = 1500)
	private String embedLink;
	
	@Temporal(TemporalType.TIMESTAMP)
  @Column(name = TBLFile.SHARED_WITH_ME_DATE)
	private Calendar sharedWithMeDate;
	
	//private List parents;
	
	@Column(name = TBLFile.QUOTA_BYTES_USED)
	private long quotaBytesUsed;
	
	@Column(name = TBLFile.OWNER_NAME)
	private String[] ownerNames;
	
	@Column(name = TBLFile.EDITABLE, length = 10)
	private boolean editable;
	
	@Column(name = TBLFile.WRITER_SCAN_SHARE, length = 10)
	private boolean writersCanShare;
	
	@Column(name = TBLFile.THUMBNAIL_LINK, nullable = true, length = 1500)
	private String thumbnailLink;
	
	@Temporal(TemporalType.TIMESTAMP)
  @Column(name = TBLFile.LAST_VIEWED_BY_ME_DATE)
	private Calendar lastViewedByMeDate;
	
	@Column(name = TBLFile.WEB_CONTENT_LINK, nullable = true, length = 1500)
	private String webContentLink;
	
	@Column(name = TBLFile.EXPLICITLY_TRASHED, length = 10)
	private boolean explicitlyTrashed;
	
	/*
   * One - To - One
   * 
   * One File has only one Thumbnail and one Thumbnail has only one File
   */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = TBLFile.THUMBNAIL)
	private Thumbnail thumbnail;
	
	@Column(name = TBLFile.WEB_VIEW_LINK, nullable = true, length = 1500)
	private String webViewLink;
	
	@Column(name = TBLFile.ICON_LINK, nullable = true, length = 1500)
	private String iconLink;
	
	@Column(name = TBLFile.SHARED, length = 10)
	private boolean shared;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = TBLOwnerFile.TBL_NAME, joinColumns = {
      @JoinColumn(name = TBLOwnerFile.OWNER_ID, nullable = false, updatable = false)}, 
      inverseJoinColumns = { 
          @JoinColumn(name = TBLOwnerFile.FILE_ID, nullable = false, updatable = false) 
      })
	private Set<Owner> owners = new HashSet<Owner>();
	
	@Column(name = TBLFile.APPLICATION_DATA_CONTENT, length = 10)
	private boolean appDataContents;
	
	@Column(name = TBLFile.DEFAULT_OPEN_WITH_LINK, nullable = true, length = 1500)
	private String defaultOpenWithLink;
	
	@ManyToOne
  @JoinColumn(name = TBLFile.HEAD_REVISION_IDENTITY, insertable = false, 
      updatable = false, nullable = false)
	private Revision revision;
	
	@Column(name = TBLFile.COPYABLE, length = 10)
	private boolean copyable;

	/**
	 * 
	 */
	public File() {
		super();
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
  public Calendar getCreatedDate() {
    return createdDate;
  }

  /**
   * @param createdDate the createdDate to set
   */
  public void setCreatedDate(Calendar createdDate) {
    this.createdDate = createdDate;
  }

  /**
   * @return the modifiedByMeDate
   */
  public Calendar getModifiedByMeDate() {
    return modifiedByMeDate;
  }

  /**
   * @param modifiedByMeDate the modifiedByMeDate to set
   */
  public void setModifiedByMeDate(Calendar modifiedByMeDate) {
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
   * @return the sharedWithMeDate
   */
  public Calendar getSharedWithMeDate() {
    return sharedWithMeDate;
  }

  /**
   * @param sharedWithMeDate the sharedWithMeDate to set
   */
  public void setSharedWithMeDate(Calendar sharedWithMeDate) {
    this.sharedWithMeDate = sharedWithMeDate;
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
  public String[] getOwnerNames() {
    return ownerNames;
  }

  /**
   * @param ownerNames the ownerNames to set
   */
  public void setOwnerNames(String[] ownerNames) {
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
  public Calendar getLastViewedByMeDate() {
    return lastViewedByMeDate;
  }

  /**
   * @param lastViewedByMeDate the lastViewedByMeDate to set
   */
  public void setLastViewedByMeDate(Calendar lastViewedByMeDate) {
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
  public Set<Owner> getOwners() {
    return owners;
  }

  /**
   * @param owners the owners to set
   */
  public void setOwners(Set<Owner> owners) {
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
   * @return the revision
   */
  public Revision getRevision() {
    return revision;
  }

  /**
   * @param revision the revision to set
   */
  public void setRevision(Revision revision) {
    this.revision = revision;
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
