package com.timnjonjo.digilend.accounts.persistence;

import com.timnjonjo.digilend.infra.Auditable;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Entity
@Table
public class CustomerSubscription extends Auditable {
    @ManyToOne
    private CustomerAccount account;
    @ManyToOne
    private LoanProduct product;
    private Double limitAmount;

    public CustomerAccount getAccount() {
        return account;
    }

    public void setAccount(CustomerAccount account) {
        this.account = account;
    }

    public LoanProduct getProduct() {
        return product;
    }

    public void setProduct(LoanProduct product) {
        this.product = product;
    }

    public Double getLimitAmount() {
        return limitAmount;
    }

    public void setLimitAmount(Double limit) {
        this.limitAmount = limit;
    }
}
