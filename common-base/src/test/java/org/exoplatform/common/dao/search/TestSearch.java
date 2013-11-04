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

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.exoplatform.common.dao.model.Field;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.Sort;
import org.exoplatform.common.dao.util.SearchUtil;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version TestSearch.java Nov 4, 2013
 */
public class TestSearch {

	@Test
	public void testToString() {
		Search s = new Search();
		System.out.println(s);

		s.setSearchClass(TestSearch.class);
		s.setDisjunction(true);
		s.setFirstResult(-44);
		s.setMaxResults(19);
		s.setPage(0);
		s.setResultMode(Search.RESULT_ARRAY);

		s.addField("home.type");
		s.addFilterEqual("father.firstName", "ABC");
		s.addSortAsc("home.address.type");

		System.out.println(s);

		s.setSearchClass(Search.class);

		s.addField("home", Field.OP_AVG);
		s.addField("sally's home", Field.OP_COUNT);
		s.addField("pork", Field.OP_COUNT_DISTINCT);
		s.addField("some pig", Field.OP_MAX);
		s.addField(new Field("", Field.OP_MIN));
		s.addField(new Field(null, Field.OP_SUM));
		s.addField("4th limb", 6000);
		s.addField((Field) null);

		s.addFilterGreaterThan("gt", "nine");
		s.addFilterLessThan("lt", 9);
		s.addFilterGreaterOrEqual("ge", 8.2293);
		s.addFilterLessOrEqual("le", null);
		s.addFilterAnd(Filter.notEqual("ne", 11), Filter.in("mine.in", 22, 23, 24, 25, "Cartons"), Filter.or(Filter
				.not(Filter.notIn("marm.not.in", 33, 34, 35)), Filter.like("dog.like", "mant*s"), Filter.ilike(
				"cat.ilike", "Mon%")));
		s.addFilter(new Filter(null, null, -3));
		s.addFilter((Filter) null);
		s.addFilterNull("nullProp");
		s.addFilterNotNull("notNullProp");
		s.addFilterEmpty("emptyProp");
		s.addFilterNotEmpty("notEmptyProp");

		s.addSort("more.sorts", true);
		s.addSort(new Sort(null, false));
		s.addSort((Sort) null);
		System.out.println(s);
	}

	@Test
	public void testMergeSorts() {
		Search s = new Search();

		Map<String, Sort> sorts = new HashMap<String, Sort>();
		sorts.put("a+", Sort.asc("alpha"));
		sorts.put("a-", Sort.desc("alpha"));
		sorts.put("b+", Sort.asc("beta"));
		sorts.put("b-", Sort.desc("beta"));
		sorts.put("g+", Sort.asc("gamma", true));

		s.setSorts(null);
		SearchUtil.mergeSortsAfter(s, sorts.get("a-"), sorts.get("b+"));
		assertTrue(collectionEquals(s.getSorts(), sorts.get("a-"), sorts.get("b+")));

		s.setSorts(null);
		SearchUtil.mergeSortsBefore(s, sorts.get("a-"), sorts.get("b+"));
		assertTrue(collectionEquals(s.getSorts(), sorts.get("a-"), sorts.get("b+")));

		s.setSorts(new ArrayList<Sort>());
		SearchUtil.mergeSortsAfter(s, sorts.get("a-"), sorts.get("b+"));
		assertTrue(collectionEquals(s.getSorts(), sorts.get("a-"), sorts.get("b+")));

		s.setSorts(new ArrayList<Sort>());
		SearchUtil.mergeSortsBefore(s, sorts.get("a-"), sorts.get("b+"));
		assertTrue(collectionEquals(s.getSorts(), sorts.get("a-"), sorts.get("b+")));

		s.clearSorts();
		s.addSort(sorts.get("g+"));
		s.addSort(sorts.get("a+"));
		SearchUtil.mergeSortsBefore(s, sorts.get("a-"), sorts.get("b+"));
		assertTrue(collectionEquals(s.getSorts(), sorts.get("a-"), sorts.get("b+"), sorts.get("g+")));
		
		s.clearSorts();
		s.addSort(sorts.get("g+"));
		s.addSort(sorts.get("a+"));
		SearchUtil.mergeSortsAfter(s, sorts.get("a-"), sorts.get("b+"));
		assertTrue(collectionEquals(s.getSorts(), sorts.get("g+"), sorts.get("a+"), sorts.get("b+") ));
	}
	
	@Test
	public void testMergeFetches() {
		Search s = new Search();
		
		s.setFetches(null);
		SearchUtil.mergeFetches(s, "alpha", "beta");
		assertTrue(collectionEquals(s.getFetches(), "alpha", "beta"));
		
		s.setFetches(new ArrayList<String>());
		SearchUtil.mergeFetches(s, "alpha", "beta");
		assertTrue(collectionEquals(s.getFetches(), "alpha", "beta"));
		
		s.clear();
		s.addFetch("alpha");
		s.addFetch("gamma");
		SearchUtil.mergeFetches(s, "alpha", "beta");
		assertTrue(collectionEquals(s.getFetches(), "alpha", "gamma", "beta"));
	}
	
