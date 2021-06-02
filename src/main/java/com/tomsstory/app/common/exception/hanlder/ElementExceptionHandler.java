package com.tomsstory.app.common.exception.hanlder;


import com.tomsstory.app.common.exception.ErrorCode;
import com.tomsstory.app.common.exception.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.NoSuchElementException;

@ControllerAdvice
@Slf4j
public class ElementExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    protected ResponseEntity<ErrorResponse> handleNoSuchValuePresent(NoSuchElementException e, HttpServletRequest req) {

        final ErrorResponse response = ErrorResponse.of(ErrorCode.ENTITY_NOT_FOUND,req,e);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
