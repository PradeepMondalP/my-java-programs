
import java.util.*;


public class TotalSetBitsCount {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(countSetBits(n));
    }
    
    public static int countSetBits(int n){
    
        if(n==0 || n==1) return n;
        int x = findNearestPowof2(n);
        
        int  btil2x   = x * ( 1 << (x-1));
        int  msb2xton = n - (1 << x) + 1  ;
        int rest =  n - (1<<x) ; 
        int ans = btil2x + msb2xton + countSetBits(rest);
        return ans;
    }
    
    static int findNearestPowof2(int n)
    {
        int x=0 ;
        while( (1<<x) <= n ) x++;
        
        return x-1; 
    }
}
