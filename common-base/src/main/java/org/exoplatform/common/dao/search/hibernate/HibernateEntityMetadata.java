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

import org.hibernate.SessionFactory;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.type.CollectionType;
import org.hibernate.type.EntityType;
import org.hibernate.type.Type;

import org.exoplatform.common.dao.search.Metadata;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version HibernateEntityMetadata.java Nov 4, 2013
 */
public class HibernateEntityMetadata implements Metadata {

	private SessionFactory sessionFactory;
	private ClassMetadata metadata;
	private Class<?> collectionType;
	
	public HibernateEntityMetadata(SessionFactory sessionFactory, ClassMetadata classMetadata, Class<?> collectionType) {
		this.sessionFactory = sessionFactory;
		this.metadata = classMetadata;
		this.collectionType = collectionType;
	}
	
	public String getEntityName() {
		return metadata.getEntityName();
	}
	
	public String getIdProperty() {
		return metadata.getIdentifierPropertyName();
	}

	public Metadata getIdType() {
		return new HibernateNonEntityMetadata(sessionFactory, metadata.getIdentifierType(), null);
	}

	public Serializable getIdValue(Object object) {
		return metadata.getIdentifier(object, null);
	}

	public Class<?> getJavaClass() {
		return metadata.getMappedClass();
	}

	public String[] getProperties() {
		String[] pn = metadata.getPropertyNames();
		String[] result = new String[pn.length + 1];
		result[0] = metadata.getIdentifierPropertyName();
		for (int i = 0; i < pn.length; i++) {
			result[i+1] = pn[i];
		}
		return result;
	}

	public Metadata getPropertyType(String property) {
		Type pType = metadata.getPropertyType(property);
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

	public Object getPropertyValue(Object object, String property) {
		if (getIdProperty().equals(property))
			return getIdValue(object);
		else
			return metadata.getPropertyValue(object, property);
	}

	public boolean isCollection() {
		return collectionType != null;
	}

	public Class<?> getCollectionClass() {
		return collectionType;
	}

	public boolean isEmeddable() {
		return false;
	}

	public boolean isEntity() {
		return true;
	}

	public boolean isNumeric() {
		return false;
	}

	public boolean isString() {
		return false;
	}
}
