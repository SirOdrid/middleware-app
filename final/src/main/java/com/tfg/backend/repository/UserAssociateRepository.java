package com.tfg.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tfg.backend.models.User;
import com.tfg.backend.models.UserAssociate;

@Repository
public interface UserAssociateRepository extends JpaRepository<UserAssociate, Integer> {
    List<UserAssociate> findByFkHostUser(User hostUser);
    List<UserAssociate> findByFkAssociatedUser(User associatedUser);
    boolean existsByFkHostUserAndFkAssociatedUser(User hostUser, User associatedUser);
    Optional<UserAssociate> findByFkHostUserAndFkAssociatedUser(User hostUser, User associatedUser);
}
