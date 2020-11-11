
import java.util.*;


public class subsetsum2 {
      public static void main(String[] args) {
         int arr[] ={11,4,9,11};
          System.out.println(minDiffernce(arr, 4));
      }
    	static public int minDiffernce(int arr[], int length) 
	{ 
	    int n=arr.length;
	    if(n==0) return 0;
	    if(n==1) return arr[0];
	    if(n==2) return Math.abs(arr[0]- arr[1] );
	    int sum=0;
	    for(int x : arr) sum+=x;
	    
	    Arrays.sort(arr);
	    return solve(arr , sum);
	} 
	
	static int solve(int arr[] , int sum)
	{
	    int min = Integer.MAX_VALUE , n= arr.length;
	    boolean dp[][] = new boolean[n+1][sum/2 +1];
	    
	    dp[0][0]=true;
	    
	    for(int i=1 ;i<=n ; i++)
	    {
	        dp[i][0]=true;
	        for(int j=1 ; j<=sum/2 ; j++)
	        {
	            if( j>= arr[i-1]) dp[i][j]= dp[i-1][j] | dp[i-1][j-arr[i-1]];
	            else dp[i][j] = dp[i-1][j];
	            
	            if( dp[i][j]==true)
	               min = Math.min(min , sum-2*j );
	        }
	    }
	    return min;
	}
}
