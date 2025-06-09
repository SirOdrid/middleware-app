package com.tfg.backend.models.Analytics;

import jakarta.persistence.*;

@Entity
@NamedStoredProcedureQuery(
    name = "GameStats.getActivityMatches",
    procedureName = "GetActivityMatches",
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userIdParam", type = Long.class)
    },
    resultClasses = GameStatsResult.class
)
public class GameStatsResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String boardgameName;
    private Long totalGames;
    private String averageDuration;
    private Boolean inCollection;

    // Getters y setters

    public String getBoardgameName() {
        return boardgameName;
    }

    public void setBoardgameName(String boardgameName) {
        this.boardgameName = boardgameName;
    }

    public Long getTotalGames() {
        return totalGames;
    }

    public void setTotalGames(Long totalGames) {
        this.totalGames = totalGames;
    }

    public String getAverageDuration() {
        return averageDuration;
    }

    public void setAverageDuration(String averageDuration) {
        this.averageDuration = averageDuration;
    }

    public Boolean getInCollection() {
        return inCollection;
    }

    public void setInCollection(Boolean inCollection) {
        this.inCollection = inCollection;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
