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
public class Owner extends StringIdentity implements IOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870864171015175044L;

	private String kind;
	
	private String displayName;

	private Picture picture;
	
	private boolean isAuthenticatedUser;
	
	private String permissionId;

  /**
   * 
   */
  public Owner() {
    super();
  }

  /**
   * @param kind
   * @param displayName
   * @param picture
   * @param isAuthenticatedUser
   * @param permissionId
   */
  public Owner(String kind, String displayName, Picture picture,
      boolean isAuthenticatedUser, String permissionId) {
    super();
    this.kind = kind;
    this.displayName = displayName;
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
   * @return the displayName
   */
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @param displayName the displayName to set
   */
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
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
    result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
    result = prime * result + (isAuthenticatedUser ? 1231 : 1237);
    result = prime * result + ((kind == null) ? 0 : kind.hashCode());
    result = prime * result + ((permissionId == null) ? 0 : permissionId.hashCode());
    result = prime * result + ((picture == null) ? 0 : picture.hashCode());
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
    Owner other = (Owner) obj;
    if (displayName == null) {
      if (other.displayName != null)
        return false;
    } else if (!displayName.equals(other.displayName))
      return false;
    if (isAuthenticatedUser != other.isAuthenticatedUser)
      return false;
    if (kind == null) {
      if (other.kind != null)
        return false;
    } else if (!kind.equals(other.kind))
      return false;
    if (permissionId == null) {
      if (other.permissionId != null)
        return false;
    } else if (!permissionId.equals(other.permissionId))
      return false;
    if (picture == null) {
      if (other.picture != null)
        return false;
    } else if (!picture.equals(other.picture))
      return false;
    return true;
  }

}