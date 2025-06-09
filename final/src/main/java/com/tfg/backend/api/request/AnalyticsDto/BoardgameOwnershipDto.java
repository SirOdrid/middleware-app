package com.tfg.backend.api.request.AnalyticsDto;

public record BoardgameOwnershipDto (
    Long id,
    String boardgameName,
    Long totalAssociatesWithGame,
    Double ownershipPercentage,
    Boolean inUserCollection
){}
