
package maze;

import java.util.ArrayDeque;
import java.util.Queue;

//  Node 0 containing sensors
// using BFS(breadth first search ) finding smallest COST from 
// indirectly findly only the shortest path
// sources(0 th colums )  to destination (N-1 Colums)

public class SimpleMaze3 {
    
    static int N;
    static boolean visited[][];
    static int x[] = {-1,0,0,1,-1,1,1,-1};
    static int y[] = {0,-1,1,0,1,-1,1,-1};
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
    
    static class Node
    {
        int x , y ,dest;

        public Node(int x, int y, int dest) {
            this.x = x;
            this.y = y;
            this.dest = dest;
        }
    }
    
    public static boolean isValid(int x , int y , int arr[][])
    {
       return (x>=0 && x<N && y>=0 && y<N);
    }
    
    public static boolean isPossible(int x , int y , int arr[][] , boolean vis[][])
    {
        return (arr[x][y]==1 && !vis[x][y]);
    }
    
    public static void main(String[] args) {
        
      
       N = arr.length;
       visited = new boolean[N][N];
      
       System.out.println(findShortestDistance(arr));
        
    }
    
    public static void print(int arr[][]){
        System.out.println("............");
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ;j<N ; j++){
                System.out.print(arr[i][j]+" ");
            }
        System.out.println();
        }
    }
    
    public static int findShortestDistance(int arr[][])
    {
        print(arr);
        System.out.println();
        for(int i = 0;i <N ; i++)
        {
            for(int j =0;j<N ;j++)
            {
                for(int k = 0 ; k<8 ; k++)
                {
                    if(arr[i][j]==0 && isValid(i+x[k],j+y[k], arr)  && arr[i+x[k]][j+y[k]]==1)
                        arr[i+x[k]][j+y[k]]=Integer.MAX_VALUE;
                }
            }
            
        }      // alternate solution for this loop is in  (datastructure-> sample -> Test1)
       
        for(int i = 0 ; i<N;i++)
            for(int j=0 ; j<N ; j++)
                if ( arr[i][j]==Integer.MAX_VALUE )
                    arr[i][j]=0;
        
        System.out.println();
        System.out.println("just printing the matrix afer adding SENSORS Neighbours");
        print(arr);
        
        Queue<Node> queue = new ArrayDeque<>();
        for(int k = 0 ;k<N ; k++)
            if(arr[k][0]==1)
                queue.add(new Node(k , 0 , 1));
        
        while(!queue.isEmpty())
        {
            int i = queue.peek().x;
            int j = queue.peek().y;
            int dist = queue.peek().dest;
            queue.poll();
            
            if(i==0 && j==N-1)
            {
                return dist;
            }
                 
            
            for(int k = 0 ; k<4 ; k++)
            {
                if(isValid(i+x[k] , j+y[k] ,arr) && isPossible(i+x[k] , j+y[k] , arr , visited ) )
                {
                    queue.add(new Node(i+x[k] , j+y[k] , dist+1));
                    visited[i+x[k]][j+y[k]] = true;
                }
            }
        }
        return -1;
    }
}
