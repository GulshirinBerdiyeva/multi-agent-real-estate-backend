package com.bsu.by.customer.agent.dto.response.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralErrorTypeErrorResponse {
    private Instant dateTime;

    private ErrorType errorType;

    public enum ErrorType {
        NOT_ENOUGH_RIGHTS,
        FILE_NOT_FOUND,
        USER_NOT_FOUND,
        ESTATE_NOT_FOUND,
        EXPIRED_TOKEN,
        INVALID_TOKEN,
        UNSUPPORTED_MEDIA_TYPE,
        UNACCEPTABLE_MEDIA_TYPE
    }
}
