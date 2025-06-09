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
import com.tfg.backend.models.BoardgameGender;
import com.tfg.backend.services.operations.BoardgameGenderService;


@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_BOARDGAME_GENDER)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class BoardgameGenderController {
    
    @Autowired
    private final BoardgameGenderService boardgameGenderService;

    // Constructor
    public BoardgameGenderController(BoardgameGenderService boardgameGenderService) {
        this.boardgameGenderService = boardgameGenderService;
    }

    // Get all boardgame genders
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_BOARDGAME_GENDER_ALL)
    public ResponseEntity<?> getAllBoardgameGenders() {
        List<BoardgameGender> boardgameGenders = boardgameGenderService.getAllBoardgameGenders().stream()
            .sorted(Comparator.comparing(BoardgameGender::getBoardgameGenderId))
            .collect(Collectors.toList());
        return new ResponseEntity<>(boardgameGenders, HttpStatus.OK);
    }
}
