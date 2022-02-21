package com.timnjonjo.digilend.accounts.services;

import com.timnjonjo.digilend.authprovider.persistence.User;
import lombok.Builder;
import lombok.Data;

import javax.persistence.OneToOne;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */

@Data
@Builder
public class CreateCustomerAccountRequest {
    private String fullname;
    private String phoneNumber;
    private String AccountNumber;
    private String status;
    @OneToOne
    private User user;
}
