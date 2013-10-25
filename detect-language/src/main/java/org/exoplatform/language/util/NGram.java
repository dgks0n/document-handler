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
package org.exoplatform.language.util;

import java.lang.Character.UnicodeBlock;
import java.util.HashMap;

import org.exoplatform.language.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version NGram.java Oct 18, 2013
 * 
 */
public class NGram {

	private static final Logger logger = LoggerFactory.getLogger(NGram.class);
	
	private static final String LATIN1_EXCLUDED = Message.getMessage("NGram.LATIN1_EXCLUDE");
	
	private StringBuffer _grams;
	private boolean _capitalWord;
	
	public final static int N_GRAM = 3;
	public static HashMap<Character, Character> cjkHashMap;
	
	/**
     * CJK Kanji Normalization Mapping
     */
    static final String[] CJK_CLASS = {
        Message.getMessage("NGram.KANJI_1_0"),
        Message.getMessage("NGram.KANJI_1_2"),
        Message.getMessage("NGram.KANJI_1_4"),
        Message.getMessage("NGram.KANJI_1_8"),
        Message.getMessage("NGram.KANJI_1_11"),
        Message.getMessage("NGram.KANJI_1_12"),
        Message.getMessage("NGram.KANJI_1_13"),
        Message.getMessage("NGram.KANJI_1_14"),
        Message.getMessage("NGram.KANJI_1_16"),
        Message.getMessage("NGram.KANJI_1_18"),
        Message.getMessage("NGram.KANJI_1_22"),
        Message.getMessage("NGram.KANJI_1_27"),
        Message.getMessage("NGram.KANJI_1_29"),
        Message.getMessage("NGram.KANJI_1_31"),
        Message.getMessage("NGram.KANJI_1_35"),
        Message.getMessage("NGram.KANJI_2_0"),
        Message.getMessage("NGram.KANJI_2_1"),
        Message.getMessage("NGram.KANJI_2_4"),
        Message.getMessage("NGram.KANJI_2_9"),
        Message.getMessage("NGram.KANJI_2_10"),
        Message.getMessage("NGram.KANJI_2_11"),
        Message.getMessage("NGram.KANJI_2_12"),
        Message.getMessage("NGram.KANJI_2_13"),
        Message.getMessage("NGram.KANJI_2_15"),
        Message.getMessage("NGram.KANJI_2_16"),
        Message.getMessage("NGram.KANJI_2_18"),
        Message.getMessage("NGram.KANJI_2_21"),
        Message.getMessage("NGram.KANJI_2_22"),
        Message.getMessage("NGram.KANJI_2_23"),
        Message.getMessage("NGram.KANJI_2_28"),
        Message.getMessage("NGram.KANJI_2_29"),
        Message.getMessage("NGram.KANJI_2_30"),
        Message.getMessage("NGram.KANJI_2_31"),
        Message.getMessage("NGram.KANJI_2_32"),
        Message.getMessage("NGram.KANJI_2_35"),
        Message.getMessage("NGram.KANJI_2_36"),
        Message.getMessage("NGram.KANJI_2_37"),
        Message.getMessage("NGram.KANJI_2_38"),
        Message.getMessage("NGram.KANJI_3_1"),
        Message.getMessage("NGram.KANJI_3_2"),
        Message.getMessage("NGram.KANJI_3_3"),
        Message.getMessage("NGram.KANJI_3_4"),
        Message.getMessage("NGram.KANJI_3_5"),
        Message.getMessage("NGram.KANJI_3_8"),
        Message.getMessage("NGram.KANJI_3_9"),
        Message.getMessage("NGram.KANJI_3_11"),
        Message.getMessage("NGram.KANJI_3_12"),
        Message.getMessage("NGram.KANJI_3_13"),
        Message.getMessage("NGram.KANJI_3_15"),
        Message.getMessage("NGram.KANJI_3_16"),
        Message.getMessage("NGram.KANJI_3_18"),
        Message.getMessage("NGram.KANJI_3_19"),
        Message.getMessage("NGram.KANJI_3_22"),
        Message.getMessage("NGram.KANJI_3_23"),
        Message.getMessage("NGram.KANJI_3_27"),
        Message.getMessage("NGram.KANJI_3_29"),
        Message.getMessage("NGram.KANJI_3_30"),
        Message.getMessage("NGram.KANJI_3_31"),
        Message.getMessage("NGram.KANJI_3_32"),
        Message.getMessage("NGram.KANJI_3_35"),
        Message.getMessage("NGram.KANJI_3_36"),
        Message.getMessage("NGram.KANJI_3_37"),
        Message.getMessage("NGram.KANJI_3_38"),
        Message.getMessage("NGram.KANJI_4_0"),
        Message.getMessage("NGram.KANJI_4_9"),
        Message.getMessage("NGram.KANJI_4_10"),
        Message.getMessage("NGram.KANJI_4_16"),
        Message.getMessage("NGram.KANJI_4_17"),
        Message.getMessage("NGram.KANJI_4_18"),
        Message.getMessage("NGram.KANJI_4_22"),
        Message.getMessage("NGram.KANJI_4_24"),
        Message.getMessage("NGram.KANJI_4_28"),
        Message.getMessage("NGram.KANJI_4_34"),
        Message.getMessage("NGram.KANJI_4_39"),
        Message.getMessage("NGram.KANJI_5_10"),
        Message.getMessage("NGram.KANJI_5_11"),
        Message.getMessage("NGram.KANJI_5_12"),
        Message.getMessage("NGram.KANJI_5_13"),
        Message.getMessage("NGram.KANJI_5_14"),
        Message.getMessage("NGram.KANJI_5_18"),
        Message.getMessage("NGram.KANJI_5_26"),
        Message.getMessage("NGram.KANJI_5_29"),
        Message.getMessage("NGram.KANJI_5_34"),
        Message.getMessage("NGram.KANJI_5_39"),
        Message.getMessage("NGram.KANJI_6_0"),
        Message.getMessage("NGram.KANJI_6_3"),
        Message.getMessage("NGram.KANJI_6_9"),
        Message.getMessage("NGram.KANJI_6_10"),
        Message.getMessage("NGram.KANJI_6_11"),
        Message.getMessage("NGram.KANJI_6_12"),
        Message.getMessage("NGram.KANJI_6_16"),
        Message.getMessage("NGram.KANJI_6_18"),
        Message.getMessage("NGram.KANJI_6_20"),
        Message.getMessage("NGram.KANJI_6_21"),
        Message.getMessage("NGram.KANJI_6_22"),
        Message.getMessage("NGram.KANJI_6_23"),
        Message.getMessage("NGram.KANJI_6_25"),
        Message.getMessage("NGram.KANJI_6_28"),
        Message.getMessage("NGram.KANJI_6_29"),
        Message.getMessage("NGram.KANJI_6_30"),
        Message.getMessage("NGram.KANJI_6_32"),
        Message.getMessage("NGram.KANJI_6_34"),
        Message.getMessage("NGram.KANJI_6_35"),
        Message.getMessage("NGram.KANJI_6_37"),
        Message.getMessage("NGram.KANJI_6_39"),
        Message.getMessage("NGram.KANJI_7_0"),
        Message.getMessage("NGram.KANJI_7_3"),
        Message.getMessage("NGram.KANJI_7_6"),
        Message.getMessage("NGram.KANJI_7_7"),
        Message.getMessage("NGram.KANJI_7_9"),
        Message.getMessage("NGram.KANJI_7_11"),
        Message.getMessage("NGram.KANJI_7_12"),
        Message.getMessage("NGram.KANJI_7_13"),
        Message.getMessage("NGram.KANJI_7_16"),
        Message.getMessage("NGram.KANJI_7_18"),
        Message.getMessage("NGram.KANJI_7_19"),
        Message.getMessage("NGram.KANJI_7_20"),
        Message.getMessage("NGram.KANJI_7_21"),
        Message.getMessage("NGram.KANJI_7_23"),
        Message.getMessage("NGram.KANJI_7_25"),
        Message.getMessage("NGram.KANJI_7_28"),
        Message.getMessage("NGram.KANJI_7_29"),
        Message.getMessage("NGram.KANJI_7_32"),
        Message.getMessage("NGram.KANJI_7_33"),
        Message.getMessage("NGram.KANJI_7_35"),
        Message.getMessage("NGram.KANJI_7_37"),
    };
    
