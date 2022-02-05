package com.crypto.AllExceptions;

public class TopFiftyNotExistException extends Exception{
    String s;
    public TopFiftyNotExistException(String s){
        this.s = s;
    }

    @Override
    public String getMessage() {
        return s;
    }
}
