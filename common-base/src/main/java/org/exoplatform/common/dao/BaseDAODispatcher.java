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
package org.exoplatform.common.dao;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * This class has some helpful properties and methods for use in making
 * DAODispatchers for various DAO implementations.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version BaseDAODispatcher.java Nov 4, 2013
 */
public class BaseDAODispatcher {

	protected Map<String, Object> specificDAOs;

	/**
	 * In practice some DAOs could be put into this map using Spring. If a DAO
	 * is in this map, it will be used instead of the general DAO. This provides
	 * a way to override the default implementation for objects with special
	 * considerations.
	 */
	public void setSpecificDAOs(Map<String, Object> specificDAOs) {
		this.specificDAOs = specificDAOs;
	}

	protected Object getSpecificDAO(String className) {
		return specificDAOs == null ? null : specificDAOs.get(className);
	}

	protected Object callMethod(Object specificDAO, String methodName, Object... args) {
		try {
			return DAOUtil.callMethod(specificDAO, methodName, args);
		} catch (IllegalArgumentException e) {
			throw new DAODispatcherException(e);
		} catch (NoSuchMethodException e) {
			throw new DAODispatcherException(e);
		} catch (IllegalAccessException e) {
			throw new DAODispatcherException(e);
		} catch (InvocationTargetException e) {
			throw new DAODispatcherException(e);
		}
	}

	protected Object callMethod(Object specificDAO, String methodName, Class<?>[] paramTypes, Object... args) {
		try {
			return DAOUtil.callMethod(specificDAO, methodName, paramTypes, args);
		} catch (IllegalArgumentException e) {
			throw new DAODispatcherException(e);
		} catch (NoSuchMethodException e) {
			throw new DAODispatcherException(e);
		} catch (IllegalAccessException e) {
			throw new DAODispatcherException(e);
		} catch (InvocationTargetException e) {
			throw new DAODispatcherException(e);
		}
	}

	/**
	 * Get the type of an array's elements. If the type of the array is more
	 * specific than "Object", the array type will be returned. Otherwise the
	 * most general of the types of the elements will be returned.
	 */
	protected static Class<?> getTypeFromArray(Object[] array) {
		if (array == null)
			return null;

		if (!array.getClass().getComponentType().equals(Object.class)) {
			// if the type of the array is more specific than Object, use that
			return array.getClass().getComponentType();
		} else {
			// otherwise, select the most general element class
			Class<?> klass = null;
			for (Object o : array) {
				if (o != null) {
					if (klass == null || o.getClass().isAssignableFrom(klass)) {
						klass = o.getClass();
					}
				}
			}
			return klass;
		}
	}

	/**
	 * <ul>
	 * <li>If array is null, empty or has no non-null elements, return null
	 * <li>If array contains all elements of the same type, return that type
	 * <li>If array contains several different element types, return
	 * Object.class
	 * </ul>
	 */
	protected static Class<?> getUniformArrayType(Object[] array) {
		if (array == null)
			return null;

		Class<?> klass = null;
		for (Object o : array) {
			if (o != null) {
				if (klass == null) {
					klass = o.getClass();
				} else {
					if (!klass.equals(o.getClass()))
						return Object.class;
				}
			}
		}

		return klass;
	}
}
