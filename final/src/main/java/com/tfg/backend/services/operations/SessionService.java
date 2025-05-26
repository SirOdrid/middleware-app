package com.tfg.backend.services.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.api.request.PackRequest;
import com.tfg.backend.api.request.SessionRequest;
import com.tfg.backend.data.ErrorMessages.ErrorMessageConflicts;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRNF;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRequests;
import com.tfg.backend.exceptions.exceptions.ConflictException;
import com.tfg.backend.exceptions.exceptions.ResourceNotFoundException;
import com.tfg.backend.models.Pack;
import com.tfg.backend.models.Session;
import com.tfg.backend.models.User;
import com.tfg.backend.repository.SessionRepository;
import com.tfg.backend.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Session createSession(SessionRequest sessionRequest) {
        User host = userRepository.findById(sessionRequest.fkUserRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));

        Session newSession = new Session();
        newSession.setSessionName(sessionRequest.sessionNameRq());
        newSession.setSessionDate(sessionRequest.sessionDateRq());
        newSession.setFkUser(host);
        return sessionRepository.save(newSession);
    }

    @Transactional
    public void updateSession(Integer sessionId, SessionRequest sessionRequest) {
        Session existingSession = sessionRepository.findById(sessionId)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.SESSION_RNF));

        User host = userRepository.findById(sessionRequest.fkUserRq())
            .orElseThrow(() -> new EntityNotFoundException(ErrorMessageRequests.USER_NULL));
        
        existingSession.setSessionName(sessionRequest.sessionNameRq());
        existingSession.setSessionDate(sessionRequest.sessionDateRq());
        existingSession.setFkUser(host);
        sessionRepository.save(existingSession);
    }

    @Transactional
    public void deleteSession(Integer sessionId) {
        if (sessionRepository.existsById(sessionId)) {
            sessionRepository.deleteById(sessionId);
        }  
    }

    @Transactional
    public List<Session> getSessionsByHost(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException(ErrorMessageRNF.USER_RNF);
        }
        return sessionRepository.findByFkUser_UserIdOrderBySessionDateDesc(userId);
    }

}