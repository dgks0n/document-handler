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
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version LanguageDetectorTest.java Oct 19, 2013
 *
 */
public class TestLanguageDetector {
	
	Detector detector;
	
	static final String[] profiles = {"af", "ar", "bg", "bn", "cs", "da", "de", "el", "en", "es", "et", "fa", "fi", 
			"fr", "gu", "he", "hi", "hr", "hu", "id", "it", "ja", "kn", "ko", "lt", "lv", "mk", "ml", "mr", "ne", 
			"nl", "no", "pa", "pl", "pt", "ro", "ru", "sk", "so", "sq", "sv", "sw", "ta", "te", "th", "tl", 
			"tr", "uk", "ur", "vi", "zh-cn", "zh-tw"};

	@BeforeClass
	public static void setup() throws LanguageDetectException {
		DetectorFactory.clearDetector();
		DetectorFactory.loadLanguageProfiles(profiles);
	}
	
	@After
	public void tearDown() throws LanguageDetectException {
	}
	
	@Test
	public void testDetectEnglish() throws LanguageDetectException {
		String text_en = "A jQuery plugin for responsive navigation. Naver is an easy way to turn any navigation system into a responsive-ready, mobile-friendly toggle.";
		
		detector = DetectorFactory.createInstance(0.5);
		detector.appendTarget(text_en);
		assertEquals("en", detector.detect());
	}
	
	@Test
	public void testDetectFrench() throws LanguageDetectException {
		String text_fr = "Les utilisateurs de Microsoft Office : traduire entre toutes les langues prises en charge. Installer des langues supplémentaires dans le bureau.";
		
		detector = DetectorFactory.createInstance(0.5);
		detector.appendTarget(text_fr);
		assertEquals("fr", detector.detect());
	}
	
	@Test
	public void testDetectSpanish() throws LanguageDetectException {
		String text_es = "Los usuarios de Microsoft Office: traducir entre todos los idiomas. Instalar idiomas adicionales en la oficina.";
		
		detector = DetectorFactory.createInstance(0.5);
		detector.appendTarget(text_es);
		assertEquals("es", detector.detect());
	}
	
	@Test
	public void testDetectJapanese() throws LanguageDetectException {
		String text_ja = "エストニア語、リトアニア語、ラトビア語、スロベニア語の言語プロファイルを追加";
		detector = DetectorFactory.createInstance(0.5);
		detector.appendTarget(text_ja);
		assertEquals("ja", detector.detect());
	}
	
	@Test
	public void testDetectKorean() throws LanguageDetectException {
		String text_ko = "뉴스스탠드 바로가기 오픈캐스트 바로가기 주제별캐스트 바로가기 타임스퀘어 바로가기 쇼핑캐스트 바로가기 로그인 바로가기";
		detector = DetectorFactory.createInstance(0.5);
		detector.appendTarget(text_ko);
		assertEquals("ko", detector.detect());
	}
}
