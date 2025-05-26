package com.tfg.backend.models;

import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = DataBaseConfig.SESSION_ENTITY)
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = DataBaseConfig.PK_SESSION_ENTITY)
    private Integer sessionId;

    @Column(name = DataBaseConfig.SESSION_COLUMN_SESSION_NAME, columnDefinition = DataBaseConfig.SESSION_COLUMN_SESSION_NAME_DEFINITION)
    private String sessionName;

    @Column(name = DataBaseConfig.SESSION_COLUMN_SESSION_DATE, columnDefinition = DataBaseConfig.SESSION_COLUMN_SESSION_DATE_DEFINITION)
    @Temporal(TemporalType.DATE)
    private Date sessionDate;
    
    @ManyToOne
    @JoinColumn(name = DataBaseConfig.SESSION_COLUMN_SESSION_HOST, nullable = false)
    private User fkUser;

    @JsonIgnore
    @OneToMany(mappedBy = "fkSession", cascade = CascadeType.ALL)
    private List<Meeting> meetings;

    @OneToMany( mappedBy = "fkSession", cascade = CascadeType.ALL)
    private List<SessionPlayer> sessionPlayers;

    public Session() {
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public User getFkUser() {
        return fkUser;
    }

    public void setFkUser(User fkUser) {
        this.fkUser = fkUser;
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }

    public void setMeetings(List<Meeting> meetings) {
        this.meetings = meetings;
    }

    public List<SessionPlayer> getSessionPlayers() {
        return sessionPlayers;
    }

    public void setSessionPlayers(List<SessionPlayer> sessionPlayers) {
        this.sessionPlayers = sessionPlayers;
    }

}
