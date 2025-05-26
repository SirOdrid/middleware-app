package com.tfg.backend.services.operations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.api.request.PackRequest;
import com.tfg.backend.data.ErrorMessages.ErrorMessageConflicts;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRNF;
import com.tfg.backend.exceptions.exceptions.ConflictException;
import com.tfg.backend.exceptions.exceptions.ResourceNotFoundException;
import com.tfg.backend.models.Pack;
import com.tfg.backend.models.User;
import com.tfg.backend.repository.PackRepository;
import com.tfg.backend.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class PackService {

    @Autowired
    private PackRepository packRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public Pack createPack(PackRequest packRequest) {

        if(packRepository.existsByPackNameAndFkUser_UserId(packRequest.packNameRq(), packRequest.fkUserRq())){
            throw new ConflictException(ErrorMessageConflicts.packNameByUserExists(packRequest.packNameRq()));
        }

        User user = userRepository.findById(packRequest.fkUserRq())
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));

        Pack newPack = new Pack();
        newPack.setFkUser(user);
        newPack.setPackName(packRequest.packNameRq());       
        return packRepository.save(newPack);
    }

    @Transactional
    public void deletePack(Integer packId) {
        if (packRepository.existsById(packId)) {
            packRepository.deleteById(packId);
        }      
    }

    public List<Pack> getUserPack(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new ResourceNotFoundException(ErrorMessageRNF.USER_RNF);
        }
        return packRepository.findByFkUser_UserId(userId);
    }
    
}
