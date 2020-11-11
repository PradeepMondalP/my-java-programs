
package hackerrank;

import java.util.*;


public class MissingNumber {
    
     static  Scanner sc = new Scanner(System.in);
     
     public static void main(String[] args)  {
        
        int min= Integer.MAX_VALUE  , max = Integer.MIN_VALUE , m ;
        int n ,i=0 , j=0, sum1=0 , sum2=0;

        Set<Integer>set = new TreeSet<>(); 
         m=sc.nextInt();
         int arr1[]= new int[m+1];
         for(int x=0 ; x<m ; x++)   arr1[x]= sc.nextInt();

         n=sc.nextInt();
         int arr2[]= new int[n+1];
         for(int x=0 ; x<n ; x++){
             arr2[x]= sc.nextInt();
             if(arr2[x]>max ) max=arr2[x];
             if(arr2[x]< min)  min = arr2[x];
         }

         if(max-min<=100 && m>=1 && m<=n)
         {
             Arrays.sort(arr2);
             Arrays.sort(arr1);
              while(j!=n-1){
                  sum1+=arr1[i];
                  sum2+=arr2[j];
                  if(sum1==sum2){
                      i++; j++ ; continue;
                  }
                  sum1-=arr1[i];   sum2-=arr2[j];
                   set.add(arr2[j]);
                   j++;
              }
              System.out.println("i ="+i +"  j  :"+j);
             if(i==m){
                  while(j<=n){
                  set.add(arr2[j]);
                  j++;
              }
             }
             set.remove(0);
             for(int z : set)
               System.out.print(z+" "); 
         }   
            

    }
}
