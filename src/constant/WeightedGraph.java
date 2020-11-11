
package constant;

import java.util.*;

public class WeightedGraph {
    
   public LinkedList<Node>list[];
   public int N;
   public class Node
    {

        @Override
        public String toString() {
            return "Node{" + "src=" + src + ", dst=" + dst + ", wt=" + wt + '}' +"\n";
        }
       public int src , dst ,wt;

        public Node(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }

        public int getWt() {
            return wt;
        }
        
    }

    public WeightedGraph(int n) {
        this.N = n;
         list = new LinkedList[N];
        for(int i = 0 ; i<N ; i++)
             list[i] = new LinkedList<>();
    }
    
    public void addUnidirectedEdge(int src ,int dst , int wt)
    {
        Node e = new Node(src , dst , wt);
        list[src].addLast(e);
    }
    
     public void addBidirectedEdge(int src ,int dst , int wt)
    {
        list[src].add(new Node(src , dst , wt));
        list[dst].add(new Node(dst , src , wt));
    }
     
     public void removeBirectEdge(int src ,int dst)
     {
          removeAnSingleEdge(src, dst);
          removeAnSingleEdge(dst, src);
     }
     
     public void removeAnSingleEdge(int src , int dst)
     {
         // src =5 , dst = 0
         LinkedList<Node> obj = list[src];
         for(int i = 0 ; i<obj.size() ; i++)
         {
              Node e = obj.get(i);
              if(e.dst == dst)
                  list[src].remove( list[src].get(i) );
         }
     }
     
    public void printGraph(WeightedGraph obj)    // using BFS
    {
        
        LinkedList<Node>temp;
        
         for(int i = 0 ; i<obj.list.length ; i++)
         {
             temp = obj.list[i];
             Iterator<Node> it = temp.iterator();
               while(it.hasNext())
               {
                   Node nod = it.next();
                   System.out.print( nod.src +" -> "+ nod.dst  + " : " + nod.wt+"\t");
               }
               System.out.println();
         }
    }
    
}
