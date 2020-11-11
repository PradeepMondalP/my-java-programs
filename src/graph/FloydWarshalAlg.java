
package graph;

// shortest path from every vertes to every vertex

import constant.WeightedGraph;
import java.util.LinkedList;


public class FloydWarshalAlg {
    
    static int arr[][];
    static int N;
    public static void main(String[] args) {
        
        WeightedGraph graph = new WeightedGraph(4);
        graph.addUnidirectedEdge(0, 1, 3);
        graph.addUnidirectedEdge(0, 3, 7);
        graph.addUnidirectedEdge(1, 0, 8);
        graph.addUnidirectedEdge(1, 2, 2);
        graph.addUnidirectedEdge(2, 0, 5);
        graph.addUnidirectedEdge(2, 3, 1);
        graph.addUnidirectedEdge(3, 0, 2);
        
        graph.printGraph(graph);
        
        flowdWarshallAlgorith(graph);
        
    }

    private static void flowdWarshallAlgorith(WeightedGraph graph) {
         N = graph.N;
        arr = new int[N][N];
        LinkedList<WeightedGraph.Node> temp;
        
        for(int i = 0; i<N ; i++)
        {
            for(int j =0 ; j <N ; j++)
             {
                if(i==j)
                    arr[i][j]=0;
                else
                arr[i][j] =888;
             }

             temp = graph.list[i];
             for(int j = 0 ; j<temp.size() ; j++)
                {
                    WeightedGraph.Node node = temp.get(j);
                    arr[i][node.dst]= node.wt;
                }
        }
        System.out.println("after creating the array is ");  //array A(0)  created successfully
        print(arr);
        
        matrixTransformation(arr);

    }
    
    private static void print(int arr[][])
    {
        System.out.println("\n..............");
        for(int i = 0 ; i<arr.length ; i++)
        {
            for(int j = 0 ; j<arr.length ; j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.println("..............\n");        
    }

    private static void matrixTransformation(int[][] arr) {
      
        for(int k = 0 ;k<N ; k++)
        {
            for(int i = 0; i<N ; i++)
                for(int j = 0 ;j<N ; j++)
                    arr[i][j] = min( arr[i][j] , arr[i][k]+arr[k][j]);
           
            print(arr);
        }
       
    }

    private static int min(int x, int y) {
        if(x==y) return x;
        if(x<y)return x;
        
        return y;
    }
}
