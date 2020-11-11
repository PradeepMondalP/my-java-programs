
package hackerrank;

import java.util.Arrays;
import java.util.Scanner;


public class CutSticks {
    
    public static void main(String[] args)  {
       Scanner sc = new Scanner(System.in);
       
       int n = sc.nextInt();
       int arr[] = new int[n];
       for(int i=0 ; i<n ; i++)
           arr[i] = sc.nextInt();

       Arrays.sort(arr);
       int start=0 , count=0 , min=0;

       while(arr[n-1]!=0)
       {
           count=0; min=arr[start];
          for(int i=start ; i<n ; i++)
          {
              if(arr[i]-min >=0)
              {
                  count++;
                  arr[i] = arr[i] - min;
                  if(arr[i]==0)  start=(i+1)%n;
              }
          }
          min=arr[start];
          System.out.println(count);
       }    
    }
}
