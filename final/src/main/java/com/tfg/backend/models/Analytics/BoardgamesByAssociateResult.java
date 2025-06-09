package com.tfg.backend.models.Analytics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
    name = "Top50BoardgamesByAssociates",
    procedureName = "getTop50BoardgamesByAssociates", // debe coincidir exactamente
    resultClasses = BoardgamesByAssociateResult.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "input_user_id", type = Integer.class)
    }
)
public class BoardgamesByAssociateResult {

    @Id
    private Long id;  // No GeneratedValue porque es solo lectura

    @Column(name = "boardgame_name")
    private String boardgameName;

    @Column(name = "boardgame_gender_name")
    private String boardgameGenderName;

    @Column(name = "play_count")
    private Integer playCount;

    // Getters y setters

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBoardgameName() {
        return boardgameName;
    }
    public void setBoardgameName(String boardgameName) {
        this.boardgameName = boardgameName;
    }
    public String getBoardgameGenderName() {
        return boardgameGenderName;
    }
    public void setBoardgameGenderName(String boardgameGenderName) {
        this.boardgameGenderName = boardgameGenderName;
    }
    public Integer getPlayCount() {
        return playCount;
    }
    public void setPlayCount(Integer playCount) {
        this.playCount = playCount;
    }
}
