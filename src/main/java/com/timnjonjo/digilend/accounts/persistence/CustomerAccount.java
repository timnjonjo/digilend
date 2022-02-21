package com.timnjonjo.digilend.accounts.persistence;

import com.timnjonjo.digilend.authprovider.persistence.User;
import com.timnjonjo.digilend.infra.Auditable;
import lombok.Builder;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Entity
@Table
@Builder
public class CustomerAccount  extends Auditable {
    private String fullname;
    private String phoneNumber;
    private String AccountNumber;
    private String status;
    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
