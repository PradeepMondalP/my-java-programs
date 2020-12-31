
import java.util.Scanner;


public class TLG {
    public static void main(String[] args) throws java.lang.Exception{
        
        try
        {
            Scanner sc = new Scanner (System.in);
            int n = sc.nextInt();
           
            int AMax=0 , BMax=0 , AScore=0 , BScore=0 , ATotal=0 , BTotal=0 ;

            for(int i=0 ;i<n ; i++)
            {
               AScore = sc.nextInt(); BScore = sc.nextInt();
               ATotal+=AScore;        BTotal+=BScore;
               
               if(ATotal > BTotal)
               {
                   AMax = Math.max(AMax, ATotal-BTotal);
               }
               else
               {
                   BMax = Math.max(BMax, BTotal-ATotal);
               }
            }
            
            if(AMax > BMax)
                System.out.println("1 "+ AMax);
            else
                System.out.println("2 "+BMax);
        }
        catch (Exception e) {
        }
    }
}
