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

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version File.java Oct 31, 2013
 *
 */
public class File extends BaseDocument {

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
	private BaseOwner[] ownerNames;
	
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
}
