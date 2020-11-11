
package decoding;

import java.util.Scanner;


public class Program_1 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String val = "MATH";
        char arr[] = val.toCharArray();
        char arr2[] = new char[arr.length];
        
        for(int i = 0 ;i<arr.length  ; i++ ){
         arr2[i] = (char)( (90-(int)arr[i])+65  ) ;
        }
        
    }
}
