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
package org.exoplatform.document.dao.impl;

import org.exoplatform.common.dao.HibernateManagerImpl;
import org.exoplatform.common.dao.hibernate.HibernateTransactionManager;
import org.exoplatform.document.dao.FileDao;
import org.exoplatform.document.entity.File;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version FileDaoImpl.java Nov 30, 2013
 *
 */
//@Repository(FileDao.REPOSITORY_ID)
//@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class FileDaoImpl extends HibernateManagerImpl<File, String> implements FileDao {

  public FileDaoImpl(HibernateTransactionManager transactionManager) {
    super(transactionManager);
  }

}
