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

import org.exoplatform.common.dao.model.Field;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.Sort;

/**
 * <code>MutableSearch</code> is an extension of <code>ISearch</code> that
 * provides setters for all of the properties.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version MutableSearch.java Nov 4, 2013
 */
public interface MutableSearch extends SearchImmutable {

	public MutableSearch setFirstResult(int firstResult);

	public MutableSearch setMaxResults(int maxResults);

	public MutableSearch setPage(int page);

	public MutableSearch setSearchClass(Class<?> searchClass);

	public MutableSearch setFilters(List<Filter> filters);

	public MutableSearch setDisjunction(boolean disjunction);

	public MutableSearch setSorts(List<Sort> sorts);

	public MutableSearch setFields(List<Field> fields);
	
	public MutableSearch setDistinct(boolean distinct);

	public MutableSearch setFetches(List<String> fetches);

	public MutableSearch setResultMode(int resultMode);
}
