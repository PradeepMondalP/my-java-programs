
package gangsofwasypur;

import java.util.Scanner;

public class FloydsTriangle {
    
    public static void main(String[] args) {
        Scanner obj = new Scanner(System.in);
        int n = obj.nextInt();
        System.out.println("********************");
        int x = 1;
        for(int i = 0 ; i<n ;i++){
            for(int j = 0 ; j<= i ; j++,++x)
                System.out.print(" "+ x);
            
            System.out.println();
        }
    }
}
