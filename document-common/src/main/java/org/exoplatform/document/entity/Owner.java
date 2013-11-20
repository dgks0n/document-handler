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

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version Owner.java Oct 31, 2013
 *
 */
public class Owner extends OwnerEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870864171015175044L;

	// This is always entity#user.
	private String kind;
	
	// The user's profile picture.
	private Picture picture;
	
	// Whether this user is the same as the authenticated user for whom the request was made.
	private boolean isAuthenticatedUser;
	
	// The user's ID as visible in the permissions collection.
	private String permissionId;

	/**
	 * 
	 */
	public Owner() {
	}

	/**
	 * @param picture
	 */
	public Owner(Picture picture) {
		this.picture = picture;
	}

	/**
	 * @param kind
	 * @param displayName
	 * @param picture
	 * @param isAuthenticatedUser
	 * @param permissionId
	 */
	public Owner(String kind, String displayName, Picture picture, boolean isAuthenticatedUser, String permissionId) {
		super(displayName);
		this.kind = kind;
		this.picture = picture;
		this.isAuthenticatedUser = isAuthenticatedUser;
		this.permissionId = permissionId;
	}

	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * @param kind the kind to set
	 */
	public void setKind(String kind) {
		this.kind = kind;
	}

	/**
	 * @return the picture
	 */
	public Picture getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(Picture picture) {
		this.picture = picture;
	}

	/**
	 * @return the isAuthenticatedUser
	 */
	public boolean isAuthenticatedUser() {
		return isAuthenticatedUser;
	}

	/**
	 * @param isAuthenticatedUser the isAuthenticatedUser to set
	 */
	public void setAuthenticatedUser(boolean isAuthenticatedUser) {
		this.isAuthenticatedUser = isAuthenticatedUser;
	}

	/**
	 * @return the permissionId
	 */
	public String getPermissionId() {
		return permissionId;
	}

	/**
	 * @param permissionId the permissionId to set
	 */
	public void setPermissionId(String permissionId) {
		this.permissionId = permissionId;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.getId().hashCode();
		result = prime * result + this.getDisplayName().hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.getId().equals(((Owner) obj).getId())
				&& this.getDisplayName().equals(((Owner) obj).getDisplayName());
	}
	
}
