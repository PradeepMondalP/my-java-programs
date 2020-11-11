
import java.util.LinkedList;


public class CreatingSimpleWeightG {
    
    public static void main(String[] args) {
        
        MyGrap obj  = new  MyGrap(10);
        obj.addEdges(1, 2, 5);
        obj.addEdges(1, 3, 10);
        obj.addEdges(1, 4, 6);
        obj.addEdges(2, 3, 7);
        obj.addEdges(3, 4, 8);
        
        obj.printEdges(obj);
    }
}


class MyGrap
{
    int V;
    LinkedList<MyVertices> adj[];
    
    static class MyVertices
    {
        int src ,  dst , wt;

        public MyVertices(int src, int dst, int wt) {
            this.src = src;
            this.dst = dst;
            this.wt = wt;
        }    
    }

    public MyGrap(int V) {
        this.V = V;
        adj = new LinkedList[V] ;
        
        for (int i = 0; i <V; i++) {
            adj[i] = new LinkedList();
        }
    }
    
    public void addEdges(int u , int v , int w)
    {
        
        adj[u].add(new MyVertices(u, v, w));
       
    }
    
    public void printEdges(MyGrap obj)
    {
        int linkLength = obj.adj.length;
        LinkedList <MyVertices> temp;
        
        for (int i = 1; i <= linkLength; i++) {
             temp = obj.adj[i] ;
            
            for(int j  = 0  ; j<temp.size() ; j++)
            {
                MyVertices tempOj =  temp.get(j);
                System.out.print("src = " + tempOj.src +"\t dest = "+ tempOj.dst  + "\t" + "weight = "+tempOj.wt);
                System.out.println();
                
            }
            temp = null ;
            
        }
    }
    
    
}
