
package dynamic;

// from the given array , we have to create 2 subArray ST whose sum difference is MIN..

import java.util.Arrays;


public class Minimum_Subset_sum_difference {
    public static void main(String[] args) {
        
        int arr [] ={3,1,4,2,2,1};
        Arrays.sort(arr);
         int sum = 0 , min =Integer.MAX_VALUE , n=arr.length;
        for(int x : arr)
            sum+=x;
        
        int arr2[][] = new int[n+1][sum+1];
        arr2[0][0]=1;
        
        for(int i=1 ; i<=n ;i++){
            arr2[i][0]=1;
            for(int j=1; j<=sum ; j++){
                
                if(j<arr[i-1])  arr2[i][j] = arr2[i-1][j];
                
                else if(arr2[i-1][j]==1 || arr2[i-1][j-arr[i-1]]==1)
                    arr2[i][j] = 1;
                
                if(i==n && arr2[i][j]==1 && j<=sum/2)
                {
                    if(sum-2*j <min)
                    min=sum-2*j;
                }
             }
        }
    System.out.println("\n\n min val possible is " + min);
                
        
    }
}
