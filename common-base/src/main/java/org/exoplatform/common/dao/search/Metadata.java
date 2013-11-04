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
 * This interface provides meta data for a single persistable type. Use
 * {@link MetadataHandler#get(Class)} or {@link MetadataHandler#get(Class, String)} to
 * get meta data instances.
 * 
 * This interface provides a layer of abstraction between the framework and the
 * underlying JPA provider (ex. Hibernate). By switching out the implementation
 * of this interface, the framework should be able to be used with different JPA
 * providers.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version Metadata.java Nov 4, 2013
 */
public interface Metadata {

	/**
	 * Return true if the type is an entity.
	 */
	public boolean isEntity();

	/**
	 * Return true if the type is an embeddable class (a component class in
	 * Hibernate).
	 */
	public boolean isEmeddable();

	/**
	 * Return true if the type is a collection.
	 */
	public boolean isCollection();

	/**
	 * Return true if the type is persisted as a string (char or varchar) type
	 * in the database.
	 */
	public boolean isString();

	/**
	 * Return true if the type is a number. For example: int, Float, Number,
	 * double, etc.
	 */
	public boolean isNumeric();

	/**
	 * Return the Java class of this type. If the type is a collection, return
	 * the type of the collection elements.
	 */
	public Class<?> getJavaClass();

	/**
	 * If the type is an entity return the entity name. Otherwise throw an
	 * UnsupportedOperationException.
	 */
	public String getEntityName();

	/**
	 * Return an array of the names of all the properties that this type has, if
	 * any. Return null if this a simple value type with no properties.
	 */
	public String[] getProperties();

	/**
	 * Return the value of the given property of the given object of this type.
	 * Return null if this a simple value type with no properties.
	 */
	public Object getPropertyValue(Object object, String property);

	/**
	 * Return the metadata for the given property of this type. Return null if
	 * this a simple value type with no properties.
	 */
	public Metadata getPropertyType(String property);

	/**
	 * Return the name of the id property of this type. Return null if this is
	 * not an entity type.
	 */
	public String getIdProperty();

	/**
	 * Return the metadata for the id property of this type. Return null if this
	 * is not an entity type.
	 */
	public Metadata getIdType();

	/**
	 * Return the value of the id property of the given object of this type.
	 * Return null if this is not an entity type.
	 */
	public Serializable getIdValue(Object object);

	/**
	 * If the type is a collection, return the Java class of the collection
	 * itself, not the Java class of it's elements as with
	 * {@link #getJavaClass()}. For example: ArrayList&lt;Project&gt;,
	 * Set&lt;Person&gt;, String[].
	 */
	public Class<?> getCollectionClass();
}
