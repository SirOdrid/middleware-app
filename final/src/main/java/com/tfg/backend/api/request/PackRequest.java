package com.tfg.backend.api.request;

import com.tfg.backend.config.DataBaseConfig;
import com.tfg.backend.data.ErrorMessages.ErrorMessageRequests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PackRequest (

    @NotNull(message = ErrorMessageRequests.USER_NULL)
    Integer fkUserRq,

    @NotBlank(message = ErrorMessageRequests.PACK_NAME_NULL)
    @Size(  min = DataBaseConfig.PACK_NAME_MIN_CHARACTERS,  
            message = ErrorMessageRequests.PACK_NAME_SIZE)
    String packNameRq
){}
