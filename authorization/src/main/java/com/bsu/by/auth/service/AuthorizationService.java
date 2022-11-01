package com.bsu.by.auth.service;

import com.bsu.by.auth.dto.request.EmailAndPasswordDto;
import com.bsu.by.auth.dto.response.success.TokensAndUserIdDto;
import com.bsu.by.auth.exception.unauthorized.IncorrectPasswordException;
import com.bsu.by.auth.model.User;
import com.bsu.by.auth.util.ResponseUtil;
import com.bsu.by.auth.util.UserUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorizationService {
    private final UserUtil userUtil;
    private final TokenService tokenService;
    private final ResponseUtil responseUtil;

    @Transactional
    public TokensAndUserIdDto loginWithEmailAndPassword(EmailAndPasswordDto emailAndPasswordDto) {
        User user = userUtil.findUserByEmail(emailAndPasswordDto.getEmail());
        userUtil.checkUserRights(user);

        boolean validPassword = new BCryptPasswordEncoder().matches(emailAndPasswordDto.getPassword(), user.getPassword());
        if (validPassword) {
            Pair<String, String> tokens = tokenService.generateAccessAndRefreshTokens(user);
            return responseUtil.createTokensAndUserIdDto(tokens, user.getId());
        } else {
            log.error("Incorrect password for user with id='{}'", user.getId());
            throw new IncorrectPasswordException();
        }
    }
}
