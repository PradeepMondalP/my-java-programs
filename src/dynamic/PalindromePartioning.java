
package dynamic;

// read question from DS part 3 Notes..

import java.util.Arrays;

public class PalindromePartioning {
    
    static int dp[][] ;
    
    public static void main(String[] args) {
        
        String s = "ababbbabbababa";
        int n = s.length();
        dp = new int[n][n];
        
        // initializing my 2D array with  -1
        for(int arr[] : dp)
            Arrays.fill(arr, -1);
        
       
        System.out.println("min partion req is "+ solve(s, 0, s.length()-1));
        
       
                
    }
    public static int solve(String s  , int i , int j)
    {
        if(i>=j  ||  isPalindrome(s , i , j))  return 0;
        if(dp[i][j] !=-1) return dp[i][j];
        
        int leftVal , rightVal , min =Integer.MAX_VALUE;
        
        for(int k=i ; k<= j-1 ; k++)
        {
            if(dp[i][k]!=-1)  leftVal = dp[i][k];
            else{
                leftVal = solve(s, i, k);
                dp[i][k] = leftVal;
            }
            
            if(dp[k+1][j]!=-1)  rightVal=dp[k+1][j];
            else{
                rightVal= solve(s, k+1, j);
                dp[k+1][j] = rightVal;
            }
            
            int temp = 1+ leftVal+rightVal;
             if(temp<min)  min = temp;
           
        }
        return dp[i][j]=min;
    }
    
    
     static boolean isPalindrome(String s , int i , int j) {
        if(i>=j)   return true;
        while(i<j)
        {
            if(s.charAt(i)!=s.charAt(j))
                  return false;
            i++; j--;
        }
        return true;
    }
}