	@Test
	public void testMergeFilters() {
		Search s = new Search();
		
		Map<String, Filter> filters = new HashMap<String, Filter>();
		filters.put("alpha", Filter.equal("alpha", "A"));
		filters.put("beta", Filter.equal("beta", "B"));
		filters.put("gamma", Filter.equal("gamma", "G"));
		filters.put("delta", Filter.equal("delta", "D"));
		
		s.setFilters(null);
		s.setDisjunction(true);
		SearchUtil.mergeFiltersAnd(s, filters.get("alpha"), filters.get("beta"));
		assertTrue(collectionEquals(s.getFilters(), filters.get("alpha"), filters.get("beta")));
		assertFalse(s.isDisjunction());
		
		s.setFilters(new ArrayList<Filter>());
		SearchUtil.mergeFiltersAnd(s, filters.get("alpha"), filters.get("beta"));
		assertTrue(collectionEquals(s.getFilters(), filters.get("alpha"), filters.get("beta")));
		assertFalse(s.isDisjunction());
		
		s.setFilters(null);
		s.setDisjunction(false);
		SearchUtil.mergeFiltersOr(s, filters.get("alpha"), filters.get("beta"));
		assertTrue(collectionEquals(s.getFilters(), filters.get("alpha"), filters.get("beta")));
		assertTrue(s.isDisjunction());
		
		s.setFilters(new ArrayList<Filter>());
		SearchUtil.mergeFiltersOr(s, filters.get("alpha"), filters.get("beta"));
		assertTrue(collectionEquals(s.getFilters(), filters.get("alpha"), filters.get("beta")));
		assertTrue(s.isDisjunction());
		
		s.clear();
		s.addFilter(filters.get("alpha"));
		s.addFilter(filters.get("beta"));
		SearchUtil.mergeFiltersAnd(s, filters.get("beta"), filters.get("gamma"));
		assertTrue(collectionEquals(s.getFilters(), filters.get("alpha"), filters.get("beta"), filters.get("beta"), filters.get("gamma")));
		assertFalse(s.isDisjunction());
		
		s.clear();
		s.addFilter(filters.get("alpha"));
		s.addFilter(filters.get("beta"));
		s.setDisjunction(true);
		SearchUtil.mergeFiltersAnd(s, filters.get("beta"), filters.get("gamma"));
		assertTrue(collectionEquals(s.getFilters(), Filter.or(filters.get("alpha"), filters.get("beta")), filters.get("beta"), filters.get("gamma")));
		assertFalse(s.isDisjunction());
		
		s.clear();
		s.addFilter(filters.get("alpha"));
		s.addFilter(filters.get("beta"));
		s.setDisjunction(true);
		SearchUtil.mergeFiltersOr(s, filters.get("beta"), filters.get("gamma"));
		assertTrue(collectionEquals(s.getFilters(), filters.get("alpha"), filters.get("beta"), filters.get("beta"), filters.get("gamma")));
		assertTrue(s.isDisjunction());
		
		s.clear();
		s.addFilter(filters.get("alpha"));
		s.addFilter(filters.get("beta"));
		SearchUtil.mergeFiltersOr(s, filters.get("beta"), filters.get("gamma"));
		assertTrue(collectionEquals(s.getFilters(), Filter.and(filters.get("alpha"), filters.get("beta")), filters.get("beta"), filters.get("gamma")));
		assertTrue(s.isDisjunction());
	}
	
	@Test
	public void testMergeFields() {
		Search s = new Search();
		
		Map<String, Field> fields = new HashMap<String, Field>();
		fields.put("alpha", new Field("alpha"));
		fields.put("beta", new Field("beta"));
		fields.put("gamma", new Field("gamma", "delta"));
		
		s.setFields(null);
		SearchUtil.mergeFieldsBefore(s, fields.get("alpha"), fields.get("beta"));
		assertTrue(collectionEquals(s.getFields(), fields.get("alpha"), fields.get("beta")));
		
		s.setFields(new ArrayList<Field>());
		SearchUtil.mergeFieldsBefore(s, fields.get("alpha"), fields.get("beta"));
		assertTrue(collectionEquals(s.getFields(), fields.get("alpha"), fields.get("beta")));
		
		s.setFields(null);
		SearchUtil.mergeFieldsAfter(s, fields.get("alpha"), fields.get("beta"));
		assertTrue(collectionEquals(s.getFields(), fields.get("alpha"), fields.get("beta")));
		
		s.setFields(new ArrayList<Field>());
		SearchUtil.mergeFieldsAfter(s, fields.get("alpha"), fields.get("beta"));
		assertTrue(collectionEquals(s.getFields(), fields.get("alpha"), fields.get("beta")));
		
		s.clearFields();
		s.addField(fields.get("alpha"));
		s.addField(fields.get("beta"));
		SearchUtil.mergeFieldsBefore(s, fields.get("beta"), fields.get("gamma"));
		assertTrue(collectionEquals(s.getFields(), fields.get("beta"), fields.get("gamma"), fields.get("alpha"), fields.get("beta")));
		
		s.clearFields();
		s.addField(fields.get("alpha"));
		s.addField(fields.get("beta"));
		SearchUtil.mergeFieldsAfter(s, fields.get("beta"), fields.get("gamma"));
		assertTrue(collectionEquals(s.getFields(), fields.get("alpha"), fields.get("beta"), fields.get("beta"), fields.get("gamma")));
	}

	private static boolean collectionEquals(Collection<?> collection, Object... values) {
		if (collection == null) {
			return values == null || values.length == 0;
		} else if (values == null) {
			return collection.size() == 0;
		} else {
			if (collection.size() != values.length)
				return false;

			int i = 0;
			for (Object elem : collection) {
				if ( elem == null ? values[i++] != null : !elem.equals(values[i++]) )
					return false;
			}
			return true;
		}
	}

}
