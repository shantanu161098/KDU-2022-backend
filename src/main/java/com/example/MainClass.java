package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        Validator validator = context.getBean(Validator.class);

        final Thing book = context.getBean(Book.class);


        /**
         * Issue date and return date should be in YYYY-MM-DD format
         * Issue date should be less than return date
         */
        book.setName("Ramayana");
        book.setIssueDate("2021-01-1");
        book.setReturnDate("2021-01-2");

        Set<ConstraintViolation<Thing>> violations = validator.validate(book);



        for (ConstraintViolation<Thing> violation : violations) {
            System.err.println(violation.getMessage());
        }

    }
}
