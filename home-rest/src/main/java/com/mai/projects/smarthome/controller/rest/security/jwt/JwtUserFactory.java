package com.mai.projects.smarthome.controller.rest.security.jwt;

import com.mai.projects.smarthome.controller.rest.entities.Role;
import com.mai.projects.smarthome.controller.rest.entities.Status;
import com.mai.projects.smarthome.controller.rest.entities.User;
import com.mai.projects.smarthome.controller.rest.security.jwt.model.JwtUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public static JwtUser create(User user) {
        return JwtUser.builder()
                .email(user.getEmail())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .username(user.getUserName())
                .firstName(user.getFirstName())
                .authorities(mapToGrantedAuthorities(user.getRoles()))
                .enabled(user.getStatus().equals(Status.ACTIVE))
                .lastPasswordResetDate(user.getUpdated()).build();

    }
    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(role ->
                        new SimpleGrantedAuthority(role.getName())
                ).collect(Collectors.toList());
    }
}
