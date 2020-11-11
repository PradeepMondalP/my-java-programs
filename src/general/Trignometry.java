
package general;

import java.util.Scanner;

public class Trignometry {
    
    public static void main(String[] args) {
        System.out.println("Eneter the degeree");
        Scanner obj = new Scanner(System.in);
        double degree = obj.nextDouble();
        
        double radians = Math.toRadians(degree);
        double sinValue = Math.sin(radians);
        double cosValue = Math.cos(radians);
        
        System.out.printf("cos %f is  =%f" ,degree , cosValue );
        System.out.println();
         System.out.printf("sin  %d is  =%f" ,(int)degree , sinValue );
    }
    
}
