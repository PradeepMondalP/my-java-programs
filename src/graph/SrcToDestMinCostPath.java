
package graph;

import constant.WeightedGraph;
import java.util.ArrayList;
import java.util.LinkedList;

public class SrcToDestMinCostPath {
    
     //to store the minimum cost path;
    static ArrayList minCostList = new ArrayList();
    static int FINAL_MINCOST=0;     // to store minimum cost
    
     public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(4);
        
        graph.addUnidirectedEdge(0, 1, 5);
        graph.addUnidirectedEdge(0, 2, 6);
        graph.addUnidirectedEdge(0, 3, 2);
        graph.addUnidirectedEdge(1, 3, 50);
        graph.addUnidirectedEdge(2, 0, 20);
        graph.addUnidirectedEdge(2, 1, 70);
       
        graph.printGraph(graph);
    
        printMinPath(graph.list , 2 ,3 , 0);
        
         System.out.println("...............");
         System.out.println("min Cost = "+FINAL_MINCOST);
         System.out.println("min cost path = "+ minCostList);
    }
     
     
    private static void printMinPath(LinkedList<WeightedGraph.Node>[] list , int src , int dst , int MIN_COST) {
        
        boolean vis[]= new boolean[list.length];
        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(src);
        
        printPathUtils(vis , aList , src , dst , list, MIN_COST);
    }
    
    private static void printPathUtils(boolean []vis , ArrayList<Integer>aList ,int src , int dst ,
     LinkedList<WeightedGraph.Node>list[] , int MIN_COST)
    {
        vis[src] = true;
        if(src==dst)
        {
            System.out.println("list = "+ aList +"  cost = "+ MIN_COST);
            vis[src] = false;
            if(MIN_COST > FINAL_MINCOST)
            {
                FINAL_MINCOST = MIN_COST;
                minCostList.clear();
                minCostList.addAll(aList);
            }
            return;
        }
        
        for(WeightedGraph.Node node : list[src])
        {
             int dest = node.dst;
             int cost = node.wt;
             if(!vis[dest])
             {
                  int min = MIN_COST + cost;
                      
                  vis[dest] = true;
                  aList.add(dest);
                  printPathUtils(vis , aList , dest , dst , list ,min );
                  int index = aList.indexOf(dest);
                  aList.remove(index);
             }
        }
        
        vis[src] = false;   // if our src is not connected to any1 then making the vis[src]  =false;
    }
}
