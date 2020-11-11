
package trees;

import java.util.*;


// go to swappingNodes its working that
public class SwapNodes2 {
    
    static LinkedList<Node>stack = new LinkedList<>();
    static Node root;
    static List<Integer> list =
             Arrays.asList(1,2,3,4,5,6,7,8,-1,-1,-1,9,10);
    
    
    //1,2,3,4-1,5,-1,-1,3,-1,-1,-1,-1,-1,7
    static class Node
    {
        Node left , right;
        int level ,data ;
        
        Node( int data, int level) {
            this.level = level;
            this.data = data;  left=null; right=null;
        }
    }
    
    
    public static void main(String[] args) {
        
       root= buildTree(root, 0,  1);
       
        System.out.println("\n inorder");
        inOrder(root);
        
        System.out.println("\n Postorder");
        postOrder(root);
        
        
        
    }
    
    private static Node buildTree(Node root , int i  , int level)
    {
        if(i<list.size())
        {
            Node temp = new Node(list.get(i) , level);
            root = temp;
            
            root.left = buildTree(root.left, 2*i+1,  root.level+1  );
            
            root.right = buildTree(root.right, 2*i+2,  root.level+1 );
        }
        return root;
    }
    
    
     public static void levelOrderPrint(Node root)
    {
        if(root==null)   return;
        
        Queue<Node> que = new ArrayDeque<>();
        que.add(null);
        que.add(root);
        Node temp;
        
        while(!que.isEmpty())
        {
            temp =que.poll();
            if(temp==null) 
            {
                System.out.println("");
                continue;
            }
            if(temp.data==-1)  System.out.print("");
            else System.out.print(" "+ temp.data);
            
            if(temp.left!=null)
                  que.add(temp.left);
            if(temp.right!=null)
                  que.add(temp.right);
        }
    }
    
    public static void postOrder(Node root)
    {
        if(root==null)  return;
        postOrder(root.left);
        postOrder(root.right);
       // if(root.data==-1)  System.out.print("");
        System.out.print(" "+ root.data);
    }
    
    public static void inOrder(Node root)
    {
        if(root==null)  return;
        inOrder(root.left);
       // if(root.data==-1)  System.out.print("");
         System.out.print(" "+ root.data);
        inOrder(root.right);
        
    }
}
