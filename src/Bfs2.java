
import java.util.Iterator;
import java.util.LinkedList;


public class Bfs2 {
   
    public static void main(String[] args) {
        
        MyGraph g = new MyGraph(16);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        
        g.addEdge(3, 6);
        g.addEdge(3, 7);
        
        g.addEdge(4, 10);
        g.addEdge(4, 9);
        
        g.addEdge(6, 15);
        g.addEdge(6, 12);
        
    
        g.bfs(1);
      
    //  g.printAllGraph(g);
        
    }
}

class MyGraph
{
    int v;
    LinkedList<Graph> list[] ;
    
    public static class Graph
    {
        int src , dst;

        public Graph(int src, int dst) {
            this.src = src;
            this.dst = dst;
        }
        
    }

    public MyGraph(int V) {
        this.v = V;
        list = new LinkedList[V];
        
        for (int i = 0; i < V ; i++) {
            list[i] = new LinkedList();
        }
    }
    
    public void addEdge(int  u  , int v)
    {
        list[u].addLast(new Graph(u, v));
        list[v].add(new Graph(v, u));
    }
    
    public void bfs( int src )
    {
        boolean []visited = new boolean[this.v];
        LinkedList<Integer> queue = new LinkedList();
 
        queue.add(src);
        visited[src] = true;
        
        
        while(queue.size()!=0)
        {
            src = queue.poll();
            System.out.print(" "+ src+ "-> ");
            
           Iterator <Graph> it = list[src].listIterator();
           while(it.hasNext())
           {
              Graph g =  it.next() ;
              int nextNode = g.dst;
               System.out.print(" " + nextNode +"->");

              if(!visited[nextNode])
                      {
                          visited[nextNode] = true;
                          queue.addLast(nextNode);
                      }
           }
            System.out.println();
            
        }
    }
    
    
    public void printAllGraph(MyGraph obj)
    {
        int v = obj.list.length;
        LinkedList<Graph> tempList ;
        
        for (int i = 1; i < v ; i++) {
           tempList = obj.list[i];
           
           for(int j= 0; j<tempList.size() ; j++)
           {              
               Graph g = tempList.get(j);
               System.out.print(g.src +"\t  -> "+g.dst);
               System.out.println();
           }
           tempList = null;
        
        }       
    }    
}
