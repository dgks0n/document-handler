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

import java.util.List;

import org.exoplatform.common.dao.model.ExampleOptions;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.SearchResult;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version SearchFacade.java Nov 4, 2013
 */
public interface SearchFacade {

	/**
	 * Search for objects based on the search parameters in the specified
	 * <code>BaseSearch</code> object.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public List search(SearchImmutable search);

	/**
	 * Search for objects based on the search parameters in the specified
	 * <code>BaseSearch</code> object. Uses the specified searchClass, ignoring the
	 * searchClass specified on the search itself.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public List search(Class<?> searchClass, SearchImmutable search);

	/**
	 * Returns the total number of results that would be returned using the
	 * given <code>BaseSearch</code> if there were no paging or maxResult limits.
	 * 
	 * @see SearchImmutable
	 */
	public int count(SearchImmutable search);

	/**
	 * Returns the total number of results that would be returned using the
	 * given <code>BaseSearch</code> if there were no paging or maxResult limits.
	 * Uses the specified searchClass, ignoring the searchClass specified on the
	 * search itself.
	 * 
	 * @see SearchImmutable
	 */
	public int count(Class<?> searchClass, SearchImmutable search);

	/**
	 * Returns a <code>SearchResult</code> object that includes the list of
	 * results like <code>search()</code> and the total length like
	 * <code>searchLength</code>.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(SearchImmutable search);

	/**
	 * Returns a <code>SearchResult</code> object that includes the list of
	 * results like <code>search()</code> and the total length like
	 * <code>searchLength</code>. Uses the specified searchClass, ignoring the
	 * searchClass specified on the search itself.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(Class<?> searchClass, SearchImmutable search);

	/**
	 * Search for a single result using the given parameters.
	 */
	public Object searchUnique(SearchImmutable search);

	/**
	 * Search for a single result using the given parameters. Uses the specified
	 * searchClass, ignoring the searchClass specified on the search itself.
	 */
	public Object searchUnique(Class<?> searchClass, SearchImmutable search);

	/**
	 * Generates a search filter from the given example using default options. 
	 */
	public Filter getFilterFromExample(Object example);

	/**
	 * Generates a search filter from the given example using the specified options. 
	 */
	public Filter getFilterFromExample(Object example, ExampleOptions options);
}
