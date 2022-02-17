package com.timnjonjo.digilend.authprovider.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.timnjonjo.digilend.authprovider.persistence.Permission;
import com.timnjonjo.digilend.authprovider.persistence.PermissionsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author TMwaura on 14/10/2019
 * @Project admin-dashboard
 */
@Service
@Slf4j
public class PermissionService {

    private ObjectMapper mapper = new ObjectMapper();


    private final PermissionsRepository permissionsRepository;


    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    public PermissionService(PermissionsRepository permissionsRepository) {
        this.permissionsRepository = permissionsRepository;
    }

    @Cacheable(cacheNames = "permissions", value = "permissions")
    public List<Permission> findAll() {
        return permissionsRepository.findAll();
    }

    public Optional<Permission> createPrivilege(Permission permission) {
        try {
            Permission persistedPermission = permissionsRepository.findByName(permission.getName());
            if (persistedPermission == null) {
                permission = permissionsRepository.saveAndFlush(permission);
                String object = mapper.writeValueAsString(permission);
                log.info("created=[{}]", object);
                return Optional.of(permission);
            }
        } catch (PersistenceException | JsonProcessingException ex) {
            log.error("error={}", ex.getMessage());
        }
        return Optional.empty();
    }


    public Collection<Permission> getPermissionsByRoleId(Long roleId) {
        List<Permission> permissions = new ArrayList<>();
        String hql = "SELECT DISTINCT r.permissions FROM Role r WHERE r.id = :roleId";
        try {
            permissions = entityManager.createQuery(hql)
                    .setParameter("roleId", roleId)
                    .getResultList();

        } catch (Exception e) {
            log.error("error={}", e.getMessage());
        }
        return permissions;
    }

    public PermissionsRepository getPermissionsRepository() {
        return permissionsRepository;
    }
}
