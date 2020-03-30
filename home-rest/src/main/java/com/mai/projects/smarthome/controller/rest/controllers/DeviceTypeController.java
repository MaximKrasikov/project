package com.mai.projects.smarthome.controller.rest.controllers;

import com.mai.projects.smarthome.controller.rest.model.request.AddDeviceTypeRequest;
import com.mai.projects.smarthome.controller.rest.model.request.UpdateDeviceTypeRequest;
import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated
@Api
@RequestMapping(path="/device",produces = MediaType.APPLICATION_JSON_VALUE)
public interface DeviceTypeController {
    @PostMapping("/add")
    ResponseEntity addDeviceType(@Valid @RequestBody AddDeviceTypeRequest addDeviceTypeRequest);

    @PostMapping("/update")
    ResponseEntity updateDeviceType(@Valid @RequestBody UpdateDeviceTypeRequest updateDeviceTypeRequest);

    @PostMapping("/delete/{id}")
    ResponseEntity deleteDeviceType(@NotNull @PathVariable Long deviceTypeId);

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity fetchDeviceType(@NotNull @PathVariable Long deviceTypeId);
}
