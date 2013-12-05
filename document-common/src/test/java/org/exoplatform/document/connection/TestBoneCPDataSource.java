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
package org.exoplatform.document.connection;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 * Created by The eXo Platform SAS
 * 
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 * 
 * @version BoneCP.java Nov 27, 2013
 */
public class TestBoneCPDataSource {

//  @Test
  public void testBoneCPCManual() {

    try {
      Class.forName("com.mysql.jdbc.Driver"); // load the DB driver
    } catch (ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    }

    BoneCPConfig config = new BoneCPConfig(); // create a new configuration object
    config.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/document?createDatabaseIfNotExist=true&autoReconnect=true&useUnicode=true&characterEncoding=UTF-8");
    config.setUsername("root"); // set the username
    config.setPassword("admin"); // set the password

    BoneCP connectionPool = null;
    Connection connection = null;

    try {
      connectionPool = new BoneCP(config); // setup the connection pool
      connection = connectionPool.getConnection(); // fetch a connection
      
      assertNotNull(connection);
    } catch (SQLException sqle) {
      sqle.printStackTrace();
    } finally {
      try {
        if (connection != null)
          connection.close();
      } catch (SQLException sqle) {
        sqle.printStackTrace();
      } // close the connection

      connectionPool.shutdown(); // close the connection pool
    }
  }
}
