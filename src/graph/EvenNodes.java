
package graph;
import java.util.*;


public class EvenNodes {
    
      static LinkedList<Integer>list[];
      static int  COUNT=0 ,N;
      static int childArr[];
     // static Set<Integer>visited = new TreeSet<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int tNodes = 20;
        int tEdges = 19;

        List<Integer> tFrom = Arrays.asList(2,3,4,5,6,7,8,9,10 ,11,12 ,13,14,15,16,17,18,19,20);
        List<Integer> tTo =   Arrays.asList(1,1,3,2,5,1,1,2,7,10,3,7,8,12,6,6,10,1,8);
        
        int val = evenForest(tNodes, tEdges, tFrom, tTo);
        System.out.println("val is "+ val);
        
        
    }
        
    static int evenForest(int t_nodes, int t_edges, List<Integer> from, List<Integer> to)  
    {
        N=t_nodes;
        list = new LinkedList[N+1];
        childArr = new int[N+1]; 
        for(int i = 0 ; i<list.length ; i++)        // initializing the list[]
            list[i] = new LinkedList<>();
        for(int i = 0 ; i< from.size() ; i++)
            list[to.get(i)].add(from.get(i));        // unidirected graph created.. 

         return findPossibbleDeleingEdges();
      }
    
    private static int findPossibbleDeleingEdges() {
        LinkedList<Integer>temp;
        for(int i =N ; i>=2;i--)
        {
            temp = list[i];
            if(temp.isEmpty())
                 childArr[i]=1;
            else
            {
                int my_count=1;
                for(int x : temp)
                    my_count+=childArr[x];
                
                childArr[i]=my_count;
                if(my_count%2==0)
                    COUNT++;
            }
        }
        return COUNT;
    }

//     static void checkChild_has_Odd_or_Even_nodes (int x)
//     {
//         Queue<Integer> que = new ArrayDeque<>();
//         que.add(x);
//         int val ;
//         LinkedList<Integer>temp;
//         
//          while(!que.isEmpty())
//          {
//              val = que.poll();
//              if(!visited.contains(val))
//               {
//                   countNodes++;
//                   visited.add(val);
//
//                   temp = list[val];
//                   if(!temp.isEmpty())
//                   {
//                       for(int nextVal : temp)
//                          if(!visited.contains(nextVal))
//                          {
//                              //System.out.println("sub childs-->"+ nextVal);
//                              que.add(nextVal);
//                          }
//                   }
//               }
//          }
//          //System.out.println("xxx "+ xxx);
//
//     }
//
//    
    static void printGraph()
    {
        for(int i = 0 ; i<list.length ; i++)
        {
            LinkedList temp = list[i];
            for(int j = 0 ; j<temp.size() ; j++)
            {
                System.out.println(i +" -> "+ temp.get(j)+" ");
            }
            System.out.println();
        }
    }

    
}
