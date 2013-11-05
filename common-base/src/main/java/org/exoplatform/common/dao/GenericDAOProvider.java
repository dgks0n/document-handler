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

import com.googlecode.genericdao.dao.hibernate.original.GenericDAO;
import com.googlecode.genericdao.search.SearchResult;

/**
 * Interface for a Data Access Object that can be used for a single specified
 * type domain object. A single instance implementing this interface can be used
 * only for the type of domain object specified in the type parameters.
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
 * @version GenericDAOProvider.java Nov 5, 2013
 */
public interface GenericDAOProvider<T, ID extends Serializable> extends GenericDAO<T, ID> {
	
	/**
	 * Search for entities given the search parameters in the specified
	 * <code>SearchParameters</code> object.
	 * 
	 * @param RT The result type is automatically determined by the context in which the method is called.
	 */
	public <RT> List<RT> search(SearchParameters parameters);
	
	/**
	 * Search for a single entity using the given parameters.
	 * 
	 * @param RT The result type is automatically determined by the context in which the method is called.
	 */
	public <RT> RT searchUnique(SearchParameters parameters);

	/**
	 * Returns the total number of results that would be returned using the
	 * given <code>SearchParameters</code> if there were no paging or maxResults limits.
	 */
	public int count(SearchParameters parameters);

	/**
	 * Returns a <code>SearchResult</code> object that includes both the list of
	 * results like <code>search()</code> and the total length like
	 * <code>count()</code>.
	 * 
	 * @param RT The result type is automatically determined by the context in which the method is called.
	 */
	public <RT> SearchResult<RT> searchAndCount(SearchParameters parameters);
}
