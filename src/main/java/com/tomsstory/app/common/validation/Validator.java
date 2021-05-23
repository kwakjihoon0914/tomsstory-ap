package com.tomsstory.app.common.validation;

import org.hibernate.annotations.Check;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Predicate;

public class Validator {
    final public static Checker<Object> isNull =  new Checker<>(Objects::isNull);
    final public static Checker<Object> isNotNull =  new Checker<>( (o) -> !Objects.isNull(o));

    final public static Checker<Boolean> isNegative = new Checker<>((f) -> !f);
    final public static Checker<Boolean> isPositive = new Checker<>((f) -> f);

    final public static Checker<LocalDateTime> isPassedTime = new Checker<>((t)->LocalDateTime.now().compareTo(t) > 0);
    final public static Checker<LocalDateTime> isNotPassedTime = new Checker<>((t)->LocalDateTime.now().compareTo(t) < 0);

    final public static Checker<Object> equals = new Checker<>(o->o.equals(o));
    final public static Checker<Object> notEquals = new Checker<>(o->!o.equals(o));


}
