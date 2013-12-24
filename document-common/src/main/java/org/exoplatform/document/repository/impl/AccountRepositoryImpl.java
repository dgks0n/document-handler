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
package org.exoplatform.document.repository.impl;

import org.exoplatform.common.dao.CrudRepositoryImpl;
import org.exoplatform.common.dao.hibernate.HibernateJpaRepository;
import org.exoplatform.document.entity.Account;
import org.exoplatform.document.repository.AccountRepository;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version AccountRepositoryImpl.java Nov 30, 2013
 * 
 */
public class AccountRepositoryImpl extends CrudRepositoryImpl<Account, String>
        implements AccountRepository {

    public AccountRepositoryImpl(HibernateJpaRepository repository) {
        super(repository);
    }

}
