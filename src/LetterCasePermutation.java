
import java.util.*;


public class LetterCasePermutation {

    static List<String> list = new ArrayList<>();
    
    public static void main(String[] args) {
        
        String str = "abcd";
       
        
        solve(str , "");
        System.out.println(list);
    }
    
    public static void solve(String ip , String op)
    {
        if(ip.length()==0){
            list.add(op);
            return;
        }
        char x = ip.charAt(0);
        if(Character.isAlphabetic(x))
        {
            solve(ip.substring(1), op+Character.toLowerCase(ip.charAt(0)));
            solve(ip.substring(1), op+Character.toUpperCase(ip.charAt(0)));
        }
        else
        {
            solve(ip.substring(1), op+ip.charAt(0));
        }
    }
    
}
