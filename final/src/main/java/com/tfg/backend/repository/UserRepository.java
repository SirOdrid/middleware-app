package com.tfg.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.backend.models.User;
import com.tfg.backend.models.UserType;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUserName(String userName);
    Optional<User> findByUserNameIgnoreCase(String userName);
    List<User> findByUserNameIgnoreCaseStartingWith(String userName);
    List<User> findByFkUserType(UserType userType);
    List<User> findByUserNameContainingIgnoreCase(String userName);
    Optional<User> findByEmail(String email);
    
}