package com.tfg.backend.models.Analytics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
    name = "LoanStatsResult.getBoardgameLoansStatsByUser",
    procedureName = "getBoardgameLoansStatsByUser",
    resultClasses = LoanStatsResult.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "input_user_id", type = Integer.class)
    }
)
public class LoanStatsResult {

    @Id
    @Column(name = "boardgame_name")
    private String boardgameName;

    @Column(name = "total_loans")
    private Long totalLoans;

    @Column(name = "total_stock")
    private Long totalStock;

    @Column(name = "avg_duration_days")
    private Double averageDurationDays;

    @Column(name = "avg_loans_per_month")
    private Double averageLoansPerMonth;

    public LoanStatsResult() {}

    public String getBoardgameName() {
        return boardgameName;
    }

    public Long getTotalLoans() {
        return totalLoans;
    }

    public Long getTotalStock() {
        return totalStock;
    }

    public Double getAverageDurationDays() {
        return averageDurationDays;
    }

    public Double getAverageLoansPerMonth() {
        return averageLoansPerMonth;
    }
}
