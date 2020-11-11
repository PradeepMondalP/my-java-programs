
package hackerrank;

import java.util.Scanner;


public class TwoDArray {
    
    public static void main(String[] args) {
        
        int sum = Integer.MIN_VALUE;
        int arr[][] = new int[6][6] ;
        Scanner obj = new Scanner(System.in);
        
        for(int i = 0 ; i<6 ; i++)
         for(int j = 0 ; j<6 ; j++)
         {
             int num =obj.nextInt();
             if(num>=-9  && num<=9)
                 arr[i][j] = num;
         }
            
        
       
             for(int i = 0 ; i<4 ; i++)
          {
            for(int j = 0 ; j<4 ; j++)
            {
                int tempSum  = arr[i][j]      +
                               arr[i][j+1]    +
                               arr[i][j+2]    +
                               arr[i+1][j+1]  +
                               arr[i+2][j]    +
                               arr[i+2][j+1]  + 
                               arr[i+2][j+2];
                if(sum<tempSum){
                    sum = tempSum;
                  //  System.out.println("i value = "+i +"   j val = "+ j);
                  //  System.out.println("max sum is "+ sum);
                }
            }
         }
           System.out.println( sum);
        
    }
}
