
package trees;


// simple Binary tree with traversing...
public class SimpleBT {
    
    static class Node
    {
        int data;
        Node left , right;

        public Node(int data) {
            this.data = data;
            left=right=null;
        }
    }
    
    static Node root;
    
    public static void main(String[] args) {
        
        root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(4);
        root.left.left = new Node(5);
        root.left.right = new Node(6);
        root.right.left = new Node(7);
        root.right.right = new Node(9);
        
        System.out.println("\n In Order");
        inOrder(root);
        System.out.println("\n preOrder");
        preOrder(root);
       
        System.out.println(" \nPost Order");
        postOrder(root);
    }
    
    public static void preOrder(Node root)
    {
        if(root==null)
            return;
        else
        {
             System.out.print(" " +root.data);
             preOrder(root.left);
             preOrder(root.right);
        }
    }
    
      public static void postOrder(Node root)
    {
        if(root==null)
            return;
        else
        {
             preOrder(root.left);
             preOrder(root.right);
             System.out.print(" " +root.data);
        }
    }
      
        public static void inOrder(Node root)
    {
        if(root==null)
            return;
        else
        {
             preOrder(root.left);
             System.out.print(" " +root.data);
             preOrder(root.right);
        }
    }
}
