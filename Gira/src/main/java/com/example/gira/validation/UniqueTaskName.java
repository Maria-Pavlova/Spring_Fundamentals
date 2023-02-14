package com.example.gira.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = UniqueTaskNameValidator.class)
public @interface UniqueTaskName {

    String message() default "Task name exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
