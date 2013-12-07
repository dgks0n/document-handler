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
package org.exoplatform.document.service.impl;

import org.exoplatform.document.dao.PictureDao;
import org.exoplatform.document.entity.Picture;
import org.exoplatform.document.exception.ServiceException;
import org.exoplatform.document.service.PictureService;
import org.exoplatform.document.util.StringUtils;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version PictureServiceImpl.java Nov 30, 2013
 *
 */
public class PictureServiceImpl implements PictureService {
  
  private PictureDao pictureDao;
  
  public PictureServiceImpl(PictureDao pictureDao) {
    this.pictureDao = pictureDao;
  }

  /* (non-Javadoc)
   * @see org.exoplatform.document.service.PictureService#create(org.exoplatform.document.entity.Picture)
   */
  @Override
  public Picture create(Picture picture) throws ServiceException {
    if (picture == null || StringUtils.isEmpty(picture.getId())) {
      throw new ServiceException("Picture's identifier is invalid");
    }
    
    Picture result = pictureDao.save(picture);
    if (result == null) {
      throw new ServiceException("Could not insert " + picture.toString() + " into \"Picture\" table");
    }
    return result;
  }

  /* (non-Javadoc)
   * @see org.exoplatform.document.service.PictureService#createByURL(java.lang.String)
   */
  @Override
  public Picture createByURL(String URL) throws ServiceException {
    if (StringUtils.isEmpty(URL)) {
      throw new ServiceException("Picture' URL is null or empty");
    }
    
//    Picture picture = new Picture();
//    picture.setId("2304824kasdfa09as13");
//    picture.setUrl(URL);
//    if (pictureDao.save(picture) == null) {
//      throw new ServiceException("Could not insert " + picture.toString() + " into \"Picture\" table");
//    }
    Picture picture = findById("2304824kasdfa09as13");
    if (picture == null) {
      System.out.println("Deo hieu tai sao khong tim duoc");
    }
    return null;
  }

  /* (non-Javadoc)
   * @see org.exoplatform.document.service.PictureService#findById(java.lang.String)
   */
  @Override
  public Picture findById(String Id) throws ServiceException {
    if (StringUtils.isEmpty(Id)) {
      throw new ServiceException("Picture's identify is null or empty");
    }
    return pictureDao.find(Id);
  }

  /* (non-Javadoc)
   * @see org.exoplatform.document.service.PictureService#remove(org.exoplatform.document.entity.Picture)
   */
  @Override
  public boolean remove(Picture picture) throws ServiceException {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see org.exoplatform.document.service.PictureService#removeById(java.lang.String)
   */
  @Override
  public boolean removeById(String Id) throws ServiceException {
    // TODO Auto-generated method stub
    return false;
  }

}
