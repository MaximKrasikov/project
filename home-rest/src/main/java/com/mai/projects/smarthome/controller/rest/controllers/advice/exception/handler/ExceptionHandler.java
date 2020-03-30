package com.mai.projects.smarthome.controller.rest.controllers.advice.exception.handler;

import com.mai.projects.smarthome.controller.rest.controllers.AbstractMainController;
import com.mai.projects.smarthome.controller.rest.enums.ErrorEnum;
import com.mai.projects.smarthome.controller.rest.exception.ServerException;
import com.mai.projects.smarthome.controller.rest.model.response.ResponseHeader;
import com.mai.projects.smarthome.controller.rest.model.response.ResponseObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@ControllerAdvice
@Slf4j
public class ExceptionHandler extends AbstractMainController implements ControllerAdviceExceptionHandler{


    @Override
    public ResponseEntity<ResponseObject<Object>> catchServerException(ServerException ex) {
        ResponseHeader responseHeader= new ResponseHeader();
        ErrorEnum errorEnum = ex.getError();
        responseHeader.setResponseCode(errorEnum.getCode());
        responseHeader.setResponseDate(LocalDateTime.now());
        responseHeader.setResponseMessage(String.format(errorEnum.getMessage(), ex.getParams()));

        return prepareResponseEntity(responseHeader,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
