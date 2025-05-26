package com.tfg.backend.services.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.api.request.BoardgameRequest;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRNF;
import com.tfg.backend.exceptions.exceptions.ResourceNotFoundException;
import com.tfg.backend.models.Boardgame;
import com.tfg.backend.models.BoardgameGender;
import com.tfg.backend.models.BoardgameType;
import com.tfg.backend.repository.BoardgameRepository;

@Service
public class BoardgameService {

    
    // DEPENDENCIES \
    @Autowired
    BoardgameRepository boardgameRepository;

    @Autowired
    BoardgameTypeService boardgameTypeService;

    @Autowired
    BoardgameGenderService boardgameGenderService;


    // Add boardgame 
    public Boardgame addBoardGame (BoardgameRequest boardGameRequest){
        if(boardgameRepository.existsByApiBggRef(boardGameRequest.refApiBggRq())) {
            return boardgameRepository.getByBoardgameName(boardGameRequest.boardgameNameRq());
        }
        return boardgameRepository.save(mapToBoardgame(boardGameRequest));
    }

    public Boardgame addBoardGame (Boardgame boardgame){
        if(boardgameRepository.existsByApiBggRef(boardgame.getApiBggRef())) {
            return boardgameRepository.getByApiBggRef(boardgame.getApiBggRef());
        }
        return boardgameRepository.save(boardgame);
    }
           
    // Get boadgame by ID
    public Boardgame getBoardGameById(Integer id){
        Boardgame boardGame = boardgameRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.BOARDGAME_RNF));   
        return boardGame;
    }

    // Get all Boardgames
    public List<Boardgame> getAllBoardgames() {
        return boardgameRepository.findAll();
    }


    // UTILITIES \

    private Boardgame mapToBoardgame(BoardgameRequest boardgameRequest) {
        Boardgame boardgame = new Boardgame();
        BoardgameType boardGameType = boardgameTypeService.getBoardgameType(boardgameRequest.boardgameTypeRq());
        BoardgameGender boardGameGender = boardgameGenderService.getBoardgameGender(boardgameRequest.boardgameGenderRq());
        Boardgame boardGameBase;
        if (boardgameRequest.boardGameBaseRq() != null){
            boardGameBase = getBoardGameById(boardgameRequest.boardGameBaseRq());
            boardgame.setFkBoardgameBase(boardGameBase);
        }
        boardgame.setBoardgameName(boardgameRequest.boardgameNameRq());
        boardgame.setApiBggRef(boardgameRequest.refApiBggRq());
        boardgame.setMinPlayers(boardgameRequest.minPlayersRq());
        boardgame.setMaxPlayers(boardgameRequest.maxPlayersRq());
        boardgame.setReleaseYear(boardgameRequest.releaseYearRq());
        boardgame.setBoardgameDescription(boardgameRequest.boardGameDescriptionRq());
        boardgame.setBoardgameImageUrl(boardgameRequest.boardgameImageUrlRq());
        boardgame.setFkBoardgameType(boardGameType);
        boardgame.setFkBoardgameGender(boardGameGender);

        return boardgame;
    }
}
