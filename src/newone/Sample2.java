
package newone;

import java.util.*;


public class Sample2 {
    
    public static void main(String[] args) {
        
        int arr[] = {1,8};
       
        System.out.println(find(arr));
      
        
    }
    
     static int find(int arr[])
     {
         int max = Integer.MIN_VALUE;
         for(int i=0 ; i<arr.length-1 ; i++)
              for(int j=i+1 ; j<arr.length ; j++)
                   max = Math.max(max, (j-i)*Math.min(arr[i], arr[j]));
         return max;
     }
}
