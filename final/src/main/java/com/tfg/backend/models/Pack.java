package com.tfg.backend.models;

import java.util.List;

import javax.xml.crypto.Data;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tfg.backend.config.DataBaseConfig;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = DataBaseConfig.PACK_ENTITY)
public class Pack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DataBaseConfig.PK_PACK_ENTITY)
    private Integer packId;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.PACK_COLUMN_USER, nullable = false)
    private User fkUser;

    @Column(name = DataBaseConfig.PACK_COLUMN_PACK_NAME, columnDefinition = DataBaseConfig.PACK_COLUMN_PACK_NAME_DEFINITION)
    private String packName;
    
    @OneToMany(mappedBy = "fkPack", cascade = CascadeType.ALL)
    private List<BoardgamePack> boardgamePacks;

    public Pack() {
    }

    public Integer getPackId() {
        return packId;
    }

    public void setPackId(Integer packId) {
        this.packId = packId;
    }

    public User getFkUser() {
        return fkUser;
    }

    public void setFkUser(User fkUser) {
        this.fkUser = fkUser;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public List<BoardgamePack> getBoardgamePacks() {
        return boardgamePacks;
    }

    public void setBoardgamePacks(List<BoardgamePack> boardgamePacks) {
        this.boardgamePacks = boardgamePacks;
    }

}
