package com.tfg.backend.api.controllers.External;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.api.request.AnalyticsDto.BoardgameOwnershipDto;
import com.tfg.backend.api.request.AnalyticsDto.BoardgameUsageRateDto;
import com.tfg.backend.api.request.AnalyticsDto.BoardgamesByAssociateDto;
import com.tfg.backend.api.request.AnalyticsDto.GameGenreCountDto;
import com.tfg.backend.api.request.AnalyticsDto.GameStatsDto;
import com.tfg.backend.api.request.AnalyticsDto.LoanStatsDto;
import com.tfg.backend.api.request.AnalyticsDto.RecommendedBoardgameDto;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.services.external.AnalyticsService;

@RestController
@RequestMapping("/tc_api/v1/analytics")
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class AnalyticsController {

    private final AnalyticsService analyticsService;

    public AnalyticsController(AnalyticsService analyticsService) {
        this.analyticsService = analyticsService;
    }

    @GetMapping("/activity/user/{userId}")
    public ResponseEntity<List<GameStatsDto>> getGameStats(@PathVariable Long userId) {
        List<GameStatsDto> stats = analyticsService.getUserStats(userId);
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }

    @GetMapping("/genres/user/{userId}")
    public ResponseEntity<List<GameGenreCountDto>> getGameGenres(@PathVariable Long userId) {
        List<GameGenreCountDto> genres = analyticsService.getUserGenre(userId);
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @GetMapping("/usage/user/{userId}")
    public ResponseEntity<List<BoardgameUsageRateDto>> getLowestUsageBoardgameByUser(@PathVariable Long userId) {
        List<BoardgameUsageRateDto> usage = analyticsService.getLowestUsageBoardgameByUser(userId);
        return new ResponseEntity<>(usage, HttpStatus.OK);
    }

    @GetMapping("/recommended/user/{userId}")
    public ResponseEntity<List<RecommendedBoardgameDto>> getRecommendedBoardgameByUser(@PathVariable Long userId) {
        List<RecommendedBoardgameDto> recommended = analyticsService.getRecommendedBoardgameByUser(userId);
        return new ResponseEntity<>(recommended, HttpStatus.OK);
    }

    @GetMapping("/associate_boardgames/user/{userId}")
    public ResponseEntity<List<BoardgamesByAssociateDto>> getTopBoardgamesByAssociates(@PathVariable Long userId) {
        List<BoardgamesByAssociateDto> topAssociates = analyticsService.getTopBoardgamesByAssociates(userId);
        return new ResponseEntity<>(topAssociates, HttpStatus.OK);
    }

    @GetMapping("/associate_compose/user/{userId}")
    public ResponseEntity<List<BoardgameOwnershipDto>> getBoardgameOwnershipPercentagesByAssociates(@PathVariable Long userId) {
        List<BoardgameOwnershipDto> ownership = analyticsService.getBoardgameOwnershipPercentagesByAssociates(userId);
        return new ResponseEntity<>(ownership, HttpStatus.OK);
    }

    @GetMapping("/loan_activity/user/{userId}")
    public ResponseEntity<List<LoanStatsDto>> getBoardgameLoansStatsByUser(@PathVariable Long userId) {
        List<LoanStatsDto> loans = analyticsService.getBoardgameLoansStatsByUser(userId);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
}

