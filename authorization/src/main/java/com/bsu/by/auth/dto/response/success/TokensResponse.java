package com.bsu.by.auth.dto.response.success;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokensResponse {
    @Schema(example = "example")
    private String accessToken;

    @Schema(example = "Bearer", description = "Always 'Bearer'")
    private String tokenType;

    @Schema(example = "1h", description = "Access token expiration time is 1 hours. BTW, refresh token for 8 hours")
    private Integer expirationTime;

    @Schema(example = "example")
    private String refreshToken;

    @Schema(example = "user-id")
    private String userId;
}
