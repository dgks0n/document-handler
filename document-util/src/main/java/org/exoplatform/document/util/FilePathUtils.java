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
package org.exoplatform.document.util;


/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version FilePathUtils.java Nov 7, 2013
 */
public class FilePathUtils {

  /** . */
  public static final String USER_HOME = "user.home";
	public static final String USER_HOME_PATH = System.getProperty(USER_HOME);
	
	/**
   * The specified local path to storage files and logs.
   */
	public static final String ROOT_PATH = USER_HOME_PATH + "/document-handler";
	
	/**
	 * We use temporary directory to temporarily store files for java
	 */
	public static final String REPOSITORY_PATH = ROOT_PATH + "/repository";
	
	/**
	 * The specified local path to storage documents
	 */
	public static final String RESOURCE_PATH = ROOT_PATH + "/resources";
}
