package hackerrank;
import java.math.*;
import java.util.*;

public class sample 
{
    public static void main(String[] args) {
        
       Scanner sc= new Scanner(System.in);
       int n=sc.nextInt();
       int arr[] =new int[n];
       
       for(int i=0 ; i<n ; i++) arr[i]=sc.nextInt();
       
        System.out.println(".............");
        System.out.println(solve(arr));
      
    }
    
    public static long solve(int arr[])
    {
        int n = arr.length ;
        long  SUM=0;
        
        int candyLeft[] = new int[n];
        int candyRight[] = new int[n];
        Arrays.fill(candyLeft, 1);
        Arrays.fill(candyRight, 1);
        
        for(int i=1 ; i<n ;i++)
            candyLeft[i]=( arr[i]> arr[i-1])? candyLeft[i-1]+1 :candyLeft[i];
        
        for(int i=n-2 ; i>=0 ;i--)
            candyRight[i]=arr[i]>arr[i+1] ?candyRight[i+1]+1 : candyRight[i];
        
        for(int i=0 ; i<n ; i++)
            SUM+=Math.max(candyLeft[i], candyRight[i]);
        
        return SUM;
    }
    
     
}



/*
10
2 4 2 6 1 7 8 9 2 1

tc1  o/p   33556     mine 33560

tc2  o/p  160929     mine 296728
  
*/