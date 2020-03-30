package com.mai.projects.smarthome.controller.rest.model.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class DeviceInfo {
    @NotNull
    Long homeDeviceId;
    @NotNull
    Long deviceTypeId;
}
