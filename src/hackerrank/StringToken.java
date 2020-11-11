
package hackerrank;

import java.util.Scanner;

public class StringToken {
    
    public static void main(String[] args) {
        
       
        String str = ""; 
        str = str.trim();
        if(str.equals(""))
        {
            System.out.println("0");
        }
        else
        {
           String[] arrOfStr = str.split("[! ,?._'@]+"); 
  
            System.out.println("Length = "+ arrOfStr.length);
            for (String a : arrOfStr) 
             System.out.println(a); 
           
        }
        
                
    }
}
