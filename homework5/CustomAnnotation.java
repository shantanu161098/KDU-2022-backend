import java.lang.annotation.*;
@Retention (RetentionPolicy.RUNTIME)
@interface CustomAnnotate{
    int value();
}

public class CustomAnnotation {
    @CustomAnnotate(1)
    public static void customMethod(){
        CustomAnnotation object = new CustomAnnotation();

        try{
            CustomAnnotate annotation = object.getClass().getMethod("customMethod").getAnnotation(CustomAnnotate.class);
            System.out.println(annotation);
        }
        catch(NoSuchMethodException e){
            System.out.println("No such method " + e);
        }
        

    }


    public static void main(String[] args) {
        customMethod();
    }  
}
