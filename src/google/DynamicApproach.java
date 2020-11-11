
package google;

import java.util.ArrayList;

// working.... but
// pprinting all the subset with given sum only printing
public class DynamicApproach {
    
    static boolean [][]dp;
    
    static  void    display(ArrayList<Integer> list){
        System.out.println(list);
    } 
    
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int LEN = arr.length;
        int sum =10;
        
        printAllSubset(arr,LEN , sum);
    }

    private static void printAllSubset(int[] arr, int n, int sum) {
        if(n==0 || sum<0)
            return;
        
        dp = new boolean[n][sum+1];
        for(int i=0 ; i<n ; i++)
             dp[i][0] =true;
        
        if(arr[0]<=sum)
            dp[0][arr[0]] = true;
        
        for(int i = 1 ; i<n ; ++i)
            for(int j = 1 ; j<sum+1 ;++j)
                dp[i][j] = (arr[i]<=j)? (dp[i-1][j]) ||dp[i-1][j-arr[i]] : dp[i-1][j];
        
        if(dp[n-1][sum]==false){
            System.out.println("no subset found");
            return;
        }
        ArrayList<Integer> p =new  ArrayList<>();
        prinSubSet(arr , n-1 , sum , p);
    }

    private static void prinSubSet(int[] arr, int i, int sum, ArrayList<Integer> p) {
          
        if(i==0 && sum!=0 && dp[0][sum])
        {
            p.add(arr[i]);
            display(p);
            p.clear();
            return;
        }
        if(i==0  && sum==0)
        {
            display(p);
            p.clear();
            return;
        }
        if(dp[i-1][sum])
        {
            ArrayList<Integer> b = new ArrayList<>();
            b.addAll(p);
            prinSubSet(arr, i-1, sum, b);
        }
        
        if(sum>=arr[i]  && dp[i-1][sum-arr[i]])
        {
            p.add(arr[i]);
            prinSubSet(arr, i-1, sum-arr[i], p);
        }
    }
}
