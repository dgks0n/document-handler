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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.exoplatform.document.constant.TBLAccount;
import org.exoplatform.document.constant.TBLEntity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Created by The eXo Platform SAS
 * 
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 * 
 * @version Account.java Nov 28, 2013
 */
@Entity
@Table(name = TBLAccount.TBL_NAME, uniqueConstraints = { @UniqueConstraint(columnNames = TBLEntity.ID) })
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = TBLAccount.TBL_NAME)
public class Account extends StringIdentity {

	private static final long serialVersionUID = 5877345833306167010L;

	@Column(name = TBLAccount.GIVE_NAME, length = 100)
	private String giveName;

	@Column(name = TBLAccount.FAMILY_NAME, length = 100)
	private String familyName;

	@Column(name = TBLAccount.EMAIL_ADDRESS, nullable = false, length = 100)
	private String emailAddress;

	@Column(name = TBLAccount.LINK, length = 250)
	private String link;

	@Column(name = TBLAccount.GENDER, nullable = false, length = 10)
	private String gender;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLAccount.BIRTH_DAY)
	private Calendar birthday;

	@Column(name = TBLAccount.LOCALE, length = 50)
	private String locale;

	@Column(name = TBLAccount.VERIFIED_EMAIL, length = 5)
	private boolean verifiedEmail;

	@Column(name = TBLAccount.PASSWORD, length = 500)
	private String password;

	@Column(name = TBLAccount.TIME_ZONE, length = 50)
	private String timeZone;

	@Column(name = TBLAccount.DESCRIPTION, length = 1000)
	private String description;

	@Column(name = TBLAccount.LANGUAGE, length = 50)
	private String language;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLAccount.CREATED_DATE)
	private Calendar createdDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = TBLAccount.MODIFIED_DATE)
	private Calendar modifiedDate;

	public Account() {
		super();
	}

	/**
	 * @return the giveName
	 */
	public String getGiveName() {
		return giveName;
	}

	/**
	 * @param giveName
	 *            the giveName to set
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
	 * @param familyName
	 *            the familyName to set
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
	 * @param emailAddress
	 *            the emailAddress to set
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
	 * @param link
	 *            the link to set
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
	 * @param gender
	 *            the gender to set
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
	 * @param birthday
	 *            the birthday to set
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
	 * @param locale
	 *            the locale to set
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
	 * @param verifiedEmail
	 *            the verifiedEmail to set
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
	 * @param password
	 *            the password to set
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
	 * @param timeZone
	 *            the timeZone to set
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
	 * @param description
	 *            the description to set
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
	 * @param language
	 *            the language to set
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
	 * @param createdDate
	 *            the createdDate to set
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
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(Calendar modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
}
