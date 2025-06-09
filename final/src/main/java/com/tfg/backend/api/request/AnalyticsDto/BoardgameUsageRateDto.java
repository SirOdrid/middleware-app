package com.tfg.backend.api.request.AnalyticsDto;

import java.time.LocalDate;

public record BoardgameUsageRateDto (
    Long id,
    String boardgameName,
    Long totalPlayed,
    LocalDate registryDate,
    Double usageRate
){}

