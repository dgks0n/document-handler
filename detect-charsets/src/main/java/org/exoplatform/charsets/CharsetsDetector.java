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

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.ByteOrderMarkDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;
import info.monitorenter.util.StringUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version CharsetsDetector.java Oct 26, 2013
 *
 */
public class CharsetsDetector {

	private static final Logger logger = LoggerFactory.getLogger(CharsetsDetector.class);
	
	CodepageDetectorProxy detector;
	
	public CharsetsDetector(CodepageDetectorProxy detector) {
		this.detector = detector;
	}
	
	/**
	 * Add the implementations of info.monitorenter.cpdetector.io.ICodepageDetector
	 * 
	 */
	public void addDetectorImplementations() {
		// This one is quick if we deal with unicode codepages: 
	    detector.add(new ByteOrderMarkDetector()); 
	    // The first instance delegated to tries to detect the meta charset attribut in html pages.
	    detector.add(new ParsingDetector(true)); // be verbose about parsing.
	    // This one does the tricks of exclusion and frequency detection, if first implementation is unsuccessful:
	    detector.add(JChardetFacade.getInstance()); // Another singleton.
	    detector.add(ASCIIDetector.getInstance()); // Fallback, see javadoc.
	    detector.add(UnicodeDetector.getInstance());
	}
	
	public Charset detectCharsetEncoding(String path) throws FileNotFoundException {
		if (StringUtil.isEmpty(path)) {
			throw new FileNotFoundException("The file's path '" + path + "' is invalid.");
		}
		
		return detectCharsetEncoding(new File(path));
	}
	
	public Charset detectCharsetEncoding(File file) throws FileNotFoundException {
		if (!file.exists()) {
			throw new FileNotFoundException("The file's path '" + file.getAbsolutePath() + "' is invalid.");
		}
		
		// Default is unknown charsets encode
		Charset charset = null;
		try {
			charset = detector.detectCodepage(file.toURI().toURL());
		} catch (MalformedURLException mue) {
			logger.error("The file's path is malformed.", mue);
		} catch (IOException ioe) {
			logger.error("Cannot detect charsets encoding of file " + file.getName() + ".", ioe);
		}
		return charset;
	}
}
