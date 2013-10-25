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
package org.exoplatform.language.exception;

import org.exoplatform.language.define.ErrorCode;



/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version LanguageDetectException.java Oct 18, 2013
 *
 */
public class LanguageDetectException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6106838564536761251L;

	private ErrorCode errorCode;
	
	public LanguageDetectException(String message) {
		super(message);
	}
	
	public LanguageDetectException(Throwable cause) {
		super(cause);
	}
	
	public LanguageDetectException(String message, Throwable cause) {
		super(message, cause);
	}
	
    public LanguageDetectException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    /**
     * @return the error errorCode
     */
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
