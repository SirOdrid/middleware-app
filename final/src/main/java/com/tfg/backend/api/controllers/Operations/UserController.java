package com.tfg.backend.api.controllers.Operations;

import com.tfg.backend.api.request.UserLoginRequest;
import com.tfg.backend.api.request.UserRecoveryRequest;
import com.tfg.backend.api.request.UserRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.User;
import com.tfg.backend.services.operations.UserService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_USER)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class UserController {

    @Autowired
    private final UserService userService;

    // Constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Registry a new user
    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_USER_REGISTRY)
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequest userRequest) {
        userService.createUser(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Login User to App
    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_USER_LOGIN)
    public ResponseEntity<?> userLogin(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        User user = userService.checkLogin(userLoginRequest);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Modify an existing user
    @CrossOrigin
    @PutMapping(ApiConfig.ENDPOINT_USER_EDIT)
    public ResponseEntity<Void> updateUser(@PathVariable(ApiConfig.PATH_USER_ID) Integer id_user, @RequestBody UserRequest userRequest) {
        userService.updateUser(id_user, userRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete user by ID
    @CrossOrigin
    @DeleteMapping(ApiConfig.ENDPOINT_USER_DELETE)
    public ResponseEntity<Void> deleteUser(@PathVariable(ApiConfig.PATH_USER_ID) Integer id_user) {
        userService.deleteUser(id_user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Recovery a password mail
    @CrossOrigin
    @PutMapping(ApiConfig.ENDPOINT_USER_PASSWORD_RECOVERY)
    public ResponseEntity<Void> passwordRecovery(@Valid @RequestBody UserRecoveryRequest userRecoveryRequest) {
        userService.recoveryCredentials(userRecoveryRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_USER_ALL_BY_TYPE)
    public ResponseEntity<List<User>> getUsersByUserType(
        @PathVariable(ApiConfig.PATH_USER_TYPE_ID) Integer userTypeId) {
        
        List<User> users = userService.getUsersByUserType(userTypeId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    // Get all users
    @GetMapping("/search/{name_user}")
    public List<User> searchUserByName(@PathVariable String name_user) {
        return userService.searchUserByName(name_user);
    }

    // // Get user by ID
    // @GetMapping("/{id_user}")
    // public ResponseEntity<?> getUserById(@PathVariable Integer id_user) {
    //     User user = userService.getUserById(id_user);
    //     return new ResponseEntity<>(user, HttpStatus.OK);
    // }

}