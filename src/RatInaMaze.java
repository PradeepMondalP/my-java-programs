import java.util.*;

public class RatInaMaze {
    
    public static void main(String[] args) {
        int n=4;
        int arr[][]=   {{1, 0, 0, 0},
                       {1, 1, 0, 1}, 
                       {1, 1, 0, 0},
                       {0, 1, 1, 1}};
        System.out.println(printPath(arr, n));
    }
    
    static int N;
    
    static int xAxis[] = {0, 1, 0,  -1};
    static int yAxis[] = {1, 0, -1,  0};
    
    static  ArrayList<String>res;
    
    public static ArrayList<String> printPath(int[][] arr, int n) {
        N=n;
        res = new ArrayList<>();
        boolean visited[][] = new boolean[n][n];
        String str="";
        solve(arr , visited  , str , 0 , 0);
        return res;
    }
    
    static boolean solve(int arr[][] , boolean vis[][] , String str , int x , int y)
    {
        if(x==N-1 && y==N-1){
            res.add( str );
            return false;
        }
        
            vis[x][y]=true;
            for(int i=0; i<4;i++)
             {
                if( isSafe(arr , vis ,x+xAxis[i] , y+yAxis[i]) )
                {
                    vis[x+xAxis[i]][y+yAxis[i]]=true;
                    String currMove = findMove(xAxis[i] , yAxis[i]);
                    str+=currMove;
                    solve(arr , vis , str , x+xAxis[i] , y+yAxis[i]);

                    str = str.substring(0,str.length()-1);
                    vis[x+xAxis[i]][y+yAxis[i]]=false;
                }
             }
            vis[x][y]=false;
        
        
        
        return false;
    }
    
    static boolean isSafe(int arr[][] , boolean vis[][] , int x , int y)
    {
        return (x>=0 && x<N && y>=0 && y<N && arr[x][y]!=0 && !vis[x][y]);
    }
    static String findMove(int x , int y)
    {
        if(x==0 && y==1) return "R";
        if(x==1 && y==0) return "D";
        if(x==0 && y==-1) return "L";
         return "U";
    }
}

/*
5
1 1 0 1 1
1 1 1 1 1
0 0 1 1 1 
0 1 0 1 0
0 1 1 1 1 

my :O/p
DRRDRDDR DRRRDDDR DRRRRDLDDR DRRRURDDLDDR RDRDRDDR RDRRDDDR RDRRRDLDDR RDRRURDDLDDR




*/