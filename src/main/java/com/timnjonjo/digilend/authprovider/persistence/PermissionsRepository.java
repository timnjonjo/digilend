package com.timnjonjo.digilend.authprovider.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Repository
public interface PermissionsRepository extends JpaRepository<Permission, Long> {
    Permission findByName(String name);
}
