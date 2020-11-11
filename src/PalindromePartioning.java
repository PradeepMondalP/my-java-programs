
import java.util.*;


public class PalindromePartioning {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solve(str));
    }

    static int dp[][];
    
    static List<List<String>> solve(String str) {
        List<List<String>>res = new ArrayList<>();
        int n = str.length();
        dp =new int[n+1][n+1];
        
        for(int arr[] : dp)
            Arrays.fill(arr, -1);
        
        findAllPalindromePartioning(str , res , new ArrayList<String>() ,0 , n-1);
        
        return res;
    }

     static void findAllPalindromePartioning(String str, List<List<String>> res, 
             ArrayList<String> list, int start , int end) {
         
         
        
         if(start==str.length()){
             res.add(new ArrayList<>(list));
             return;
         }
 
         for(int k=start  ; k<=end ; k++)
         {
             if( dp[start][k]==0 ) continue;
             else if(dp[start][k]==1)
             {
                 list.add(str.substring(start , k+1));
                 findAllPalindromePartioning(str , res , list , k+1 , end);
                 list.remove(list.size()-1);
             }
             else
             {
                 if( isPalindrome(str , start , k) )
                 {
                     dp[start][k]=1;
                     list.add(str.substring(start , k+1));
                     findAllPalindromePartioning(str , res , list , k+1 , end);
                     list.remove(list.size()-1);
                 }
                 else dp[start][k]=0;
             }
         }
    }

    static boolean isPalindrome(String str, int start, int end) {
         while(start<=end)
         {
             if(str.charAt(start)!=str.charAt(end)) return false;
             start++;   end--;
         }
         return true;
    }
}
