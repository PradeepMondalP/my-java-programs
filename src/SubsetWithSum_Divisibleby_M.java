
import java.util.*;


public class SubsetWithSum_Divisibleby_M {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt() , m=sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0 ;i<n ; i++) arr[i] =sc.nextInt();
        
        System.out.println(DivisibleByM(arr, m));
        
        
    }
    
   static int DivisibleByM(int [] arr, int m)
    {
        int sum=0 , n = arr.length;
        Arrays.sort(arr);
        
        for(int x: arr)
        {
            if(x%m==0) return 1;
            sum+=x;
            if(sum%m==0) return 1;
        }
        if(sum < m) return 0;
        
        int maxSum = m * (sum/m);
        
        int dp[][] = new int[n+1] [maxSum+1];
        
        dp[0][0]=1;
        
        for(int i=1 ; i<=n ; i++)
        {
            if(arr[i-1] > maxSum) break;
            dp[i][0] = 1;
            
            for(int j=1 ; j<=maxSum ; j++)
            {
                if( j>=arr[i-1] ){
                    dp[i][j] = dp[i-1][j] + dp[i-1][j - arr[i-1] ];
                }
                else
                  dp[i][j]= dp[i-1][j];
                
                if(j%m==0 && dp[i][j]!=0) return 1;  
            }
        }
        
        for(int temp[] : dp)
        {
            for(int x : temp)
                System.out.print(x+" ");
            System.out.println();
        }
        
        return 0;
    }
}


/*
5 16
7 8 11 12 13

*/