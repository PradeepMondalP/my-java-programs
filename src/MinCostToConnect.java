
import java.util.*;


public class MinCostToConnect {
    
    public static void main(String[] args) {
        
        int arr[][] = { {0,0},{2,2},{3,10},{5,2},{7,0} };
        System.out.println(minCostConnectPoints(arr));
        
        
        
        
    }
    
    public static int minCostConnectPoints(int[][] arr) {
        
        long cost=0 , mod = 1000000009;
        
        for(int i=0; i<arr.length ; i++)
        {
            long tempSum =Integer.MAX_VALUE;
            for(int j=i+1 ; j<arr.length ; j++)
            {
                long temp = (Math.abs(arr[i][0]-arr[j][0])%mod + Math.abs(arr[i][1]-arr[j][1])%mod) %mod;
                tempSum = Math.min(tempSum , temp);
            }
            cost+=tempSum%mod;
            cost%=mod;
        }
        
        int res = (int)cost;
        return res;
    }
   
}
