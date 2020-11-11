/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampletests;

import java.io.*;
import java.util.*;


public class Prblm2 {
 
    public static void main(String[] args) throws Exception{
        
         String ch , salary , companyName ;
         String []str;
         int totalSum1 =0, totalSum2=0;
         
        String dir = System.getProperty("user.dir");
        List<Integer>list = new ArrayList<Integer>(); 
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/output.txt"));
        
        while( (ch=br.readLine())!=null)
        {
            str = ch.split(",");
            salary = str[1].trim();
            companyName = str[2].trim();
            
            if(companyName.equals("Amkart"))
                totalSum1+=Integer.parseInt(salary);
            
            else if(companyName.equals("Airflix"))
                totalSum2+=Integer.parseInt(salary);
        }
        bw.write("Amkart" +" " +totalSum1);
        bw.newLine();
        bw.write("Airflix" +" " +totalSum2);
        br.close();
        bw.close();
    }
}
