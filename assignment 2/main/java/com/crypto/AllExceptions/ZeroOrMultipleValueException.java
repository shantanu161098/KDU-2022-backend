package com.crypto.AllExceptions;

public class ZeroOrMultipleValueException extends Exception {
    String s;
    public ZeroOrMultipleValueException(String s){
        this.s = s;
    }

    public String getMessage(){
        return s;
    }
}
