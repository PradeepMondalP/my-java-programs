
import java.math.BigInteger;
import java.util.*;


public class CatalanNumber {
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            int n = sc.nextInt();
            
            System.out.println(findCatalan(n));
        }
    }
    
     static BigInteger dp[] = new BigInteger[102];
     static int startPos=2;

public static BigInteger findCatalan(int n)
  {
        dp[0] = new BigInteger("1");
        dp[1] = new BigInteger("1");

        if(dp[n] !=null) return dp[n];

        for( ; startPos<=n ; startPos++)
        {
            BigInteger temp = new BigInteger("0");
            BigInteger total = new BigInteger("0");
            dp[startPos] = new BigInteger("0");
            
            for(int j=0 ; j<startPos/2 ; j++)
            {
               temp = dp[j].multiply(dp[startPos-j-1]) ;
               total = total.add(temp);
            }
            
            dp[startPos] = total.multiply(new BigInteger("2"));
            
            if(startPos%2==1){
                 temp = dp[startPos/2].multiply(dp[startPos/2]);
                 dp[startPos] = dp[startPos].add(temp);
            }
            
        }
        return dp[n];
   }
}
