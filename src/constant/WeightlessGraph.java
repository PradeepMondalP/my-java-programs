
package constant;

import java.util.Iterator;
import java.util.LinkedList;

// weightless   integer Node graph 
public class WeightlessGraph {
    
    public LinkedList<Integer>list[];
    public int N;

    public WeightlessGraph(int n) {
        this.N = n;
        
        list = new LinkedList[N];
        for(int i = 0 ; i<N ; i++)
             list[i] = new LinkedList<>();
    }
    
    public void addUnidirectedEdge(int src ,int dst)
    {
        list[src].add(dst);
    }
    
     public void addBidirectedEdge(int src ,int dst)
    {
        list[src].add(dst);
        list[dst].add(src);
    }
     
    public void printGraph()    // using BFS
    {
         for(int i = 0 ; i<N ; i++)
         {
             LinkedList<Integer>temp = list[i];
             Iterator<Integer>it = temp.iterator();
             while(it.hasNext())
             {
                 System.out.print(i +" -> "+ it.next() +"\t");
             }
             System.out.println();
         }
    }
    
}
