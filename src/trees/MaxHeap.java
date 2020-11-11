
package trees;

import constant.Node2;
import java.util.*;


public class MaxHeap {
    
    static LinkedList<Integer>list = new LinkedList<>();
    static Node2 root;
    static Stack<Integer>stk = new Stack<>();
    
    public static void main(String[] args)
    {
         Scanner obj = new Scanner(System.in);
         System.out.println("Enter the number of elements");
         int num = obj.nextInt();
         list.add(Integer.MAX_VALUE);
         while(num>0)
         {
              insert(obj.nextInt());
              num--;
         }
         list.remove(list.get(0));
         
         System.out.println("final list "+ list);
         root= createTree(list , root , 0);
         
         System.out.println("inOrder traversal...");
         root.inOrderTraversal(root);
         
         System.out.println(" \n Top root = "+ list.get(0));
         
         System.out.println("  lets delete Main Root...");
         deleteNodeFrom_heap(root);
         
         System.out.println("\n after deletion main Root is .."+ list.get(0));
         root=null;
         root = createTree(list , root , 0);
         
         System.out.println("new Tree created with "+ list);
         
         System.out.println("inOrder traversal...");
         root.inOrderTraversal(root);
                 
                 
    }
    
    // doing changes in the array.... as per the concept
    public static void insert(int val)
    {
        list.add(val);
        int n = list.size()-1;
        int i = n , parent;
        while(i>1)
        {
            parent = i/2;
            if(list.get(i) < list.get(parent)) // max heap (for min heap change ">" to "<"  sysmbol   
               swapIndex(parent, i);
            else
                return;
            i=parent;
        }
    }

    // creating the tree..
    private static Node2 createTree(List<Integer> list , Node2 root , int i) {
        
        if(i<list.size())
        {
            Node2 temp = new Node2(list.get(i));
            root = temp;
            root.left  = createTree(list, root.left, 2*i+1);
            root.right = createTree(list, root.right, 2*i+2);
        }
        return root;
    }
    
    
    // deleting a node from a Max Heap
    public static void deleteNodeFrom_heap(Node2 root)
    {
        if(root==null)
        {
            System.out.println("root is Empty");
            return;
        }
        
        stk.push(list.poll());
        list.add(0 , list.removeLast());
        
        System.out.println("\n before starting deletion process thr list is "+ list);
        int i=0 , n = list.size()-1  , leftChildIndex=0 , rightChildIndex=0;
        
        while(i<n)
        {
              if(2*i+1 >n)
                  break;
              if(2*i+2 >n)
              {
                   leftChildIndex=2*i+1;
                   if(list.get(i) > list.get(leftChildIndex))   // max heap deletion    (min heap = >)  maxHeap("<")
                   {
                       swapIndex(i, leftChildIndex);     i = leftChildIndex;
                   }
                   else
                       break;
              }
              else
              {
                  leftChildIndex = 2*i+1;       rightChildIndex = 2*i+2;
                  int maxValIndex = findMaxValIndex(leftChildIndex, rightChildIndex);
                  if(list.get(i) > list.get(maxValIndex))    // max heap deletion   (min heap = >) (max Heap ="<")
                  {
                      swapIndex(i, maxValIndex);     i = maxValIndex;
                  }
                  else
                      break;
              }
        }
    }
    
    
    // finding the index which has max value          // for minHeap Math.min
    public static int findMaxValIndex(int i , int j) // for max heap
    {
        return list.indexOf(Math.min(list.get(i), list.get(j)));
    }
    
    
    // swapping of indexes of the linkedList
    public static void swapIndex(int Findex ,int Lindex)
    {
                 int temp = list.get(Lindex);               // first remove then replace
                list.remove(list.get(Lindex));
                list.add(Lindex , list.get(Findex));

                list.remove(list.get(Findex));
                list.add(Findex , temp);
    }
}
