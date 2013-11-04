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
package org.exoplatform.common.dao.model;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Use this class to pass options to find by example functionality.
 * 
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version ExampleOptions.java Nov 4, 2013
 */
public class ExampleOptions {

	public final static int EXACT = 0;
	public final static int START = 1;
	public final static int END = 2;
	public final static int ANYWHERE = 3;

	private Collection<String> excludeProps;
	private int likeMode = EXACT;
	private boolean excludeNulls = true;
	private boolean excludeZeros = false;
	private boolean ignoreCase = false;

	/**
	 * Add a property to the excludeProps collection
	 */
	public ExampleOptions excludeProp(String property) {
		if (excludeProps == null) {
			excludeProps = new ArrayList<String>();
		}
		excludeProps.add(property);
		return this;
	}

	public Collection<String> getExcludeProps() {
		return excludeProps;
	}

	/**
	 * <p>This is a list of properties to exclude. For example if a person object is
	 * as an example and it is not desirable to filter on the person's parents, the
	 * mother and father properties can be excluded by setting this list to contain
	 * the strings "mother" and "father".
	 * 
	 * <p>Default: &lt;none&gt;
	 */
	public ExampleOptions setExcludeProps(Collection<String> excludeProps) {
		this.excludeProps = excludeProps;
		return this;
	}

	public boolean isExcludeNulls() {
		return excludeNulls;
	}

	/**
	 * <p>If this is true, all properties with <code>null</code> values will be ignored.
	 * 
	 * <p>Default: true
	 */
	public ExampleOptions setExcludeNulls(boolean excludeNulls) {
		this.excludeNulls = excludeNulls;
		return this;
	}

	public boolean isExcludeZeros() {
		return excludeZeros;
	}

	/**
	 * <p>If this is true, all properties with the value <code>0</code> will be ignored.
	 * 
	 * <p>Default: false
	 */
	public ExampleOptions setExcludeZeros(boolean excludeZeros) {
		this.excludeZeros = excludeZeros;
		return this;
	}

	public boolean isIgnoreCase() {
		return ignoreCase;
	}

	/**
	 * <p>If this is true, case is ignored when comparing string values.
	 * 
	 * <p>Default: true
	 */
	public ExampleOptions setIgnoreCase(boolean ignoreCase) {
		this.ignoreCase = ignoreCase;
		return this;
	}

	public int getLikeMode() {
		return likeMode;
	}

	/**
	 * <p>This options describes how all string values are compared. The options are:
	 * <ul>
	 * 	<li>EXACT: The entire strings must match entirely.
	 *  <li>START: The value must start with the example string.
	 *  <li>END: The value must end with the example string.
	 *  <li>ANYWHERE: The value may contain the example string anywhere.
	 * </ul>
	 * 
	 * <p>Default: EXACT
	 */
	public ExampleOptions setLikeMode(int likeMode) {
		this.likeMode = likeMode;
		return this;
	}
}
