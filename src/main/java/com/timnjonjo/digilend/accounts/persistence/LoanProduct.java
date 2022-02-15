package com.timnjonjo.digilend.accounts.persistence;

import com.timnjonjo.digilend.infra.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author TMwaura on 15/02/2022
 * @Project digilend
 */
@Entity
@Table
public class LoanProduct extends Auditable {
    private String name;
    private String description;
    private Double interestRate;
    private Double maxAmount;
    private Double minimumAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    public Double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(Double maxAmount) {
        this.maxAmount = maxAmount;
    }

    public Double getMinimumAmount() {
        return minimumAmount;
    }

    public void setMinimumAmount(Double minimunAmount) {
        this.minimumAmount = minimunAmount;
    }
}
