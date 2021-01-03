
package input;

import java.util.*;

public class WithArrayWithTC {
    
    public static void main(String[] args)throws java.lang.Exception {
        
        try {
            Scanner sc = new Scanner (System.in);
            int t = sc.nextInt();
            while(t-->0)
            {
                int n = sc.nextInt();
                int arr[] = new int[n];

                for(int i=0 ;i<n ; i++) arr[i] =sc.nextInt();


            }
        } catch ( Exception e ) { }
    }
    
    // gcd
    static int gcd(int a , int b)
    {
        if(a==0) return b;
        if(b==0) return a;
        if(a>b) return gcd(a%b, b);
        return gcd(a, b%a);
    }
}
