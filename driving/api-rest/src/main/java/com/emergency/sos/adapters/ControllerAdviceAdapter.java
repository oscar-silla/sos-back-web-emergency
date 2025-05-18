package com.emergency.sos.adapters;

import com.emergency.sos.application.exceptions.BadRequestException;
import com.emergency.sos.application.exceptions.ConflictException;
import openapi.emergency_sos.model.ErrorResponseType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviceAdapter {

  @ExceptionHandler(BadRequestException.class)
  protected ResponseEntity<ErrorResponseType> handleBadRequestException() {
    ErrorResponseType errorResponseType = new ErrorResponseType();
    errorResponseType.setCode(HttpStatus.BAD_REQUEST.value());
    errorResponseType.setMessage(HttpStatus.BAD_REQUEST.getReasonPhrase());
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseType);
  }

  @ExceptionHandler(ConflictException.class)
  protected ResponseEntity<ErrorResponseType> handleConflictException() {
    ErrorResponseType errorResponseType = new ErrorResponseType();
    errorResponseType.setCode(HttpStatus.CONFLICT.value());
    errorResponseType.setMessage(HttpStatus.CONFLICT.getReasonPhrase());
    return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponseType);
  }
}
