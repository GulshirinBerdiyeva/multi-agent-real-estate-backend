package com.bsu.by.auth.util;

import com.bsu.by.auth.model.Role;
import com.bsu.by.auth.exception.notfound.RoleNotFoundException;
import com.bsu.by.auth.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class RoleUtil {
    private final RoleRepository roleRepository;

    public Role findRoleById(String roleId) {
        return roleRepository.findById(roleId)
                .orElseThrow(() -> {
                    log.error("Role with id='{}' not found", roleId);
                    throw new RoleNotFoundException(roleId);
                });
    }
}
