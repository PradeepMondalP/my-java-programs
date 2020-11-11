
import java.util.*;


public class FindingMedianInAnSortedRowsMatrix {
    
    public static void main(String[] args) {
        
        int r = 3, c = 3; 
        int m[][]= { {1,3,5}, {2,6,9}, {3,6,9} }; 
        
        System.out.println(solve(m, r, c));
    }
    
    static int solve(int arr[][] , int r , int c)
    {
        int max = Integer.MIN_VALUE; 
        int min = Integer.MAX_VALUE; 
          
        for(int i=0; i<r ; i++) 
        { 
            min = Math.min(min, arr[i][0]);
            max = Math.max(max, arr[i][c-1]);
        } 
        
        int desired = (r * c + 1) / 2; 
        while(min < max) 
        { 
            int mid = min + (max - min) / 2; 
            int count = 0 , get = 0; 
              
            // Find count of elements smaller than mid 
            for(int i = 0; i < r; ++i) 
            { 
                get = Arrays.binarySearch(arr[i],mid); 
                  
                if(get < 0) 
                    get = Math.abs(get) - 1; 
                else
                { 
                    while(get < arr[i].length && arr[i][get] == mid)  get += 1; 
                } 
                count += get; 
            } 
            if (count < desired)  min = mid + 1; 
            else  max = mid; 
        } 
        return min; 
    }
}
