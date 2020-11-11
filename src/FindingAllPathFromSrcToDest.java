
import java.util.ArrayList;
import java.util.List;

public class FindingAllPathFromSrcToDest {
    
    public static void main(String[] args) {
        
        Graph g = new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);
        
        System.out.println("following graph");
        g.printAllPath(2, 3);
        
    }
}

class Graph
{
    int v;
    ArrayList<Integer>[] AdjList;
    
    Graph(int V)
    {
        v = V;
        AdjList = new ArrayList[V];
        
        for(int i=0;i <v;i++)
        {
            AdjList[i]= new ArrayList<>();
        }
        
    }
    
    public void addEdge(int u , int v)
    {
        AdjList[u].add(v);
    }
    
    public void printAllPath(int src , int dst)
    {
        boolean[] visited = new boolean[v];
        ArrayList<Integer> pathList = new ArrayList<>();
        
        pathList.add(src);
        
        printAllPathUtils(src , dst , visited , pathList);
               
    }

    private void printAllPathUtils(Integer src, Integer dst, boolean[] visited, List<Integer> pathList) {
       
        visited[src] = true;
        
        if(src.equals(dst))
        {
            System.out.println(pathList );
            visited[src] = false;
            return;
        }
        
        for(Integer i : AdjList[src])
        {
             if(!visited[i])
             {
                 pathList.add(i);
                 printAllPathUtils(i, dst, visited, pathList);
                 pathList.remove(i);
             }
        }
        visited[src] = false;
    }
}
