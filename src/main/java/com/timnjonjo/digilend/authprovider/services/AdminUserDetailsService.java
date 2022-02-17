package com.timnjonjo.digilend.authprovider.services;

import com.timnjonjo.digilend.authprovider.persistence.Permission;
import com.timnjonjo.digilend.authprovider.persistence.PrincipleUser;
import com.timnjonjo.digilend.authprovider.persistence.User;
import com.timnjonjo.digilend.authprovider.persistence.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Service
public class AdminUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final PermissionService permissionService;

    public AdminUserDetailsService(UserRepository userRepository, PermissionService permissionService) {
        super();
        this.userRepository = userRepository;
        this.permissionService = permissionService;
    }


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = this.userRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("No user Found with username " + userName);
        }
        Set<Permission> permissions = new HashSet<>();
        permissions.addAll(this.permissionService.getPermissionsByRoleId(user.getRole().getId()));
        return new PrincipleUser(user, permissions);
    }


}
