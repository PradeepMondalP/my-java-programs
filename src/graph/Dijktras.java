
package graph;

import java.util.*;


// finding shortest cost from src to all other destinatio..

public class Dijktras {
     
    public static void main(String[] args) {
        
        Graph obj = new Graph(6);
        obj.addNode(0, 2, 45);
        obj.addNode(0, 1, 50);
        obj.addNode(0, 3, 10);
        obj.addNode(1, 2, 10);
        obj.addNode(1, 4, 15);
        obj.addNode(2, 4, 30);
        obj.addNode(3, 0, 5);
        obj.addNode(3, 4, 15);
        obj.addNode(4, 1, 20);
        obj.addNode(4, 2, 35);
        obj.addNode(4, 3, 5);
        obj.addNode(5, 4, 3);
        
        obj.printGraph();
        obj.findShortestPath(0);
    }
}

class Graph
{
    int N;
    LinkedList<Node> list[];
    class Node
    {
        int src , dest , cost;

        public Node(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    Graph(int N)
    {
         list = new LinkedList[N];
         this.N = N;
         
          for(int i = 0 ;i<N ; i++)
            list[i] = new LinkedList();
    }
    
   public void addNode(int src ,int dst ,int cost)
   {
        Node obj = new Node(src , dst , cost);
        list[src].addLast(obj);
   }
   
   public void printGraph()    // bfs traverse
   {
       for(int i = 0 ; i<N ; i++)
       {
           LinkedList<Node>temp = list[i];
           Iterator<Node> it = temp.iterator();
           while(it.hasNext())
                {
                    Node n = it.next();
                    System.out.print(" " + i +" -> "+ n.dest +"  cost= "+ n.cost +"     ");
                }
            System.out.println();
       }
      
   }
   
   public void findShortestPath(int src)
   {
       int arr[] = new int[N];
       for(int i = 0 ; i<N ; i++)
           arr[i] = Integer.MAX_VALUE;
       
       arr[src] = 0;
       
       LinkedList<Node>temp = list[src];
       for(Node n : temp)
           arr[n.dest] = n.cost;         // value = cost    dest = index
            
       ArrayList<Integer> al = new ArrayList<>();
       al.add(src);
      
       
       while(al.size()!=N)
       {
            int pos = findMinPos(arr , al);  // getting min value pos from the array
            al.add(pos);
            
            LinkedList<Node> tempList = list[pos];
            
            for(Node e : tempList)        //src = pos
            { // using dijktras algorithm here
                if( ( arr[pos] + e.cost) < arr[e.dest]  )
                     arr[e.dest] = arr[pos] + e.cost;
            }
       }
             
       System.out.println("final conclusion  ");
       System.out.println(" ");
       for(int i = 0 ; i<N ; i++){
           System.out.println("cost from "+ src + " ->"+i + " ="+ arr[i]);
       }
   }
   
   public int findMinPos(int arr[], ArrayList<Integer> list)
   {
       
       int arrx[] = new int[arr.length];
       // copying the array valu to list for safety purpose
       // not changing anything wrt to the arr coz , it acts as pass by reference
       
       ArrayList<Integer> tempList = new ArrayList<>();
       for(int i = 0 ;i<arr.length ; i++)
       {
           tempList.add(arr[i]);
           arrx[i] = arr[i];
       }
      
       // making indexes -1 , which elements  are  presnt in list
       for(int i = 0 ; i<list.size() ; i++)
           arrx[list.get(i)]=-1;
       
       
       ArrayList<Integer> x = new ArrayList<>();
       for(int j = 0 ;j<arrx.length; j++)
           if(arrx[j]>=0)
               x.add(arrx[j]);
       
       // reversing to get the min value
       // may or may not work , if the list contains similar values
       Collections.sort(x);
        
       return tempList.indexOf(x.get(0));
   }
   
   public void print(int arr[])
   {
       System.out.println(" \n...............");
       for(int i =0; i<arr.length;i++)
         System.out.print(" "+ arr[i]);
   }
}
