package com.tfg.backend.api.request.AnalyticsDto;

public record GameGenreCountDto(
    Long id,
    String genreName,
    Long totalGames
) {}