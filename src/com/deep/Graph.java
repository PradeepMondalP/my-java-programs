
package com.deep;

import java.util.ArrayList;
import java.util.List;

public class Graph { 
    
    private int v;  
      
    private ArrayList<Integer>[] adjList;  
      
    //Constructor 
    public Graph(int vertices){ 
          
        
        this.v = vertices; 
          
        
        initAdjList();  
    } 
      
    private void initAdjList() 
    { 
        adjList = new ArrayList[v]; 
          
        for(int i = 0; i < v; i++) 
        { 
            adjList[i] = new ArrayList<>(); 
        } 
    } 
      
     
    public void addEdge(int u, int v) 
    { 
        adjList[u].add(v);  
    } 
       
    public void printAllPaths(int s, int d)  
    { 
        boolean[] isVisited = new boolean[v]; 
        ArrayList<Integer> pathList = new ArrayList<>(); 
          
        pathList.add(s); 
          
        printAllPathsUtil(s, d, isVisited, pathList); 
    } 
  
    private void printAllPathsUtil(Integer u, Integer d, 
                                    boolean[] isVisited, 
                            List<Integer> localPathList) { 
          
       
        isVisited[u] = true; 
          
        if (u.equals(d))  
        { 
            System.out.println(localPathList); 
          
            isVisited[u]= false; 
            return ; 
        } 
          
        for (Integer i : adjList[u])  
        { 
            if (!isVisited[i]) 
            { 
               
                localPathList.add(i); 
                printAllPathsUtil(i, d, isVisited, localPathList); 
                  
            
                localPathList.remove(i); 
            } 
        } 
          
        isVisited[u] = false; 
    } 
  
  
    public static void main(String[] args)  
    { 
        
        Graph g = new Graph(4); 
        g.addEdge(0,1); 
        g.addEdge(0,2); 
        g.addEdge(0,3); 
        g.addEdge(2,0); 
        g.addEdge(2,1); 
        g.addEdge(1,3); 
      
        // arbitrary source 
        int s = 2; 
      
        // arbitrary destination 
        int d = 3; 
      
        System.out.println("Following are all different paths from "+s+" to "+d); 
        g.printAllPaths(s, d); 
  
    } 
} 
  