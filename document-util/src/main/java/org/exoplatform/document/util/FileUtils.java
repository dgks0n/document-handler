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
package org.exoplatform.document.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.CountingInputStream;
import org.exoplatform.document.util.exception.DuplicateFileException;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version FileUtils.java Oct 26, 2013
 *
 */
public class FileUtils extends org.apache.commons.io.FileUtils {

	/**
	 * Move or rename a file to a target file.
	 * 
	 * By default, this method attempts to move the file to the target file, failing if the target file exists except if the source and target are the same file, in which case this method has no effect.
	 * If the file is a symbolic link then the symbolic link itself, not the target of the link, is moved.
	 * 
	 * @param source - the path to the file to move
	 * @param target - the path to the target file (may be associated with a different provider to the source path)
	 * @param isOverwrite - options specifying how the move or rename should be done
	 * 
	 * @return True if probably move or rename otherwise is False
	 * 
	 * @throws FileNotFoundException if source file doen't exist or File's path is invalid.
	 * @throws IOException
	 */
	public static boolean move(File source, File target, boolean isOverwrite) throws FileNotFoundException, DuplicateFileException, IOException {
		if (!source.exists()) {
			throw new FileNotFoundException("The system cannot find the file specified. File's path " + source.getAbsolutePath());
		}
		
		File existing = new File(target.getParentFile().getPath() + File.separator + source.getName());
		if (!isOverwrite && existing.exists()) {
			throw new DuplicateFileException("The process cannot move or rename the file " + source.getName() + " because it is being used by another file.");
		}
		
		return source.renameTo(target);
	}
	
	/**
	 * Move or rename a file to a target file.
	 * 
	 * By default, this method attempts to move the file to the target file, failing if the target file exists except if the source and target are the same file, in which case this method has no effect.
	 * If the file is a symbolic link then the symbolic link itself, not the target of the link, is moved.
	 * 
	 * @param source - the path to the file to move
	 * @param targetName - the name of the target file
	 * @param isOverwrite - options specifying how the move or rename should be done
	 * 
	 * @return True if probably move or rename otherwise is False
	 * 
	 * @throws FileNotFoundException if source file doen't exist or File's path is invalid.
	 * @throws IOException
	 */
	public static boolean move(File source, String targetName, boolean isOverwrite) throws FileNotFoundException, DuplicateFileException, IOException {
		File target = new File(source.getParentFile().getPath() + File.separator + targetName);
		return move(source, target, isOverwrite);
	}
	
	/**
	 * Returns the size of the specified file or directory. If the provided File is a regular file, then the file's length is returned.
	 * If the argument is a directory, then the size of the directory is calculated recursively. If a directory or subdirectory is security restricted, its size will not be included.
	 * 
	 * @param inputStream - the input stream
	 * @param fileName - the file's name
	 * 
	 * @return the length of the file, or recursive size of the directory, provided (in bytes).
	 * @throws NullPointerException - if the file is null
	 * @throws IllegalArgumentException - if the file does not exist.
	 */
	public static long sizeOf(InputStream inputStream, String fileName) throws NullPointerException, IllegalArgumentException {
		if (inputStream == null) {
			throw new NullPointerException("The input stream is null.");
		}
		
    FileOutputStream fileOutputStream = null;
    CountingInputStream countingInputStream = null;

    long sizeOfFile = 0;
    try {
      fileName = FileNameUtils.getName(fileName);
      fileOutputStream = new FileOutputStream(new File(FilePathUtils.ROOT_PATH + fileName));
      countingInputStream = new CountingInputStream(inputStream);

      // Write file directly on location
      IOUtils.copyLarge(countingInputStream, fileOutputStream);
      sizeOfFile = countingInputStream.getByteCount();
    } catch (Exception ex) {
      sizeOfFile = 0;
    } finally {
      IOUtils.closeQuietly(countingInputStream);
      IOUtils.closeQuietly(fileOutputStream);
    }

    return sizeOfFile;
	}
	
	/**
	 * Create a file or folder from specified path or the directory cannot be created then an exception is thrown.
	 * 
	 * @param filePath - the specified local path
	 * @return File - created file
	 * 
	 * @throws IllegalArgumentException if the file's Path is <code>null</code>
	 * @throws IOException if the directory cannot be created
	 */
	public static File forceMkdir(String filePath) throws IllegalArgumentException, IOException {
    if (StringUtils.isEmpty(filePath)) {
      throw new IllegalArgumentException("Unable to create directory "
          + filePath);
    }

    File directory = new File(filePath);
    if (!directory.exists()) {
      if (!directory.mkdirs()) {
        throw new IOException("Unable to create directory " + directory);
      }
    }

    return directory;
	}
}
