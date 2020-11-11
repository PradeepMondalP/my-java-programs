
//check whther a subset exist or not wid the particular sum , if exist print the sub array
package dynamic;

import java.util.Arrays;

public class Subset_sum_problem {
    
    public static void main(String[] args) {
        int input[] = {2,3,5,6,8,10};
        int n = input.length , sum=10;
        int arr[][] = new int[n][sum+1];
        Arrays.sort(input);
        arr[0][0]=1;  
        arr[0][input[0]]=1;
        
        for(int i =1 ; i<n ;i++)
        {
            arr[i][0]=1;
            for(int j=1 ; j<=sum; j++)
             {
                 if(input[i]==j || arr[i-1][j]==1)  arr[i][j]=1;
                  if(j>input[i] && arr[i-1][j]==0)   arr[i][j]= arr[i-1] [j-input[i]];
             }
        }
        System.out.println("array is");
        for(int []arrX :arr)
        {
            for(int u : arrX)
                System.out.print(u+" ");
            System.out.println();
        }
        int exists = arr[n-1][sum];
        System.out.println("\n the sub arry elemnts are......");
        
        if(exists==1)
        {
            int i=n , j=sum , tempSum=sum;
            while( tempSum!=0 )
            {
                if(i==0 ||j==0){
                    System.out.print(" "+input[i]);
                    tempSum-=input[i];  continue;
                }
                if( arr[i-1][j]==1 )  i--;
                else{
                    System.out.print(" "+ input[i]);
                    j-=input[i];
                    tempSum-=input[i];
                }
            }
        }
        else
            System.out.println("sub array not exits");
    }
}
