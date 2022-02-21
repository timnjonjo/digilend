package com.timnjonjo.digilend.accounts.services;

import com.timnjonjo.digilend.accounts.persistence.CustomerAccount;
import com.timnjonjo.digilend.accounts.persistence.CustomerAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */
@Service
public class CustomerAccountServiceImpl implements CustomerAccountService {
    private final CustomerAccountRepository customerAccountRepository;

    @Autowired
    public CustomerAccountServiceImpl(CustomerAccountRepository customerAccountRepository) {
        this.customerAccountRepository = customerAccountRepository;
    }

    @Override
    public void createAccount(CreateCustomerAccountRequest customerAccountRequest) {
        CustomerAccount customerAccount = CustomerAccount.builder()
                .AccountNumber(customerAccountRequest.getAccountNumber())
                .fullname(customerAccountRequest.getFullname())
                .phoneNumber(customerAccountRequest.getPhoneNumber())
                .status("NEW")
                .user(customerAccountRequest.getUser())
                .build();
        this.customerAccountRepository.save(customerAccount);
    }

    @Override
    public Optional<CustomerAccount> getCustomerAccount(String accountNumber) {
        return this.customerAccountRepository.findByAccountNumber(accountNumber);
    }


}
