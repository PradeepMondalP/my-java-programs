
import java.util.Iterator;
import java.util.LinkedList;


// Node are with Charecter
// weighted grapg

public class CharecterRelatedGraph {
    
    static class MyClass
    {
        char source , dst;
        int cost;

        public MyClass(char source, char dst, int cost) {
            this.source = source;
            this.dst = dst;
            this.cost = cost;
        }
    }
    
    
   static class GGraph
    {
        
    LinkedList<MyClass> list[];
    int V;

        public GGraph(int V) {
            this.V = V;
            list = new LinkedList[V];
            
            for(int i = 0 ; i<V ; i++)
                 list[i] = new LinkedList();
        }
    
        public void addEdge(char src , char dst , int cost)
        {
            int index = (int)src - 65;
            MyClass obj = new MyClass(src , dst , cost);
            list[index].addLast(obj);
        }
        
        public void printGraph(GGraph obj)
        {
            LinkedList<MyClass> temp;
            
            for(int i = 0 ; i<obj.V ; i++)
            {
                temp = obj.list[i];
                Iterator<MyClass> it = temp.iterator();
                while(it.hasNext())
                {
                    MyClass ob =(MyClass)it.next();
                    System.out.print("src "+ ob.source +"\t "+ "dst = "+ ob.dst +"\t" +"cost = "+ ob.cost+"\n");
                    
                }
                System.out.println("..............");
            }
        }
    
    }
    
    
    public static void main(String[] args) {
        GGraph obj = new GGraph(4);
        obj.addEdge('A', 'B', 3);
        obj.addEdge('B', 'A', 7);
        obj.addEdge('A', 'C', 5);
        obj.addEdge('A', 'D', 7);
        obj.addEdge('B', 'D', 10);
        obj.addEdge('C', 'D', 9);
        obj.addEdge('D', 'C', 15);
        
        obj.printGraph(obj);
    }
}
