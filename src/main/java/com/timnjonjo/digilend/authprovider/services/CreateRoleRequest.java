package com.timnjonjo.digilend.authprovider.services;

import com.timnjonjo.digilend.authprovider.persistence.Permission;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */
@Data
@Builder
public class CreateRoleRequest {
    private String name;
    private List<Permission> permissions;
}
