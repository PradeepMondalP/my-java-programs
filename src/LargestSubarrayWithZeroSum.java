
import java.util.*;


public class LargestSubarrayWithZeroSum {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0 ; i<n ; i++) arr[i]=sc.nextInt();
        
        System.out.println(maxLen(arr, n));
        
    }
    
    
    static int maxLen(int arr[], int n)
    {
        int max=0 ,preSum=0;
        Map<Integer , Integer>map  = new HashMap<>();
        map.put(0, 0);
        
        for(int i=1 ; i<=n ; i++)
        {
            preSum+=arr[i-1];
            if(map.containsKey(preSum) )  
            {
            max = Math.max(max , i-map.get(preSum)  );
            continue;
            }
            else  map.put(preSum , i);     
        }
        
        return max;
    }
}
/*
10
2 1 -3 1 -8 7 6 5 -2 -9

4
1 -1 1 -1

5 
9 1 -1 1 -1
*/
