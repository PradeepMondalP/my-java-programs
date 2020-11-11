package hackerrank;

import java.util.Scanner;

public class OneDArray_2 {

    static int x = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }

    private static boolean canWin(int leap, int[] game) {

        int startPos = 0;
        int x = search(leap, game , startPos);
        if (x > 1) {
            return true;
        }
        return false;
    }

   /*
    
     private static int search (int leap, int[] game, int start) {
        int size = game.length - 1;
        if ((start + leap >= size - 1 || start == size - 1) && (game[size - 1] == 0)) {
            x++;
            System.out.println("returning 1 now  value of x is and also came to the end point" + x);
            return 1;
        } else {
            game[start] = 1;
            if ((start + leap <= size - 1) && (game[start + leap] != 0)) {
                if (start > 1 && (game[start - 1] == 0)) {
                    x++;
                    System.out.println("<-------back tracking");
                    System.out.println("x value is " + x);
                    return search(leap, game, start - 1);

                } else if (game[start + 1] == 0) {
                    x++;
                    System.out.println("moving forward-------->") ;
                    System.out.println("x value is " + x) ;
                    return search(leap, game, start + 1) ;
                }

            } else if (( start + leap <= size - 1 ) && (game[start + leap] == 0)) 
            {         // little issues here
                x++;
                System.out.println("moving to lucky number direct");
                System.out.println("x value is " + x);
                return search(leap, game, start + leap);
            }

        }
        return 0;

    }
    
    */

    private static int search(int leap, int[] game, int startPos) {
        
        if(startPos>=game.length-1)
             return 1;
        else
        {
              if(game[startPos]!=0)
              {
                  game[startPos] = 1;
                   
        }
        return -1;
    }

}
}
