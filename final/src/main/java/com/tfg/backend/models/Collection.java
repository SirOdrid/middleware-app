package com.tfg.backend.models;
import java.util.Date;

import com.tfg.backend.config.DataBaseConfig;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = DataBaseConfig.COLLECTION_ENTITY)
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DataBaseConfig.PK_COLLECTION_ENTITY)
    private Integer collectionId;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.COLLECTION_COLUMN_USER, nullable = false)
    private User fkUser;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.COLLECTION_COLUMN_BOARDGAME, nullable = false)
    private Boardgame fkBoardgame;

    @Column(name = DataBaseConfig.COLLECTION_COLUMN_REGISTRY_DATE, columnDefinition = DataBaseConfig.COLLECTION_COLUMN_REGISTRY_DATE_DEFINITION)
    @Temporal(TemporalType.DATE)
    private Date registryDate;

    public Collection() {
    }

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public User getFkUser() {
        return fkUser;
    }

    public void setFkUser(User fkUser) {
        this.fkUser = fkUser;
    }

    public Boardgame getFkBoardgame() {
        return fkBoardgame;
    }

    public void setFkBoardgame(Boardgame fkBoardgame) {
        this.fkBoardgame = fkBoardgame;
    }

    public Date getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(Date registryDate) {
        this.registryDate = registryDate;
    }

}