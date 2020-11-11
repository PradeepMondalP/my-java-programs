
package alldatastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class BFSUsingMultiDList {
    
    public static void main(String[] args) {
        
        List<Graph.Edge> edges = Arrays.asList
        (   
                new Graph.Edge(0,1),   new Graph.Edge(1,2),
                new Graph.Edge(2,0),   new Graph.Edge(2,1),
                new Graph.Edge(4,5),   new Graph.Edge(5,4)
        );
   
    
    Graph.printGraph(new Graph(edges));
    }
    
   
}

class Graph
{
     static class Edge
     {
         int src , dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
         
     }
     
     
    List<List<Integer>> adj = new ArrayList<>();

    public Graph(List<Edge> edge) {
    
        for (int i = 0; i < edge.size(); i++) {
            adj.add( i  , new ArrayList<>());
        }
  
        
        for(Edge  current : edge)
        {
            adj.get(current.src).add(current.dest);
        }
        
    }
    
    public static  void printGraph(Graph gr)
    {
        int src =0;
        int n = gr.adj.size();
        
        while(n>src)
        {
            for(int val : gr.adj.get(src))
            {
                System.out.print("(" + src +"  ->  "+ val +"  )");
            }
            System.out.println();
            src++;
        }
    }

  
}