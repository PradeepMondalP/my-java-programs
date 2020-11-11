
package practice;

// leetCode

import java.util.Arrays;

public class TargetSum {
    
    
    public static void main(String[] args) {
        
        int arr[] = {0,0,0,0,0,0,0,0,1};
        System.out.println("answer is -> "+findTargetSumWays(arr, 1));
    }
    
     public static int findTargetSumWays(int[] num, int diff)  {
        
        int n = num.length , newSum=0 , sum=0;
        Arrays.sort(num);
        for(int x: num)  sum+=x;
        
        if(sum<diff) return 0;
       // if(sum%2!=0 && diff%2==0)  return 0;
        
        newSum = (sum+diff)/2;
        
         System.out.println("new sum is "+ newSum);
         
        int arr[][] = new int[n+1][newSum+1];
        arr[0][0]=1;
        
        for(int i=1 ; i<=n ;i++){
            arr[i][0]=1;
            for(int j=1 ; j<=newSum ; j++){
                if(j==num[i-1])  arr[i][j]=1;
                
                else if( j>num[i-1])  arr[i][j] = arr[i-1][j] + arr[i-1][j-num[i-1]];
                
                else   arr[i][j]= arr[i-1][j];
            }
        }
        
        for(int x[]:arr){
            for(int y :x)
                System.out.print(y+" ");
            System.out.println();
        }
        return arr[n][newSum];
    }
}
