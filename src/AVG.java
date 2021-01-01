
import java.util.Scanner;


public class AVG {
    public static void main(String[] args)throws java.lang.Exception {
        
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int n = sc.nextInt() ,  k = sc.nextInt() , v= sc.nextInt();
            long sum=0;
            int arr[] = new int[n];
        
            for(int i=0 ;i<n ; i++){
                arr[i] =sc.nextInt();
                sum+=arr[i];
            } 
            
            System.out.println(solve(n , k , v , sum));
            
        }
    }

    private static long solve(int n, int k, int avg, long sum) {
        
        long totalSum = (n+k) * avg;
        if(sum > totalSum) return -1;
        long remainSum = totalSum - sum;
        
        if(remainSum%k ==0 || remainSum>0) 
        return remainSum/k;
        
        return -1;
    }
}
