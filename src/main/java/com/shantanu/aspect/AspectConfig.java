package com.shantanu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Pointcut("execution(public Double *(..))")
    public void anyMethod() {
    }

    /**
     * Implementation of within Pointcut
     */
    @Pointcut("within(com.shantanu.aspect.operations.StringOperations)")
    public void stringMethod() {}

    /**
     * Implementation of args method
     */

    @Pointcut("execution(public String *(int))")
    public void stringWithArgs() {}

    @Before("stringWithArgs()")
    public void beforeStringWithArgs(JoinPoint joinPoint){
        System.out.println("Before arg " + joinPoint.getSignature().getName());
    }

    @Around("stringWithArgs()")
    public String aroundStringWithArgs(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around arg");
        Object result = proceedingJoinPoint.proceed();
        return String.valueOf(result);
    }

    @After("stringWithArgs()")
    public void afterStringWithArgs(JoinPoint joinPoint){
        System.out.println("After arg " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "stringWithArgs()",returning = "result")
    public void afterReturnStringWithArgs(String result){
        System.out.println(result);
    }

    @AfterThrowing(pointcut = "stringWithArgs()",throwing = "error")
    public void afterThrowingStringWithArgs(JoinPoint joinPoint,Throwable error){
        System.out.println(error.getMessage());
    }













    @Before("stringMethod()")
    public void beforeStringConcat(JoinPoint joinPoint){
        System.out.println("Before : "+ joinPoint.getSignature().getName());
    }

    @Around("stringMethod()")
    public String concatAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("Around advice of string method ");
        Object result = proceedingJoinPoint.proceed();
        return String.valueOf(result);
    }

    @Before("anyMethod()")
    public void beforeDivide(JoinPoint joinPoint) {
        System.out.println("Before : " + joinPoint.getSignature().getName());
    }

    @After("anyMethod()")
    public void AfterDivide(JoinPoint joinPoint) {
        System.out.println("After : " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "anyMethod()", returning = "result")
    public void AfterReturn(int result) {
        System.out.println("After Return " + result);
    }

   @Around("anyMethod()")
    public Double around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around advice");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("Around advice returned  " + result);
        return Double.valueOf(result.toString());
   }

   @AfterThrowing(pointcut = "anyMethod()",throwing = "error")
    public void afterThrowing(JoinPoint joinpoint,Throwable error){
        System.out.println("In after throwing advice " + error.getMessage());
   }

}
