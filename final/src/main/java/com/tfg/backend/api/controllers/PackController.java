package com.tfg.backend.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.api.request.PackRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Pack;
import com.tfg.backend.services.operations.PackService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_PACK)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class PackController {

    private final PackService packService;

    @Autowired
    public PackController(PackService PackService) {
        this.packService = PackService;
    }
    
    // Add Pack to User
    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_PACK_CREATE)
    public ResponseEntity<?> createPack(@Valid @RequestBody PackRequest packRequest) {
        Pack newPack = packService.createPack(packRequest);       
        return new ResponseEntity<>(newPack, HttpStatus.CREATED);       
    }

    // Delete Pack to User
    @CrossOrigin
    @Transactional
    @DeleteMapping(ApiConfig.ENDPOINT_PACK_DELETE)
    public ResponseEntity<?> deletePack(@PathVariable(ApiConfig.PATH_PACK_ID) Integer packId) {
        packService.deletePack(packId);       
        return new ResponseEntity<>(HttpStatus.OK);       
    }

    // Get all Pack by user
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_PACK_ALL_BY_USER)
    public ResponseEntity<List<Pack>> getUserPack(@PathVariable(ApiConfig.PATH_USER_ID) Integer user_id) {
        List<Pack> Pack = packService.getUserPack(user_id);
        return new ResponseEntity<>(Pack, HttpStatus.OK);
    }
}
