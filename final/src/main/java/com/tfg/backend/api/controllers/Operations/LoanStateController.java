package com.tfg.backend.api.controllers.Operations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.LoanState;
import com.tfg.backend.services.operations.LoanStateService;

import java.util.List;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_LOAN_STATE)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class LoanStateController {

    @Autowired
    private final LoanStateService loanStateService;

    public LoanStateController(LoanStateService loanStateService) {
        this.loanStateService = loanStateService;
    }

    @CrossOrigin
    @GetMapping
    @RequestMapping(ApiConfig.ENDPOINT_LOAN_STATE_ALL)
    public List<LoanState> getAllLoanStates() {
        return loanStateService.getAllLoanStates();
    }
}
