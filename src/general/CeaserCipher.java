/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package general;

import java.util.Scanner;

/**
 *
 * @author Pradeep Mondal
 */
public class CeaserCipher {
     public static void main(String[] args) {
          
      Scanner sc = new Scanner(System.in);
      String msg = sc.nextLine();
      char[]ch = msg.toCharArray();
      int []arr = new int[ch.length];
      
     for(int x = 0 ; x<ch.length ; x++)
           arr[x] = (int)ch[x];
     
     for(int key = 0 ; key<26 ; key++)
     {
         int ch2[] = new int[arr.length];
         
         for(int y=0 ; y<arr.length ; y++)
              ch2[y] = (arr[y]-key ) %26 ;
         
         
         for(int x : ch2)
             System.out.print(" "+(char) (x+65));
         System.out.println();
     }
      
    } 
}
