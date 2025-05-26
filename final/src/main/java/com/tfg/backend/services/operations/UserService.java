package com.tfg.backend.services.operations;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfg.backend.api.request.UserLoginRequest;
import com.tfg.backend.api.request.UserRecoveryRequest;
import com.tfg.backend.api.request.UserRequest;
import com.tfg.backend.data.NotificationMessages;
import com.tfg.backend.data.ErrorMessages.ErrorMessageConflicts;
import com.tfg.backend.data.ErrorMessages.ErrorMessageOperations;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRNF;
import com.tfg.backend.exceptions.exceptions.ConflictException;
import com.tfg.backend.exceptions.exceptions.ResourceNotFoundException;
import com.tfg.backend.models.Country;
import com.tfg.backend.models.User;
import com.tfg.backend.models.UserType;
import com.tfg.backend.repository.UserRepository;
import com.tfg.backend.services.external.EmailSenderService;
import com.tfg.backend.services.external.PasswordRecoveryService;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private UserTypeService userTypeService;


// OPERATIONS \

    // REGISTRY
    public User createUser(UserRequest userRequest) {
        validateUniqueValues(-1,userRequest);
        User user = mapToUser(userRequest);
        return userRepository.save(user);
    }
   
    // LOGIN
    public User checkLogin(UserLoginRequest userLoginRequest) {
        User user = userRepository.findByEmail(userLoginRequest.userEmailRq())
            .orElseThrow(() -> new ConflictException(ErrorMessageOperations.FAIL_LOGIN));
        if (!(user.getPassHash().equals(userLoginRequest.passHashRq()))){
            throw new ConflictException(ErrorMessageOperations.FAIL_LOGIN);
        }
        return user;
    }
    
    // ACCOUNT EDIT
    public User updateUser(Integer id, UserRequest userRequest) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
        validateUniqueValues(id, userRequest);
        return userRepository.save(mapToUser(user, userRequest));
    }

    // RECOVERY PASSWORD
    public void recoveryCredentials(UserRecoveryRequest userRecoveryRequest) {
        User user = userRepository.findByEmail(userRecoveryRequest.emailRecoveryRq())
                .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_MAIL_RNF));
        String passwordGenerated = PasswordRecoveryService.generatePassword();
        EmailSenderService.sendEmail(userRecoveryRequest.emailRecoveryRq(), NotificationMessages.EMAIL_RECOVERY_SUBJECT,
                NotificationMessages.generateRecoveryMessage(user.getUserName(), passwordGenerated));
        user.setPassHash(passwordGenerated);
        userRepository.save(user);
    }   

// SIMPLE SERVICES \

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User getUserById(Integer id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException(ErrorMessageRNF.USER_RNF));
        return user;
    }

    // Delete User by ID
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public List<User> getUsersByUserType(Integer userTypeId) {
        UserType userType = userTypeService.getUserType(userTypeId);
        return userRepository.findByFkUserType(userType);
    }
    
// UTILITIES \

    // Modifies and returns a new user with the values ​​of the request passed as a parameter
    private User mapToUser(UserRequest userRequest){
        User user = new User();
        return mapToUser(user, userRequest);
    }

    // Modifies and returns the user passed as parameter with the values ​​of the request passed as parameter
    private User mapToUser(User user, UserRequest userRequest){
        Country country = countryService.getCountry(userRequest.fkCountryNameRq());
        UserType userType = userTypeService.getUserType(userRequest.fkUserTypeNameRq());
        user.setUserName(userRequest.userNameRq());
        user.setPassHash(userRequest.passHashRq());
        user.setEmail(userRequest.emailRq());
        user.setCreationDate(new Date(userRequest.creationDateRq()));
        user.setProfileImage(userRequest.profileImageRq());
        user.setPhoneNumber(userRequest.phoneNumberRq());
        user.setEmailNotifications(userRequest.emailNotificationsRq());
        user.setFkCountry(country);
        user.setFkUserType(userType);
        return user;
    }

    // Validates that the username and email values are unique in the database
    // param ID - Pass -1 if it needs to be null
    private void validateUniqueValues(int id, UserRequest userRequest) {
        // Validate unique username
        userRepository.findByUserName(userRequest.userNameRq()).ifPresent(user -> {
            if (user.getUserId() != id || id == -1) { // Only throw exception if ID doesn't match or if ID is null
                throw new ConflictException(ErrorMessageConflicts.userNameExists(userRequest.userNameRq()));
            }
        });

        // Validate unique email
        userRepository.findByEmail(userRequest.emailRq()).ifPresent(user -> {
            if (user.getUserId() != id || id == -1) { // Only throw exception if ID doesn't match or if ID is null
                throw new ConflictException(ErrorMessageConflicts.emailExists(userRequest.emailRq()));
            }
        });
    }

    public List<User> searchUserByName(String name_user) {  
        return userRepository.findByUserNameContainingIgnoreCase(name_user);
    }
}