package com.tfg.backend.api.request.AnalyticsDto;

public record GameStatsDto(
    Long id,
    String boardgameName,
    Long totalGames,
    String averageDuration,
    Boolean inCollection
) {}
