
package com.deep;

import java.util.LinkedList;
import java.util.List;

public class WeightedGraph {
    
    static class Edge
    {
        int src, dst , wt;
        public Edge(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }
        
    };
    
    static class MyGraph
    {
       int V;
       LinkedList<Edge> adj[];

        public MyGraph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }
        
        public void addEdge(int src , int dst , int wt)
        {
            Edge e = new Edge(src, dst, wt);
            
            adj[src].add(e);
        }
        
        public void printGraph()
        {
            System.out.println("source \t desti\t cost");
            for(int i=0 ; i<V ;i++)
            {
                 List<Edge> myList = adj[i];
                 
                 for(int j =0 ; j< myList.size() ; j++ ){
                     
                     System.out.print(myList.get(j).src +"\t  "+ myList.get(j).dst +"\t  "+ myList.get(j).wt);
                     System.out.println();
                 }
                 System.out.println();
            }
        }
        
        
        
        // Not prining properly
        public void printSourceToDestAllVertex(int src , int dst)
        {
              LinkedList<Integer>pathList = new LinkedList();
              boolean isVisited[] = new boolean[V];
              pathList.add(src);
              printAllPathUtils(src , dst , isVisited , pathList);
        }

        private void printAllPathUtils(Integer src, Integer dst, boolean[] visited, LinkedList<Integer> pathList)
        {
            System.out.println("function called and the pathList :"+ pathList);
            System.out.println("no printing properly");
                   visited[src] = true;
                   
                   if(src.equals(dst))
                   {
                       System.out.println("src "+ src +" == "+ " dst "+ dst);
                       System.out.println(pathList);
                       visited[src] = false;
                       return;
                   }
                  
                   for(Edge obj : adj[src])
                   {
                         int newSource = obj.dst;
                         
                         if(!visited[newSource])
                         {
                             System.out.println("source = "+ obj.src  +" newSource---->" +  newSource);
                             
                             pathList.add(newSource);
                             
                             System.out.println("newSource :"+newSource +"  dest :"+dst);
                             
                             System.out.println("pathList "+ pathList);
                             printAllPathUtils(newSource, dst, visited, pathList);
                             
                             pathList.remove(newSource);
                         }
                   }
                   visited[src] = false; 
        }
       
    };
    
    public static void main(String[] args) {
       
        MyGraph g = new MyGraph(4);
//        g.addEdge(0, 1, 4);
//        
//        g.addEdge(0, 2, 3);
//        g.addEdge(1, 3, 2);
//        g.addEdge(1, 2, 5);
//        g.addEdge(2, 3, 7);
//        g.addEdge(3, 4, 2);
//        g.addEdge(4, 0, 4);
//        g.addEdge(4, 1, 4);
//        g.addEdge(4 ,5, 6);

         g.addEdge(0, 1, 3);
         g.addEdge(0, 2, 5);
         g.addEdge(0, 3, 7);
         g.addEdge(1, 3, 5);
         g.addEdge(2, 0, 4);
         g.addEdge(2, 1, 5);
        
    //    g.printGraph();
          g.printSourceToDestAllVertex(2, 3);
        
    }
    
}
