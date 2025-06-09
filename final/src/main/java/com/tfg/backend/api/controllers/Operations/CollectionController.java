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
import com.tfg.backend.services.operations.CollectionService;

import jakarta.transaction.Transactional;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_COLLECTION)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class CollectionController {

    private final CollectionService collectionService;

    @Autowired
    public CollectionController(CollectionService collectionService) {
        this.collectionService = collectionService;
    }
    
    // Add boardgame to user collection
    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_BOARDGAME_ADD_TO_COLLECTION)
    public ResponseEntity<?> addBoardgameToCollection(
            @PathVariable(ApiConfig.PATH_USER_ID) Integer userId,
            @PathVariable(ApiConfig.PATH_BOARDGAME_ID) Integer boardgameId) {
        collectionService.addBoardgameToCollection(userId,boardgameId);       
        return new ResponseEntity<>(HttpStatus.CREATED);       
    }

    // Delete boardgame to user collection
    @CrossOrigin
    @Transactional
    @DeleteMapping(ApiConfig.ENDPOINT_BOARDGAME_DELETE_FROM_COLLECTION)
    public ResponseEntity<?> deleteBoardgameToCollection(
        @PathVariable(ApiConfig.PATH_USER_ID) Integer userId,
        @PathVariable(ApiConfig.PATH_BOARDGAME_ID) Integer boardgameId) {
        collectionService.deleteBoardgameToCollection(userId,boardgameId);       
        return new ResponseEntity<>(HttpStatus.OK);       
    }

    // Get all collection by user
    @CrossOrigin
    @Transactional
    @GetMapping(ApiConfig.ENDPOINT_BOARDGAME_COLLECTION_BY_USER)
    public ResponseEntity<List<Boardgame>> getUserCollection(@PathVariable(ApiConfig.PATH_USER_ID) Integer user_id) {
        List<Boardgame> collection = collectionService.getUserCollection(user_id);
        return new ResponseEntity<>(collection, HttpStatus.OK);
    }
}
