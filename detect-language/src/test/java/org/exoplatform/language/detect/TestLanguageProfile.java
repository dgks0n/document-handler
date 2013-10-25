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

import org.exoplatform.language.profile.LanguageProfile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version TestLanguageProfile.java Oct 24, 2013
 */
@SuppressWarnings("deprecation")
public class TestLanguageProfile {

	LanguageProfile profile;
	
	/**
     * @throws java.lang.Exception
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**
     * @throws java.lang.Exception
     */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

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
     * Test method for {@link com.cybozu.labs.langdetect.util.LanguageProfile#LanguageProfile()}.
     */
    @Test
    public final void testLangProfile() {
    	profile = new LanguageProfile();
        assertEquals(profile.getLanguageProfile(), null);
    }

    /**
     * Test method for {@link com.cybozu.labs.langdetect.util.LanguageProfile#LanguageProfile(java.lang.String)}.
     */
    @Test
    public final void testLangProfileStringInt() {
		profile = new LanguageProfile("en");
        assertEquals(profile.getLanguageProfile(), "en");
    }

    /**
     * Test method for {@link com.cybozu.labs.langdetect.util.LanguageProfile#addNGramToProfile(java.lang.String)}.
     */
    @Test
    public final void testAdd() {
    	profile = new LanguageProfile("en");
        profile.addNGramToProfile("a");
        assertEquals((int)profile.getFrequency().get("a"), 1);
        profile.addNGramToProfile("a");
        assertEquals((int)profile.getFrequency().get("a"), 2);
        profile.omitLessFrequency();
    }

    
    /**
     * Illegal call test for {@link LanguageProfile#addNGramToProfile(String)}
     */
    @Test
    public final void testAddIllegally1() {
        profile = new LanguageProfile(); // Illegal ( available for only JSONIC ) but ignore  
        profile.addNGramToProfile("a"); // ignore
        assertEquals(profile.getFrequency().get("a"), null); // ignored
    }

    /**
     * Illegal call test for {@link LanguageProfile#addNGramToProfile(String)}
     */
    @Test
    public final void testAddIllegally2() {
        profile = new LanguageProfile("en");
        profile.addNGramToProfile("a");
        profile.addNGramToProfile("");  // Illegal (string's length of parameter must be between 1 and 3) but ignore
        profile.addNGramToProfile("abcd");  // as well
        assertEquals((int)profile.getFrequency().get("a"), 1);
        assertEquals(profile.getFrequency().get(""), null);     // ignored
        assertEquals(profile.getFrequency().get("abcd"), null); // ignored
        
    }
    
    /**
     * Test method for {@link com.cybozu.labs.langdetect.util.LanguageProfile#omitLessFrequency()}.
     */
    @Test
    public final void testOmitLessFreq() {
        profile = new LanguageProfile("en");
        String[] grams = "a b c \u3042 \u3044 \u3046 \u3048 \u304a \u304b \u304c \u304d \u304e \u304f".split(" ");
        for (int i=0;i<5;++i) for (String g : grams) {
            profile.addNGramToProfile(g);
        }
        profile.addNGramToProfile("\u3050");

        assertEquals((int)profile.getFrequency().get("a"), 5);
        assertEquals((int)profile.getFrequency().get("\u3042"), 5);
        assertEquals((int)profile.getFrequency().get("\u3050"), 1);
        profile.omitLessFrequency();
        assertEquals(profile.getFrequency().get("a"), null); // omitted
        assertEquals((int)profile.getFrequency().get("\u3042"), 5);
        assertEquals(profile.getFrequency().get("\u3050"), null); // omitted
    }

    /**
     * Illegal call test for {@link com.cybozu.labs.langdetect.util.LanguageProfile#omitLessFrequency()}.
     */
    @Test
    public final void testOmitLessFreqIllegally() {
        profile = new LanguageProfile();
        profile.omitLessFrequency();  // ignore
    }
}
