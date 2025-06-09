package com.tfg.backend.api.request.AnalyticsDto;

public record LoanStatsDto (
    String boardgameName,
    Long totalLoans,
    Long totalStock,
    Double averageDurationDays,
    Double averageLoansPerMonth
){}
