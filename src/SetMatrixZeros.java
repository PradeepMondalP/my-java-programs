
public class SetMatrixZeros {
    
    static int max=999999;
    public static void main(String[] args) {
        
        int arr[][] = { {0,1,3,1,5} ,
                        {1,1,0,1,6} ,
                        {1,1,1,1,7} };
        
        solve(arr);
        
        for(int x[] : arr)
        {
            for(int y : x)
                System.out.print(y+" ");
            System.out.println();
        }
    }

     static void solve(int[][] arr) {
         
         for(int i=0 ; i<arr.length ; i++)
           for(int j=0; j<arr[0].length ; j++)
             {
                 if(arr[i][j]==0)  changeTheArray(arr , i , j);
             }
         
         for(int i=0 ; i<arr.length ; i++)
           for(int j=0; j<arr[0].length ; j++)
               if(arr[i][j]==max) arr[i][j]=0;
         
     }

   static void changeTheArray(int[][] arr, int i, int j) {
       
       //change all the row elemnts
       for(int x=0 ; x<arr[0].length ; x++)
       {
           if(arr[i][x]==0) continue;
           arr[i][x]=max;
       }
       
        //change all the col elemnts
       for(int x=0 ; x<arr.length ; x++)
       {
           if(arr[x][j]==0) continue;
           arr[x][j]=max;
       }
       
     }
}
