package com.example;

public class CircularDependancy1 {
    private CircuarDependancy2 dependency;

    CircularDependancy1(CircuarDependancy2 dependency){
        this.dependency = dependency;
    }
}
