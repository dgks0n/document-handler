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
 * @version CommonEntity.java Oct 31, 2013
 *
 */
public class CommonEntity extends Entity<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 311072933487708402L;

	// This is always drive#parentReference.
	private String kind;
	
	// A link back to this reference.
	private String selfLink;

	public CommonEntity() {
		super();
	}

	public CommonEntity(String kind, String selfLink) {
		super();
		this.kind = kind;
		this.selfLink = selfLink;
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
	 * @return the selfLink
	 */
	public String getSelfLink() {
		return selfLink;
	}

	/**
	 * @param selfLink the selfLink to set
	 */
	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + this.getId().hashCode();
		result = prime * result + this.getKind().hashCode();
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		return this.getId().equals(((CommonEntity) obj).getId());
	}

}
