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
import org.exoplatform.common.dao.HibernateManagerImpl;
import org.exoplatform.common.dao.hibernate.HibernateTransactionManager;
import org.exoplatform.common.session.config.HibernateConfiguration;
import org.exoplatform.document.dao.AccountDao;
import org.exoplatform.document.dao.FileDao;
import org.exoplatform.document.dao.LabelDao;
import org.exoplatform.document.dao.OwnerDao;
import org.exoplatform.document.dao.PictureDao;
import org.exoplatform.document.dao.RevisionDao;
import org.exoplatform.document.dao.ThumbnailDao;
import org.exoplatform.document.dao.impl.AccountDaoImpl;
import org.exoplatform.document.dao.impl.FileDaoImpl;
import org.exoplatform.document.dao.impl.LabelDaoImpl;
import org.exoplatform.document.dao.impl.OwnerDaoImpl;
import org.exoplatform.document.dao.impl.PictureDaoImpl;
import org.exoplatform.document.dao.impl.RevisionDaoImpl;
import org.exoplatform.document.dao.impl.ThumbnailDaoImpl;
import org.exoplatform.document.service.PictureService;
import org.exoplatform.document.service.impl.PictureServiceImpl;
import org.exoplatform.document.upload.handle.UploadMultipartHandler;
import org.exoplatform.document.upload.rest.UploadDocumentService;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistryBuilder;
import org.picocontainer.MutablePicoContainer;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version DocumentApplicationComposer.java Nov 17, 2013
 *
 */
public class DocumentApplicationComposer extends EverrestComposer {

	@Override
	protected void doComposeApplication(MutablePicoContainer container, ServletContext servletContext) {
	  container.addComponent(Configuration.class);
	  container.addComponent(ServiceRegistryBuilder.class);
	  container.addComponent(HibernateConfiguration.class);
	  container.addComponent(HibernateTransactionManager.class);
	  container.addComponent(HibernateManagerImpl.class);
	  
	  container.addComponent(AccountDao.class, AccountDaoImpl.class); 
	  container.addComponent(ThumbnailDao.class, ThumbnailDaoImpl.class);
	  container.addComponent(RevisionDao.class, RevisionDaoImpl.class);
	  container.addComponent(PictureDao.class, PictureDaoImpl.class);
	  container.addComponent(OwnerDao.class, OwnerDaoImpl.class);
	  container.addComponent(LabelDao.class, LabelDaoImpl.class);
	  container.addComponent(FileDao.class, FileDaoImpl.class);
	  
	  // Add services component
    container.addComponent(PictureService.class, PictureServiceImpl.class);
    
    container.addComponent(UploadMultipartHandler.class);
    container.addComponent(UploadDocumentService.class);
	}
	
	@Override
	protected void doComposeRequest(MutablePicoContainer container) {
	  container.addComponent(CodepageDetectorProxy.class);
    container.addComponent(CharsetPrinter.class);
    container.addComponent(CodepageProcessor.class);
	}

	@Override
	protected void doComposeSession(MutablePicoContainer container) {

	}
}
