package com.tfg.backend.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tfg.backend.models.Session;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository<Session, Integer> {

    List<Session> findByFkUser_UserIdOrderBySessionDateDesc(Integer userId);

    List<Session> findBySessionDate(Date tomorrow);
}
