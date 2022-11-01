package com.bsu.by.auth.dto.response.success;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TokensAndUserIdDto {
    private String accessToken;
    private String refreshToken;
    private String userId;
}
