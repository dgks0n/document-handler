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
package org.exoplatform.common.dao.search.jpa;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import java.util.*;

import org.exoplatform.common.dao.model.Field;
import org.exoplatform.common.dao.model.SearchResult;
import org.exoplatform.common.dao.search.BaseSearchProcessor;
import org.exoplatform.common.dao.search.MetadataHandler;
import org.exoplatform.common.dao.search.SearchImmutable;
import org.exoplatform.common.dao.util.InternalUtil;
import org.exoplatform.common.dao.util.SearchUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Implementation of BaseSearchProcessor that works with JPA.
 * 
 * <p>This class is designed to be used as a singleton. The constructor requires a
 * MetadataUtil instance. Each MetadataUtil instance is typically associated
 * with a single persistence unit (i.e. EntityManagerFactory). A
 * JPASearchProcessor can only be used with EntityManagers that are associated
 * with the same persistence unit as the MetadataUtil. If an application has
 * multiple persistence units, it will need to have multiple corresponding
 * Search Processors.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version SearchProcessor.java Nov 4, 2013
 */
public class SearchProcessor extends BaseSearchProcessor {

	private static Logger logger = LoggerFactory.getLogger(SearchProcessor.class);

	public SearchProcessor(MetadataHandler mdh) {
		super(QLTYPE_EQL, mdh);
	}

	// --- Public Methods ---

	/**
	 * Search for objects based on the search parameters in the specified
	 * <code>SearchImmutable</code> object.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public List search(EntityManager entityManager, SearchImmutable search) {
		if (search == null)
			return null;

		return search(entityManager, search.getSearchClass(), search);
	}

	/**
	 * Search for objects based on the search parameters in the specified
	 * <code>SearchImmutable</code> object. Uses the specified searchClass, ignoring the
	 * searchClass specified on the search itself.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public List search(EntityManager entityManager, Class<?> searchClass, SearchImmutable search) {
		if (searchClass == null || search == null)
			return null;

		List<Object> paramList = new ArrayList<Object>();
		String ql = generateQL(searchClass, search, paramList);
		Query query = entityManager.createQuery(ql);
		addParams(query, paramList);
		addPaging(query, search);

		return transformResults(query.getResultList(), search);
	}

	/**
	 * Returns the total number of results that would be returned using the
	 * given <code>SearchImmutable</code> if there were no paging or maxResult limits.
	 * 
	 * @see SearchImmutable
	 */
	public int count(EntityManager entityManager, SearchImmutable search) {
		if (search == null)
			return 0;
		return count(entityManager, search.getSearchClass(), search);
	}

	/**
	 * Returns the total number of results that would be returned using the
	 * given <code>SearchImmutable</code> if there were no paging or maxResult limits.
	 * Uses the specified searchClass, ignoring the searchClass specified on the
	 * search itself.
	 * 
	 * @see SearchImmutable
	 */
	public int count(EntityManager entityManager, Class<?> searchClass, SearchImmutable search) {
		if (searchClass == null || search == null)
			return 0;

		List<Object> paramList = new ArrayList<Object>();
		String ql = generateRowCountQL(searchClass, search, paramList);
		if (ql == null) { // special case where the query uses column operators
			return 1;
		}
		Query query = entityManager.createQuery(ql);
		addParams(query, paramList);

		return ((Number) query.getSingleResult()).intValue();
	}

	/**
	 * Returns a <code>SearchResult</code> object that includes the list of
	 * results like <code>search()</code> and the total length like
	 * <code>searchLength</code>.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(EntityManager entityManager, SearchImmutable search) {
		if (search == null)
			return null;
		return searchAndCount(entityManager, search.getSearchClass(), search);
	}

	/**
	 * Returns a <code>SearchResult</code> object that includes the list of
	 * results like <code>search()</code> and the total length like
	 * <code>searchLength</code>. Uses the specified searchClass, ignoring the
	 * searchClass specified on the search itself.
	 * 
	 * @see SearchImmutable
	 */
	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(EntityManager entityManager, Class<?> searchClass, SearchImmutable search) {
		if (searchClass == null || search == null)
			return null;

		SearchResult result = new SearchResult();
		result.setResult(search(entityManager, searchClass, search));

		if (search.getMaxResults() > 0) {
			result.setTotalCount(count(entityManager, searchClass, search));
		} else {
			result.setTotalCount(result.getResult().size() + SearchUtil.calcFirstResult(search));
		}

		return result;
	}

	/**
	 * Search for a single result using the given parameters.
	 */
	public Object searchUnique(EntityManager entityManager, SearchImmutable search) throws NonUniqueResultException {
		if (search == null)
			return null;
		return searchUnique(entityManager, search.getSearchClass(), search);
	}

