package com.mai.projects.smarthome.controller.rest.controllers;

import com.mai.projects.smarthome.controller.rest.entities.User;
import com.mai.projects.smarthome.controller.rest.model.response.ResponseObject;
import com.mai.projects.smarthome.controller.rest.model.response.TokenResponse;
import com.mai.projects.smarthome.controller.rest.security.jwt.JwtTokenProvider;
import com.mai.projects.smarthome.controller.rest.security.jwt.model.AuthenticationRequest;
import com.mai.projects.smarthome.controller.rest.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth/",produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AuthenticationRestControllerV1 extends AbstractMainController {
    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @PostMapping("login")
    @ResponseBody
    public ResponseEntity<ResponseObject<TokenResponse>> login(@RequestBody AuthenticationRequest requestDto) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByUserName(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());

            TokenResponse tokenResponse =new TokenResponse();
            tokenResponse.setToken(token);

            return prepareResponseEntity(tokenResponse);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username or password");
        }
    }

}
