
import java.util.Scanner;


public class FLOW013 {
    public static void main(String[] args) throws java.lang.Exception{
        
        Scanner sc = new Scanner (System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            int a=sc.nextInt() , b=sc.nextInt() , c = sc.nextInt() , sum=a+b+c;
            if(sum==180)System.out.println("YES");
            else System.out.println("NO");
            
        }
        
    }
}
