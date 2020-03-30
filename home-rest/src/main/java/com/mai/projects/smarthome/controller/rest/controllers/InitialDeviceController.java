package com.mai.projects.smarthome.controller.rest.controllers;

import com.mai.projects.smarthome.controller.rest.model.request.InitialDeviceRequest;
import com.mai.projects.smarthome.controller.rest.model.request.RecordDataRequest;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Validated
@Api
@RequestMapping(path="/device",produces = MediaType.APPLICATION_JSON_VALUE)
public interface InitialDeviceController {
    @PostMapping(path="/record/initial/state")
    ResponseEntity recordInitialState(@Valid @RequestBody InitialDeviceRequest initialDeviceRequest,HttpServletRequest httpServletRequest);

    @PostMapping(path="/record/data")
    ResponseEntity recordData(@Valid @RequestBody RecordDataRequest recordDataRequest, HttpServletRequest httpServletRequest);

}
