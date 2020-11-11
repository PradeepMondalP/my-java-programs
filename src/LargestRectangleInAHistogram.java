
import java.util.*;


public class LargestRectangleInAHistogram {
    
    public static void main(String[] args) {
        
        int arr[] ={1,1};
        int val = findLargestRectInHistogram(arr);
        
        System.out.println( val);
    }

    static int findLargestRectInHistogram(int[] arr) {
     
        List<Integer>nsr = NSR(arr);
        Collections.reverse(nsr);
        System.out.println("NSR "+ nsr);
        
        List<Integer>nsl = NSL(arr);
        System.out.println("NSL "+ nsl);
        
        int max=-9999;
        for(int i=0 ; i<arr.length ; i++)
        {
            int totalContinousBilding = nsr.get(i) - nsl.get(i) - 1;
            max = Math.max(max, arr[i] * totalContinousBilding);
        }
        
        
       return max;
    }

    static List<Integer> NSL(int[] arr) {
        
        Stack<MyNode> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i<arr.length ; i++)
        {
             if(stk.isEmpty()){
                 list.add(-1);  
              }
            else
             {
                 while(!stk.isEmpty() && stk.peek().value >= arr[i])  stk.pop();
                 
                 if(stk.isEmpty()){
                     list.add(-1); 
                 }
                 else
                     list.add( stk.peek().index );
             }
             stk.push(new MyNode( arr[i] , i));
        }
        
        return list;
    }
    
     static List<Integer> NSR(int[] arr) {
        
        Stack<MyNode> stk = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int n=arr.length;
        
        for(int i=n-1 ; i>=0 ; i--)
        {
             if(stk.isEmpty()){
                 list.add(n);  
              }
            else
             {
                 while(!stk.isEmpty() && stk.peek().value > arr[i])  stk.pop();
                 
                 if(stk.isEmpty()){
                     list.add(n); 
                 }
                 else
                     list.add( stk.peek().index );
             }
             stk.push(new MyNode( arr[i] , i));
        }
        
        return list;
    }
}

class MyNode
{
    int value , index;

    public MyNode(int value, int index) {
        this.value = value;
        this.index = index;
    }
    
}