	static {
		cjkHashMap = new HashMap<Character, Character>();
		for (String cjk_list : CJK_CLASS) {
			char representative = cjk_list.charAt(0);
			for (int i = 0; i < cjk_list.length(); ++i) {
				cjkHashMap.put(cjk_list.charAt(i), representative);
			}
		}
	}
	
	public NGram() {
        _grams = new StringBuffer(" ");
        _capitalWord = false;
        
        logger.info("Initialize N-Gram");
    }

    /**
     * @param ch
     */
	public void addChar(char ch) {
		ch = normalize(ch);
		char lastchar = _grams.charAt(_grams.length() - 1);
		if (lastchar == ' ') {
			_grams = new StringBuffer(" ");
			_capitalWord = false;
			if (ch == ' ') {
				return;
			}
		} else if (_grams.length() >= N_GRAM) {
			_grams.deleteCharAt(0);
		}
		_grams.append(ch);

		if (Character.isUpperCase(ch)) {
			if (Character.isUpperCase(lastchar)) {
				_capitalWord = true;
			}
		} else {
			_capitalWord = false;
		}
	}

    /**
     * Get n-Gram
     * @param n length of n-gram
     * @return n-Gram String (null if it is invalid)
     */
	public String get(int n) {
		if (_capitalWord) {
			return null;
		}
		int len = _grams.length();
		if (n < 1 || n > 3 || len < n) {
			return null;
		}
		if (n == 1) {
			char ch = _grams.charAt(len - 1);
			if (ch == ' ') {
				return null;
			}
			return Character.toString(ch);
		} else {
			return _grams.substring(len - n, len);
		}
	}
    
