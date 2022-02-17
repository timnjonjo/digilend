package com.timnjonjo.digilend.authprovider.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author TMwaura on 25/01/2020
 * @Project admin-dashboard
 * This is an Implementation of Spring Security UserDetails Object used ty The Authentication Module.
 */
public class PrincipleUser implements UserDetails {

    private User user;
    private Set<Permission> permissions;


    public PrincipleUser(User user, Set<Permission> permissions) {
        super();
        this.user = user;
        this.permissions =permissions;
    }

    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(permissions == null){
            return Collections.emptySet();
        }
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
        permissions.forEach(permission ->
                grantedAuthorities.add(new SimpleGrantedAuthority(permission.getName()))

        );

        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.user.isAccountLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.user.isEnabled();
    }
}
