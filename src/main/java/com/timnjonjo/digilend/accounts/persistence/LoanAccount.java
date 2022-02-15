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
public class LoanAccount extends Auditable {
    private String loanNumber;
    @ManyToOne
    private LoanProduct loanProduct;
    private Double amount;
    private String status;

    public String getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(String loanNumber) {
        this.loanNumber = loanNumber;
    }

    public LoanProduct getLoanProduct() {
        return loanProduct;
    }

    public void setLoanProduct(LoanProduct loanProduct) {
        this.loanProduct = loanProduct;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
