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
package org.exoplatform.common.dao.search;

import java.io.Serializable;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version MetadataUtil.java Nov 4, 2013
 */
public interface MetadataHandler {

	/**
	 * Get the value of the ID property of an entity.
	 */
	public Serializable getId(Object object);

	/**
	 * Return true if the property at the given property path is the id of some
	 * entity.
	 */
	public boolean isId(Class<?> rootClass, String propertyPath);

	/**
	 * Get the Metadata for an entity class.
	 * 
	 * @throws IllegalArgumentException
	 *             if the class is not a Hibernate entity.
	 */
	public Metadata get(Class<?> klass) throws IllegalArgumentException;

	/**
	 * Get the Metadata for a property of an entity class. The property can be
	 * simple ("name") or nested ("organization.name").
	 * 
	 * @throws IllegalArgumentException
	 *             if the root class is not a Hibernate entity.
	 * @throws IllegalArgumentException
	 *             if the class does not have the given property.
	 */
	public Metadata get(Class<?> rootEntityClass, String propertyPath) throws IllegalArgumentException;
	
	/**
	 * Return the actual entity class registered with the persistence provider.
	 * This may be the same class or it may be different if the given class is
	 * is a proxy. For example, the entity class may be Person, but the class
	 * of the proxy may be Person_$$_javassist_5. We need to normalize this to
	 * Person so that we can create correct queries and inspect metadata correctly.
	 */
	public <T> Class<T> getUnproxiedClass(Class<?> klass);
	
	/**
	 * Return the actual entity class registered with the persistence provider.
	 * This may be the same as entity.getClass() or it may be different if the object is
	 * is a proxy. For example, the entity class may be Person, but the class
	 * of the proxy object may be Person_$$_javassist_5. We need to normalize this to
	 * Person so that we can create correct queries and inspect metadata correctly.
	 */
	public <T> Class<T> getUnproxiedClass(Object entity);
}
