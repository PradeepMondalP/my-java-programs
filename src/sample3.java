
import java.util.Scanner;


public class sample3 {
    
    public static void main (String[] args)
	 {
	   Scanner sc = new Scanner(System.in);
	   int t=sc.nextInt();
	   while(t-- >0)
	   {
	       int n = sc.nextInt();
	       int arr[] = new int [n];
               for(int i=0 ; i<n ; i++) arr[i]=sc.nextInt();
	       System.out.println( majorityElement(arr) );
	       
	   }
	 }
	 
    static int majorityElement(int[] arr) 
    {
        
        int n=arr.length;
        if(n==0) return -1;
        
        int count=0 , num=-1;
        
        for(int i=0 ; i<n ; i++)
        {
            if(count==0)
            {
                count++;
                num=arr[i];
            }
           else if(arr[i]==num)  count++;
           
           else count--;
        }
        int temp=0;
        for(int i=0; i<n;i++)
            if(arr[i]==num) temp++;
        
        if(temp>n/2) return num;
        return -1;
    }
}