	/**
	 * Search for a single result using the given parameters. Uses the specified
	 * searchClass, ignoring the searchClass specified on the search itself.
	 */
	public Object searchUnique(EntityManager entityManager, Class<?> entityClass, SearchImmutable search)
			throws NonUniqueResultException {
		if (search == null)
			return null;

		List<Object> paramList = new ArrayList<Object>();
		String ql = generateQL(entityClass, search, paramList);
		Query query = entityManager.createQuery(ql);
		addParams(query, paramList);
		addPaging(query, search);
		try {
			return transformResult(query.getSingleResult(), search);
		} catch (NoResultException ex) {
			return transformResult(null, search);
		}
	}

	// ---- SEARCH HELPERS ---- //

	private void addParams(Query query, List<Object> params) {
		StringBuilder debug = null;

		int i = 1;
		for (Object o : params) {
			if (logger.isDebugEnabled()) {
				if (debug == null)
					debug = new StringBuilder();
				else
					debug.append("\n\t");
				debug.append("p");
				debug.append(i);
				debug.append(": ");
				debug.append(InternalUtil.paramDisplayString(o));
			}
			query.setParameter("p" + Integer.toString(i++), o);
		}
		if (debug != null && debug.length() != 0) {
			logger.debug(debug.toString());
		}
	}

	private void addPaging(Query query, SearchImmutable search) {
		int firstResult = SearchUtil.calcFirstResult(search);
		if (firstResult > 0) {
			query.setFirstResult(firstResult);
		}
		if (search.getMaxResults() > 0) {
			query.setMaxResults(search.getMaxResults());
		}
	}

	@SuppressWarnings("unchecked")
	private Object transformResult(Object result, SearchImmutable search) {
		List results = new ArrayList(1);
		results.add(result);
		return transformResults(results, search).get(0);
	}

	@SuppressWarnings("unchecked")
	private List transformResults(List results, SearchImmutable search) {
		if (results.size() == 0)
			return results;

		int resultMode = search.getResultMode();
		if (resultMode == SearchImmutable.RESULT_AUTO) {
			int count = 0;
			Iterator<Field> fieldItr = search.getFields().iterator();
			while (fieldItr.hasNext()) {
				Field field = fieldItr.next();
				if (field.getKey() != null && !field.getKey().equals("")) {
					resultMode = SearchImmutable.RESULT_MAP;
					break;
				}
				count++;
			}
			if (resultMode == SearchImmutable.RESULT_AUTO) {
				if (count > 1)
					resultMode = SearchImmutable.RESULT_ARRAY;
				else
					resultMode = SearchImmutable.RESULT_SINGLE;
			}
		}

		switch (resultMode) {
		case SearchImmutable.RESULT_ARRAY:
			if (!(results.get(0) instanceof Object[])) {
				List<Object[]> rArray = new ArrayList<Object[]>(results.size());
				for (Object result : results) {
					rArray.add(new Object[] { result });
				}
				return rArray;
			} else {
				return results;
			}
		case SearchImmutable.RESULT_LIST:
			List<List> rList = new ArrayList<List>(results.size());
			if (results.get(0) instanceof Object[]) {
				for (Object[] result : (List<Object[]>) results) {
					List list = new ArrayList(result.length);
					for (Object o : result) {
						list.add(o);
					}
					rList.add(list);
				}
			} else {
				for (Object result : results) {
					List list = new ArrayList(1);
					list.add(result);
					rList.add(list);
				}
			}
			return rList;
		case SearchImmutable.RESULT_MAP:
			List<String> keyList = new ArrayList<String>();
			Iterator<Field> fieldItr = search.getFields().iterator();
			while (fieldItr.hasNext()) {
				Field field = fieldItr.next();
				if (field.getKey() != null && !field.getKey().equals("")) {
					keyList.add(field.getKey());
				} else {
					keyList.add(field.getProperty());
				}
			}

			List<Map<String, Object>> rMap = new ArrayList<Map<String, Object>>(results.size());
			if (results.get(0) instanceof Object[]) {
				for (Object[] result : (List<Object[]>) results) {
					Map<String, Object> map = new HashMap<String, Object>();
					for (int i = 0; i < keyList.size(); i++) {
						String key = keyList.get(i);
						if (key != null) {
							map.put(key, result[i]);
						}
					}
					rMap.add(map);
				}
			} else if (keyList.size() == 1) {
				for (Object result : results) {
					Map<String, Object> map = new HashMap<String, Object>();
					;
					if (keyList.get(0) != null)
						map.put(keyList.get(0), result);
					rMap.add(map);
				}
			} else {
				throw new RuntimeException(
						"Unexpected condition: a single object was returned from the query for each record, but the Search expects multiple.");
			}

			return rMap;
		default: // SearchImmutable.RESULT_SINGLE
			return results;
		}
	}
}
