
package dynamic;

import java.util.Scanner;


public class LongestSubstringWidoutRepeat {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = "abcd";
        
        System.out.println(" "+ longestSubstringWidoutRepeat(s));
        
        
    }
    public static int longestSubstringWidoutRepeat(String str)
    {
        boolean arr[];
        int n = str.length() , i=0 , count=0 , res = Integer.MIN_VALUE , index=0;
        
        while(i!=n)
        {
            count=0;
            arr= new boolean[26];
            int x=i;
            while(true)
            {
                if(x==n) break;
                System.out.println(str.charAt(x%n));
                index = (int)(str.charAt(x++ % n )) - 97 ;
                System.out.println("index "+ index);
                if(!arr[index])
                {
                    arr[index]=true;
                    count++;
                }
                else
                    break;
            }
            res =Math.max(res, count);
            i++;
        }
        return res;
        
    }
}
