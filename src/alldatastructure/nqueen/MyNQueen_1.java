
package alldatastructure.nqueen;

import java.util.ArrayList;

public class MyNQueen_1 {
    
    static ArrayList<Integer> stack = new ArrayList();
     
    static int n = 4;
    
    public static void main(String[] args) {
        
        boolean arr[][];
        
       for(int i = 0 ;i<n ; i++)
       {
            System.out.println(i+1 +"   time calling from main");
            stack.clear();
            arr = new boolean[n][n];
                  
            arr[0][i] = true;
            stack.add(i) ;
            
            get(arr ,1);
            System.out.println("list = "+ stack);
            
        }
    }

    private static void get(boolean[][] arr, int curRow) {
        
        if( curRow == n  )   return;
        
        for(int j = 0 ;j<n ;j++)
            {
               
                
                if(  (j+1>n)||(j-1)<0  ||   
                     stack.contains(j)  ||(arr[curRow-1][j+1] ) ||(arr[curRow-1][j-1])==true  ) 
                       {
                         arr[curRow][j] = false;
                         System.out.println("make false");
                       }
                else
              {
                  System.out.println(".........else.........");
                  stack.add(j);
                  arr[curRow][j] = true;
                  get(arr, curRow+1);
              }
            }
    }
}
