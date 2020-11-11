
package hackerrank;

import java.util.Scanner;


public class Regex1 { 
    
    public static void main(String[] args) {
        
        System.out.println("Entera string in format A.B.C.D");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();                              //false
        String []arr = s.split(".");
        boolean bl = false;
        
        for(String x : arr)
        {
            if(x.trim().length()>0)
            {
                int val  =Integer.parseInt(x.trim());
                if(val<0  &&  val>255){
                     System.out.println("fasle");
                     bl = false;
                     break;
                }
           }
            else
            {
                bl = false;
                System.out.println("false");
                break;
            }
        }
        
        if(bl)
            System.out.println("true");
    }
}

