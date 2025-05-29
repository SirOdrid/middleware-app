package com.tfg.backend.services.operations;
import com.tfg.backend.api.request.LoanRequest;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRNF;
import com.tfg.backend.exceptions.exceptions.ResourceNotFoundException;
import com.tfg.backend.models.Loan;
import com.tfg.backend.models.LoanState;
import com.tfg.backend.models.Stock;
import com.tfg.backend.models.User;
import com.tfg.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private LoanStateRepository loanStateRepository;

    public void addLoan(LoanRequest loanRequest) {
        User user = userRepository.findById(loanRequest.fkUserRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
        
        Stock stock = stockRepository.findById(loanRequest.fkStockRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.STOCK_RNF));
        
        LoanState loanState = loanStateRepository.findById(loanRequest.fkLoanStateRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.LOAN_STATE_RNF));

        Loan loan = new Loan();
        loan.setLoanDate(loanRequest.loanDateRq());
        loan.setExpirationDate(loanRequest.expirationDateRq());
        loan.setFkUser(user);
        loan.setFkStock(stock);
        loan.setFkLoanState(loanState);

        loanRepository.save(loan);
    }

    public void updateLoan(Integer loanId, LoanRequest loanRequest) {
        Loan existingLoan = loanRepository.findById(loanId)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.LOAN_RNF));
        
        User user = userRepository.findById(loanRequest.fkUserRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
        
        Stock stock = stockRepository.findById(loanRequest.fkStockRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.STOCK_RNF));
        
        LoanState loanState = loanStateRepository.findById(loanRequest.fkLoanStateRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.LOAN_STATE_RNF));

        existingLoan.setLoanDate(loanRequest.loanDateRq());
        existingLoan.setExpirationDate(loanRequest.expirationDateRq());
        existingLoan.setFkUser(user);
        existingLoan.setFkStock(stock);
        existingLoan.setFkLoanState(loanState);

        loanRepository.save(existingLoan);
    }

    public void deleteLoan(Integer loanId) {
        if (loanRepository.existsById(loanId)) {
            loanRepository.deleteById(loanId);
        }
       
    }

    public List<Loan> getAllLoansByStockId(Integer stockId) {
        Stock stock = stockRepository.findById(stockId)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.STOCK_RNF));
        return loanRepository.findByFkStock(stock);
    }

    public List<Loan> getAllLoansByUserId(Integer userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
        return loanRepository.findByFkStock_FkUser_UserId(user.getUserId());
    }
}
