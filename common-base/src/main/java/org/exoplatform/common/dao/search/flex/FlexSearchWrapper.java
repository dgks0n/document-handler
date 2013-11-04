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
package org.exoplatform.common.dao.search.flex;

import java.util.List;

import org.exoplatform.common.dao.model.Field;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.Sort;
import org.exoplatform.common.dao.search.SearchImmutable;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version FlexSearchWrapper.java Nov 4, 2013
 */
public class FlexSearchWrapper implements SearchImmutable {

	FlexSearch search;

	public FlexSearchWrapper(FlexSearch flexSearch) {
		search = flexSearch;
	}

	public List<String> getFetches() {
		return search.fetches;
	}

	public List<Field> getFields() {
		return search.fields;
	}

	public List<Filter> getFilters() {
		return search.filters;
	}

	public int getFirstResult() {
		return search.firstResult;
	}

	public int getMaxResults() {
		return search.maxResults;
	}

	public int getPage() {
		return search.page;
	}

	public int getResultMode() {
		return search.resultMode;
	}

	public Class<?> getSearchClass() {
		if (search.searchClassName == null || "".equals(search.searchClassName)) {
			return null;
		} else {
			try {
				return Class.forName(search.searchClassName);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}
	}

	public List<Sort> getSorts() {
		return search.sorts;
	}

	public boolean isDisjunction() {
		return search.disjunction;
	}

	public boolean isDistinct() {
		return search.distinct;
	}
}
