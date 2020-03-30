package com.mai.projects.smarthome.controller.rest.controllers;


import com.mai.projects.smarthome.controller.rest.model.request.InitialDeviceRequest;
import com.mai.projects.smarthome.controller.rest.model.request.RegistrationRequest;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@Api
@RequestMapping(path="/api/v1/registration",produces = MediaType.APPLICATION_JSON_VALUE)
public interface RegistrationController {

    @PostMapping()
    ResponseEntity registration(@Valid @RequestBody RegistrationRequest registrationRequest);
}
