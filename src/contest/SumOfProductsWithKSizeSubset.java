/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contest;

import java.util.*;

public class SumOfProductsWithKSizeSubset {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t -- >0)
        {
            int n = sc.nextInt() , k =sc.nextInt();
            int arr[] = new int[n];
            for(int i=0 ; i<n ; i++) arr[i]  =sc.nextInt();
            
            System.out.println(sumOfProduct(arr, n, k));
        }
    }
    
    //efficent way
    public static int sumOfProduct(int arr[], int n,int k)
    {
        long dp[][] = new long[n+1][n+1] ;
        long  mod = 1000000007;
         

        long  cur_sum = 0; 

        for(int i = 1; i <= n; i++) 
        { 
            dp[1][i] = arr[i - 1] ; 
            cur_sum = cur_sum  +  arr[i - 1]  ; 
        } 
     
        for(int i = 2; i <= k; i++) 
        { 

            long  temp_sum = 0; 
     
            for(int j = 1; j <= n; j++)
            { 

                cur_sum = cur_sum - dp[i - 1][j]; 
     
                dp[i][j] = ( (arr[j - 1])  * (cur_sum) ) % mod; 
                temp_sum =  temp_sum + dp[i][j] ; 
            } 
            cur_sum = cur_sum + temp_sum ; 
        } 
        return (int)(cur_sum % mod);      
        
    }
    
    
    //naive approach
    static int K;
    public static int sumOfProduct2(int arr[], int n,int k)
    {
        K = k;
        // create sub array
        ArrayList<ArrayList<Integer>>res= new ArrayList<>();
        ArrayList<Integer>temp = new ArrayList<>();
        
        solve(arr , res , temp , 0 );
        
        System.out.println("res "+ res);
        
        return getSum(res);
    }
    
    static void solve(int arr[] ,ArrayList<ArrayList<Integer>>res , 
      ArrayList<Integer>temp , int x)
      {
          
          if(temp.size()==K ){
              res.add(new ArrayList<>(temp));
              return;
          }
          
          for(int i=x ; i<arr.length ; i++)
          {
              temp.add(arr[i]);
              solve(arr, res, temp, i+1);
              temp.remove(temp.size()-1);
          }
      }

    private static int getSum(ArrayList<ArrayList<Integer>> res) {
        
        int sum=0 , mod= 1000000007;
        for(ArrayList<Integer>tempList : res)
        {
            long tempSum=1;
            for(int val : tempList){
                tempSum *= val;
                tempSum %= mod;
            }
            
            sum += tempSum;            
        }
        return sum % mod;
    }
}
