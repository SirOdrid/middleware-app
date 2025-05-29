package com.tfg.backend.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tfg.backend.config.DataBaseConfig;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = DataBaseConfig.LOAN_ENTITY)
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DataBaseConfig.PK_LOAN_ENTITY)
    private Integer loanId;

    @Column(name = DataBaseConfig.LOAN_COLUMN_LOAN_DATE, columnDefinition = DataBaseConfig.LOAN_COLUMN_LOAN_DATE_DEFINITION)
    @Temporal(TemporalType.DATE)
    private Date loanDate;

    @Column(name = DataBaseConfig.LOAN_COLUMN_EXPIRATION_DATE, columnDefinition = DataBaseConfig.LOAN_COLUMN_EXPIRATION_DATE_DEFINITION)
    @Temporal(TemporalType.DATE)
    private Date expirationDate;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.LOAN_COLUMN_USER, nullable = false)
    private User fkUser;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.LOAN_COLUMN_STOCK, nullable = false)
    private Stock fkStock;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.LOAN_COLUMN_LOAN_STATE, nullable = false)
    private LoanState fkLoanState;

    public Loan() {
    }

    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public User getFkUser() {
        return fkUser;
    }

    public void setFkUser(User fkUser) {
        this.fkUser = fkUser;
    }

    public Stock getFkStock() {
        return fkStock;
    }

    public void setFkStock(Stock fkStock) {
        this.fkStock = fkStock;
    }

    public LoanState getFkLoanState() {
        return fkLoanState;
    }

    public void setFkLoanState(LoanState fkLoanState) {
        this.fkLoanState = fkLoanState;
    }
}
