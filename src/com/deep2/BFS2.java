
package com.deep2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS2 {
    public static void main(String[] args) {
        
        MyBFS obj = new MyBFS(7);
        
        obj.addNodes(0, 1);
        obj.addNodes(0, 2);
        obj.addNodes(0, 3);
        obj.addNodes(1, 2);
        obj.addNodes(1, 4);
        obj.addNodes(2, 3);
        obj.addNodes(2, 5);
        obj.addNodes(3, 6);
        
        obj.printAll(obj);
        System.out.println();
        System.out.println(",................BFS....................");
        obj.printBFS(obj, 0);
        System.out.println();
        System.out.println(",..................DFS....................");
        obj.printDFS(obj, 0);
        
    }
}


class MyBFS
{
      int V;
      LinkedList<Integer> adj[];

    public MyBFS(int V) {
        this.V = V;
        adj = new LinkedList[V];
        
        for(int i = 0 ; i<V ; i++)
            adj[i] = new LinkedList<Integer>();
    }
      
    public void addNodes(int u , int v)
    {
        adj[u].add(v);
        // createing bidirected graph
        adj[v].add(u);
    }
    
    public void printAll(MyBFS obj){
        int size = obj.adj.length;
        
        for(int i = 0 ;i<size ; i++)
        {
            Iterator<Integer>it = obj.adj[i].listIterator();
            while(it.hasNext())
            {
                System.out.print( i+" -> "+it.next() +"  ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void printBFS(MyBFS obj , int src)
    {
       int size = obj.adj.length;
       boolean []visited = new boolean[size];
       
       LinkedList<Integer>queue = new LinkedList();
       
       queue.add(src);
       visited[src ] = true;
       
       while(queue.size()!=0)
       {
           src = queue.poll();
           System.out.print(src +" -> ");
           
           Iterator<Integer>it = obj.adj[src].listIterator();
           while(it.hasNext())
           {
               int n = it.next();
                 if(!visited[n])
                     {
                         visited[n]=true;
                         queue.add(n);
                     }
           }
           
       }

    }
    
    
    
    public void printDFS(MyBFS obj , int src)
    {
       int size = obj.adj.length;
       boolean []visited = new boolean[size];
       
       LinkedList<Integer>stack = new LinkedList();
       
       stack.add(src);
       visited[src ] = true;
       
       while(stack.size()!=0)
       {
           src = stack.pollLast();
           System.out.print(src +" -> ");
           
           Iterator<Integer>it = obj.adj[src].listIterator();
           while(it.hasNext())
           {
               int n = it.next();
                 if(!visited[n])
                     {
                         visited[n]=true;
                         stack.addLast(n);
                     }
           }
           
       }

    }
}