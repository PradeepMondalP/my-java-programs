
package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;


public class SumProblem {
    
    static  BigInteger sum = new BigInteger("0");
    static  BigInteger x1,x2 ;
    
    public static void main(String[] args) 
  {
    System.out.print("Enetr a num :");
    addValues(new Scanner(System.in).nextInt());
    StringBuilder str ;
    String x ;
    
    for(BigInteger bi = x1; bi.compareTo(x2)<=0; bi=bi.add(new BigInteger("9"))) {
        str = new StringBuilder(bi+"");
        x   = str.reverse().toString();
        if(x.equals(bi+"") && !x.contains(0+"") )
            sum=sum.add(bi);
      }
      System.out.print(" = "+ sum);
  }

    private static void addValues(int n) {
        StringBuilder x = new StringBuilder(1+""); //for appending zeros 0 get lowval and high val
        StringBuilder y = new StringBuilder(1+"");
        for(int i=1 ; i<=n;i++)
        {
            x.append(0+"");
            if(i==n)continue;
            y.append(0+"");
        }
       x1 = new BigInteger(y.toString()).add(new BigInteger("8"));
       x2 = new BigInteger(x.toString());
    }
}
