
package sampletests;

import java.io.*;
import java.util.*;

public class prblm4 {
    
    public static void main(String[] args) throws Exception{
        
         String ch , key , value , finalString="";
         String []str;
         int totalLineNumber =0;
         ArrayList<Integer>lines = new ArrayList<>();
         Map<String ,String> map = new LinkedHashMap<>();
         LinkedList<String> list = new LinkedList<String>();
   
        String dir = System.getProperty("user.dir");
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/output.txt"));
        
        while( (ch=br.readLine())!=null)
        {
            str = ch.split(",");
           // value = str[0].trim();
            key = str[2].trim();
            
            if(key.equals("NOBODY"))
                  lines.add(totalLineNumber);
                 
           totalLineNumber ++;  
        }
       
//        System.out.println("new company present at");
//        for(int y:lines)
//            System.out.print("  "+ y);
//        System.out.println("\n\n\n");
//        
//        
        for(int i=0 ; i<lines.size() ; i++)
        {
            BufferedReader br2 = new BufferedReader(new FileReader(dir+"/input.txt"));

            for(int j = 0 ; j<=lines.get(i) ; j++)
            {
                  if(j==lines.get(i))
                 {
                       while( (ch=br2.readLine())!=null)
                           {
                               str = ch.split(",");
                                  value = str[0].trim();
                                  key = str[2].trim();
            
                                 if(j==lines.get(i) && key.equals("NOBODY")){
                                        list.addLast(value);
                              //          System.out.println("value of j is"+ j);
                                    }
                                  else
                                   {
                                       if(list.contains(key))
                                            {
                                             map.put(key, value);
                                             list.addLast(value);
                                            }
                                    }
                                 j++;   // for giving exception at first line of Nobody
                            }
                 }
                 br2.readLine();
            }
//            
//            System.out.println("list "+ (i+1) +"times contains");
//            for(String d: list)
//                System.out.print("\t"+ d);
//            System.out.println("\n\n");
//            
//            
//            Set<Map.Entry<String , String>>zz= map.entrySet();
//            Iterator<Map.Entry<String , String>>it = zz.iterator();
//             while(it.hasNext())
//               {
//                 System.out.print(it.next()+" ");
//                 System.out.println("");
//               }
//              
              Set<String>key2 = map.keySet();
              for(String key3 :key2)
                finalString = map.get(key3);
              
               bw.write(list.get(0) +" : "+ finalString);
               bw.newLine();
               map.clear();
               list.clear();
               finalString="";
        
        }
        
        bw.close();
    }
}
