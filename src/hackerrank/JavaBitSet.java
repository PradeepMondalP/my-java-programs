
package hackerrank;

import java.util.BitSet;
import java.util.Scanner;


public class JavaBitSet {
    
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();
       int M = sc.nextInt();
       BitSet B1 = new BitSet(N);
       BitSet B2 = new BitSet(N);
       
      while(M>0)
       {
           String op = sc.next();
           int x = sc.nextInt();
           int y = sc.nextInt();
           
           
           if(op.equals("AND"))
           {
                 if(x==1)  B1.and(B2);
                 else      B2.and(B1);
           }
           else   if(op.equals("OR"))
           {
                 if(x==1)  B1.or(B2);
                 else      B2.or(B1);
           }
           else   if(op.equals("XOR"))
           {
                 if(x==1)  B1.xor(B2);
                 else      B2.xor(B1);
           }
           else   if(op.equals("SET"))
           {
                 if(x==1)  B1.set(y);
                 else      B2.set(y);
           }
           else   if(op.equals("FLIP"))
           {
                 if(x==1)  B1.flip(y);
                 else      B2.flip(y);
           }
          
           System.out.println(B1.cardinality() +" " + B2.cardinality());
           
          M--;
       }
    }
}
