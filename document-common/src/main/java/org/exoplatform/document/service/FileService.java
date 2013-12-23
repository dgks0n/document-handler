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
package org.exoplatform.document.service;

import java.util.List;

import org.exoplatform.document.entity.File;
import org.exoplatform.document.exception.ServiceException;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version FileService.java Dec 22, 2013
 *
 */
public interface FileService {

    /**
     * Gets a file's metadata by ID
     * 
     * @param fileId
     * @return
     * @throws ServiceException
     */
    public File getFile(String fileId) throws ServiceException;
    
    /**
     * Insert a new file
     * 
     * @param file
     * @throws ServiceException
     */
    public void insertFile(File file) throws ServiceException;
    
    /**
     * Updates file metadata and/or conten
     * 
     * @param file
     * @throws ServiceException
     */
    public void updateFile(File file) throws ServiceException;
    
    /**
     * Permanently deletes a file by ID. Skips the trash
     * 
     * @param fileId
     * @throws ServiceException
     */
    public void deleteFile(String fileId) throws ServiceException;
    
    /**
     * Creates a copy of the specified file
     * 
     * @param fileId
     * @throws ServiceException
     */
    public void copyFile(String fileId) throws ServiceException;
    
    /**
     * Lists the user's files
     * 
     * @return
     * @throws ServiceException
     */
    public List<File> findAll() throws ServiceException;
    
    /**
     * Moves a file to the trash
     * 
     * @param fileId
     * @throws ServiceException
     */
    public void trashFile(String fileId) throws ServiceException;
    
    /**
     * Restores a file from the trash
     * 
     * @param fileId
     * @throws ServiceException
     */
    public void untrashFile(String fileId) throws ServiceException;
}
