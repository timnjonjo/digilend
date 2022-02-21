package com.timnjonjo.digilend.accounts.services;

import com.timnjonjo.digilend.accounts.persistence.CustomerAccount;

import java.util.Optional;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */

public interface CustomerAccountService {
    void createAccount(CreateCustomerAccountRequest customerAccountRequest);
    Optional<CustomerAccount> getCustomerAccount(String accountNumber);
}
