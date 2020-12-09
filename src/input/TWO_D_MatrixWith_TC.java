
package input;

import java.util.*;

public class TWO_D_MatrixWith_TC {
    
    
    static int xAxis[] = {0, 1, 0, -1,-1, 1, 1 ,-1};
    static int yAxis[] = {1, 0, -1, 0, 1, 1,-1, -1};
    
    
     public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt() ,  m = sc.nextInt();
            int arr[][] = new int[n][m];
        
            for(int i=0 ;i<n ; i++)
                for(int j=0 ;j<m ; j++)
                    arr[i][j] =sc.nextInt();
            
            
        }
    }
     
     static boolean isSafe(int arr[][] , boolean vis[][] , int i , int j)
      {
        return (i>=0 && i<arr.length && j>=0 && j<arr[0].length 
                && !vis[i][j] && arr[i][j]==1);
      }
}
