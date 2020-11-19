
import java.util.Arrays;

/*
* count all the numbers <= N  which has Exactly 3 divisors
*/
public class Exactly3Divisors {
    
    public static void main(String[] args) {
        
        int n= 10;
        System.out.println(exactly3Divisors(n));
        
    }
    
    
    static int exactly3Divisors(int N)
    {
        int count=0;
        
        N =(int) Math.sqrt(N);
        
        // applying sieve method to get all the prime number between 2 - N
        boolean arr[] = new boolean[N+1];
        
        // initializing my entire array to  true
        Arrays.fill(arr , true);
        
        for(int p=2 ; p*p <= N ; p++)
        {
             if( arr[p])
             {
                 for(int i=p*p ; i<=N ; i+=p)  
                      arr[i] = false;
             }
        }
        
        
        // counting the primes
        for(int i=2 ; i<=N ; i++)
        {
            if( arr[i]  )  count++;
        }
        return count;
    }
}
