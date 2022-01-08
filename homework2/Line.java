import java.lang.Exception;

class ParallelLineException extends Exception
{
    public ParallelLineException(String s)
    {
        // parent constructor call
        super(s);
    }
}



public class Line{
    float m = 0;
    float c = 0;
    public Line(int m,int c){
        this.m = m;
        this.c = c;
    }

    


}





class Main{

    public static void point_of_intersection(Line l1,Line l2)throws ParallelLineException{
        if(l1.m == l2.m){
            throw new ParallelLineException("Lines are parallel ");
        }
        else{
            try{
                float x = (l2.c - l1.c)/(l1.m - l2.m);
                float y = l1.m*x+l1.c;
                System.out.println("Point of intersection " + x + " and " + y);
            }
            // other exception 

            catch(Exception e){
                System.out.println(e);
            }
        }
    }


    public static void main(String[] args) {
        // y = x + 1
        Line l1 = new Line(1,1);
        
        // y = x + 2

        Line l2 = new Line(1, 2);

        try {
            point_of_intersection(l1,l2);
        } catch (Exception e) {
            System.out.println(e);
        }

        // y = 2x + 1
        Line l3 = new Line(2,1);
        
        // y = 5x + 5

        Line l4 = new Line(5, 5);
            
        try {
            point_of_intersection(l3,l4);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
}