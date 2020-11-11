
package constant;


// TRees With INtegers..
public class Node2 {
    
    public int data, level;
    public Node2 left , right;

    public Node2(int data) {
        this.data = data;
        left = right = null;
        this.level=0;
    }
       public  void preOrderTraversal(Node2 root)
    {
        if(root==null)
            return;
        System.out.print(" "+ root.data);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    
     public  void postOrderTraversal(Node2 root)
    {
        if(root==null)
            return;
        
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(" "+ root.data);
    }
     
      public  void inOrderTraversal(Node2 root)
    {
        if(root==null)
            return;
       
        inOrderTraversal(root.left);
        System.out.print(" "+ root.data);
        inOrderTraversal(root.right);
    }
}
