package com.tomsstory.app.common.validation;


import com.tomsstory.app.common.exception.custom.ValidationException;
import org.springframework.util.StringUtils;

import java.util.function.Predicate;

public class Checker<T> {
    private Predicate<T> condition;
    private String defaultSuffixMessage;

    public Checker(Predicate<T> condition) {
        this.condition = condition;
        this.defaultSuffixMessage = "Validation Error";
    }

    public Checker(Predicate<T> condition,String  defaultSuffixMessage) {
        this.condition = condition;
    }

    public void test(T t){
        if (condition.test(t)) throw new ValidationException(this.defaultSuffixMessage);
    }
    public void test(T t,RuntimeException ex){
        if (condition.test(t)) throw ex;
    }
    public void test(T t,String message){
        if (condition.test(t)) throw new ValidationException (message+" ::"+this.defaultSuffixMessage);
    }
}
