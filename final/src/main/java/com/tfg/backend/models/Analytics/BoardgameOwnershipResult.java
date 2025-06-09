package com.tfg.backend.models.Analytics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
    name = "BoardgameOwnershipResult.getBoardgameOwnershipPercentagesByAssociates",
    procedureName = "getBoardgameOwnershipPercentagesByAssociates",
    resultClasses = BoardgameOwnershipResult.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "input_user_id", type = Integer.class)
    }
)
public class BoardgameOwnershipResult {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "boardgame_name")
    private String boardgameName;

    @Column(name = "total_associates_with_game")
    private Long totalAssociatesWithGame;

    @Column(name = "ownership_percentage")
    private Double ownershipPercentage;

    @Column(name = "in_user_collection")
    private Boolean inUserCollection;

    public BoardgameOwnershipResult() {}

    public Long getId() {
        return id;
    }

    public String getBoardgameName() {
        return boardgameName;
    }

    public Long getTotalAssociatesWithGame() {
        return totalAssociatesWithGame;
    }

    public Double getOwnershipPercentage() {
        return ownershipPercentage;
    }

    public Boolean getInUserCollection() {
        return inUserCollection;
    }
}


