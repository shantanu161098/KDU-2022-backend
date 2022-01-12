import java.lang.reflect.Array;
import java.time.*;
import java.util.ArrayList;
import java.util.List;  

public class Speed {
    public static void main(String[] args) {
        
        
        List<Integer> numbers = new ArrayList<Integer>();

        

        for(int i=0;i<10;i++){
            numbers.add(0);
        }

    Instant start_for = Instant.now();

    for(int i=0;i<10;i++){
        System.out.println(numbers.get(i));
    }

    Instant end_for = Instant.now();

    System.out.println("For loop took " + Duration.between(start_for, end_for) + " time");
        
    Instant start_each = Instant.now();
    numbers.forEach(System.out :: println);
    Instant end_each = Instant.now();

    System.out.println("For each loop took " + Duration.between(start_each, end_each) + " time");

    
/* 
    Foreach loop first needs to instantiate an Enumerator for the collection.
*/


    Instant start = Instant.now();
    numbers.stream().forEach(System.out :: println);
    Instant end = Instant.now();
    System.out.println("Normal stream took " + Duration.between(start, end) + " time");


    start = Instant.now();
    numbers.parallelStream().forEach(System.out :: println);
    end = Instant.now();
    System.out.println("Parallel stream took " + Duration.between(start, end) + " time");

/*
    Prallel stream can do independent computation.

*/
    }
}
