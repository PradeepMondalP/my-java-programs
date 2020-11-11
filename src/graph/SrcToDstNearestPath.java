
package graph;

import constant.WeightedGraph;
import java.util.ArrayList;

// src to dest nearest path neglecting the cost
public class SrcToDstNearestPath {
    
    static int NUM = Integer.MIN_VALUE;        //for lonest path keep minimum value and vice versa
    static ArrayList finalList = new ArrayList();
    
    public static void main(String[] args) {
         WeightedGraph graph = new WeightedGraph(4);
        
        graph.addUnidirectedEdge(0, 1, 5);
        graph.addUnidirectedEdge(0, 2, 6);
        graph.addUnidirectedEdge(0, 3, 2);
        graph.addUnidirectedEdge(1, 3, 50);
        graph.addUnidirectedEdge(2, 0, 20);
        graph.addUnidirectedEdge(2, 1, 70);
       
        graph.printGraph(graph);
        int src =0  , dst = 3;
        
        boolean vis[] = new boolean[graph.list.length];
        ArrayList tempList = new ArrayList();
        
        tempList.add(src);
        printUtils(vis , tempList , src , dst , graph);
        
        System.out.println("my nearest path = "+ finalList);
    }

    // find the nearest path from src to dest without considering the cost
    private static void printUtils(boolean[] vis, ArrayList tempList, int src, int dst ,WeightedGraph graph) {
        
        vis[src] = true;
        
        if(src==dst)
        {
             System.out.println(" "+ tempList +" length = "+ tempList.size());
             if(tempList.size() > NUM )      // for lonest path change <  -->   >  and vice versa
             {
                 finalList.clear();
                 finalList.addAll(tempList);
                 NUM = tempList.size();
                 vis[dst] = false;
                 return;
             }
        }
          
        for(  WeightedGraph.Node   node  : graph.list[src])
        {
             int newSource = node.dst;
             if(!vis[newSource])
             {
                  vis[newSource] = true;
                  tempList.add(newSource);
                  printUtils(vis, tempList ,newSource ,dst , graph );
                  int index = tempList.indexOf(newSource);
                  tempList.remove(index);
             }
        }
        vis[src] = false;
    }
}
