
import java.util.*;


public class Word_Break {
    
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            int N=sc.nextInt();
            Set<String>set = new HashSet<>();
            for(int i=0; i<N ; i++) set.add(sc.next());
            sc.nextLine();
            
            String str=sc.nextLine();
            
            if(dfs(str , set ) ) System.out.println("1");
            else System.out.println("0");
        }
     }

    static boolean dfs(String str, Set<String> set ) {
    
         boolean dp[] = new boolean[str.length()+1];
         
         dp[0]=true;
         for(int len=1 ;len<=str.length() ; len++)
         {
             for(int i=0 ; i<len ; i++)
             {
                 if(dp[i] && set.contains(str.substring(i , len)))
                 {
                     dp[len]=true;  break;
                 }
             }
         }
         return dp[str.length()];
    }

    
}
