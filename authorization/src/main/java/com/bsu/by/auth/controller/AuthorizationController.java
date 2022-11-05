package com.bsu.by.auth.controller;

import com.bsu.by.auth.dto.request.EmailAndPasswordDto;
import com.bsu.by.auth.dto.request.RefreshTokenDto;
import com.bsu.by.auth.dto.response.success.SuccessResponse;
import com.bsu.by.auth.dto.response.success.TokensAndUserIdDto;
import com.bsu.by.auth.dto.response.success.TokensResponse;
import com.bsu.by.auth.service.AuthorizationService;
import com.bsu.by.auth.service.TokenService;
import com.bsu.by.auth.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authorization")
@Slf4j
public class AuthorizationController {
    private final AuthorizationService authorizationService;
    private final TokenService tokenService;
    private final ResponseUtil responseUtil;

    @PostMapping("/login")
    @Operation(summary = "Login with email and password then take an access tokens")
    public TokensResponse login(@Valid @RequestBody EmailAndPasswordDto emailAndPasswordDto) {
        TokensAndUserIdDto tokensAndUserIdDto = authorizationService.loginWithEmailAndPassword(emailAndPasswordDto);
        return responseUtil.createTokensResponse(tokensAndUserIdDto);
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout and delete refresh token")
    public SuccessResponse logout(@Valid @RequestBody RefreshTokenDto refreshTokenDto) {
        tokenService.deleteRefreshToken(refreshTokenDto.getRefreshToken());
        return SuccessResponse.getGeneric();
    }
}