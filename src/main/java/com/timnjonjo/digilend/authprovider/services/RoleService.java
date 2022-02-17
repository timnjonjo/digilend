package com.timnjonjo.digilend.authprovider.services;

import com.timnjonjo.digilend.authprovider.persistence.Role;
import com.timnjonjo.digilend.authprovider.persistence.RoleRepository;

import java.util.Optional;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */
public interface RoleService {
    void createRole(CreateRoleRequest createRoleRequest);

    Optional<Role> findByName(String roleName);

    RoleRepository getRoleRepository();
}
