
package dynamic;

// read question from DS notes part 3 DP
import java.util.Arrays;

public class MCMMatrix {
    
    static int t[][];
    static int res=Integer.MAX_VALUE;
    static int count=0;
    public static void main(String[] args) {
       
        int arr[] = {40,20,30,10,30};
        int n = arr.length;
        t= new int[n+1][n+1];
        
        for(int a[] : t)
            Arrays.fill(a,-1);
        
        System.out.println(solve(arr, 1, n-1));
      }
    
    
    public static int solve(int arr[], int i , int j)
    {
        if(i>=j)  return 0;
        if(t[i][j]!=-1)   return t[i][j];
            
       int temp=0 , left , right;
        for(int k=i ; k<=j-1 ; k++)
        {
            if(t[i][k]!=-1)  left = t[i][k];
             else{
                left = solve(arr, i, k);
                t[i][k] = left;
                }
            
            if(t[k+1][j]!=-1)   right = t[k+1][j];
            else{
                right = solve(arr, k+1, j);
                t[k+1][j] = right;
               }
            
            temp = left + right + arr[i-1]*arr[k]*arr[j];
            
            res = Math.min(temp, res);
        }
        t[i][j] = temp;
        return res;
    }
}
