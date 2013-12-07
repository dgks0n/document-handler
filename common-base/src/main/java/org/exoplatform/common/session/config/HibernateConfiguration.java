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
package org.exoplatform.common.session.config;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.picocontainer.Disposable;

/**
 * Created by The eXo Platform SAS
 * 
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 * 
 * @version HibernateSessionFactory.java Dec 5, 2013
 */
public final class HibernateConfiguration implements Disposable {

  private final SessionFactory sessionFactory;

  private final Configuration _configuration;

  public HibernateConfiguration(Configuration configuration, ServiceRegistryBuilder serviceRegistryBuilder) {
    this._configuration = configuration;
    this._configuration.configure();
    this.sessionFactory = _configuration.buildSessionFactory(serviceRegistryBuilder.applySettings(_configuration.getProperties()).buildServiceRegistry());
  }

  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }

  public boolean isClosed() {
    return sessionFactory.isClosed();
  }

  public Session openSession() {
    return sessionFactory.openSession();
  }

  /**
   * Clears the session factory when the container is disposed.
   */
  @Override
  public void dispose() {
    close();
  }

  private void close() {
    if (sessionFactory != null && !isClosed()) {
      sessionFactory.close();
    }
  }
}
