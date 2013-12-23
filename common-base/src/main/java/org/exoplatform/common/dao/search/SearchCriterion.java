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

import com.googlecode.genericdao.search.ISearch;

/**
 * The base search DTO (data transfer object). A Search object is passed into a
 * DAO or Search Processor to define the parameters for a search. There are six
 * types of parameters that can be set.
 * <ul>
 * <li>SearchClass - The Class of the object(s) to search for.
 * <li>Filters - Any number of filters may be specified for the search. Filters
 * specify a property and a condition that it must match for the object to be
 * included in the result. Filters are "ANDed" together by default, but
 * disjunction (OR) can be used instead by setting
 * <code>disjunction == true</code>. See also the {@link Filter} class.
 * <li>Sorts - Any number of sorts may be specified. Each sort consists of a
 * property, a flag for ascending or descending and a flag for whether or not to
 * ignore case. The first sort added is the primary sort, the second, secondary
 * and so on. See also the {@link Sort} class.
 * <li>Fields - By default the entity specified in search class is returned as
 * the result for each row. However, by specifying fields, any combination of
 * individual properties can be returned for each row in the result set. These
 * properties can be returned as maps, lists, arrays or a single object
 * depending on <code>resultMode</code>. See also the {@link Field} class.<br/>
 * <br/>
 * 
 * Additionally, fields can be specified using column operators:
 * <code>COUNT, COUNT DISTINCT, SUM, AVG, MAX, MIN</code>. Note that fields with
 * column operators can not be mixed with fields that do not use column
 * operators.<br/>
 * <br/>
 * 
 * Set <code>distinct</code> to <code>true</code> in order to filter out
 * duplicate results.<br/>
 * <br/>
 * 
 * <li>Fetch - This determines which attached objects to pull along with the
 * base search object. With Hibernate this eagerly loads the specified
 * properties. Otherwise they might be loaded lazily. This is useful for
 * performance and results that will be disconnected from Hibernate and copied
 * to a remote client.
 * <li>Paging - The maximum number of results may be specified with
 * <code>maxResults</code>. (This can also be thought of as results per page.)
 * The first result can be specified using either <code>firstResult</code> or
 * <code>page</code>.
 * </ul>
 * 
 * <code>ISearch</code> is intended to be an immutable interface and only
 * provides getters for each of the properties. The {@link IMutableSearch}
 * interface extends <code>ISearch</code> by adding setters for all the
 * properties.
 * 
 * @see Filter
 * @see Field
 * @see Sort
 * @see IMutableSearch
 * 
 *      Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 * 
 * @version SearchParameters.java Nov 5, 2013
 */
public interface SearchCriterion extends ISearch {

}
