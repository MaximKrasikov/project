package com.mai.projects.smarthome.controller.rest.model.request;

import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

@Data
public class AddDeviceTypeRequest {
    @NotBlank
    private String title;

    @NotBlank
    private String unitName;
}
