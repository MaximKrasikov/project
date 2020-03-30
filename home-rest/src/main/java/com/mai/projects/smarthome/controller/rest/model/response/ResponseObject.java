package com.mai.projects.smarthome.controller.rest.model.response;

import lombok.Data;

@Data
public class ResponseObject<T> {
    private ResponseHeader responseHeader;
    private T responseBody;
}
