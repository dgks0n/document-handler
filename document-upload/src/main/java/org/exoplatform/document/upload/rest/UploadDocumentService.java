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
package org.exoplatform.document.upload.rest;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.exoplatform.document.upload.Document;
import org.exoplatform.document.upload.util.UploadMultipartHandler;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version UploadDocumentService.java Nov 7, 2013
 */
@Path("/document")
public class UploadDocumentService {
	
	private static final String WS_UPLOAD_PATH = "/upload";
	private static final String WS_SERVICE_INFORMATION_PATH = "/service-infor";
	
	private UploadMultipartHandler uploadMultipartHandler;
	
	public UploadDocumentService(UploadMultipartHandler uploadMultipartHandler) {
		this.uploadMultipartHandler = uploadMultipartHandler;
	}

	@POST
    @Path(UploadDocumentService.WS_UPLOAD_PATH)
	@Produces(MediaType.APPLICATION_JSON)
    public Response uploadFile(@Context HttpServletRequest request) throws Exception {
		String responseText = "Unable to attach files";
		List<Document> documents = uploadMultipartHandler.parseHttpRequest(request);
		if (null != documents && documents.size() > 0) {
			responseText = "{\"fileName\":\"" + documents.get(0).getFilename()
					+ "\",\"type\":\"" + documents.get(0).getContentType()
					+ "\",\"size\":\"" + documents.get(0).getSize() + "\"}";
		}
		return Response.ok(responseText).build();
    }
	
	@GET
    @Path(UploadDocumentService.WS_SERVICE_INFORMATION_PATH)
	@Produces(MediaType.APPLICATION_JSON)
	public ServiceInfor checkFileSize() {
		ServiceInfor serviceInfor = new ServiceInfor();
		serviceInfor.setAuthor("Ngoc Son Dang");
		serviceInfor.setServiceName(getClass().getName());
		serviceInfor.setOwner(true);
		serviceInfor.setDescription("Upload Document REST service");
		return serviceInfor;
	}
	
	public class ServiceInfor implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8224416078047201046L;
		
		String author;
		
		String serviceName;
		
		boolean isOwner;
		
		String description;

		/**
		 * 
		 */
		public ServiceInfor() {
			super();
		}

		/**
		 * @param author
		 * @param serviceName
		 * @param isOwner
		 * @param description
		 */
		public ServiceInfor(String author, String serviceName, boolean isOwner,
				String description) {
			super();
			this.author = author;
			this.serviceName = serviceName;
			this.isOwner = isOwner;
			this.description = description;
		}

		/**
		 * @return the author
		 */
		public String getAuthor() {
			return author;
		}

		/**
		 * @param author the author to set
		 */
		public void setAuthor(String author) {
			this.author = author;
		}

		/**
		 * @return the serviceName
		 */
		public String getServiceName() {
			return serviceName;
		}

		/**
		 * @param serviceName the serviceName to set
		 */
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}

		/**
		 * @return the isOwner
		 */
		public boolean isOwner() {
			return isOwner;
		}

		/**
		 * @param isOwner the isOwner to set
		 */
		public void setOwner(boolean isOwner) {
			this.isOwner = isOwner;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}

		/**
		 * @param description the description to set
		 */
		public void setDescription(String description) {
			this.description = description;
		}
	}
}
