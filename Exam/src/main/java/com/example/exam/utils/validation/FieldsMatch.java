package com.example.exam.utils.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = FieldsMatchValidator.class)
public @interface FieldsMatch {

    String first();

    String second();

    String message() default "Password does not match.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
