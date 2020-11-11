
import java.util.Scanner;


public class UniquePath62 {
    
    static int count=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m=sc.nextInt() , n=sc.nextInt();
        
        System.out.println(solve(m, n));
    }

   static int solve(int m, int n)
   {
        if(m==0 || n==0) return 0;
        int arr[][] = new int[m+1][n+1];
        arr[0][1]=1;
        
        for(int  i=1 ; i<=m ; i++)
           for(int j=1 ; j<=n ; j++)
               arr[i][j]= arr[i-1][j] +arr[i][j-1];
        
        return arr[m][n];
    }

}
