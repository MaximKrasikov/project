package com.mai.projects.smarthome.controller.rest.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UpdateDeviceTypeRequest {

    @NotNull
    private Long id;

    @NotBlank
    private String title;

    @NotBlank
    private String unitName;
}
