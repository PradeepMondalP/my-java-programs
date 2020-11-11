
package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Anagrams {
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram( a , b );
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
        
        

    }

  //  private static boolean isAnagram(String a, String b) {
//        
//       char []a1 = a.trim().toLowerCase().toCharArray();
//       char []a2 = b.trim().toLowerCase().toCharArray();
//       Arrays.sort(a1);
//       Arrays.sort(a2);
//       if(Arrays.equals(a1, a2))
//            return true;
//       else
//           return false;

static boolean isAnagram(String a, String b) {
            String A = a.toUpperCase();
            String B = b.toUpperCase();
            if(A.length()!=B.length()) return false;
            int[] c = new int[26] , d = new int[26];
            try{
                for(int i=0;i<A.length();i++)
                {
                  c[A.charAt(i)-'A']++;
                  d[B.charAt(i)-'A']++;
                }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
                for(int i=0;i<=26;i++)
                {
                   if(c[i]!=d[i])
                      return false;
                }
           }
         return true;
    }
}
