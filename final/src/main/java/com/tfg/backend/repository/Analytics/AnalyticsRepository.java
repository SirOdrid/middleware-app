package com.tfg.backend.repository.Analytics;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.tfg.backend.api.request.AnalyticsDto.BoardgameOwnershipDto;
import com.tfg.backend.api.request.AnalyticsDto.BoardgameUsageRateDto;
import com.tfg.backend.api.request.AnalyticsDto.BoardgamesByAssociateDto;
import com.tfg.backend.api.request.AnalyticsDto.GameGenreCountDto;
import com.tfg.backend.api.request.AnalyticsDto.GameStatsDto;
import com.tfg.backend.api.request.AnalyticsDto.LoanStatsDto;
import com.tfg.backend.api.request.AnalyticsDto.RecommendedBoardgameDto;
import com.tfg.backend.models.Analytics.BoardgameOwnershipResult;
import com.tfg.backend.models.Analytics.BoardgameUsageRateResult;
import com.tfg.backend.models.Analytics.BoardgamesByAssociateResult;
import com.tfg.backend.models.Analytics.GameGenreResult;
import com.tfg.backend.models.Analytics.GameStatsResult;
import com.tfg.backend.models.Analytics.LoanStatsResult;
import com.tfg.backend.models.Analytics.RecommendedBoardgameResult;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;

@Repository
public class AnalyticsRepository {

        @PersistenceContext
        private EntityManager entityManager;

        public List<GameStatsDto> getActivityMatches(Long userId) {
                StoredProcedureQuery query = entityManager
                                .createNamedStoredProcedureQuery("GameStats.getActivityMatches")
                                .setParameter("userIdParam", userId);

                @SuppressWarnings("unchecked")
                List<GameStatsResult> results = query.getResultList();

                return results.stream()
                                .map(r -> new GameStatsDto(
                                                r.getId(),
                                                r.getBoardgameName(),
                                                r.getTotalGames(),
                                                r.getAverageDuration(),
                                                r.getInCollection()))
                                .toList();
        }

        public List<GameGenreCountDto> getTopGenresByUser(Long userId) {
                StoredProcedureQuery query = entityManager
                                .createNamedStoredProcedureQuery("GameGenreResult.getTopGenresByUser")
                                .setParameter("userIdParam", userId);

                @SuppressWarnings("unchecked")
                List<GameGenreResult> results = query.getResultList();

                return results.stream()
                                .map(r -> new GameGenreCountDto(
                                                r.getGenreId(),
                                                r.getGenreName(),
                                                r.getTotalGames()))
                                .toList();
        }

        public List<BoardgameUsageRateDto> getLowestUsageBoardgameByUser(Long userId) {
                StoredProcedureQuery query = entityManager
                                .createNamedStoredProcedureQuery(
                                                "BoardgameUsageRateResult.getLowestUsageBoardgameByUser")
                                .setParameter("userIdParam", userId);

                @SuppressWarnings("unchecked")
                List<BoardgameUsageRateResult> results = query.getResultList();

                return results.stream()
                                .map(r -> new BoardgameUsageRateDto(
                                                r.getId(),
                                                r.getBoardgameName(),
                                                r.getTotalPlayed(),
                                                r.getRegistryDate(),
                                                r.getUsageRate()))
                                .toList();
        }

        public List<RecommendedBoardgameDto> getRecommendedBoardgameByUser(Long userId) {
                StoredProcedureQuery query = entityManager
                                .createNamedStoredProcedureQuery(
                                                "RecommendedBoardgameResult.getRecommendedBoardgameByUser")
                                .setParameter("userIdParam", userId);

                @SuppressWarnings("unchecked")
                List<RecommendedBoardgameResult> results = query.getResultList();

                return results.stream()
                                .map(r -> new RecommendedBoardgameDto(
                                                r.getId(),
                                                r.getBoardgameName(),
                                                r.getBoardgameDescription(),
                                                r.getGlobalPlayCount()))
                                .toList();
        }

        public List<BoardgamesByAssociateDto> getTopBoardgamesByAssociates(Long userId) {
                StoredProcedureQuery query = entityManager
                                .createNamedStoredProcedureQuery("Top50BoardgamesByAssociates")
                                .setParameter("input_user_id", userId.intValue());

                @SuppressWarnings("unchecked")
                List<BoardgamesByAssociateResult> results = query.getResultList();

                return results.stream()
                                .map(r -> new BoardgamesByAssociateDto(
                                                r.getId(),
                                                r.getBoardgameName(),
                                                r.getBoardgameGenderName(),
                                                r.getPlayCount()))
                                .toList();
        }

        public List<BoardgameOwnershipDto> getBoardgameOwnershipPercentagesByAssociates(Long userId) {
                StoredProcedureQuery query = entityManager
                                .createNamedStoredProcedureQuery(
                                                "BoardgameOwnershipResult.getBoardgameOwnershipPercentagesByAssociates")
                                .setParameter("input_user_id", userId.intValue());

                @SuppressWarnings("unchecked")
                List<BoardgameOwnershipResult> results = query.getResultList();

                return results.stream()
                                .map(r -> new BoardgameOwnershipDto(
                                                r.getId(),
                                                r.getBoardgameName(),
                                                r.getTotalAssociatesWithGame(),
                                                r.getOwnershipPercentage(),
                                                r.getInUserCollection()))
                                .toList();
        }

        public List<LoanStatsDto> getBoardgameLoansStatsByUser(Long userId) {
                StoredProcedureQuery query = entityManager
                                .createNamedStoredProcedureQuery("LoanStatsResult.getBoardgameLoansStatsByUser")
                                .setParameter("input_user_id", userId.intValue());

                @SuppressWarnings("unchecked")
                List<LoanStatsResult> results = query.getResultList();

                return results.stream()
                                .map(r -> new LoanStatsDto(
                                                r.getBoardgameName(),
                                                r.getTotalLoans(),
                                                r.getTotalStock(),
                                                r.getAverageDurationDays(),
                                                r.getAverageLoansPerMonth()))
                                .toList();
        }
}
