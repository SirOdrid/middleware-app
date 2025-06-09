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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tfg.backend.api.request.SessionRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Session;
import com.tfg.backend.services.operations.SessionPlayerService;
import com.tfg.backend.services.operations.SessionService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_SESSION)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class SessionController {

    private final SessionService sessionService;
    private final SessionPlayerService sessionPlayerService;

    @Autowired
    public SessionController(SessionService sessionService, SessionPlayerService sessionPlayerService) {
        this.sessionService = sessionService;
        this.sessionPlayerService = sessionPlayerService;
    }
    
    
    // Add Session by User
    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_SESSION_CREATE)
    public ResponseEntity<?> createSession(@Valid @RequestBody SessionRequest sessionRequest) {   
        Session newSession = sessionService.createSession(sessionRequest);
        sessionPlayerService.addPlayersToSession(newSession.getSessionId(), sessionRequest.playerIdsRq());       
        return new ResponseEntity<>(HttpStatus.CREATED);      
    }
    
    // Update Session by User
    @CrossOrigin
    @PutMapping(ApiConfig.ENDPOINT_SESSION_UPDATE)
    public ResponseEntity<?> updateSession(
            @PathVariable(ApiConfig.PATH_SESSION_ID) Integer id_session,
            @Valid @RequestBody SessionRequest sessionRequest) {
        sessionService.updateSession(id_session, sessionRequest);
        sessionPlayerService.updatePlayersToSession(id_session, sessionRequest.playerIdsRq());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Delete Session by User
    @CrossOrigin
    @Transactional
    @DeleteMapping(ApiConfig.ENDPOINT_SESSION_DELETE)
    public ResponseEntity<?> deleteSession(@PathVariable(ApiConfig.PATH_SESSION_ID) Integer id_session) {
        sessionService.deleteSession(id_session);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // Get all Session by user
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_SESSION_ALL_BY_USER)
    public ResponseEntity<List<Session>> getSessionsByHost(@PathVariable(ApiConfig.PATH_USER_ID) Integer id_user) {
        List<Session> sessions = sessionService.getSessionsByHost(id_user);
        return new ResponseEntity<>(sessions, HttpStatus.OK);
    }
}
