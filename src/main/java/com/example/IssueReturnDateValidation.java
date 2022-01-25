package com.example;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;

public class IssueReturnDateValidation implements ConstraintValidator<IssueReturnRateCheck, Thing> {
    @Override
    public boolean isValid(Thing book, ConstraintValidatorContext constraintValidatorContext) {



        try{
            Date issueDate=new SimpleDateFormat("yyyy-mm-dd").parse(book.getIssueDate());
            Date returnDate=new SimpleDateFormat("yyyy-mm-dd").parse(book.getReturnDate());
            if(issueDate.before(returnDate)){
                return true;
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public void initialize(IssueReturnRateCheck constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
