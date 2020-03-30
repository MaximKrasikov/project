package com.mai.projects.smarthome.controller.rest.model.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class RecordDataRequest {
    @NotEmpty
    private List<Measurement> deviceMeasuring;
}
