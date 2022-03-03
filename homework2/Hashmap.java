
import java.util.*;

class Hashmap{

    static void repeatingChars(String str){
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
        char[] char_array = str.toCharArray();

        for(char c : char_array){
            if(hash.containsKey(c)){
                hash.put(c,hash.get(c) + 1);
            }
            else{
                hash.put(c,1);
            }
        }

        for(Map.Entry element : hash.entrySet()){    
             if((int)element.getValue() > 1){
                 System.out.println((char)element.getKey() + " " + (int)element.getValue());
             } 
                
        }  
    }

    static void removeDuplicates(String str){
        char[] char_array = str.toCharArray();
        HashMap<Character,Integer> hash = new HashMap<Character,Integer>();

        for(char c: char_array){
            c = Character.toLowerCase(c);
            if(!hash.containsKey(c)){
                System.out.println(c);
                hash.put(c,1);
            }
        }

    }

    static boolean isStringsEqual(char[] c1,char[] c2,int start){
        for(int i = start;i<c2.length;i++){
            if(c1[i] != c2[i-start]){
                return false;
            }   
        }
        return true;

    }

    static void occurenceCheck(String s1,String s2){
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int start_index = -1;

        for(int i=0;i<c1.length - c2.length;i++){
            if(isStringsEqual(c1, c2, i)){
                start_index = i;
            }
            
        }
        System.out.println(start_index);
    }

    static void insertString(String s1,String s2,int index){
        if(index > s1.length()){
            System.out.println("length exceeded");
            return;
        }


        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c = new char[c1.length+c2.length];

        for(int i = 0;i<index;i++){
            c[i] = c1[i];
        }

        for(int i=0;i<c2.length;i++){
            c[index+i] = c2[i];
        }
        
        for(int i=index;i<c1.length;i++){
            c[i+ c2.length] = c1[i];
        }

        System.out.println(c);
    }



    public static void main(String[] args){
        System.out.println("==========repeating char==========");
        repeatingChars("inputin");
        System.out.println("==========remove duplicates==========");
        removeDuplicates("banaNas");
        System.out.println("============= Occurence check========");
        occurenceCheck("abcdabcdef","abcd");
        System.out.println("==========insert index==========");
        insertString("abcd", "efgh", 2);
        

    }
}