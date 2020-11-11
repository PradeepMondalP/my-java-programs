
package hackerrank;

import java.util.Scanner;

public class PalindromeSTring {
    public static void main(String[] args) {
        
        System.out.println("Enter a STring");
        Scanner sc = new Scanner(System.in);
        
        String A = sc.next();
        
        StringBuffer buf = new StringBuffer(A);
       buf.reverse();
        
        if(A.equals(buf.toString()))
        {
            System.out.println("Palindrome");
        }
        else
            System.out.println("Not Palindrome");
}
}
