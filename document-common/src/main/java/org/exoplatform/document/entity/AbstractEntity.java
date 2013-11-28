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

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.exoplatform.document.constant.TBLEntity;
import org.exoplatform.document.entity.plugin.Entity;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version AbstractEntity.java Oct 31, 2013
 * 
 */
@MappedSuperclass
public abstract class AbstractEntity<I extends Serializable> implements Entity<I> {

  /**
	 * 
	 */
  private static final long serialVersionUID = 6475766928065560033L;

  /**
   * ID of Object Entity
   */
  @Id
  @Column(name = TBLEntity.ID, unique = true, nullable = false, length = 100)
  protected I id;

  public void setId(I id) {
    this.id = id;
  }

  @Override
  public I getId() {
    return id;
  }
}
