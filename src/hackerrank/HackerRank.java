
package hackerrank;
 import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class HackerRank {
 
    public static String getSmallestAndLargest(String s, int k) 
    {
        String smallest = "";
        String largest = "";
        
       SortedSet<String>obj = new TreeSet<String>();
        for(int i=0 ; i<=s.length() -k  ; i++)
        {
            obj.add( s.substring( i , i+k)  );
        }
              smallest = obj.first();
              largest = obj.last();
              
        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}
    

