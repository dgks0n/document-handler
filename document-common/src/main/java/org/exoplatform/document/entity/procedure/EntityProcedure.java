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
package org.exoplatform.document.entity.procedure;

import java.io.Serializable;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version BasePlugin.java Oct 31, 2013
 *
 */
public interface EntityProcedure<I extends Serializable> {

	/**
	 * Removes a parent from an entity
	 * 
	 * @param fileId : The ID of the entity
	 * @param folderId : The ID of the parent
	 */
	public void deleteEntity(String fileId, String folderId);
	
	/**
	 * Gets a specific parent reference
	 * 
	 * @param fileId : The ID of the entity
	 * @param parentid : The ID of the parent
	 */
	public void findEntity(String fileId, String parentid);
	
	/**
	 * Adds a parent folder for a file (entity)
	 * 
	 * @param fileId : The ID of the entity
	 */
	public void insertEntity(String fileId);
	
	/**
	 * Lists a file's parents
	 * 
	 * @param fileId  : The ID of the entity
	 */
	public void findParentsOfEntity(String fileId);
}
