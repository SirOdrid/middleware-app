package com.tfg.backend.api.request;

import java.sql.Date;

import com.tfg.backend.config.DataBaseConfig;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRequests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserRequest(
    @NotBlank(message = ErrorMessageRequests.USER_NAME_USER_NULL)
    @Size(  min = DataBaseConfig.USER_NAME_MIN_CHARACTERS, 
            max = DataBaseConfig.USER_NAME_MAX_CHARACTERS, 
            message = ErrorMessageRequests.USER_NAME_USER_SIZE)
    String userNameRq,

    @NotBlank(message = ErrorMessageRequests.USER_PASS_HASH_NULL)
    @Size(  max = DataBaseConfig.USER_PASS_HASH_MAX_CHARACTERS, 
            message = ErrorMessageRequests.USER_PASS_HASH_SIZE)
    String passHashRq,

    @NotBlank(message = ErrorMessageRequests.USER_EMAIL_NULL)
    @Size(  min = DataBaseConfig.USER_EMAIL_MIN_CHARACTERS, 
            max = DataBaseConfig.USER_EMAIL_MAX_CHARACTERS, 
            message = ErrorMessageRequests.USER_EMAIL_SIZE)
    @Email(message = ErrorMessageRequests.USER_EMAIL_VALID)
    String emailRq,
    
    String profileImageRq,

    Integer phoneNumberRq,

    @NotNull(message = ErrorMessageRequests.USER_EMAIL_NOTIFICATION_NULL)
    boolean emailNotificationsRq,

    @NotNull(message = ErrorMessageRequests.USER_CREATION_DATE_NULL)
    Date creationDateRq,

    @NotBlank(message = ErrorMessageRequests.USER_COUNTRY_NULL)
    String fkCountryNameRq,

    @NotBlank(message = ErrorMessageRequests.USER_TYPE_NULL)
    String fkUserTypeNameRq
) {}