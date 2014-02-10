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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.exoplatform.document.constant.TBLEntity;
import org.exoplatform.document.constant.TBLLabel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version Label.java Oct 31, 2013
 * 
 */
@Entity
@Table(name = TBLLabel.TBL_NAME, uniqueConstraints = { @UniqueConstraint(columnNames = TBLEntity.ID) })
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = TBLLabel.TBL_NAME)
public class Label extends StringIdentity {

	private static final long serialVersionUID = 4457310329075840843L;

	@Column(name = TBLLabel.STARRED, nullable = true, length = 10)
	private boolean starred;

	@Column(name = TBLLabel.HIDDEN, nullable = true, length = 10)
	private boolean hidden;

	@Column(name = TBLLabel.TRASHED, nullable = true, length = 10)
	private boolean trashed;

	@Column(name = TBLLabel.RESTRICTED, nullable = true, length = 10)
	private boolean restricted;

	@Column(name = TBLLabel.VIEWED, nullable = true, length = 10)
	private boolean viewed;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = TBLLabel.MAPPEDBY_LABLE_OF_FILE)
	private List<File> files;

	public Label() {
	}

	/**
	 * @return the starred
	 */
	public boolean isStarred() {
		return starred;
	}

	/**
	 * @param starred
	 *            the starred to set
	 */
	public void setStarred(boolean starred) {
		this.starred = starred;
	}

	/**
	 * @return the hidden
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * @param hidden
	 *            the hidden to set
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}

	/**
	 * @return the trashed
	 */
	public boolean isTrashed() {
		return trashed;
	}

	/**
	 * @param trashed
	 *            the trashed to set
	 */
	public void setTrashed(boolean trashed) {
		this.trashed = trashed;
	}

	/**
	 * @return the restricted
	 */
	public boolean isRestricted() {
		return restricted;
	}

	/**
	 * @param restricted
	 *            the restricted to set
	 */
	public void setRestricted(boolean restricted) {
		this.restricted = restricted;
	}

	/**
	 * @return the viewed
	 */
	public boolean isViewed() {
		return viewed;
	}

	/**
	 * @param viewed
	 *            the viewed to set
	 */
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

	/**
	 * @return the files
	 */
	public List<File> getFiles() {
		return files;
	}

	/**
	 * @param files
	 *            the files to set
	 */
	public void setFiles(List<File> files) {
		this.files = files;
	}
}
