package com.example;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IssueReturnDateValidation.class)
public @interface IssueReturnRateCheck {
    String message() default "Return date should be equal or less than issue date";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
