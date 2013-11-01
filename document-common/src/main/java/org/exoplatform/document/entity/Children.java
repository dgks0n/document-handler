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
 * @version Children.java Oct 31, 2013
 *
 */
public class Children extends CommonEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3338144206955937089L;

	// A link to the child.
	private String childLink;

	/**
	 * 
	 */
	public Children() {
		super();
	}

	/**
	 * @param childLink
	 */
	public Children(String kind, String selfLink, String childLink) {
		super(kind, selfLink);
		this.childLink = childLink;
	}

	/**
	 * @return the childLink
	 */
	public String getChildLink() {
		return childLink;
	}

	/**
	 * @param childLink the childLink to set
	 */
	public void setChildLink(String childLink) {
		this.childLink = childLink;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.getId().equals(((Children) obj).getId());
	}
}
