
import java.util.*;


public class FindingMSBofaNumber {
    
     Queue<Integer> q1 = new LinkedList<Integer>();
     Queue<Integer> q2 = new LinkedList<Integer>();
     
     
     Stack<Integer>stk = new Stack<>();
    /*The method pop which return the element poped out of the stack*/
    int pop()
    {
        
        
	   if(q1.size()==0) return -1;
           return q1.poll();
    }
	
    /* The method push to push element into the stack */
    void push(int a)
    {
	    if(q1.size()==0){
	        q1.add(a);  return;
	    }
	    while(q1.size()!=0)
	    {
	        q2.add(q1.poll());
	    }
            
            q1.add(a);
            while(q2.isEmpty())  q1.add(q2.poll());
    }
    
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> list, int N) {
        
        ArrayList<Integer>res = new ArrayList<>();
        Queue<Integer>que =new ArrayDeque<>();
        Set<Integer>set = new HashSet<>();
        set.add(0);   que.add(0);   res.add(0);
        
        while(!que.isEmpty())
        {
            int index = que.poll();
            ArrayList<Integer> temp = list.get(index);
            if(temp.size()==0) continue;
            for(int next : temp)
                {
                   if(!set.contains(next)){
                        que.add(next);
                        res.add(next);
                        set.add(next);
                   }
                }
        }
        return res;
    }
}
