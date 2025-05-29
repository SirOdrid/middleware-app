package com.tfg.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.backend.models.LoanState;

public interface LoanStateRepository extends JpaRepository<LoanState, Integer> {

    LoanState findByLoanStateName(String string);
}
