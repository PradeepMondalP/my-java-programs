
package hackerrank;

import java.util.Scanner;

// split the string based on the alphabetical order......
//   trim() removes the whiteSpace  at the begining and ending of the string  .....

public class StringSperation {
    
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in) ;
        System.out.println("Enetr a String") ;
        String s = obj.nextLine();
        String ar[] = s.split("[ ^a-zA-z ]");
        
        System.out.println(ar.length);
        for(String p: ar)
            System.out.println(p);

//     s= s.trim();
//        System.out.println(0);
//        System.out.println(s);
    }
    
}
