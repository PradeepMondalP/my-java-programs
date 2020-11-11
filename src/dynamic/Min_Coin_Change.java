
package dynamic;

// find out the min number of coin req to make a particular amount
// perfect,....

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.BiFunction;


public class Min_Coin_Change {
    
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
        int sum = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n ; i++) arr[i]=sc.nextInt();
        
        
        
        System.out.println(findMin(arr, n, sum));
                
                
    }

     static int findMin(int[] arr,int n, int sum) {
       

        int[] res = new int[sum + 1]; 
  
        for (int j = 1; j <= sum; j++)  res[j] = Integer.MAX_VALUE; 
  
        for (int j = 1; j <= sum; j++) 
        { 
            // Go through all coins smaller than i 
            for (int i = 0; i < n; i++) 
            {
                if (arr[i] <= j) 
                { 
                   int sub_res = res[j - arr[i]]; 
                if (sub_res != Integer.MAX_VALUE   && sub_res + 1 < res[j]) 
                       res[j] = sub_res + 1; 
                } 
            }
              
        } 
        return res[sum]; 
    }
    
    public static BiFunction<Integer,Integer,Integer> min = 
            (a,b)->{
              if(a>b) return b;
              return a;
            };
    
}
