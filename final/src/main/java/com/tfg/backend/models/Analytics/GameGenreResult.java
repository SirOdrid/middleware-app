package com.tfg.backend.models.Analytics;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;

@Entity
@NamedStoredProcedureQuery(
    name = "GameGenreResult.getTopGenresByUser",
    procedureName = "GetTopGenresByUser",
    resultClasses = GameGenreResult.class,
    parameters = {
        @StoredProcedureParameter(mode = ParameterMode.IN, name = "userIdParam", type = Long.class)
    }
)
public class GameGenreResult {

    @Id
    @Column(name = "genre_id")
    private Long genreId;

    @Column(name = "genre_name")
    private String genreName;

    @Column(name = "total_games")
    private Long totalGames;

    public GameGenreResult() {}

    public Long getGenreId() {
        return genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public Long getTotalGames() {
        return totalGames;
    }
}
