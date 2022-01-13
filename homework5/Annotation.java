import java.lang.annotation.*;



@Retention (RetentionPolicy.RUNTIME)

@interface SingleValueAnnotation {
    int value();
}


@interface MarkerAnnotation{}



@interface MultiValuedAnnotation{
    int numberOne();
    int numberTwo();
}

public class Annotation {


    // Program to demonstrate single value annotation.
    @SingleValueAnnotation(1)
    public static void singleValueMethod(){
        System.out.println("Single valued");
    }


    // program for marker annotation.
    @MarkerAnnotation
    public static void markerMethod(){
        System.out.println("Marker");
    }


    // program for multi valued annonation
    @MultiValuedAnnotation(numberOne = 1,numberTwo = 2)
    public static void multiMethod(){
        System.out.println("Multi valued");
    }

}

class Main{
    public static void main(String[] args) {
        Annotation instance = new Annotation();
        instance.singleValueMethod();
        instance.markerMethod();
        instance.multiMethod();
    }
}