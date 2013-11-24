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

import info.monitorenter.cpdetector.CharsetPrinter;
import info.monitorenter.cpdetector.CodepageProcessor;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;

import javax.servlet.ServletContext;

import org.everrest.pico.EverrestComposer;
import org.exoplatform.document.upload.rest.UploadDocumentService;
import org.exoplatform.document.upload.util.UploadMultipartHandler;
import org.picocontainer.MutablePicoContainer;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version DocumentApplicationComposer.java Nov 17, 2013
 *
 */
public class DocumentApplicationComposer extends EverrestComposer {

	@Override
	protected void doComposeApplication(MutablePicoContainer container, ServletContext servletContext) {
		// And adding component in apllication scope container minds one instance of 
	  // component per web application.
	}
	
	@Override
	protected void doComposeRequest(MutablePicoContainer container) {
	  // Adding component in request scope container minds new instance of 
	  // components will be created for each request.
		container.addComponent(CodepageDetectorProxy.class);
		container.addComponent(CharsetPrinter.class);
		container.addComponent(CodepageProcessor.class);
	}

	@Override
	protected void doComposeSession(MutablePicoContainer container) {
	  // Adding component is session scope container minds one instance of 
	  // component per HTTP session.
	  container.addComponent(UploadMultipartHandler.class);
    container.addComponent(UploadDocumentService.class);
	}
}
