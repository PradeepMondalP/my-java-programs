
package com.deep;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;


public class FindingCycleInGraph {
    
    public static void main(String[] args) {
        
        CycleGraph cg = new CycleGraph(6);
        cg.addEdge(1, 2);
        cg.addEdge(2, 4);
        cg.addEdge(2, 5);
        cg.addEdge(3, 2);
        cg.addEdge(4, 3);
        cg.addEdge(5, 1);
        cg.addEdge(5, 4);
       
        boolean visted[] = new boolean[5];
        Stack stk = new Stack();
        LinkedList list ;
        
        for(Integer i = 1 ; i< cg.adj.length ;i++)
        {
            stk.push(i);
            list= new LinkedList();
            list.add(cg.adj[i]);
            
            cg.searchLoops(list, visted, i, stk);
        }
    }
    
}

class CycleGraph
{
    int V ;
    LinkedList<Integer> []adj;

    public CycleGraph(int V ) {
     
     this.V = V; 
     adj = new LinkedList[V];
     
     for (int i =0 ;i<V ;i++)
     {
         adj[i]= new LinkedList<>();
     }
    }
    
    public void addEdge(int src , int dst)
    {
        adj[src].addLast(dst);
    }
    
    public void printAllGraph()
    {
         LinkedList list ;
         
         for(int i=1 ;i<V ;i++)
         {
             list = new LinkedList();
             list.add(adj[i]);
             
             for(int j = 0 ; j<list.size() ;j++)
             {
                 System.out.print(i +"-> " + list.get(j));
             }
             System.out.println();
             
         }
    }
    
    public void searchLoops(LinkedList list , boolean []visited , Integer dst , Stack stk)
    {
        if(list.size()==0  && dst.equals(stk.lastElement()))
        {
            System.out.println(stk);
            return;
        }
        
        if( list.size()==0  && (!dst.equals(stk.lastElement())))
        {
            stk.pop();
            return;
        }
        
        for(int j =0 ; j<list.size() ; j++)
        {
            Iterator<Integer> it =list.iterator();
            
            while(it.hasNext())
            {
                try{
                  Integer z = (int)it.next();
                  if(!visited[z])
                  {
                      visited[z] = true;
                      stk.push(z);
                      
                      LinkedList tempList = new LinkedList();
                      tempList.add(adj[z]);
                      
                      searchLoops(tempList, visited, dst, stk);
                      stk.pop();
                             
                  }
                  
                  return;
                }catch(Exception e)
                {
                     System.out.println("error = "+ e.getMessage());
                     
                }
                  
            }
            
        }
    }

}

