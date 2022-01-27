package com.shantanu.aspect.operations;

import org.springframework.stereotype.Component;

@Component
public class StringOperations {
    public String concatString(String s1, String s2) {
        return s1 + s2;
    }

    public String intToString(int i){
        return String.valueOf(i);
    }
}
