import java.util.*;

public class MaximumSlidingWindow {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,1,4,5,2,3,6};
        int k=3 , n=arr.length;
        
        List<Integer>res = findKMaxElement(arr, k ,n );
        
        for(int x : res) System.out.print(x+" ");
    }

    static ArrayList<Integer> findKMaxElement(int[] arr, int k , int n) {
        
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer>res = new ArrayList<>();
        int  i=0 ;

        
        for( ; i<k ; i++) queue.add(arr[i]);
        
        // adding the maximum element among first k elements
        res.add(queue.peek());
        // removing the first element of the array
        queue.remove(arr[0]);
        
        // iterarting for the next elements
        for( ; i< n ; i++)
        {
            queue.add(arr[i]);
            res.add(queue.peek());
            queue.remove( arr[i-k+1]);
        }
        
        return res;
        
        // this code is Contributed by Pradeep Mondal P
        
    }
}
