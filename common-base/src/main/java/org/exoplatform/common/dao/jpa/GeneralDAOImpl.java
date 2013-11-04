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
 * Implementation of <code>GeneralDAO</code> using Hibernate.
 * The SessionFactory property is annotated for automatic resource injection.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version GeneralDAOImpl.java Nov 4, 2013
 */
public class GeneralDAOImpl extends JPABaseDAO implements GeneralDAO {

	public int count(SearchImmutable search) {
		return _count(search);
	}

	public <T> T find(Class<T> type, Serializable id) {
		return (T) _find(type, id);
	}

	public <T> T[] find(Class<T> type, Serializable... ids) {
		return _find(type, ids);
	}

	public <T> List<T> findAll(Class<T> type) {
		return _all(type);
	}

	public void flush() {
		_flush();
	}

	public <T> T getReference(Class<T> type, Serializable id) {
		return _getReference(type, id);
	}

	public <T> T[] getReferences(Class<T> type, Serializable... ids) {
		return _getReferences(type, ids);
	}

	public boolean isAttached(Object entity) {
		return _contains(entity);
	}

	public void refresh(Object... entities) {
		_refresh(entities);
	}

	public boolean remove(Object entity) {
		return _removeEntity(entity);
	}

	public void remove(Object... entities) {
		_removeEntities(entities);
	}

	public boolean removeById(Class<?> type, Serializable id) {
		return _removeById(type, id);
	}

	public void removeByIds(Class<?> type, Serializable... ids) {
		_removeByIds(type, ids);
	}

	public <T> T merge(T entity) {
		return _merge(entity);
	}

	public Object[] merge(Object... entities) {
		return _merge(Object.class, entities);
	}

	public void persist(Object... entities) {
		_persist(entities);
	}

	public <T> T save(T entity) {
		return _persistOrMerge(entity);
	}

	public Object[] save(Object... entities) {
		return _persistOrMerge(Object.class, entities);
	}

	public List search(SearchImmutable search) {
		return _search(search);
	}

	public SearchResult searchAndCount(SearchImmutable search) {
		return _searchAndCount(search);
	}

	public Object searchUnique(SearchImmutable search) {
		return _searchUnique(search);
	}

	public Filter getFilterFromExample(Object example) {
		return _getFilterFromExample(example);
	}

	public Filter getFilterFromExample(Object example, ExampleOptions options) {
		return _getFilterFromExample(example, options);
	}

}
