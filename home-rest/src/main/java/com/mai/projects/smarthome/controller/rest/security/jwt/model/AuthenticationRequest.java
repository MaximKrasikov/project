package com.mai.projects.smarthome.controller.rest.security.jwt.model;

import lombok.Data;

@Data
public class AuthenticationRequest {
    private String username;
    private String password;
}