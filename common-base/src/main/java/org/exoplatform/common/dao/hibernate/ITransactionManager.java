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
package org.exoplatform.common.dao.hibernate;

import org.hibernate.Session;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version IHibernateTransactionManager.java Dec 7, 2013
 * 
 */
public interface ITransactionManager {

    /**
     * Obtains the current session. The definition of what exactly "current"
     * means controlled by the CurrentSessionContext impl configured for use.
     * 
     * @return The current session
     */
    public Session getSession();

    /**
     * Open a Session
     * 
     * @return The created session
     */
    public Session openSession();
}
