
package hackerrank;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/*
In this challenge, we use regular expressions (RegEx) to remove instances of words that are repeated more than once, but retain the first occurrence of any case-insensitive repeated word. For example, the words love and to are repeated in the sentence I love Love to To tO code. Can you complete the code in the editor so it will turn I love Love to To tO code into I love to code?

To solve this challenge, complete the following three lines:

Write a RegEx that will match any repeated word.
Complete the second compile argument so that the compiled RegEx is case-insensitive.
Write the two necessary arguments for replaceAll such that each repeated word is replaced with the very first instance the word found in the sentence. It must be the exact first occurrence of the word, as the expected output is case-sensitive.
Note: This challenge uses a custom checker; you will fail the challenge if you modify anything other than the three locations that the comments direct you to complete. To restore the editor's original stub code, create a new buffer by clicking on the branch icon in the top left of the editor.

Input Format

The following input is handled for you the given stub code:

The first line contains an integer, , denoting the number of sentences.
Each of the  subsequent lines contains a single sentence consisting of English alphabetic letters and whitespace characters.

Constraints

Each sentence consists of at most  English alphabetic letters and whitespaces.
Output Format

Stub code in the editor prints the sentence modified by the replaceAll line to stdout. The modified string must be a modified version of the initial sentence where all repeat occurrences of each word are removed.

Sample Input

5
Goodbye bye bye world world world
Sam went went to to to his business
Reya is is the the best player in eye eye game
in inthe
Hello hello Ab aB
Sample Output

Goodbye bye world
Sam went to his business
Reya is the best player in eye game
in inthe
Hello Ab


Explanation

We remove the second occurrence of bye and the second and third occurrences of world from Goodbye bye bye world world world to get Goodbye bye world.
We remove the second occurrence of went and the second and third occurrences of to from Sam went went to to to his business to get Sam went to his business.
We remove the second occurrence of is, the second occurrence of the, and the second occurrence of eye from Reya is is the the best player in eye eye game to get Reya is the best player in eye game.
The sentence in inthe has no repeated words, so we do not modify it.
We remove the second occurrence of ab from Hello hello Ab aB to get Hello Ab. It's important to note that our matching is case-insensitive, and we specifically retained the first occurrence of the matched word in our final string.
*/

public class DuplicateWordProblem {
    

    public static void main(String[] args) {
       
        String []str;
        int n , j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter how many string  (size array)");
        n = sc.nextInt();
        str = new String[n];
        sc.nextLine();
        
        for(int i =0 ; i<n ; i++)
              str[i] = sc.nextLine();
        
        for(int i = 0 ;i<n ; i++)
        {
            Set<String> list = new LinkedHashSet();
            String s = str[i];
            String splitStr[] = s.split(" ");
            
            for( j = 0 ; j< splitStr.length -1 ; j++ )
            {
               String x = splitStr[j].toLowerCase();
               String y = splitStr[j+1].toLowerCase();
               System.out.print("x="+x   +" \t y = "+ y +"\n");
                 
                if(x.equals(y))
                      {
                       list.add(splitStr[j]); 
                       j++;
                          System.out.println(list);
                      }
                    else
                   {
                    list.add(splitStr[j]);
                 
                       System.out.println(list);
                   }
             }
            
            System.out.println("value of j is "+ j);
            
            int lastIndex = j--;
            int prevLastIndex = lastIndex-1;
            String a = splitStr[prevLastIndex].trim().toLowerCase();
            String b = splitStr[lastIndex].trim().toLowerCase();
           
            if(!a.equals(b))
                 list.add(b);
              
            list.forEach((str2) ->  System.out.print(str2 +"   ") );
            list.clear();
            System.out.println();
        }
        j = 0;
    } 
    
    public static boolean stringComparision(String a , String b) {
        
        String x = a.trim().toLowerCase();
        String y = b.trim().toLowerCase();
        if(x.equals(y))
             return true;
        return false;
    }
}

