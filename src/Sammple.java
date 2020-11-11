
import java.util.*;
public class Sammple {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int large = sc.nextInt() , small = sc.nextInt();
        
        System.out.println(divide(large, small));
    }
    
    static int divide(int dividend, int divisor) {
        
        if(dividend==0) return 0;
        if(divisor==1) return dividend; 
        if(divisor==0 ) return Integer.MAX_VALUE;
        if(divisor==-1 && dividend==Integer.MIN_VALUE)  return Integer.MAX_VALUE;
        
        int a = Math.abs(dividend) , b=Math.abs(divisor) , quot=0;
        while(a-b >=0)
        {
            int pow=0;
            while( a- (b<<pow) >=0  ) pow++;
            
            int temp = 1<<(pow-1);
            quot+=temp;
            a-= b*temp ;
        }
        return dividend>0 && divisor>0 ? quot : -quot;
        
    }
}
