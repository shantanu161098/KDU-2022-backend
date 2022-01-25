package com.example;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateFormatValidation.class)
public @interface DateFormat {
    String message() default "Date must be in YYYY-MM-DD format";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
