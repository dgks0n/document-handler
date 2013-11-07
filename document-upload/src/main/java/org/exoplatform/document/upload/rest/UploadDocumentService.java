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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
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
@Path("/document/upload")
public class UploadDocumentService {
	
	// https://github.com/venuduggireddy/samples/tree/master/WebRoot
	private UploadMultipartHandler uploadMultipartHandler;
	
	public UploadDocumentService(UploadMultipartHandler uploadMultipartHandler) {
		this.uploadMultipartHandler = uploadMultipartHandler;
	}

	@POST
    @Path("file")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.TEXT_PLAIN)
    public Response uploadFile(@Context HttpServletRequest request, @Context HttpServletResponse response) throws Exception {
		String responseText = "Unable to attach files";
		Document bean = uploadMultipartHandler.parseUploadMultipart(request);
		if (null != bean) {
			responseText = "{\"fileName\":\"" + bean.getFilename()
					+ "\",\"type\":\"" + bean.getContentType()
					+ "\",\"size\":\"" + bean.getSize() + "\"}";
		}
		return Response.ok(responseText).build();
    }
}
