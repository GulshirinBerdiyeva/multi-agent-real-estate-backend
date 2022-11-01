package com.bsu.by.auth.dto.response.success;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {
    private String message;

    public static SuccessResponse getGeneric() {
        return new SuccessResponse("Operation completed successfully");
    }
}
