package com.tfg.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.api.request.BoardgameRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Boardgame;
import com.tfg.backend.services.operations.BoardgameService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_BOARDGAME)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class BoardgameController {

    @Autowired
    private final BoardgameService boardgameService;

    public BoardgameController(BoardgameService boardGameService) {
        this.boardgameService = boardGameService;
    }

    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_BOARDGAME_CREATE)
    public ResponseEntity<?> createBoardGame(@Valid @RequestBody BoardgameRequest boardGameRequest) {
        Boardgame newBoardGame = boardgameService.addBoardGame(boardGameRequest);
        return new ResponseEntity<>(newBoardGame, HttpStatus.CREATED);
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_BOARDGAME_BY_ID)
    public ResponseEntity<?> getBoardgameById(@PathVariable("id_boardgame") Integer boardgameId) {
        Boardgame boardgame = boardgameService.getBoardGameById(boardgameId);
        return new ResponseEntity<>(boardgame, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_BOARDGAME_ALL)
    public ResponseEntity<?> getAllBoardgames() {
        List<Boardgame> boardgames = boardgameService.getAllBoardgames();
        return new ResponseEntity<>(boardgames, HttpStatus.OK);
    }
}
