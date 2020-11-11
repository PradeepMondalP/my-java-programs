
package graph;

// detection of cycle in a Connected graph

import constant.WeightlessGraph;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class DetectionOfCycle {
    
    static int vis[];
    static int N;
    
    public static void main(String[] args) {
        
        WeightlessGraph graph = new WeightlessGraph(6);
        graph.addBidirectedEdge(0, 1);
        graph.addBidirectedEdge(0, 2);
        graph.addBidirectedEdge(1, 3);
        graph.addBidirectedEdge(1, 4);
      //  graph.addBidirectedEdge(3, 4);
        graph.addBidirectedEdge(4, 5);
        graph.addBidirectedEdge(3, 5);
        
        graph.printGraph();
        N  = graph.N;
        
        System.out.println("cycle contain loop = "+ detectCycle(graph));
    }

    private static boolean detectCycle(WeightlessGraph graph) {
       vis = new int[N];
       for(int i = 0 ; i<N ; i++)
           vis[i] = -1;
       
       Queue<Integer> queue =new ArrayDeque<>();    // let me start with node 0
       vis[0]=0;
       queue.add(0);
       LinkedList<Integer>temp;
       
       while(!queue.isEmpty())
       {
          int val = queue.poll();     // poll will retreive and delete the first element of thr queue
          vis[val] = 1;
          temp= graph.list[val];
          for(int i = 0 ;i<temp.size() ; i++)
          {
               int nextNode = temp.get(i);
               if(vis[nextNode]==0)
                   return true;
               if(vis[nextNode]==-1)
               {
                    vis[nextNode]=0;
                    queue.add(nextNode);
               }
          }
       }
       return false;
    }
    
}
