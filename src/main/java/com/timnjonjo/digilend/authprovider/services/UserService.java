package com.timnjonjo.digilend.authprovider.services;

import com.timnjonjo.digilend.authprovider.persistence.User;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */

public interface UserService {
    void createUser(CreateUserRequest createUserRequest);

    User findByUsername(String user);

}
