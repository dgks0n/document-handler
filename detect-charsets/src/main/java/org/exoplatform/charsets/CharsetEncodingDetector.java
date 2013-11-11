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

import info.monitorenter.cpdetector.io.ICodepageDetector;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version CharsetEncodingDetector.java Nov 7, 2013
 */
public interface CharsetEncodingDetector {

	/**
	 * Detector the charset encoding of file depends on file's path. No check for images or other resources is made.
	 * 
	 * @param path - the file's path
	 * 
	 * @return charset encoding
	 * @throws FileNotFoundException - If a problem with the url - handling occurs.
	 */
	public Charset detectCharsetEncoding(String path) throws FileNotFoundException;
	
	/**
	 * Detector the charset encoding of file. Should link to a file containing textual document.
	 * No check for images or other resources is made.
	 * 
	 * @param file - the file input
	 * @return charset encoding
	 * @throws FileNotFoundException - If a problem with the url - handling occurs.
	 */
	public Charset detectCharsetEncoding(File file) throws FileNotFoundException;
	
	/**
	 * <p>
	 * Detects the codepage by iteratively delegating the call to all internal
	 * {@link ICodepageDetector} instances added by
	 * {@link #add(ICodepageDetector)}.
	 * </p>
	 * <p>
	 * The given InputStream has to support mark such that the call
	 * {@link InputStream#mark(int)} with argument length does not throw an
	 * exception. This is needed, as the stream has to be resetted to the
	 * beginning for each internal delegate that tries to detect.
	 * </p>
	 * <p>
	 * If this is impossible (large documents), prefer using
	 * {@link #detectCodepage(URL)}.
	 * </p>
	 * 
	 * @param in
	 *            An InputStream for the document, that supports mark and a
	 *            readlimit of argument length.
	 * 
	 * @param length
	 *            The amount of bytes to take into account. This number shouls
	 *            not be longer than the amount of bytes retrievable from the
	 *            InputStream but should be as long as possible to give the
	 *            fallback detection (chardet) more hints to guess.
	 * 
	 * @see cpdetector.io.ICodepageDetector#detectCodepage(java.io.InputStream,
	 *      int length)
	 * 
	 * @throws IllegalArgumentException
	 *             if more bytes had to be read from the input stream than param
	 *             length or the given input stream does not support marking.
	 */
	public Charset detectCodepage(final InputStream inputStream, final int length) throws IOException, IllegalArgumentException;
}
