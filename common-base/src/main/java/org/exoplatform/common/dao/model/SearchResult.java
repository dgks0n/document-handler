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
package org.exoplatform.common.dao.model;

import java.io.Serializable;
import java.util.List;

/**
 * This class is used to return the results of <code>searchAndCount()</code>
 * operations. It has just two properties: the results and the search and the
 * total (unpaged) count of the search.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version SearchResult.java Nov 4, 2013
 */
public class SearchResult<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1447210743289270917L;

	protected List<T> result;
	protected int totalCount = -1;

	/**
	 * The results of the search.
	 */
	public List<T> getResult() {
		return result;
	}

	/**
	 * The results of the search.
	 */
	public void setResult(List<T> results) {
		this.result = results;
	}

	/**
	 * The total number of results that would have been returned if no
	 * maxResults had been specified. (-1 means unspecified.)
	 */
	public int getTotalCount() {
		return totalCount;
	}

	/**
	 * The total number of results that would have been returned if no
	 * maxResults had been specified. (-1 means unspecified.)
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
