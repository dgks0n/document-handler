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

import static org.junit.Assert.*;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;

import java.io.File;
import java.nio.charset.Charset;

import org.exoplatform.document.util.FileUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.PicoContainer;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version TestCharsetsDetector.java Oct 28, 2013
 *
 */
public class TestCharsetsDetector {
	
	static final String RESOURCES_BASE_PATH = "ucs/";
	
	File file;
	
	CharsetsDetector charsetsDetector;

	@Test
	public void testCharsetsDetector1() {
		file = FileUtils.toFile(getClass().getResource(RESOURCES_BASE_PATH + "UTF-8-test.txt"));
		MutablePicoContainer container = new DefaultPicoContainer();
		container.addComponent(CodepageDetectorProxy.class);
		container.addComponent(CharsetsDetector.class);
		
		charsetsDetector = container.getComponent(CharsetsDetector.class);
		Charset charset = charsetsDetector.getFileEncode(file);
		
		assertEquals("utf-8", charset.name());
	}

}
