package com.tfg.backend.models.Analytics;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
    name = "BoardgameUsageRateResult.getLowestUsageBoardgameByUser",
    procedureName = "GetLowestUsageBoardgameByUser",
    resultClasses = BoardgameUsageRateResult.class,
    parameters = {
        @StoredProcedureParameter(name = "userIdParam", mode = ParameterMode.IN, type = Long.class)
    }
)
public class BoardgameUsageRateResult {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "boardgame_Name")
    private String boardgameName;

    @Column(name = "totalPlayed")
    private Long totalPlayed;

    @Column(name = "registryDate")
    private LocalDate registryDate;

    @Column(name = "usageRate")
    private Double usageRate;

    public Long getId() { return id; }
    public String getBoardgameName() { return boardgameName; }
    public Long getTotalPlayed() { return totalPlayed; }
    public LocalDate getRegistryDate() { return registryDate; }
    public Double getUsageRate() { return usageRate; }

    public void setId(Long id) { this.id = id; }
    public void setBoardgameName(String boardgameName) { this.boardgameName = boardgameName; }
    public void setTotalPlayed(Long totalPlayed) { this.totalPlayed = totalPlayed; }
    public void setRegistryDate(LocalDate registryDate) { this.registryDate = registryDate; }
    public void setUsageRate(Double usageRate) { this.usageRate = usageRate; }
}
