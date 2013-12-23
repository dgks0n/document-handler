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
package org.exoplatform.document.service.impl;

import java.util.List;

import org.exoplatform.document.dao.FileDao;
import org.exoplatform.document.entity.File;
import org.exoplatform.document.exception.ServiceException;
import org.exoplatform.document.service.FileService;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version FileServiceImpl.java Dec 22, 2013
 *
 */
public class FileServiceImpl implements FileService {

    private FileDao fileDao;
    
    public FileServiceImpl(FileDao fileDao) {
        this.fileDao = fileDao;
    }
    
    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#getFile(java.lang.String)
     */
    @Override
    public File getFile(String fileId) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#insertFile(org.exoplatform.document.entity.File)
     */
    @Override
    public void insertFile(File file) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#updateFile(org.exoplatform.document.entity.File)
     */
    @Override
    public void updateFile(File file) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#deleteFile(java.lang.String)
     */
    @Override
    public void deleteFile(String fileId) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#copyFile(java.lang.String)
     */
    @Override
    public void copyFile(String fileId) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#findAll()
     */
    @Override
    public List<File> findAll() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#trashFile(java.lang.String)
     */
    @Override
    public void trashFile(String fileId) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.FileService#untrashFile(java.lang.String)
     */
    @Override
    public void untrashFile(String fileId) throws ServiceException {
        // TODO Auto-generated method stub

    }

}
