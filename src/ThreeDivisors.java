
import java.util.*;


public class ThreeDivisors {
    
 public static void main (String[] args)
    {
       Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        while(t-->0)
        {
            long n = sc.nextLong();
            System.out.println(solve(n) );
        }
    }
	 
    static long solve(long n)
    {
        long   count=0;
        
        
        boolean prime[] = new boolean[(int)n+1];
        Arrays.fill(prime, true);
        prime[0]=prime[1]=false;
        
        for( long i = 2; i * i <= n; i++ )
	    {
                if( prime[(int)i] == true )
                {
                    if( i * i > n ) break ;
                    count++;
                    for(long j=i*i; j<=n; j += i )
                       prime[(int)j] = false ;
                }
	    }
	  return count ;
    } 
    
}
