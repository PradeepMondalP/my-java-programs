
package com.deep;

public class BellmanFord {
    
    public static void main(String[] args) {
        
        BellmanGraph g = new BellmanGraph(5, 8);
        
        g.edge[0].src=0;
        g.edge[0].dst=1;
        g.edge[0].wt=-1;
        
        g.edge[1].src=0;
        g.edge[1].dst=2;
        g.edge[1].wt=4;
        
         g.edge[2].src=1;
        g.edge[2].dst=2;
        g.edge[2].wt=3;
        
        g.edge[3].src=1;
        g.edge[3].dst=3;
        g.edge[3].wt=2;
        
        g.edge[4].src=1;
        g.edge[4].dst=4;
        g.edge[4].wt=2;
        
        g.edge[5].src=3;
        g.edge[5].dst=2;
        g.edge[5].wt=5;
        
        g.edge[6].src=3;
        g.edge[6].dst=1;
        g.edge[6].wt=1;
        
        g.edge[7].src=4;
        g.edge[7].dst=3;
        g.edge[7].wt=-3;
        
        g.bellmanFordAlgorithm(g, 0);
        
     
        
    }
    
}

class BellmanGraph
{
    int V , E;
    Edge []edge;

    
     class Edge
     {
         int src , dst ,wt;

        public Edge() {
            
            src = dst =wt =0;
        }
         
     }

    public BellmanGraph(int V , int E) {
     
     this.V = V; 
     this.E=E;
     
     edge = new Edge[E];
     
     for(int i=0; i<E ;i++)
     {
         edge[i] = new Edge();
     }
    }
    
    
    public void bellmanFordAlgorithm(BellmanGraph graph , int src)
    {
        int v = graph.V;
        int e = graph.E;
        int []cost = new int[V];
        
        for(int i=0 ; i<v; i++){
            cost[i]=Integer.MAX_VALUE;
        }
        cost[src]=0;
        
        
        for(int i=1 ; i<v ;i++)
        {
            for(int j=0 ;j<e ;j++)
            {
                int uu = graph.edge[j].src;
                int vv = graph.edge[j].dst;
                int wt = graph.edge[j].wt;
                
                if(cost[uu]!=Integer.MAX_VALUE && cost[uu] +wt < cost[vv])
                      cost[vv] = cost[uu]+wt;
            }
        }
        
        
        for(int j=0 ;j<e ;j++)
            {
                int uu = graph.edge[j].src;
                int vv = graph.edge[j].dst;
                int wt = graph.edge[j].wt;
                
                if(cost[uu]!=Integer.MAX_VALUE && cost[uu] +wt < cost[vv])
                {
                    System.out.println("Graph contain negative weight cycle");
                    return;
                }
            }
        
        printArr(cost , v , src);
        
    }
    
    public  void printArr(int[] cost, int V, int src) {
        System.out.println("distance from source...");
        
        for(int i=0; i<V ;i++)
        {
            System.out.print(i +"\t"+ cost[i]);
            System.out.println();
        }
        
    }
     
}
