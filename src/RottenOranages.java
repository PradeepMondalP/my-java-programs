
import java.util.*;


public class RottenOranages {
    
     final static int R = 3;
     final static int C = 5;
     
     //to check all 4 directions
     static int xAxis[] = {0 , -1 ,0 ,1 };
     static int yAxis[] = {-1 , 0 ,1 ,0 };
     
   public static void main (String[] args)
	 {
	    int arr[][] = { {2, 1, 0, 2, 1},
                        {1, 0, 1, 2, 1},
                        {1, 0, 0, 2, 1}};
            int ans = rotOranges(arr);
           if(ans == -1)
            System.out.println("All oranges cannot rot");
            else
            System.out.println("Time required for all oranges to rot = " + ans);
	 }
	 
	 
	 static int rotOranges(int arr[][])
	 {
	     Queue<int[]>rottenQue = new LinkedList<int[]>();
	     int fresh=0 , time=0 , x , y;
	     
             /*
             counting all fresh oranges
             adding rotten orange positions
             */
	     for(int i=0 ; i<R ; i++){
                 for(int j=0 ; j<C ; j++)
	        {
	            if(arr[i][j]==1) fresh++;
	            else if( arr[i][j]==2 ) rottenQue.add(new int[]{i , j});
	        }
             }
	       
	    //traversing untill our que is not empty 
	     while(!rottenQue.isEmpty() )
	     {
	         int size = rottenQue.size();
	         for(int i=0 ; i<size ; i++)
	         {
                     // getting current rotten orange position and Dequing
	             x = rottenQue.peek()[0];   y = rottenQue.poll()[1];
                     
                /* once we find a Rotten oranges position which has fresh orange
                   (i) we add the fresh orange position in the que
                   (ii) reducing fresh orange count by 1 
                   (iii)marking  fresh orange position as 2,  in the array
                */
	             for(int k=0 ; k<4 ; k++)
	             {
                         // check the validation of neighbour
	                 if( isSafe(arr ,x+xAxis[k], y+yAxis[k] ) )
	                 {
	                     fresh--;
	                     rottenQue.add(new int[]{x+xAxis[k], y+yAxis[k]} );
	                     arr[x+xAxis[k]] [y+yAxis[k]] =2;
	                 }
	             }
	         }
                 // if queue is not empty , more time need
	         if(!rottenQue.isEmpty())  time++;
	         
	     }
             //checking : all fresh oranges are rotten or not
	     return fresh==0 ? time : -1;
	     
	 }
	 
         /*
         checking valid x,y cordinate &
          fresh oranges
         */
	 static boolean isSafe(int arr[][]  , int x , int y)
	 {
	     return ( x>=0 && x<arr.length && y>=0 && y<arr[0].length && arr[x][y]==1 );
	 }
}


/*

 // C++ program to find minimum time required to make all
// oranges rotten
#include <bits/stdc++.h>
#define R 3
#define C 5
using namespace std;

//to check all 4 directions
int xAxis[] = { 0, -1, 0, 1 };
int yAxis[] = { -1, 0, 1, 0 };

bool isSafe(int arr[R][C], int x, int y)
{
    return (x >= 0 && x < R && y >= 0 && y < C
            && arr[x][y] == 1);
}

public
int rotOranges(int[R][C] arr)
{

    int fresh = 0, time = 0, x, y;
    queue<pair<int, int> > rottenQue;

    for (int i = 0; i < R; i++)
        for (int j = 0; j < C; j++) {
            if (arr[i][j] == 1)
                fresh++;
            else if (arr[i][j] == 2)
                rottenQue.push({ i, j });
        }

    while (rottenQue.size() > 0) {
        int size = rottenQue.size();
        for (int i = 0; i < size; i++) {
            x = rottenQue.front().first;
            y = rottenQue.front().second;
            rottenQue.pop();            

            for (int k = 0; k < 4; k++) {
                if (isSafe(arr, x + xAxis[k],
                           y + yAxis[k])) {
                    fresh--;
                    rottenQue.push({x + xAxis[k], y + yAxis[k] });
                    arr[x + xAxis[k]][y + yAxis[k]] = 2;
                }
            }
        }
        if (rottenQue.size() > 0)
            time++;
    }
    return fresh == 0 ? time : -1;
}

// Driver program
int main()
{
    int arr[][C] = { { 2, 1, 0, 2, 1 },
                     { 1, 0, 1, 2, 1 },
                     { 1, 0, 0, 2, 1 } };
    int ans = rotOranges(arr);
    if (ans == -1)
        cout << "All oranges cannot rotn";
    else
        cout << "Time required for all oranges to rot => "
             << ans << endl;
    return 0;
}

*/