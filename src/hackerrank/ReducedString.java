
package hackerrank;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Scanner;

// its wrong
public class ReducedString {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        System.out.println(superReducedString(str));
        
    }
    static String superReducedString(String str) {
        if(str.length()==0)  return "Empty String";
        LinkedList<Character>list = new LinkedList<>();
        
        for(int i=0 ; i<str.length() ; i++)
            list.add(str.charAt(i));

        int  count=0;
        while(true)
        {
            count=0;
            for(int i=0 ; i<=list.size()-2 ; )
            {
               if(list.isEmpty() ) break;
                if(Objects.equals(list.get(i), list.get(i+1))){
                    list.remove(list.get(i));
                    list.remove(list.get(i));
                    count++;
                }
                else
                    i++;
            }
            if(count==0)  break;
        }
         String x = list.toString().replace("[", "").replace("]","")
                .replace(",", "").replace(" ","");
        if(x.length()==0) return "Empty String";
        return x;
    }
}
