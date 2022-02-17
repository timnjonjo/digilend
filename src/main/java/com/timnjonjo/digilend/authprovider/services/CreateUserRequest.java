package com.timnjonjo.digilend.authprovider.services;

import com.timnjonjo.digilend.authprovider.persistence.Role;
import lombok.Builder;
import lombok.Data;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */
@Data
@Builder
public class CreateUserRequest {
    private String username;
    private String fullname;
    private Role role;

}
