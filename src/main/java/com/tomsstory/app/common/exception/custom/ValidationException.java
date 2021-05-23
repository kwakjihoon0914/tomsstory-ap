package com.tomsstory.app.common.exception.custom;

public class ValidationException extends RuntimeException{

    public ValidationException(String message){
        super(message);
    }
}
