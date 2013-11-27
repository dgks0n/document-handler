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

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import net.arnx.jsonic.JSON;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;
import org.apache.commons.fileupload.FileUploadException;
import org.exoplatform.document.upload.Document;
import org.exoplatform.document.upload.handle.UploadMultipartHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version UploadDocumentService.java Nov 7, 2013
 */
@Path("/document-service/document")
public class UploadDocumentService implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = -2858971360376069291L;

  private static final Logger logger = LoggerFactory.getLogger(UploadDocumentService.class);
  
  private static final String WS_UPLOAD_PATH = "/upload";

  private UploadMultipartHandler uploadMultipartHandler;

  public UploadDocumentService(UploadMultipartHandler uploadMultipartHandler) {
    this.uploadMultipartHandler = uploadMultipartHandler;
  }

  @POST
  @Path(UploadDocumentService.WS_UPLOAD_PATH)
  @Produces(MediaType.APPLICATION_JSON)
  public Response uploadFile(@Context HttpServletRequest request) {
    String responseText = null;
    String message = null;
    List<Document> documents = new ArrayList<Document>();
    try {
      documents = uploadMultipartHandler.parseHttpRequest(request);
      if (CollectionUtils.isNotEmpty(documents)) {
        responseText = JSON.encode(documents.get(0));
        return Response.ok(responseText).build();
      } else {
        message = "An IO exception has occurred while reading the properties file";
        responseText = "{\"error\":\"" + 2015
            + "\",\"message\":\"" + message + "\"}";
      }
    } catch (SizeLimitExceededException slee) {
      message = slee.getMessage();
      responseText = "{\"error\":\"" + 2013
          + "\",\"message\":\"" + message + "\"}";
      
      logger.error(message, slee);
    } catch (FileUploadException fue) {
      message = fue.getMessage();
      responseText = "{\"error\":\"" + 2014
          + "\",\"message\":\"" + message + "\"}";
      
      logger.error(message, fue);
    } catch (IOException ioe) {
      message = "An IO exception has occurred while reading the properties file";
      responseText = "{\"error\":\"" + 2015
          + "\",\"message\":\"" + message + "\"}";
      
      logger.error(message, ioe);
    }
    
    return Response.status(Response.Status.BAD_REQUEST).entity(responseText).build();
  }
}
