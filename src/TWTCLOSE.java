
import java.util.Scanner;


public class TWTCLOSE {
    public static void main(String[] args) throws java.lang.Exception{
        
        try
        {
            Scanner sc = new Scanner (System.in);
            int n = sc.nextInt() , k = sc.nextInt();
            int arr[] = new int[n+1];
            int res=0;
            
            sc.nextLine();
            
            for(int i=1 ; i<=k ; i++)
            {
                String input = sc.nextLine();
                if(input.equals("CLOSEALL")){
                    arr = new int[n+1];
                    res=0;
                }
                else{
                    int index = Integer.parseInt(input.split(" ")[1]);
                    arr[index]^=1;
                    
                    if(arr[index]==1) res++;
                    else res--;
                }
                
                System.out.println(res);
            }
            
        }
        catch (Exception e) {
        }
    }
}
