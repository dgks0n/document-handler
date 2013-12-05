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
package org.exoplatform.common.session.factory;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.picocontainer.Disposable;
import org.picocontainer.PicoCompositionException;
import org.picocontainer.persistence.hibernate.annotations.ConstructableAnnotationConfiguration;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version HibernateSessionFactory.java Dec 5, 2013
 */
public final class HibernateSessionFactory implements Disposable {
  
  private SessionFactory sessionFactory;
  
  private ServiceRegistry serviceRegistry;
  
  public HibernateSessionFactory() {
    try {
      Configuration configuration = new ConstructableAnnotationConfiguration();
      configuration.configure();
      serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    } catch (HibernateException he) {
      throw new PicoCompositionException(he);
    }
  }
  
  public SessionFactory getSessionFactory() {
    return this.sessionFactory;
  }
  
  public Session getCurrentSession() {
    return sessionFactory.getCurrentSession();
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
  
  public void close() {
    if (sessionFactory != null && !sessionFactory.isClosed())
      sessionFactory.close();
  }
}
