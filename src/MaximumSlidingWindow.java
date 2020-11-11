import java.util.*;

public class MaximumSlidingWindow {
    
    public static void main(String[] args) {
        
        int arr[] = {1,2,3,1,4,5,2,3,6};
        int k=3 , n=arr.length;
        
        List<Integer>res = findKMaxElementUsingDeque(arr, k ,n );
        
        for(int x : res) System.out.print(x+" ");
    }

    // method 1  using AVL Tree
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
    
    // method 2 using Double ended queue
    static ArrayList<Integer> findKMaxElementUsingDeque(int[] arr, int k , int n)
    {
        ArrayList<Integer>res = new ArrayList<>();
        Deque<Integer>que = new LinkedList<>();
        que.addLast(0);
        int i=1;
        System.out.println("peekLast "+ arr[que.peekLast()]);
        
        for( ; i<k ; i++){
            while(que.size()>0 && arr[i]>=arr[que.peekLast()]) 
                que.removeLast();
            
            que.addLast(i);
        }
        
        res.add(arr[que.peekFirst()]);
        
        for( ; i<n ; i++)
        {
            int minReqInd = i-k;
            while(que.size()>0 && que.peekFirst()<= minReqInd)  que.removeFirst();
            
            while(que.size()>0 && arr[que.peekLast()]<=arr[i])  que.removeLast();
            
            que.add(i);
            
            res.add(arr[que.peekFirst()]);
        }
        
        return res;
    }
}
