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

import org.hibernate.EntityMode;
import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.Mapping;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.type.CollectionType;
import org.hibernate.type.ComponentType;
import org.hibernate.type.EntityType;
import org.hibernate.type.Type;

import org.exoplatform.common.dao.search.Metadata;

/**
 * Implementation of Metadata for a non-entity type in Hibernate.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version HibernateNonEntityMetadata.java Nov 4, 2013
 */
public class HibernateNonEntityMetadata implements Metadata {

	private SessionFactory sessionFactory;
	private Type type;
	private Class<?> collectionType;
	
	public HibernateNonEntityMetadata(SessionFactory sessionFactory, Type type, Class<?> collectionType) {
		this.sessionFactory = sessionFactory;
		this.type = type;
		this.collectionType = collectionType;
	}
	
	public String getIdProperty() {
		return null;
	}

	public Metadata getIdType() {
		return null;
	}

	public Serializable getIdValue(Object object) {
		return null;
	}

	public Class<?> getJavaClass() {
		return type.getReturnedClass();
	}
	
	public String getEntityName() {
		throw new UnsupportedOperationException("Cannot get Entity Name of non-entity type.");
	}

	public String[] getProperties() {
		if (type.isComponentType())
			return ((ComponentType)type).getPropertyNames();
		else
			return null;
	}

	public Metadata getPropertyType(String property) {
		if (!type.isComponentType())
			return null;
		
		int i = getPropertyIndex(property);
		if (i == -1) {
			return null;
		} else {
			Type pType = ((ComponentType)type).getSubtypes()[i];
			Class<?> pCollectionType = null;
			if (pType.isCollectionType()) {
				pType = ((CollectionType)pType).getElementType((SessionFactoryImplementor) sessionFactory);
				pCollectionType = pType.getReturnedClass();
			}
			if (pType.isEntityType()) {
				return new HibernateEntityMetadata(sessionFactory, sessionFactory.getClassMetadata(((EntityType)pType).getName()), pCollectionType);
			} else {
				return new HibernateNonEntityMetadata(sessionFactory, pType, pCollectionType);
			}
		}
	}

	public Object getPropertyValue(Object object, String property) {
		if (!type.isComponentType())
			return null;
		int i = getPropertyIndex(property);
		if (i == -1) {
			return null;
		} else {
			return ((ComponentType)type).getPropertyValue(object, i, EntityMode.POJO);
		}		
	}

	public boolean isCollection() {
		return collectionType != null;
	}
	
	public Class<?> getCollectionClass() {
		return collectionType;
	}

	public boolean isEmeddable() {
		return type.isComponentType();
	}

	public boolean isEntity() {
		return false;
	}

	public boolean isNumeric() {
		return Number.class.isAssignableFrom(getJavaClass());
	}

	public boolean isString() {
		int[] types = type.sqlTypes((Mapping) sessionFactory);
		return types.length == 1 && (types[0] == java.sql.Types.VARCHAR || types[0] == java.sql.Types.CHAR);
	}
	
	
	private int getPropertyIndex(String property) {
		String[] properties = getProperties();
		for (int i = 0; i < properties.length; i++) {
			if (properties[i].equals(property)) {
				return i;
			}
		}
		return -1;
	}

}
