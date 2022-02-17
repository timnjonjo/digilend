package com.timnjonjo.digilend.authprovider.services;

import com.timnjonjo.digilend.authprovider.persistence.Permission;
import com.timnjonjo.digilend.authprovider.persistence.Role;
import com.timnjonjo.digilend.authprovider.persistence.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final PermissionService permissionService;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository, PermissionService permissionService) {
        this.roleRepository = roleRepository;
        this.permissionService = permissionService;
    }

    @Override
    public void createRole(CreateRoleRequest createRoleRequest) {

        Role role = Role.builder()
                .permissions(createRoleRequest.getPermissions())
                .name(createRoleRequest.getName())
                .build();
        roleRepository.save(role);
        log.info("Role {} Created", createRoleRequest.getName());
    }

    @Override
    public Optional<Role> findByName(String roleName) {
        return roleRepository.findByName(roleName);
    }

    @Override
    public RoleRepository getRoleRepository() {
        return this.roleRepository;
    }


}
