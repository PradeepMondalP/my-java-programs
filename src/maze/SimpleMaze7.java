
package maze;

// find the longest route from source to destination using recursion



public class SimpleMaze7 {
    
    static  int arr[][] = {
//                            {1,1,0,0,1},
//                            {1,1,0,1,1},
//                            {0,1,0,1,1},
//                            {1,1,0,1,0},
//                            {0,1,1,1,1}         //change this array
        
        {1,0,1,1,1,1,0,1,1,1},//0
        {1,0,1,0,1,1,1,0,1,1},//1
        {1,1,1,0,1,1,0,1,0,1},//2
        {0,0,0,0,1,0,0,1,0,0},//3
        {1,0,0,0,1,1,1,1,1,1},//4
        {1,1,1,1,1,1,1,1,1,0},//5
        {1,0,0,0,1,0,0,1,0,1},//6
        {1,0,1,1,1,1,0,0,1,1},//7
        {1,1,0,0,1,0,0,0,0,1},//8
        {1,0,1,1,1,1,0,1,0,0}//9
            
                          };
    static int xAxis[] =  {-1,0,1,0};
    static int yAxis[] = {0,-1,0,1};
    static int N = arr.length  , xDest=5  , yDest=7 , arraySum=0;
    static int longArr[][] = new int[N][N];
 
    public static boolean isPossible(int x , int y , int arr[][] , int vis[][])
    {
        return (x>=0 && x<N && y>=0 && y<N && arr[x][y]==1 && vis[x][y]==0);
    }
    
    public static int getLength(int arr[][])
    {
        int sum=0;
        for(int i = 0 ; i<N ; i++)
            for(int j = 0 ;j<N ; j++)
                if(arr[i][j]==1)
                    sum++;
        return sum;
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
        
        
        public static void main(String[] args) 
        {
           // print(arr);
            printArray(arr);
            
            System.out.println("final array is ");
            print(longArr);
            System.out.println("total = \t"+getLength(longArr));
        }
       
        private static void printArray(int[][] arr)
        {
            int visited[][] = new int[N][N];
            printLenghtyArray(0 , 0 ,arr , visited);
        }
        
         private static boolean printLenghtyArray(int x, int y, int[][] arr, int[][] visited)
         {
             if(x==xDest && y==yDest)
             {
                  if(isPossible(x , y, arr , visited))
                  {
                        visited[x][y] = 1;
                        int length = getLength(visited);                        
                        if(length>=arraySum){
                            
                            System.out.println("copying now  coz "+ length +"  >= "+ arraySum);
                            arraySum = length;
                            copy(visited);
                        }
                        
                        System.out.println("temp Total "+ length);
                        print(visited);
                        visited[x][y]=0;
                        return false;
                  }
                  else
                      System.out.println("No path found");
             }
             
             if(isPossible(x, y, arr, visited))
             {
               //  System.out.println("possible "+ x+"\t and "+ y);
                  visited[x][y] = 1;
                  boolean tempDes = true;
                  
                  for(int i = 0 ; i<4 ; i++)
                  {
                      if(printLenghtyArray(x+xAxis[i], y+yAxis[i], arr, visited))
                      {
                          tempDes = false;
                           return true;
                      }
                  }
                  if(tempDes)
                  {
                      visited[x][y] = 0;
                      return false;
                  }
             }
             return false;
         }

    public static void copy(int arr[][])
    {
        for(int i = 0 ; i <N ; i++)
            System.arraycopy(arr[i], 0, longArr[i], 0, N);
    }

}
