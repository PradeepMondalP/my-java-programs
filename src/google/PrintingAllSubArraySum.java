
package google;

// not printing , its checkking whether  SUM is exists in subarray or nOt

public class PrintingAllSubArraySum {
    
    static int count=0;
    public static void main(String[] args) {
        
        int arr[] = {2,5,6,8};
        int LEN = arr.length;
        int sum =14;
        
        if(subset(arr, LEN, sum))
            System.out.println("exists  and count val = "+ count);
        else
            System.out.println("not exits and count val is  "+ count) ;
    }
    
    public static boolean subset (int arr[] , int n , int sum )
    {
       // System.out.println("sum is "+ sum);
        if(sum==0)  return true;
        
          if (n==0 && sum!=0) 
              return false ;
          
          if (arr[n-1] > sum )
              return subset(arr, n-1, sum);
          else
          {    
                count++;
                return   subset(arr, n-1, sum-arr[n-1]) || subset(arr, n-1, sum);
          }
    }
}
