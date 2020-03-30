package com.mai.projects.smarthome.controller.rest.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Measurement {
    @NotEmpty
    private List<DeviceValue> deviceValues;
    @NotNull
    private LocalDateTime localDateTime;
}
