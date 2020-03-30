package com.mai.projects.smarthome.controller.rest.controllers.advice.exception.handler;

import com.mai.projects.smarthome.controller.rest.exception.ServerException;
import com.mai.projects.smarthome.controller.rest.model.response.ResponseObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public interface ControllerAdviceExceptionHandler {
    @ExceptionHandler(ServerException.class)
    @ResponseBody
    <T> ResponseEntity<ResponseObject<Object>> catchServerException(ServerException ex);
}
