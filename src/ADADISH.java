
import java.util.*;


public class ADADISH {
    	public static void main (String[] args) throws java.lang.Exception
	{
            try {


              Scanner sc = new Scanner (System.in);
              int t = sc.nextInt();
              while(t-->0)
              {
                        int n = sc.nextInt();
                        int arr[] = new int[n];
                    
                        for(int i=0 ;i<n ; i++) arr[i] =sc.nextInt();
                        
                        if(n==0){
                              System.out.println(0);  continue;
                        }
                        if(n==1){
                              System.out.println(arr[0]);  continue;
                        }
                  
                  
                  
                      Arrays.sort(arr);
                      int sum=0 ,temp = arr[n-1] , j= n-2 , minV;
            
                      while(j >=0 )
                      {
                          if(temp==0 ) {
                              temp = arr[j];
                              j--;
                              continue;
                          }
                          minV = Math.min(temp , arr[j]);
                          
                          sum = sum + minV;
                  
                          temp = temp - minV;
                          arr[j] = arr[j] - minV;
                  
                          temp = Math.max(temp , arr[j]);
                          j--;
                      }
            
                   System.out.println(sum+temp);
                  
              }    
	      
		      
	    } catch(Exception e) { }
	}
}
