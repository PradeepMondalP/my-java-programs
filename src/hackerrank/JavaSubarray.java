
package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class JavaSubarray {
    
    public static void main(String[] args) {
        
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        int arr[]  = new int[n+1];
        List<Integer> list = new ArrayList<>();
        
        for(int i = 1 ; i<= n ; i++)
            arr[i] = obj.nextInt();
        
        int i=0 , j=0 , k=0 , l=0 , m=0 , sum=0;
      
        
        for( i =1 ; i<=n ; i++ )
        {
            sum=0;
            sum= arr[i];
            System.out.println("...............new arr[i]///////////// = " + sum);
            if((sum<0))  { list.add(sum);
                              System.out.println("adding..............................");}
            
            
            for(j=i ; j<n ; j++)
            {
                 for(k = j+1 ; k<=n  ; k++)
                 {
                      if(k>6)   continue;
                      else
                      {
                          sum+=arr[k];
                          System.out.println( "a[k]  " + arr[k] ) ;
                          System.out.println("sum is :"+sum);
                          if((sum<0)) { list.add(sum);
                              System.out.println("adding..............................");}
                      }
                          
                 }
                 sum= arr[i];
            }
        }
          
        
        System.out.println("list is : "+ list);
        System.out.println(list.size());
   }
    
    
    
    
    /*
    
      best solutions
    
       Scanner sc = new Scanner(System.in);
    int length = sc.nextInt();
    int[] arr = new int[length];

    int first = sc.nextInt();
    arr[0] = first;
    int count = first < 0 ? 1 : 0;

    for (int i = 1; i < length; i++){
        int num = sc.nextInt();
        arr[i] = arr[i - 1] + num;

        if (arr[i] < 0){
            count++;
        }

        for (int j = 0; j < i; j++){
            int sub_result = arr[i] - arr[j];
            if (sub_result < 0){
                count++;
            }
        }
    }

    System.out.print(count);
    
    */
}
