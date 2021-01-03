
import java.util.Scanner;


public class DECODEIT {
    public static void main(String[] args) throws java.lang.Exception{
        
        try
        {
            Scanner sc =new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- >0)
            {
                int n = sc.nextInt();
                char arr[] = sc.next().toCharArray();
                int i=0;
                StringBuffer res = new StringBuffer();
                while(i<n)
                {
                    String temp=arr[i]+""+arr[i+1]+""+arr[i+2]+""+arr[i+3];
                    res.append(solve(temp));
                    i+=4;
                }
                
                System.out.println(res);
            }
        }
        catch (Exception e) {
        }
    }
    
    static char dp[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p'};
    
    static char solve(String str)
    {
        int val = Integer.parseInt(str, 2);
        return dp[val];
    }
}
