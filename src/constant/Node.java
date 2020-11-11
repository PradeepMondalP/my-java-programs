
package constant;

// used for tree data structure..

public class Node {
   public char data;
   public Node left , right;

    public Node(char data) {
        this.data = data;
        left = right = null;
    }
    
    public void preOrderTraversal(Node root)
    {
        if(root==null)
            return;
        System.out.print(" "+ root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
     public void postOrderTraversal(Node root)
    {
        if(root==null)
            return;
        
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(" "+ root.data);
    }
     
      public void inOrderTraversal(Node root)
    {
        if(root==null)
            return;
       
        inOrderTraversal(root.left);
        System.out.print(" "+ root.data);
        inOrderTraversal(root.right);
    }
}
