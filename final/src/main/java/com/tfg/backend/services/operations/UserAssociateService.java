package com.tfg.backend.services.operations;

import com.tfg.backend.api.request.UserAssociateRequest;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRNF;
import com.tfg.backend.exceptions.exceptions.ResourceNotFoundException;
import com.tfg.backend.models.User;
import com.tfg.backend.models.UserAssociate;
import com.tfg.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAssociateService {

    @Autowired
    private UserAssociateRepository userAssociateRepository;

    @Autowired
    private UserRepository userRepository;

    public UserAssociate addAssociation(UserAssociateRequest request) {
        User hostUser = userRepository.findById(request.fkHostUserId())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
        
        User associatedUser = userRepository.findById(request.fkAssociatedUserId())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));

        if(!userAssociateRepository.existsByFkHostUserAndFkAssociatedUser(hostUser, associatedUser)){
            UserAssociate association = new UserAssociate();
            association.setFkHostUser(hostUser);
            association.setFkAssociatedUser(associatedUser);
            association.setAssociationDate(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            return userAssociateRepository.save(association);
        }else{
            return userAssociateRepository.findByFkHostUserAndFkAssociatedUser(hostUser, associatedUser).get();
        } 
        
    }

    public void deleteAssociation(Integer associationId) {
        if (userAssociateRepository.existsById(associationId)) {
            userAssociateRepository.deleteById(associationId);
        }
    }

    public List<UserAssociate> getAllAssociationsByHostUser(Integer hostUserId) {
        User hostUser = userRepository.findById(hostUserId)
        .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
    
        return userAssociateRepository.findByFkHostUser(hostUser);
    }

    public List<UserAssociate> getAllAssociationsByAssociatedUser(Integer associatedUserId) {
        User associatedUser = userRepository.findById(associatedUserId)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
        
        List<UserAssociate> associations = userAssociateRepository.findByFkAssociatedUser(associatedUser);   
        return associations;
    }
}
