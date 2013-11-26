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
 * @version Label.java Oct 31, 2013
 *
 */
public class Label extends StringIdentity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4457310329075840843L;

	private boolean starred;
	
	private boolean hidden;
	
	private boolean trashed;
	
	private boolean restricted;
	
	private boolean viewed;

	/**
	 * 
	 */
	public Label() {
	}

	/**
	 * @param starred
	 * @param hidden
	 * @param trashed
	 * @param restricted
	 * @param viewed
	 */
	public Label(boolean starred, boolean hidden, boolean trashed, boolean restricted, boolean viewed) {
		this.starred = starred;
		this.hidden = hidden;
		this.trashed = trashed;
		this.restricted = restricted;
		this.viewed = viewed;
	}

	/**
	 * @return the starred
	 */
	public boolean isStarred() {
		return starred;
	}

	/**
	 * @param starred the starred to set
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
	 * @param hidden the hidden to set
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
	 * @param trashed the trashed to set
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
	 * @param restricted the restricted to set
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
	 * @param viewed the viewed to set
	 */
	public void setViewed(boolean viewed) {
		this.viewed = viewed;
	}

}
