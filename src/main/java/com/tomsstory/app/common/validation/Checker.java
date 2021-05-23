package com.tomsstory.app.common.validation;


import com.tomsstory.app.common.exception.custom.ValidationException;

import java.util.function.Predicate;

public class Checker<T> {
    private Predicate<T> condition;

    public Checker(Predicate<T> condition) {
        this.condition = condition;
    }

    public void test(T t){
        if (condition.test(t)) throw new ValidationException("Validation Error");
    }
    public void test(T t,RuntimeException ex){
        if (condition.test(t)) throw ex;
    }
    public void test(T t,String message){
        if (condition.test(t)) throw new ValidationException (message);
    }
}
