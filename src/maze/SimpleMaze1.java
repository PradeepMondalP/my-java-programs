
package maze;

//  source to dest finding finding 1 path  using Backtracking...
// Rat in a Maze problem
public class SimpleMaze1 {
    
    static int N;
    
    public static void main(String[] args) {
        
        int maze[][] = {
                        {1,0,0,0},
                        {1,1,0,1},
                        {0,1,0,0},
                        {1,1,1,1}
                       };
        N = maze.length;
        solveMaze(maze);
        
    }
    
    static void printSolution(int soln[][])
    {
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ; j<N ; j++){
                 System.out.print(" "+ soln[i][j]);
            }
            System.out.println();
        }
        
    }
    
    private static boolean isSafe(int maze[][] , int x , int y)
    {
        return (x<N && x>=0 && y<N && y>=0 && maze[x][y]==1);
    }
    
   static void solveMaze(int maze[][])
    {
        int soln[][] = new int[N][N];
        if(solveMazeUtil(maze, 0, 0, soln))
            printSolution(soln);
        else
            System.out.println("No Path found");
        
    }
    
  static  boolean solveMazeUtil(int maze[][] , int x , int y , int soln[][])
    {
        if(x==N-1 && y==N-1)
        {
             soln[x][y]=1;
             return true;
        }
        
        if(isSafe(maze , x , y))
        {
              soln[x][y]=1;
              
              if(solveMazeUtil(maze, x, y+1, soln) || solveMazeUtil(maze, x+1, y, soln))
                   return true;
             
              soln[x][y]=0;
              return false;
        }
        return false;
    }
   
}
