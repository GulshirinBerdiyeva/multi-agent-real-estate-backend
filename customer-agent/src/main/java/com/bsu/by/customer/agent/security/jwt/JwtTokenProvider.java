package com.bsu.by.customer.agent.security.jwt;

import com.bsu.by.customer.agent.exception.unauthorized.InvalidTokenException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider {
    private final JwtUserDetailsService jwtUserDetailsService;

    public Authentication getAuthentication(String token) throws InvalidTokenException {
        CustomUser userDetails = jwtUserDetailsService.loadUserByUsername(token);
        return new UsernamePasswordAuthenticationToken(userDetails, token, userDetails.getAuthorities());
    }
}
