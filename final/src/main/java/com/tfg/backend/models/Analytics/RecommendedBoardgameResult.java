package com.tfg.backend.models.Analytics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
    name = "RecommendedBoardgameResult.getRecommendedBoardgameByUser",
    procedureName = "GetRecommendedBoardgameByUserGenre",
    resultClasses = RecommendedBoardgameResult.class,
    parameters = {
        @StoredProcedureParameter(name = "userIdParam", mode = ParameterMode.IN, type = Long.class)
    }
)
public class RecommendedBoardgameResult {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "boardgame_name")
    private String boardgameName;

    @Column(name = "boardgamedescription")
    private String boardgameDescription;

    @Column(name = "globalPlayCount")
    private Long globalPlayCount;

    public Long getId() { return id; }
    public String getBoardgameName() { return boardgameName; }
    public String getBoardgameDescription() { return boardgameDescription; }
    public Long getGlobalPlayCount() { return globalPlayCount; }

    public void setId(Long id) { this.id = id; }
    public void setBoardgameName(String boardgameName) { this.boardgameName = boardgameName; }
    public void setBoardgameDescription(String boardgameDescription) { this.boardgameDescription = boardgameDescription; }
    public void setGlobalPlayCount(Long globalPlayCount) { this.globalPlayCount = globalPlayCount; }
}

