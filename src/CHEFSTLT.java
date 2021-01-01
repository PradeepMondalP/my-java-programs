
import java.util.Scanner;

public class CHEFSTLT {
     public static void main(String[] args) throws java.lang.Exception{
        
        try
        {
            Scanner sc =new Scanner(System.in);
            int t = sc.nextInt();
            while(t-- >0)
            {
                char arr1[] = sc.next().toCharArray() , arr2[] = sc.next().toCharArray();
                int minCount=0 , maxCount=0;
                
                // find min
                for(int i=0 ; i<arr1.length ; i++)
                {
                    if(arr1[i]=='?' || arr2[i]=='?')  maxCount++;
                    else
                    {
                        if(arr1[i] != arr2[i]) minCount++;
                    }
                }
                
                maxCount+=minCount;
                
                System.out.println(minCount+" "+ maxCount);
            }
        }
        catch (Exception e) {
        }
    }
}
