
package maze;

//with sensors problem
//  printing all path from colm0 -> colmN  using BAcktracking
// 
//  Node 0 Means sensors
// need to be modified

public class SimpleMaze4 {
      static int N;
     
    static int x[] = {-1,0,1,-1,1,1,-1,0};
    static int y[] = {0,1,0,1,-1,1,-1,-1};
    static  int arr[][] = {
                            {0,1,1,1,0,1,1,1,1,1 },
                             {1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,0,1},
                             {1,1,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,0,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1},
                             {1,0,1,1,1,1,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,0},
                             {1,1,1,1,1,0,1,1,1,1},
                             {1,1,1,1,1,1,1,1,1,1}
                          };

    public static boolean isValid(int x , int y , int arr[][])
    {
       return (x>=0 && x<N && y>=0 && y<N);
    }
    
    public static boolean isPossible(int x , int y , int arr[][] , int vis[][])
    {
        return (arr[x][y]==1 && vis[x][y]==0);
    }
    
    public static void main(String[] args) {
        
       int visited[][];
       N = arr.length;
       visited = new int[N][N];
       findShortestDistance(arr , visited);
      }
    
    
    public static void print(int arr[][]){
        System.out.println(".................");
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ;j<N ; j++){
                System.out.print(arr[i][j]+" ");
            }
        System.out.println();
        }
    }
    
    public static void findShortestDistance(int arr[][] , int visited[][])
    {
       for(int i = 0;i <N ; i++)
        {
            for(int j =0;j<N ;j++)
            {
                  if(arr[i][j]==0)
                  {
                      for(int m=0 ; m<8; m++)
                          if( isValid(i+x[m],j+y[m], arr) )
                                 arr[i+x[m]][j+y[m]]=Integer.MAX_VALUE;
                  }
            }
        }     
           for(int i = 0 ; i<N;i++)
             for(int j=0 ; j<N ; j++)
                if ( arr[i][j]==Integer.MAX_VALUE )
                    arr[i][j]=0;
       
        
        for(int i = 0 ; i<N ; i++)
            if(arr[i][0]==1)
            {
                 visited[i][0]=1;
                 printMyDiagram(i,0,visited);
                 visited[i][0]=0;
            }
    }
    
     private static boolean printMyDiagram(int xPos, int yPos, int[][] visited) {
       
         if( xPos==0 && yPos==N-1){
             visited[xPos][yPos]=1;
             print(visited);
             
             visited[xPos][yPos]=0;
             return false;
         }
         
         for(int i = 0 ; i<3 ; i++)
         {
            if(isValid(xPos+x[i] ,yPos+y[i],arr) && isPossible(xPos+x[i], yPos+y[i], arr, visited)) 
            {
            //    System.out.println("Xpos = "+(xPos+x[i]) +"...yPos = "+ (yPos+y[i]));
                visited[xPos+x[i]] [yPos+y[i]] = 1;
                
                if(printMyDiagram(xPos+x[i], yPos+y[i], visited))
                    return true;
                 else
                    visited[xPos+x[i]][yPos+y[i]]=0;
                
               
            }
           
         }
         return false;
    }
    
    
}
