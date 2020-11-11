/*
 5
Goodbye bye bye World World world game
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe
Hello hello Ab aB
Sample Output

Goodbye bye world game
Sam went to his business
Reya is the best player in eye game
in inthe
Hello Ab
 */
package hackerrank;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class DuplicateWordProblem2 {
    
    public static void main(String[] args) {
        
        int N;
        String str[];
       Scanner sc = new Scanner(System.in);
     //   System.out.println("Enter how many string  (size array)");
        N = sc.nextInt();
        str = new String[N];
        sc.nextLine();
        
        for(int i =0 ; i<N ; i++)
              str[i] = sc.nextLine();
        
        System.out.println("\n\n");
        
        for(String temp : str)
        {
            String output = stringComparision(temp);
            String output2 = stringComparision(output);
            System.out.println(output2 );
          
        }
    }
    
    
    public static boolean compare2String(String a , String b)
    {
        a = a.trim().toLowerCase();
        b = b.trim().toLowerCase();
        if(a.equals(b))
             return  true;
        
        return false;
    }
    
    public static String stringComparision(String str)
    {
        Set<String> list = new LinkedHashSet<>();
                
        String []splitArray = str.split(" ");
        for(int i = 0 ; i<splitArray.length ; i++)
        {
            try
            {
                 String a = splitArray[i];
                 String b = splitArray[i+1];
             
             if(compare2String(a, b)  )  // both same
             {
                 list.add(a);
                 i++;
             }
             else 
             {
                 list.add(a);
             }
            }
            catch(ArrayIndexOutOfBoundsException e)
            {
          //      System.out.println("i value = "+ i);
                String a = splitArray[i-1];
                String b = splitArray[i];
                if(! compare2String(a, b))  // not same element with prev element
                {
                     if( ! list.contains(b))
                     {
                  //       System.out.println("hii");
                         list.add(b);
                     }
                }
            }
        }
        
        return list.toString().trim().replace("[", "").replace("]", "").replace(",", "");
    }
    
}

