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
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version Revision.java Nov 1, 2013
 */
public class Revision extends Document {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6612421643350781170L;
	
	private boolean pinned;
	
	private boolean published;
	
	private boolean publishAuto;
	
	private boolean publishedOutsideDomain;
	
	private String publishedLink;

  /**
   * 
   */
  public Revision() {
    super();
  }

  /**
   * @param pinned
   * @param published
   * @param publishAuto
   * @param publishedOutsideDomain
   * @param publishedLink
   */
  public Revision(boolean pinned, boolean published, boolean publishAuto,
      boolean publishedOutsideDomain, String publishedLink) {
    super();
    this.pinned = pinned;
    this.published = published;
    this.publishAuto = publishAuto;
    this.publishedOutsideDomain = publishedOutsideDomain;
    this.publishedLink = publishedLink;
  }

  /**
   * @return the pinned
   */
  public boolean isPinned() {
    return pinned;
  }

  /**
   * @param pinned the pinned to set
   */
  public void setPinned(boolean pinned) {
    this.pinned = pinned;
  }

  /**
   * @return the published
   */
  public boolean isPublished() {
    return published;
  }

  /**
   * @param published the published to set
   */
  public void setPublished(boolean published) {
    this.published = published;
  }

  /**
   * @return the publishAuto
   */
  public boolean isPublishAuto() {
    return publishAuto;
  }

  /**
   * @param publishAuto the publishAuto to set
   */
  public void setPublishAuto(boolean publishAuto) {
    this.publishAuto = publishAuto;
  }

  /**
   * @return the publishedOutsideDomain
   */
  public boolean isPublishedOutsideDomain() {
    return publishedOutsideDomain;
  }

  /**
   * @param publishedOutsideDomain the publishedOutsideDomain to set
   */
  public void setPublishedOutsideDomain(boolean publishedOutsideDomain) {
    this.publishedOutsideDomain = publishedOutsideDomain;
  }

  /**
   * @return the publishedLink
   */
  public String getPublishedLink() {
    return publishedLink;
  }

  /**
   * @param publishedLink the publishedLink to set
   */
  public void setPublishedLink(String publishedLink) {
    this.publishedLink = publishedLink;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + (pinned ? 1231 : 1237);
    result = prime * result + (publishAuto ? 1231 : 1237);
    result = prime * result + (published ? 1231 : 1237);
    result = prime * result
        + ((publishedLink == null) ? 0 : publishedLink.hashCode());
    result = prime * result + (publishedOutsideDomain ? 1231 : 1237);
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!super.equals(obj)) {
      return false;
    }
    if (!(obj instanceof Revision)) {
      return false;
    }
    Revision other = (Revision) obj;
    if (pinned != other.pinned) {
      return false;
    }
    if (publishAuto != other.publishAuto) {
      return false;
    }
    if (published != other.published) {
      return false;
    }
    if (publishedLink == null) {
      if (other.publishedLink != null) {
        return false;
      }
    } else if (!publishedLink.equals(other.publishedLink)) {
      return false;
    }
    if (publishedOutsideDomain != other.publishedOutsideDomain) {
      return false;
    }
    return true;
  }
}
