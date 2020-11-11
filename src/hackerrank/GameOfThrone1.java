
package hackerrank;

import java.util.Scanner;

public class GameOfThrone1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        System.out.println("\n"+checkPalindrome(str));
    }

    private static String checkPalindrome(String str) {
        
        int len = str.length();
      if(len==0 || len==1)  return "YES";
      boolean arr[]= new boolean[26];
      int count=0;
      char letters[] = str.toCharArray();

      for(int i=0 ; i<len ;i++)
      {
          int index =  ( (int)letters[i]-97);
          if(!arr[index])
              arr[index]=true;
          else
              arr[index]=false;
      }  
       //System.out.println(".........my array.........");
        for(boolean x : arr)
        {
            if(x)  count++;
        }

        if(count>1) return "NO";
       return "YES"; 
  
    }
}
