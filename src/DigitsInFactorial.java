
//import java.math.BigInteger;


//import java.math.BigInteger;


public class DigitsInFactorial {
    
    public static void main(String[] args) {
        int n = 10108998;
       
        System.out.println( Math.floor(  Math.log10(n) ) +1  );
        //System.out.println(digitsInFactorial(n));
        
    }
    static int digitsInFactorial(int n) {
        
        // factorial exists only for n >= 0 
        if (n < 0) 
            return 0; 
   
        // base case 
        if (n <= 1) 
            return 1; 
   
        // else iterate through n and calculate the 
        // value 
        double digits = 0; 
        for (int i=2; i<=n; i++) 
        {
            double logVal = Math.log10(i); 
            digits += logVal;
        }
   
        return (int)(Math.floor(digits) ) +1;
    }
}
