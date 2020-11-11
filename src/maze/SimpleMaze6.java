
package maze;
import java.util.Stack;

// going for DFS to find the shortest path from src-> destination
// uses stack
// always go for BFS while finding shortest path...

public class SimpleMaze6 {
    
    static  int arr[][] = {
                        {1,1,0,0,1},
                        {1,1,0,1,1},
                        {0,1,0,1,1},
                        {1,1,0,1,1},
                        {0,1,1,1,1}         //change this array
                          };
    static int xAxis[] =  {-1,0,1,0};
    static int yAxis[] = {0,-1,0,1};
    static int xPos =1, yPos=3;
    
    static int N = arr.length;

    static class Node
    {
        int x , y, dest;

        public Node(int x, int y, int dest) {
            this.x = x;
            this.y = y;
            this.dest = dest;
        }

    }
    
    
    public static void print(int arr[][])
    {
        System.out.println("............");
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ;j<N ; j++){
                System.out.print(arr[i][j]+" ");
            }
        System.out.println();
        }
    }
    
    public static void main(String a[])
    {
        print(arr);
        findShortestPathUsingDFS(arr );
        
    }

    private static void findShortestPathUsingDFS(int[][] arr ) {
        int visiting[][] = new int[N][N];
        
        printUtils(arr, visiting);
    }

     private static void printUtils( int[][] arr, int[][] visiting)
     {
        Stack<Node>stk = new Stack<>();
        stk.add(new Node(1,0,1));
                        
        while(!stk.isEmpty())
        {
            Node obj  = stk.pop();
            int i = obj.x;
            int j = obj.y;
            int dest = obj.dest;
        //    System.out.println("........popping "+ i +"\t  and"+ j);
            
            if(i==xPos && j ==yPos)
                {
                    visiting[i][j]=1;
                    System.out.println("cost :"+ dest);
                    print(visiting);
                    return ;
                }

                if(isPossible(i, j, arr, visiting))
                {
                    visiting[i][j]=1;
                    boolean temp = true;
            
                    for(int m = 0 ; m<4 ; m++)  // checking all four possible 4 directions
                        {
                            if(isPossible(i+xAxis[m] , j+yAxis[m] ,arr , visiting))
                                {
                                stk.add(new Node(i+xAxis[m] , j+yAxis[m] , dest+1)  ) ;
                                temp = false;
                                }
                        }
                    if(temp)
                        visiting[i][j]=0;
                    
                }
        }       
     }
        
     public static boolean isPossible(int x , int y , int arr[][] , int vis[][])
    {
        return (x>=0 && x<N && y>=0 && y<N && arr[x][y]==1 && vis[x][y]==0);
    }
}
