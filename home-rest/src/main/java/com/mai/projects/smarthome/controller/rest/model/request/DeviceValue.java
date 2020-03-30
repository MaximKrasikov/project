package com.mai.projects.smarthome.controller.rest.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DeviceValue {
    @NotNull
    Double value;
    @NotNull
    Integer homeDeviceId;
}
