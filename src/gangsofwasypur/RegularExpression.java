
package gangsofwasypur;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegularExpression {
    
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);
       String s = sc.next();
       String p = sc.next();
       System.out.println(Pattern.matches(p , s));
    }
}
