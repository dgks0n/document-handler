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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = TBLOwner.PICTURE)
  private Picture picture;
	
	@Column(name = TBLOwner.GIVE_NAME, length = 100)
	private String giveName;
	
	@Column(name = TBLOwner.FAMILY_NAME, length = 100)
	private String familyName;
	
	@Column(name = TBLOwner.EMAIL_ADDRESS, length = 100)
	private String emailAddress;
	
	@Column(name = TBLOwner.LINK)
	private String link;
	
	@Column(name = TBLOwner.GENDER)
	private String gender;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLOwner.BIRTH_DAY)
	private Calendar birthday;
	
	@Column(name = TBLOwner.LOCALE, length = 50)
	private String locale;
	
	@Column(name = TBLOwner.VERIFIED_EMAIL, length = 5)
	private boolean verifiedEmail;
	
	@Column(name = TBLOwner.PASSWORD, length = 500)
	private String password;
	
	@Column(name = TBLOwner.TIME_ZONE, length = 50)
	private String timeZone;
	
	@Column(name = TBLOwner.DESCRIPTION, length = 1000)
	private String description;
	
	@Column(name = TBLOwner.LANGUAGE, length = 50)
	private String language;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLOwner.CREATED_DATE)
	private Calendar createdDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLOwner.MODIFIED_DATE)
	private Calendar modifiedDate;
	
	@OneToOne(mappedBy = TBLFile.TBL_NAME)
  private File file;

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
   * @return the giveName
   */
  public String getGiveName() {
    return giveName;
  }

  /**
   * @param giveName the giveName to set
   */
  public void setGiveName(String giveName) {
    this.giveName = giveName;
  }

  /**
   * @return the familyName
   */
  public String getFamilyName() {
    return familyName;
  }

  /**
   * @param familyName the familyName to set
   */
  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  /**
   * @return the emailAddress
   */
  public String getEmailAddress() {
    return emailAddress;
  }

  /**
   * @param emailAddress the emailAddress to set
   */
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * @return the link
   */
  public String getLink() {
    return link;
  }

  /**
   * @param link the link to set
   */
  public void setLink(String link) {
    this.link = link;
  }

  /**
   * @return the gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender the gender to set
   */
  public void setGender(String gender) {
    this.gender = gender;
  }

  /**
   * @return the birthday
   */
  public Calendar getBirthday() {
    return birthday;
  }

  /**
   * @param birthday the birthday to set
   */
  public void setBirthday(Calendar birthday) {
    this.birthday = birthday;
  }

  /**
   * @return the locale
   */
  public String getLocale() {
    return locale;
  }

  /**
   * @param locale the locale to set
   */
  public void setLocale(String locale) {
    this.locale = locale;
  }

  /**
   * @return the verifiedEmail
   */
  public boolean isVerifiedEmail() {
    return verifiedEmail;
  }

  /**
   * @param verifiedEmail the verifiedEmail to set
   */
  public void setVerifiedEmail(boolean verifiedEmail) {
    this.verifiedEmail = verifiedEmail;
  }

  /**
   * @return the password
   */
  public String getPassword() {
    return password;
  }

  /**
   * @param password the password to set
   */
  public void setPassword(String password) {
    this.password = password;
  }

  /**
   * @return the timeZone
   */
  public String getTimeZone() {
    return timeZone;
  }

  /**
   * @param timeZone the timeZone to set
   */
  public void setTimeZone(String timeZone) {
    this.timeZone = timeZone;
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
   * @return the modifiedDate
   */
  public Calendar getModifiedDate() {
    return modifiedDate;
  }

  /**
   * @param modifiedDate the modifiedDate to set
   */
  public void setModifiedDate(Calendar modifiedDate) {
    this.modifiedDate = modifiedDate;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((birthday == null) ? 0 : birthday.hashCode());
    result = prime * result
        + ((createdDate == null) ? 0 : createdDate.hashCode());
    result = prime * result
        + ((description == null) ? 0 : description.hashCode());
    result = prime * result
        + ((displayName == null) ? 0 : displayName.hashCode());
    result = prime * result
        + ((emailAddress == null) ? 0 : emailAddress.hashCode());
    result = prime * result
        + ((familyName == null) ? 0 : familyName.hashCode());
    result = prime * result + ((gender == null) ? 0 : gender.hashCode());
    result = prime * result + ((giveName == null) ? 0 : giveName.hashCode());
    result = prime * result + (isAuthenticatedUser ? 1231 : 1237);
    result = prime * result + ((kind == null) ? 0 : kind.hashCode());
    result = prime * result + ((language == null) ? 0 : language.hashCode());
    result = prime * result + ((link == null) ? 0 : link.hashCode());
    result = prime * result + ((locale == null) ? 0 : locale.hashCode());
    result = prime * result
        + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
    result = prime * result + ((password == null) ? 0 : password.hashCode());
    result = prime * result
        + ((permissionId == null) ? 0 : permissionId.hashCode());
    result = prime * result + ((picture == null) ? 0 : picture.hashCode());
    result = prime * result + ((timeZone == null) ? 0 : timeZone.hashCode());
    result = prime * result + (verifiedEmail ? 1231 : 1237);
    return result;
  }
}