package com.timnjonjo.digilend.authprovider.services;

import com.timnjonjo.digilend.authprovider.persistence.Role;
import com.timnjonjo.digilend.authprovider.persistence.User;
import com.timnjonjo.digilend.authprovider.persistence.UserRepository;
import com.timnjonjo.digilend.infra.Helper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .accountLocked(false)
                .enabled(true)
                .loginAttempts(0)
                .password(Helper.passwordEncoder().encode(createUserRequest.getUsername()))
                .fullname(createUserRequest.getFullname())
                .credentialsExpiryDate(Helper.getNewDateAfterAddingDays(10))
                .role(createUserRequest.getRole())
                .username(createUserRequest.getUsername())
                .build();
        userRepository.save(user);
        log.info("User: {} Created", user.getFullname());
    }

    @Override
    public User findByUsername(String user) {
        return userRepository.findByUsername(user);
    }


}
