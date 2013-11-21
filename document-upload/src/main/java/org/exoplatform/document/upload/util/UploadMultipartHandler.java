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
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.exoplatform.document.upload.Document;
import org.exoplatform.document.util.FilePathUtils;
import org.exoplatform.document.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version UploadMultipartHandler.java Nov 7, 2013
 */
public class UploadMultipartHandler implements HttpRequestHandler {

  /** . */
	private static final Logger logger = LoggerFactory.getLogger(UploadMultipartHandler.class);
	
	public static final String DEFAULT_SIZE_EXCEEDED = "FILE_UPLOAD_EXCEPTION";
	
	private static final int DEFAULT_FILE_SIZE = 10 * 1024 * 1024; // Maximun is 10MB
	
	private static final int DEFAULT_SIZE_THRESHOLD = 4 * 1024;
	
	private List<Document> documents;
	
	private File file;
	
	/* (non-Javadoc)
	 * @see org.exoplatform.document.upload.util.UploadMultipartPlugin#parseUploadMultipart(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public List<Document> parseUploadMultipart(HttpServletRequest request) throws FileUploadException, IllegalArgumentException, IOException {
		return parseHttpRequest(request);
	}

	/* (non-Javadoc)
	 * @see org.exoplatform.document.upload.util.UploadMultipartPlugin#parseRequestMultipart(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public List<Document> parseHttpRequest(HttpServletRequest request) throws FileUploadException, IllegalArgumentException, IOException {
		if (logger.isDebugEnabled()) {
			logger.info("Parse file item form HTTP servlet request.");
		}
		
		if (request == null) {
			throw new IllegalArgumentException("HTTP servlet request is null.");
		}
		
		Document document = null;
		if (ServletFileUpload.isMultipartContent(request)) {
		  documents = new ArrayList<Document>();
		}
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(DEFAULT_SIZE_THRESHOLD);
		factory.setRepository(FileUtils.forceMkdir(FilePathUtils.REPOSITORY_PATH));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(DEFAULT_FILE_SIZE);
		
		try {
			List<FileItem> items = upload.parseRequest(request);
			Iterator<FileItem> iterator = items.iterator();
			
			logger.info("To create specified sub-folder under " + FilePathUtils.ROOT_PATH + " top-level folder");
			FileUtils.forceMkdir(FilePathUtils.RESOURCE_PATH);
			
			while (iterator.hasNext()) {
				FileItem fileItem = iterator.next();
				if (!fileItem.isFormField()) {
				  document = Document.getInstance();
					document.setFilename(fileItem.getName());
					document.setContentType(fileItem.getContentType());
					document.setSize(fileItem.getSize());
					
					int lastIndexOf = document.getFilename().lastIndexOf("\\");
					file = new File(FilePathUtils.RESOURCE_PATH + File.separator 
					    + document.getFilename().substring((lastIndexOf >= 0) ? lastIndexOf : lastIndexOf + 1));
					
					// Write file items to disk-based
					fileItem.write(file);
					
					// Sets specified local path
          document.setUrl(file.getAbsolutePath());
          document.setReadOnly(false);
          document.setArchive(false);
          document.setDirectory(false);
          document.setHidden(false);
          document.setSystem(false);
          document.setOther(false);
          document.setRegularFile(false);
          
          Date time = Calendar.getInstance().getTime();
          document.setCreationTime(time);
          document.setLastAccessTime(time);
          document.setLastModifiedTime(time);
          
          documents.add(document);
          logger.info("File(s) " + document.getFilename() + " was/were uploaded successfully");
				}
			}
		} catch (FileUploadBase.SizeLimitExceededException slexe) {
		  logger.error("The request was rejected because its size exceeds the configured maximum", slexe);
		  
		  request.setAttribute(DEFAULT_SIZE_EXCEEDED, true);
		  documents = Collections.<Document>emptyList();
		} catch (FileUploadException fue) {
		  
		  throw new FileUploadException("Could not parse multipart servlet request", fue);
		} catch (Exception ex) {
			logger.error("Error encountered while uploading file", ex);
			documents = Collections.<Document>emptyList();
		} finally {
		  
		  try {
		    logger.info("Cleans a directory without deleting it");
        FileUtils.cleanDirectory(factory.getRepository());
      } catch (IOException ioe) {
        logger.warn("Error encountered while cleaning a directory");
      }
		}
		
		return documents;
	}
}
