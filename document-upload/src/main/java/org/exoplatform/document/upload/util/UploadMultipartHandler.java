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
package org.exoplatform.document.upload.util;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.exoplatform.document.upload.Document;
import org.exoplatform.document.util.FilePathUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version UploadMultipartHandler.java Nov 7, 2013
 */
public class UploadMultipartHandler extends HttpServlet implements HttpRequestHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2024802260998718378L;

	private static final Logger logger = LoggerFactory.getLogger(UploadMultipartHandler.class);
	
	private static final String DATA_DIRECTORY = "data";
	
	private static final int DEFAULT_FILE_SIZE = 50 * 1024;
	
	private static final int DEFAULT_SIZE_THRESHOLD = 4 * 1024;
	
	private String filePath;
	
	private File file;
	
	/* (non-Javadoc)
	 * @see org.exoplatform.document.upload.util.UploadMultipartPlugin#parseUploadMultipart(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public List<Document> parseUploadMultipart(HttpServletRequest request) throws NullPointerException, FileUploadException {
		return parseHttpRequest(request);
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.upload.util.UploadMultipartPlugin#parseRequestMultipart(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public List<Document> parseHttpRequest(HttpServletRequest request) throws NullPointerException, FileUploadException {
		if (logger.isDebugEnabled()) {
			logger.info("Parse file item form HTTP servlet request.");
		}
		
		if (request == null) {
			throw new NullPointerException("HTTP servlet request is not.");
		}
		
		Document document = null;
		// Check that we have a file upload request
		if (ServletFileUpload.isMultipartContent(request)) {
			document = Document.getInstance();
			logger.info("Create new instance for document object.");
		}
		
		// Get the file location where it would be stored.
		filePath = getServletContext().getRealPath("") + File.separator + DATA_DIRECTORY;
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// Set factory constraints
		// Maximum size that will be stored in memory
		factory.setSizeThreshold(DEFAULT_SIZE_THRESHOLD);
		// Sets the directory used to temporarily store files that are larger
        // than the configured size threshold. We use temporary directory for java
		factory.setRepository(new File(FilePathUtils.TEMPRORY_PATH));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// Set overall request size constraint. 
		// Maximum file size to be uploaded.
		upload.setSizeMax(DEFAULT_FILE_SIZE);
		
		try {
			// Parse the request
			List<FileItem> items = upload.parseRequest(request);
			// Process the uploaded items
			Iterator<FileItem> iterator = items.iterator();
			while (iterator.hasNext()) {
				FileItem fileItem = iterator.next();
				if (!fileItem.isFormField()) {
					document.setFilename(fileItem.getName());
					document.setContentType(fileItem.getContentType());
					document.setSize(fileItem.getSize());
					
					int lastIndexOf = document.getFilename().lastIndexOf("\\");
					file = new File(filePath + document.getFilename().substring((lastIndexOf >= 0) ? lastIndexOf : lastIndexOf + 1));
					// Write file items to disk-based
					fileItem.write(file);
				}
			}
		} catch (Exception ex) {
			logger.error("Error encountered while uploading file.", ex);
		}
		
		return null;
	}
}
