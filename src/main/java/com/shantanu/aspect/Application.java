package com.shantanu.aspect;

import com.shantanu.aspect.operations.MathOperations;
import com.shantanu.aspect.operations.StringOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void printMathOperations(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        MathOperations mathOperations = context.getBean(MathOperations.class);
        System.out.println("Returned by main application " + mathOperations.divideTwoNumbers(20,10));
        System.out.println("");
        System.out.println("================================================");
        System.out.println("");
        try{
            System.out.println("Returned by main application " + mathOperations.divideTwoNumbers(0,0));
        }
        catch(ArithmeticException e){
            System.out.println("In main application " + e.getMessage());
        }
    }

    public static void printStringOperations(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        StringOperations stringOperations = context.getBean(StringOperations.class);
        System.out.println(stringOperations.concatString("Hello "," World"));
        System.out.println("");
        System.out.println("====================================");
        System.out.println("");
        System.out.println(stringOperations.intToString(100));
    }

    public static void main(String[] args) {
        System.out.println("================ Math operations ================");
        printMathOperations();
        System.out.println("================ String operations ================");
        printStringOperations();
    }
}
