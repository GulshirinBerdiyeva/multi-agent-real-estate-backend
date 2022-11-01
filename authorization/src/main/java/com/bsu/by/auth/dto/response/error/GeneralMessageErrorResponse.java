package com.bsu.by.auth.dto.response.error;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralMessageErrorResponse {
    @Schema(example = "2022-11-02T23:07:59.441143700Z")
    private Instant dateTime;

    @Schema(example = "Operation completed unsuccessfully")
    private String message;
}
