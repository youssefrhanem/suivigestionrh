package com.rhanem.backend.security;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.rhanem.backend.persistence.model.Authority;
import com.rhanem.backend.persistence.model.User;
import com.rhanem.backend.persistence.service.IUserService;

@Component
public class CustomUserService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    // API

    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        final User foundByUsername = userService.findByName(username);
        final Set<Authority> authorities = foundByUsername.getAuthorities();
        final List<GrantedAuthority> authoritiesForSpring = SecurityUtil.convertAuthorityEntieiesIntoSpringAuthorities(authorities);
        return new org.springframework.security.core.userdetails.User(username, foundByUsername.getPassword(), authoritiesForSpring);
    }

}
