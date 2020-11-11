
package maze;

// from particular src to paricular dst all possibilities Routes...
// using backtracking........
// Perfect program

public class SimpleMaze5 {
    static  int arr[][] = {
                        {1,1,0,0,1},
                        {0,1,0,1,1},
                        {0,1,0,1,0},
                        {1,1,0,1,0},
                        {0,1,1,1,0}         //change this array
                      };
    
    static int N = arr.length;
    
    public static void main(String[] args) {
        
        print(arr);
        printArray(arr);
    }
    
    public static void printArray(int arr[][])
    {
        int visited[][] = new int[N][N];
        printAllPossibilities(0,0 ,arr ,visited);
    }

    private static boolean printAllPossibilities(int x, int y, int[][] arr, int[][] visited) {
        
        if(x==3 && y==2)          //give a destination
        {
            if(isPossible(x, y, arr, visited))
            {
                visited[x][y] = 1;
                print(visited);
                visited[x][y]=0;
                return false; 
            }
            else
                System.out.println("Not possible");
           
        }
        
        if(isPossible(x,y,arr,visited))
        {
            visited[x][y]=1;
          //  System.out.println("x :"+x +"\t y: "+ y);
            
            if(printAllPossibilities(x, y+1, arr, visited) || 
               printAllPossibilities(x+1, y, arr, visited) || 
               printAllPossibilities(x, y-1, arr, visited) ||
               printAllPossibilities(x-1, y, arr, visited))        //checking all 4 directions
                {
                    return true;
                }
            else   // came to some corner so making the value to 0
            {
                visited[x][y]=0;
                return false;
            }
           
        }
       
        return false;
    }
    
    public static boolean isPossible(int x , int y , int arr[][] , int vis[][])
    {
        return (x>=0 && x<N && y>=0 && y<N && arr[x][y]==1 && vis[x][y]==0);
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
}
