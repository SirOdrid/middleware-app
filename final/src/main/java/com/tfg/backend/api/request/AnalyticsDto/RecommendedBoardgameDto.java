package com.tfg.backend.api.request.AnalyticsDto;

public record RecommendedBoardgameDto(
    Long id,
    String boardgameName,
    String boardgameDescription,
    Long globalPlayCount
) {}

