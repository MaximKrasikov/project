package com.mai.projects.smarthome.controller.rest.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class InitialDeviceRequest {
    @NotEmpty
    private List<DeviceInfo> deviceInfos;
}
