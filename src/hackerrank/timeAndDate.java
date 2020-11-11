
package hackerrank;

import java.time.LocalDate;
import java.util.Scanner;


public class timeAndDate 
{
    public static void main(String[] args) 
    {
        
        System.out.println("Enter the date");
        Scanner obj = new Scanner(System.in);
        String date = obj.next();
        System.out.println("Enter the Month");
        String month = obj.next();
        System.out.println("Enter the year") ;
        String year = obj.next();          
        System.out.println( gettingDay(date , month  ,year));
    }

    private static String gettingDay(String date, String month, String year) {
        int d = Integer.parseInt(date);
        int m = Integer.parseInt(month);
        int y = Integer.parseInt(year);
        
        LocalDate lt = LocalDate.of(y, m, d);
        return lt.getDayOfWeek().name();
        
      
    }
    
}
