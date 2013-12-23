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
package org.exoplatform.document.upload.plugin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.exoplatform.document.upload.Document;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version HttpRequestHandler.java Nov 20, 2013
 *
 */
public interface HttpRequestHandler {

	/**
	 * Just handle one file upload in this handler, developer can extend to support multi-files upload
	 * 
	 * @param request
	 * @return
	 * @throws FileUploadException 
	 * 
	 * @deprecated Use {@link #parseHttpRequest(HttpServletRequest)} instead for
	 */
	@Deprecated
	public List<Document> parseUploadMultipart(HttpServletRequest request) throws SizeLimitExceededException, FileUploadException;
	
	/**
	 * Just handle one file upload in this handler, developer can extend to support multi-files upload 
	 * 
	 * @param request
	 * @return
	 * @throws FileUploadException 
	 */
	public List<Document> parseHttpRequest(HttpServletRequest request) throws SizeLimitExceededException, FileUploadException;
}
