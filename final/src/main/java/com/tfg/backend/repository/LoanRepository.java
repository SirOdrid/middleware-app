package com.tfg.backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tfg.backend.models.Loan;
import com.tfg.backend.models.Stock;
import com.tfg.backend.models.User;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findByFkStock(Stock stock);
    List<Loan> findByFkUser(User user);
    List<Loan> findByFkStock_FkUser_UserId(Integer userId);
    List<Loan> findByExpirationDate(Date yesterday);
    List<Loan> findByLoanDate(Date tomorrow);
    // List<Loan> findByExpirationDateAndFkLoanState_LoanStateName(Date yesterday, String string);
    @Query("SELECT l FROM Loan l WHERE l.expirationDate < CURRENT_DATE AND l.fkLoanState.loanStateName = 'pendiente de devolucion'")
    List<Loan> findExpiredLoans();
}
