
package dynamicP;

import java.util.Scanner;


public class NCR {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        
        Solution obj = new Solution();
        System.out.println(obj.nCr(n, r));
    }
    
//    static int dp[][] = new int[1002][1002];
//    static int max=1 , mod=(int)1e9 +7;
//
//    static int ncr(int n, int r) {
//         
//        if(dp[n][r]!=0) return dp[n][r];
//        if(n > max)
//        {
//            
//            for(int i=max ; i<=n; i++)
//            {
//                dp[i][i] = 1;
//                dp[i][1] = i;
//                dp[i][i-1]=i;
//            }
//            max= n;
//            
//        }
//        
//        return solve(n , Math.min(r, n-r) );
//        
//    }
//
//    static int solve(int n, int r) {
//        if(dp[n][r]!=0) return dp[n][r];
//        
//        dp[n][r] = ( solve(n-1, r-1) + solve(n-1, r) ) %mod;
//        
//        return dp[n][n-r]=dp[n][r];
//    }
}



class Solution{
    
     int dp[][] ; 
     int  mod=(int)1e9 +7;
    
   int nCr(int n, int r)
    {
        if(n==r || r==0) return 1;
        if(r==1) return n;
        
        dp = new int[1002][1002];
        for(int i=1 ; i<=n; i++)
          {
                dp[i][i] = 1;
                dp[i][1] = i;
                dp[i][i-1]=i;
          }
        
         
        return solve(n , Math.min(r, n-r) );
    }
    
    int solve(int n, int r) {
        
        if( dp[n][r]!=0) return dp[n][r];
        
        dp [n][r] = ( solve(n-1, r-1) + solve(n-1, r) ) %mod;
        
        return dp[n][n-r]=dp[n][r];
    }
}