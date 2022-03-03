package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void displayProperties(ApplicationContext context){
        System.out.println(context.getApplicationName());
        System.out.println(context.getDisplayName());
        System.out.println(context.getId());
        System.out.println(context.getBean("vehicle"));
        System.out.println(context.getStartupDate());
        System.out.println(context.FACTORY_BEAN_PREFIX);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        Vehicle obj = (Vehicle) context.getBean("vehicle");
        obj.drive();
        Vehicle initObject = (Vehicle) context.getBean("modelcar");
        Vehicle destroyObject = (Vehicle) context.getBean("destroy");
        destroyObject.destroy();
          Vehicle propertyObject = (Vehicle) context.getBean("propertycar");
          propertyObject.getMileage();
        Vehicle constructorObject = (Vehicle) context.getBean("constructorcar");
        constructorObject.getModel();
        Vehicle scopeObject = (Vehicle) context.getBean("scopecar");
        displayProperties(context);



    }
}
