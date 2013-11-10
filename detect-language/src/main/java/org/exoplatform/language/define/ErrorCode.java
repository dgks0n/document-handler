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
package org.exoplatform.language.define;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version ErrorCode.java Oct 18, 2013
 *
 */
public enum ErrorCode {
	// Text note
	NOTEXTERROR, 
	// Format error
	FORMATERROR, 
	// File loader
	FILELOADERROR, 
	// Duplicate language
	DUPLICATELANGERROR, 
	// Need load profile
	NEEDLOADPROFILEERROR, 
	// Can't detect
	CANTDETECTERROR, 
	// Can't open train data
	CANTOPENTRAINDATA, 
	// Train data format error
	TRAINDATAFORMATERROR, 
	// Error when initialize parameters
	INITPARAMERROR
}
