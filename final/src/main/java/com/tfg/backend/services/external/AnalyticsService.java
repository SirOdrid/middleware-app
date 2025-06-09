package com.tfg.backend.services.external;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.api.request.AnalyticsDto.BoardgameOwnershipDto;
import com.tfg.backend.api.request.AnalyticsDto.BoardgameUsageRateDto;
import com.tfg.backend.api.request.AnalyticsDto.BoardgamesByAssociateDto;
import com.tfg.backend.api.request.AnalyticsDto.GameGenreCountDto;
import com.tfg.backend.api.request.AnalyticsDto.GameStatsDto;
import com.tfg.backend.api.request.AnalyticsDto.LoanStatsDto;
import com.tfg.backend.api.request.AnalyticsDto.RecommendedBoardgameDto;
import com.tfg.backend.repository.Analytics.AnalyticsRepository;

@Service
public class AnalyticsService {

    @Autowired
    private final AnalyticsRepository analyticsRepository;

    public AnalyticsService(AnalyticsRepository analyticsRepository) {
        this.analyticsRepository = analyticsRepository;
    }

    public List<GameStatsDto> getUserStats(Long userId) {
        return analyticsRepository.getActivityMatches(userId);
    }

    public List <GameGenreCountDto> getUserGenre(Long userId) {
        return analyticsRepository.getTopGenresByUser(userId);
    }

    public List<BoardgameUsageRateDto> getLowestUsageBoardgameByUser(Long userId) {
        return analyticsRepository.getLowestUsageBoardgameByUser(userId);
    }

    public List<RecommendedBoardgameDto> getRecommendedBoardgameByUser(Long userId) {
        return analyticsRepository.getRecommendedBoardgameByUser(userId);
    }

    public List<BoardgamesByAssociateDto> getTopBoardgamesByAssociates(Long userId) {
        return analyticsRepository.getTopBoardgamesByAssociates(userId);
    }

    public List<BoardgameOwnershipDto> getBoardgameOwnershipPercentagesByAssociates(Long userId) {
        return analyticsRepository.getBoardgameOwnershipPercentagesByAssociates(userId);
    }

    public List<LoanStatsDto> getBoardgameLoansStatsByUser(Long userId) {
        return analyticsRepository.getBoardgameLoansStatsByUser(userId);
    }
}
