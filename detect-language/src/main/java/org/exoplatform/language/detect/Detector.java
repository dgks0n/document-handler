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

import java.io.IOException;
import java.io.Reader;
import java.lang.Character.UnicodeBlock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;

import org.exoplatform.document.util.StringUtils;
import org.exoplatform.language.Language;
import org.exoplatform.language.define.ErrorCode;
import org.exoplatform.language.exception.LanguageDetectException;
import org.exoplatform.language.util.NGramTokenizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * {@link Detector} class is to detect language from specified text. 
 * Its instance is able to be constructed via the factory class {@link DetectorFactory}.
 * <probability>
 * After appending a target text to the {@link Detector} instance with {@link #append(Reader)} or {@link #append(String)},
 * the detector provides the language detection results for target text via {@link #detect()} or {@link #getProbabilities()}.
 * {@link #detect()} method returns a single language name which has the highest probability.
 * {@link #getProbabilities()} methods returns a list of multiple _languages and their probabilities.
 * <probability>  
 * The detector has some parameters for language detection.
 * See {@link #setAlpha(double)}, {@link #setMaxTextLength(int)} and {@link #setPriorMap(HashMap)}.
 * 
 * <ul>
 * 		<li>4x faster improvement based on Elmer Garduno's code. Thanks!</li>
 * </ul>
 * 
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version Detector.java Oct 18, 2013
 *
 */
public class Detector {

	private static final Logger logger = LoggerFactory.getLogger(Detector.class);
	
	private static final double ALPHA_DEFAULT = 0.5;
    private static final double ALPHA_WIDTH = 0.05;

    private static final int ITERATION_LIMIT = 1000;
    private static final double PROB_THRESHOLD = 0.1;
    private static final double CONV_THRESHOLD = 0.99999;
    private static final int BASE_FREQ = 10000;
    private static final String UNKNOWN_LANG = "unknown";

    private static final Pattern URL_REGEX = Pattern.compile("https?://[-_.?&~;+=/#0-9A-Za-z]+");
    private static final Pattern MAIL_REGEX = Pattern.compile("[-_.0-9A-Za-z]+@[-_0-9A-Za-z]+[-_.0-9A-Za-z]+");
    
    private final HashMap<String, double[]> _wordLangProbability;
    private final ArrayList<String> _languages;

    private StringBuffer _text;
    private double[] _languageProbability = null;

    private double _alpha = ALPHA_DEFAULT;
    private int _nTrial = 7;
    private int _maxTextLength = 10000;
    private double[] _priorMap = null;
    private boolean _verbose = false;

    /**
     * Constructor.
     * Detector instance can be constructed via {@link DetectorFactory#create()}.
     * @param factory {@link DetectorFactory} instance (only DetectorFactory inside)
     */
	public Detector(DetectorFactory detectorFactory) {
		this._wordLangProbability = detectorFactory.getWordLangProbability();
		this._languages = detectorFactory.getLanguages();
		this._text = new StringBuffer();
	}

	/**
	 * Set Verbose Mode(use for debug).
	 */
	public void setVerbose() {
		this._verbose = true;
	}

	/**
	 * Set smoothing parameter. The default value is 0.5(i.e. Expected
	 * Likelihood Estimate).
	 * 
	 * @param _alpha
	 *            the smoothing parameter
	 */
	public void setAlpha(double _alpha) {
		this._alpha = _alpha;
	}

	/**
	 * Set prior information about language probabilities.
	 * 
	 * @param _priorMap 
	 * 				the _priorMap to set
	 * @throws LangDetectException
	 */
	public void setPriorMap(HashMap<String, Double> _priorMap) throws LanguageDetectException {
		this._priorMap = new double[_languages.size()];
		double sumProbability = 0;
		for (int i = 0; i < this._priorMap.length; ++i) {
			String language = _languages.get(i);
			if (_priorMap.containsKey(language)) {
				double prior = _priorMap.get(language);
				if (prior < 0) {
					throw new LanguageDetectException("Prior probability must be non-negative.", ErrorCode.INITPARAMERROR);
				}
				
				this._priorMap[i] = prior;
				sumProbability += prior;
			}
		}
		
		if (sumProbability <= 0) {
			throw new LanguageDetectException("More one of prior probability must be non-zero.", ErrorCode.INITPARAMERROR);
		}
		
		for (int i = 0; i < this._priorMap.length; ++i) {
			this._priorMap[i] /= sumProbability;
		}
	}

	/**
	 * Specify max size of target text to use for language detection. The
	 * default value is 10000(10KB).
	 * 
	 * @param _maxTextLength
	 *            the _maxTextLength to set
	 */
	public void setMaxTextLength(int _maxTextLength) {
		this._maxTextLength = _maxTextLength;
	}

	/**
	 * Append the target text for language detection. This method read the text
	 * from specified input reader. If the total size of target text exceeds the
	 * limit size specified by {@link Detector#setMaxTextLength(int)}, the rest
	 * is cut down.
	 * 
	 * @param reader
	 *            the input reader (BufferedReader as usual)
	 * @throws IOException
	 *             Can't read the reader.
	 */
	public void appendTarget(final Reader reader) throws LanguageDetectException, IOException {
		char[] buffered = new char[_maxTextLength / 2];
		while (_text.length() < _maxTextLength && reader.ready()) {
			int length = reader.read(buffered);
			appendTarget(new String(buffered, 0, length));
		}
	}

	/**
	 * Append the target text for language detection. If the total size of
	 * target text exceeds the limit size specified by
	 * {@link Detector#setMaxTextLength(int)}, the rest is cut down.
	 * 
	 * @param text
	 *            the target text to append
	 */
	public void appendTarget(final String target) throws LanguageDetectException {
		if (StringUtils.isEmpty(target)) {
			throw new LanguageDetectException("The target text is null."); 
		}
		
		String text = URL_REGEX.matcher(target).replaceAll(" ");
		text = MAIL_REGEX.matcher(text).replaceAll(" ");
		
		char pre = 0;
		for (int i = 0; i < text.length() && i < _maxTextLength; ++i) {
			char character = NGramTokenizer.normalize(text.charAt(i));
			if (character != ' ' || pre != ' ') {
				this._text.append(character);
			}
			pre = character;
		}
	}

	/**
	 * Cleaning text to detect (eliminate URL, e-mail address and Latin sentence
	 * if it is not written in Latin alphabet)
	 */
	private void cleaningText() {
		int latinCount = 0, nonLatinCount = 0;
		for (int i = 0; i < _text.length(); ++i) {
			char character = _text.charAt(i);
			if (character <= 'z' && character >= 'A') {
				++latinCount;
			} else if (character >= '\u0300' && UnicodeBlock.of(character) != UnicodeBlock.LATIN_EXTENDED_ADDITIONAL) {
				++nonLatinCount;
			}
		}
		if (latinCount * 2 < nonLatinCount) {
			StringBuffer textWithoutLatin = new StringBuffer();
			for (int i = 0; i < _text.length(); ++i) {
				char character = _text.charAt(i);
				if (character > 'z' || character < 'A') {
					textWithoutLatin.append(character);
				}
			}
			_text = textWithoutLatin;
		}

	}

	/**
	 * Detect language of the target text and return the language name which has
	 * the highest probability.
	 * 
	 * @return detected language name which has most probability.
	 * @throws LangDetectException
	 *             code = ErrorCode.CantDetectError : Can't detect because of no
	 *             valid features in text
	 */
	public String detect() throws LanguageDetectException {
		ArrayList<Language> probabilities = getProbabilities();
		if (probabilities.size() > 0) {
			return probabilities.get(0).getLanguage();
		}
		return UNKNOWN_LANG;
	}

	/**
	 * Get language candidates which have high probabilities
	 * 
	 * @return possible _languages list (whose probabilities are over
	 *         PROB_THRESHOLD, ordered by probabilities descendently
	 * @throws LangDetectException
	 *             code = ErrorCode.CantDetectError : Can't detect because of no
	 *             valid features in text
	 */
	public ArrayList<Language> getProbabilities() throws LanguageDetectException {
		if (_languageProbability == null) {
			detectBlock();
		}

		ArrayList<Language> list = sortProbability(_languageProbability);
		return list;
	}

	/**
	 * @throws LangDetectException
	 * 
	 */
	private void detectBlock() throws LanguageDetectException {
		cleaningText();
		ArrayList<String> ngrams = extractNGrams();
		if (ngrams.size() == 0) {
			throw new LanguageDetectException("No features in text", ErrorCode.CANTDETECTERROR);
		}

		_languageProbability = new double[_languages.size()];
		Random random = new Random();
		
		for (int t = 0; t < _nTrial; ++t) {
			double[] probability = initProbability();
			double _alpha = this._alpha + random.nextGaussian() * ALPHA_WIDTH;

			for (int i = 0;; ++i) {
				int rand = random.nextInt(ngrams.size());
				updateLanguageProbability(probability, ngrams.get(rand), _alpha);
				if (i % 5 == 0) {
					if (normalizeProbability(probability) > CONV_THRESHOLD || i >= ITERATION_LIMIT) {
						break;
					}
					if (_verbose) {
						logger.info("> " + sortProbability(probability));
					}
				}
			}
			for (int j = 0; j < _languageProbability.length; ++j) {
				_languageProbability[j] += probability[j] / _nTrial;
			}
			if (_verbose) {
				logger.info("==> " + sortProbability(probability));
			}
		}
	}

	/**
	 * Initialize the map of language probabilities. If there is the specified
	 * prior map, use it as initial map.
	 * 
	 * @return initialized map of language probabilities
	 */
	private double[] initProbability() {
		double[] probabilities = new double[_languages.size()];
		if (_priorMap != null) {
			for (int i = 0; i < probabilities.length; ++i) {
				probabilities[i] = _priorMap[i];
			}
		} else {
			for (int i = 0; i < probabilities.length; ++i) {
				probabilities[i] = 1.0 / _languages.size();
			}
		}
		return probabilities;
	}

	/**
	 * Extract n-grams from target text
	 * 
	 * @return n-grams list
	 */
	private ArrayList<String> extractNGrams() {
		ArrayList<String> list = new ArrayList<String>();
		NGramTokenizer ngram = new NGramTokenizer();
		
		for (int i = 0; i < _text.length(); ++i) {
			ngram.addChar(_text.charAt(i));
			for (int n = 1; n <= NGramTokenizer.N_GRAM; ++n) {
				String w = ngram.get(n);
				if (w != null && _wordLangProbability.containsKey(w)) {
					list.add(w);
				}
			}
		}
		return list;
	}

	/**
	 * Update language probabilities with N-gram string(N=1,2,3)
	 * 
	 * @param nGramWord
	 *            N-gram string
	 */
	private boolean updateLanguageProbability(double[] probabilities, String nGramWord, double _alpha) {
		if (StringUtils.isEmpty(nGramWord) || !_wordLangProbability.containsKey(nGramWord)) {
			return false;
		}

		double[] langProbMap = _wordLangProbability.get(nGramWord);
		if (_verbose) {
			logger.info(nGramWord + "(" + unicodeEncode(nGramWord) + "):" + langProbMap.toString());
		}

		double weight = _alpha / BASE_FREQ;
		for (int i = 0; i < probabilities.length; ++i) {
			probabilities[i] *= weight + langProbMap[i];
		}
		return true;
	}

	/**
	 * normalize probabilities and check convergence by the maximun probability
	 * 
	 * @return maximum of probabilities
	 */
	private static double normalizeProbability(double[] probabilities) {
		double maximunProbability = 0, sumProbability = 0;
		for (int i = 0; i < probabilities.length; ++i) {
			sumProbability += probabilities[i];
		}
		for (int i = 0; i < probabilities.length; ++i) {
			double probability = probabilities[i] / sumProbability;
			if (maximunProbability < probability) {
				maximunProbability = probability;
			}
			probabilities[i] = probability;
		}
		return maximunProbability;
	}

	/**
	 * @param probabilities
	 *            HashMap
	 * @return lanugage candidates order by probabilities descendently
	 */
	private ArrayList<Language> sortProbability(double[] probabilities) {
		ArrayList<Language> list = new ArrayList<Language>();
		for (int j = 0; j < probabilities.length; ++j) {
			double probability = probabilities[j];
			if (probability > PROB_THRESHOLD) {
				for (int i = 0; i <= list.size(); ++i) {
					if (i == list.size() || list.get(i).getProbability() < probability) {
						list.add(i, new Language(_languages.get(j), probability));
						break;
					}
				}
			}
		}
		return list;
	}

	/**
	 * Unicode encoding (for verbose mode)
	 * 
	 * @param nGramWord
	 * @return
	 */
	private static String unicodeEncode(String nGramWord) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < nGramWord.length(); ++i) {
			char character = nGramWord.charAt(i);
			if (character >= '\u0080') {
				String string = Integer.toHexString(0x10000 + (int) character);
				while (string.length() < 4) {
					string = "0" + string;
				}
				buf.append("\\u").append(string.subSequence(1, 5));
			} else {
				buf.append(character);
			}
		}
		return buf.toString();
	}
}
