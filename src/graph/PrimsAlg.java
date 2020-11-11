
package graph;

import constant.WeightedGraph;
import java.util.*;


// prims alg (greedy method)  to find minimum spanning tree of a graph
public class PrimsAlg {
    
    static int src , dst , wt =Integer.MAX_VALUE , N;
    static WeightedGraph minSpanGraph = new WeightedGraph(7);
    static ArrayList<Integer> tempList = new ArrayList<>();
    
    public static void main(String[] args) {
        
        WeightedGraph graph = new WeightedGraph(7);
        graph.addBidirectedEdge(0, 5, 10);
        graph.addBidirectedEdge(0, 1, 28);
        graph.addBidirectedEdge(1, 6, 14);
        graph.addBidirectedEdge(1, 2, 16);
        graph.addBidirectedEdge(2, 3, 12);
        graph.addBidirectedEdge(3, 6, 18);
        graph.addBidirectedEdge(3, 4, 22);
        graph.addBidirectedEdge(4, 6, 24);
        graph.addBidirectedEdge(4, 5, 25);
        
        N = graph.list.length;
      //  graph.printGraph(graph);
        
        prims(graph);
        minSpanGraph.printGraph(minSpanGraph);
        
    }

    private static void prims(WeightedGraph graph) {
        
        // finding the minWeight edge from the graph
        for(LinkedList<WeightedGraph.Node> list : graph.list)
           for(WeightedGraph.Node node : list)
             if(node.wt < wt)
                  {
                      wt = node.wt;
                      src = node.src;
                      dst = node.dst;
                  }
         System.out.println("First min edge = "+ src +" -> "+ dst +" = "+ wt); 
         minSpanGraph.addBidirectedEdge(src, dst, wt);
         tempList.add(src);
         tempList.add(dst);    // tempList starting stage
         
         createMinGraph(graph);
    }

    private static boolean isPresent(WeightedGraph.Node node, WeightedGraph minSpanGraph) {
        int srcX = node.src;
        int dstX = node.dst;
        
        LinkedList<WeightedGraph.Node>list=   minSpanGraph.list[srcX];
        for(WeightedGraph.Node nodeX : list)
           if(nodeX.dst==dstX)
                 return true;
        return false;
    }
    
    public static void createMinGraph(WeightedGraph graph)
    {
        while(tempList.size()!=N )
        {    
            wt = Integer.MAX_VALUE;   // so that it shouldnt comapare with prev stored lowest wt value
  
            LinkedList<WeightedGraph.Node> tempo ;
            for(int val : tempList)
                {
                     tempo = graph.list[val];
                     // checking individually , where the node is connected
                     // and can it be a span tree or not
                     for(int i = 0 ; i<tempo.size() ; i++)
                        {
                             WeightedGraph.Node node = tempo.get(i);
                             if(! isPresent(node , minSpanGraph))
                             {
                                  if(node.wt < wt)
                                  {
                                      src = node.src;
                                      dst = node.dst;
                                      wt=node.wt;
                                  }
                              }
                        }
                  }
                         tempList.add(dst);
                         minSpanGraph.addBidirectedEdge(src, dst, wt);
                         System.out.println("tempList = --->"+ tempList);
                     
        }
    }
}
