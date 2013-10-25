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
package org.exoplatform.language.detect;

import static org.junit.Assert.assertEquals;

import org.exoplatform.language.Language;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version TestLanguage.java Oct 24, 2013
 */
public class TestLanguage {

	/**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link com.cybozu.labs.langdetect.Language#Language(java.lang.String, double)}.
     */
    @Test
    public final void testLanguage() {
        Language lang = new Language(null, 0);
        assertEquals(lang.language, null);
        assertEquals(lang.probability, 0.0, 0.0001);
        assertEquals(lang.toString(), "");
        
        Language lang2 = new Language("en", 1.0);
        assertEquals(lang2.language, "en");
        assertEquals(lang2.probability, 1.0, 0.0001);
        assertEquals(lang2.toString(), "{en:1.0}");
        
    }
}
