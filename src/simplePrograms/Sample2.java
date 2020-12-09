
package simplePrograms;

import java.util.Scanner;


public class Sample2 {
     public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0 ;i<n ; i++) arr[i] =sc.nextInt();
        
        int k = sc.nextInt();
        
        // System.out.println(findNumber(arr, n, k));
         System.out.println(findMaximum(arr, n));
    }
     
     static int findNumber(int arr[], int n, int key) {
	   
	   int low =0 , high=n-1;
	   while(low<=high)
	   {
	       int mid = low + (high-low)/2;
	       if(arr[mid]==key) return mid;
	       if(arr[low]==key) return low;
	       if(arr[high]==key) return high;
	       
	       
	       if(mid==0){
	           return -1;
	       }
	       
	       if(mid==n-2) return -1;
	       
	       //if left part is sorted
	       if(arr[low] < arr[mid]  && arr[mid] > arr[mid-1]){
	           if(key>=arr[low+1] && key<=arr[mid-1])  high = mid-1;
	           else low = mid+1;
	       }
	       // right part is sorted
	       else
	       {
	           if(key>=arr[mid+1] && key<=arr[high-1]) low=mid+1;
	           else high = mid-1;
	       }
	   }
	   return -1;
	}
     
    static  int findMaximum(int arr[], int n)
    {
        int start=0 , end=n-1;
        
        while(start<=end)
        {
            int mid  = start + (end-start)/2;
            
            if(mid==0){
                if(arr[mid] > arr[mid]+1) return 0;
                return 1;
            }
            
            if(mid==n-1){
                if( arr[n-1] > arr[n-2] ) return n-1;
                return n-2;
            }
            
            if(  arr[mid]>arr[mid+1] && arr[mid] > arr[mid-1] )
                return mid;
            
            if( arr[ mid ] < arr[mid-1] )  end =  mid-1;
            
            else start = (mid+1);
        }
        return -1;
    }
}
