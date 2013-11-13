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
package org.exoplatform.language;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;


/**
 * {@link Language} is to store the detected _language.
 * {@link Detector#getProbabilities()} returns an {@link ArrayList} of {@link Language}s.
 * 
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version Language.java Oct 18, 2013
 *
 */
public class Language {

	private String _language;
	private double _probability;

	public Language(String language, double probability) {
		this._language = language;
		this._probability = probability;
	}
	
	/**
	 * @return the _language
	 */
	public String getLanguage() {
		return _language;
	}

	/**
	 * @param _language
	 *            the _language to set
	 */
	public void setLanguage(String language) {
		this._language = language;
	}

	/**
	 * @return the _probability
	 */
	public double getProbability() {
		return _probability;
	}

	/**
	 * @param _probability
	 *            the _probability to set
	 */
	public void setProbability(double probability) {
		this._probability = probability;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((_language == null) ? 0 : _language.hashCode());
		long temp;
		temp = Double.doubleToLongBits(_probability);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Language other = (Language) obj;
		if (_language == null) {
			if (other._language != null)
				return false;
		} else if (!_language.equals(other._language))
			return false;
		if (Double.doubleToLongBits(_probability) != Double.doubleToLongBits(other._probability))
			return false;
		return true;
	}

	public String toString() {
		if (StringUtils.isEmpty(_language)) {
			return "";
		}
		return  "{" + _language + ":" + _probability + "}";
	}
}
