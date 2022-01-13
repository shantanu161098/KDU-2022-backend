import org.junit.Test;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;


class FindAvgOfElement{

    public int correctCode(int[] numberArray,int numberOfElement){

        int sum = 0;

        for(int i=0;i<numberOfElement;i++){
            sum = sum + numberArray[i];
        }
        return sum/numberOfElement;
    }

    public int incorrectCode(int[] numberArray,int numberOfElement){

        int sum = 1;

        for(int i=0;i<numberOfElement;i++){
            sum = sum + numberArray[i];
        }
        return sum/numberOfElement;
    }


}


public class App {

    @BeforeClass
    public void beforeClassFunction(){
        System.out.println("Before class");
    }

    @Before
    public void beforeTestCase(){
        System.out.println("Before test case");
    }

    @Test
    public void testCode(){
        FindAvgOfElement instance = new FindAvgOfElement();

        assertEquals(1,instance.correctCode(new int[]{1,1,1,1},4));  
    }

    @Test
    public void testAnotherCode(){
        FindAvgOfElement instance = new FindAvgOfElement();

        assertEquals(2,instance.incorrectCode(new int[]{1,1,1,1},4));  
    }

    @After
    public void afterTestCase(){
        System.out.println("After test case");
    }

    @AfterClass
    public void afterClassFunction(){
        System.out.println("After class");
    }

}


