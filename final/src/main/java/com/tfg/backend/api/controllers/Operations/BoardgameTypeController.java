package com.tfg.backend.api.controllers.Operations;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.BoardgameType;
import com.tfg.backend.services.operations.BoardgameTypeService;


@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_BOARDGAME_TYPE)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class BoardgameTypeController {
    
    @Autowired
    private final BoardgameTypeService boardgameTypeService;

    // Constructor
    public BoardgameTypeController(BoardgameTypeService boardgameTypeService) {
        this.boardgameTypeService = boardgameTypeService;
    }

    // Get all boardgame types
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_BOARDGAME_TYPE_ALL)
    public ResponseEntity<?> getAllBoardgameTypes() {
        List<BoardgameType> boardgameTypes = boardgameTypeService.getAllBoardgameTypes().stream()
        .sorted(Comparator.comparing(BoardgameType::getBoardgameTypeId))
        .collect(Collectors.toList());
        return new ResponseEntity<>(boardgameTypes, HttpStatus.OK);
    }

}
