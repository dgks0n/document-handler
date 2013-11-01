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
 * @version Parent.java Oct 31, 2013
 *
 */
public class Parent extends RootEntity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9174189865264723277L;

	// A link to the parent.
	private String parentLink;
	
	// Whether or not the parent is the root folder.
	private boolean isRoot;

	public Parent() {
		super();
	}

	/**
	 * @param parentLink
	 * @param isRoot
	 */
	public Parent(String kind, String selfLink, String parentLink, boolean isRoot) {
		super(kind, selfLink);
		this.parentLink = parentLink;
		this.isRoot = isRoot;
	}

	/**
	 * @return the parentLink
	 */
	public String getParentLink() {
		return parentLink;
	}

	/**
	 * @param parentLink the parentLink to set
	 */
	public void setParentLink(String parentLink) {
		this.parentLink = parentLink;
	}

	/**
	 * @return the isRoot
	 */
	public boolean isRoot() {
		return isRoot;
	}

	/**
	 * @param isRoot the isRoot to set
	 */
	public void setRoot(boolean isRoot) {
		this.isRoot = isRoot;
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
		return this.getId().equals(((Parent) obj).getId());
	}
	
}
