package com.example;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
@ComponentScan
public class ApplicationConfig {


    @Bean
    public Validator createValidator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }

}
