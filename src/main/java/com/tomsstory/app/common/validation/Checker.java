package com.tomsstory.app.common.validation;


import com.tomsstory.app.common.exception.custom.ValidationException;
import org.springframework.util.StringUtils;

import java.util.function.Predicate;

public class Checker<T> {
    private Predicate<T> condition;
    static String defaultSuffixMessage = "Validation Error";
    private String customizeSuffixMessage;
    public Checker(Predicate<T> condition) {
        this.condition = condition;
    }

    public Checker(Predicate<T> condition,String  customizeSuffixMessage) {
        this.condition = condition;
        this.customizeSuffixMessage = customizeSuffixMessage;
    }

    public void test(T t){
        if (condition.test(t)) throw new ValidationException(this.defaultSuffixMessage);
    }
    public void test(T t,RuntimeException ex){
        if (condition.test(t)) throw ex;
    }
    public void test(T t,String message){
        if (condition.test(t)) throw new ValidationException (message+" ::"+this.customizeSuffixMessage);
    }

    public static void throwValidationException(String message){
        throw new ValidationException(message);
    }
    public static void throwValidationException(){
        throw new ValidationException(defaultSuffixMessage);
    }
}
