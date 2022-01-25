package com.example;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;


@Component
@Data
@IssueReturnRateCheck
@DateFormat
public class Book implements Thing {

    @NotNull(message="Name should be not null")
    private String name;
    private String issueDate;

    private String returnDate;
}
