/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package roughWorking;

import java.util.*;
import java.util.Scanner;


public class Sample2 {
    	public static void main (String[] args)
	 {
	    Scanner sc =new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- >0)
            {
                int a = sc.nextInt() , b = sc.nextInt();
                if(a==b){
                    System.out.println("0");
                    continue;
                }
                
                LinkedList<Integer>list1 = new LinkedList<>() , list2 = new LinkedList<>();
                while(a>0){
                    list1.addFirst(a);
                    a/=2;
                }
                while(b>0){
                    list2.addFirst(b);
                    b/=2;
                }
                
               if(list1.size() > list2.size())  System.out.println("out :"+solve(list1 , list2) );
               else System.out.println("out :"+solve(list2 , list1));       
            }
	 }   

    private static int solve(LinkedList<Integer> large, LinkedList<Integer> small) {
        
        int l = large.size() , s = small.size() , start=-1 , count=0;
        start=s-1;
               
        for( ; start>=0 ; start--)
        {
            if(large.get(start) .equals(small.get(start))  )  break; 
            else count+=2;                
        }
        
        return count+(l-s);
    }
       
}

/*

1
66 56676416
o/p -  31


1
66 566764
19

1
66 5667
16

1
66 566
9
*/