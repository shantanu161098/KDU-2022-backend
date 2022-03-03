package com.example;

public class Car implements Vehicle{
    private String model;
    private String mileage;


    Car(){}
    Car(String model){
        this.model = model;
    }

    public void setMileage(String mileage){
        this.mileage = mileage;
    }

    public String getMileage(){
        System.out.println(mileage);
        return mileage;
    }
    public void drive(){
        System.out.println("Driving");
    }


    public void init(){
        System.out.println("Going through init method");
    }

    public String getModel(){
        System.out.println(model);
        return model;
    }
    public void destroy(){
        System.out.println("Object is destroyed");
    }



}
