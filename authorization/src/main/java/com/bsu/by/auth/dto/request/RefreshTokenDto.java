package com.bsu.by.auth.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenDto {
    @NotBlank(message = "Refresh token is required")
    @Schema(example = "example")
    private String refreshToken;
}