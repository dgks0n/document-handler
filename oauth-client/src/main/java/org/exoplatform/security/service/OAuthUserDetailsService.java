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
package org.exoplatform.security.service;

import java.util.Vector;

import javax.inject.Inject;

import org.exoplatform.document.entity.Account;
import org.exoplatform.document.entity.Owner;
import org.exoplatform.document.exception.ServiceException;
import org.exoplatform.document.service.AccountService;
import org.exoplatform.document.service.OwnerService;
import org.exoplatform.document.util.StringUtils;
import org.exoplatform.security.authority.SecurityRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author <a href="mailto:sondn@exoplatform.com">Ngoc Son Dang</a>
 * @version OAuthUserDetailsService.java Dec 26, 2013
 *
 */
public class OAuthUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(OAuthUserDetailsService.class);
    
    @Inject
    private OwnerService ownerService;
    @Inject
    private AccountService accountService;
    
    /* (non-Javadoc)
     * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("Locates the user based on the username: " + username);
        
        Account account = null;
        if (StringUtils.isNotEmpty(username)) {
            try {
                account = accountService.findByUsername(username);
            } catch (ServiceException ex) {
                logger.error(ex.getMessage(), ex);
            }
        }
        
        // Throw error exception if user object still is null
        if (account == null) {
            throw new UsernameNotFoundException("No such user match with " + username);
        }
        
        Vector<GrantedAuthority> authorities = new Vector<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(SecurityRole.ROLE_USER.getAuthority()));
        Owner owner = null;
        try {
            owner = ownerService.findById(account.getId());
            if (owner != null && owner.getPermissionId().equals(SecurityRole.ROLE_ADMIN.getAuthority()))
                authorities.add(new SimpleGrantedAuthority(SecurityRole.ROLE_ADMIN.getAuthority()));
        } catch (ServiceException ex) {
            logger.error(ex.getMessage(), ex);
        }
        
        UserDetails userDetails = new User(account.getUsername(), account.getPassword(), true, true, true, true, authorities);
        return userDetails;
    }

}
