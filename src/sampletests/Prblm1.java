
package sampletests;

import java.io.*;
import java.util.*;

public class Prblm1 {
    
    public static void main(String[] args) throws Exception {
        
         String ch , temp ;
         String []str;
         
        String dir = System.getProperty("user.dir");
        List<Integer>list = new ArrayList<Integer>(); 
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/output.txt"));
        
        while( (ch=br.readLine())!=null)
        {
            str = ch.split(",");
            temp = str[1];
            list.add(Integer.parseInt(temp.trim()));
        }
        br.close();
      
        Collections.sort(list);
        bw.write(list.get(0)+"");
        bw.close();
    }
}
