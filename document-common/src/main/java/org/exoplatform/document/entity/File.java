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
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.exoplatform.document.constant.TBLEntity;
import org.exoplatform.document.constant.TBLFile;

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
	
	@Column(name = TBLFile.LABEL, length = 255)
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
	
	private List parents;
	
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
	
	private List owners;
	
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
	
}
