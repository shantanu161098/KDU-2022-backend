package com.example;

public class CircuarDependancy2 {
    private CircularDependancy1 dependency;
    CircuarDependancy2( CircularDependancy1 dependency){
        this.dependency = dependency;
    }
}
