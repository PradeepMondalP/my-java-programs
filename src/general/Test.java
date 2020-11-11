
package general;
import java.util.*;
import java.math.*;

public class Test {
     
    static int K,N;
    public static void main(String[] args) {
        
       String s="abcdef";
       solve(s);
        
    }
    public static void solve(String s)
    {
        
    }
    
  
  public static int mincostTickets(int[] days, int[] costs) 
    {
    
        int n = days[days.length - 1];
        Set<Integer> set = new HashSet<>();
        int[] amount = new int[n+1];
        for(int day : days) 
            set.add(day);
        
        amount[0] = 0;
        for(int i=1; i<=n; ++i) {
            if(set.contains(i)) {
                int min = amount[i-1] + costs[0];
                min = Math.min(min, (i < 7 ? 0 : amount[i-7] ) + costs[1]);
                min = Math.min(min, (i < 30 ? 0 : amount[i-30]) + costs[2]);
                amount[i] = min;
            } else {
                amount[i] = amount[i-1];
            }
        }
        return amount[n];
    }
    
    
}




