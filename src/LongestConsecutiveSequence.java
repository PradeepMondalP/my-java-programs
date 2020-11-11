
import java.util.*;


public class LongestConsecutiveSequence {
    
    public static void main(String[] args) {
        
        int arr[] = {2147483647,-2147483648};
        System.out.println(longestConsecutive(arr));
    }
    
    static int longestConsecutive(int[] arr) 
    {
        int max=0 , count=0;
        Set<Long>set = new HashSet<>();
        for(int x : arr)  set.add((long)x);
        long prev , next;
        
        for(int x : arr)
        {
            prev=(long)x -1;
            if(set.contains(prev)) continue;
            count=1;
            next = (long)x+1;
            while(set.contains(next))
            {
                count++;   next++;
            }
            max = Math.max(max , count);
        }
        
        return max;
        
    }
}
