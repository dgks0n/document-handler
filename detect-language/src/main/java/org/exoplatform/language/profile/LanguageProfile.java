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
package org.exoplatform.language.profile;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.exoplatform.language.util.NGram;
import org.exoplatform.language.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link LanguageProfile} is a Language Profile Class.
 * Identifier of the language that best matches a given content profile.
 * The content profile is compared to generic language profiles based on material from various sources.
 * 
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version LanguageProfile.java Oct 18, 2013
 *
 */
public class LanguageProfile {

	private static final Logger logger = LoggerFactory.getLogger(LanguageProfile.class);
	
	private static final int MINIMUM_FREQ = 2;
    private static final int LESS_FREQ_RATIO = 100000;
    
    private String _name = null;
    private HashMap<String, Integer> _frequency = new HashMap<String, Integer>();
    private int[] _nWords = new int[NGram.N_GRAM];

    /**
     * Constructor for JSONIC 
     */
    public LanguageProfile() {
    	logger.info("Constructor for JSONIC");
    }

    /**
     * Normal Constructor
     * 
     * @param _name language _name
     */
    @Deprecated
    public LanguageProfile(String name) {
        this._name = name;
    }
    
    public void addLanguageProfile(String name) {
    	this._name = name;
    }
    
    public String getLanguageProfile() {
		return _name;
	}

	public HashMap<String, Integer> getFrequency() {
		return _frequency;
	}

	public int[] getNWords() {
		return _nWords;
	}

	/**
     * Add n-gram to profile
     * @param gram
     */
	public void addNGramToProfile(String nGram) {
		if (StringUtils.isEmpty(_name) || StringUtils.isEmpty(nGram)) {
			return;
		}
		
		if (logger.isDebugEnabled()) {
			logger.info("Add n-gram to profile");
		}
		
		int len = nGram.length();
		if (len < 1 || len > NGram.N_GRAM) {
			return;
		}
		++_nWords[len - 1];
		if (_frequency.containsKey(nGram)) {
			_frequency.put(nGram, _frequency.get(nGram) + 1);
		} else {
			_frequency.put(nGram, 1);
		}
	}

    /**
     * Eliminate below less _frequency n-grams and noise Latin alphabets
     */
	public void omitLessFrequency() {
		if (StringUtils.isEmpty(_name)) {
			return;
		}
		
		if (logger.isDebugEnabled()) {
			logger.info("Eliminate below less frequency n-grams and noise Latin alphabets");
		}
		
		int threshold = _nWords[0] / LESS_FREQ_RATIO;
		if (threshold < MINIMUM_FREQ) {
			threshold = MINIMUM_FREQ;
		}

		Set<String> keys = _frequency.keySet();
		int roman = 0;
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			String key = iterator.next();
			int count = _frequency.get(key);
			if (count <= threshold) {
				_nWords[key.length() - 1] -= count;
				iterator.remove();
			} else {
				if (key.matches("^[A-Za-z]$")) {
					roman += count;
				}
			}
		}

		if (roman < _nWords[0] / 3) {
			Set<String> keys2 = _frequency.keySet();
			for (Iterator<String> iterator = keys2.iterator(); iterator.hasNext();) {
				String key = iterator.next();
				if (key.matches(".*[A-Za-z].*")) {
					_nWords[key.length() - 1] -= _frequency.get(key);
					iterator.remove();
				}
			}
		}
	}
}
