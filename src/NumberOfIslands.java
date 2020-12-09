
import java.util.*;


public class NumberOfIslands {
    
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
           
            findNumberOfIslands(arr);
            
            System.out.println("count : "+ count);
        }
    }
     
    static int xAxis[] = {0, 1, 0, -1,-1, 1, 1 ,-1};
    static int yAxis[] = {1, 0, -1, 0, 1, 1,-1, -1};
    static int count;

    private static void findNumberOfIslands(int[][] arr) {
        
        int r=arr.length , c=arr[0].length;
        count=0;
        
        boolean vis[][] = new boolean[r][c];
        
        for(int i=0 ; i<r ;i++)
            for(int j=0 ; j<c ; j++)
            {
                if(!vis[i][j])
                {
                    if(solve(arr , vis , i , j) )  count++;
                    vis[i][j]=true;
                }
            }
    }

    private static boolean solve(int[][] arr, boolean[][] vis, int i, int j) {
        
        if(vis[i][j] || arr[i][j]==0) return false;
        
        vis[i][j]=true;
        
        for(int n=0 ; n<8 ; n++)
        {
            
            if( isSafe(arr, vis, i+xAxis[n], j+yAxis[n] ) )
            {
                solve(arr, vis, i+xAxis[n], j+yAxis[n]);
            }
        }
                
        return true;
    }
    
    static boolean isSafe(int arr[][] , boolean vis[][] , int i , int j)
    {
        return (i>=0 && i<arr.length && j>=0 && j<arr[0].length 
                && !vis[i][j] && arr[i][j]==1);
    }      
}


/*
1
4 4
1 1 0 0 
0 0 1 0
0 0 0 1
0 1 0 0

                   {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1} };
*/