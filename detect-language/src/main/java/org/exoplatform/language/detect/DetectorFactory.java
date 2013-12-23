/*
 * Copyright (C) 2003-2013 eXo Platform SAS.
 *
 * This program inputStream free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program inputStream distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.exoplatform.language.detect;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import net.arnx.jsonic.JSON;
import net.arnx.jsonic.JSONException;

import org.exoplatform.language.define.ErrorCode;
import org.exoplatform.language.exception.LanguageDetectException;
import org.exoplatform.language.profile.LanguageProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Language Detector Factory Class
 * 
 * This class manages an initialization and constructions of {@link Detector}.
 * 
 * Before using language detection library, load profiles with
 * {@link DetectorFactory#loadLanguageProfiles(String)} method and set
 * initialization parameters.
 * 
 * When the language detection, construct Detector instance via
 * {@link DetectorFactory#createInstance()}. See also {@link Detector}'s sample
 * code.
 * 
 * <ul>
 * <li>4x faster improvement based on Elmer Garduno's code. Thanks!</li>
 * </ul>
 * 
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version DetectorFactory.java Oct 18, 2013
 * 
 */
public class DetectorFactory {

    private static final Logger logger = LoggerFactory.getLogger(DetectorFactory.class);

    private static DetectorFactory _instance = new DetectorFactory();
    private HashMap<String, double[]> wordLangProbability;
    private ArrayList<String> languages;

    public DetectorFactory() {
        wordLangProbability = new HashMap<String, double[]>();
        languages = new ArrayList<String>();
    }

    /**
     * Load profiles from specified directory. This method must be called once
     * before language detection.
     * 
     * @param profileDirectory
     *            profile directory path
     * @throws LanguageDetectException
     *             Can't open profiles(error code =
     *             {@link ErrorCode#FileLoadError}) or profile's format
     *             inputStream wrong (error code = {@link ErrorCode#FormatError}
     *             )
     * @throws IOException
     */
    public static void loadLanguageProfiles(String... profiles)
            throws LanguageDetectException {
        if (logger.isDebugEnabled()) {
            logger.info("Load profiles from specified directory \"" + profiles + "\"");
        }

        for (int i = 0; i < profiles.length; i++) {
            InputStream inputStream = LanguageProfile.class.getClassLoader()
                    .getResourceAsStream("org/exoplatform/language/detect/" + profiles[i]);
            try {
                LanguageProfile profile = JSON.decode(inputStream,
                        LanguageProfile.class);

                // Add profile to detector instance
                addLanguageProfile(profile, profiles.length);
            } catch (JSONException e) {
                throw new LanguageDetectException(
                        "Profile format error in for: " + profiles[i], ErrorCode.FORMAT_ERROR);
            } catch (IOException e) {
                throw new LanguageDetectException(
                        "Profile format error in for: " + profiles[i], ErrorCode.FORMAT_ERROR);
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    logger.warn("Profile format error in for: " + profiles[i]);
                }
            }
        }
    }

    /**
     * Add profile from specified Language Profile
     * 
     * @param profile
     * @param langsize
     * @param index
     * @throws LanguageDetectException
     */
    protected static void addLanguageProfile(LanguageProfile profile,
            int langsize) throws LanguageDetectException {
        if (logger.isDebugEnabled()) {
            logger.info("Added language profile from specified Profile \""
                    + profile.getLanguageProfile() + "\"");
        }

        String language = profile.getLanguageProfile();
        if (_instance.languages.contains(language)) {
            throw new LanguageDetectException(
                    "Duplicate the same language profile", ErrorCode.DUPLICATE_LANG_ERROR);
        }
        _instance.languages.add(language);
        for (String word : profile.getFrequency().keySet()) {
            if (!_instance.wordLangProbability.containsKey(word)) {
                _instance.wordLangProbability.put(word, new double[langsize]);
            }
            double prob = profile.getFrequency().get(word).doubleValue()
                    / profile.getNWords()[word.length() - 1];
            _instance.wordLangProbability.get(word)[_instance.languages
                    .indexOf(profile.getLanguageProfile())] = prob;
        }
    }

    protected static void clearDetector() {
        _instance.languages.clear();
        _instance.wordLangProbability.clear();
    }

    /**
     * Construct Detector instance
     * 
     * @return Detector instance
     * @throws LanguageDetectException
     */
    public static Detector createInstance() throws LanguageDetectException {
        return createDetector();
    }

    /**
     * Construct Detector instance with smoothing parameter
     * 
     * @param alpha
     *            smoothing parameter (default value = 0.5)
     * @param langSize
     *            number of profiles
     * @return Detector instance
     * @throws LanguageDetectException
     */
    public static Detector createInstance(double alpha) throws LanguageDetectException {
        Detector detector = createDetector();
        detector.setAlpha(alpha);
        return detector;
    }

    private static Detector createDetector() throws LanguageDetectException {
        if (_instance.languages.size() == 0) {
            throw new LanguageDetectException("Need to load profiles",
                    ErrorCode.NEED_LOAD_PROFILE_ERROR);
        }
        Detector detector = new Detector(_instance);
        return detector;
    }

    /**
     * @return the wordLangProbability
     */
    public HashMap<String, double[]> getWordLangProbability() {
        return wordLangProbability;
    }

    /**
     * @return the languages
     */
    public ArrayList<String> getLanguages() {
        return languages;
    }
}
