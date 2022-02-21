package com.timnjonjo.digilend.accounts.services;

import com.timnjonjo.digilend.accounts.persistence.LoanApplication;
import com.timnjonjo.digilend.accounts.persistence.LoanApplicationRepsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TMwaura on 21/02/2022
 * @Project digilend
 */
@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {
    private final LoanApplicationRepsitory loanApplicationRepsitory;

    @Autowired
    public LoanApplicationServiceImpl(LoanApplicationRepsitory loanApplicationRepsitory) {
        this.loanApplicationRepsitory = loanApplicationRepsitory;
    }

    @Override
    public List<LoanApplication> getLoanApplications() {
        return loanApplicationRepsitory.findAll();
    }
}
