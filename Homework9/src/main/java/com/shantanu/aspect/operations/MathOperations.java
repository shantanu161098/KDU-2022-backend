package com.shantanu.aspect.operations;

import org.springframework.stereotype.Component;

@Component
public class MathOperations {
    public Double divideTwoNumbers(int a, int b) {

        return (double) (a / b);
    }
}
