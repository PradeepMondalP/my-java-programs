
package alldatastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

                                                // incomplete.................... didnt got output
public class DFS {
    public static void main(String[] args) {
        
        MyGraph graph = new MyGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(4, 5);
        
        graph.DFS(0);
    }
    
}

class  MyGraph{
    int v;
    LinkedList<Integer>[] adj;

    public MyGraph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        
        for(int i = 0; i<v;i++)
              adj[i] = new LinkedList<>();
        
    }
   
   public void addEdge(int u , int v)
   {
       adj[u].add(v);
       adj[v].add(u);
   }
   
   public void DFS(Integer ele){
      
       boolean []visited = new boolean[v];
       
       Stack<Integer> stk = new Stack<>();
       stk.push(ele);
       
       while(stk.isEmpty())
       {
           ele = stk.peek();
           stk.pop();
           
           if(!visited[ele]){
               System.out.println(ele);
               visited[ele] = false;
           }
           
           Iterator<Integer> it = adj[ele].listIterator();
           
           while(it.hasNext())
           {
                int x = it.next();
                if(!visited[x])
                      stk.push(x);
           }
       }
       
   }
   
      
}
