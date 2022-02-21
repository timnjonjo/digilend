package com.timnjonjo.digilend.orchestator;

import com.timnjonjo.digilend.accounts.persistence.CustomerAccount;
import com.timnjonjo.digilend.accounts.services.*;
import com.timnjonjo.digilend.authprovider.persistence.User;
import com.timnjonjo.digilend.authprovider.services.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */
@Service
@Slf4j
public class CreateCustomerAccountServiceImpl implements CreateCustomerAccountService {

    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final CustomerAccountService customerAccountService;
    private final RoleService roleService;

    @Autowired
    public CreateCustomerAccountServiceImpl(UserServiceImpl userService, SubscriptionServiceImpl subscriptionService, CustomerAccountServiceImpl customerAccountService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
        this.customerAccountService = customerAccountService;
        this.roleService = roleService;
    }

    @Override
    public void createAccount(CreateAccountRequest createAccountRequest) {
        //Create User

        userService.createUser(CreateUserRequest.builder()
                .username(createAccountRequest.getPrefferedUsername())
                .role(this.roleService.getDefaultUsersRole().get())
                .fullname(createAccountRequest.getFullname())
                .build());
        //get user
        User user = userService.findByUsername(createAccountRequest.getPrefferedUsername());
        //Create Account
        CreateCustomerAccountRequest customerAccountRequest = CreateCustomerAccountRequest.builder()
                .AccountNumber(createAccountRequest.getPhoneNumber())
                .fullname(createAccountRequest.getFullname())
                .status("NEW")
                .user(user)
                .build();

        this.customerAccountService.createAccount(customerAccountRequest);
        Optional<CustomerAccount> customerAccount = this.customerAccountService.getCustomerAccount(customerAccountRequest.getAccountNumber());
        if (!customerAccount.isPresent()){
            log.info("missing Account");
        }
        //Create Sub
        this.subscriptionService.createSubscription(CreateSubscriptionRequest.builder()
                        .customerAccount(customerAccount.get())
                        .creditLimit(createAccountRequest.getCreditLimit())
                        .loanProduct(createAccountRequest.getLoanProduct())
                .build() );

    }
}
