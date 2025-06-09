package com.tfg.backend.api.controllers.Operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.UserType;
import com.tfg.backend.services.operations.UserTypeService;



@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_USER_TYPE)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class UserTypeController {
    
    @Autowired
    private final UserTypeService userTypeService;

    // Constructor
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    // Get all users
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_USER_TYPE_ALL)
    public ResponseEntity<?> getAllUserTypes() {
        List<UserType> userTypes = userTypeService.getAllUserTypes();
        return new ResponseEntity<>(userTypes, HttpStatus.OK);
    }

}
