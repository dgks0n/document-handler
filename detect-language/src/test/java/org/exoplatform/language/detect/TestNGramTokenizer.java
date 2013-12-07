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
import static org.junit.Assert.assertThat;

import static org.hamcrest.CoreMatchers.is;
import org.exoplatform.language.util.NGramTokenizer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * 
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 * 
 * @version TestNGram.java Oct 24, 2013
 */
public class TestNGramTokenizer {

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
   * Test method for constants
   */
  @Test
  public final void testConstants() {
    assertThat(NGramTokenizer.N_GRAM, is(3));
    assertEquals(NGramTokenizer.N_GRAM, 3);
  }

  /**
   * Test method for {@link NGramTokenizer#normalize(char)} with Latin
   * characters
   */
  @Test
  public final void testNormalizeWithLatin() {
    assertEquals(NGramTokenizer.normalize('\u0000'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0009'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0020'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0030'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0040'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0041'), '\u0041');
    assertEquals(NGramTokenizer.normalize('\u005a'), '\u005a');
    assertEquals(NGramTokenizer.normalize('\u005b'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0060'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0061'), '\u0061');
    assertEquals(NGramTokenizer.normalize('\u007a'), '\u007a');
    assertEquals(NGramTokenizer.normalize('\u007b'), ' ');
    assertEquals(NGramTokenizer.normalize('\u007f'), ' ');
    assertEquals(NGramTokenizer.normalize('\u0080'), '\u0080');
    assertEquals(NGramTokenizer.normalize('\u00a1'), '\u00a1');
  }

  /**
   * Test method for {@link NGramTokenizer#normalize(char)} with CJK Kanji
   * characters
   */
  @Test
  public final void testNormalizeWithCJKKanji() {
    assertEquals(NGramTokenizer.normalize('\u4E00'), '\u4E00');
    assertEquals(NGramTokenizer.normalize('\u4E01'), '\u4E01');
    assertEquals(NGramTokenizer.normalize('\u4E02'), '\u4E02');
    assertEquals(NGramTokenizer.normalize('\u4E03'), '\u4E01');
    assertEquals(NGramTokenizer.normalize('\u4E04'), '\u4E04');
    assertEquals(NGramTokenizer.normalize('\u4E05'), '\u4E05');
    assertEquals(NGramTokenizer.normalize('\u4E06'), '\u4E06');
    assertEquals(NGramTokenizer.normalize('\u4E07'), '\u4E07');
    assertEquals(NGramTokenizer.normalize('\u4E08'), '\u4E08');
    assertEquals(NGramTokenizer.normalize('\u4E09'), '\u4E09');
    assertEquals(NGramTokenizer.normalize('\u4E10'), '\u4E10');
    assertEquals(NGramTokenizer.normalize('\u4E11'), '\u4E11');
    assertEquals(NGramTokenizer.normalize('\u4E12'), '\u4E12');
    assertEquals(NGramTokenizer.normalize('\u4E13'), '\u4E13');
    assertEquals(NGramTokenizer.normalize('\u4E14'), '\u4E14');
    assertEquals(NGramTokenizer.normalize('\u4E15'), '\u4E15');
    assertEquals(NGramTokenizer.normalize('\u4E1e'), '\u4E1e');
    assertEquals(NGramTokenizer.normalize('\u4E1f'), '\u4E1f');
    assertEquals(NGramTokenizer.normalize('\u4E20'), '\u4E20');
    assertEquals(NGramTokenizer.normalize('\u4E21'), '\u4E21');
    assertEquals(NGramTokenizer.normalize('\u4E22'), '\u4E22');
    assertEquals(NGramTokenizer.normalize('\u4E23'), '\u4E23');
    assertEquals(NGramTokenizer.normalize('\u4E30'), '\u4E30');
  }

  /**
   * Test method for {@link NGramTokenizer#get(int)} and
   * {@link NGramTokenizer#addChar(char)}
   */
  @Test
  public final void testNGram() {
    NGramTokenizer ngram = new NGramTokenizer();
    assertEquals(ngram.get(0), null);
    assertEquals(ngram.get(1), null);
    assertEquals(ngram.get(2), null);
    assertEquals(ngram.get(3), null);
    assertEquals(ngram.get(4), null);
    ngram.addChar(' ');
    assertEquals(ngram.get(1), null);
    assertEquals(ngram.get(2), null);
    assertEquals(ngram.get(3), null);
    ngram.addChar('A');
    assertEquals(ngram.get(1), "A");
    assertEquals(ngram.get(2), " A");
    assertEquals(ngram.get(3), null);
    ngram.addChar('\u06cc');
    assertEquals(ngram.get(1), "\u064a");
    assertEquals(ngram.get(2), "A\u064a");
    assertEquals(ngram.get(3), " A\u064a");
    ngram.addChar('\u1ea0');
    assertEquals(ngram.get(1), "\u1ec3");
    assertEquals(ngram.get(2), "\u064a\u1ec3");
    assertEquals(ngram.get(3), "A\u064a\u1ec3");
    ngram.addChar('\u3044');
    assertEquals(ngram.get(1), "\u3042");
    assertEquals(ngram.get(2), "\u1ec3\u3042");
    assertEquals(ngram.get(3), "\u064a\u1ec3\u3042");

    ngram.addChar('\u30a4');
    assertEquals(ngram.get(1), "\u30a2");
    assertEquals(ngram.get(2), "\u3042\u30a2");
    assertEquals(ngram.get(3), "\u1ec3\u3042\u30a2");
    ngram.addChar('\u3106');
    assertEquals(ngram.get(1), "\u3105");
    assertEquals(ngram.get(2), "\u30a2\u3105");
    assertEquals(ngram.get(3), "\u3042\u30a2\u3105");
    ngram.addChar('\uac01');
    assertEquals(ngram.get(1), "\uac00");
    assertEquals(ngram.get(2), "\u3105\uac00");
    assertEquals(ngram.get(3), "\u30a2\u3105\uac00");
    ngram.addChar('\u2010');
    assertEquals(ngram.get(1), null);
    assertEquals(ngram.get(2), "\uac00 ");
    assertEquals(ngram.get(3), "\u3105\uac00 ");

    ngram.addChar('a');
    assertEquals(ngram.get(1), "a");
    assertEquals(ngram.get(2), " a");
    assertEquals(ngram.get(3), null);
  }
}
