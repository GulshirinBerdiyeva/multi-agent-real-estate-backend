package com.bsu.by.auth.controller;

import com.bsu.by.auth.dto.request.EmailAndPasswordDto;
import com.bsu.by.auth.dto.request.RefreshTokenDto;
import com.bsu.by.auth.dto.response.error.GeneralErrorTypeErrorResponse;
import com.bsu.by.auth.dto.response.error.GeneralMessageErrorResponse;
import com.bsu.by.auth.dto.response.success.SuccessResponse;
import com.bsu.by.auth.dto.response.success.TokensAndUserIdDto;
import com.bsu.by.auth.dto.response.success.TokensResponse;
import com.bsu.by.auth.service.AuthorizationService;
import com.bsu.by.auth.service.TokenService;
import com.bsu.by.auth.util.DocumentationUtil;
import com.bsu.by.auth.util.ResponseUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Authorized successfully",
                    content = @Content(schema = @Schema(implementation = TokensResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid user values",
                    content = @Content(schema = @Schema(implementation = GeneralMessageErrorResponse.class),
                            examples ={ @ExampleObject(name = "Email" , value = DocumentationUtil.EMAIL_BAD_REQUEST),
                                    @ExampleObject(name = "Password" , value = DocumentationUtil.PASSWORD_BAD_REQUEST) })),
            @ApiResponse(responseCode = "401", description = "Incorrect user password",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.INCORRECT_PASSWORD))),
            @ApiResponse(responseCode = "403", description = "Access denied exception",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.NOT_ENOUGH_RIGHTS))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples ={ @ExampleObject(name = "User" , value = DocumentationUtil.USER_NOT_FOUND),
                                    @ExampleObject(name = "Role" , value = DocumentationUtil.ROLE_NOT_FOUND) }))
    })
    public TokensResponse login(@Valid @RequestBody EmailAndPasswordDto emailAndPasswordDto) {
        TokensAndUserIdDto tokensAndUserIdDto = authorizationService.loginWithEmailAndPassword(emailAndPasswordDto);
        return responseUtil.createTokensResponse(tokensAndUserIdDto);
    }

    @PostMapping("/refresh")
    @Operation(summary = "Generate new access and refresh tokens")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Hold new tokens",
                    content = @Content(schema = @Schema(implementation = TokensResponse.class))),
            @ApiResponse(responseCode = "400", description = "Refresh token couldn't be empty",
                    content = @Content(schema = @Schema(implementation = GeneralMessageErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.REFRESH_TOKEN_REQUIRED))),
            @ApiResponse(responseCode = "401", description = "Expired or Invalid token",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = {@ExampleObject(name = "Expired token" , value = DocumentationUtil.EXPIRED_TOKEN),
                                    @ExampleObject(name = "Invalid token" , value = DocumentationUtil.INVALID_TOKEN)})),
            @ApiResponse(responseCode = "403", description = "Access denied exception",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.NOT_ENOUGH_RIGHTS))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples ={@ExampleObject(name = "User" , value = DocumentationUtil.USER_NOT_FOUND),
                                    @ExampleObject(name = "Role" , value = DocumentationUtil.ROLE_NOT_FOUND)})),
            @ApiResponse(responseCode = "409", description = "Refresh token with no session",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.REFRESH_TOKEN_WITH_NO_SESSIONS)))
    })
    public TokensResponse refreshToken(@Valid @RequestBody RefreshTokenDto refreshTokenDto) {
        String oldRefreshToken = refreshTokenDto.getRefreshToken();
        TokensAndUserIdDto tokensAndUserIdDto = tokenService.generateAccessAndRefreshTokens(oldRefreshToken);
        tokenService.deleteRefreshToken(oldRefreshToken);
        return responseUtil.createTokensResponse(tokensAndUserIdDto);
    }

    @PostMapping("/logout")
    @Operation(summary = "Logout and delete refresh token")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Refresh token deleted successfully",
                    content = @Content(schema = @Schema(implementation = SuccessResponse.class))),
            @ApiResponse(responseCode = "400", description = "Refresh token couldn't be empty",
                    content = @Content(schema = @Schema(implementation = GeneralMessageErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.REFRESH_TOKEN_REQUIRED))),
            @ApiResponse(responseCode = "401", description = "Expired or Invalid token",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = {@ExampleObject(name = "Expired token" , value = DocumentationUtil.EXPIRED_TOKEN),
                                    @ExampleObject(name = "Invalid token" , value = DocumentationUtil.INVALID_TOKEN)})),
            @ApiResponse(responseCode = "403", description = "Access denied exception",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.NOT_ENOUGH_RIGHTS))),
            @ApiResponse(responseCode = "404", description = "Not found",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples ={ @ExampleObject(name = "User" , value = DocumentationUtil.USER_NOT_FOUND),
                                    @ExampleObject(name = "Role" , value = DocumentationUtil.ROLE_NOT_FOUND) })),
            @ApiResponse(responseCode = "409", description = "Refresh token with no session",
                    content = @Content(schema = @Schema(implementation = GeneralErrorTypeErrorResponse.class),
                            examples = @ExampleObject(DocumentationUtil.REFRESH_TOKEN_WITH_NO_SESSIONS)))
    })
    public SuccessResponse logout(@Valid @RequestBody RefreshTokenDto refreshTokenDto) {
        tokenService.deleteRefreshToken(refreshTokenDto.getRefreshToken());
        return SuccessResponse.getGeneric();
    }
}