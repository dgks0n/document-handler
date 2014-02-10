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

import org.exoplatform.document.entity.Account;
import org.exoplatform.document.exception.ServiceException;
import org.exoplatform.document.service.AccountService;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version AccountServiceImpl.java Dec 26, 2013
 *
 */
public class AccountServiceImpl implements AccountService {

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#createAccount(org.exoplatform.document.entity.Account)
     */
    @Override
    public void createAccount(Account account) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#findById(java.lang.String)
     */
    @Override
    public Account findById(String id) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#findByEmail(java.lang.String)
     */
    @Override
    public Account findByEmail(String email) throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#findByUsername(java.lang.String)
     */
    @Override
    public Account findByUsername(String username)
            throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#findAll()
     */
    @Override
    public List<Account> findAll() throws ServiceException {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#updateAccount(org.exoplatform.document.entity.Account)
     */
    @Override
    public void updateAccount(Account account) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#removeById(java.lang.String)
     */
    @Override
    public void removeById(String id) throws ServiceException {
        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see org.exoplatform.document.service.AccountService#removeByEmail(java.lang.String)
     */
    @Override
    public void removeByEmail(String email) throws ServiceException {
        // TODO Auto-generated method stub

    }

}
