/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest;

import java.util.*;

/**
 *
 * @author Pradeep Mondal
 */
public class ValidPairSum {
    
    public static void main(String[] args) {
        
        int arr[] ={-2,-1,-1,-1,-1,0 ,1,2,3}; //{-2,1 , 3};  //
        System.out.println(ValidPair(arr));
           
        
    }

    private static int ValidPair(int[] arr) {
        
        int n = arr.length;
        
        // Sorting the given array 
         Arrays.sort(arr);
         
        // Variable to store the count of pairs 
        int ans = 0; 
      
        for (int i = 0; i < n; i++)
        { 
      
             // Ignore if the value is negative
            if (arr[i] <= 0)   continue; 

            /*
            minReqVal val is the min value ,which after adding gives the positive sum pair
            */
            int minReqVal = -arr[i]+1;
            int j=lower_bound(arr , minReqVal );

            if(j>=0)  ans += i - j ; 
           
        } 
        return ans;
    }
    
    /*
       it return the index of a minimum Number
       which is just >= val
    */
    static int lower_bound(int arr[] , int val)
    {
        int start=0 , end = arr.length;
        
        /*
          using the Binary search technique , since our array is sorted
        */
        while(start < end)
        {
            int mid = (start + end)>>1;
            
            if(val > arr[mid]) start = mid+1;
            else end = mid;
        }
        
        // when we dont find the answer return -1
        if(start==arr.length) return -1;
        
        return start;
    }
    
    
    //this code is contributed by Pradeep Mondal P
}
 







/*

4class GFG {

    // Function to find the number
    // of pairs in the array with
    // sum > 0
    static int findNumOfPair(int arr[], int n)
    {

        // Sorting the given array
        Arrays.sort(arr);

        // Variable to store the count of pairs
        int ans = 0;

        // Loop to iterate through the array
        for (int i = 0; i < n; ++i) {

            // Ignore if the value is negative
            if (arr[i] <= 0)
                continue;
          
            /*
            minReqVal val is the min value ,which will
            give >=1 after adding with the arr[i]
            */
            int minReqVal = -arr[i] + 1;
            int j = lower_bound(arr, minReqVal);

            if (j >= 0)
                ans += i - j;
        }
        return ans;
    }

    /*
         it return the index of a minimum Number in the
         array which is just >= val
      */
    static int lower_bound(int arr[], int val)
    {
        int start = 0, end = arr.length;

        /*
          using the Binary search technique , since our
          array is sorted
        */
        while (start < end) {
            int mid = (start + end) >> 1;

            if (val > arr[mid])
                start = mid + 1;
            else
                end = mid;
        }

        // when we dont find the answer return -1
        if (start == arr.length)
            return -1;

        return start;
    }

    // Driver code
    public static void main(String[] args)
    {
        int a[] = { -2, 1, 3 };
        int n = a.length;

        int ans = findNumOfPair(a, n);
        System.out.println(ans);
    }
}

// This code is contributed by Pradeep Mondal P


*/