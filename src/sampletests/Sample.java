/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletests;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


public class Sample {
    
    public static void main(String[] args) {
        
          Map<String ,String> map = new TreeMap<>();
          
         map.put("nob","vp");
         map.put("vp","ajoy");
         map.put("ajoy","abhi");
         map.put("nob","jesh");
         map.put("abhi","vijoy");
         map.put("jayesh","shital");
         map.put("vp","rajam");
         map.put("jayesh","zeba");
         map.put("zeba","chaital");
         map.put("vp","sheela");
         
         for(Map.Entry entry :map.entrySet())
              System.out.println("key ="+entry.getKey() +"\t\t"+ "value="+entry.getValue());
    }
}

