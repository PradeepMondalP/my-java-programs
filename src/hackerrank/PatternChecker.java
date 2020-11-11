
package hackerrank;

import java.util.Scanner;
import java.util.regex.*;

public class PatternChecker {
    
    public static void main(String[] args) {
        
        	Scanner in = new Scanner(System.in);
                String x = in.nextLine();
                x = x.trim();
               
                  if(x.length()>0)
                  {
                        try{
                Pattern p = Pattern.compile(x);
                    System.out.println("valid");
                }
                catch(PatternSyntaxException e)
                {
                    System.out.println("invalid");
                    System.out.println(e.getMessage());
                }
                  }
                  else
                      System.out.println("hmm");
               
    }
}
