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

import org.exoplatform.common.dao.DAOUtil;
import org.exoplatform.common.dao.model.ExampleOptions;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.SearchResult;
import org.exoplatform.common.dao.search.Search;
import org.exoplatform.common.dao.search.SearchImmutable;

/**
 * Implementation of <code>GenericDAO</code> using Hibernate.
 * The SessionFactory property is annotated for automatic resource injection.
 * 
 * @author dwolverton
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
 * @version GenericDAOImpl.java Nov 4, 2013
 */
public class GenericDAOImpl<T, ID extends Serializable> extends JPABaseDAO implements GenericDAO<T, ID> {

	protected Class<T> persistentClass = (Class<T>) DAOUtil.getTypeArguments(GenericDAOImpl.class, this.getClass()).get(0);

	public int count(SearchImmutable search) {
		if (search == null)
			search = new Search();
		return _count(persistentClass, search);
	}

	public T find(ID id) {
		return _find(persistentClass, id);
	}

	public T[] find(ID... ids) {
		return _find(persistentClass, ids);
	}

	public List<T> findAll() {
		return _all(persistentClass);
	}

	public void flush() {
		_flush();
	}

	public T getReference(ID id) {
		return _getReference(persistentClass, id);
	}

	public T[] getReferences(ID... ids) {
		return _getReferences(persistentClass, ids);
	}

	public boolean isAttached(T entity) {
		return _contains(entity);
	}

	public void refresh(T... entities) {
		_refresh(entities);
	}

	public boolean remove(T entity) {
		return _removeEntity(entity);
	}

	public void remove(T... entities) {
		_removeEntities((Object[]) entities);
	}

	public boolean removeById(ID id) {
		return _removeById(persistentClass, id);
	}

	public void removeByIds(ID... ids) {
		_removeByIds(persistentClass, ids);
	}

	public T merge(T entity) {
		return _merge(entity);
	}

	public T[] merge(T... entities) {
		return _merge(persistentClass, entities);
	}

	public void persist(T... entities) {
		_persist(entities);
	}
	
	public T save(T entity) {
		return _persistOrMerge(entity);
	}

	public T[] save(T... entities) {
		return _persistOrMerge(persistentClass, entities);
	}

	public <RT> List<RT> search(SearchImmutable search) {
		if (search == null)
			return (List<RT>) findAll();
		return _search(persistentClass, search);
	}

	public <RT> SearchResult<RT> searchAndCount(SearchImmutable search) {
		if (search == null) {
			SearchResult<RT> result = new SearchResult<RT>();
			result.setResult((List<RT>) findAll());
			result.setTotalCount(result.getResult().size());
			return result;
		}
		return _searchAndCount(persistentClass, search);
	}

	public <RT> RT searchUnique(SearchImmutable search) {
		return (RT) _searchUnique(persistentClass, search);
	}

	public Filter getFilterFromExample(T example) {
		return _getFilterFromExample(example);
	}

	public Filter getFilterFromExample(T example, ExampleOptions options) {
		return _getFilterFromExample(example, options);
	}
}
