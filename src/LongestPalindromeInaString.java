
import java.util.*;


// using DP

public class LongestPalindromeInaString {
    
    public static void main (String[] args)
	 {
             
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    
	    while(t-- >0)
	    {
	        String str = sc.next();
                if(str.length()==0){
                    System.out.println("");  continue;
                }
	       String res =  getString(str) ;
               if(res.length()==0) System.out.println(str.charAt(0));
               else System.out.println(res);
	    }
             
	 }
    
    static boolean  dp[][];
    static int maxLength=Integer.MIN_VALUE ,
            startPoint , endPoint;
    
    static String getString(String str)
    {
        int n = str.length();
        startPoint=0 ; endPoint=0; maxLength=Integer.MIN_VALUE;
        
        if(n==1) return str.charAt(0)+"";
        if(n==2){
            if(str.charAt(0)!=str.charAt(1)) return str.charAt(0)+"";
            return str;
        }
        
        dp = new boolean[n][n];
       
       for(int i=0 ; i<=n-2 ; i++)
       {
           dp[i][i] = true;
           if(str.charAt(i)==str.charAt(i+1))
           {
               dp[i] [i+1]=true;
               if(maxLength < 2)
               {
                   maxLength = 2;
                   startPoint = i;
                   endPoint = i+1;
               }
           }
       }
       dp[n-1][n-1]=true;
       
       int k=2;
       
       for(int i=0 ; i<n ; i++)
       {
           for(int s=0,end=s+k ; end<n ; s++, end=s+k)
           {
               if(str.charAt(s)==str.charAt(end) && dp[s+1][end-1] )
               {
                   dp[s][end]=true;
                       
                   if(end-s+1 > maxLength)
                   {
                       maxLength = end-s+1;
                       startPoint =s;
                       endPoint = end;
                   }
                   else if(end-s+1 == maxLength)
                   {
                      if(s < startPoint)
                       {
                           startPoint = s;
                           endPoint = end;
                       }
                   }
               }
           }
           k++;
       }
       
       
       return str.substring(startPoint , endPoint+1);
    }

}


/*
kjqlrzzfmlvyoshiktodnsjjp

*/