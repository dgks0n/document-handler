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
package org.exoplatform.document.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.picocontainer.persistence.hibernate.ConfigurableSessionFactory;
import org.picocontainer.persistence.hibernate.annotations.ConstructableAnnotationConfiguration;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version HibernateSessionFactory.java Dec 2, 2013
 *
 */
public class HibernateSessionFactory {

  private static final String HIBERNATE_CONFIGURATION_PATH = "/hibernate.cfg.xml";
  
  private static SessionFactory sessionFactory;
  
  public static SessionFactory getInstanceOfSessionFactory() {
    Configuration configuration = new ConstructableAnnotationConfiguration(HIBERNATE_CONFIGURATION_PATH);
    sessionFactory = new ConfigurableSessionFactory(configuration);
    return sessionFactory;
  }
}
