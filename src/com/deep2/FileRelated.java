
package com.deep2;

// writing and  fetching data from current directiry

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileRelated {
    public static void main(String[] args) throws IOException {
        
        String dir = System.getProperty("user.dir");
        System.out.println("current directory is  = " + dir);
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(dir+"/input.txt"));
        for(int i = 1 ; i<=10 ; i++)
        {
            bw.write(i+"");
            bw.newLine();
        }
        bw.close();
        
        BufferedReader br = new BufferedReader(new FileReader(dir+"/input.txt"));
        BufferedWriter bw2 = new BufferedWriter(new FileWriter(dir+"/output.txt"));
        String str;
        while( (str=br.readLine())!=null)
        {
            bw2.write(str);
            bw2.newLine();
           
        }
        bw2.close();
        br.close();
    }
}
