package com.tfg.backend.api.request;
import jakarta.validation.constraints.*;
import java.util.Date;

import com.tfg.backend.data.ErrorMessages.ErrorMessageRequests;

public record LoanRequest(

    @PastOrPresent(message = ErrorMessageRequests.LOAN_DATE_NOT_VALID)
    Date loanDateRq,
    
    @NotNull(message = ErrorMessageRequests.LOAN_EXPIRATION_DATE_NULL)
    // @FutureOrPresent(message = ErrorMessageRequests.LOAN_EXPIRATION_DATE_NOT_VALID)
    Date expirationDateRq,
    
    @NotNull(message = ErrorMessageRequests.USER_NULL)
    Integer fkUserRq,
    
    @NotNull(message = ErrorMessageRequests.STOCK_NULL)
    Integer fkStockRq,
    
    @NotNull(message = ErrorMessageRequests.LOAN_STATE_NULL)
    Integer fkLoanStateRq
) {}