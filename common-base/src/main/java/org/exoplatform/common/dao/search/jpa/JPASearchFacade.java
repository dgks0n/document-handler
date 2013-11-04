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

import java.util.List;

import javax.persistence.EntityManager;

import org.exoplatform.common.dao.model.ExampleOptions;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.SearchResult;
import org.exoplatform.common.dao.search.SearchFacade;
import org.exoplatform.common.dao.search.SearchImmutable;

/**
 * <p>
 * JPA implementation of {@link SearchFacade}.
 * 
 * <p>
 * The <code>SearchProcessor</code> and <code>EntityManager</code> must be set
 * in order for the SearchFacade to function. Generally, a single
 * SearchProcessor will be associated with an instance of JPASearchFacade for
 * the lifetime of the instance, while a new "current" EntityManager will be
 * injected as needed. Make sure that any EntityManager that is used is
 * associated with the same persistence unit (i.e. EntityManagerFactory) as the
 * SearchProcessor.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version JPASearchFacade.java Nov 4, 2013
 */
public class JPASearchFacade implements SearchFacade {

	protected SearchProcessor processor;

	protected EntityManager entityManager;

	public void setSearchProcessor(SearchProcessor searchProcessor) {
		this.processor = searchProcessor;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@SuppressWarnings("unchecked")
	public List search(SearchImmutable search) {
		return processor.search(entityManager, search);
	}

	@SuppressWarnings("unchecked")
	public List search(Class<?> searchClass, SearchImmutable search) {
		return processor.search(entityManager, searchClass, search);
	}

	public int count(SearchImmutable search) {
		return processor.count(entityManager, search);
	}

	public int count(Class<?> searchClass, SearchImmutable search) {
		return processor.count(entityManager, searchClass, search);
	}

	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(SearchImmutable search) {
		return processor.searchAndCount(entityManager, search);
	}

	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(Class<?> searchClass, SearchImmutable search) {
		return processor.searchAndCount(entityManager, searchClass, search);
	}

	public Object searchUnique(SearchImmutable search) {
		return processor.searchUnique(entityManager, search);
	}

	public Object searchUnique(Class<?> searchClass, SearchImmutable search) {
		return processor.searchUnique(entityManager, searchClass, search);
	}

	public Filter getFilterFromExample(Object example) {
		return processor.getFilterFromExample(example);
	}

	public Filter getFilterFromExample(Object example, ExampleOptions options) {
		return processor.getFilterFromExample(example, options);
	}
}
