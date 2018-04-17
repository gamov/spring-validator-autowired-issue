package com.example.demo;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PersonConstraintValidator.class)
public @interface NameConstraint {

    String message() default "Name not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
