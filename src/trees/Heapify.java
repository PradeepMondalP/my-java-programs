
package trees;

import constant.Node2;
import java.util.*;


public class Heapify {
    
    static LinkedList<Integer>list = new LinkedList<>();
    static Node2 root;
    
    public static void main(String[] args) {
        
        Scanner obj = new Scanner(System.in);
         System.out.println("Enter the number of elements");
         int num = obj.nextInt();
         while(num>0)
         {
              list.add(obj.nextInt());
              num--;
         }
         
         System.out.println("be4 changes the list is "+ list);
         createHeapify(list);
         System.out.println("after changes the list is "+ list);
         
         System.out.println("\n tree created \n preOrder Traversal is..");
         root = createTree(list, root, 0);
         root.preOrderTraversal(root);
    }

    private static void createHeapify(LinkedList<Integer> list) {
        if(list.isEmpty())
             return;
        int n = list.size()-1  , leftChild , rightChild;
        
        for(int i = n ; i>=0;i--) 
        {
             if(2*i+1 >n) 
                  continue;
             if(2*i+2>n)
             {
                 leftChild = list.get(2*i+1);
                 if(leftChild < list.get(i))   //maxHeap(">")  minHeap("<")
                       swapIndex(leftChild , i);
             }
             else
             {
                 leftChild = list.get(2*i+1);  
                 rightChild = list.get(2*i+2);                            //  maxHeap(Math.max)     minHeap(Math.min)
                 int maxIndex = list.indexOf(Math.min(leftChild, rightChild)) ;  // maxIndex=5  , i=2
                 if(list.get(maxIndex)< list.get(i))                            // maxHeap(">")  minHeap("<")
                       swapIndex(i, maxIndex);
             }
        }
    }
                               //less index , big index        
    public static void swapIndex(int Findex ,int Lindex)
    {
                 int temp = list.get(Lindex);               // first remove then replace
                list.remove(list.get(Lindex));
                list.add(Lindex , list.get(Findex));

                list.remove(list.get(Findex));
                list.add(Findex , temp);
    }
    
    // i want to create a entire tree from the array elements
    public static Node2 createTree(LinkedList<Integer>list , Node2 root , int i)
    {
        if(i<list.size())
        {
            Node2 temp = new Node2(list.get(i));
            root = temp;
            root.left  = createTree(list, root.left, 2*i+1);
            root.right = createTree(list, root.right, 2*i+2);
        }
        return root;
    }
}
