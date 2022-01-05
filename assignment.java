
public class assignment {

    public static int tribonacci(int a){
        if(a == 0 || a == 2){

            return 1;
        }
        if(a == 1){
            return 2;
        }
        if(a >= 3){
            return tribonacci(a-1) + tribonacci(a-2) + tribonacci(a-3);
        }
        return 0;
    }

    public static void square(int N){
        int number = 1;
        for(int i=1;i<=N;i++){
            if(number%4 == 0){
                number++;
            }

                System.out.println(number*number);
                number+=1;


        }
    }

    public static void divi(int N){
        for(int i=1;i<N;i++){
            int sum_of_digits = 0;
            int j = i;
            while (j != 0){
                sum_of_digits = sum_of_digits + j%10;
                j = j/10;
            }

            if(sum_of_digits%3 == 0){
                System.out.println(i);
            }
        }

    }

    public static void tribo_printer(int N){
        for(int i=0;i<N;i++){
            System.out.println(tribonacci(i+3));
        }
    }

    public static Boolean palindrome(String s){

        int i = 0;
        int j = s.length()-1;
        while (i<j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void series3(int N){
        int current_multiple = 4;
        int number = 1;

        for(int i=0;i<N;i++){
            if(current_multiple%3 == 0){
                current_multiple+=4;
            }
            System.out.println(number);
            number = number + current_multiple;

            current_multiple+=4;
        }
    }

    public static void main(String[] args){
        System.out.println("Series 1");
        tribo_printer(5);
        System.out.println("Series 2");
        square(5);
        System.out.println("Series 3");
        series3(5);
        System.out.println("Divisible by 3");
        divi(5);
        System.out.println("Palindrome");
        System.out.println(palindrome("abba"));


    }
}
