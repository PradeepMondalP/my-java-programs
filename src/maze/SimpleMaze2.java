
package maze;


//  source to dest finding finding All Possible path  using Backtracking...
// Rat in a Maze problem

public class SimpleMaze2 {
    
    static int N;
    
    public static boolean isSafe(int maze[][] , int x , int y , int soln[][])
    {
        return (x<N && x>=0&& y<N && y>=0 && (maze[x][y]==1) && (soln[x][y]==0));
    }
    
    public static void maze(int maze[][])
    {
        int soln[][] = new int[N][N];
        if(mazeUtils(maze, 0, 0, soln))
            print(soln);
        else
            System.out.println("No solution found");
    }
    
    public static boolean mazeUtils(int maze[][] , int x , int y  , int soln[][])
    {
        if(x==N-1 && y==N-1)
        {
            soln[x][y]=1;
            print(soln);
            soln[x][y] = 0;
            return false;
        }
        
        if(isSafe(maze , x , y ,soln))
        {
             soln[x][y]=1;
             
             if(mazeUtils(maze, x, y+1, soln)  || mazeUtils(maze, x+1 , y, soln) ||
               mazeUtils(maze, x, y-1, soln)   || mazeUtils(maze, x-1, y, soln)  )
                 return true;
             
             soln[x][y]=0;
             return false;
        }
        return false;
    }

    private static void print(int[][] soln) {
        System.out.println();
        System.out.println("...........................");
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ;j<N ; j++)
                System.out.print(" "+ soln[i][j]);
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
           int maze[][] = {
                        {1,1,1,1},
                        {1,1,0,1},
                        {0,1,0,1},
                        {1,1,1,1}
                       };
        N = maze.length;
        maze(maze);
    }
}
