package com.tfg.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.backend.models.Meeting;
import com.tfg.backend.models.Session;

import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

    List<Meeting> findByFkSession_SessionId(Integer sessionId);
    
    List<Meeting> findByFkSessionFkUserUserId(Integer userId);

}
