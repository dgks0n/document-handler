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

import java.io.Serializable;

import org.exoplatform.common.dao.search.Metadata;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version AnnotationCollectionMetadata.java Nov 4, 2013
 */
public class AnnotationCollectionMetadata implements Metadata {

	Metadata classMetadata;
	Class<?> collectionClass;

	public AnnotationCollectionMetadata(Class<?> klass, Class<?> collectionClass) {
		classMetadata = AnnotationMetadata.getMetadata(klass);
		this.collectionClass = collectionClass;
	}

	public Class<?> getCollectionClass() {
		return collectionClass;
	}

	public String getIdProperty() {
		return classMetadata.getIdProperty();
	}

	public Metadata getIdType() {
		return classMetadata.getIdType();
	}

	public Serializable getIdValue(Object object) {
		return classMetadata.getIdValue(object);
	}

	public Class<?> getJavaClass() {
		return classMetadata.getJavaClass();
	}
	
	public String getEntityName() {
		return classMetadata.getEntityName();
	}

	public String[] getProperties() {
		return classMetadata.getProperties();
	}

	public Metadata getPropertyType(String property) {
		return classMetadata.getPropertyType(property);
	}

	public Object getPropertyValue(Object object, String property) {
		return classMetadata.getPropertyValue(object, property);
	}

	public boolean isCollection() {
		return true;
	}

	public boolean isEmeddable() {
		return classMetadata.isEmeddable();
	}

	public boolean isEntity() {
		return classMetadata.isEntity();
	}

	public boolean isNumeric() {
		return classMetadata.isNumeric();
	}

	public boolean isString() {
		return classMetadata.isString();
	}
}
