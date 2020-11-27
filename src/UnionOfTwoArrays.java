
import java.util.Scanner;


public class UnionOfTwoArrays {
    public static void main (String[] args)
	 {
	     Scanner sc = new Scanner(System.in);
	     int t = sc.nextInt();
	     while(t-- >0)
	     {
	         int N = sc.nextInt() , M = sc.nextInt();
	         
	         int arr1[] = new int[N] , arr2[] = new int[M];
	         
	         for(int i=0 ; i<N ; i++) arr1[i] = sc.nextInt();
	         
	         for(int i=0 ; i<M ; i++) arr2[i] = sc.nextInt();
	         
	         System.out.println( findUnionCount(arr1 , arr2) );
	     }
	 }
	 
	 static int findUnionCount(int arr1[] , int arr2[])
	 {
	     int N = arr1.length , M = arr2.length;
	     int count=0;
	     
	     int max = 0;
	     for(int x : arr1) max = Math.max(max , x);
	     for(int x : arr2) max = Math.max(max , x);
	     
	     int dp[] = new int[max+5];
	     
	     
	     for(int i=0 ; i<N ; i++){
	         if(dp[ arr1[i] ]==0){
                     dp[ arr1[i] ]=1;
	             count++;
                 }
	            
	     }
	     
	     for(int i=0 ;i<M ; i++){
	         if(dp[ arr2[i] ]==0){
                     dp[ arr2[i] ]=1;
	             count++;
                 }
	            
	     }
	     
	     return count;
	 }
}
