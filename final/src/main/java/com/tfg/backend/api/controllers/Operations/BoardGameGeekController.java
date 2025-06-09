package com.tfg.backend.api.controllers.Operations;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Boardgame;
import com.tfg.backend.services.external.BoardGameGeekService;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_BOARDGAME)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class BoardGameGeekController {

    private final BoardGameGeekService bggService;

    public BoardGameGeekController(BoardGameGeekService bggService) {
        this.bggService = bggService;
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_BOARDGAMEGEEK_SEARCH_BOARDGAME)
    public List<Boardgame> searchBoardGames(@PathVariable("boardgame_name") String boardgameName) {
        return bggService.searchTopRelevantGames(boardgameName);
    }
}   