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

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.exoplatform.document.util.exception.DuplicateFileException;
import org.junit.Test;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version TestFileUtils.java Oct 30, 2013
 */
public class TestFileUtils {

	File source;
	
	File target;
	
	@Test
	public void testRenameFile() throws FileNotFoundException, DuplicateFileException, IOException {
		source = FileUtils.toFile(getClass().getResource("source/grid-mixed-1.txt"));
		target = new File(source.getParentFile().getParentFile().getPath() + "/target/grid-mixed-new.txt");
		boolean isSuccess = FileUtils.move(source, target, false);
		assertTrue(isSuccess);
	}

	@Test
	public void testRenameFileDuplicateNotOverwrite() throws FileNotFoundException, IOException {
		source = FileUtils.toFile(getClass().getResource("source/grid-mixed-2.txt"));
		target = new File(source.getParentFile().getParentFile().getPath() + "/target/grid-mixed-2.txt");
		boolean isSuccess = false;
		try {
			isSuccess = FileUtils.move(source, target, false);
		} catch (DuplicateFileException dfe) {
			System.out.println(dfe.getMessage());
		}
		
		assertFalse(isSuccess);
	}
	
	@Test
	public void testRenameFileDuplicateOverwrite() throws FileNotFoundException, DuplicateFileException, IOException {
		source = FileUtils.toFile(getClass().getResource("source/digraphs.txt"));
		target = new File(source.getParentFile().getParentFile().getPath() + "/target/digraphs.txt");
		boolean isSuccess = FileUtils.move(source, target, true);
		assertTrue(isSuccess);
	}
}
