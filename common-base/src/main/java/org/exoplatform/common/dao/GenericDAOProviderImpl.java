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

import com.googlecode.genericdao.dao.DAOUtil;
import com.googlecode.genericdao.dao.hibernate.HibernateBaseDAO;
import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
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
public class GenericDAOProviderImpl<T, ID extends Serializable> extends HibernateBaseDAO implements GenericDAOProvider<T, ID> {
	
	protected Class<T> persistentClass = (Class<T>) DAOUtil.getTypeArguments(GenericDAOProviderImpl.class, this.getClass()).get(0);

	@Override
	public T find(ID id) {
		return _get(persistentClass, id);
	}

	@Override
	public T[] find(ID... ids) {
		return _get(persistentClass, ids);
	}

	@Override
	public T getReference(ID id) {
		return _load(persistentClass, id); 
	}

	@Override
	public T[] getReferences(ID... ids) {
		return _load(persistentClass, ids);
	}

	@Override
	public void persist(T... entities) {
		
	}

	@Override
	public T merge(T entity) {
		return merge(entity);
	}

	@Override
	public T[] merge(T... entities) {
		return null;
	}

	@Override
	public T save(T entity) {
		return null;
	}

	@Override
	public T[] save(T... entities) {
		// TODO Auto-generated method stub
		return null;
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
		return _deleteById(persistentClass, id);
	}

	@Override
	public void removeByIds(ID... ids) {
		_deleteById(persistentClass, ids);
	}

	@Override
	public List<T> findAll() {
		return _all(persistentClass);
	}

	@Override
	public <RT> List<RT> search(SearchParameters parameters) {
		if (parameters == null) {
			return (List<RT>) findAll();
		}
		return _search(persistentClass, parameters);
	}

	@Override
	public <RT> RT searchUnique(SearchParameters parameters) {
		return (RT) _searchUnique(persistentClass, parameters);
	}

	@Override
	public int count(SearchParameters parameters) {
		if (parameters == null) {
			parameters = (SearchParameters) new Search();
		}
		return _count(persistentClass, parameters);
	}

	@Override
	public <RT> SearchResult<RT> searchAndCount(SearchParameters parameters) {
		if (parameters == null) {
			SearchResult<RT> result = new SearchResult<RT>();
			result.setResult((List<RT>) findAll());
			result.setTotalCount(result.getResult().size());
			return result;
		}
		return _searchAndCount(persistentClass, parameters);
	}

	@Override
	public boolean isAttached(T entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConnected(Object object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refresh(T... entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void flush() {
		_flush();
	}

	@Override
	public Filter getFilterFromExample(T example) {
		return _getFilterFromExample(example);
	}

	@Override
	public Filter getFilterFromExample(T example, ExampleOptions options) {
		return _getFilterFromExample(example, options);
	}

}
