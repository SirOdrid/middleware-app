package com.tfg.backend.models;

import javax.xml.crypto.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tfg.backend.config.DataBaseConfig;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = DataBaseConfig.BOARDGAME_PACK_ENTITY)
public class BoardgamePack {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DataBaseConfig.PK_BOARDGAME_PACK_ENTITY)
    private Integer boardgamePackId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = DataBaseConfig.BOARDGAME_PACK_COLUMN_PACK, nullable = false)
    private Pack fkPack;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.BOARDGAME_PACK_COLUMN_BOARDGAME, nullable = false)
    private Boardgame fkBoardgame;

    public BoardgamePack() {
    }

    public Integer getBoardgamePackId() {
        return boardgamePackId;
    }

    public void setBoardgamePackId(Integer boardgamePackId) {
        this.boardgamePackId = boardgamePackId;
    }

    public Pack getFkPack() {
        return fkPack;
    }

    public void setFkPack(Pack fkPack) {
        this.fkPack = fkPack;
    }

    public Boardgame getFkBoardgame() {
        return fkBoardgame;
    }

    public void setFkBoardgame(Boardgame fkBoardgame) {
        this.fkBoardgame = fkBoardgame;
    }
}
