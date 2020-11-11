
import java.io.*;
import java.util.*;

public class AddMatrix {
    
    static int rowCount=0 , colmCount=0 , size , count;
    static int arr[][];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-- >0)
        {
            size=0; count=0;
	    size=sc.nextInt();
	    arr=new int[size+1][size+1];
          
	  for(int i=1 ; i<=size ; i++)
	     for(int j=1 ; j<=size ; j++)
	         arr[i][j]=sc.nextInt();
          
          rowCount=rowCount();
            colmCount=colmCount();
            if(colmCount > rowCount)   //do transpose  n/2 + 1
            {
                  
                  System.out.println( checkColDifference()/2 +1 );
            }
            else   // without transpose n/2
            {
                   
                  System.out.println( checkColDifference()/2  );                                                         
            }
        }
    }

    private static int colmCount() {
        int count=0;
        for(int i=1 ; i<=size ; i++)
            for(int j=2 ; j<=size ; j++)
                if(arr[j][i]-arr[j-1][i]==1)
                    count++;
        return count;
    }

    private static int rowCount() {
        int count=0;
        for(int i=1 ; i<=size ; i++)
            for(int j=2 ; j<=size ; j++)
                if(arr[i][j]-arr[i][j-1]==1)
                    count++;
        return count;
    }
    
    public static int checkRowDifference()
    {
        int x=1 , count=0;
        for(int i=1 ; i<=size ; i++)
          for(int j=1 ; j<=size ; j++)
              if(arr[i][j]!=x++)
                   count++;
                 
        return count;
    }
    public static int checkColDifference()
    {
        int x=1 , count=0;
        for(int i=1 ; i<=size ; i++)
          for(int j=1 ; j<=size ; j++)
              if(arr[j][i]!=x++)
                   count++;
                 
        return count;
    }

//    private static void print() {
//        System.out.println("\n\n");
//        
//        for(int i=1 ; i<=size;i++){
//            for(int j=1 ; j<=size; j++)
//                System.out.print(arr[i][j]+" ");
//            System.out.println("\n");
//        }
//    }
}
