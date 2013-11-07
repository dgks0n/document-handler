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
package org.exoplatform.document.composer;

import javax.servlet.ServletContext;

import org.exoplatform.document.upload.rest.UploadDocumentService;
import org.exoplatform.document.upload.util.UploadMultipartHandler;
import org.picocontainer.Characteristics;
import org.picocontainer.MutablePicoContainer;
import org.picocontainer.web.WebappComposer;

/**
 * Created by The eXo Platform SAS
 * @author <a href="mailto:exo@exoplatform.com">eXoPlatform</a>
 *          
 * @version DocumentUploadComposer.java Nov 7, 2013
 */
public class DocumentUploadComposer implements WebappComposer {

	/* (non-Javadoc)
	 * @see org.picocontainer.web.WebappComposer#composeApplication(org.picocontainer.MutablePicoContainer, javax.servlet.ServletContext)
	 */
	@Override
	public void composeApplication(MutablePicoContainer container, ServletContext servletContext) {
		
	}

	/* (non-Javadoc)
	 * @see org.picocontainer.web.WebappComposer#composeSession(org.picocontainer.MutablePicoContainer)
	 */
	@Override
	public void composeSession(MutablePicoContainer container) {

	}

	/* (non-Javadoc)
	 * @see org.picocontainer.web.WebappComposer#composeRequest(org.picocontainer.MutablePicoContainer)
	 */
	@Override
	public void composeRequest(MutablePicoContainer container) {
		container.as(Characteristics.NO_CACHE).addComponent(UploadMultipartHandler.class);
		container.as(Characteristics.NO_CACHE).addComponent(UploadDocumentService.class);
	}
}
