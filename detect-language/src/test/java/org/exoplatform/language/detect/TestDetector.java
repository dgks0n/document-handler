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

import org.exoplatform.language.exception.LanguageDetectException;
import org.exoplatform.language.profile.LanguageProfile;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version DetectorTest.java Oct 18, 2013
 * 
 */
@SuppressWarnings("deprecation")
public class TestDetector {

  static final String TRAINING_EN = "a a a b b c c d e";
  static final String TRAINING_FR = "a b b c c c d d d";
  static final String TRAINING_JA = "\u3042 \u3042 \u3042 \u3044 \u3046 \u3048 \u3048";

  Detector detect;

  @Before
  public void setUp() throws Exception {
    DetectorFactory.clearDetector();

    LanguageProfile profile_en = new LanguageProfile("en");
    for (String w : TRAINING_EN.split(" ")) {
      profile_en.addNGramToProfile(w);
    }
    DetectorFactory.addLanguageProfile(profile_en, 3);

    LanguageProfile profile_fr = new LanguageProfile("fr");
    for (String w : TRAINING_FR.split(" ")) {
      profile_fr.addNGramToProfile(w);
    }
    DetectorFactory.addLanguageProfile(profile_fr, 3);

    LanguageProfile profile_ja = new LanguageProfile("ja");
    for (String w : TRAINING_JA.split(" ")) {
      profile_ja.addNGramToProfile(w);
    }
    DetectorFactory.addLanguageProfile(profile_ja, 3);
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public final void testDetector1() throws LanguageDetectException {
    detect = DetectorFactory.createInstance();
    detect.appendTarget("a");
    System.out.println("****************************************");
    System.out.println("asfasdfasfasd: " + detect.detect());
    assertEquals(detect.detect(), "en");
  }

  @Test
  public final void testDetector2() throws LanguageDetectException {
    detect = DetectorFactory.createInstance();
    detect.appendTarget("b d");
    assertEquals(detect.detect(), "fr");
  }

  @Test
  public final void testDetector3() throws LanguageDetectException {
    detect = DetectorFactory.createInstance();
    detect.appendTarget("d e");
    assertEquals(detect.detect(), "en");
  }

  @Test
  public final void testDetector4() throws LanguageDetectException {
    detect = DetectorFactory.createInstance();
    detect.appendTarget("\u3042\u3042\u3042\u3042a");
    assertEquals(detect.detect(), "ja");
  }
}
