
package sample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class HEProblem1 {
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
         String N = br.readLine();

         long out_ = solve(N);
         System.out.println(out_);

         wr.close();
         br.close();
        
    }
     static long solve(String N){
        long count=0 ;
        long x = Long.parseLong(N);
        int num ;

        for(int i = 0 ; i<=x ; i++)
        {
               for(int j = 0 ; j<=x ;j++)
            {
                if(i==j)  continue;
                 num = i+j;
                if(isPrime(num))
                    count++;
            }
        }
        return (count/2 )%1000000007;
        
    }
     public static boolean isPrime(int num)  // n 
    {
        if(num==0 || num==1) return false;
        for(int i = 2; i<num ; i++)
            if(num%i == 0) return false;
        return true;    
    }
}
