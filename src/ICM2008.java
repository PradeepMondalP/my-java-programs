
import java.util.Scanner;


public class ICM2008 {
    public static void main(String[] args) throws java.lang.Exception{
        
        try
        {
            Scanner sc =new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- >0)
            {
                int start1 = sc.nextInt() , start2 = sc.nextInt() , 
                        dist1 = sc.nextInt() , dist2 = sc.nextInt();
                
                if(start1 < start2)
                {
                    if(solve(start1, start2, Math.max(dist1, dist2) , Math.min(dist1, dist2)))
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }
                else
                {
                    if(solve(start2, start1, Math.max(dist1, dist2) , Math.min(dist1, dist2)))
                        System.out.println("YES");
                    else
                        System.out.println("NO");
                }

//               if(solve2(start1, start2, dist1, dist2))
//                        System.out.println("YES");
//                    else
//                        System.out.println("NO");
                
            }
        }
        catch (Exception e) {
        }
    }

    private static boolean solve(int start1, int start2, int dist1, int dist2) {
        
        while(start1< start2)
        {
            start1+=dist1;
            start2+=dist2;
        }
        if(start1==start2) return true;
        return false;
    }
    
    static boolean solve2(int s1, int s2, int d1, int d2)
    {
        int diff1 = Math.max(s1, s2) - Math.min(s1, s2);
        int diff2 = Math.max(d1, d2) - Math.min(d1, d2);
        
        return diff1%diff2==0;
    }
}
