package com.tfg.backend.models;

import java.sql.Time;

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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = DataBaseConfig.MEETING_ENTITY)
public class Meeting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DataBaseConfig.PK_MEETING_ENTITY)
    private Integer meetingId;


    @ManyToOne
    @JoinColumn(name = DataBaseConfig.MEETING_COLUMN_SESSION, nullable = false)
    private Session fkSession;

    @ManyToOne
    @JoinColumn(name = DataBaseConfig.MEETING_COLUMN_BOARDGAME, nullable = false)
    private Boardgame fkBoardgame;

    @Column(name = DataBaseConfig.MEETING_COLUMN_MEETING_DURATION, columnDefinition = DataBaseConfig.MEETING_COLUMN_MEETING_DURATION_DEFINITION)
    @Temporal(TemporalType.TIME)
    private Time meetingDuration;

    public Meeting() {
    }

    public Integer getMeetingId() {
        return meetingId;
    }

    public void setMeetingId(Integer meetingId) {
        this.meetingId = meetingId;
    }

    public Session getFkSession() {
        return fkSession;
    }

    public void setFkSession(Session fkSession) {
        this.fkSession = fkSession;
    }

    public Boardgame getFkBoardgame() {
        return fkBoardgame;
    }

    public void setFkBoardgame(Boardgame fkBoardgame) {
        this.fkBoardgame = fkBoardgame;
    }

    public Time getMeetingDuration() {
        return meetingDuration;
    }

    public void setMeetingDuration(Time meetingDuration) {
        this.meetingDuration = meetingDuration;
    }

}