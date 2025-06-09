package com.tfg.backend.api.request.AnalyticsDto;

public record BoardgamesByAssociateDto (
    Long id,
    String boardgameName,
    String boardgameGenderName,
    Integer playCount
) {}

