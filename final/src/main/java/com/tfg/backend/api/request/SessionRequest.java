package com.tfg.backend.api.request;

import java.sql.Date;
import java.util.List;

import com.tfg.backend.config.DataBaseConfig;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRequests;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SessionRequest (
    @NotBlank(message = ErrorMessageRequests.SESSION_NAME_NULL)
    @Size(  min = DataBaseConfig.SESSION_NAME_MIN_CHARACTERS, 
            max = DataBaseConfig.SESSION_NAME_MAX_CHARACTERS, 
            message = ErrorMessageRequests.SESSION_NAME_SIZE)
    String sessionNameRq,
    
    @NotNull(message = ErrorMessageRequests.SESSION_DATE_NULL)
    // @FutureOrPresent(message = ErrorMessageRequests.FUTURE_OR_PRESENT_DATE)
    Date sessionDateRq,
    
    @NotNull(message = ErrorMessageRequests.USER_NULL)
    Integer fkUserRq,

    List<@Positive(message = ErrorMessageRequests.USER_NOT_VALID) Integer> playerIdsRq
) {}