    /**
     * Character Normalization
     * @param ch
     * @return Normalized character
     */
	public static char normalize(char ch) {
		Character.UnicodeBlock block = Character.UnicodeBlock.of(ch);
		if (block == UnicodeBlock.BASIC_LATIN) {
			if (ch < 'A' || (ch < 'a' && ch > 'Z') || ch > 'z') {
				ch = ' ';
			}
		} else if (block == UnicodeBlock.LATIN_1_SUPPLEMENT) {
			if (LATIN1_EXCLUDED.indexOf(ch) >= 0) {
				ch = ' ';
			}
		} else if (block == UnicodeBlock.GENERAL_PUNCTUATION) {
			ch = ' ';
		} else if (block == UnicodeBlock.ARABIC) {
			if (ch == '\u06cc') {
				ch = '\u064a';
			}
		} else if (block == UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) {
			if (ch >= '\u1ea0') {
				ch = '\u1ec3';
			}
		} else if (block == UnicodeBlock.HIRAGANA) {
			ch = '\u3042';
		} else if (block == UnicodeBlock.KATAKANA) {
			ch = '\u30a2';
		} else if (block == UnicodeBlock.BOPOMOFO || block == UnicodeBlock.BOPOMOFO_EXTENDED) {
			ch = '\u3105';
		} else if (block == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS) {
			if (cjkHashMap.containsKey(ch)) {
				ch = cjkHashMap.get(ch);
			}
		} else if (block == UnicodeBlock.HANGUL_SYLLABLES) {
			ch = '\uac00';
		}
		return ch;
	}
}
