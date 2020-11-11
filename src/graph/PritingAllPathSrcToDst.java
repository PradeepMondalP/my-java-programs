
package graph;
import constant.*;
import java.util.ArrayList;
import java.util.LinkedList;

// printing all path from src to dest in a weighted connected graph
public class PritingAllPathSrcToDst {
    
    public static void main(String[] args) {
       
        WeightedGraph graph = new WeightedGraph(4);
        
        graph.addUnidirectedEdge(0, 1, 5);
        graph.addUnidirectedEdge(0, 2, 6);
        graph.addUnidirectedEdge(0, 3, 2);
        graph.addUnidirectedEdge(1, 3, 50);
        graph.addUnidirectedEdge(2, 0, 20);
        graph.addUnidirectedEdge(2, 1, 70);
       
        graph.printGraph(graph);
    
        printAllPath(graph.list , 2,3);
    }

    private static void printAllPath(LinkedList<WeightedGraph.Node>[] list , int src , int dst) {
        
        boolean vis[]= new boolean[list.length];
        ArrayList<Integer> aList = new ArrayList<>();
        aList.add(src);
        
        printPathUtils(vis , aList , src , dst , list);
    }
    
    private static void printPathUtils(boolean []vis , ArrayList<Integer>aList ,int src , int dst ,
     LinkedList<WeightedGraph.Node>list[])
    {
        vis[src] = true;
        if(src==dst)
        {
            System.out.println("list = "+ aList);
            vis[src] = false;
            return;
        }
        
        for(WeightedGraph.Node node : list[src])
        {
             int dest = node.dst;
             if(!vis[dest])
             {
                  vis[dest] = true;
                  aList.add(dest);
                  printPathUtils(vis , aList , dest , dst , list);
                  int index = aList.indexOf(dest);
                  aList.remove(index);
             }
        }
        
        vis[src] = false;   // if our src is not connected to any1 then making the vis[src]  =false;
    }
}
