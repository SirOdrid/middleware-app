package com.tfg.backend.api.controllers.Operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Boardgame;
import com.tfg.backend.services.operations.BoardgamePackService;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_BOARDGAME_PACK)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class BoardgamePackController {
    
    private final BoardgamePackService boardgamePackService;

    @Autowired
    public BoardgamePackController(BoardgamePackService boardgamePackService) {
        this.boardgamePackService = boardgamePackService;
    }

    // Add Boardgame to Pack
    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_PACK_ADD_BOARDGAME)
    public ResponseEntity<?> addBoardgameToPack(@PathVariable(ApiConfig.PATH_PACK_ID) Integer packId, 
        @PathVariable(ApiConfig.PATH_BOARDGAME_ID) Integer boardgameId) {
            boardgamePackService.addBoardgameToPack(packId, boardgameId);       
            return new ResponseEntity<>(HttpStatus.CREATED);       
    }

    // Delete Boardgame to Pack
    @CrossOrigin
    @DeleteMapping(ApiConfig.ENDPOINT_PACK_DELETE_BOARDGAME)
    public ResponseEntity<?> deleteBoardgameToPack(@PathVariable(ApiConfig.PATH_PACK_ID) Integer packId, 
        @PathVariable(ApiConfig.PATH_BOARDGAME_ID) Integer boardgameId) {
            boardgamePackService.deleteBoardgameToPack(packId, boardgameId);       
            return new ResponseEntity<>(HttpStatus.OK);       
    }

    // Get all Boardgames by Pack
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_PACK_ALL_BOARDGAMES)
    public ResponseEntity<List<Boardgame>> getBoardgamesByPack(@PathVariable(ApiConfig.PATH_PACK_ID) Integer pack_id) {
        List<Boardgame> Pack = boardgamePackService.getBoardgamesByPack(pack_id);
        return new ResponseEntity<>(Pack, HttpStatus.OK);
    }
}
