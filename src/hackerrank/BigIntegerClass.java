
package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerClass {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        String y = sc.next();
        
        BigInteger bg1 = new BigInteger(x);
        BigInteger bg2 = new BigInteger(y);
        
        bg1 = bg1.add(bg2);
        bg2  = bg2.multiply(new BigInteger(x));
        
        System.out.println(bg1);
        System.out.println(bg2);

 
    
         
    }
}
