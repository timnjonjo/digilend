package com.timnjonjo.digilend.orchestator;

import com.timnjonjo.digilend.accounts.persistence.LoanProduct;
import lombok.Builder;
import lombok.Data;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */
@Data
public class CreateAccountRequest {
    private String prefferedUsername;
    private String fullname;
    private String phoneNumber;
    private LoanProduct loanProduct;
    private Double creditLimit;
}
