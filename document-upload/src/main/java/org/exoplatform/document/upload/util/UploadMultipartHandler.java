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

import javax.servlet.http.HttpServletRequest;

import org.exoplatform.document.upload.Document;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version UploadMultipartHandler.java Nov 7, 2013
 */
public class UploadMultipartHandler extends UploadMultipart {

	private static final Logger logger = LoggerFactory.getLogger(UploadMultipartHandler.class);
	
	/* (non-Javadoc)
	 * @see org.exoplatform.document.upload.util.UploadMultipartPlugin#parseUploadMultipart(javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public Document parseUploadMultipart(HttpServletRequest request) throws NullPointerException {
		if (logger.isDebugEnabled()) {
			logger.info("Parse file item form HTTP servlet request.");
		}
		
		if (request == null) {
			throw new NullPointerException("HTTP servlet request is not.");
		}
		
		Document document = null;
//		if (ServletFileUpload.isMultipartContent(request)) {
//			document = Document.getInstance();
//			logger.info("Create new instance for document object.");
//		}
//		
//		ServletFileUpload uploadHandler = new ServletFileUpload();
//        InputStream inputStream = null;
//        document.setFormFields(new HashMap<String, String>());
//        
//        try {
//			FileItemIterator iterator = uploadHandler.getItemIterator(request);
//			while (iterator.hasNext()) {
//				FileItemStream fileItemStream = iterator.next();
//				String fileName = fileItemStream.getFieldName();
//				inputStream = fileItemStream.openStream();
//				if (fileItemStream.isFormField()) {
//					String value = Streams.asString(inputStream);
//					document.getFormFields().put(fileName, value);
//				} else {
//					document.setFilename(fileItemStream.getName());
//					document.setContentType(fileItemStream.getContentType());
//					document.setSize(FileUtils.sizeOf(inputStream, fileName));
//				}
//			}
//		} catch (FileUploadException fue) {
//			logger.error(fue.getMessage(), fue);
//		} catch (IOException ioe) {
//			logger.error(ioe.getMessage(), ioe);
//		} finally {
//			IOUtils.closeQuietly(inputStream);
//		}
        
		return document;
	}
}
