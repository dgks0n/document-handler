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
import org.exoplatform.common.dao.CrudRepositoryImpl;
import org.exoplatform.common.dao.config.RepositorySessionFactory;
import org.exoplatform.common.dao.hibernate.HibernateJpaRepository;
import org.exoplatform.document.repository.AccountRepository;
import org.exoplatform.document.repository.FileRepository;
import org.exoplatform.document.repository.LabelRepository;
import org.exoplatform.document.repository.OwnerRepository;
import org.exoplatform.document.repository.PictureRepository;
import org.exoplatform.document.repository.RevisionRepository;
import org.exoplatform.document.repository.ThumbnailRepository;
import org.exoplatform.document.repository.impl.AccountRepositoryImpl;
import org.exoplatform.document.repository.impl.FileRepositoryImpl;
import org.exoplatform.document.repository.impl.LabelRepositoryImpl;
import org.exoplatform.document.repository.impl.OwnerRepositoryImpl;
import org.exoplatform.document.repository.impl.PictureRepositoryImpl;
import org.exoplatform.document.repository.impl.RevisionRepositoryImpl;
import org.exoplatform.document.repository.impl.ThumbnailRepositoryImpl;
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
        container.addComponent(RepositorySessionFactory.class);
        container.addComponent(HibernateJpaRepository.class);
        container.addComponent(CrudRepositoryImpl.class);

        container.addComponent(AccountRepository.class, AccountRepositoryImpl.class);
        container.addComponent(ThumbnailRepository.class, ThumbnailRepositoryImpl.class);
        container.addComponent(RevisionRepository.class, RevisionRepositoryImpl.class);
        container.addComponent(PictureRepository.class, PictureRepositoryImpl.class);
        container.addComponent(OwnerRepository.class, OwnerRepositoryImpl.class);
        container.addComponent(LabelRepository.class, LabelRepositoryImpl.class);
        container.addComponent(FileRepository.class, FileRepositoryImpl.class);

        // Add services component
        container.addComponent(PictureService.class, PictureServiceImpl.class);
    }

    @Override
    protected void doComposeRequest(MutablePicoContainer container) {
        container.addComponent(CodepageDetectorProxy.class);
        container.addComponent(CharsetPrinter.class);
        container.addComponent(CodepageProcessor.class);
        
        container.addComponent(UploadMultipartHandler.class);
        container.addComponent(UploadDocumentService.class);
    }

    @Override
    protected void doComposeSession(MutablePicoContainer container) {
        // TODO: Edit here
    }
}
