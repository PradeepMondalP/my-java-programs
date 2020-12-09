
import java.util.*;




public class FloodFill_Algorithm {
    
    static int xAxis[] = {-1, 0 , 1 , 0};
    static int yAxis[] = {0 , 1 , 0 ,-1};
    static int  col;
	
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt() , m=sc.nextInt();
            int arr[][] = new int[n][m];
        
            for(int i=0 ;i<n ; i++)
              for(int j=0 ; j<m ; j++) 
                 arr[i][j] =sc.nextInt();
            
            int xPos = sc.nextInt();
            int yPos = sc.nextInt();
            col  = sc.nextInt();
            
            boolean vis[][] = new boolean[n][m];
            solve(arr ,vis , xPos , yPos, arr[xPos][yPos]);
            
            print(arr);
            
            System.out.println();
        }
    }

    private static void solve(int[][] arr ,boolean vis[][] ,int x , int y , int val) {
       
         if(vis[x][y]) return;
         vis[x][y]=true;
         arr[x][y]=col;
         
         for(int i=0 ; i<4 ; i++)
         {
             if (isSafe(arr, vis, x+xAxis[i], y+yAxis[i], val ))
                 solve(arr, vis, x+xAxis[i], y+yAxis[i], val);
         }
    }
    
    static boolean isSafe(int arr[][] , boolean vis[][], int i , int j , int val)
    {
        return (i>=0 && i<arr.length && j>=0 && j<arr[0].length && !vis[i][j]
                && (arr[i][j]==val || arr[i][j]==col  ) );
    }

    private static void print(int[][] arr) {
        
        for(int i=0 ; i<arr.length ; i++)
            for(int j=0 ; j<arr[0].length ; j++)
                System.out.print(arr[i][j]+" ");
        
       
    }

    
}


/*

9 7 0 2 0 9 5 3 8 7 7 5 0 1 4 4 7 4 7 1 8 5 5 6 7 9 0 8 5 9 4 4 6 6 9 8 7 4 4 6 1 1 1 3 4 8 7 3 2 7 5 2 2 0 1 9 2 1 9 7 0 6 3 8 2 2 9 0 7 3 6 0 6 9 4 2 7 1 5 0 8 2 4 1 5 5 2 7 7 4 4 9 0 9 8 2 4 9 2 1 4 0 3 0 0 7 2 9 1 9 1 9 2 6 2 7 1 5 4 0 1 0 0 1 1 0 3 5 9 8 8 3 0 2 5 2 9 9 9 2 8 5 2 0 1 6 7 5 3 3 5 4 5 7 5 7 9 1 2 8 1 1 3 1 3 0 6 4 9 0 7 0 5 1 0 9 7 0 6 3 5 3 7 1 1 3 8 0 6 0 1 7 3 6 0 8 9 6 3 0 8 2 0 6 3 3 5 2 5 1 5 0 4 5 3 7 0 3 0 6 6 3 5 9 9 5 8 8 4 3 1 4 5 1 0 0 4 5 4 1 8 0 2 5 7 7 2 7 1 2 3 7 5 8 6 7 5 6 7 1 9 8 6 6 2 6 6 8 4 1 0 2 3 4 9 0 1 2 9 2 6 2 9 4 2


9 7 0 2 0 9 5 3 8 7 7 5 0 1 4 4 7 4 7 1 8 5 5 6 7 9 0 8 5 9 4 4 6 6 9 8 7 4 4 6 1 1 1 3 4 8 7 3 2 7 5 2 2 0 1 9 2 1 9 7 0 6 3 8 2 2 9 0 7 3 6 0 6 9 4 2 7 1 5 0 8 2 4 1 5 5 2 7 7 4 4 9 0 9 8 2 4 9 2 1 4 0 3 0 0 7 2 9 1 9 1 9 2 6 2 7 1 5 4 0 1 0 0 1 1 0 3 5 9 8 8 3 0 2 5 2 9 9 9 2 8 5 2 0 1 6 7 5 3 3 5 9 5 7 5 7 9 1 2 8 1 1 3 1 3 0 6 4 9 0 7 0 5 1 0 9 7 0 6 3 5 3 7 1 1 3 8 0 6 0 1 7 3 6 0 8 9 6 3 0 8 2 0 6 3 3 5 2 5 1 5 0 4 5 3 7 0 3 0 6 6 3 5 9 9 5 8 8 4 3 1 4 5 1 0 0 4 5 4 1 8 0 2 5 7 7 2 7 1 2 3 7 5 8 6 7 5 6 7 1 9 8 6 6 2 6 6 8 4 1 0 2 3 4 9 0 1 2 9 2 6 2 9 4 2


*/