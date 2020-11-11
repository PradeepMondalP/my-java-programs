
package alldatastructure.nqueen;

import java.util.ArrayList;

public class NQueen_2 {
    
    static boolean arr[][] ;
    static int N , MIN = 0 , MAX ;
    static ArrayList stack ;
    
    public static void main(String[] args) {
        N = 4;
        MAX = N-1;
        
        for(int i=0 ; i<N ; i++)
        {
            arr = new boolean[N][N];
            stack = new ArrayList();
            
            arr[0][i] = true;
            stack.add(i) ;
            get(1 , stack , arr);
          //    System.out.println(" ............displaying ARRRAY...................................");
               
            
             stack.clear();
        }
    }

    private static void get( int currRow , ArrayList list , boolean arr[][])
    {
        ArrayList temp = new ArrayList(list);       
        if(currRow==N-1)  return;
        
        System.out.println("listXX is  "+list );
        
        
         if(list.size()==N){
          //   temp.stream().map( i -> stack.add(i));
             System.out.println("complete list  =  "+ stack);
             display(arr);
             return;
         }         
         
         for(int colum= 0 ; colum<N ; colum++)
         {
              if(list.contains(colum))
                  continue;
             
              if( ! checkExistence(currRow , colum  , temp , arr ) )
              {
                  temp = new ArrayList(list);
                  temp.add(colum);
                  arr[currRow][colum] = true;
                 
                  get( currRow+1 ,temp ,arr);
                  
                  
                //  return;
              }
         }
         
         
       
    }

    private static boolean checkExistence( int currRow, int colum  , ArrayList temp , boolean [][]arr) {
       
        if(colum==MIN)
        {
             if(temp.contains(colum))
                  return true;
             else
                if(arr[currRow-1][colum+1])
                       return true;
                else
                  return false;
                
        }
        if(colum==MAX)
        {
            if(temp.contains(colum))
                return true;
            else
                if(arr[currRow-1][colum-1])
                    return true;
                else
                   return false;
                
        }
        
     //    display();
        
        if( arr[currRow-1][colum+1] || 
                arr[currRow-1][colum-1] )
                 return true;
        else
            return false;
        
    }
    
    public static void display(boolean  [][]arr)
    {
        for(int i = 0 ; i<N ; i++)
        {
            for(int j = 0 ; j<N ; j++)
            {
                System.out.print("  "+ arr[i][j]);
            }
            System.out.println();
        }
        
        System.out.println("\n\n");
    }
}
