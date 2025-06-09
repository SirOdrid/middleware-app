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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tfg.backend.api.request.MeetingRequest;
import com.tfg.backend.config.ApiConfig;
import com.tfg.backend.models.Meeting;
import com.tfg.backend.services.operations.MeetingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(ApiConfig.ENDPOINT_BASE_MEETING)
@CrossOrigin(origins = ApiConfig.CROSS_ORIGIN)
public class MeetingController {
    
    private final MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    // Create Meeting
    @CrossOrigin
    @PostMapping(ApiConfig.ENDPOINT_MEETING_CREATE)
    public ResponseEntity<?> createMeeting(@Valid @RequestBody MeetingRequest meetingRequest) {
        meetingService.createMeeting(meetingRequest);       
        return new ResponseEntity<>(HttpStatus.CREATED);       
    }

    // Delete Meeting
    @CrossOrigin
    @DeleteMapping(ApiConfig.ENDPOINT_MEETING_DELETE)
    public ResponseEntity<?> deleteBoardgameToPack(@PathVariable(ApiConfig.PATH_MEETING_ID) Integer meetingId) {
        meetingService.deleteMeeting(meetingId);       
        return new ResponseEntity<>(HttpStatus.OK);       
    }

    // Get all Meetings to Session
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_MEETING_ALL_BY_SESSION)
    public ResponseEntity<List<Meeting>> getMeetingBySession(@PathVariable(ApiConfig.PATH_SESSION_ID) Integer sessionId) {
        List<Meeting> meetings = meetingService.getMeetingBySession(sessionId);
        return new ResponseEntity<>(meetings, HttpStatus.OK);
    }

    // Get all Meetings to User
    @CrossOrigin
    @GetMapping(ApiConfig.ENDPOINT_MEETING_ALL_BY_USER)
    public ResponseEntity<List<Meeting>> getMeetingByUser(@PathVariable(ApiConfig.PATH_USER_ID) Integer userId) {
        List<Meeting> meetings = meetingService.getMeetingByUser(userId);
        return new ResponseEntity<>(meetings, HttpStatus.OK);
    }
}
