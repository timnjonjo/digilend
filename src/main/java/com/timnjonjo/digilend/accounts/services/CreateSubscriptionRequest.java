package com.timnjonjo.digilend.accounts.services;

import com.timnjonjo.digilend.accounts.persistence.CustomerAccount;
import com.timnjonjo.digilend.accounts.persistence.LoanProduct;
import lombok.Builder;
import lombok.Data;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */
@Data
@Builder
public class CreateSubscriptionRequest {
    private LoanProduct loanProduct;
    private CustomerAccount customerAccount;
    private Double creditLimit;
}
