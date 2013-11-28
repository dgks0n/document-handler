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

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.exoplatform.document.constant.TBLEntity;
import org.exoplatform.document.constant.TBLFile;
import org.exoplatform.document.constant.TBLOwner;
import org.exoplatform.document.entity.plugin.IOwner;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version Owner.java Oct 31, 2013
 *
 */
@Entity
@Table(name = TBLOwner.TBL_NAME, 
    uniqueConstraints = {@UniqueConstraint(columnNames = TBLEntity.ID)})
public class Owner extends StringIdentity implements IOwner {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5870864171015175044L;

	@Column(name = TBLOwner.KIND, length = 50)
	private String kind;
	
	@Column(name = TBLOwner.DISPLAY_NAME, length = 100)
	private String displayName;
	
	@Column(name = TBLOwner.IS_AUTHENTICATED_USER, length = 1)
	private boolean isAuthenticatedUser;
	
	@Column(name = TBLOwner.PERMISSION_ID, length = 100)
	private String permissionId;
	
	/*
	 * One - To - One
	 * 
	 * One Owner has only one Picture and one Picture has only one Owner
	 */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = TBLOwner.PICTURE)
  private Picture picture;
	
	/*
   * One - To - One
   * 
   * One Owner has only one Owner's detail and one Owner's detail has only one Owner
   */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinColumn(name = TBLOwner.ACCOUNT_INFOR)
	private Account accountInfor;
	
	@OneToOne(mappedBy = TBLFile.TBL_NAME)
  private File file;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = TBLOwner.TBL_NAME)
	private Set<File> modifiedFiles = new HashSet<File>();
	
	/*
   * Many - To - Many
   * 
   * One Owner has many File and one File has many Owner
   */
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = TBLOwner.TBL_NAME)
	private Set<File> files = new HashSet<File>();

  /**
   * 
   */
  public Owner() {
    super();
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
   * @return the accountInfor
   */
  public Account getAccountInfor() {
    return accountInfor;
  }

  /**
   * @param accountInfor the accountInfor to set
   */
  public void setAccountInfor(Account accountInfor) {
    this.accountInfor = accountInfor;
  }

  /**
   * @return the file
   */
  public File getFile() {
    return file;
  }

  /**
   * @param file the file to set
   */
  public void setFile(File file) {
    this.file = file;
  }

  /**
   * @return the modifiedFiles
   */
  public Set<File> getModifiedFiles() {
    return modifiedFiles;
  }

  /**
   * @param modifiedFiles the modifiedFiles to set
   */
  public void setModifiedFiles(Set<File> modifiedFiles) {
    this.modifiedFiles = modifiedFiles;
  }

  /**
   * @return the files
   */
  public Set<File> getFiles() {
    return files;
  }

  /**
   * @param files the files to set
   */
  public void setFiles(Set<File> files) {
    this.files = files;
  }
}