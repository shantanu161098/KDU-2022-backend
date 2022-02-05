package com.crypto.AllExceptions;

public class AmbiguousTransactionTypeException extends Exception {
    String s;

    public AmbiguousTransactionTypeException(String s) {
        this.s = s;
    }

    @Override
    public String getMessage() {
        return s;
    }
}
