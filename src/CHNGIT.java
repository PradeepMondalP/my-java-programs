
import java.util.Arrays;
import java.util.Scanner;

public class CHNGIT {
     public static void main(String[] args)throws java.lang.Exception {
        
        try {
            Scanner sc = new Scanner (System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
                int n = sc.nextInt() , maxVal=0 , maxCount=0;
                int arr[] = new int[n];
                int dp[] = new int[n];

                for(int i=0 ;i<n ; i++){
                     arr[i] =sc.nextInt();
                  //   temp[arr[i]]++;
                }
                Arrays.sort(arr);
                
                dp[0] =1;
                maxCount=1;
                for(int i=1 ; i<n ; i++)
                {
                    if(arr[i]==arr[i-1])
                        dp[i]=1+dp[i-1];
                    else
                        dp[i]=1;
                    
                    maxCount = Math.max(dp[i], maxCount);
                }
               
                System.out.println(n-maxCount);
            }
        } catch ( Exception e ) { }
    }
}
