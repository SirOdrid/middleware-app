package com.tfg.backend.api.controllers.Operations;


import com.tfg.backend.api.request.UserAssociateRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.User;
import com.tfg.backend.models.UserAssociate;
import com.tfg.backend.services.operations.UserAssociateService;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_USER_ASSOCIATE)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class UserAssociateController {

    private final UserAssociateService userAssociateService;

    public UserAssociateController(UserAssociateService userAssociateService) {
        this.userAssociateService = userAssociateService;
    }

    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_ASSOCIATION_ADD)
    public ResponseEntity<?> addAssociation(@Valid @RequestBody UserAssociateRequest userAssociateRequest) {
        userAssociateService.addAssociation(userAssociateRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin
    @DeleteMapping(ApiConfig.ENDPOINT_ASSOCIATION_DELETE)
    public ResponseEntity<Void> deleteAssociation(@PathVariable(ApiConfig.PATH_USER_ASSOCIATE_ID) Integer associationId) {
        userAssociateService.deleteAssociation(associationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_ASSOCIATED_USERS_BY_HOST)
    public ResponseEntity<List<UserAssociate>> getAllAssociationsByHostUser(@PathVariable("id_user") Integer hostUserId) {
        List<UserAssociate> associations = userAssociateService.getAllAssociationsByHostUser(hostUserId);
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_ASSOCIATIONS_BY_USER)
    public ResponseEntity<List<UserAssociate>> getAllAssociationsByAssociatedUser(@PathVariable("id_user") Integer associatedUserId) {
        List<UserAssociate> associations = userAssociateService.getAllAssociationsByAssociatedUser(associatedUserId);
        return new ResponseEntity<>(associations, HttpStatus.OK);
    }
}
