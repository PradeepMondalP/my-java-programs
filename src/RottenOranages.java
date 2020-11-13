
import java.util.*;


public class RottenOranages {
   public static void main (String[] args)
	 {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while(t-- >0)
	    {
	        int r = sc.nextInt() , c = sc.nextInt();
	        int arr[][] = new int[r][c];
	        
	        for(int i=0 ; i<r ; i++)
	            for(int j=0 ; j<c ; j++)
	                arr[i][j] = sc.nextInt();
	                
	       int x= solve(arr) ;
	       System.out.println(x);
	    }
	 }
	 
	 static int solve(int arr[][])
	 {
	     int row = arr.length , col = arr[0].length;
	     Queue<int[]>rottenQue = new LinkedList<int[]>();
	     int fresh=0 , time=0 , x , y;
	     
	     for(int i=0 ; i<row ; i++)
	       for(int j=0 ; j<col ; j++)
	        {
	            if(arr[i][j]==1) fresh++;
	            else if( arr[i][j]==2 ) rottenQue.add(new int[]{i , j});
	        }
	     
	     while(!rottenQue.isEmpty() )
	     {
	         int size = rottenQue.size();
	         for(int i=0 ; i<size ; i++)
	         {
	             x = rottenQue.peek()[0];   y = rottenQue.peek()[1];
	             rottenQue.poll();
	             
	             for(int k=0 ; k<4 ; k++)
	             {
	                 if( isSafe(arr ,x+xAxis[k], y+yAxis[k] ) )
	                 {
	                     fresh--;
	                     rottenQue.add(new int[]{x+xAxis[k], y+yAxis[k]} );
	                     arr[x+xAxis[k]] [y+yAxis[k]] =2;
	                 }
	             }
	         }
	         if(!rottenQue.isEmpty())  time++;
	         
	     }
	     return fresh==0 ? time : -1;
	     
	 }
	 
	 static int xAxis[] = {0 , -1 ,0 ,1 };
	 static int yAxis[] = {-1 , 0 ,1 ,0 };
	 
	 static boolean isSafe(int arr[][]  , int x , int y)
	 {
	     return ( x>=0 && x<arr.length && y>=0 && y<arr[0].length && arr[x][y]==1 );
	 }
}
