package com.example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Date;

public class DateFormatValidation implements ConstraintValidator<DateFormat, Thing> {
    @Override
    public boolean isValid(Thing book, ConstraintValidatorContext constraintValidatorContext) {


        if(book.getIssueDate().toCharArray()[4] == '-' && book.getIssueDate().toCharArray()[7] == '-' &&
                book.getReturnDate().toCharArray()[4] == '-' && book.getReturnDate().toCharArray()[7] == '-'){
            return true;
        }
        return false;
    }

    @Override
    public void initialize(DateFormat constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
