package com.timnjonjo.digilend.accounts.persistence;

import com.timnjonjo.digilend.infra.Auditable;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author TMwaura on 16/02/2022
 * @Project digilend
 */
@Entity
@Table
public class CustomerAccount  extends Auditable {
    private String fullname;
    private String phoneNumber;
    private String AccountNumber;
    private String status;

}
