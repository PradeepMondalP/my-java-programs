
import java.util.Scanner;


public class NumOfRotatinInSortedArr {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++) arr[i] = sc.nextInt();
        
        System.out.println(findKRotation(arr, n));
        
    }
    
    static int findKRotation(int arr[], int n) {
	    
	    int low = 0 , high = n-1;
	    while( low <= high)
	    {
	        int mid = low + (high - low)/2;
	        int nextEle = arr[ (mid+1)%n ];
	        int preEle = arr[ (mid+n-1) % n ];
                
                
	        if( arr[low]<=arr[(low+1)%n ] && arr[low]<=arr[ (low+n-1)%n ]) return low;
                
                if( arr[high]<=arr[ (high+1)%n ] && arr[high]<=arr[(high+n-1)%n]) return high;
                
	        if(arr[mid]<=nextEle && arr[mid]<=preEle)  return mid;
	        
	        if(arr[mid] >= arr[low]) low = mid+1;
	        else if( arr[mid] <= arr[high]) high = mid-1;
	    }
	    return 0;
	}
}
