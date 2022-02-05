package com.crypto.AllExceptions;

public class TimoutLimitExceededException extends Exception {
    private String s;

    public TimoutLimitExceededException(String s) {
        this.s = s;
    }

    public String getMessage(){

        return s;
    }

}
