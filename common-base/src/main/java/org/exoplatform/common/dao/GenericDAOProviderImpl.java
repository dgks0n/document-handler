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
import java.lang.reflect.Array;
import java.util.List;

import org.exoplatform.common.dao.hibernate.HibernateDAOProcessor;
import org.hibernate.SessionFactory;

import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;

/**
 * Implementation of <code>GenericDAOProvider</code> using Hibernate.
 * The SessionFactory property is annotated for automatic resource injection.
 * 
 * @param <T>
 *            The type of the domain object for which this instance is to be
 *            used.
 * @param <ID>
 *            The type of the id of the domain object for which this instance is
 *            to be used.
 *            
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version GenericDAOProviderImpl.java Nov 6, 2013
 */
public class GenericDAOProviderImpl<T, ID extends Serializable> extends HibernateDAOProcessor implements GenericDAOProvider<T, ID> {
	
	protected Class<T> persistentClass = (Class<T>) HibernateDAOUtil.getTypeArguments(GenericDAOProviderImpl.class, this.getClass()).get(0);
	
	public GenericDAOProviderImpl(SessionFactory sessionFactory) {
		super(sessionFactory);
	}

	@Override
	public T find(ID id) {
		return _getEntity(persistentClass, id);
	}

	@Override
	public T[] find(ID... ids) {
		return _getEntities(persistentClass, ids);
	}

	@Override
	public T getReference(ID id) {
		return _loadEntity(persistentClass, id);
	}

	@Override
	public T[] getReferences(ID... ids) {
		return _loadEntities(persistentClass, ids);
	}

	@Override
	public void persist(T... entities) {
		_persistEntities(entities);
	}

	@Override
	public T save(T entity) {
		if (entity == null || !persistentClass.isInstance(entity)) {
			throw new IllegalArgumentException("Object class does not match dao type.");
		}
		
		return _getEntity(persistentClass, _saveEntity(entity));
	}

	@Override
	public T[] save(T... entities) {
		T[] savedEntities = (T[]) Array.newInstance(persistentClass, entities.length);
		for (int j = 0; j < entities.length; j++) {
			savedEntities[j] = save(entities[j]);
		}
		return savedEntities;
	}

	@Override
	public boolean remove(T entity) {
		return _deleteEntity(entity);
	}

	@Override
	public void remove(T... entities) {
		_deleteEntities(entities);
	}

	@Override
	public boolean removeById(ID id) {
		return _deleteEntityById(persistentClass, id);
	}

	@Override
	public void removeByIds(ID... ids) {
		_deleteEntityById(persistentClass, ids);
	}

	@Override
	public List<T> findAll() {
		return _allEnties(persistentClass);
	}

	@Override
	public <RT> List<RT> search(SearchCriterion parameters) {
		if (parameters == null) {
			return (List<RT>) findAll();
		}
		return _searchEntity(persistentClass, parameters);
	}

	@Override
	public <RT> RT searchUnique(SearchCriterion parameters) {
		return (RT) _searchUniqueEntity(persistentClass, parameters);
	}

	@Override
	public int count(SearchCriterion parameters) {
		if (parameters == null) {
			parameters = (SearchCriterion) new Search();
		}
		return _countEntity(persistentClass, parameters);
	}

	@Override
	public <RT> SearchResult<RT> searchAndCount(SearchCriterion parameters) {
		if (parameters == null) {
			SearchResult<RT> result = new SearchResult<RT>();
			result.setResult((List<RT>) findAll());
			result.setTotalCount(result.getResult().size());
			return result;
		}
		return _searchAndCountEntity(persistentClass, parameters);
	}

	@Override
	public boolean isAttached(T entity) {
		return _sessionContains(entity);
	}

	@Override
	@Deprecated
	public boolean isConnected(Object object) {
		return _sessionContains(object);
	}

	@Override
	public void refresh(T... entities) {
		_refreshEntities(entities);
	}

	@Override
	public void flush() {
		_flush();
	}

	@Override
	public T merge(T entity) {
		return _mergeEntity(entity);
	}

}
