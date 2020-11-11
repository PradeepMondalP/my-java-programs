package alldatastructure;

//using LL
import java.util.Iterator;
import java.util.LinkedList;

public class BFS {

    public static void main(String[] args) {
        Graph g = new Graph(20);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(1, 5);
        
        g.addEdge(2, 6);
        g.addEdge(2, 6);
        
        g.addEdge(3, 8);
        g.addEdge(3, 9);
        
        g.addEdge(4, 10);
        g.addEdge(4, 11);
        
          g.addEdge(5, 12);
        g.addEdge(5, 13);
        
        

        g.bfs(1);

    }

    static class Graph {

        private int V;
        private LinkedList<Integer> adj[];

        public Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];

            try{
            for (int i = 1; i <= this.V; i++) {
                adj[i] = new LinkedList();
            }
            }
            catch(Exception e)
            {
                System.out.println("error is =   "+ e.getMessage());
            }

        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        public void bfs(int src) {
            boolean visited[] = new boolean[V];
           
            LinkedList<Integer> queue = new LinkedList();
            visited[src] = true;
            queue.add(src);

            while (queue.size() != 0) {
              
                src = queue.poll();
                System.out.print(" " + src );
                
               Iterator<Integer> it = adj[src].listIterator();
               
               while (it.hasNext()) {
                    int n = it.next();
                    if (!visited[n]) {
                        visited[n] = true;
                        queue.add(n);
                    }
                }
            }
        }
    };

}
