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
package org.exoplatform.common.dao.search;

import static org.junit.Assert.*;

import org.exoplatform.common.dao.util.InternalUtil;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version TestInternalUtil.java Nov 4, 2013
 */
public class TestInternalUtil {

	@Test
	public void testConvertIfNeeded() {
		assertEquals(null, InternalUtil.convertIfNeeded(null, Double.class));
		
		assertEquals(13.0, InternalUtil.convertIfNeeded(13L, Double.class));
		assertEquals(Double.class, InternalUtil.convertIfNeeded(13L, Double.class).getClass());
		assertEquals(13.0, InternalUtil.convertIfNeeded(13, Double.class));
		assertEquals(Double.class, InternalUtil.convertIfNeeded(13, Double.class).getClass());
		assertEquals(47.5, InternalUtil.convertIfNeeded(47.5f, Double.class));
		assertEquals(Double.class, InternalUtil.convertIfNeeded(47.5f, Double.class).getClass());
		assertEquals(47.5, InternalUtil.convertIfNeeded(47.5, Double.class));
		assertEquals(Double.class, InternalUtil.convertIfNeeded(47.5, Double.class).getClass());
		assertEquals(47.5, InternalUtil.convertIfNeeded("47.5", Double.class));
		assertEquals(Double.class, InternalUtil.convertIfNeeded("47.5", Double.class).getClass());
		
		assertEquals(13L, InternalUtil.convertIfNeeded(13, Long.class));
		assertEquals(Long.class, InternalUtil.convertIfNeeded(13, Long.class).getClass());
		assertEquals(13L, InternalUtil.convertIfNeeded(13L, Long.class));
		assertEquals(Long.class, InternalUtil.convertIfNeeded(13L, Long.class).getClass());
		assertEquals(13L, InternalUtil.convertIfNeeded(13d, Long.class));
		assertEquals(Long.class, InternalUtil.convertIfNeeded(13d, Long.class).getClass());
		assertEquals(13L, InternalUtil.convertIfNeeded(13f, Long.class));
		assertEquals(Long.class, InternalUtil.convertIfNeeded(13f, Long.class).getClass());
		assertEquals(13L, InternalUtil.convertIfNeeded("13", Long.class));
		assertEquals(Long.class, InternalUtil.convertIfNeeded("13", Long.class).getClass());
		
		assertEquals("13", InternalUtil.convertIfNeeded("13", String.class));
		assertEquals(String.class, InternalUtil.convertIfNeeded("13", String.class).getClass());
		assertEquals("13", InternalUtil.convertIfNeeded(13L, String.class));
		assertEquals(String.class, InternalUtil.convertIfNeeded(13L, String.class).getClass());
		assertEquals("13", InternalUtil.convertIfNeeded(13, String.class));
		assertEquals(String.class, InternalUtil.convertIfNeeded(13, String.class).getClass());
		assertEquals("13.0", InternalUtil.convertIfNeeded(13.0f, String.class));
		assertEquals(String.class, InternalUtil.convertIfNeeded(13.0f, String.class).getClass());
		assertEquals("class java.lang.String", InternalUtil.convertIfNeeded(String.class, String.class));
		assertEquals(String.class, InternalUtil.convertIfNeeded(String.class, String.class).getClass());
		
		assertEquals(String.class, InternalUtil.convertIfNeeded(String.class, Class.class));
		assertEquals(Class.class, InternalUtil.convertIfNeeded(String.class, Class.class).getClass());
		assertEquals(String.class, InternalUtil.convertIfNeeded("java.lang.String", Class.class));
		assertEquals(Class.class, InternalUtil.convertIfNeeded("java.lang.String", Class.class).getClass());
	}
}
