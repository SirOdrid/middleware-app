package com.tfg.backend.api.controllers.Operations;
import com.tfg.backend.api.request.LoanRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Loan;
import com.tfg.backend.services.operations.LoanService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_LOAN)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_LOAN_ADD)
    public ResponseEntity<?> addLoan(@Valid @RequestBody LoanRequest loanRequest) {
        loanService.addLoan(loanRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping(ApiConfig.ENDPOINT_LOAN_UPDATE)
    public ResponseEntity<?> updateLoan(
            @PathVariable(ApiConfig.PATH_LOAN_ID) Integer loanId,
            @Valid @RequestBody LoanRequest loanRequest) {
        loanService.updateLoan(loanId, loanRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(ApiConfig.ENDPOINT_LOAN_DELETE)
    public ResponseEntity<Void> deleteLoan(@PathVariable(ApiConfig.PATH_LOAN_ID) Integer loanId) {
        loanService.deleteLoan(loanId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_LOAN_ALL_BY_STOCK)
    public ResponseEntity<List<Loan>> getAllLoansByStockId(@PathVariable(ApiConfig.PATH_STOCK_ID) Integer stockId) {
        List<Loan> loans = loanService.getAllLoansByStockId(stockId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_LOAN_ALL_BY_USER)
    public ResponseEntity<List<Loan>> getAllLoansByUserId(@PathVariable(ApiConfig.PATH_USER_ID) Integer userId) {
        List<Loan> loans = loanService.getAllLoansByUserId(userId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
}