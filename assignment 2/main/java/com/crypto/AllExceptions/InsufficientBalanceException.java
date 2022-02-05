package com.crypto.AllExceptions;

public class InsufficientBalanceException extends Exception {
    String s;

    public InsufficientBalanceException(String s) {
        this.s = s;
    }

    @Override
    public String getMessage() {
        return s;
    }
}
