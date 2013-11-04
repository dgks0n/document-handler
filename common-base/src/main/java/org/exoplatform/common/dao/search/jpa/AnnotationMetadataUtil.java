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

import javax.persistence.Entity;

import org.exoplatform.common.dao.search.Metadata;
import org.exoplatform.common.dao.search.MetadataHandler;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version AnnotationMetadataUtil.java Nov 4, 2013
 */
public class AnnotationMetadataUtil implements MetadataHandler {

	public Metadata get(Class<?> klass) throws IllegalArgumentException {
		return AnnotationMetadata.getMetadata(klass);
	}

	public Metadata get(Class<?> rootEntityClass, String propertyPath) throws IllegalArgumentException {
		Metadata md = get(rootEntityClass);
		if (propertyPath == null || propertyPath.equals("")) {
			return md;
		} else {
			for (String prop : propertyPath.split("\\.")) {
				if ("id".equals(prop)) {
					md = md.getIdType();
				} else {
					md = md.getPropertyType(prop);
				}
				if (md == null)
					throw new IllegalArgumentException("Property path '" + propertyPath + "' invalid for type " + rootEntityClass.getName());
			}
			return md;
		}
	}

	public Serializable getId(Object object) {
		Metadata md = get(object.getClass());
		return md.getIdValue(object);
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
			return propertyPath.equals(get(rootClass).getIdProperty());
		}
	}

	@SuppressWarnings("unchecked")
	public <T> Class<T> getUnproxiedClass(Class<?> klass) {
		while (klass.getAnnotation(Entity.class) == null) {
			klass = klass.getSuperclass();
			if (Object.class.equals(klass))
				return null;
		}
		
		return (Class<T>) klass;
	}
	
	@SuppressWarnings("unchecked")
	public <T> Class<T> getUnproxiedClass(Object entity) {
		return (Class<T>) getUnproxiedClass(entity.getClass());
	}
}
