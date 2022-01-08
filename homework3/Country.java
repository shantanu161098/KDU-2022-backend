import java.io.*;
import java.util.*;


public class Country {

    public static HashMap<String,String> sortcaptial(HashMap<String,String> map)
    {
    
        List<Map.Entry<String,String> > list =
               new LinkedList<Map.Entry<String,String> >(map.entrySet());
 
        
        Collections.sort(list, new Comparator<Map.Entry<String,String> >() {
            public int compare(Map.Entry<String,String> o1,
                               Map.Entry<String,String> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
         
    
        HashMap<String,String> temp = new LinkedHashMap<String,String>();
        for (Map.Entry<String,String> a : list) {
            temp.put(a.getKey(), a.getValue());
        }
        return temp;
    }
    
 
     













    public static void main(String[] args) {
        File file = new File("country-list.csv");

        // displaying 10 lines of file.

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            br.readLine();
            for(int i=0;i<10;i++){
                
                // System.out.println(br.readLine());
                // br.close();
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        
        try{
            HashMap<String,String> map = new HashMap<String,String>();
            BufferedReader br2 = new BufferedReader(new FileReader(file));
            br2.readLine();
            while(br2.readLine()!=null){
                String temp = br2.readLine();
                map.put(temp.split(",")[0], temp.split(",")[1]);
                

                
            }
            br2.close();

            Map<String,String> ms = sortcaptial(map);
            
            File writefile = new File("sorted.csv");

            FileWriter writer = new FileWriter("sorted.csv");

            for (Map.Entry<String,String> en : ms.entrySet()) {
                writer.write(en.getKey() + "," + en.getValue() + "\n");
            }

            writer.close();

            String[] lines = new String[10];
            int counter = 0;
            BufferedReader reader = new BufferedReader(new FileReader(writefile));

            for(int i=0;i<114;i++){
                reader.readLine();
            }
            while(counter < 10){
                lines[counter] = reader.readLine();
                counter++;
            }
            reader.close();

            for(int i=0;i<10;i++){
                System.out.println(lines[i]);
            }

        }
        catch(Exception e){
            System.out.println(e);
        }
        
        
    }
}
