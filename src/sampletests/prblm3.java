/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletests;

import java.io.*;
import java.util.*;

public class prblm3 {
    public static void main(String[] args)  throws Exception{
        String ch , key , value ,finalValue="";
         String []str;
         
         
        String dir = System.getProperty("user.dir");
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/output.txt"));
        
        Map<String ,String> map = new LinkedHashMap<>();
        LinkedList<String> list = new LinkedList<String>();
        
        while( (ch=br.readLine())!=null)
        {
            str = ch.split(",");
            value = str[0].trim();
            key = str[2].trim();
            
            if(key.equals("NOBODY")){
                  list.addLast(value);
            }
             else
            {
                 if(list.contains(key))
                 {
                     map.put(key, value);
                      list.addLast(value);
                 }
            }
     }
         
        for(Map.Entry ent : map.entrySet()){
            System.out.print(ent.getKey()+"\t "+ent.getValue());
            System.out.println();
            finalValue = ent.getValue().toString();
        }
        
        bw.write(finalValue);
        br.close();
        bw.close();
    }
}
