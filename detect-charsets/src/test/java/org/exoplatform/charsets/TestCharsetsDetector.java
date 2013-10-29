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
package org.exoplatform.charsets;

import static org.junit.Assert.assertEquals;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;

import org.exoplatform.document.util.FileUtils;
import org.junit.Before;
import org.junit.Test;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version TestCharsetsDetector.java Oct 28, 2013
 *
 */
public class TestCharsetsDetector {
	
	private static final Logger logger = LoggerFactory.getLogger(TestCharsetsDetector.class);
	
	static final String RESOURCES_BASE_PATH = "ucs/";
	
	File file;
	
	static CharsetsDetector charsetsDetector;
	
	@Before
	public void setUp() {
		logger.info("Initialization variables");
		
		MutablePicoContainer container = new DefaultPicoContainer();
		container.addComponent(CodepageDetectorProxy.class);
		container.addComponent(CharsetsDetector.class);
		
		charsetsDetector = container.getComponent(CharsetsDetector.class);
		charsetsDetector.addDetectorImplementations();
	}

	@Test
	public void testUnknownCharsetDetector() throws FileNotFoundException {
		file = FileUtils.toFile(getClass().getResource(RESOURCES_BASE_PATH + "UTF-8-test.txt"));
		Charset charset = charsetsDetector.detectCharsetEncoding(file);
		assertEquals("void", charset.toString());
	}

	@Test
	public void testUnicodeCharsetDetector() throws FileNotFoundException {
		file = FileUtils.toFile(getClass().getResource(RESOURCES_BASE_PATH + "TeX.txt"));
		Charset charset = charsetsDetector.detectCharsetEncoding(file);
		assertEquals("UTF-8", charset.toString());
	}
}
