
package general;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Pangram {
    public static void main(String[] args) {
        char []ch;
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a String :");
        String str = obj.nextLine().trim().toLowerCase();
        
        ch = str.toCharArray();
        Set set = new HashSet();
      
        for(int i=0;i<ch.length;i++)
             if(Character.isAlphabetic(ch[i]))
                 set.add(ch[i]);

        if(set.size() == 26)
            System.out.println("\n the String is pangram........");
        else
            System.out.println("\nnot a pangram");
     
    }
    
}
