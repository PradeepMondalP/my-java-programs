
package hackerrank;

import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class BigDecimals {
    
     public static void main(String []args){
        //Input
       
       
        
         Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++)
            s[i]=sc.next();
        
      	
//        BigDecimal bg[] = new BigDecimal[n];
//        for( int i = 0 ; i <n ; i++ )
//              bg[i] = new BigDecimal(s[i]);
//        
//    
//        
//        for(int i  =0 ; i< bg.length-1 ; i++)
//             for(int j = 0 ; j<bg.length-i-1 ; j++)
//                 if( bg[j].compareTo(bg[j+1])  <0 )
//                 {
//                      BigDecimal temp = bg[j];
//                      bg[j] = bg[j+1];
//                      bg[j+1] = temp;
//                 }
//        
//        for(int i = 0 ; i<bg.length ; i++)
//            s[i] = bg[i].toString();


      
        Arrays. sort ( s , 0 , n , Collections.reverseOrder( new Comparator<String>() {
             @Override
             public int compare(String o1, String o2) {
               BigDecimal b1 = new BigDecimal(o1);
               BigDecimal b2 = new BigDecimal(o2);
               return b1.compareTo(b2);  // b1 > b2 ? 1 : -1 ;
             }
         })
        );
        
        for(int i=0;i<n;i++)
            System.out.println(s[i]);
        
        
        
        
    }
}
