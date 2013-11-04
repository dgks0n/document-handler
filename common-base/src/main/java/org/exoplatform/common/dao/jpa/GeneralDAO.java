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
package org.exoplatform.common.dao.jpa;

import java.io.Serializable;
import java.util.List;

import org.exoplatform.common.dao.model.ExampleOptions;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.SearchResult;
import org.exoplatform.common.dao.search.SearchImmutable;

/**
 * Interface for general Data Access Object that can be used for any type domain
 * object. A single instance implementing this interface can be used for
 * multiple types of domain objects.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version GeneralDAO.java Nov 4, 2013
 */
public interface GeneralDAO {

	/**
	 * <p>
	 * Get the entity with the specified type and id from the datastore.
	 * 
	 * <p>
	 * If none is found, return null.
	 */
	public <T> T find(Class<T> type, Serializable id);

	/**
	 * Get all entities of the specified type from the datastore that have one
	 * of these ids. An array of entities is returned that matches the same
	 * order of the ids listed in the call. For each entity that is not found in
	 * the datastore, a null will be inserted in its place in the return array.
	 */
	public <T> T[] find(Class<T> type, Serializable... ids);

	/**
	 * <p>
	 * Get a reference to the entity with the specified type and id from the
	 * datastore.
	 * 
	 * <p>
	 * This does not require a call to the datastore and does not populate any
	 * of the entity's values. Values may be fetched lazily at a later time.
	 * This increases performance if a another entity is being saved that should
	 * reference this entity but the values of this entity are not needed.
	 * 
	 * @throws a
	 *             HibernateException if no matching entity is found
	 */
	public <T> T getReference(Class<T> type, Serializable id);

	/**
	 * <p>
	 * Get a reference to the entities of the specified type with the given ids
	 * from the datastore. An array of entities is returned that matches the
	 * same order of the ids listed in the call.
	 * 
	 * <p>
	 * This does not require a call to the datastore and does not populate any
	 * of the entities' values. Values may be fetched lazily at a later time.
	 * This increases performance if a another entity is being saved that should
	 * reference these entities but the values of these entities are not needed.
	 * 
	 * @throws a
	 *             HibernateException if any of the matching entities are not
	 *             found.
	 */
	public <T> T[] getReferences(Class<T> type, Serializable... ids);

	/**
	 * <p>
	 * Make a transient instance persistent and add it to the datastore. This
	 * operation cascades to associated instances if the association is mapped
	 * with cascade="persist". Throws an error if the entity already exists.
	 * 
	 * <p>
	 * Does not guarantee that the object will be assigned an identifier
	 * immediately. With <code>persist</code> a datastore-generated id may not
	 * be pulled until flush time.
	 */
	public void persist(Object... entities);

	/**
	 * <p>
	 * Copy the state of the given object onto the persistent object with the
	 * same identifier. If there is no persistent instance currently associated
	 * with the session, it will be loaded. Return the persistent instance. If
	 * the given instance is unsaved, save a copy and return it as a newly
	 * persistent instance.
	 * 
	 * <p>
	 * The instance that is passed in does not become associated with the
	 * session. This operation cascades to associated instances if the
	 * association is mapped with cascade="merge".
	 */
	public <T> T merge(T entity);

	/**
	 * <p>
	 * Copy the state of the given objects onto the persistent objects with the
	 * same identifier. If there is no persistent instance currently associated
	 * with the session, it will be loaded. Return the persistent instances. If
	 * a given instance is unsaved, save a copy and return it as a newly
	 * persistent instance.
	 * 
	 * <p>
	 * The instances that are passed in do not become associated with the
	 * session. This operation cascades to associated instances if the
	 * association is mapped with cascade="merge".
	 */
	public Object[] merge(Object... entities);
	
	/**
	 * If an entity with the same ID already exists in the database, merge the
	 * changes into that entity. If not persist the given entity. In either
	 * case, a managed entity with the changed values is returned. It may or may
	 * not be the same object as was passed in.
	 */
	public <T> T save(T entity);

	/**
	 * <p>
	 * For each entity: If an entity with the same ID already exists in the
	 * database, merge the changes into that entity. If not persist the given
	 * entity. In either case, a managed entity with the changed values is
	 * returned. It may or may not be the same object as was passed in.
	 * 
	 * @return an array containing each managed entity corresponding to the
	 *         entities passed in.
	 */
	public Object[] save(Object... entities);
	
	/**
	 * Remove the specified entity from the datastore.
	 * 
	 * @return <code>true</code> if the entity is found in the datastore and
	 *         removed, <code>false</code> if it is not found.
	 */
	public boolean remove(Object entity);

	/**
	 * Remove all of the specified entities from the datastore.
	 */
	public void remove(Object... entities);

	/**
	 * Remove the entity with the specified type and id from the datastore.
	 * 
	 * @return <code>true</code> if the entity is found in the datastore and
	 *         removed, <code>false</code> if it is not found.
	 */
	public boolean removeById(Class<?> type, Serializable id);

	/**
	 * Remove all the entities of the given type from the datastore that have
	 * one of these ids.
	 */
	public void removeByIds(Class<?> type, Serializable... ids);

	/**
	 * Get a list of all the objects of the specified type.
	 */
	public <T> List<T> findAll(Class<T> type);

	/**
	 * Search for objects given the search parameters in the specified
	 * <code>SearchImmutable</code> object.
	 */
	@SuppressWarnings("unchecked")
	public List search(SearchImmutable search);

	/**
	 * Search for a single result using the given parameters.
	 */
	public Object searchUnique(SearchImmutable search);

	/**
	 * Returns the total number of results that would be returned using the
	 * given <code>SearchImmutable</code> if there were no paging or maxResults limits.
	 */
	public int count(SearchImmutable search);

	/**
	 * Returns a <code>SearchResult</code> object that includes both the list of
	 * results like <code>search()</code> and the total length like
	 * <code>count()</code>.
	 */
	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(SearchImmutable search);

	/**
	 * Returns <code>true</code> if the object is connected to the current
	 * Hibernate session.
	 */
	public boolean isAttached(Object entity);

	/**
	 * Refresh the content of the given entity from the current datastore state.
	 */
	public void refresh(Object... entities);

	/**
	 * Flushes changes in the Hibernate session to the datastore.
	 */
	public void flush();

	/**
	 * Generates a search filter from the given example using default options.
	 */
	public Filter getFilterFromExample(Object example);

	/**
	 * Generates a search filter from the given example using the specified
	 * options.
	 */
	public Filter getFilterFromExample(Object example, ExampleOptions options);
}
