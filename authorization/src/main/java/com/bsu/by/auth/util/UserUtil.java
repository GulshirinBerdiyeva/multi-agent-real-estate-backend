package com.bsu.by.auth.util;

import com.bsu.by.auth.exception.notfound.UserNotFoundException;
import com.bsu.by.auth.model.Role;
import com.bsu.by.auth.model.User;
import com.bsu.by.auth.repository.UserRepository;
import com.bsu.by.auth.security.AuthorityType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserUtil {
    private final UserRepository userRepository;
    private final RoleUtil roleUtil;

    public User findUserById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> {
                    log.error("User with id='{}' not found", userId);
                    throw new UserNotFoundException(userId);
                });
    }

    public void checkUserRights(User user) {
        Role role = roleUtil.findRoleById(user.getRoleId());
        if (Arrays.stream(role.getAuthorities()).noneMatch(AuthorityType.AUTHORIZATION::equals)) {
            log.info("User with id='{}' hasn't got enough rights for authorization", user.getId());
            throw new AccessDeniedException(
                    String.format("User with id='%s' hasn't got enough rights for authorization", user.getId()));
        }
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> {
                    log.error("User with email='{}' not found", email);
                    throw new UserNotFoundException(email, true);
                });
    }
}
