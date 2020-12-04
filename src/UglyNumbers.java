
import java.util.*;


public class UglyNumbers {
    
    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0)
        {
            int n = sc.nextInt();
            
            System.out.println("result  "+ getNthUglyNo(n));
        }
    }
    
    //tle
    
        static long ugly[] = new long[10001];  // To store ugly numbers 
        static int i2 = 0, i3 = 0, i5 = 0; 
        static long next_multiple_of_2 = 2l; 
        static long next_multiple_of_3 = 3l; 
        static long next_multiple_of_5 = 5l; 
        static long next_ugly_no = 1l ;
        static int startPos=1;
         
        
    static long getNthUglyNo(int n) 
    { 
         ugly[0] = 1l;
         if(ugly[n-1]!=0) return ugly[n-1];
        
          
        for( ; startPos < n; startPos++) 
        { 
            next_ugly_no = (long) Math.min(next_multiple_of_2, 
                                  (long)Math.min(next_multiple_of_3, 
                                        next_multiple_of_5)); 
              
            ugly[startPos] = next_ugly_no; 
            
            if (next_ugly_no == next_multiple_of_2) 
            { 
               i2++; 
               next_multiple_of_2 = ugly[i2]*2; 
            } 
            if (next_ugly_no == next_multiple_of_3) 
            { 
               i3 ++; 
               next_multiple_of_3 = ugly[i3]*3l; 
            } 
            if (next_ugly_no == next_multiple_of_5) 
            { 
               i5 ++; 
               next_multiple_of_5 = ugly[i5]*5; 
            } 
        } 
        
        return next_ugly_no; 
    }
    
}
