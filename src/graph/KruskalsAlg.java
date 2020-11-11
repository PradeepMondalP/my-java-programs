
package graph;

// finding the minimum spanning tree using kruskal algorithm

import constant.WeightedGraph;
import java.util.*;

public class KruskalsAlg {
    
    static int N;
    static LinkedList<WeightedGraph.Node>stack;
    static WeightedGraph minSpanGraph ;
    
    public static void main(String[] args) {
        
        WeightedGraph graph = new WeightedGraph(7);
        graph.addBidirectedEdge(0, 5, 10);
        graph.addBidirectedEdge(0, 1, 28);
        graph.addBidirectedEdge(1, 6, 14);
        graph.addBidirectedEdge(1, 2, 16);
        graph.addBidirectedEdge(2, 3, 12);
        graph.addBidirectedEdge(3, 6, 18);
        graph.addBidirectedEdge(3, 4, 22);
        graph.addBidirectedEdge(4, 6, 24);
        graph.addBidirectedEdge(4, 5, 25);

       N = graph.list.length;
        
        minSpanGraph = new WeightedGraph(N);
        
        addAllNodeToTheStack(graph);
        kruskalsAlg(graph);
        System.out.println("min span graph");
        minSpanGraph.printGraph(minSpanGraph);
    }

    private static void kruskalsAlg(WeightedGraph graph) {
        
        int srcX , destX , wtX;
        while(!stack.isEmpty())
        {
             stack.removeFirst();                                       // removing twice boz its a bidirected graph
             WeightedGraph.Node nod = stack.removeFirst();
              srcX = nod.src ; destX = nod.dst  ; wtX = nod.wt;
             minSpanGraph.addBidirectedEdge(srcX, destX, wtX);
             
             if( isContainLoop (minSpanGraph) )                   //  checking whether this edge(node) makes 
                  minSpanGraph.removeBirectEdge(srcX, destX);     //any loop with respect to the minSpantree or not
             
        }
    }

    private static void addAllNodeToTheStack(WeightedGraph graph) {
        stack = new LinkedList<>();
        
        for(LinkedList<WeightedGraph.Node>list : graph.list)
            for(int i = 0 ; i<list.size() ; i++)
                stack.add(list.get(i));   //WeightedGraph.Node node = list.get(i);
        
        // now we have to sort the stack based on the weigth (top = min     botton = max) wt
        Collections.sort(stack, Comparator.comparingInt(WeightedGraph.Node::getWt));
        
        System.out.println("stack is "+ stack);
    }

    
    // detection of cycle in Non Connected Graph.........
    private static boolean isContainLoop( WeightedGraph graph) { 
       int vis[] = new int[N];
       for(int i = 0 ; i<N ; i++)
           vis[i]=-1;
       
       LinkedList<WeightedGraph.Node> temp;
       Queue<Integer> que = new ArrayDeque<>();    // using bfs traversal
       
        for(int j = 0 ; j<N ; j++)
        { 
             if(vis[j]==-1)
             {
                  vis[j]=0;
                  que.add(j);

                    while(!que.isEmpty())
                    {
                        int val = que.poll();
                        vis[val]=1;
                        temp = graph.list[val];
                        for(int i = 0 ; i< temp.size() ; i++)
                        {
                            WeightedGraph.Node nod = temp.get(i);
                            int next = nod.dst;

                            if(vis[next]==0)
                                return true;
                            if(vis[next]==-1)
                            {
                                 vis[next]=0;
                                 que.add(next);
                            }
                        }
                    }
             }
        }
       
       return false;
    }
}

// output of prims....cross check it...
/*
0 -> 5 : 10	
1 -> 2 : 16	1 -> 6 : 14	
2 -> 3 : 12	2 -> 1 : 16	
3 -> 4 : 22	3 -> 2 : 12	
4 -> 5 : 25	4 -> 3 : 22	
5 -> 0 : 10	5 -> 4 : 25	
6 -> 1 : 14	
*/