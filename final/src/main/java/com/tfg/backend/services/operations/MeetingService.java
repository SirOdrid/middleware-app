package com.tfg.backend.services.operations;

import java.sql.Time;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.api.request.MeetingRequest;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRNF;
import com.tfg.backend.exceptions.exceptions.ResourceNotFoundException;
import com.tfg.backend.models.Boardgame;
import com.tfg.backend.models.Meeting;
import com.tfg.backend.models.Session;
import com.tfg.backend.repository.BoardgameRepository;
import com.tfg.backend.repository.MeetingRepository;
import com.tfg.backend.repository.SessionRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private BoardgameRepository boardgameRepository;

    @Transactional
    public void createMeeting(MeetingRequest meetingRequest) {
        Session session = sessionRepository.findById(meetingRequest.FkSessionRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.SESSION_RNF));
        
        Boardgame boardgame = boardgameRepository.findById(meetingRequest.FkBoardgameRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.BOARDGAME_RNF));

        Meeting meeting = new Meeting();
        meeting.setFkSession(session);
        meeting.setFkBoardgame(boardgame);
        meeting.setMeetingDuration(Time.valueOf(meetingRequest.meetingDurationRq()));        
        meetingRepository.save(meeting);
    }

    @Transactional
    public void deleteMeeting(Integer meetingId) {
        if(meetingRepository.existsById(meetingId)){
            meetingRepository.deleteById(meetingId);
        }
    }

    @Transactional
    public List<Meeting> getMeetingBySession(Integer sessionId) {
        sessionRepository.findById(sessionId)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.SESSION_RNF));                  
        return meetingRepository.findByFkSession_SessionId(sessionId);
    }

    @Transactional
    public List<Meeting> getMeetingByUser(Integer userId) {                 
        return meetingRepository.findByFkSessionFkUserUserId(userId);
    }
    
}
