
import java.util.Scanner;


public class SUMTRIAN {
    
 
    public static void main(String[] args) throws Exception {
        
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            int n = sc.nextInt() , maxV=0;
            int arr[][] = new int[n][n] ; 
            
            for(int i=0 ; i<n ; i++) 
               for(int j=0 ; j<=i ; j++) 
                  arr[i][j] = sc.nextInt();
            
            
            for(int i=n-1 ; i>0 ; i--)
            {
                for(int j=0 ; j<i ; j++)
                {
                    arr[i-1][j] += arr[i][j] > arr[i][j+1] ? arr[i][j] : arr[i][j+1];
                }
            }
            
            System.out.println(arr[0][0]);
        }
    }
}
