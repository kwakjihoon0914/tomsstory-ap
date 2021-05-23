package com.tomsstory.app.common.exception.hanlder;

import com.tomsstory.app.common.exception.ErrorCode;
import com.tomsstory.app.common.exception.ErrorResponse;
import com.tomsstory.app.common.exception.custom.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@ControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(com.tomsstory.app.common.exception.custom.ValidationException.class)
    protected ResponseEntity<ErrorResponse> handleCustomValidationException(com.tomsstory.app.common.exception.custom.ValidationException e, HttpServletRequest req) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.VALIDATION_ERROR,e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(javax.xml.bind.ValidationException.class)
    protected ResponseEntity<ErrorResponse> handleValidationException(com.tomsstory.app.common.exception.custom.ValidationException e, HttpServletRequest req) {
        ErrorResponse response = ErrorResponse.of(ErrorCode.VALIDATION_ERROR,e);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
