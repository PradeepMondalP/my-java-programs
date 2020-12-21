
import java.util.Scanner;


public class DONATION {
    
    static int mod = (int)1e9+7 , size=1001 ,N=0 ,C=0 ,M=0;
    static long arr1[][] = new long[size][size] ,
               arr2[][] = new long[size][size] ,
               arr3[][] = new long[size][size];
    
    static void preSolve()
    {
        arr1[0][0]=1;arr2[0][0]=1;arr3[0][0]=1;
        
        // atleast 1 coin
        for(int n=1 ; n<size ; n++)
           for(int c=1 ; c<size ; c++)
           {
               arr1[n][c] = c * arr1[n-1][c] + arr1[n-1][c-1];
               arr1[n][c]%=mod;
           }
        
        // atleast 2 coin
        for(int n=2 ; n<size ; n++)
           for(int c=1 ; c<size ; c++)
           {
               arr2[n][c] = c * arr2[n-1][c] + (n-1)* arr2[n-2][c-1];
               arr2[n][c]%=mod;
           }
        
        // atleast 3 coin
        for(int n=3 ; n<size ; n++)
           for(int c=1 ; c<size ; c++)
           {
               arr3[n][c] = c * arr3[n-1][c] +   ((n-1)*(n-2))/2    * arr3[n-3][c-1];
               arr3[n][c]%=mod;
           }
    }
            
    public static void main(String[] args)throws java.lang.Exception {
        
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        
        preSolve();
        while(t-->0)
        {
            N=sc.nextInt() ; C = sc.nextInt(); M = sc.nextInt();
            if(M==1) System.out.println(arr1[N][C]);
            else if(M==2) System.out.println(arr2[N][C]);
            else System.out.println(arr3[N][C]);
        }
    }
}
