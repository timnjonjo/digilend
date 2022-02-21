package com.timnjonjo.digilend.portal;

import com.timnjonjo.digilend.accounts.services.LoanApplicationService;
import com.timnjonjo.digilend.accounts.services.LoanApplicationServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author TMwaura on 17/02/2022
 * @Project digilend
 */
@Slf4j
@Controller
@RequestMapping("/loan-applications")
public class LoanApplicationController {

    private final LoanApplicationService loanApplicationService;

    @Autowired
    public LoanApplicationController(LoanApplicationServiceImpl loanApplicationService) {
        this.loanApplicationService = loanApplicationService;
    }


    @GetMapping
    public String loanApplications(Model model){
        model.addAttribute( "title", "Loan Applications");
        model.addAttribute("loanapplications", loanApplicationService.getLoanApplications());
        return "loan-applications";
    }
}
