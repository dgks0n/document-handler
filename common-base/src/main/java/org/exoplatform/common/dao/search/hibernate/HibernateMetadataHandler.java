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

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.exoplatform.common.dao.search.Metadata;
import org.exoplatform.common.dao.search.MetadataHandler;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.proxy.HibernateProxyHelper;

/**
 * Implementation of MetadataUtil for Hibernate
 * 
 * A singleton instance of this class is maintained for each SessionFactory.
 * This should be accessed using
 * {@link HibernateMetadataHandler#getInstanceForSessionFactory(SessionFactory)}.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version HibernateMetadataHandler.java Nov 4, 2013
 */
public class HibernateMetadataHandler implements MetadataHandler {

	private static Map<SessionFactory, HibernateMetadataHandler> map = new HashMap<SessionFactory, HibernateMetadataHandler>();

	public static HibernateMetadataHandler getInstanceForSessionFactory(SessionFactory sessionFactory) {
		HibernateMetadataHandler instance = map.get(sessionFactory);
		if (instance == null) {
			instance = new HibernateMetadataHandler();
			instance.sessionFactory = sessionFactory;
			map.put(sessionFactory, instance);
		}
		return instance;
	}

	private SessionFactory sessionFactory;

	protected HibernateMetadataHandler() {
	}

	// --- Public Methods ---

	public Serializable getId(Object entity) {
		if (entity == null)
			throw new NullPointerException("Cannot get ID from null object.");
		return get(entity.getClass()).getIdValue(entity);
	}
	
	public boolean isId(Class<?> rootClass, String propertyPath) {
		if (propertyPath == null || "".equals(propertyPath))
			return false;
		// with hibernate, "id" always refers to the id property, no matter what
		// that property is named. just make sure the segment before this "id"
		// refers to an entity since only entities have ids.
		if (propertyPath.equals("id")
				|| (propertyPath.endsWith(".id") && get(rootClass, propertyPath.substring(0, propertyPath.length() - 3))
						.isEntity()))
			return true;

		// see if the property is the identifier property of the entity it
		// belongs to.
		int pos = propertyPath.lastIndexOf(".");
		if (pos != -1) {
			Metadata parentType = get(rootClass, propertyPath.substring(0, pos));
			if (!parentType.isEntity())
				return false;
			return propertyPath.substring(pos + 1).equals(parentType.getIdProperty());
		} else {
			return propertyPath.equals(sessionFactory.getClassMetadata(rootClass).getIdentifierPropertyName());
		}
	}

	public Metadata get(Class<?> entityClass) throws IllegalArgumentException {
		entityClass = getUnproxiedClass(entityClass);
		ClassMetadata cm = sessionFactory.getClassMetadata(entityClass);
		if (cm == null) {
			throw new IllegalArgumentException("Unable to introspect " + entityClass.toString()
					+ ". The class is not a registered Hibernate entity.");
		} else {
			return new HibernateEntityMetadata(sessionFactory, cm, null);
		}
	}

	public Metadata get(Class<?> rootEntityClass, String propertyPath) throws IllegalArgumentException {
		try {
			Metadata md = get(rootEntityClass);
			if (propertyPath == null || "".equals(propertyPath))
				return md;

			String[] chain = propertyPath.split("\\.");

			for (int i = 0; i < chain.length; i++) {
				md = md.getPropertyType(chain[i]);
			}

			return md;

		} catch (HibernateException ex) {
			throw new IllegalArgumentException("Could not find property '" + propertyPath + "' on class "
					+ rootEntityClass + ".");
		}
	}
	
	public <T> Class<T> getUnproxiedClass(Class<?> klass) {
		//cm will be null if entityClass is not registered with Hibernate or when
		//it is a Hibernate proxy class (e.x. test.googlecode.genericdao.model.Person_$$_javassist_5).
		//So if a class is not recognized, we will look at superclasses to see if
		//it is a proxy.
		while (sessionFactory.getClassMetadata(klass) == null) {
			klass = klass.getSuperclass();
			if (Object.class.equals(klass))
				return null;
		}
		
		return (Class<T>) klass;
	}
	
	public <T> Class<T> getUnproxiedClass(Object entity) {
		return HibernateProxyHelper.getClassWithoutInitializingProxy(entity);
	}

}
