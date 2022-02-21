package com.timnjonjo.digilend.orchestator;

import com.timnjonjo.digilend.authprovider.persistence.Permission;
import com.timnjonjo.digilend.authprovider.persistence.Role;
import com.timnjonjo.digilend.authprovider.persistence.User;
import com.timnjonjo.digilend.authprovider.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */
@Component
@Slf4j
public class DefaultAccountsSetup {

    private final UserService userService;
    private final RoleService roleService;
    private final PermissionService permissionService;
    private final List<String> permissions;

    @Autowired
    public DefaultAccountsSetup(UserServiceImpl userService, RoleServiceImpl roleService, PermissionService permissionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.permissionService = permissionService;
        this.permissions = Arrays.stream(Permissions.values()).map(Enum::name).collect(Collectors.toList());
    }


    @EventListener(ApplicationReadyEvent.class)
    public void setUpAccounts() {
        this.boostrapPermissions();
        this.createDefaultRole();
        this.createDefaultUser();
        this.createUsersRole();
    }

    private void createDefaultUser() {
        //Get User admin
        User user = userService.findByUsername("admin");
        if (user != null) {
            log.info("Admin User already exists");
            return;
        }
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .fullname("Super Admin")
                .role(new Role(Long.valueOf(1)))
                .username("admin")
                .build();
        this.userService.createUser(createUserRequest);
    }


    // Create Super Role
    public void createDefaultRole() {

        //Get DEFAULT Role
        Optional<Role> optionalRole = this.roleService.findByName(Constants.ADMIN_ROLE_NAME);
        if (optionalRole.isPresent()) {
            log.info("Role {} Exists", Constants.ADMIN_ROLE_NAME);
            log.info("Check missing missions;");
            Role createdRole = optionalRole.get();
            Collection<Permission> rolePermissions = this.permissionService.getPermissionsByRoleId(createdRole.getId());
            List<Permission> permissionsList = this.permissionService.findAll();
            permissionsList.removeAll(rolePermissions);
            if (!permissions.isEmpty()) {
                log.info("Missing Permissions: {}", permissions.size());
                createdRole.getPermissions().addAll(permissionsList);
                this.roleService.getRoleRepository().save(createdRole);
            }

        }

        // Get All Permissions;
        List<Permission> permissions = this.permissionService.findAll();
        CreateRoleRequest request = CreateRoleRequest.builder()
                .name(Constants.ADMIN_ROLE_NAME)
                .permissions(permissions)
                .build();
        this.roleService.createRole(request);
        log.info("Role{} Created", Constants.ADMIN_ROLE_NAME);
    }

    public void createUsersRole() {
        Optional<Role> optionalRole = this.roleService.findByName(Constants.USERS_ROLE_NAME);
        if (!optionalRole.isPresent()) {
            return;
        }
        CreateRoleRequest request = CreateRoleRequest.builder()
                .name(Constants.ADMIN_ROLE_NAME)
                .build();
        this.roleService.createRole(request);
        log.info("Role{} Created", Constants.ADMIN_ROLE_NAME);

    }

    //Bootstrap permissions;
    public void boostrapPermissions() {
        List<Permission> createdPermissions = this.permissionService.findAll();
        List<String> createdPermissionsList = createdPermissions.stream().map(Permission::getName).collect(Collectors.toList());
        this.permissions.removeAll(createdPermissionsList);
        if (!this.permissions.isEmpty()) {
            log.info("Missing Permissions:{} ", permissions.size() - createdPermissions.size());
            List<Permission> permissionsToCreate = permissions.stream().map(Permission::new).collect(Collectors.toList());
            this.permissionService.getPermissionsRepository().saveAll(permissionsToCreate);
            log.info("Created Missing Permissions");
        }
    }
}
