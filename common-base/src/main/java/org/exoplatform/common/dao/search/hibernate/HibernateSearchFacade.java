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
package org.exoplatform.common.dao.search.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.exoplatform.common.dao.model.ExampleOptions;
import org.exoplatform.common.dao.model.Filter;
import org.exoplatform.common.dao.model.SearchResult;
import org.exoplatform.common.dao.search.SearchFacade;
import org.exoplatform.common.dao.search.SearchImmutable;

/**
 * <p>
 * Hibernate implementation of SearchFacade.
 * 
 * <p>
 * The SessionFactory must be set before an instance of this class can be used.
 * The <code>getCurrentSession()</code> method of the SessionFactory is used
 * when a session is needed.
 * 
 * <p>To change this default behavior, you can override the protected {@link #getSession()} method.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version HibernateSearchFacade.java Nov 4, 2013
 */
public class HibernateSearchFacade implements SearchFacade {

	private SessionFactory sessionFactory;
	private HibernateSearchProcessor processor;

	public HibernateSearchFacade() {
	}

	public HibernateSearchFacade(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.processor = HibernateSearchProcessor.getInstanceForSessionFactory(sessionFactory);
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	protected HibernateSearchProcessor getProcessor() {
		return processor;
	}

	@SuppressWarnings("unchecked")
	public List search(SearchImmutable search) {
		return processor.search(getSession(), search);
	}

	@SuppressWarnings("unchecked")
	public List search(Class<?> searchClass, SearchImmutable search) {
		return processor.search(getSession(), searchClass, search);
	}

	public int count(SearchImmutable search) {
		return processor.count(getSession(), search);
	}

	public int count(Class<?> searchClass, SearchImmutable search) {
		return processor.count(getSession(), searchClass, search);
	}

	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(SearchImmutable search) {
		return processor.searchAndCount(getSession(), search);
	}

	@SuppressWarnings("unchecked")
	public SearchResult searchAndCount(Class<?> searchClass, SearchImmutable search) {
		return processor.searchAndCount(getSession(), searchClass, search);
	}

	public Object searchUnique(SearchImmutable search) {
		return processor.searchUnique(getSession(), search);
	}

	public Object searchUnique(Class<?> searchClass, SearchImmutable search) {
		return processor.searchUnique(getSession(), searchClass, search);
	}

	public Filter getFilterFromExample(Object example) {
		return processor.getFilterFromExample(example);
	}

	public Filter getFilterFromExample(Object example, ExampleOptions options) {
		return processor.getFilterFromExample(example, options);
	}
}
