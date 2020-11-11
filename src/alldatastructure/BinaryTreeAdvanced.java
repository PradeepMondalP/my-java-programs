
package alldatastructure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class BinaryTreeAdvanced {
    
    static class Node
    {
        int data, sum;
        ArrayList<Integer> list;
        Node left , right;

        public Node(int data, int sum, ArrayList<Integer> list) {
            this.data = data;
            this.sum = sum;
            this.list = list;
            left = right = null;
        }
       
    }
    static class MyClass
    {
        int sum;
        ArrayList<Integer> list;

        public MyClass(int sum, ArrayList<Integer> list) {
            this.sum = sum;
            this.list = list;
        }
        
        public MyClass()
        {
            
        }
        
    }
    
    static ArrayList<MyClass> classList = new ArrayList<>();
    Node root;
    static int SUM = 17;
    
    public Node createNodes(int arr[] , Node root , int sum , ArrayList list , int pos)
    {
        
        
        if(pos<arr.length && (sum+arr[pos]<=SUM))
        {
            ArrayList<Integer> tempList = list;
             int tempSum = sum;
             tempSum+=arr[pos];
               if(tempSum <=SUM){
                   tempList.add(arr[pos]);
                   classList.add(new MyClass(tempSum, tempList));
                   
                   Node temp = new Node(arr[pos], sum, list);
                    root = temp;
                   
                   root.left = createNodes(arr, root.left, tempSum, tempList, 2*pos+1);
                   root.right= createNodes(arr, root.right, tempSum, tempList, 2*pos+2);
               }
        }
        return root;
    }
    
    public void preOrder(Node s)
    {
         if(s==null)
             return;
        else
        {
         //   System.out.print(" data "+ s.data +"\n"  +"   sum is "+ s.sum +" \n ");
            preOrder(s.left);
            preOrder(s.right);
            System.out.println("................");
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int arr[] = {2,5,6,8};
         ArrayList<Integer> list = new ArrayList<>();
        
       BinaryTreeAdvanced tree = new BinaryTreeAdvanced();
       tree.root = tree.createNodes(arr, tree.root, 0, list, 0);
       
        Collections.sort(classList , (MyClass o1, MyClass o2) -> o2.sum - o1.sum);
        
         Iterator<MyClass> it = classList.iterator();
         while(it.hasNext())
         {
             MyClass obj = it.next();
             System.out.println("sum= "+obj.sum);
             System.out.println("list= "+ obj.list);
             System.out.println("..................");
         }

  //  tree.preOrder(tree.root);
    }
}
