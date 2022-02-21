package com.timnjonjo.digilend.accounts.services;

import com.timnjonjo.digilend.accounts.persistence.LoanApplication;

import java.util.List;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */
public interface LoanApplicationService {
    List<LoanApplication> getLoanApplications();
}
