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

import java.util.Collection;

import org.exoplatform.document.entity.Owner;
import org.exoplatform.document.exception.ServiceException;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version OwnerService.java Dec 26, 2013
 *
 */
public interface OwnerService {

    public Owner findById(String id) throws ServiceException;
    
    public Owner findByUsername(String username) throws ServiceException;
    
    public Owner findByEmail(String email) throws ServiceException;
    
    public Collection<Owner> findAll() throws ServiceException;
    
    public void createOwner(Owner owner) throws ServiceException;
    
    public void updateOwner(Owner owner) throws ServiceException;
    
    public void removeById(String id) throws ServiceException;
    
    public void removeByUsername(String username) throws ServiceException;
    
    public void removeByEmail(String email) throws ServiceException;
    
}
