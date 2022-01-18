
import java.io.*;
import java.util.Scanner;

public class Exception {
    public static void main(String[] args) {
        // io exception

        try{
            File file = new File("");
            Scanner s = new Scanner(file);
        }
        catch(IOException e){
            System.out.println("IO Exception is " + e);
        }

        // number format exeption 

        try{
            Integer.parseInt("a");
        }
        catch(NumberFormatException e){
            System.out.println("number format exception "+ e);
        }

        // arthematic exception

        try{
            int a = 12/0;
        }
        catch(ArithmeticException e){
            System.out.println("arithematic exception " + e);
        }

    // out of bound exception

    try {
            int[] a = new int[2];
            int b = a[3];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array out of bound exception "+ e);
        }



    // nested try catch finally


    // System.out.println("nested try catch block");

    try{  
        int a = 1/0;
      }  
      catch(ArithmeticException e){  
            System.out.println(e);
         
      
         try{  
            int a = Integer.parseInt("a");
         }  
         catch(NumberFormatException f){  
            System.out.println(f);
         }  
      }  

      finally {
        System.out.println("caught");
      }

      
    }
}
