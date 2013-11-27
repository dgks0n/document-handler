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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.exoplatform.document.constant.GenericGeneratorType;
import org.exoplatform.document.constant.ParameterType;
import org.exoplatform.document.constant.TBLEntity;
import org.exoplatform.document.constant.TBLOwner;
import org.exoplatform.document.constant.TBLPicture;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version Picture.java Oct 31, 2013
 *
 */
@Entity
@Table(name = TBLPicture.TBL_NAME, 
    uniqueConstraints = {@UniqueConstraint(columnNames = TBLEntity.ID)})
public class Picture extends StringIdentity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1190891511410189743L;

	@Column(name = TBLPicture.URL, length = 1500)
	private String url;
	
	@OneToOne(fetch = FetchType.LAZY)
  @PrimaryKeyJoinColumn
	private Owner owner;

	/**
	 * 
	 */
	public Picture() {
	}
	
	/**
	 * Mapped with Owner's Identity
	 * 
	 * (non-Javadoc)
	 * @see org.exoplatform.document.entity.AbstractEntity#getId()
	 */
	@GenericGenerator(name = GenericGeneratorType.GENERATOR, 
	    strategy = GenericGeneratorType.STRATEGY_FOREIGN, 
	    parameters = @Parameter(name = ParameterType.PROPERTY, 
	    value = TBLOwner.TBL_NAME))
	@Override
	public String getId() {
	  return id;
	}

  /**
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @param url the url to set
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * @return the owner
   */
  public Owner getOwner() {
    return owner;
  }

  /**
   * @param owner the owner to set
   */
  public void setOwner(Owner owner) {
    this.owner = owner;
  }
}
