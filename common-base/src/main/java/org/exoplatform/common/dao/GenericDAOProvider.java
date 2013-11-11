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
package org.exoplatform.common.dao;

import java.io.Serializable;
import java.util.List;

import com.googlecode.genericdao.search.SearchResult;

/**
 * Interface for a Data Access Object that can be used for a single specified
 * type domain object. A single instance implementing this interface can be used
 * only for the type of domain object specified in the type parameters.
 * 
 * @param <T>
 *            The type of the domain object for which this instance is to be used.
 * @param <ID>
 *            The type of the id of the domain object for which this instance is to be used.
 *            
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version GenericDAOProvider.java Nov 5, 2013
 */
public interface GenericDAOProvider<T, ID extends Serializable> {
	
	/**
	 * <p>
	 * Get the entity with the specified type and id from the datastore.
	 * 
	 * <p>
	 * If none is found, return null.
	 */
	public T find(ID id);

	/**
	 * Get all entities of the specified type from the datastore that have one
	 * of these ids.
	 */
	public T[] find(ID... ids);

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
	 * @throws IllegalArgumentException if the first argument does
     *         not denote an entity type or the second argument is
     *         not a valid type for that entityÂ’s primary key or
     *         is null
     * @throws javax.persistence.EntityNotFoundException if the entity state
     *         cannot be accessed
	 */
	public T getReference(ID id);

	/**
	 * <p>
	 * Get a reference to the entities of the specified type with the given ids
	 * from the datastore.
	 * 
	 * <p>
	 * This does not require a call to the datastore and does not populate any
	 * of the entities' values. Values may be fetched lazily at a later time.
	 * This increases performance if a another entity is being saved that should
	 * reference these entities but the values of these entities are not needed.
	 * 
	 * @throws IllegalArgumentException if the first argument does
     *         not denote an entity type or the second argument is
     *         not a valid type for that entityÂ’s primary key or
     *         is null
     * @throws javax.persistence.EntityNotFoundException if the entity state
     *         cannot be accessed
	 */
	public T[] getReferences(ID... ids);

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
	public void persist(T... entities);

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
	public T merge(T entity);
	
	/**
	 * If an entity with the same ID already exists in the database, merge the
	 * changes into that entity. If not persist the given entity. In either
	 * case, a managed entity with the changed values is returned. It may or may
	 * not be the same object as was passed in.
	 */
	public T save(T entity);

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
	public T[] save(T... entities);

	/**
	 * Remove the specified entity from the datastore.
	 * 
	 * @return <code>true</code> if the entity is found in the datastore and
	 *         removed, <code>false</code> if it is not found.
	 */
	public boolean remove(T entity);

	/**
	 * Remove all of the specified entities from the datastore.
	 */
	public void remove(T... entities);

	/**
	 * Remove the entity with the specified type and id from the datastore.
	 * 
	 * @return <code>true</code> if the entity is found in the datastore and
	 *         removed, <code>false</code> if it is not found.
	 */
	public boolean removeById(ID id);

	/**
	 * Remove all the entities of the given type from the datastore that have
	 * one of these ids.
	 */
	public void removeByIds(ID... ids);

	/**
	 * Get a list of all the objects of the specified type.
	 */
	public List<T> findAll();

	/**
	 * Search for entities given the search parameters in the specified
	 * <code>ISearch</code> object.
	 * 
	 * @param RT The result type is automatically determined by the context in which the method is called.
	 */
	public <RT> List<RT> search(SearchCriterion parameters);

	/**
	 * Search for a single entity using the given parameters.
	 * 
	 * @param RT The result type is automatically determined by the context in which the method is called.
	 */
	public <RT> RT searchUnique(SearchCriterion parameters);

	/**
	 * Returns the total number of results that would be returned using the
	 * given <code>ISearch</code> if there were no paging or maxResults limits.
	 */
	public int count(SearchCriterion parameters);

	/**
	 * Returns a <code>SearchResult</code> object that includes both the list of
	 * results like <code>search()</code> and the total length like
	 * <code>count()</code>.
	 * 
	 * @param RT The result type is automatically determined by the context in which the method is called.
	 */
	public <RT> SearchResult<RT> searchAndCount(SearchCriterion parameters);

	/**
	 * Returns <code>true</code> if the object is connected to the current
	 * Hibernate session.
	 */
	public boolean isAttached(T entity);
	
	/**
	 * Returns true if the object is connected to the current Hibernate session.
	 * 
	 * @deprecated Use {@link #isAttached(Object)}
	 */
	@Deprecated
	public boolean isConnected(Object object);

	/**
	 * Refresh the content of the given entity from the current datastore state.
	 */
	public void refresh(T... entities);

	/**
	 * Flushes changes in the Hibernate session to the datastore.
	 */
	public void flush();
}
