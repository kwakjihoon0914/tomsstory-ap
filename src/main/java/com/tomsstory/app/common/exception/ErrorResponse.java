package com.tomsstory.app.common.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ErrorResponse {

    private String message;
    private String detail;
    private String url;
    private int status;
    private String code;


    private ErrorResponse(final ErrorCode code) {
        this.message = code.getMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
    }
    private ErrorResponse(final ErrorCode code,Exception e) {
        this.message = code.getMessage();
        this.detail = e.getLocalizedMessage();
        this.status = code.getStatus();
        this.code = code.getCode();
    }
    public static ErrorResponse of(final ErrorCode code){
        return new ErrorResponse(code);
    }
    public static ErrorResponse of(final ErrorCode code,Exception e) {
        return new ErrorResponse(code,e);
    }



}
