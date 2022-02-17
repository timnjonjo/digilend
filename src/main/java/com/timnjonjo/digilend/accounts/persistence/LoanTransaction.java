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
public class LoanTransaction extends Auditable {
    @ManyToOne
    private LoanAccount loanAccount;
    private String transactionType;
    private Double credit;
    private Double  debit;


    public LoanAccount getLoanAccount() {
        return loanAccount;
    }

    public void setLoanAccount(LoanAccount loanAccount) {
        this.loanAccount = loanAccount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getDebit() {
        return debit;
    }

    public void setDebit(Double debit) {
        this.debit = debit;
    }
}
