
import java.util.Scanner;


public class Vaccine {
    
     public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        int d1=sc.nextInt(),v1=sc.nextInt(),d2=sc.nextInt(),v2=sc.nextInt(),p=sc.nextInt();
	

	
	int sum=0, minDays , minDaysVal , maxDays , maxDaysVal , startPoint;
	
	startPoint = Math.min(d1, d2) - 1;
        startPoint = Math.max(1, startPoint);
	
	if(d1 <=d2)
	{
	    
	    minDays = d1;      maxDays = d2;
	    minDaysVal = v1 ;  maxDaysVal = v2;
	}
	else
	{
	     minDays = d2;      maxDays = d1;
	     minDaysVal = v2 ;  maxDaysVal = v1;
	}
	
	while(sum < p)
	{
	      if(startPoint < maxDays)  sum = sum + minDaysVal;
	      
	      else sum= sum+ minDaysVal + maxDaysVal;
	      
	      startPoint++;
	}
	
	        System.out.println(Math.max(startPoint-1, 1));
    }
}
